package com.sxt.controller;

import com.sxt.compment.GlobalExceptionHandler;
import com.sxt.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(description = "集成swagger用户管理",consumes="aaa",produces="bbb",value="cccc")
@RestController
@RequestMapping("user")
public class ApiUserController {

    @ApiOperation(value = "查询一个用户")
//    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "整数",dataType = "整数")})
    @GetMapping("queryOneUser")
    public String queryOne(@NotNull(message = "id不能为空") @RequestParam Integer id) {
        return "success";
    }

    @ApiOperation(value = "查询全部用户")
    @GetMapping("queryAllUser")
    public String queryAll() {
        return "success";
    }

    @ApiOperation(value = "新增用户")
//    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "整数",dataType = "整数"),
//                                @ApiImplicitParam(name = "name",value = "用户姓名",required = true,dataType = "字符串",paramType = "新增")})
    @PostMapping("inserUser")
    public String inserUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }else{
            return "success";
        }
    }

    @ApiOperation(value = "删除用户")
//    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "整数",dataType = "整数")})
    @DeleteMapping("deleteUser")
    public String deleteUser(@NotNull(message = "id不能为空") @RequestParam Integer id) {
        return "success";
    }

    @ApiOperation(value = "更新用户")
//    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "整数",dataType = "整数"),
//            @ApiImplicitParam(name = "name",value = "用户姓名",required = true,dataType = "字符串",paramType = "新增")})
    @PutMapping("updateUser")
    public String updateUser(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }else{
            return "success";
        }
//        return "success";
    }

}
