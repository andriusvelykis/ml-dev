package in.iitd.mldev.launch.ui;

import in.iitd.mldev.launch.SmlLaunchPlugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/** The main tab in the Run dialog for SML. Allows the user to enter
 * the file to be run, and saves the information in a launch configuration.
 * <p>
 * Note that we never have to create our own launch configurations
 * ("configs"). Eclipse handles the entire config life cycle --
 * creating, saving and reloading configs -- on its own.
 * This class is only responsible for getting SML-specific information
 * from the user and entering it in the config Eclipse passes to it.
 * Eclipse will save the config somewhere, and pass it to the
 * SML launch delegate whenever the user asks to run the config.
 * To enable Eclipse to do all this, a launch configuration is very simple,
 * essentially just a mapping from strings to a few simple types of data.
 */
public class SmlLaunchTab extends AbstractLaunchConfigurationTab {
	
	private Text projectField, fileField;
	private Button fileRadio, cmRadio;
	private ModifyListener modifyListener = new ModifyListener () {
		public void modifyText (ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
	};
	private Image image;

	/** Creates the contents of this tab. The given composite is the container
	 * which is to be populated with the tab's fields. */
	/* TODO: The fields should use Resource- or Element- ListSelectionDialog */
	public void createControl (Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		composite.setLayout(new GridLayout());
		
		new Label(composite, SWT.NONE).setText("Project:");
		projectField = new Text(composite, SWT.SINGLE | SWT.BORDER);
		projectField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		projectField.addModifyListener(modifyListener);
		
		Group fileGroup = new Group(composite, SWT.NULL);
		fileGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fileGroup.setLayout(new GridLayout(2,false));
		fileGroup.setText("File");

		fileRadio = new Button(fileGroup, SWT.RADIO);
		fileRadio.setText("SML file");
		cmRadio = new Button(fileGroup, SWT.RADIO);
		cmRadio.setText("CM description file");
		
		fileField = new Text(fileGroup, SWT.SINGLE | SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		fileField.setLayoutData(gridData);
		fileField.addModifyListener(modifyListener);
	}

	public void setDefaults (ILaunchConfigurationWorkingCopy config) {
		// leave the configuration empty
	}

	public void initializeFrom (ILaunchConfiguration config) {
		try {
			projectField.setText(config.getAttribute(SmlLaunchPlugin.SML_CONFIG_PROJECT, ""));
			fileField.setText(config.getAttribute(SmlLaunchPlugin.SML_CONFIG_FILE, ""));
			boolean isCm = config.getAttribute(SmlLaunchPlugin.SML_CONFIG_IS_CM, false);
			fileRadio.setSelection(!isCm);
			cmRadio.setSelection(isCm);
		} catch (CoreException e) {
			projectField.setText("");
			fileField.setText("");
			fileRadio.setSelection(true);
			cmRadio.setSelection(false);
		}
	}

	public void performApply (ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(SmlLaunchPlugin.SML_CONFIG_PROJECT, projectField.getText());
		config.setAttribute(SmlLaunchPlugin.SML_CONFIG_FILE, fileField.getText());
		config.setAttribute(SmlLaunchPlugin.SML_CONFIG_IS_CM, cmRadio.getSelection());
	}

	public String getName () {
		return "Main";
	}
	
	public Image getImage () {
		if (image == null) {
			String url = "/icons/file.gif";
			ImageDescriptor descriptor = ImageDescriptor.createFromURL(SmlLaunchPlugin.getDefault().getBundle().getEntry(url));
			image = descriptor.createImage();
		}
		return image;
	}
	
	/** Called when the tab has been disposed.
	 * Used to perform any cleanup required. */
	public void dispose () {
		if (image != null)
			image.dispose();
		super.dispose();
	}

}
