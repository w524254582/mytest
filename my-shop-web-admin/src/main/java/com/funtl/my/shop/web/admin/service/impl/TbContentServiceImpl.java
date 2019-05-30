package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.commons.utils.RegexpUtils;
import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.admin.dao.TbContentDao;
import com.funtl.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TbContentServiceImpl
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 16:13
 * @Version 1.0
 **/
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult = checkTbContent(tbContent);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbContent.setUpdated(new Date());
            //新增
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
                baseResult.setMessage("新增内容信息成功");
            } else {
                //编辑
                tbContentDao.update(tbContent);
                baseResult.setMessage("编辑内容信息成功");
            }

        }
        return baseResult;

    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);

    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.update(tbContent);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page(int draw, int start, int length, TbContent TbContent) {
        int count = tbContentDao.count(TbContent);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("TbContent", TbContent);

        PageInfo<TbContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbContent tbContent) {
        return 0;
    }

    /**
     * 有效信息验证
     *
     * @param tbContent
     * @return
     */
    private BaseResult checkTbContent(TbContent tbContent) {
        BaseResult baseResult = BaseResult.success();

        //非空验证
        if (tbContent.getCategoryId() == null) {
            baseResult = BaseResult.fail("内容所属分类不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getTitle())) {
            baseResult = BaseResult.fail("标题不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getSubTitle())) {
            baseResult = BaseResult.fail("sub标题不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getTitleDesc())) {
            baseResult = BaseResult.fail("标题级别不能为空，请重新输入");
        }
        return baseResult;
    }
}
