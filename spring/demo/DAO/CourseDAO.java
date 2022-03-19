package com.example.demo.DAO;

import com.example.demo.Entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDAO extends JpaRepository<Course,Integer> {
    @Query(value = "select count(sno) from course_Selection where cno in ("+
                "select cno from course where cname=:cname)",nativeQuery = true)
    Integer findNumberByCname(@Param(value="cname") String cname);

}
