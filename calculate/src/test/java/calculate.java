import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

/**
 * @Author wangjia
 * @Date 2022/4/28
 */
public class calculate {

    private static String nanosToSeconds(double duration) {
        double timeSeconds = formatData(3, duration);
        System.out.println("共" + timeSeconds  + "秒");
        long hour, minute, sec;
        if (timeSeconds >= 60) {
            minute = (long)timeSeconds / 60;
            if (minute >= 60) {
                hour = minute / 60;
                minute = minute % 60;
                sec = (long)formatData(0,timeSeconds - ((hour * 60 * 60) + (minute * 60)));
                return hour + "时" + minute + "分" + sec + "秒";
            }
            sec = (long)timeSeconds % 60;
            return minute + "分" + sec + "秒";
        }
        return timeSeconds + "秒";
    }


    private static double formatData(int num, double data) {
        BigDecimal bigDecimal = new BigDecimal(data);
        return bigDecimal.setScale(num, RoundingMode.HALF_UP).doubleValue();
    }


    public static void main(String[] args) throws ParseException {

        long l = System.nanoTime();
        int j  = 0;
        for (int i = 0;i < 1100; i ++) {
            j += 1;
        }
        long l1 = System.nanoTime();
        long l2 = l1 - l;
        System.out.println("共" + l + "纳秒");
        System.out.println(nanosToSeconds(l /1.0E9D));



        System.out.println(nanosToSeconds(91451231));
        System.out.println(nanosToSeconds(3145));



        System.out.println(nanosToSeconds(23.2221341341));
















/*        System.out.println(nanosToSeconds(1212141290));

//        System.out.println(TimeUnit.NANOSECONDS.toNanos());

        System.out.println(System.currentTimeMillis());*/

   /*     SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

        System.out.println( System.nanoTime());
*/

/*

        Date date = new Date(System.currentTimeMillis());
        System.out.println("当前时间：" + date);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = dateFormat.format(date);

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = dateFormat.parse(format);
        long ts = date1.getTime();
        System.out.println(ts);
        String res = String.valueOf(ts);  // 转化为字符串
        System.out.println(res);

*/


/*

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = dateFormat.format(date);

        String[] s = format.split(" ");
        String s1 = s[1];



*/

//        System.out.println(format);


    }

}
