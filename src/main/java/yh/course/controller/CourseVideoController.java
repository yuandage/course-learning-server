package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            String relativePath = "src/main/resources/course-video/";
            String fileName = courseVideo.getFileName();
            Path filePath = Paths.get(relativePath+fileName);

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
    public Result videoUpload(CourseVideo courseVideo, @RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile == null)
            return new Result(false, StatusCode.ERROR, "文件上传失败");
        File path = new File("src/main/resources/course-video");

        System.out.println("path:" + path.getAbsolutePath());
        String id = idWorker.nextId() + "";
        String originalFileName = multipartFile.getOriginalFilename();
        String fileNamePrefix = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + "-" + id;
        String newFileName = fileNamePrefix + originalFileName.substring(originalFileName.lastIndexOf("."));
        File dir = new File(path.getAbsolutePath());
        if (!dir.exists())  //如果文件目录不存在
            dir.mkdirs();
        File serverFile = new File(path.getAbsolutePath() + "/" + newFileName);
        try { //上传
            multipartFile.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        courseVideo.setId(id);
        courseVideo.setVideoUrl("http://localhost:9000/resource/download/" + id);
        courseVideo.setFileName(newFileName);
        courseVideoService.save(courseVideo);

        return new Result(true, StatusCode.SUCCESS, "文件上传成功", newFileName);
    }

}
