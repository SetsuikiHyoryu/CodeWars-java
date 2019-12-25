package kyu5.Human_Readable_Time;

//重點：String.format()
public class HumanReadableTime {
  public static String makeReadable(int seconds) {

    //定義三個時間
    int hour = seconds / 60 / 60;
    int minute = seconds / 60 % 60;
    int second = seconds % 60;

    //利用字符串數組以兩位的方式顯示
    return hour + ":" + minute + ":" + second;
  }

  public static String best(int seconds) {
    int h = seconds/60/60;
    int min = seconds/60%60;
    int sec = seconds%60;
    return String.format("%02d:%02d:%02d",h,min,sec);
  }
}