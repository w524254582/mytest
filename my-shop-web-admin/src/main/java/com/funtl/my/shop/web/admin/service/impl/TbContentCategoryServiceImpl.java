package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
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
            TbContentCategory parent = tbContentCategory.getParent();
            //如果没有选择父级节点，则默认设置为根目录
            if (parent == null || parent.getId() == null) {
                //0代表根目录
                parent.setId(0L);
            }
            tbContentCategory.setUpdated(new Date());
            //新增
            if (tbContentCategory.getId() == null) {
                tbContentCategory.setCreated(new Date());
                tbContentCategory.setStatus(1);
                //判断当前新增节点有无父级节点
                if (parent.getId() != 0L) {
                    tbContentCategory.setIsParent(false);
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent != null) {
                        //为父级节点设置 isParent为true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                } else {//父级节点为0表示为根目录
                    //根目录一定是父级目录
                    tbContentCategory.setIsParent(true);
                }

                tbContentCategoryDao.insert(tbContentCategory);
            } else {
                //编辑
                tbContentCategoryDao.update(tbContentCategory);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

    @Override
    public void delete(Long id) {

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

    @Override
    public void update(TbContentCategory entity) {
        tbContentCategoryDao.update(entity);
    }

    @Override
    public void deleteMulti(String[] ids) {

    }

    @Override
    public PageInfo<TbContentCategory> page(int draw, int start, int length, TbContentCategory entity) {
        return null;
    }

    @Override
    public int count(TbContentCategory entity) {
        return 0;
    }

}
