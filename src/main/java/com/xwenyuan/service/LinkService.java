package com.xwenyuan.service;

import java.util.List;

import com.xwenyuan.entity.Link;

/**
 * link service interface
 * @author xwenyuan
 *
 */
public interface LinkService {
    
    /**
     * query links by page
     * @param page
     * @param pageSize
     * @return
     */
    public List<Link> list(Integer page, Integer pageSize);
    
    /**
     * get total count
     * @return
     */
    public Long getCount();

}
