package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("DMK ");
        student.setGroup("2-nd group ");
        student.setDate(new Date(999989568868L));
        System.out.println(student.getName() + student.getGroup() + student.getDate());
    }
}
