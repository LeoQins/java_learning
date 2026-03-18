import java.util.ArrayList;
import java.util.List;

// ListExample.java - 演示 List 集合的使用
public class ListExample {
    public static void main(String[] args) {
        // 1. 创建一个 List
        // ArrayList 是 List 接口的一个常用实现类
        List<String> fruits = new ArrayList<>();

        // 2. 添加元素
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("橘子");
        System.out.println("初始列表: " + fruits);

        // 3. 获取元素
        // 索引从 0 开始
        String secondFruit = fruits.get(1);
        System.out.println("第二个水果是: " + secondFruit);

        // 4. 修改元素
        fruits.set(0, "红苹果");
        System.out.println("修改后列表: " + fruits);

        // 5. 删除元素
        fruits.remove(2); // 按索引删除
        System.out.println("删除'橘子'后: " + fruits);
        fruits.remove("香蕉"); // 按值删除
        System.out.println("删除'香蕉'后: " + fruits);

        // 6. 遍历 List
        System.out.println("遍历列表:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        // 7. 获取大小和检查是否为空
        System.out.println("列表大小: " + fruits.size());
        System.out.println("列表是否为空? " + fruits.isEmpty());

        // 8. 清空列表
        fruits.clear();
        System.out.println("清空后列表: " + fruits);
        System.out.println("列表是否为空? " + fruits.isEmpty());
    }
}
