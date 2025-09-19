package top.example.boot.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.example.boot.mp.entity.UserAccount;
import top.example.boot.mp.mapper.UserAccountMapper;
import top.example.boot.mp.service.UserAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

// 继承 ServiceImpl<Mapper, Entity>，绑定 Mapper 和 Entity
@Service
@Transactional
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Override
    public boolean createUser(UserAccount user) {
        processUserBeforeSave(user);
        return this.save(user);
    }

    @Override
    public boolean createUsers(List<UserAccount> users) {
        users.forEach(this::processUserBeforeSave);
        return this.saveBatch(users, 1000);
    }

    private void processUserBeforeSave(UserAccount user) {
        if (user.getPassword() != null && !user.getPassword().startsWith("$2")) {
            user.setPassword(ENCODER.encode(user.getPassword()));
        }

        if (user.getDeleted() == null) {
            user.setDeleted(0);
        }
        if (user.getStatus() == null) {
            user.setStatus(1);
        }
        if (user.getVersion() == null) {
            user.setVersion(0);
        }
    }
}