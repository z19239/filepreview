package cn.keking.service;

import cn.keking.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author Sandeepin
 */
public interface IUserService {
    int alterPassword(String userName, String secret);

    int add(User user);

    int update(User user);

    int deleteByIds(String[] ids);

    int deleteByUsernames(String[] userNames);

    User queryUserByUsername(String userName);

    List<User> queryUserList(Map<String, Object> params);
}
