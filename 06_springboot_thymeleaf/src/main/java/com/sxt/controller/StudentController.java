package com.sxt.controller;

import com.sxt.entity.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("index")
public class StudentController {
    /**
     * 跳转到helle.html
     */
    @RequestMapping("hello")
    public String hello(Model model) {
        return "hello";
    }

    /**
     *跳转到showOneStudent.html
     */
    @RequestMapping("showOneStudent")
    public String showOneStudent(Model model){
        return "showOneStudent";
    }

    /**
     *跳转到showAllStudent.html
     */
    @RequestMapping("showAllStudent")
    public String showAllStudent(Model model){
        List<Student> students = new ArrayList<>();
        for (int i=1; i<=5; i++){
            students.add(new Student(i,"小明"+i,"北京",i%2==0?"男":"女",
                    "1341112211"+i,22+i, new Date()));
        }
        model.addAttribute("students",students);
        return "showAllStudent";
    }

    /**
     * 跳转到showOneStudentModel.html
     */
    @RequestMapping("showOneStudentModel")
    public String showOneStudentModel(Model model){
        Student student = new Student(1, "张三", "北京", "男", "13411133111",22, new Date());
        model.addAttribute("student",student);
        return "showOneStudentModel";
    }
    /**
     * 跳转到showAllStudentModel.html
     */
    @RequestMapping("showAllStudentModel")
    public String ShowAllStudentModel(Model model){
        List<Student> list = new ArrayList<>();
        for (int i = 1; i <=10; i++)
        {
            list.add(new Student(i, "张三"+i, "北京"+i, "男", "13411133111",i+10, new Date()));
        }
        model.addAttribute("list",list);
        model.addAttribute("username","超级管理员");
        model.addAttribute("userage",99);
        return "showAllStudentModel";
    }
    /**
     * 跳转到showObject.html
     */
    @RequestMapping("showObject")
    public String showObject(HttpServletRequest request, HttpSession session){
        ServletContext context = request.getServletContext();
        request.setAttribute("req_name","张三_req");
        request.setAttribute("session_name","张三_session");
        context.setAttribute("context_name","张三_context");
        return "showObject";
    }
}
