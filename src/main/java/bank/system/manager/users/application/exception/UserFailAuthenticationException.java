package bank.system.manager.users.application.exception;

public class UserFailAuthenticationException extends RuntimeException {
    public UserFailAuthenticationException(String message) {
        super(message);
    }
}
