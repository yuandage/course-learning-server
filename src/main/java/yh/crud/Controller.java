package yh.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", crudService.findById(id));
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

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable String id) {
		crudService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
