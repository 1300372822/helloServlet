package com.sgg.JUC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateDemo {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 线程安全的 DateTimeFormatter
     * 推荐使用，因为该类是不可变的，并且是线程安全的
     */
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    String dateStr = "2019-04-16 10:26:30";
                    // 解决方法
                    // 1、可以只在需要时创建对象，也可以避免错误，但是频繁创建与销毁会导致额外的开销，性能低
//                    SimpleDateFormat newInNeed = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    for(int j = 0; j < 10; j++){
//
//                        try {
                        // 直接使用不但运行结果错误，最后还会抛出 NumberFormatException: 异常
//                        try {
//                            System.out.println(format.parse(dateStr));
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }

                        // 2、使用加了 synchronized 的同步方法，但是并发量高时，性能影响大，线程阻塞
//                            System.out.println(ConcurrentDateFormat.parse(dateStr));

                        // 3、使用 ThreadLocal 来解决，比较优雅的一种做法
//                            System.out.println(ThreadLocalDateFormat.parse(dateStr));

//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
                        // 4、使用DateFormatter，该类是线程安全的，可以放心使用
                        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, dtf);
                        System.out.println(localDateTime);
                    }
                }
            });
        }
    }
}
