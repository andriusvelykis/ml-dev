package in.iitd.mldev.launch;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jface.preference.IPreferenceStore;

/** This class performs the actual task of running an SML program or
 * a CM description file. */
public class SmlLaunchDelegate implements ILaunchConfigurationDelegate {

	/** Performs a launch. This method is called by Eclipse when the user
	 * wants to run something.
	 * <p>
	 * The information entered by the user in the 'Run...' dialog
	 * is passed here in the given launch configuration. Eclipse also
	 * creates a new launch object to manage the processes we will create.
	 * This method's job is only to run SML in a new process and add it
	 * to the given launch object.
	 * <p>
	 * The method first runs the SML interpreter, then calls 'use'
	 * or 'CM.make' in it, since unfortunately the file cannot be passed
	 * as a command-line argument. */
	public void launch (ILaunchConfiguration config, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		IPath filePath = getFilePath(config);
		if (filePath == null)
			throw new CoreException(new Status(IStatus.ERROR, "in.iitd.mldev.launch", 1, "The file to launch was not found in the workspace.", null));
		IPath fileDir = filePath.removeLastSegments(1);
		String fileName = filePath.lastSegment();
		IProcess smlProcess = execSml(fileDir.toFile(), launch);
		try {
			boolean isCM = config.getAttribute(SmlLaunchPlugin.SML_CONFIG_IS_CM, false);
			if (isCM) {
				IPreferenceStore store = SmlLaunchPlugin.getDefault().getPreferenceStore(); 
				String makeFunction = store.getString(SmlLaunchPlugin.SML_CM_MAKE_FUNCTION);
				if (makeFunction.equals(SmlLaunchPlugin.SML_CM_MAKE_UNIT))
					smlProcess.getStreamsProxy().write("CM.make ();\n");
				else
					smlProcess.getStreamsProxy().write(makeFunction + " \"" + fileName + "\";\n");
			} else {
				smlProcess.getStreamsProxy().write("use \"" + fileName + "\";\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Runs the SML interpreter in a new process with the given
	 * working directory, and add it to the given launch object. */
	private IProcess execSml (File workingDir, ILaunch launch) throws CoreException {
		String smlPath = SmlLaunchPlugin.getDefault().getPreferenceStore().getString(SmlLaunchPlugin.SML_EXECUTABLE_PATH);
		if (smlPath == null || smlPath.length() == 0)
			throw new CoreException(new Status(IStatus.ERROR, "in.iitd.mldev.launch", 1, "No SML interpreter specified in the launch preferences.", null));
		Process process = DebugPlugin.exec(new String[] {smlPath}, workingDir);
		return DebugPlugin.newProcess(launch, process, "SML");
	}
	
	/** Queries the given launch configuration for the file to be run,
	 * and returns its absolute path. */
	private IPath getFilePath (ILaunchConfiguration config) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String projectName = config.getAttribute(SmlLaunchPlugin.SML_CONFIG_PROJECT, "");
		String fileName = config.getAttribute(SmlLaunchPlugin.SML_CONFIG_FILE, "");
		IProject project = root.getProject(projectName);
		IFile file = project.getFile(fileName);
		if (file.exists()) 
			return file.getLocation();
		else
			return null;
	}

}
