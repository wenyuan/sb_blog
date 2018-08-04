package com.xwenyuan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * comment entity
 * @author xwenyuan
 *
 */
@Entity
@Table(name="t_comment")
public class Comment {
    
    @Id
    @GeneratedValue
    private Integer id;    // comment id
    
    @Column(length = 50, name = "user_ip")
    private String userIp;    // visitor ip
    
    @Column(nullable = false, length = 1000, name = "content")
    private String content;    // comment content
    
    @Column(name = "comment_date")
    private Date commentDate;    // comment date
    
    @Column(name = "state")
    private Integer state;    // audit status: 0-wait 1-passed 2-not_passed
    
    @ManyToOne
    @JoinColumn(name= "blog_id" )
    private Blog blog;    // blog that belong to

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
