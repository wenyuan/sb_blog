package com.xwenyuan.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * blog type entity
 * @author xwenyuan
 *
 */
@Entity
@Table(name="t_blogtype")
public class BlogType implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;    // blogtype id
    
    @Column(nullable = false, length = 30, name = "type_name")
    private String typeName;    // blogtype typename
    
    @Column(name = "order_no")
    private Integer orderNo;    // order by asc: 1234
    
    @Transient
    private Integer blogCount;    // not mapping to db: blog count in current type

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }
    
}
