package com.sxt.controller;

import com.sxt.entity.User;
import com.sxt.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-11 09:14:02
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return userService.queryById(id);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    @PostMapping("insertUser")
    public int insertUser(User user){
        return userService.insert(user);
    }
    /**
     * 删除数据
     *
     * @param
     * @return 实例对象
     */
    @DeleteMapping("deleteUser")
    public int deleteUser(int id){
        return userService.deleteById(id);
    }
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @PutMapping("updateUser")
    public int update(User user){
        return userService.update(user);
    }
}