package kyu5.Common_Denominators;

import java.util.*;
//求最小公倍數
public class Fracts {
  // your code
  public static String convertFrac(long[][] lst) {

    if(lst.length == 0) return ""; //無參數時返回空值

    long total = 1,aim = lst[0][1],min = lst[0][1];
    for(long[] inArray : lst){
      //如果2號位不能除盡1號位，實行comDiv方法求得2號位，若二者階無，則二數互質。
      if(inArray[1] % inArray[0] == 0){
        inArray[1] = inArray[1] / inArray[0];
        inArray[0] = 1;
      }else if(inArray[0] % (inArray[1] / comDiv(inArray[0],inArray[1])) == 0){
        //如果1號位不能除盡找出的2號位，則無效。
        long temp = inArray[1];
        inArray[1] = comDiv(inArray[0],inArray[1]);
        inArray[0] = inArray[0] / (temp / inArray[1]);
      }

      total *= inArray[1]; //最大公倍數
      if(inArray[1] > aim) aim = inArray[1];
      if(inArray[1] < min) min = inArray[1];
    }

    //判斷找出的最大值是不是所有元素的最小公倍數
    boolean isRight = true;
    for(long[] num : lst){
      if(aim % num[1] != 0)  isRight = false;
    }

    if(!isRight){
      //創建一個集合收集所有可能的公倍數
      List<Long> temp = new ArrayList<>();
      for(long i = min;i <= total;i++){
        for (long[] longs : lst) {
          if (i % longs[1] == 0) {
            temp.add(i);
          }
        }
      }

      //通過集合中出現的次數找出最小公倍數
      long change = temp.get(0);
      for(int i = 0,count = 0;i < temp.size();i++){
        if(temp.get(i) == change){
          count++;
        }else{
          count = 1;
        }
        change = temp.get(i);
        if(count == lst.length){
          aim = temp.get(i);
          break;
        }
      }
    }

    //返回值
    StringBuilder result = new StringBuilder();
    for(long[] inArray : lst){
      inArray[0] = aim / inArray[1] * inArray[0];
      inArray[1] = aim;
      result.append("(").append(inArray[0]).append(",").append(inArray[1]).append(")");
    }

    return result.toString();
  }

  //如果2號位不能除盡1號位，則套娃，直到找出最小2號位
  public static long comDiv(long x, long y){
    return y % x == 0 ? y / x : comDiv(y % x,y);
  }

}