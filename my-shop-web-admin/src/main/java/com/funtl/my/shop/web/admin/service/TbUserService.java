package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.domain.TbUser;

import java.util.List;

/**
 * TbUserService
 *
 * @author Administrator
 * @version 1.0
 * 2019/5/24 11:01
 **/
public interface TbUserService {
    /**
     * 查询全部
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 保存用户信息
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(Long id);

    /**
     *根据ID获取用户信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 更新用户信息
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 登录
     * @param emai
     * @param password
     * @return
     */
    TbUser login(String emai, String password);


    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<TbUser> page(int draw,int start, int length,TbUser tbUser);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbUser tbUser);


}
