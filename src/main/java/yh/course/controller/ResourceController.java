package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.Resource;
import yh.course.service.ResourceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", resourceService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", resourceService.findById(id));
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public Result findByCourseId(@PathVariable String courseId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", resourceService.findByCourseId(courseId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Resource resource) {
        resourceService.save(resource);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Resource resource) {
        resourceService.update(resource);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        resourceService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result fileUpload(Resource resource, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        Date date = new Date();
        resource.setCreateTime(date);
        resource.setUpdateTime(date);

        resourceService.save(resource);

        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("path:"+path.getAbsolutePath());

        String originalFileName = multipartFile.getOriginalFilename();
        String fileNamePrefix = resource.getName() + "-" + resource.getId();
        String newFileName = fileNamePrefix + originalFileName.substring(originalFileName.lastIndexOf("."));
        File dir = new File(path.getAbsolutePath()+"/course-resource");
        if (!dir.exists())  //如果文件目录不存在
            dir.mkdirs();
        File serverFile = new File(path +"/course-resource/"+ newFileName);
        try { //上传
            multipartFile.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(true, StatusCode.SUCCESS, "文件上传成功");
    }

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public void fileDownload(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("path:"+path.getAbsolutePath()+"/course-resource/");
        Resource resource = resourceService.findById(id);
        String fileNamePrefix = resource.getName() + "-" + resource.getId();
        System.out.println("文件名:" + fileNamePrefix);
        File file = new File(path.getAbsolutePath()+"/course-resource/");
        File[] files = file.listFiles();
        String fileSearchName;

        for (File filePathAndName : files) {
            fileSearchName = filePathAndName.getName();
            if (fileNamePrefix.equals(fileSearchName.substring(0, fileSearchName.lastIndexOf(".")))) {
                fileNamePrefix = fileSearchName;
                file = filePathAndName;
                break;
            }
        }
        //判断文件是否存在
        try {
            fileNamePrefix = new String(fileNamePrefix.getBytes("gbk"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(fileNamePrefix);
        OutputStream outputStream = response.getOutputStream(); // 使用response 获取字节输出
        response.setContentType("application/x-download");   // 进行文件下载
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileNamePrefix);
        outputStream.write(FileCopyUtils.copyToByteArray(file));   // outputStream 写入到输出流
        outputStream.flush();   // 刷新流
        outputStream.close();   // 关闭流
    }


}
