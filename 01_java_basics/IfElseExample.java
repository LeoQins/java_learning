// IfElseExample.java - 演示条件控制语句

public class IfElseExample {
    public static void main(String[] args) {
        int score = 85;

        System.out.println("当前分数: " + score);

        // if-else if-else 结构
        if (score >= 90) {
            System.out.println("优秀!");
        } else if (score >= 80) {
            System.out.println("良好!");
        } else if (score >= 60) {
            System.out.println("及格!");
        } else {
            System.out.println("需要努力!");
        }

        // switch 结构
        int dayOfWeek = 3;
        String dayName;

        switch (dayOfWeek) {
            case 1:
                dayName = "星期一";
                break;
            case 2:
                dayName = "星期二";
                break;
            case 3:
                dayName = "星期三";
                break;
            // ... 其他case
            default:
                dayName = "未知";
                break;
        }
        System.out.println("今天是: " + dayName);
    }
}
