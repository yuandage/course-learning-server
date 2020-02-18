package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.Chapter;
import yh.course.service.ChapterService;

@RestController
@CrossOrigin
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", chapterService.findAll());
    }

    @RequestMapping(value = "/{chapterId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String chapterId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", chapterService.findById(chapterId));
    }

    //查询课程的父章节
    @RequestMapping(value = "/parentChapter/{courseId}",method = RequestMethod.GET)
    public Result findParentChapter(@PathVariable String courseId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功",chapterService.findParentChapter(courseId));
    }

    //查询课程的子章节
    @RequestMapping(value = "/subChapter/{courseId}/{parentId}", method = RequestMethod.GET)
    public Result findSubChapter(@PathVariable String courseId, @PathVariable String parentId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", chapterService.findSubChapter(courseId,parentId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{chapterId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String chapterId, @RequestBody Chapter chapter) {
        chapterService.update(chapter);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{chapterId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String chapterId) {
        chapterService.deleteById(chapterId);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
