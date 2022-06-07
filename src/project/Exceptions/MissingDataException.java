package project.Exceptions;

/**
 * Custom exception to catch out a NullPointerException when an incorrect vehicle name is present in GUI.
 */
public class MissingDataException extends Exception {
    /**
     * Instantiates a new Missing data exception.
     *
     * @param errorMessage the error message
     */
    public MissingDataException(String errorMessage) {
        super(errorMessage);
    }
}
