import java.util.List;
import java.util.Optional;
import java.util.Scanner;

// UserManager.java - 负责与用户交互的命令行界面 (View/Controller)
public class UserManager {
    private UserService userService = new UserService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            showMenu();
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("无效输入，请输入数字！");
                continue;
            }

            switch (choice) {
                case 1:
                    listAllUsers();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    findUser();
                    break;
                case 0:
                    System.out.println("感谢使用，再见！");
                    return;
                default:
                    System.out.println("无效选择，请重试！");
            }
            System.out.println(); // 打印一个空行以分隔
        }
    }

    private void showMenu() {
        System.out.println("===== 用户管理系统 =====");
        System.out.println("1. 显示所有用户");
        System.out.println("2. 添加新用户");
        System.out.println("3. 更新用户信息");
        System.out.println("4. 删除用户");
        System.out.println("5. 查找用户");
        System.out.println("0. 退出");
        System.out.print("请输入你的选择: ");
    }

    private void listAllUsers() {
        System.out.println("\n--- 所有用户列表 ---");
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("当前没有用户。");
        } else {
            users.forEach(System.out::println);
        }
    }

    private void addUser() {
        System.out.println("\n--- 添加新用户 ---");
        System.out.print("请输入用户名: ");
        String username = scanner.nextLine();
        System.out.print("请输入密码: ");
        String password = scanner.nextLine();

        if (userService.addUser(username, password)) {
            System.out.println("用户添加成功！");
        }
    }

    private void updateUser() {
        System.out.println("\n--- 更新用户信息 ---");
        System.out.print("请输入要更新的用户ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("无效的ID格式！");
            return;
        }

        if (userService.findUserById(id).isEmpty()) {
            System.out.println("未找到ID为 " + id + " 的用户。");
            return;
        }

        System.out.print("请输入新用户名: ");
        String newUsername = scanner.nextLine();
        System.out.print("请输入新密码: ");
        String newPassword = scanner.nextLine();

        if (userService.updateUser(id, newUsername, newPassword)) {
            System.out.println("用户信息更新成功！");
        }
    }

    private void deleteUser() {
        System.out.println("\n--- 删除用户 ---");
        System.out.print("请输入要删除的用户ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("无效的ID格式！");
            return;
        }

        if (userService.deleteUser(id)) {
            System.out.println("ID为 " + id + " 的用户已删除。");
        } else {
            System.out.println("未找到ID为 " + id + " 的用户。");
        }
    }

    private void findUser() {
        System.out.println("\n--- 查找用户 ---");
        System.out.print("请输入要查找的用户名: ");
        String username = scanner.nextLine();
        Optional<User> userOptional = userService.findUserByUsername(username);
        if (userOptional.isPresent()) {
            System.out.println("找到用户: " + userOptional.get());
        } else {
            System.out.println("未找到用户名为 '" + username + "' 的用户。");
        }
    }
}
