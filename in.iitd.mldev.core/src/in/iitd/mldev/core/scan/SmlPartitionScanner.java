package in.iitd.mldev.core.scan;

import in.iitd.mldev.core.scan.SmlTokenTypes;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.Token;

/**
 * A partition scanner that separates a document into comments, strings, and
 * normal SML code. This is useful for syntax highlighting and bracket matching.
 * Partitioning of a document is done by creating a FastPartitioner that
 * uses this scanner to identify the partitions. The partitioner must be
 * connected to the document, and vice versa.
 * See SmlCorePlugin.getPartitioner(). 
 * <p>
 * We can't just use a standard RuleBasedPartitionScanner to partition
 * an SML document. This is because a RuleBasedPartitionScanner uses
 * IPredicateRules, which are expected to be able to find the end
 * of a partition when started from the middle of the partition.
 * This simply isn't possible for nested comments in SML.
 */
public class SmlPartitionScanner extends BufferedRuleBasedScanner implements IPartitionTokenScanner {

	public static final String[] CONTENT_TYPES = new String[] {IDocument.DEFAULT_CONTENT_TYPE, SmlTokenTypes.STRING, SmlTokenTypes.COMMENT};
	
	/** Creates and initializes a new partition scanner. */
	public SmlPartitionScanner () {
		super();
		IRule commentRule = new SmlCommentRule(new Token(SmlTokenTypes.COMMENT));
		IRule stringRule = new SmlStringRule(new Token(SmlTokenTypes.STRING));
		IRule charRule = new SmlCharRule(new Token(SmlTokenTypes.CHAR));
		setRules(new IRule[] {commentRule, stringRule, charRule});
	}
	
	public void setPartialRange (IDocument document, int offset, int length, String contentType, int partitionOffset) {
		if (partitionOffset > -1 && partitionOffset < offset) setRange(document, partitionOffset, length + offset-partitionOffset);
		else setRange(document, offset, length);
	}
	
}
