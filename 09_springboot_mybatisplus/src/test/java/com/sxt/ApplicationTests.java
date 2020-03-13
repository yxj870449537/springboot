package com.sxt;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.dao.UserDao;
import com.sxt.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.Date;
import java.util.List;

@SpringBootTest
@MapperScan(basePackages= {"com.sxt.dao"})
class ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao);
    }
    @Test
    public void addUser() {
        userDao.insert(new User( null, "小明","男", 18, new Date(), "武汉", "abc123456"));
    }
    /*@Test
    public void queryForPage(){
        IPage<User> page=new Page<>(1, 5);
        userDao.selectPage(page,null);
        List<User> users = page.getRecords();
        for (User user:users){
            System.out.println(user);
        }
        System.out.println("总条数"+page.getTotal());
    }*/
}
