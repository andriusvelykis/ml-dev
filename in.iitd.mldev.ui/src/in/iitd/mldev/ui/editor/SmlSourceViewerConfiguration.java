package in.iitd.mldev.ui.editor;

import in.iitd.mldev.core.SmlCorePlugin;
import in.iitd.mldev.core.scan.SmlPartitionScanner;
import in.iitd.mldev.core.scan.SmlTokenTypes;
import in.iitd.mldev.ui.SmlUiPlugin;
import in.iitd.mldev.ui.text.SingleTokenScanner;
import in.iitd.mldev.ui.text.SmlTextStyleScanner;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/** Bundles the configuration of an SmlEditor. Sets up its default document
 * partitioning, syntax highlighting, tab width, and the reconciler that
 * updates the program model. Except for the constructor, all the methods are
 * called only by Eclipse to determine the configuration of the editor. */
public class SmlSourceViewerConfiguration extends SourceViewerConfiguration {

	/** The editor that this instance configures. */
	private SmlEditor editor;

	/** Creates a source viewer configuration to configure the given editor.
	 * It should only be used with this editor. */
	public SmlSourceViewerConfiguration (SmlEditor editor) {
		this.editor = editor;
	}
	
	/** Returns the content types to be configured in an SML document.
	 * See SmlPartitionScanner. */
	public String[] getConfiguredContentTypes (ISourceViewer sourceViewer) {
		return SmlPartitionScanner.CONTENT_TYPES;
	}

	/** Returns the default partitioning for an SML document.
	 * See SmlPartitionScanner. */
	public String getConfiguredDocumentPartitioning (ISourceViewer sourceViewer) {
		return SmlCorePlugin.SML_PARTITIONING;
	}
	
	/** Returns a presentation reconciler for performing syntax highlighting. */
	public IPresentationReconciler getPresentationReconciler (ISourceViewer viewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(viewer));
		
		SmlTextStyleProvider styleProvider = new SmlTextStyleProvider();
        
		DefaultDamagerRepairer damageRepairer;
		damageRepairer = new DefaultDamagerRepairer(new SmlTextStyleScanner(styleProvider.getKeywordStyle()));
		reconciler.setDamager(damageRepairer, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(damageRepairer, IDocument.DEFAULT_CONTENT_TYPE);
        
		damageRepairer = new DefaultDamagerRepairer(new SingleTokenScanner(styleProvider.getCommentStyle()));
		reconciler.setDamager(damageRepairer, SmlTokenTypes.COMMENT);
		reconciler.setRepairer(damageRepairer, SmlTokenTypes.COMMENT);
        
		damageRepairer = new DefaultDamagerRepairer(new SingleTokenScanner(styleProvider.getStringStyle()));
		reconciler.setDamager(damageRepairer, SmlTokenTypes.STRING);
		reconciler.setRepairer(damageRepairer, SmlTokenTypes.STRING);
        
		damageRepairer = new DefaultDamagerRepairer(new SingleTokenScanner(styleProvider.getStringStyle()));
		reconciler.setDamager(damageRepairer, SmlTokenTypes.CHAR);
		reconciler.setRepairer(damageRepairer, SmlTokenTypes.CHAR);
        
		return reconciler;
    }
    
	/** Returns the width that a tab character should be displayed with. */
    public int getTabWidth (ISourceViewer viewer) {
    	return SmlUiPlugin.getDefault().getPreferenceStore().getInt(SmlUiPlugin.SML_TAB_WIDTH);
    }
    
    /** Returns the reconciler that will updates the program model
     * in response to changes in the editor's document. */
    public IReconciler getReconciler (ISourceViewer viewer) {
    	MonoReconciler reconciler = new MonoReconciler(new SmlReconcilingStrategy(editor), false);
    	return reconciler;
    }

}
