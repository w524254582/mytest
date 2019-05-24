package com.funtl.my.shop.web.admin.service;

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

    public List<TbUser> selectAll();

    void insert(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);
}
