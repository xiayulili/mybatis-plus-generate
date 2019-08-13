package com.dream.xy.bootx.mybatisplusgenerate.service;

import com.dream.xy.bootx.mybatisplusgenerate.pojo.User;
import com.dream.xy.bootx.mybatisplusgenerate.mapper.UserMapper;
import com.dream.xy.bootx.mybatisplusgenerate.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author xiayu
 * @since 2019-08-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
