package com.funtl.my.shop.web.api.dao;

import com.funtl.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 * @ClassName TbUserDao
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/6 13:39
 * @Version 1.0
 **/
@Repository
public interface TbUserDao {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);

}
