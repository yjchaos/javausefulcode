package org.yj.java.core.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 对象流(处理流):
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有的对象都可以序列化Serializable
 *
 * @author yaojun
 * @version 1.0
 * @date 2019/2/4 13:50
 **/
public class ObjectTest {
    public static void main(String[] args) {
        System.out.println("对象流测试:");
        ObjectTest objectTest = new ObjectTest();
        objectTest.test();
    }

    public void test() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeUTF("编码辛酸泪");
            oos.writeInt(18);
            oos.writeBoolean(false);
            oos.writeChar('a');

            oos.writeObject("谁解其中味");
            oos.writeObject(new Date());
            Employee emp = new Employee("yaojun", 15000);
            oos.writeObject(emp);
            oos.flush();

            byte[] data = baos.toByteArray();
            System.out.println(data.length);

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            String msg = ois.readUTF();
            int age = ois.readInt();
            boolean flag = ois.readBoolean();
            char ch = ois.readChar();
            Object str = ois.readObject();
            Object date = ois.readObject();
            Object employee = ois.readObject();
            System.out.println(msg);
            System.out.println(age);
            System.out.println(flag);
            System.out.println(ch);
            if (str instanceof String) {
                String strObj = (String) str;
                System.out.println(strObj);
            }
            if (date instanceof Date) {
                Date dateObj = (Date) date;
                System.out.println(dateObj);
            }
            if (employee instanceof Employee) {
                Employee employeeObj = (Employee) employee;
                System.out.println(employeeObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}

/**
 * javabean 封装数据
 */
class Employee implements java.io.Serializable{
    /**
     * 该数据不需要序列化
     */
    private transient String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
