package in.iitd.mldev.ui.editor.outline;

import in.iitd.mldev.core.model.SmlBinding;
import in.iitd.mldev.core.model.SmlProgram;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/** This class provides the outline page's internal tree viewer with
 * information about the actual bindings tree. The tree viewer expects to
 * be given arbitrary Objects as input, so it depends on a content provider
 * to find out the nodes in the tree. In our case, the viewer is given
 * an SmlProgram, and calls getElements on it to get the top-level elements
 * in the tree, then getChildren on them to find their children, and so on. */
public class SmlBindingsContentProvider implements ITreeContentProvider {

	/** Returns the children bindings of the given binding. */
	public Object[] getChildren (Object element) {
		return ((SmlBinding)element).getChildren();
	}

	/** Returns the parent binding of the given binding. */
	public Object getParent (Object element) {
		return ((SmlBinding)element).getParent();
	}

	/** Returns whether the given binding has any children. */
	public boolean hasChildren (Object element) {
		return ((SmlBinding)element).hasChildren();
	}

	/** Returns the top-level bindings of the given program (which is
	 * conceptually the root of the tree, but is not displayed in the view).
	 * This method is called only on the object given to the tree viewer
	 * in setInput(). */
	public Object[] getElements (Object inputElement) {
		return ((SmlProgram)inputElement).getBindings();
	}

	public void dispose () {}

	public void inputChanged (Viewer viewer, Object oldInput, Object newInput) {}

}
