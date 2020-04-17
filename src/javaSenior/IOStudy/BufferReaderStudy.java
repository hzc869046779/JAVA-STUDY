package javaSenior.IOStudy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @ClassName BufferReaderStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/15 15:51
 * @Version 1.0
 */
public class BufferReaderStudy {
    public static void main(String[] args) throws Exception{
        BufferedReader  input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入信息");
        String msg = input.readLine();
        System.out.println("输入成功:"+msg);

    }
}
