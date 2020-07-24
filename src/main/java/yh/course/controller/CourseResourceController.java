package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseResource;
import yh.course.service.CourseResourceService;
import yh.util.IdWorker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/resource")
public class CourseResourceController {

    @Autowired
    private CourseResourceService courseResourceService;
    @Autowired
    IdWorker idWorker;
    @Value("${spring.profiles.active:prod}")
    public String env;
    @Value("${server.port:9000}")
    public String port;

    public String path = Objects.equals(env, "dev") ? "D:/Project/IDEA/course-Learning-server/file/course-resource/"
            : "/file/course-resource/";
    public String ip = Objects.equals(env, "dev") ? "localhost"
            : "192.168.1.10";

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseResourceService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseResourceService.findById(id));
    }

    @RequestMapping(value = "/courseId/{courseId}", method = RequestMethod.GET)
    public Result findByCourseId(@PathVariable String courseId) {
        System.out.println(path);
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseResourceService.findByCourseId(courseId));
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result save(@RequestBody CourseResource courseResource) {
        courseResourceService.save(courseResource);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result update(@PathVariable String id, @RequestBody CourseResource courseResource) {
        courseResourceService.update(courseResource);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result deleteById(@PathVariable String id) {
        courseResourceService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

    @RequestMapping(value = "/resourceUpload", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('upload')")
    public Result resourceUpload(CourseResource courseResource, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        if (multipartFile == null)
            return new Result(false, StatusCode.ERROR, "文件上传失败");

        String id = idWorker.nextStringId();
        String originalFileName = multipartFile.getOriginalFilename();
        String fileNamePrefix = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + "-" + id;
        String newFileName = fileNamePrefix + originalFileName.substring(originalFileName.lastIndexOf("."));
//        File dir = new File(path);
//        if (!dir.exists())  //如果文件目录不存在
//            dir.mkdirs();
        File serverFile = new File(path + newFileName);
        multipartFile.transferTo(serverFile);

        courseResource.setId(id);
        courseResource.setFileName(newFileName);
        courseResource.setResUrl("http://" + ip + ":" + port + "/resource/download/" + id);
        courseResourceService.save(courseResource);

        return new Result(true, StatusCode.SUCCESS, "文件上传成功", newFileName);
    }

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public Result fileDownload(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        CourseResource courseResource = courseResourceService.findById(id);
        if (courseResource == null || StringUtils.isEmpty(courseResource.getFileName()))
            return new Result(false, StatusCode.ERROR, "资源不存在");

        String fileName = courseResource.getFileName();

        File file = new File(path + fileName);
        if (!file.exists())
            return new Result(false, StatusCode.ERROR, "资源不存在");

        fileName = new String(fileName.getBytes("gbk"), "ISO8859-1");
        OutputStream outputStream = response.getOutputStream();  // 使用response 获取字节输出

        response.setContentType("application/x-download");   // 进行文件下载
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        outputStream.write(FileCopyUtils.copyToByteArray(file));   // outputStream 写入到输出流
        outputStream.flush();   // 刷新流
        outputStream.close();   // 关闭流

        return null;
    }

}
