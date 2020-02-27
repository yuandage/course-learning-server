package yh.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.base.entity.Label;
import yh.common.Result;
import yh.common.StatusCode;

@RestController
@CrossOrigin
@RequestMapping("/crud")
public class Controller {
    @Autowired
    private CrudService crudService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", crudService.findAll());
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String labelId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", crudService.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        crudService.save(label);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody Label label) {
        crudService.update(label);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId) {
        crudService.deleteById(labelId);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
