package in.iitd.mldev.core.model;

import in.iitd.mldev.core.parse.SmlParser;
import in.iitd.mldev.core.parse.ast.ASTRoot;
import in.iitd.mldev.core.scan.SmlLexer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import java_cup.runtime.Symbol;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

/**
 * Maintains the high-level representation of an SML program,
 * including the parse tree and the identifiers defined in the program.
 * <p>
 * An SmlProgram works on one document being edited in the workspace.
 * It has to be updated by the SmlEditor whenever the document is changed.
 */
public class SmlProgram {
	
	/** The document containing the program source. */
	private final IDocument document;
	/** The list of listeners registered to be notified of updates. */
	private final List<ISmlProgramListener> listeners =
			new CopyOnWriteArrayList<ISmlProgramListener>();
	
	/** Every SmlProgram keeps its own lexer and parser. */
	private SmlLexer lexer;
	/** Every SmlProgram keeps its own lexer and parser. */
	private SmlParser parser;
	
	/** The parse tree. */
	private ASTRoot parseTree;
	/** The list of bindings. */
	private List<SmlBinding> bindings;
	/** The list of problems. */
	private List<IRegion> problems;

	/** Creates a SmlProgram attached to the given document.
	 * The SmlProgram does not update itself when the document changes. */
	public SmlProgram (IDocument document) {
		this.document = document;
	}
	
	/** Returns the parse tree of the program. */
	public ASTRoot getParseTree () {
		if (parseTree == null)
			update();
		return parseTree;
	}
	
	/** Returns the list of identifiers bound by the program.
	 * See SmlBinding for details. */
	public SmlBinding[] getBindings () {
		if (bindings == null)
			update();
		return bindings.toArray(new SmlBinding[0]);
	}
	
	/** Returns the regions where problems were found in the program.
	 * In this version, only syntax errors are found. */
	public IRegion[] getProblems () {
		if (problems == null)
			update();
		return problems.toArray(new IRegion[0]);
	}
	
	/** Updates the representation of the program. This method should
	 * be called by the editor when the document is changed. */
	public void update () {
		parse();
		bindings = SmlBinding.getBindings(parseTree);
		fireModelChanged();
	}
	
	/** Updates the parse tree and the list of problems. */
	private void parse () {
		if (lexer == null)
			lexer = new SmlLexer();
		lexer.setDocument(document);
		if (parser == null)
			parser = new SmlParser();
		parser.setScanner(lexer);
		problems = new ArrayList<IRegion>();
		try {
			Symbol result = parser.parse();
			for (Symbol error : parser.parseErrors) {
				problems.add(new Region(error.left,error.right-error.left));
			}
			parseTree = (ASTRoot) result.value;
		} catch (Exception e) {
			parseTree = new ASTRoot();
		}
	}

	/** Adds a listener to this program. The listener will be notified
	 * when the program is updated. */
	public void addListener (ISmlProgramListener listener) {listeners.add(listener);}
	/** Removes the listener from this program. If the listener was not
	 * added to the program, nothing happens. */
	public void removeListener (ISmlProgramListener listener) {listeners.remove(listener);}
	/** Notifies all listeners that the program has been updated. */
	private void fireModelChanged () {
		for (ISmlProgramListener listener : listeners) {
			listener.programChanged(this);
		}
	}

	/** Returns the deepest identifier bound at the given offset
	 * in the document. If there is no binding at the offset,
	 * null is returned. */
	public SmlBinding getBinding (int offset) {
		return getDeepestBinding(offset, getBindings());
	}
	
	/** Recursively searches among the given bindings and their children
	 * to find the deepest binding containing the given offset. */
	private SmlBinding getDeepestBinding (int offset, SmlBinding[] bindings) {
		for (SmlBinding binding : bindings) {
			if (containsOffset(binding,offset)) {
				SmlBinding childBinding = getDeepestBinding(offset, binding.getChildren());
				if (childBinding != null)
					return childBinding;
				else
					return binding;
			}
		}
		return null;
	}

	private boolean containsOffset (SmlBinding binding, int offset) {
		return offset >= binding.getLeft() && offset <= binding.getRight(); 
	}

}
