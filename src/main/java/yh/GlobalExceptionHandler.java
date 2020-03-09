package yh;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import yh.common.Result;
import yh.common.StatusCode;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Result exception(Exception e) {
		e.printStackTrace();//追踪错误信息
		return new Result(false, StatusCode.ERROR, "发生了错误!",e.getMessage());
	}

	@ExceptionHandler(AccessDeniedException.class)
	public Result handleAccessException(AccessDeniedException e) {
		return new Result(false, StatusCode.ACCESS_ERROR, "权限不足!", e.getMessage());
	}

}
