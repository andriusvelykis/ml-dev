package in.iitd.mldev.ui.preferences;

import in.iitd.mldev.ui.SmlUiPlugin;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/** The main SML page in the Preferences window. */
public class SmlMainPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/** Creates an SML preference page and sets it to save preferences in
	 * the SML UI plug-in's preference store. */
	public SmlMainPreferencePage () {
		super(GRID);
		setPreferenceStore(SmlUiPlugin.getDefault().getPreferenceStore());
	}
	
	/** Creates the page's fields. Since this class extends
	 * FieldEditorPreferencePage, all we have to do is create the field
	 * editors for all the required fields, and everything else will take
	 * care of itself. */
	protected void createFieldEditors () {
		addField(new ColorFieldEditor(SmlUiPlugin.SML_KEYWORD_COLOR, "Keyword colour:", getFieldEditorParent()));
		addField(new ColorFieldEditor(SmlUiPlugin.SML_STRING_COLOR, "String colour:", getFieldEditorParent()));
		addField(new ColorFieldEditor(SmlUiPlugin.SML_COMMENT_COLOR, "Comment colour:", getFieldEditorParent()));
		addField(new IntegerFieldEditor(SmlUiPlugin.SML_TAB_WIDTH, "Tab width:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(SmlUiPlugin.SML_MARK_ERRORS, "Mark syntax errors in editor", getFieldEditorParent()));
	}

	/** Nothing to initialize. */
	public void init (IWorkbench workbench) {}

}
