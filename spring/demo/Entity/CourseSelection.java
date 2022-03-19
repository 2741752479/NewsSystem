package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "course_Selection")
public class CourseSelection {
    @Id
    @Column(name = "sno")
    private String sno;
    @Column(name = "cno")
    private String cno;
    @Column(name = "grade")
    private String grade;

    public CourseSelection() {
    }

    public CourseSelection(String sno, String cno, String grade) {
        this.sno = sno;
        this.cno = cno;
        this.grade = grade;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseSelection{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
