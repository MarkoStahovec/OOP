package project.Exceptions;

/**
 * This Exception is called when incorrect input in one of textfields occurs.
 */
public class IncorrectInputException extends Exception {
    /**
     * Instantiates a new Incorrect input exception.
     *
     * @param errorMessage the error message
     */
    public IncorrectInputException(String errorMessage) {
        super(errorMessage);
    }
}
