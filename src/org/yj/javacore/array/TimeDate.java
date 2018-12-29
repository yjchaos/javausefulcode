package org.yj.javacore.array;

import java.util.Date;

/**
 * java时间日期类测试
 *
 * java.util.TimeZone                                    java.sql.Time
 *      |                                                     |
 *      |                                                    \|/
 * java.util.Calendar   ------------------------------  java.util.Date  ------------------------------- java.text.DateFormat
 *     /|\                                              /|\        /|\                                           |
 *      |                                                |          |                                            |
 * java.util.GregorianCalendar                java.sql.TimeStamp  java.sql.Date                       java.text.SimpleDataFormat
 *
 * @author yaojun
 * @version 1.0
 * @date 2018/12/29 14:45
 */
public class TimeDate {
    public static void main(String[] args) {
        System.out.println("java 时间日期测试");
        TimeDate timeDate = new TimeDate();
        timeDate.dateTest();
    }

    public void dateTest() {
        System.out.println();
        System.out.println("java java.util.Date测试");
        //直接创建Date对象，默认为当前时刻
        Date date = new Date();
        System.out.println(date);
        //Date时间日期比较
    }
}
