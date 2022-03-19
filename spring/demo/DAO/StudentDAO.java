package com.example.demo.DAO;
//jpa:
//数据访问层，用来封装对数据库的增删改查操作，而不涉及具体的需求逻辑，方便不同的需求任务来复用对数
import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// //帮助将类函数送到工厂里面.让spring在初始化时，往容器中添加该对象的一个实例，之后通过自动注入等方式可以引用该实例，不
public interface StudentDAO extends JpaRepository<Student,Integer> {//与Entity层对应.   继承jpa仓库，jpa反射机制：把类似jdbc那些操作包装起来
   Student findAllBySexAndSname(String sex, String sname);//通过这个函数，可以根据sex,name字段查找Student表中的内容
    //相当于SELECT*FROM student WHERE sex=:sex
}


