package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.validator.BeanValidator;
import com.funtl.my.shop.domain.TbContentCategory;
import com.funtl.my.shop.web.admin.dao.TbContentCategoryDao;
import com.funtl.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @ClassName TbContentCategoryServiceImpl
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 11:31
 * @Version 1.0
 **/
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public BaseResult save(TbContentCategory tbContentCategory) {
        String validator = BeanValidator.validator(tbContentCategory);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        } else {
            tbContentCategory.setUpdated(new Date());
            //新增
            if (tbContentCategory.getId() == null) {
                tbContentCategory.setCreated(new Date());
                tbContentCategoryDao.insert(tbContentCategory);
            } else {
                //编辑
                tbContentCategoryDao.update(tbContentCategory);
            }
            return BaseResult.success("保存信息成功");
        }
    }

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id);
    }

}
