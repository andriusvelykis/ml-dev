package in.iitd.mldev.ui.editor;

import in.iitd.mldev.ui.SmlUiPlugin;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/** A utility class to get colours and font styles for syntax highlighting. */
public class SmlTextStyleProvider {

	private TextAttribute defaultStyle, keywordStyle, stringStyle, commentStyle;
	
	/** Creates a new text style provider. Currently, a new provider is
	 * created for each SML editor. */
	/* Colour preferences are only read in the constructor, which is why
	 * editors need to be closed and reopened after changing the colours. */
	public SmlTextStyleProvider () {
		IPreferenceStore store = SmlUiPlugin.getDefault().getPreferenceStore();
		RGB keywordColor = PreferenceConverter.getColor(store, SmlUiPlugin.SML_KEYWORD_COLOR);
		RGB stringColor = PreferenceConverter.getColor(store, SmlUiPlugin.SML_STRING_COLOR);
		RGB commentColor = PreferenceConverter.getColor(store, SmlUiPlugin.SML_COMMENT_COLOR);
		keywordStyle = new TextAttribute(new Color(null,keywordColor), null, SWT.BOLD);
		stringStyle = new TextAttribute(new Color(null,stringColor), null, SWT.NORMAL);
		commentStyle = new TextAttribute(new Color(null,commentColor), null, SWT.NORMAL);
	}

	/** Disposes the colours allocated in the constructor. */
	/* "Applications must dispose of all colors which they allocate."
	 * Unfortunately, this method is never called. */
	public void dispose() {
		TextAttribute[] styles = {defaultStyle, keywordStyle, stringStyle, commentStyle};
		for (int i = 0; i < styles.length; i++) {
			if (styles[i].getBackground() != null)
				styles[i].getBackground().dispose();
			if (styles[i].getForeground() != null)
				styles[i].getForeground().dispose();
		}
	}
	
	/** Returns the colour and font style for comments in the editor. */
	public TextAttribute getCommentStyle () {return commentStyle;}
	/** Returns the colour and font style for keywords in the editor. */
	public TextAttribute getKeywordStyle () {return keywordStyle;}
	/** Returns the colour and font style for strings in the editor. */
	public TextAttribute getStringStyle () {return stringStyle;}
}
