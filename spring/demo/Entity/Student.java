package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//实体层，用来存放与数据库中表相对应的实体类，类中的变量与数据库对应表的字段保持一致。
@Entity(name = "student")//注解，没有注解，就只是普通对象，要用注解与数据库构建联系。并且先给表名(与数据库的表对应)，完成表的对应,与数据库中的表建立联系
public class Student {
    @Id //在主键上面添加主键注解
    @Column(name = "sno")//完成每列字段上的对应,用来标识实体类中属性与数据表中字段的对应关系
    private String sno;
    @Column(name = "sname")
    private String sname;
    @Column(name = "sex")
    private String sex;
    @Column(name = "classno")
    private String classNo;

    public Student() {
    }

    public Student(String sno, String sname, String sex, String classNo) {
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
        this.classNo = classNo;
    }
    //还需要get，set方法完成自动注入的过程，必须要有
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return "Student{" +             
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", classNo='" + classNo + '\'' +
                '}';
    }
}
