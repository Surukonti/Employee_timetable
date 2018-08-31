package app.springbootdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class StartTimeAlreadyRecordedException extends RuntimeException{


    public StartTimeAlreadyRecordedException(String s) {

        super(s);

    }

}

