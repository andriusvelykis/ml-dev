package in.iitd.mldev.core.scan;

import in.iitd.mldev.core.SmlCorePlugin;
import in.iitd.mldev.core.parse.SmlSymbols;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.rules.IToken;


/**
 * The lexer used by the SmlParser.
 * <p>
 * Uses the document partitioning already defined by an SmlPartitionScanner
 * to find strings and comments. Scans the remainder of the SML code using
 * an SmlTokenScanner. Implementing it this way ensures that the lexer
 * and the syntax highlighting in the editor behave identically,
 * which otherwise might not be easy given SML's nested comments and
 * my inexperience with lexing escaped characters in strings.
 */
/* Actually, this is probably bad form... The core functionality of program
 * analysis shouldn't depend on the UI. A document partitioning is only
 * defined if the file is open in an editor in the workspace, an assumption
 * that will prevent us from being able to check semantic errors in programs
 * which refer to other files. It shouldn't be too hard to rewrite the lexer
 * to not use document partitioning, by using SmlCommentRule, SmlStringRule and
 * SmlCharRule directly. */
public class SmlLexer implements Scanner {
	
	private IDocument document;
	private ITypedRegion[] partitions;
	private int currentPartition;
	private SmlTokenScanner scanner;
	
	/** Initializes the lexer to work on the given document. */
	public void setDocument (IDocument document) {
		this.document = document;
		IDocumentPartitioner partitioner = SmlCorePlugin.getPartitioner(document);
		partitions = partitioner.computePartitioning(0, document.getLength());
		if (scanner == null)
			scanner = new SmlTokenScanner();
		currentPartition = 0;
		scanner.setRange(document, partitions[0].getOffset(), partitions[0].getLength());
	}
	
	/** Advances the current partition to the next partition in the document,
	 * and sets the scanner to run on that region. */
	private void nextPartition () {
		currentPartition++;
		if (currentPartition >= partitions.length)
			return;
		ITypedRegion partition = partitions[currentPartition];
		scanner.setRange(document, partition.getOffset(), partition.getLength());
	}

	/** Returns the next token in the document. */
	public Symbol next_token () {
		/* The implementation is a little shady... needs to be rewritten
		 * to make more sense. What's happening is that the lexer keeps
		 * track of which partition in the document is being read.
		 * If it's a comment or a string, no problem: return it and advance
		 * to the next partition. If it's not (i.e. it's SML code), the lexer
		 * gets the next token from the scanner and returns it.
		 * ...Unless it's an EOF, which means the partition
		 * is finished, so go to the next partition and try again. */
		if (currentPartition >= partitions.length)
			return new Symbol(SmlSymbols.EOF);
		ITypedRegion partition = partitions[currentPartition];
		if (partition.getType() == SmlTokenTypes.COMMENT) {
			nextPartition();
			return next_token();
		}
		if (partition.getType() == SmlTokenTypes.STRING) {
			nextPartition();
			int offset = partition.getOffset();
			int length = partition.getLength();
			return new Symbol(SmlSymbols.STRING, offset, offset+length, getText(offset,length));
		}
		if (partition.getType() == SmlTokenTypes.CHAR) {
			nextPartition();
			int offset = partition.getOffset();
			int length = partition.getLength();
			return new Symbol(SmlSymbols.CHAR, offset, offset+length, getText(offset,length));
		}
		IToken token = scanner.nextToken();
		if (token.isEOF()) {
			nextPartition();
			return next_token();
		}
		if (token.isUndefined() || token.isWhitespace())
			return next_token();
		int offset = scanner.getTokenOffset();
		int length = scanner.getTokenLength();
		if (token.getData() == SmlTokenTypes.INT)
			return new Symbol(SmlSymbols.INT, offset, offset+length, toInt(getText(offset,length)));
		if (token.getData() == SmlTokenTypes.REAL)
			return new Symbol(SmlSymbols.REAL, offset, offset+length, toFloat(getText(offset,length)));
		if (token.getData() == SmlTokenTypes.TYVAR)
			return new Symbol(SmlSymbols.TYVAR, offset, offset+length, getText(offset,length));
		if (token.getData() == SmlTokenTypes.WORD) {
			String word = getText(offset,length);
			return new Symbol(SmlKeywords.getSym(word), offset, offset+length, word);
		}
		return next_token();
	}
	
	/** Gets a substring of the document. */
	private String getText (int offset, int length) {
		try {return document.get(offset, length);}
		catch (BadLocationException e) {return "";}
	}
	
	/** Converts a SML-style integer (e.g. "~42") to an Integer. */
	private Integer toInt (String s) {
		return Integer.valueOf(s.replace('~','-'));
	}

	/** Converts a SML-style real (e.g. "~1.602e~19") to a Float. */
	private Float toFloat (String s) {
		return Float.valueOf(s.replace('~','-'));
	}

//	/** Helper function for debugging. */
//	private void debugToken (IToken token, ITokenScanner scanner) {
//		String tokenMsg = "";
//		if (token.isEOF()) tokenMsg = "eof";
//		if (token.isUndefined()) tokenMsg = "undefined";
//		if (token.isWhitespace()) tokenMsg = "whitespace";
//		if (token.isOther()) tokenMsg = "data '"+token.getData()+"'";
//		String scannerMsg = scanner.getTokenOffset()+"+"+scanner.getTokenLength();
//		System.out.println("token "+tokenMsg+" at "+scannerMsg);
//	}

}
