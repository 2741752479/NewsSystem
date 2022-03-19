package com.example.demo;

import com.example.demo.DAO.CourseDAO;
import com.example.demo.DAO.CourseSelectionDAO;
import com.example.demo.DAO.StudentDAO;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.CourseSelection;
import com.example.demo.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Scanner;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    CourseSelectionDAO courseSelectionDAO;
    @Autowired
    CourseDAO courseDAO;

    @Test
   void contextLoads() {//查找操作
        Student students = studentDAO.findAllBySexAndSname("男", "宋文卓");//通过对应字段查找student表,其中这个方法要在DAO层定义
        //这里我也不晓得，直接alt+enter就不报错了
        List<Student> student = studentDAO.findAll();//查student表所以信息
        System.out.println(students);
        System.out.println(student);
    }
     /*   void contextfind(){//多表查询
        List<CourseSelection>courseSelection=courseSelectionDAO.findCourseByName("宋文卓");
        System.out.println(courseSelection);
    }*/
   /* void contextnum(){//根据课程名字找人数
        List<Integer> courses = courseDAO.findNumberByCname("计算机导论");
        System.out.println(courses);
    }*/
    ////////////////////////////////////////////////
  /* @Test
    void contextadd(){//增加数据
        Student student=new Student("12345","crab","啊","998");//也可以用list
        studentDAO.save(student);//在数据库中增加数据
    }*/
   /* void contestdelete(){
        Student student=new Student("12345","crab","啊","998");
        studentDAO.delete(student);//删除对应列
    }*/
}