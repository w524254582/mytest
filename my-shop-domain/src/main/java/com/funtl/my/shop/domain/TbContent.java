package com.funtl.my.shop.domain;

import com.funtl.my.shop.commons.persistence.BaseEntity;

/**
 * 内容管理
 * @ClassName TbContent
 * @Description TODO
 * @Author kdnight
 * @Date 2019/5/29 16:09
 * @Version 1.0
 **/

public class TbContent extends BaseEntity {

    private String categoryId;
    private String title;
    private String subTitle;
    private String titleDese;
    private String url;
    private String pic;
    private String pic2;
    private String content;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitleDese() {
        return titleDese;
    }

    public void setTitleDese(String titleDese) {
        this.titleDese = titleDese;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
