package org.yj.java.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        // timeDate.dateTest();
        // timeDate.calendarTest();
        timeDate.dateConvert();
    }

    /**
     * Date类测试
     */
    public void dateTest() {
        System.out.println();
        System.out.println("java java.util.Date测试");

        //直接创建Date对象，默认为当前时刻
        System.out.println();
        Date date = new Date();
        System.out.println(date);

        //Date时间日期比较
        System.out.println();
        System.out.println("时间日期比较:");
        Date now = new Date();
        Date date1 = new Date(now.getTime());
        Date date2 = new Date(now.getTime() - 1000000);
        Date date3 = new Date(now.getTime());
        System.out.println("date1:" + date1);
        System.out.println("date2:" + date2);
        System.out.println("date3:" + date3);
        System.out.println("date1>date2:" + date1.after(date2));
        System.out.println("date1<date2:" + date1.before(date2));
        System.out.println("date1==date3:" + date1.equals(date3));

        // unix时间戳与Date类型之间的转换
        System.out.println();
        System.out.println("unix时间戳与Date类型之间的转换：");
        Long time = System.currentTimeMillis();
        System.out.println("当前时刻的unix时间戳：" + time);
        Date date4 = new Date(time);
        System.out.println("date4:" + date4);
        System.out.println("date4的unix时间戳：" + date4.getTime());
    }

    /**
     * calendar测试
     */
    public void calendarTest() {
        // 注意月份尽量用Calendar中定义的常量，因为Calendar.DECEMBER=11，比12月小了1，很容易出错
        Calendar calendar = new GregorianCalendar(2018, Calendar.DECEMBER, 30, 14, 0, 0);
        // 纪元，GregorianCalendar.AD=1代表公元，GregorianCalendar.BC=0代表公元前
        System.out.println("ERA:" + calendar.get(Calendar.ERA));

        // 年份
        System.out.println("YEAR：" + calendar.get(Calendar.YEAR));

        // 月份
        System.out.println("MONTH：" + calendar.get(Calendar.MONTH));

        // 一年中的第几周,这个值得分两种情况讨论
        // 1.周日为一周第一天的国家：
        // 通过查看日历我们知道2018.12.30为周日，所以是新一周的第一天，
        // 而2019.1.1与2018.12.30在同一周，所以2018.12.30被归到2019年的第1周
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        System.out.println("周日为一周第一天时，WEEK_OF_YEAR：" + calendar.get(Calendar.WEEK_OF_YEAR));
        // 2.周一为一周第一天的国家：
        // 2018.12.30被归到2018年的最后一周，52周
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println("周一为一周第一天时，WEEK_OF_YEAR：" + calendar.get(Calendar.WEEK_OF_YEAR));

        // 一月中的第几周，同理也有两种情况
        // 1.周日为一周第一天的国家：
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        System.out.println("周日为一周第一天时，WEEK_OF_MONTH：" + calendar.get(Calendar.WEEK_OF_MONTH));
        // 2.周一为一周第一天的国家：
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println("周一为一周第一天时，WEEK_OF_MONTH：" + calendar.get(Calendar.WEEK_OF_MONTH));

        // 日期，也就是1月中的第几天
        System.out.println("DATE：" + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH：" + calendar.get(Calendar.DAY_OF_MONTH));

        // 一年中的第几天
        System.out.println("DAY_OF_YEAR：" + calendar.get(Calendar.DAY_OF_YEAR));

        // 星期几
        System.out.println("DAY_OF_WEEK：" + calendar.get(Calendar.DAY_OF_WEEK));

        // 当天处于这个月的第几周，但是要注意的是，这里计算第几周的方式与之前WEEK_OF_MONTH不同，
        // 1.DAY_OF_WEEK_IN_MONTH的计算方式很简单，举例来说12.1-12.7为第一周，以此类推，12.30就是第5周
        // 2.而WEEK_OF_MONTH具体值还与Calendar.firstDayOfWeek有关，举例来说2018.12.1日是周六。
        // 如果是周日为一周第一天的国家：那么12月的第1周只有12.1日一天，以此类推，12.30为12月的第6周
        // 如果是周一为一周第一天的国家：那么12月的第1周就是12.1-12.2，以此类推，12.30为12月的第5周
        System.out.println("DAY_OF_WEEK_IN_MONTH：" + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        // 早上还是下午,Calendar.AM=0上午，Calendar.PM=1下午
        System.out.println("AM_PM：" + calendar.get(Calendar.AM_PM));

        // 时，12小时制
        System.out.println("HOUR：" + calendar.get(Calendar.HOUR));

        // 时，24小时制
        System.out.println("HOUR_OF_DAY：" + calendar.get(Calendar.HOUR_OF_DAY));

        // 分
        System.out.println("MINUTE：" + calendar.get(Calendar.MINUTE));

        // 秒
        System.out.println("SECOND：" + calendar.get(Calendar.SECOND));

        // 毫秒
        System.out.println("MILLISECOND：" + calendar.get(Calendar.MILLISECOND));

        // 时区导致的时间偏移量，比如东八区，+8小时，ZONE_OFFSET=28800000毫秒
        System.out.println("ZONE_OFFSET：" + calendar.get(Calendar.ZONE_OFFSET));
    }

    /**
     * Date、格式化输出、Calendar之间相互转化
     */
    public void dateConvert() {
        System.out.println();
        System.out.println("java Date、格式化输出、Calendar之间相互转化测试");

        System.out.println();
        System.out.println("Date格式化输出");
        Calendar calendar = new GregorianCalendar(2018, Calendar.DECEMBER, 30, 0, 0, 0);
        Date date = calendar.getTime();
        // W和F的区别同Calendar中WEEK_OF_MONTH和DAY_OF_WEEK_IN_MONTH的区别
        // H(0~23小时)，h(am/pm中的1~12小时)，K(am/pm中的0~11小时)，k(1~24小时)
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SSS毫秒，一年中的ww周,"
            + "一月中的WW周，一年中的DDD天，一月中的FF周，星期：E，上午下午：a,k时，K时，h时，时区：z，时区：Z");
        // Date格式化输出
        System.out.println(df.format(date));

        System.out.println();
        System.out.println("字符串转Date测试");
        String time = "2018-12-30";
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = df1.parse(time);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println();
        Date date3 = new Date();
        Calendar calendar3 = Calendar.getInstance();
        // Date转Calendar
        calendar3.setTime(date3);
        System.out.println("Date转Calendar");
        System.out.println(calendar3);
        // Calendar转Date
        Date date33 = calendar3.getTime();
        System.out.println("Calendar转Date");
        System.out.println(date33);
    }
}
