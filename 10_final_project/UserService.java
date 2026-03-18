import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// UserService.java - 负责用户数据的增删改查 (Service/Business Logic)
public class UserService {
    private List<User> userDatabase = new ArrayList<>();

    public UserService() {
        // 添加一些初始数据
        userDatabase.add(new User("admin", "admin123"));
        userDatabase.add(new User("alice", "alice123"));
    }

    // 1. 添加用户
    public boolean addUser(String username, String password) {
        // 检查用户名是否已存在
        if (findUserByUsername(username).isPresent()) {
            System.out.println("错误：用户名 '" + username + "' 已存在！");
            return false;
        }
        userDatabase.add(new User(username, password));
        return true;
    }

    // 2. 查找所有用户
    public List<User> getAllUsers() {
        return userDatabase;
    }

    // 3. 根据用户名查找用户
    public Optional<User> findUserByUsername(String username) {
        return userDatabase.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }
    
    // 4. 根据ID查找用户
    public Optional<User> findUserById(int id) {
        return userDatabase.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    // 5. 更新用户信息
    public boolean updateUser(int id, String newUsername, String newPassword) {
        Optional<User> userOptional = findUserById(id);
        if (userOptional.isPresent()) {
            // 检查新用户名是否与其他人冲突
            Optional<User> existingUserWithNewName = findUserByUsername(newUsername);
            if (existingUserWithNewName.isPresent() && existingUserWithNewName.get().getId() != id) {
                System.out.println("错误：用户名 '" + newUsername + "' 已被其他用户使用！");
                return false;
            }
            
            User userToUpdate = userOptional.get();
            userToUpdate.setUsername(newUsername);
            userToUpdate.setPassword(newPassword);
            return true;
        }
        return false;
    }

    // 6. 删除用户
    public boolean deleteUser(int id) {
        return userDatabase.removeIf(user -> user.getId() == id);
    }
}
