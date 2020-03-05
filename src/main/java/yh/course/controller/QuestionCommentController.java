package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.QuestionComment;
import yh.course.service.QuestionCommentService;

@RestController
@CrossOrigin
@RequestMapping("/questionComment")
public class QuestionCommentController {

    @Autowired
    private QuestionCommentService questionCommentService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", questionCommentService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", questionCommentService.findById(id));
    }

    @RequestMapping(value = "/questionId/{id}", method = RequestMethod.GET)
    public Result findByQuestionId(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", questionCommentService.findByQuestionId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody QuestionComment questionComment) {
        questionCommentService.save(questionComment);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody QuestionComment questionComment) {
        questionCommentService.update(questionComment);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        questionCommentService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
