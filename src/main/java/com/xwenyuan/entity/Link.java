package com.xwenyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * friendly link entity
 * @author xwenyuan
 *
 */
@Entity
@Table(name="t_link")
public class Link {
    
    @Id
    @GeneratedValue
    private Integer id;    // link id
    
    @Column(length = 100, name = "link_name")
    private String linkName;    // link name
    
    @Column(length = 200, name = "link_url")
    private String linkUrl;    // link url
    
    @Column(name = "order_no")
    private Integer orderNo;    // order by asc: 1234

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

}
