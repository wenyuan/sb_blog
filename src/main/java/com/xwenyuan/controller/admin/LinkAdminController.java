package com.xwenyuan.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xwenyuan.entity.Link;
import com.xwenyuan.service.LinkService;

@RestController
@RequestMapping("/admin/link")
public class LinkAdminController {

    @Resource
    private LinkService linkService;
    
    /**
     * query links by page
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public Map<String, Object> list(@RequestParam(value="page",required=false)Integer page,@RequestParam(value="limit",required=false)Integer limit)throws Exception {
        List<Link> linklist = linkService.list(page-1, limit);
        Long total = linkService.getCount();
        Map<String,Object> resultMap= new HashMap<String,Object>();
        resultMap.put("code", 200);
        resultMap.put("msg", "查询成功");
        resultMap.put("data", linklist);
        resultMap.put("total", total);
        return resultMap;
    }
}
