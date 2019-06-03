package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.commons.persistence.BaseDao;
import com.funtl.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * TbUserDao
 *
 * @author kdnight
 * @version 1.0
 * 2019/5/24 10:59
 **/
@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

}
