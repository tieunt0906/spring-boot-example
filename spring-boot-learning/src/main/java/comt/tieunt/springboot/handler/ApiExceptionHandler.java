package comt.tieunt.springboot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import comt.tieunt.springboot.model.ErrorMessage;

@RestControllerAdvice
public class ApiExceptionHandler {
	/**
	 * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleAllException(Exception ex, WebRequest request) {
		return new ErrorMessage(10000, ex.getLocalizedMessage());
	}

	/**
	 * IndexOutOfBoundsException se dc xu ly tai day
	 */
	@ExceptionHandler(IndexOutOfBoundsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage TodoException(Exception ex, WebRequest request) {
		return new ErrorMessage(10100, "Doi tuong khong ton tai");
	}
}
