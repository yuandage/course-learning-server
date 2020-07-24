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
import yh.course.entity.CourseVideo;
import yh.course.handler.ResourceHandler;
import yh.course.service.CourseVideoService;
import yh.util.IdWorker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class CourseVideoController {

    @Autowired
    CourseVideoService courseVideoService;
    @Autowired
    IdWorker idWorker;
    @Autowired
    ResourceHandler resourceHandler;

    @Value("${spring.profiles.active:prod}")
    public String env;
    @Value("${server.port:9000}")
    public String port;

    public String path = Objects.equals(env, "dev") ? "D:/Project/IDEA/course-Learning-server/file/course-video/"
            : "/file/course-video/";
    public String ip = Objects.equals(env, "dev") ? "localhost"
            : "192.168.1.10";

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseVideoService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseVideoService.findById(id));
    }

    @RequestMapping(value = "/courseId/{id}", method = RequestMethod.GET)
    public Result findByCourseId(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseVideoService.findByCourseId(id));
    }

    @GetMapping("/info/{courseId}/{sectionId}")
    public Result findByCourseIdAndSectionId(@PathVariable String courseId, @PathVariable String sectionId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseVideoService.findByCourseIdAndSectionId(courseId, sectionId));
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result save(@RequestBody CourseVideo courseVideo) {
        courseVideoService.save(courseVideo);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result update(@PathVariable String id, @RequestBody CourseVideo courseVideo) {
        courseVideoService.update(courseVideo);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result deleteById(@PathVariable String id) {
        courseVideoService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

    //视频播放
    @GetMapping("/play")
    public void playVideo(@RequestParam String courseId, @RequestParam String sectionId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CourseVideo courseVideo = courseVideoService.findByCourseIdAndSectionId(courseId, sectionId);
        if (courseVideo != null) {
            String fileName = courseVideo.getFileName();
            Path filePath = Paths.get(path + fileName);

            if (Files.exists(filePath)) {
                String mimeType = Files.probeContentType(filePath);
                if (mimeType != null && !"".equals(mimeType)) {
                    response.setContentType(mimeType);
                }
                resourceHandler.setFilePath(filePath);
                resourceHandler.handleRequest(request, response);
            }
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
    }

    //视频上传
    @RequestMapping(value = "/videoUpload", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result videoUpload(CourseVideo courseVideo, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        if (multipartFile == null)
            return new Result(false, StatusCode.ERROR, "文件上传失败");

        String id = idWorker.nextStringId();
        String originalFileName = multipartFile.getOriginalFilename();
        String fileNamePrefix = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + "-" + id;
        String newFileName = fileNamePrefix + originalFileName.substring(originalFileName.lastIndexOf("."));
//        File dir = new File(path.getAbsolutePath());
//        if (!dir.exists())  //如果文件目录不存在
//            dir.mkdirs();
        File serverFile = new File(path + newFileName);
        multipartFile.transferTo(serverFile);

        courseVideo.setId(id);
        courseVideo.setFileName(newFileName);
        courseVideo.setVideoUrl("http://" + ip + ":" + port + "/video/download/" + id);
        courseVideoService.save(courseVideo);

        return new Result(true, StatusCode.SUCCESS, "文件上传成功", newFileName);
    }

    //视频下载
    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public Result fileDownload(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        CourseVideo courseVideo = courseVideoService.findById(id);
        if (courseVideo == null || StringUtils.isEmpty(courseVideo.getFileName()))
            return new Result(false, StatusCode.ERROR, "资源不存在");

        String fileName = courseVideo.getFileName();

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
