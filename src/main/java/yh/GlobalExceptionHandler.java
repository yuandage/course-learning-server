package yh;

import yh.common.Result;
import yh.common.StatusCode;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        //e.printStackTrace(); //追踪错误信息
        System.out.println(e.getMessage());
        if (e.getMessage().equals("权限不足!")||e.getMessage().equals("令牌不正确!")){
            return new Result(false, StatusCode.ACCESS_ERROR,e.getMessage());
        }
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
