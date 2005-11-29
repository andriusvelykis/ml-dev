package in.iitd.mldev.ui.editor;

import in.iitd.mldev.core.model.ISmlProgramListener;
import in.iitd.mldev.core.model.SmlBinding;
import in.iitd.mldev.core.model.SmlProgram;
import in.iitd.mldev.ui.SmlUiPlugin;
import in.iitd.mldev.ui.editor.outline.SmlContentOutlinePage;
import in.iitd.mldev.ui.text.SmlBracketMatcher;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.DefaultRangeIndicator;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

/** The SML editor. */
public class SmlEditor extends TextEditor implements ISmlProgramListener {
    
	/** The content outline page shown in the Outline view. */
    private SmlContentOutlinePage outlinePage;
    /** The high-level model of the program in the editor. */
	private SmlProgram program;

	/** Called by Eclipse to initialize the editor. Sets the editor to use
	 * the SML UI plug-in's preference store, and configures its syntax
	 * highlighting, tab width, etc. See SmlSourceViewerConfiguration. */
	protected void initializeEditor () {
		super.initializeEditor();
		setPreferenceStore(new ChainedPreferenceStore(new IPreferenceStore[] {
				SmlUiPlugin.getDefault().getPreferenceStore(),
				EditorsPlugin.getDefault().getPreferenceStore()}));
        setSourceViewerConfiguration(new SmlSourceViewerConfiguration(this));
        setRangeIndicator(new DefaultRangeIndicator());
        showOverviewRuler();
	}

	/** Returns this editor's outline page if requested. (This is how
	 * Eclipse gets the outline from the editor.) If the request is for
	 * something else, passes it on to the superclass. */
	public Object getAdapter (Class adaptTo) {
        if (adaptTo.equals(IContentOutlinePage.class)) {
            if (outlinePage == null)
            	outlinePage = new SmlContentOutlinePage(this);
            return outlinePage;
        }
        return super.getAdapter(adaptTo);
    }
    
	/** Called by Eclipse when creating the editor. Adds bracket matching. */
	protected void configureSourceViewerDecorationSupport (SourceViewerDecorationSupport support) {
		super.configureSourceViewerDecorationSupport(support);
		support.setCharacterPairMatcher(new SmlBracketMatcher());
		support.setMatchingCharacterPainterPreferenceKeys(SmlUiPlugin.SML_BRACKET_MATCHING_ENABLED, SmlUiPlugin.SML_BRACKET_MATCHING_COLOR);
	}
	
	/** Returns the SmlProgram representing the document in this editor. */
	public SmlProgram getProgram () {
		if (program == null) {
			IDocument document = getDocumentProvider().getDocument(getEditorInput());
			program = new SmlProgram(document);
			program.addListener(this);
		}
		return program;
	}

	/** Called when the SmlProgram is updated. Removes existing error markers,
	 * and optionally adds markers for the errors in the updated program. */
	/* We always remove all markers to avoid any markers getting left over
	 * after the user disables error marking. */
	public void programChanged (SmlProgram program) {
		removeErrorMarkers();
		if (SmlUiPlugin.getDefault().getPluginPreferences().getBoolean(SmlUiPlugin.SML_MARK_ERRORS))
			addErrorMarkers(program);
	}
	
	/** Removes all error markers from the editor's document. */
	private void removeErrorMarkers () {
		if (!(getEditorInput() instanceof IFileEditorInput)) return;
		IFile file = ((IFileEditorInput) getEditorInput()).getFile();
		try {
			file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {e.printStackTrace();}
	}
	
	/** Adds markers for all errors in the given program. */
	private void addErrorMarkers (SmlProgram program) {
		if (!(getEditorInput() instanceof IFileEditorInput)) return;
		IFile file = ((IFileEditorInput) getEditorInput()).getFile();
		IRegion[] problems = program.getProblems();
		try {
			for (int i = 0; i < problems.length; i++) {
				IDocument document = getDocumentProvider().getDocument(getEditorInput());
				Map attributes = new HashMap();
				attributes.put(IMarker.MESSAGE, "Syntax error");
				attributes.put(IMarker.CHAR_START, new Integer(problems[i].getOffset()));
				attributes.put(IMarker.CHAR_END, new Integer(problems[i].getOffset()+problems[i].getLength()));
				attributes.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
				attributes.put(IMarker.TRANSIENT, Boolean.TRUE);
				MarkerUtilities.createMarker(file, attributes, IMarker.PROBLEM);
			}
		} catch (CoreException e) {e.printStackTrace();}
	}

	/** Called when the cursor position changes. Selects the binding at that
	 * position in the outline page. */
	protected void handleCursorPositionChanged () {
		super.handleCursorPositionChanged();
		ISourceViewer sourceViewer = getSourceViewer();
		int offset = widgetOffset2ModelOffset(sourceViewer, sourceViewer.getTextWidget().getCaretOffset());
		SmlBinding binding = program.getBinding(offset);
		if (binding != null)
			outlinePage.select(binding);
		else
			outlinePage.deselect();
	}
	
}
