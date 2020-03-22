package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseChapter;
import yh.course.service.CourseChapterService;

@RestController
@CrossOrigin
@RequestMapping("/chapter")
public class CourseChapterController {

    @Autowired
    private CourseChapterService courseChapterService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseChapterService.findAll());
    }

    @RequestMapping(value = "/{chapterId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String chapterId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseChapterService.findById(chapterId));
    }

    //查询课程的章节 parentId=0 父章节 parentId!=0 子章节章节
    @RequestMapping(value = "/{courseId}/{parentId}", method = RequestMethod.GET)
    public Result findByCourseIdAndParentId(@PathVariable String courseId, @PathVariable String parentId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseChapterService.findByCourseIdAndParentId(courseId,parentId));
    }

    @RequestMapping(value = "/courseId/{courseId}", method = RequestMethod.GET)
    public Result findByCourseId(@PathVariable String courseId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseChapterService.findByCourseId(courseId));
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result save(@RequestBody CourseChapter courseChapter) {
        courseChapterService.save(courseChapter);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{chapterId}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result update(@PathVariable String chapterId, @RequestBody CourseChapter courseChapter) {
        courseChapterService.update(courseChapter);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{chapterId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result deleteById(@PathVariable String chapterId) {
        courseChapterService.deleteById(chapterId);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
