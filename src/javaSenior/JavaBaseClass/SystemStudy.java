package javaSenior.JavaBaseClass;

public class SystemStudy {

    /**
     * psvn快速生成main方法
     * @param args
     */
    public static void main(String[] args) {
        /**
         * System.arraycopy 数组拷贝
         * System.currentTimeMillis() 获取当初日期时间数值 操作耗时统计
         * System.gc()
         */

        long start = System.currentTimeMillis();
        String str = "";
        for(int x=0; x<30000; x++){
            str+=x;
        }
        long end = System.currentTimeMillis();
        System.out.println("操作耗时+"+ (end-start)+ "ms");

        System.gc(); // 执行了runtime中的gc  Runtime.getruntime.gc()


    }
}
