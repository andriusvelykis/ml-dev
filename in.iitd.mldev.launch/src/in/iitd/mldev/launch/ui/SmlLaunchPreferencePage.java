package in.iitd.mldev.launch.ui;

import in.iitd.mldev.launch.SmlLaunchPlugin;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/** The SML > Run page in the Preferences. */
public class SmlLaunchPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public SmlLaunchPreferencePage () {
		super(GRID);
		setPreferenceStore(SmlLaunchPlugin.getDefault().getPreferenceStore());
	}

	protected void createFieldEditors () {
		FileFieldEditor interpreterField = new FileFieldEditor(
				SmlLaunchPlugin.SML_EXECUTABLE_PATH,
				"SML executable:",
				false,
				getFieldEditorParent());
		interpreterField.setEmptyStringAllowed(true);
		addField(interpreterField);
		addField(new RadioGroupFieldEditor(
					SmlLaunchPlugin.SML_CM_MAKE_FUNCTION,
					"CM make function",
					3,
					new String[][]{
							{"CM.make ()", SmlLaunchPlugin.SML_CM_MAKE_UNIT},
							{"CM.make <filename>", SmlLaunchPlugin.SML_CM_MAKE_STRING},
							{"CM.make' <filename>", SmlLaunchPlugin.SML_CM_MAKEP_STRING}},
					getFieldEditorParent(),
					true));
	}

	public void init (IWorkbench workbench) {}

}
