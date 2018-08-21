package com.xwenyuan.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/list")
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
    
    /**
     * add or update link
     * @param link
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public Map<String, Object> save(@RequestBody Link link)throws Exception{
        Map<String,Object> resultMap= new HashMap<String,Object>();
        linkService.save(link);
        resultMap.put("success", true);
        return resultMap;
    }
    
    /**
     * delete links
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public Map<String, Object> delete(@RequestParam(value="ids")String ids)throws Exception{
        String []idsStr = ids.split(",");
        Map<String,Object> resultMap= new HashMap<String,Object>();
        for(int i=0;i<idsStr.length;i++) {
            linkService.delete(Integer.parseInt(idsStr[i]));
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
