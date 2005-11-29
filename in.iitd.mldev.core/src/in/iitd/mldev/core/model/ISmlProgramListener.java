package in.iitd.mldev.core.model;

/**
 * An ISmlProgramListener gets notified when an ISmlProgram is updated.
 */
public interface ISmlProgramListener {
	/** This method will be called by the program when it is updated. */
	public void programChanged (SmlProgram program);
}
