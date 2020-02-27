package yh.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.user.service.UserFavoriteService;
import yh.user.entity.UserFavorite;

@RestController
@CrossOrigin
@RequestMapping("/userFavorite")
public class UserFavoriteController {
    @Autowired
    private UserFavoriteService userFavoriteCrudService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", userFavoriteCrudService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", userFavoriteCrudService.findById(id));
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
    public Result findByUserId(@PathVariable String userId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", userFavoriteCrudService.findByUserId(userId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody UserFavorite userFavorite) {
        userFavoriteCrudService.save(userFavorite);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody UserFavorite userFavorite) {
        userFavoriteCrudService.update(userFavorite);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{userFavoriteId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String userFavoriteId) {
        userFavoriteCrudService.deleteById(userFavoriteId);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
