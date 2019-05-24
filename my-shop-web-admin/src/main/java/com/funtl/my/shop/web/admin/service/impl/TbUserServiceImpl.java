package com.funtl.my.shop.web.admin.service.impl;/**
 * TbUserServiceImpl
 *
 * @author Administrator
 * @version 1.0
 * 2019/5/24 11:01
 **/

import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.admin.dao.TbUserDao;
import com.funtl.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName TbUserServiceImpl
 *@Description TODO
 *@Author Administrator
 *@Date 2019/5/24 11:01
 *@Version 1.0
 **/
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public void insert(TbUser tbUser) {
        tbUserDao.insert(tbUser);
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }
}
