package com.xwenyuan.controller.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xwenyuan.entity.Blog;
import com.xwenyuan.service.BlogService;
import com.xwenyuan.service.BlogTypeService;
import com.xwenyuan.util.DateUtil;

@RestController
@RequestMapping("/admin/blog")
public class BlogAdminController {
    
    @Resource
    private BlogService blogService;
    
    @Resource
    private BlogTypeService blogTypeService;
    
    @Value("${blogImgPath}")
    private String blogImgPath;
    
    @Value("${blogImgUrl}")
    private String blogImgUrl;
    
    /**
     * save or update blog
     * @param blog
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public Map<String,Object> save(@RequestBody Blog blog) throws Exception {
        blog.setReleaseDate(new Date());
        blog.setBlogType(blogTypeService.findById(blog.getBlogTypeId()));
        Map<String,Object> resultMap=new HashMap<String,Object>();
        blogService.save(blog);
        resultMap.put("success", true);
        return resultMap;
    }
    
    /**
     * upload blogImg
     * @param file
     * @param CKEditorFuncNum
     * @return
     * @throws Exception
     */
    @RequestMapping("/ckeditorUpload")
    public Map<String,Object> ckeditorUpload(@RequestParam("upload")MultipartFile file, String CKEditorFuncNum) throws Exception {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName=DateUtil.getCurrentDateStr() + suffixName;
        Map<String,Object> resultMap=new HashMap<String,Object>();
        try{
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(blogImgPath + newFileName));
            resultMap.put("uploaded", 1);
            resultMap.put("fileName", newFileName);
            resultMap.put("url", blogImgUrl + newFileName);
            return resultMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            resultMap.put("uploaded", 0);
            resultMap.put("error", "file not found");
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("uploaded", 0);
            resultMap.put("error", "io exception");
            return resultMap;
        }
    }

}
