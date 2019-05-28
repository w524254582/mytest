package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params, 需要两个参数 start 记录开始位置和 length 每页记录数
     * @return
     */
    List<TbUser> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbUser tbUser);



}
