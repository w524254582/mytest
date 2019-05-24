package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TbUserDao
 *
 * @author Administrator
 * @version 1.0
 * 2019/5/24 10:59
 **/
@Repository
public interface TbUserDao {
    /**
     * 查询用户表全部信息
     * @return
     */
     List<TbUser> selectAll();

    void insert(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

}
