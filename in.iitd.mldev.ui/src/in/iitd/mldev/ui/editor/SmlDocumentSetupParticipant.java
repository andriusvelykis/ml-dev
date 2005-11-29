package in.iitd.mldev.ui.editor;

import in.iitd.mldev.core.SmlCorePlugin;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.IDocument;

/** Sets up an SML document when an editor is opened. */
public class SmlDocumentSetupParticipant implements IDocumentSetupParticipant {

	/** Sets up the document by adding an SML partitioner. */
    public void setup (IDocument document) {
    	SmlCorePlugin.getPartitioner(document);
    }

}
