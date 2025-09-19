package top.example.boot.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.example.boot.mp.entity.UserAccount;

import java.util.List;

// 关键：继承 IService<UserAccount>，指定泛型为 UserAccount
public interface UserAccountService extends IService<UserAccount> {

    // 保留你自定义的方法（如 createUser、createUsers 等）
    boolean createUser(UserAccount userAccount);
    boolean createUsers(List<UserAccount> userAccounts);
}
