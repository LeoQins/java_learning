// ThreadExample.java - 演示多线程的创建和运行

// 方法一：继承 Thread 类
class MyThread extends Thread {
    @Override
    public void run() {
        // 线程要执行的任务
        for (int i = 0; i < 3; i++) {
            System.out.println("MyThread (继承Thread类) 正在运行: " + i);
            try {
                Thread.sleep(500); // 暂停 500 毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 方法二：实现 Runnable 接口，注意是implements，而不是extends，这直接避免了方法一只能单继承的局限性。
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 线程要执行的任务
        for (int i = 0; i < 3; i++) {
            System.out.println("MyRunnable (实现Runnable接口) 正在运行: " + i);
            try {
                Thread.sleep(500); // 暂停 500 毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // 创建并启动继承 Thread 类的线程
        MyThread thread1 = new MyThread();
        thread1.start(); // 调用 start() 方法启动线程，而不是 run()

        // 创建并启动实现 Runnable 接口的线程
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        // 方法三：使用 Lambda 表达式 (Java 8+)
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Lambda 表达式线程正在运行: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        System.out.println("Main 方法执行完毕。");
        // 注意：主线程结束了，但其他线程可能还在运行。
    }
}
