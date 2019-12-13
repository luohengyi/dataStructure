package example;

/**
 * 递归求和
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/15
 * Time: 10:55 上午
 */
public class Sum {

    /**
     * @param arr 数组
     * @param l 左边的边界点
     * @return int
     * 最简单的一个计算应该是 最后一个数+0;
     */
    private static int sum(int[] arr,int l){
       if (l==arr.length)
           return 0;
       return arr[l]+sum(arr,l+1);
    }

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    public static void main(String[] args) {
        int[] i = {1,2,3};
        int sum = sum(i);
        System.out.println(sum);
    }

}
