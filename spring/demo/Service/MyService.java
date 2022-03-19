package com.example.demo.Service;

import com.example.demo.DAO.CourseDAO;
import com.example.demo.DAO.CourseSelectionDAO;
import com.example.demo.DAO.StudentDAO;
import com.example.demo.Entity.CourseSelection;
import com.example.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//在service层实现对应，分别构建成一个服务函数供controller调用，实现功能函数
@Service
public class MyService {
    private StudentDAO studentDAO;
    private CourseSelectionDAO courseSelectionDAO;
    private CourseDAO courseDAO;
    @Autowired
    public MyService(StudentDAO studentDAO, CourseSelectionDAO courseSelectionDAO, CourseDAO courseDAO) {
        this.studentDAO = studentDAO;
        this.courseSelectionDAO = courseSelectionDAO;
        this.courseDAO = courseDAO;
    }
    public Student contextLoads(String sex,String sname){
        Student students = studentDAO.findAllBySexAndSname(sex, sname);//通过对应字段查找student表,其中这个方法要在DAO层定义
      //  List<Student> student = studentDAO.findAll();//查student表所有信息
       // System.out.println(students);
      //  System.out.println(student);
       Student stu=new Student(students.getSno(),students.getSname(),students.getSex(),students.getClassNo());
        return stu;
    }
   public CourseSelection contextfind(String sname) {//多表查询
       CourseSelection courseSelection = courseSelectionDAO.findCourseByName(sname);
       CourseSelection cor=new CourseSelection(courseSelection.getSno(),courseSelection.getCno(),courseSelection.getGrade());
       //System.out.println(courseSelection);
       return courseSelection;
   }
   public void contextadd(String sno,String sname,String sex,String classNo){//录入数据
        Student student=new Student(sno,sname,sex,classNo);//也可以用list
        studentDAO.save(student);//在数据库中增加数据
    }
    public Integer contextnum(String cname){//根据课程名字找人数
        Integer courses = courseDAO.findNumberByCname(cname);
        return courses;
    }
}
