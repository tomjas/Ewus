package pl.gov.nfz.ewus.exception;

/**
 * @author Tomasz Jasiński
 *
 */
public class NoSuchPersonException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchPersonException() {
		super();
	}

	public NoSuchPersonException(String message) {
		super(message);
	}

	public NoSuchPersonException(Throwable cause) {
		super(cause);
	}

	public NoSuchPersonException(String message, Throwable cause) {
		super(message, cause);
	}

}
