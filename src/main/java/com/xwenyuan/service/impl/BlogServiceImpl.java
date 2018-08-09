package com.xwenyuan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xwenyuan.entity.Blog;
import com.xwenyuan.repository.BlogRepository;
import com.xwenyuan.service.BlogService;

/**
 * blog service implementation class
 * @author xwenyuan
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService{

    @Resource
    private BlogRepository blogRepository;
    
    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

}
