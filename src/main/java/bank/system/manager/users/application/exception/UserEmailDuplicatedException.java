package bank.system.manager.users.application.exception;

public class UserEmailDuplicatedException extends RuntimeException {
    public UserEmailDuplicatedException(String message) {
        super(message);
    }
}
