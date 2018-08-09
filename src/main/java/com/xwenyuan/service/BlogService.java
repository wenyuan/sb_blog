package com.xwenyuan.service;

import com.xwenyuan.entity.Blog;

/**
 * blog service interface
 * @author xwenyuan
 *
 */
public interface BlogService {
    
    /**
     * save or update blog
     * @param blog
     */
    public void save(Blog blog);

}
