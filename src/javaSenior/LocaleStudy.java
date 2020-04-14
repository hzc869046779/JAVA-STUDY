package javaSenior;

import javaStudy.packageTest.Message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleStudy {
    public static void main(String[] args) {
        Locale loc = new Locale("en","US");
        Locale myloc = Locale.getDefault();
        System.out.println(myloc.toString());
        ResourceBundle resource = ResourceBundle.getBundle("javaSenior.Messages",loc);
        ResourceBundle resource1 = ResourceBundle.getBundle("javaSenior.Messages");
        String val = resource.getString("info");
        String val1 = resource1.getString("info");
        System.out.println(MessageFormat.format(val,"hzc"));
        System.out.println(val1);
}}
