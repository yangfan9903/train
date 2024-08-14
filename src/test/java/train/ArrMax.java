package train;

public class ArrMax {
    public static void main(String[] args) {
        int[] arr = {1000,200,300,100,500,600,400,1200};
        System.out.println(getMax(arr));
    }
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i : arr) {
            if (max<i){
                max = i;
            }
        }
        return max;
    }
}
