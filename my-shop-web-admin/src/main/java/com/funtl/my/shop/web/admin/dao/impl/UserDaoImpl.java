package com.funtl.my.shop.web.admin.dao.impl;

import com.funtl.my.shop.domain.User;
import com.funtl.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author:Dknight
 * @date:2019/5/23
 * @description:
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public User getUser(String email, String password) {
        logger.debug("调用getUser（），email：{},password:{}", email, password);
        User user = null;
        if ("sd.fenglin@qq.com".equals(email)) {
            if ("123".equals(password)) {
                user = new User();
                user.setEmail("sd.fenglin@qq.com");
                user.setUsername("kdnight");
                logger.info("成功获取\"{}\"的用户信息", user.getUsername());

            }
        } else {
            logger.warn("获取\"{}\"的信息失败", email);//埋点 日志的记录
        }
        return user;
    }
}
