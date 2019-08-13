package com.dream.xy.bootx.mybatisplusgenerate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dream.xy.bootx.mybatisplusgenerate.CommonConstant;
import com.dream.xy.bootx.mybatisplusgenerate.pojo.User;
import com.dream.xy.bootx.mybatisplusgenerate.service.UserService;
import com.dream.xy.bootx.mybatisplusgenerate.utils.ResultDto;
/**
 * <p>
 * 用户 Controller层
 * </p>
 *
 * @author xiayu
 * @since 2019-08-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService iUserService;
	
	@RequestMapping("/list")
	public List<User> selectUserList() {
		return iUserService.list();
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public ResultDto saveUser(@RequestBody User user) {
		ResultDto rsDto=new ResultDto(CommonConstant.resultCode,CommonConstant.resultMsg);
		iUserService.save(user);
		return rsDto;
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/update")
	public ResultDto updateUser(@RequestBody User user) {
		ResultDto rsDto=new ResultDto(CommonConstant.resultCode,CommonConstant.resultMsg);
		iUserService.updateById(user);
		return rsDto;
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/delete")
	public ResultDto deleteUser(@RequestBody User user) {
		ResultDto rsDto=new ResultDto(CommonConstant.resultCode,CommonConstant.resultMsg);
		iUserService.removeById(user.getId());
		return rsDto;
	}
}

