package in.iitd.mldev.core.parse.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The abstract superclass of every node in the parse tree of a SML program. The tree is strongly
 * typed. Each node also stores the offsets in the document where it begins and ends. For simplicity
 * and speed, AST nodes make their fields public instead of providing getters and setters.
 */
public abstract class AST {

	/** The offset in the document where the node begins. */
	private int left = -1;

	/** The offset in the document where the node ends. */
	private int right = -1;

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	/**
	 * Sets the left and right positions of the node. Shouldn't be called after the parse tree has
	 * been built.
	 */
	public void setPos(int l, int r) {
		left = l;
		right = r;
	}

	protected static <T> List<T> copyList(List<T> list) {
		return Collections.unmodifiableList(new ArrayList<T>(list));
	}
}
