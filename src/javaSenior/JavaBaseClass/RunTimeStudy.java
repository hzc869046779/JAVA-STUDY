package javaSenior.JavaBaseClass;

/**
 * 描述的是运行状态，唯一一个与JVM运行状态有关的类。
 */
public class RunTimeStudy {
    public static void main(String[] args)throws Exception{
        Runtime run = Runtime.getRuntime();

        // 获取本机CPU内核数
        System.out.println(run.availableProcessors());

        System.out.println(run.maxMemory());
        System.out.println(run.freeMemory());
        System.out.println(run.totalMemory());

        /**
         * gc是垃圾收集器，是可以系统自动调用或者runtime gc手工调用
         */
    }
}
