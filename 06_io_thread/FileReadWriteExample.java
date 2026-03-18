import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// FileReadWriteExample.java - 演示基本的文件读写
public class FileReadWriteExample {

    private static final String FILE_NAME = "sample.txt";

    // 准备一个用于演示的文件
    public static void prepareFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Hello, Java IO!\n");
            writer.write("这是第二行。\n");
            writer.write("文件读写演示。\n");
            System.out.println("测试文件 '" + FILE_NAME + "' 已创建/更新。");
        } catch (IOException e) {
            System.err.println("创建文件时出错: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 1. 写入文件 (会覆盖原有内容)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("这是新写入的第一行。\n");
            writer.write("This is the new second line.\n");
            System.out.println("成功写入到文件 '" + FILE_NAME + "'。");
        } catch (IOException e) {
            System.err.println("写入文件时出错: " + e.getMessage());
        }

        System.out.println("\n---");

        // 2. 读取文件
        System.out.println("开始读取文件 '" + FILE_NAME + "':");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("读取文件时出错: " + e.getMessage());
        }
        
        // 删除测试文件
        new File(FILE_NAME).delete();
        System.out.println("\n测试文件 '" + FILE_NAME + "' 已删除。");
    }
}
