package com.sxt.compment;

import com.sxt.vo.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RestControllerAdvice/*(basePackages = {"com.sxt.controller.UserController"})*/
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    /*@ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(Exception e) throws Exception {
        LOGGER.error(e.getMessage(), e);
//        由于Exception是异常的父类，如果你的项目中出现过在自定义异常中使用@ResponseStatus的情况，
//        你的初衷是碰到那个自定义异常响应对应的状态码，而这个控制器增强处理类，会首先进入，并直接
//        返回，不会再有@ResponseStatus的事情了，这里为了解决这种纰漏，我提供了一种解决方式。
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("Error Message: ", e.getMessage());
        return result;
    }*/

   /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    /*@ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    public Map<String, Object> handleBusinessException(UserNotExistException e) {
        LOGGER.error(e.getMessage(), e);

        Map<String, Object> result = new HashMap<>();
        result.put("Error Message: ", e.getMessage());
        return result;
    }*/

    /**
     * 处理所有接口数据验证异常
     * @param e
     * @return
     */
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        LOGGER.error(e.getMessage(), e);

        Map<String, Object> result = new HashMap<>();
        String messages = "";
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            messages += objectError.getDefaultMessage() + ",";
        }

        result.put("Error Message: ", messages);
        return result;
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo<?> validationErrorHandler(MethodArgumentNotValidException ex) {
        // 同样是获取BindingResult对象，然后获取其中的错误信息
        // 如果前面开启了fail_fast，事实上这里只会有一个信息
        //如果没有，则可能又多个
        List<String> errorInformation = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResultInfo<>(400, errorInformation.toString(), null);
    }
}
