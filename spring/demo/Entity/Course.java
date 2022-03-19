package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="course")
public class Course {
    @Id
    @Column(name="cno")
    private String cno;
    @Column(name="cname")
    private String cname;
    @Column(name="credit")
    private String credit;
    @Column(name="semester")
    private String semester;

    public Course() {
    }

    public Course(String cno, String cname, String credit, String semester) {
        this.cno = cno;
        this.cname = cname;
        this.credit = credit;
        this.semester = semester;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", credit='" + credit + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
