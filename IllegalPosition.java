package mmn12_2;

public class IllegalPosition extends Exception{

	
	private static final long serialVersionUID = 1L;

	/**
	 * @see java.lang.Exception#Exception()
	 */
	public IllegalPosition() {
		super();
	}
	
	/**
	 * @see java.lang.Exception#Exception(String)
	 */
	public IllegalPosition(String str) {
		super(str);
	}

	
}
