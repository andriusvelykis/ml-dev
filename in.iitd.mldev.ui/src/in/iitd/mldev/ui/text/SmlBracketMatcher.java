package in.iitd.mldev.ui.text;

import in.iitd.mldev.core.scan.SmlCodeReader;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ICharacterPairMatcher;

/** Helper class for bracket matching. */
public class SmlBracketMatcher implements ICharacterPairMatcher {
	
	private static char[] openBrackets = {'(', '{', '['};
	private static char[] closeBrackets = {')', '}', ']'};

	/** Whether the cursor position was left or right of the matching bracket. */
	private int anchor;
	
	public void dispose () {}

	public void clear () {}

	/** If the character at the given offset in the document is a bracket,
	 * finds its matching bracket and returns the region between them. */
	public IRegion match (IDocument document, int offset) {
		offset = (offset > 0) ? offset-1 : 0;
		IRegion region;
		for (int i = 0; i < openBrackets.length; i++) {
			region = matchForward(document, offset, openBrackets[i], closeBrackets[i]);
			if (region != null) {
				anchor = LEFT;
				return region;
			}
			region = matchBackward(document, offset, openBrackets[i], closeBrackets[i]);
			if (region != null) {
				anchor = RIGHT;
				return region;
			}
		}
		return null;
	}
	
	/** Returns whether the cursor position was at the left or the right end
	 * of the region returned when match() was last called. */
	/* This is the opposite of where the matching bracket was, relative to
	 * the bracket at the cursor position. That's how the ICharacterPairMatcher
	 * API works, go figure. */
	public int getAnchor () {
		return anchor;
	}
	
	/** Finds the position of the close bracket which matches the open bracket
	 * at the given offset at the document, and returns the region between them.
	 * Returns null if the character at the offset is not the given
	 * open bracket, or there is no matching close bracket. */
	private IRegion matchForward (IDocument document, int offset, char open, char close) {
		SmlCodeReader reader = new SmlCodeReader(document, offset);
		if (reader.readForward() != open || reader.getLastOffset() != offset)
			return null;
		int depth = 1;
		while (depth > 0) {
			int c = reader.readForward();
			if (c == -1) break;
			if (c == open) depth++;
			if (c == close) depth--;
		}
		if (depth != 0)
			return null;
		return new Region(offset, reader.getLastOffset() - offset + 1);
	}
	
	/** Finds the position of the open bracket which matches the close bracket
	 * at the given offset at the document, and returns the region between them.
	 * Returns null if the character at the offset is not the given
	 * close bracket, or there is no matching open bracket. */
	private IRegion matchBackward (IDocument document, int offset, char open, char close) {
		SmlCodeReader reader = new SmlCodeReader(document, offset);
		if (reader.readBackward() != close || reader.getLastOffset() != offset) return null;
		int depth = 1;
		while (depth > 0) {
			int c = reader.readBackward();
			if (c == -1) break;
			if (c == open) depth--;
			if (c == close) depth++;
		}
		if (depth != 0)
			return null;
		return new Region(reader.getLastOffset(), offset - reader.getLastOffset() + 1);
	}
	
}
