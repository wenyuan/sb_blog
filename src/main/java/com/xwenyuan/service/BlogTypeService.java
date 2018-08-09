package com.xwenyuan.service;

import com.xwenyuan.entity.BlogType;

/**
 * blogType service interface
 * @author xwenyuan
 *
 */
public interface BlogTypeService {
    
    /**
     * query blogType by id
     * @param blog
     */
    public BlogType findById(Integer id);

}
