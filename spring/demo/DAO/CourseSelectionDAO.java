package com.example.demo.DAO;

import com.example.demo.Entity.CourseSelection;
import com.example.demo.Entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseSelectionDAO extends JpaRepository<CourseSelection,Integer> {

    //@Query当需要复杂查询时，JPA中通过定义抽象函数，让JPA自动实现的方法便不适用，这时通过该注解，可实现较复杂的操作
   //如现在进行多表查询
    @Query(value = "select *from course_Selection where sno in (" +
            "select sno from student where sname=:sname)",nativeQuery=true)//value为编写的sql语句，nativeQuery为原生sql或jpa版本
    CourseSelection findCourseByName(@Param(value = "sname") String sname);
}
