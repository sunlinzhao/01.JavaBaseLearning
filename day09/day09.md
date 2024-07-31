1. Date 类

java.util.Date 表示指定的时间信息，不支持国际化 （“Date不支持国际化”意味着Date类本身不具备根据用户所在地区自动调整日期格式的功能。）

> - new Date(): 当前系统日期和时间
> - new Date(long): 给定日期和时间
>   主要方法:
> - after(Date): 判断当前日期对象是否在给定日期对象之后
> - before(Date): 判断当前日期对象是否在给定日期对象之前
> - equals(0bject): 判断两个日期是否相等
> - compareTo(Date): 比较两个日期的顺序，如果当前日期对象大于给定日期对象，返回正数，如果小于给定日期对象，返回负数，如果等于给定日期对象，返回零

```java
public class TestDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date); // CST : Chinese Standard Time
        System.out.println(date.toLocaleString());

        Date date1 = new Date(System.currentTimeMillis() - 2000);
        Date date2 = new Date(System.currentTimeMillis() + 2000);
        System.out.println(date1.before(date2));
        System.out.println(date2.before(date1));
        System.out.println(date1.after(date2));
        System.out.println(date2.after(date1));
        System.out.println(date.compareTo(date1));
        System.out.println(date.compareTo(date2));
        System.out.println(date1.equals(date2));
        System.out.println(date1.equals(date1));
    }
}
```

2. DateFormat

对日期类进行格化式和解析, DateFormat本身是一个抽象类，实例化的方式:

1️⃣ 一种是通过静态方法的调用, 处理的是长日期和长时间类型

> - getDatelnstance()；
> - getTimelnstance()；
> - getDateTimelnstance()；

2️⃣ 一种是通过创建子类对象

> 创建DateFormat的子类SimpleDateFormat对象，处理的是短日期和短时间类型, 可以自定义格式：
>
> y 年 M 月 d 日 h 时(12) m 分 s 秒 E 星期 H 时(24) a 上/下午 S 毫秒

> 方法:
>
> - format(Date): 将Date类型，格式化成字符串；
> - parse(String): 将字符串解析成 Date 类型；

```java
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        DateFormat f1 = DateFormat.getDateInstance(); // DateFormat 格式化时间，返回的是长日期格式 2024年6月6日 下午10:32:11
        System.out.println(f1.format(date));

        DateFormat f2 = DateFormat.getTimeInstance();
        System.out.println(f2.format(date));

        DateFormat f3 = DateFormat.getDateTimeInstance();
        System.out.println(f3.format(date));

        SimpleDateFormat sf1 = new SimpleDateFormat(); // SimpleDateFormat 格式化时间, 返回的是短日期格式 2024/6/6 下午10:32
        System.out.println(sf1.format(date));

        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss"); // 根据给定模式字符pattern格式化字符串
        System.out.println(sf2.format(date));

        SimpleDateFormat sf3 = new SimpleDateFormat("yyyy/MM/dd");
        String dstr = "2024/06/07";
        Date date1 = sf3.parse(dstr); // 将字符串解析为日期
        System.out.println(date1);
    }
}
```

3. Calendar 类

java.util.Calendar 一个抽象类

- GregorianCalendar 类 （格里高利历，公历的标准名称 1582年颁布）公历纪元，又称“西元”，1949年9月27日，中国政协通过，采用国际社会通用的西历和西元作业历法和纪年。四年一闰，百年不闰，四百年一大闰。年均长度365天5小时49分12秒，按此计算方式，3000年左右误差一天

```java
public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(); // 抽象类获取实例
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // 一月是0，从0开始计数
        int date = calendar.get(Calendar.DATE);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK); // 周日算第一天
        System.out.println(year + " "  + month + " " + date + " " + weekday);
        calendar.set(2024, Calendar.JULY, 10);
        System.out.println(calendar.get(Calendar.MONTH));

        // Calendar 转 Date
        Date time = calendar.getTime();
        System.out.println(time);

        Date date1 = new Date();
        calendar.setTime(date1);
        // Date 转 Calendar
        int date2 = calendar.get(Calendar.DATE);
        System.out.println(date2);
        // 格里高利历
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.isLeapYear(2024)); // 是否是闰年
    }
}
```


4. Java 8 新增日期工具类 java.time.* 包）

LocalDate: 获取本地日期
LocalTime: 获取本地时间
LocalDateTime: 获取本地日期和时间

```java
public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now(); // 获取系统时间
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate.toString());
        System.out.println(localTime.toString());
        System.out.println(localDateTime.toString());

        LocalDate localDate1 = LocalDate.of(2022, 9, 13);
        System.out.println(localDate1);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfWeek().getValue());

        LocalDate date1 = localDate.withDayOfMonth(10).
                minusWeeks(4).
                withYear(2022); // 修改
        System.out.println(date1);

        System.out.println(localDateTime.plusDays(30)); // 延后30天
        System.out.println(localDateTime.minusDays(30)); // 提前30天
    }
}
```


5. Instant 类

代表时间点

```java
public class TestInstant {
    public static void main(String[] args) {
        Instant instant = Instant.now(); // 获取当前时间点
        System.out.println(instant);
        System.out.println(Instant.MIN); // 最大时间点
        System.out.println(Instant.MAX); // 最小时间点
        long l = instant.toEpochMilli();
        System.out.println(l); // 1970 到目前的毫秒数
        System.out.println(System.currentTimeMillis()); // 1970 到目前的毫秒数

        System.out.println(instant.atOffset(ZoneOffset.of("+8"))); // 东八区
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8))) ; // 东八区
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8)).toLocalDateTime()); // 再转回本地时间
        System.out.println(Instant.ofEpochMilli(System.currentTimeMillis())); // 将时间戳转为Instant
    }
}
```

6. DateTimeFormatter

```java
public class TestDateTimeFormatter {
    public static void main(String[] args) {
        // 将LocalDate 转为String格式
        LocalDateTime date =  LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = dateTimeFormatter.format(date);
        System.out.println(s);

        // 时间戳转字符串日期格式，先转为LocalDateTime, 再转为字符串日期
        long x = Instant.now().toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(x), ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);
        System.out.println(ZoneId.systemDefault()); // 获取系统默认时区
        System.out.println(dateTimeFormatter.format(localDateTime));

        // 将字符串解析为日期
        String ss = "2022-05-01 12:20:30";
        LocalDateTime parse = LocalDateTime.parse(ss, dateTimeFormatter);
        System.out.println(parse);
    }
}
```


7. Period 类

计算两个"日期"之间的间隔，得到的是年月日。假设 2022年9月2日 和 2021年2月1日 去计算得到相关1年7月1天，没有办法知道具体是多少天。

```java
public class TestPeriod {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2022, 8, 13);
        LocalDate date2 = LocalDate.of(2024, 9, 15);

        // 方法 1
        Period between = Period.between(date1, date2);
        System.out.println("year: " + between.getYears());
        System.out.println("month: " + between.getMonths());
        System.out.println("day: " + between.getDays());
        // 方法 2
        System.out.println("days: " + ChronoUnit.DAYS.between(date1, date2));
        System.out.println("years: " + ChronoUnit.YEARS.between(date1, date2));
        System.out.println("months: " + ChronoUnit.MONTHS.between(date1, date2));
        // 方法 3
        System.out.println(date2.toEpochDay() - date1.toEpochDay());
    }
}
```

8. Duration 类

计算两个日期时间的间隔

```java
public class TestDuration {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 1, 10, 10, 10,5);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        // 方式 1
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration.toDays()); // 计算俩个日期相差天数
        System.out.println(duration.toHours()); // 计算俩个日期相差小时
        System.out.println(duration.toSeconds()); // 计算俩个日期相差秒数
        System.out.println(duration.getSeconds()); // 同上
        // 方式 2
        System.out.println(localDateTime1.until(localDateTime2, ChronoUnit.DAYS)); // 计算俩个日期相差天数
        System.out.println(localDateTime1.until(localDateTime2, ChronoUnit.HOURS)); // 计算俩个日期相差小时
        System.out.println(localDateTime1.until(localDateTime2, ChronoUnit.SECONDS)); // 计算俩个日期相差秒数
        // 方式 3
        System.out.println(ChronoUnit.YEARS.between(localDateTime1, localDateTime2));
        System.out.println(ChronoUnit.HOURS.between(localDateTime1, localDateTime2));
        System.out.println(ChronoUnit.DAYS.between(localDateTime1, localDateTime2));
    }
}
```

9. 时间调节器 TemporalAdjuster

一个接口

```java
public class TestTemporalAdjuster {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.with(DayOfWeek.MONDAY); // 获取本周一的时间

        localDateTime2 = localDateTime1.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // 获取下周一的时间
        System.out.println(localDateTime1);
    }
}
```

10. Date 类 （JDK1.8之前）和 LocalDate（JDK1.8之后） 转换

```java
public class Test {
    public static void main(String[] args) {
        LocalDateTime date=LocalDateTime.now();
        ZonedDateTime zonedDateTime = date.atZone(ZoneId.systemDefault());
        Instant instant =zonedDateTime.toInstant();
        Date date1 = Date.from(instant);
        String s= new SimpleDateFormat("yyyy-MM-dd").format(date1);
        System.out.println(s);
    }
}
```
