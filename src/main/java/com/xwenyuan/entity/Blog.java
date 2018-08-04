package com.xwenyuan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * blog entity
 * @author xwenyuan
 *
 */
@Entity
@Table(name = "t_blog")
public class Blog implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Integer id;    // blog id
    
    @Column(nullable = false, length = 100, name = "title")
    private String title;    // blog title
    
    @Column(nullable = false, length = 400, name = "summary")
    private String summary;    // blog summary
    
    @Column(nullable = false, name = "release_date")
    private Date releaseDate;    // blog release date
    
    @Column(name="visit_count")
    private Integer visitCount;    // blog visit count
    
    @Column(name="reply_count")
    private Integer replyCount;    // blog replay count
    
    @Lob
    @Column(columnDefinition = "TEXT", name="html_content")
    private String htmlContent;    // blog main content
    
    @Column(length = 200, name = "key_word")
    private String keyWord;    // blog keywords, split with blank space
    
    @ManyToOne
    @JoinColumn(name= "type_id" )
    private BlogType blogType;    // blog type
    
    @Transient
    private String rawContent;    // not mapping to db: raw content, for lucene
    
    @Transient
    private Integer blogCount;    // not mapping to db: blog count, not blog's attribute, just for list blogs by releaseDate
    
    @Transient
    private String releaseDateStr;    // without mapping to db: year and month
    
    @Transient
    private List<String> imagesList=new LinkedList<String>();    // without mapping to db: blog pic, show in blog list

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public String getRawContent() {
        return rawContent;
    }

    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

}
