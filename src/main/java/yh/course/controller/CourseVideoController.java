package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseVideo;
import yh.course.service.CourseVideoService;
import yh.util.IdWorker;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class CourseVideoController {

    @Autowired
    CourseVideoService courseVideoService;
    @Autowired
    IdWorker idWorker;

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
    public Result save(@RequestBody CourseVideo courseVideo) {
        courseVideoService.save(courseVideo);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody CourseVideo courseVideo) {
        courseVideoService.update(courseVideo);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        courseVideoService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

    @RequestMapping(value = "/videoUpload", method = RequestMethod.POST)
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
        courseVideoService.save(courseVideo);

        return new Result(true, StatusCode.SUCCESS, "文件上传成功", newFileName);
    }

}
