package com.xwenyuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xwenyuan.entity.Blog;

/**
 * blog repository interface
 * @author xwenyuan
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
