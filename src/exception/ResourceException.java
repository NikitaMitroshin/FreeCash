package exception;

/**
 * Created by Nikita Mitroshin on 18.06.2015.
 */
public class ResourceException extends Exception {

    public ResourceException() {
        super();
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
}
