package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.commons.dto.BaseResult;
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

    BaseResult save(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    TbUser login(String emai, String password);


}
