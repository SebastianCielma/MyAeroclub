package pl.sebastiancielma.MyAeroclub.common.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class BuisnessException extends RuntimeException {
    public BuisnessException(String message) {
        super(message);
    }
}
