// Main.java - IO与多线程学习入口

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 文件读写示例 ---");
        // 准备一个文件用于读写
        FileReadWriteExample.prepareFile();
        // 运行文件读写示例
        FileReadWriteExample.main(args);

        System.out.println("\n--- 多线程示例 ---");
        ThreadExample.main(args);
    }
}
