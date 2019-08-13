package com.dream.xy.bootx.mybatisplusgenerate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dream.xy.bootx.mybatisplusgenerate.CommonConstant;
import com.dream.xy.bootx.mybatisplusgenerate.utils.ResultDto;
import com.dream.xy.bootx.mybatisplusgenerate.service.AdminUserService;
import com.dream.xy.bootx.mybatisplusgenerate.pojo.AdminUser;
/**
 * <p>
 *  Controller层
 * </p>
 *
 * @author xiayu
 * @since 2019-08-13
 */
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {
	@Autowired
	private AdminUserService iAdminUserService;
	@RequestMapping("/list")
	public List<AdminUser> selectAdminUserList() {
		return iAdminUserService.list();
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public ResultDto saveUser(@RequestBody AdminUser record) {
		ResultDto rsDto=new ResultDto(CommonConstant.resultCode,CommonConstant.resultMsg);
		iAdminUserService.save(record);
		return rsDto;
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/update")
	public ResultDto updateUser(@RequestBody AdminUser record) {
		ResultDto rsDto=new ResultDto(CommonConstant.resultCode,CommonConstant.resultMsg);
		iAdminUserService.updateById(record);
		return rsDto;
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/delete")
	public ResultDto deleteUser(@RequestBody AdminUser record) {
		ResultDto rsDto=new ResultDto(CommonConstant.resultCode,CommonConstant.resultMsg);
		iAdminUserService.removeById(record.getId());
		return rsDto;
	}
	
}

