package javaSenior.reStudy;
import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reStudy {
    public static void main(String[] args) {
        String str = "c";
        String regex = "[abc]";
        System.out.println(str.matches(regex));

        Pattern phone = Pattern.compile("1\\d{10}");
        Pattern email = Pattern.compile("\\w+@163.com");
        Pattern ip = Pattern.compile("^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$");
        Pattern new1 = Pattern.compile("\\d&&[^2]") ;
        Matcher m = ip.matcher("192.168.256.5");
//        Matcher m = new1.matcher("3");
        boolean b = m.matches();
        System.out.println(b);

        String str5 = "sadasd1561*/*/53asd*9/*";
        String regex1 = "[^\\w]+";
        System.out.println(str5.replaceAll(regex1,""));
        System.out.println("asdasd192.168.0.1adasdasd".matches(".*((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2}" +
                "(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}).*"));



    }
}


