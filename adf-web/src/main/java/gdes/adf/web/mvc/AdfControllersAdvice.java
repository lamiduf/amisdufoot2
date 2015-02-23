package gdes.adf.web.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdfControllersAdvice {

	public static final Logger LOG = LoggerFactory
			.getLogger(AdfControllersAdvice.class);

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public  @ResponseBody String   handleIllegalArgumentException(IllegalArgumentException e) {
	     return e.getMessage();		
	}


}
