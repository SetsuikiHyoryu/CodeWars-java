package kyu5.Pick_peaks;

//找高峰
import java.util.*;
public class PickPeaks {

    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        for(int i = 1,valMark = 0,indexMark = 0;i < arr.length-1;i++){ //去頭尾

            //如果當前元素不同於前一個元素，標記前一個元素及自身的下標。
            if(arr[i] != arr[i-1]){
                valMark = arr[i-1];
                indexMark = i;
            }

            //當前元素是否大於之前標記的元素
            if(arr[i] > valMark){
                //是，則判斷當前元素是否大於或等於前一個元素，並且當前元素是否大於後一個元素。
                if(arr[i] >= arr[i-1] && arr[i] > arr[i+1]){
                    //都爲是，則添加之前標記的下標及其對應的元素值。
                    peaks.add(arr[indexMark]);
                    pos.add(indexMark);
                }
            }
        }

        Map<String,List<Integer>> result = new HashMap<>();
        result.put("pos", pos);
        result.put("peaks", peaks);

        return result;
    }

    public static Map<String,List<Integer>> best(int[] arr) {

        Map<String,List<Integer>> ans = new HashMap<String,List<Integer>>() {{
            put("pos",   new ArrayList<Integer>() );
            put("peaks", new ArrayList<Integer>() );
        }};
        int posMax = 0;
        boolean matchAsc = false;

        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i-1] < arr[i]) {
                matchAsc = true;
                posMax = i;
            }
            if (matchAsc && arr[i-1] > arr[i]) {
                matchAsc = false;
                ans.get("pos").add(posMax);
                ans.get("peaks").add(arr[posMax]);
            }
        }
        return ans;
    }
}