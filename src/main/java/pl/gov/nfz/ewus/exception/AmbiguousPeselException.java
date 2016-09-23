/**
 * 
 */
package pl.gov.nfz.ewus.exception;

/**
 * @author Tomasz Jasiński
 *
 */
public class AmbiguousPeselException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmbiguousPeselException() {
		super();
	}

	public AmbiguousPeselException(String message) {
		super(message);
	}

	public AmbiguousPeselException(Throwable cause) {
		super(cause);
	}

	public AmbiguousPeselException(String message, Throwable cause) {
		super(message, cause);
	}
}
