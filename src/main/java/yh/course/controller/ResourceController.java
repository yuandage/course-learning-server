package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.Resource;
import yh.course.service.ResourceService;

@RestController
@CrossOrigin
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService ;

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

}
