package pl.sebastiancielma.MyAeroclub.security.exception;

import pl.sebastiancielma.MyAeroclub.common.exception.BuisnessException;

public class RegisterException extends BuisnessException {

    public RegisterException(String message) {
        super(message);
    }
}
