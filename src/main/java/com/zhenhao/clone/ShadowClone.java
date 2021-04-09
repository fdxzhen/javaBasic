package com.zhenhao.clone;


/**
 * Created by zhenhao on 2021/4/8 14:28
 * Content:参考文章：https://www.cnblogs.com/vipstone/p/11539689.html
 * 1.使用克隆有什么好处？
 * 答：好处包含以下几点：
 * 使用方便：假如要复制一个对象，但这个对象中的部分属性已经被修改过了，如果不使用克隆的话，需要给属性手动赋值，相比克隆而已麻烦很多；
 * 性能高：查看 clone 方法可以知道，它是 native 方法，native 方法是原生函数，使用操作系统底层的语言实现的，因此执行效率更高；
 * 隔离性：克隆可以确保对象操作时相互隔离。
 * 2.浅克隆和深克隆有什么区别？
 * 答：区别主要在对引用类型的复制上，具体信息如下：
 * 浅克隆：只会复制对象的值类型，而不会复制对象的引用类型；
 * 深克隆：复制整个对象，包含值类型和引用类型。
 * 3.如何实现浅克隆？
 * 答：克隆的对象实现 Cloneable 接口，并重写 clone() 方法就可以实现浅克隆了。
 * 5.深克隆如何实现？有几种实现方式？
 * 答：一般实现方式有以下两种：
 * 通过序列化实现深克隆（序列化实现方式：Java 原生序列化、JSON 序列化、Hessian 序列化）；
 * 所有引用类型都实现克隆，从而实现深克隆。
 * 6.为什么不能直接使用 Object 的 Clone 方法，还要重写 clone() 方法之后才能实现克隆？
 * 答：虽然所有类都是 Object 的子类，但因为 Object 中的 clone() 方法被声明为 protected 访问级别，所以非 java.lang 包下的其他类是不能直接使用的。因此要想实现克隆功能，就必须实现 Cloneable，并重写 clone() 方法才行。
 * 7.序列化可不可以实现深克隆？实现的原理是什么？
 * 答：先将原对象序列化到内存的字节流中，再从字节流中反序列化出刚刚存储的对象，这个新对象和原对象就不存在任何地址上的共享，这样就实现了深克隆。
 */
public class ShadowClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        /**
         * 以下是浅拷贝的方式,浅拷贝主要是说按照值传递
         */
        Student student = new Student(20, "zhangsan");
        Student student1 = (Student) student.clone();
        student1.setAge(10);
        student1.setName("lisi");
        System.out.println(student);
        System.out.println(student1);
        System.out.println("*******************************************");
        /**
         * 以下是深拷贝的方式
         */

        Student s1 = new Student(10, "s1");
        Teacher t1 = new Teacher();
        t1.setStudent(s1);
        t1.setName("t1");

        Teacher t2 = (Teacher) t1.clone();
        t2.setName("t2");
        Student s2 = new Student(11, "s2");
        t2.setStudent(s2);
        System.out.println(t1);
        System.out.println(t2);
    }
}

/**
 * 浅拷贝所用类
 */
class Student implements Cloneable {

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


class Teacher implements Cloneable {

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
