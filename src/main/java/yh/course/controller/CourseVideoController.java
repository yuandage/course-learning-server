package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseVideo;
import yh.course.service.CourseVideoService;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class CourseVideoController {

    @Autowired
    CourseVideoService courseVideoService;

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

}
