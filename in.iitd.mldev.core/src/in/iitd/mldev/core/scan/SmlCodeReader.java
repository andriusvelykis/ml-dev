package in.iitd.mldev.core.scan;

import in.iitd.mldev.core.SmlCorePlugin;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;

/** A utility class to read characters from a document, skipping
 * comments and strings. Used by SmlBracketMatcher. */
public class SmlCodeReader {
	
	private IDocument document;
	private IDocumentPartitioner partitioner;
	private int offset;
	private int lastOffset;

	/** Creates a SmlCodeReader that reads characters from the given document.
	 * The first character read will be the character at the given offset. */
	public SmlCodeReader (IDocument document, int offset) {
		this.document = document;
		this.partitioner = SmlCorePlugin.getPartitioner(document);
		this.offset = offset;
		this.lastOffset = offset;
	}

	/** Returns the next character, ignoring comments and strings. */
	public int readForward () {
		try {
			ITypedRegion partition = partitioner.getPartition(offset);
			if (!partition.getType().equals(IDocument.DEFAULT_CONTENT_TYPE)) {
				offset = partition.getOffset() + partition.getLength();
				return readForward();
			}
			int c = document.getChar(offset);
			lastOffset = offset;
			offset++;
			return c;
		} catch (BadLocationException e) {
			return -1;
		}
	}

	/** Returns the previous character, ignoring comments and strings. */
	public int readBackward () {
		try {
			ITypedRegion partition = partitioner.getPartition(offset);
			if (!partition.getType().equals(IDocument.DEFAULT_CONTENT_TYPE)) {
				offset = partition.getOffset() - 1; 
				return readBackward();
			}
			int c = document.getChar(offset);
			lastOffset = offset;
			offset--;
			return c;
		} catch (BadLocationException e) {
			return -1;
		}
	}
	
	/** Returns the offset of the character last read. */
	public int getLastOffset () {return lastOffset;}
	
}