package com.zhenhao.clone;


/**
 * Created by zhenhao on 2021/4/8 14:28
 * Content:
 */
public class ShadowClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        /**
         * ������ǳ�����ķ�ʽ,ǳ������Ҫ��˵����ֵ����
         */
        Student student = new Student(20,"zhangsan");
        Student student1 = (Student) student.clone();
        student1.setAge(10);
        student1.setName("lisi");
        System.out.println(student);
        System.out.println(student1);
        System.out.println("*******************************************");
        /**
         * ����������ķ�ʽ
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
 * ǳ����������
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
         * ��ʽ1��ǳ����
         *  super.clone();
         */



        /**
         * ��ʽ2 ʹ�����,Ŀǰ����ʹ�õ������
         */
        Teacher teacher = (Teacher) super.clone();
        teacher.setStudent((Student) teacher.getStudent().clone());
        return teacher;
    }


}
