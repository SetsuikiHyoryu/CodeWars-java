package kyu5.Number_of_trailing_zeros_of_N_tanhao;

//方法正確但是效率太低，内存超載
//階乘
public class Solution {
    public static int zeros(int n) {
        if(n == 0) return 0;

        //將階乘所用之數生成數組
        int[] arrays = new int[n];
        for(int i = 0;i < arrays.length;i++){
            arrays[i] = n;
            n--;
        }

        //將數組中的第一個數乘等之後的所有數
        int count = 1;
        long temp = arrays[0];
        while(count < arrays.length){
            temp *= arrays[count];
            count++;
        }

        count = 0;
        //當階乘完的數除10不餘0時，計算除的次數。
        while(temp % 10 == 0){
            count++;
            temp /= 10;
        }

        return count;
    }

    public static int best(int n) {
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
    }
}