import java.util.HashMap;
import java.util.Map;

// MapExample.java - 演示 Map 集合的使用
public class MapExample {
    public static void main(String[] args) {
        // 1. 创建一个 Map
        // HashMap 是 Map 接口的一个常用实现类
        // Map 存储键值对 (Key-Value)
        Map<String, Integer> studentScores = new HashMap<>();

        // 2. 添加键值对
        studentScores.put("张三", 95);
        studentScores.put("李四", 88);
        studentScores.put("王五", 92);
        System.out.println("初始 Map: " + studentScores);

        // 3. 获取值
        // 通过 Key 获取 Value
        int zhangsanScore = studentScores.get("张三");
        System.out.println("张三的分数是: " + zhangsanScore);

        // 4. 修改值
        // 如果 Key 已存在，put 方法会覆盖旧的值
        studentScores.put("李四", 90);
        System.out.println("修改后 Map: " + studentScores);

        // 5. 删除键值对
        studentScores.remove("王五");
        System.out.println("删除'王五'后: " + studentScores);

        // 6. 检查 Key 或 Value 是否存在
        System.out.println("Map 是否包含'张三'这个键? " + studentScores.containsKey("张三"));
        System.out.println("Map 是否包含 90 这个值? " + studentScores.containsValue(90));

        // 7. 遍历 Map
        System.out.println("遍历 Map:");
        // 遍历键集合 (keySet)
        for (String name : studentScores.keySet()) {
            System.out.println("- 姓名: " + name + ", 分数: " + studentScores.get(name));
        }
        
        System.out.println("\n遍历键值对 (entrySet):");
        // 遍历 Entry 集合 (更高效)
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println("- 姓名: " + entry.getKey() + ", 分数: " + entry.getValue());
        }

        // 8. 获取大小
        System.out.println("\nMap 的大小: " + studentScores.size());
    }
}
