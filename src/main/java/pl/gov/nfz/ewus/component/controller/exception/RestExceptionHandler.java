package pl.gov.nfz.ewus.component.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pl.gov.nfz.ewus.exception.ErrorResponse;
import pl.gov.nfz.ewus.exception.NoSuchPersonException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NoSuchPersonException.class)
	public ResponseEntity<ErrorResponse> handleException(Throwable e) {
		ErrorResponse error = new ErrorResponse();
		error.setCode(-200);
		error.setMessage("No such person!");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
