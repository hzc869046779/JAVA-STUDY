package javaStudy.listStudy;

class ArrayUtil{
    public static int sum(int ... data){   //变种数组
        int sum = 0;
        for( int temp:data){
            sum += temp;
        }
        return  sum;
    }
}

public class listStudy {
    public static void main(String[] args){

        //一位数组定义使用
        int []arr  = new int[]{2,3,5,7,4};

        // 二维数组定义使用
//        int data2 [][] = new int[][]{{1,3,5},{2,4,5}};
//        System.out.println(data2[0][0]);
//        for(int x[] : data2){
//            for(int y : x){
//                System.out.println(y);
//            }
//        }

        // 数组排序
//        Arrays.sort(arr);
//        for(int x : arr){
//            System.out.print(x);
//        }

        // 数组拷贝
//        int []arr2 = new int[]{2,3,5,6,7};
//        System.arraycopy(arr,0,arr2,2,3);
//        System.out.println(Arrays.toString(arr2));

        // 变种数组 可变参数
        System.out.println(ArrayUtil.sum(1,2,3));
        System.out.println(ArrayUtil.sum(new int[] {1,2,3}));






    }

}
