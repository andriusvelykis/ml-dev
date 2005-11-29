package in.iitd.mldev.launch.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;

/** The group of tabs in the Run dialog for SML. */
public class SmlLaunchTabGroup extends AbstractLaunchConfigurationTabGroup {

	public SmlLaunchTabGroup () {
		super();
	}

	public void createTabs (ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ILaunchConfigurationTab[] {
				new SmlLaunchTab(),
				new RefreshTab(),
				new CommonTab()
		});
	}

}
