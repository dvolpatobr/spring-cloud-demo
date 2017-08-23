package br.com.volpato.springcloud.handle;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.volpato.springcloud.exception.MainframeDataNotFoundException;

@RestControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(MainframeDataNotFoundException.class)
	public ResponseMsg handleMainframeDataNotFoundException(MainframeDataNotFoundException ex, HttpServletResponse responseHTTP, HttpServletRequest requestHTTP) {
		ResponseMsg responseMsg = new ResponseMsg();
		responseMsg.setError(ex.getError());
		responseMsg.setMessage(ex.getMessage());
		responseMsg.setStatus(HttpStatus.BAD_REQUEST.value());
		responseMsg.setPath(requestHTTP.getRequestURI());
		responseMsg.setException(ex.getClass().getName());
		responseMsg.setTimestamp(new Date(System.currentTimeMillis()));
		responseHTTP.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return responseMsg;
	}
	
}
