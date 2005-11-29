package in.iitd.mldev.core.parse.ast;

/**
 * The abstract superclass of every node in the parse tree of a SML program.
 * The tree is strongly typed. Each node also stores the offsets in the
 * document where it begins and ends. For simplicity and speed,
 * AST nodes make their fields public instead of providing getters and setters.
 */
public abstract class AST {
	
	/** The offset in the document where the node begins. */
    public int left = -1;
    
	/** The offset in the document where the node ends. */
    public int right = -1;
    
    /** Sets the left and right positions of the node.
     * Shouldn't be called after the parse tree has been built. */
    public void setPos (int l, int r) {left = l; right = r;}
    
}
