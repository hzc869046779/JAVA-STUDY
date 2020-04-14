package javaSenior.ThreadStudy;

/**
 * votatile
 *
 * 主要是在属性定义上使用的，表示此属性为直接数据操作，不进行副本的拷贝处理
 * 普通属性 1 获取标量原有的数据内容副本
 *        2  利用副本为变量进行数学计算
 *        3  将计算后的变量，保存到原始空间职中
 *
 *
 * volatile和syschronized区别
 *        1. volatile主要在属性上使用，而synchronized是在代码块和方法上使用的；
 *        2. volatile无法描述同步的处理，它知识一中直接内存的处理，避免了副本的操作. 而syschronize实现了同步
 *
 *        volatitle 使用也离不开syschronized
 */


public class volatileStudy {

    public static void main(String[] args){

    }
}
