package ru.kpfu.itis.selyantsev.models;

import java.util.Date;

public class Article {

    private Long articleId;
    private String articleName;
    private Date articleDate;
    private String userLoginName;

    public Article(Long articleId, String articleName, Date articleDate, String userLoginName) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleDate = articleDate;
        this.userLoginName = userLoginName;
    }

    public Article(String articleName, Date articleDate, String userLoginName) {
        this.articleName = articleName;
        this.articleDate = articleDate;
        this.userLoginName = userLoginName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }
}
