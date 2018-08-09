package com.xwenyuan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xwenyuan.entity.BlogType;
import com.xwenyuan.repository.BlogTypeRepository;
import com.xwenyuan.service.BlogTypeService;

/**
 * blogType service implementation class
 * @author xwenyuan
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService{

    @Resource
    private BlogTypeRepository blogTypeRepository;
    
    @Override
    public BlogType findById(Integer id) {
        return blogTypeRepository.getOne(id);
    }

}
