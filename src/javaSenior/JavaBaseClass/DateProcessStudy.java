package javaSenior.JavaBaseClass;
import java.util.Date;
import java.text.*;

/**
 * long转为Date  public Date（long date）；
 * Date转为long  public long getTime；
 */
public class DateProcessStudy {
    public static void main(String[] args) throws Exception{
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        System.out.println(str);

        String bitthdat = "1846-11-11 11:11:11";
        Date date1 = sdf.parse(bitthdat);
        System.out.println(date1);

        double money = 132123165.132;
        String str1= NumberFormat.getInstance().format(money);
        System.out.println(str1);
    }
}

