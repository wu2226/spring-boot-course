package top.example.boot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.example.boot.mp.entity.UserAccount;

// 关键：继承 BaseMapper<UserAccount>，绑定实体类 UserAccount
@Mapper
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    // 这里可以添加自定义的 Mapper 方法（可选）
}