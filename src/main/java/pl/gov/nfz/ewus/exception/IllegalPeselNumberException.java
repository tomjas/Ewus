package pl.gov.nfz.ewus.exception;

/**
 * @author Tomasz Jasiński
 *
 */
public class IllegalPeselNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalPeselNumberException() {
		super();
	}

	public IllegalPeselNumberException(String message) {
		super(message);
	}

	public IllegalPeselNumberException(Throwable cause) {
		super(cause);
	}

	public IllegalPeselNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
