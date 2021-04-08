package com.zhenhao.clone;


/**
 * Created by zhenhao on 2021/4/8 14:28
 * Content:
 */
public class ShadowClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        /**
         * 以下是浅拷贝的方式,浅拷贝主要是说按照值传递
         */
        Student student = new Student(20,"zhangsan");
        Student student1 = (Student) student.clone();
        student1.setAge(10);
        student1.setName("lisi");
        System.out.println(student);
        System.out.println(student1);
        System.out.println("*******************************************");
        /**
         * 以下是深拷贝的方式
         */

        Student s1 = new Student(10,"s1");
        Teacher t1 = new Teacher();
        t1.setStudent(s1);
        t1.setName("t1");

        Teacher t2 = (Teacher) t1.clone();
        t2.setName("t2");
        Student s2 = new Student(11,"s2");
        t2.setStudent(s2);
        System.out.println(t1);
        System.out.println(t2);







    }


}

/**
 * 浅拷贝所用类
 */
class Student implements Cloneable{

    private int age;
    private String name;


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class Teacher implements Cloneable{

    private String name;

    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", student=" + student +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        /**
         * 方式1：浅拷贝
         *  super.clone();
         */



        /**
         * 方式2 使用深拷贝,目前测试使用的是深拷贝
         */
        Teacher teacher = (Teacher) super.clone();
        teacher.setStudent((Student) teacher.getStudent().clone());
        return teacher;
    }


}
