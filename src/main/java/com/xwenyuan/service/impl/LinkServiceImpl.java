package com.xwenyuan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.xwenyuan.entity.Link;
import com.xwenyuan.repository.LinkRepository;
import com.xwenyuan.service.LinkService;

/**
 * link service implementation class
 * @author xwenyuan
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService{

    @Resource
    private LinkRepository linkRepository;
    
    @Override
    public List<Link> list(Integer page, Integer pageSize) {
        return linkRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    @Override
    public Long getCount() {
        return linkRepository.count();
    }

    @Override
    public void save(Link link) {
        linkRepository.save(link);
    }

    @Override
    public void delete(Integer id) {
        linkRepository.deleteById(id);
    }

}
