package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import yh.common.PageResult;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.Course;
import yh.course.service.CourseService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseService.findAll());
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String courseId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseService.findById(courseId));
    }

    @RequestMapping(value = "/parentId/{parentId}", method = RequestMethod.GET)
    public Result findByParentId(@PathVariable String parentId) {
        System.out.println(parentId);
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseService.findByParentId(parentId));
    }

    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET)
    public Result findBySubjectId(@PathVariable Integer subjectId) {
        System.out.println(subjectId);
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseService.findBySubjectId(subjectId));
    }

    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public Result findAllByPage(@PathVariable int page, @PathVariable int size) {
        Page<Course> pageData = courseService.findAllByPage(page, size);
        return new Result(true, StatusCode.SUCCESS, "查询成功", new PageResult<Course>(pageData.getTotalElements(), pageData.getContent()));
    }

    @RequestMapping(value = "/parentId/{parentId}/{page}/{size}", method = RequestMethod.GET)
    public Result findByParentIdPage(@PathVariable String parentId,@PathVariable int page, @PathVariable int size) {
        Page<Course> pageData = courseService.findByParentIdPage(parentId,page, size);
        return new Result(true, StatusCode.SUCCESS, "查询成功", new PageResult<Course>(pageData.getTotalElements(), pageData.getContent()));
    }

    @RequestMapping(value = "/subject/{subjectId}/{page}/{size}", method = RequestMethod.GET)
    public Result findBySubjectIdPage(@PathVariable Integer subjectId,@PathVariable int page, @PathVariable int size) {
        Page<Course> pageData = courseService.findBySubjectIdPage(subjectId,page, size);
        return new Result(true, StatusCode.SUCCESS, "查询成功", new PageResult<Course>(pageData.getTotalElements(), pageData.getContent()));
    }


    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Course course) {
        courseService.save(course);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String courseId, @RequestBody Course course) {
        courseService.update(course);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String courseId) {
        courseService.deleteById(courseId);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Course course) {
        List<Course> list = courseService.findSearch(course);
        return new Result(true, StatusCode.SUCCESS, "查询成功", list);
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Course course, @PathVariable int page, @PathVariable int size) {
        Page<Course> pageData = courseService.pageQuery(course, page, size);
        return new Result(true, StatusCode.SUCCESS, "查询成功", new PageResult<Course>(pageData.getTotalElements(), pageData.getContent()));
    }
}
