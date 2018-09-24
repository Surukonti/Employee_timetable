package app.springbootdemo.login;

public class UsernameAlreadyExistsException extends Throwable {
    public UsernameAlreadyExistsException(String s) {

        super(s);
    }
}
