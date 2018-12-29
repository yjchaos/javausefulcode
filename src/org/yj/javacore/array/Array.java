package org.yj.javacore.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * java数组相关常用代码
 * @author yaojun
 * @version 1.0
 * @date 2018/12/26 11:06
 */
public class Array {

    private int[] intArray = new int[]{1, 2, 3, 4, 5, 6};

    private int[] intArray1 = new int[]{1, 8, 3, 9, 2, 7, 4, 6, 5, 0};

    private Student[] students = new Student[]{
            new Student("yi", 10), new Student("er", 8),
            new Student("san", 15), new Student("si", 7), new Student("wu", 11)
    };

    private Student[] students1 = new Student[]{
            new Student("yi", 10), new Student("er", 8),
            new Student("san", 15), new Student("si", 7),
            new Student("wu", 11),new Student("liu", 7),
            new Student("qi", 15)
    };

    public static void main(String[] args) {
        System.out.println("java 数组测试");
        Array array = new Array();
//        array.arrayCopy();
//        array.arraySort();
        array.arraySortAdvance();
    }

    /**
     * 数组拷贝
     */
    private void arrayCopy() {
        System.out.println("原数组:" + Arrays.toString(intArray));
        int[] newIntArray = new int[intArray.length];
        System.arraycopy(intArray, 0, newIntArray, 0, intArray.length);
        System.out.println("新数组:" + Arrays.toString(newIntArray));
    }

    /**
     * 数组排序(简单排序)
     * 1.基本类型及其包装类型的数组排序直接用Arrays.sort()就行，结果直接作用与原数组，排序方式根据基本类型的不同而不同，默认升序排列
     * 2.引用数据类型的数组排序：
     *      1).实现Comparable接口
     *      2).Comparator,更加灵活，可以实现各种排序需求
     */
    private void arraySort() {
        System.out.println("基本类型数组排序");
        System.out.println("原数组:" + Arrays.toString(intArray1));
        Arrays.sort(intArray1);
        System.out.println("排序后数组：" + Arrays.toString(intArray1));

        System.out.println();
        System.out.println("引用类型数组排序Comparator");
        //为了不影响原数组，我们拷贝一份
        Student[] studentsCopy = new Student[students.length];
        System.arraycopy(students, 0, studentsCopy, 0, students.length);
        System.out.println("原数组:" + Arrays.toString(studentsCopy));

        //写法1：匿名内部类实现Comparator接口的compare方法
        Arrays.sort(studentsCopy, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });

        //写法2：java8 之后可以使用函数式编程将上述代码简化，可以看到函数式编程的一个作用：
        // 对于函数式接口，我们不必再创建匿名内部类对象去实现接口的方法，直接使用lambda表达式即可
        Arrays.sort(studentsCopy, (o1, o2) -> Integer.compare(o1.age, o2.age));
        //还可以进一步改写，这种方式我觉得只是语义上更加清晰，本质上和上面的写法并无差别
        Arrays.sort(studentsCopy, Comparator.comparingInt(student -> student.age));

        System.out.println("按年龄升序排列后：" + Arrays.toString(studentsCopy));

        System.out.println();
        System.out.println("引用类型数组排序Comparable");
        //为了不影响原数组，我们拷贝一份
        System.arraycopy(students, 0, studentsCopy, 0, students.length);
        System.out.println("原数组:" + Arrays.toString(studentsCopy));
        Arrays.sort(studentsCopy);
        System.out.println("按年龄升序排列后：" + Arrays.toString(studentsCopy));
    }

    /**
     * 数组排序(多重排序)，只有引用类型可能会有多重排序排序的方式依旧是两种：
     *      1).Comparator
     *      2).Comparable
     */
    private void arraySortAdvance() {
        System.out.println();
        //学生优先按年龄排序，年龄一样按名字字典序
        Student[] studentsCopy = new Student[students1.length];
        System.arraycopy(students1, 0, studentsCopy, 0, students1.length);
        System.out.println("原数组:" + Arrays.toString(studentsCopy));

        //写法1：实现Comparator接口的compare方法
        Arrays.sort(studentsCopy, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.name.compareTo(o2.name);
            }else{
                return Integer.compare(o1.age, o2.age);
            }
        });

        //写法2：用thenComparing
        Arrays.sort(studentsCopy, Comparator.comparingInt((Student s) -> s.age).thenComparing((Student s) -> s.name));

        //写法3：引用类实现Comparable接口，略，适用性比较差
        System.out.println("优先按年龄排序，年龄一样按名字字典序排序后：" + Arrays.toString(studentsCopy));
    }
}

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }
}
