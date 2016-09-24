package pl.gov.nfz.ewus.component.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pl.gov.nfz.ewus.exception.AmbiguousPeselException;
import pl.gov.nfz.ewus.exception.ErrorResponse;
import pl.gov.nfz.ewus.exception.IllegalPeselNumberException;
import pl.gov.nfz.ewus.exception.NoSuchPersonException;

@RestControllerAdvice
public class RESTExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleException(Throwable e) {

		ErrorResponse error = new ErrorResponse();

		if (e instanceof NoSuchPersonException) {
			error.setCode(-200);
		}

		if (e instanceof IllegalPeselNumberException) {
			error.setCode(-201);
		}
		
		if (e instanceof AmbiguousPeselException) {
			error.setCode(-202);
		}

		error.setMessage(e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
