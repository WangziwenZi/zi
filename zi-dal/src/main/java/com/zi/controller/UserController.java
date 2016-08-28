package com.zi.controller;

import com.google.common.base.Preconditions;
import com.zi.dal.user.dao.UserMapper;
import com.zi.dal.user.entity.User;
import com.zi.dal.user.entity.UserExample;
import com.zi.sys.factory.ServiceImplFactory;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.constant.SysConstant;
import com.zi.sys.result.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/8/16.
 */
@Controller
@RequestMapping("/zi/base/user/")
public class UserController extends ServiceImplFactory {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    /**
     * @api {post} /zi/base/user/sigin.htm 登录接口
     * @apiName sigin
     * @apiGroup user
     * @apiParam {String} email 用户名.
     * @apiParam {String} password 密码.
     */
    @RequestMapping(value = "sigin", method = RequestMethod.POST)
    @ResponseBody
    public Result sigin(User param, HttpServletRequest request) {
//        账户密码空值判断
        Preconditions.checkArgument((StringUtils.isNotBlank(param.getEmail()) && StringUtils.isNotBlank(param.getPassword())), StateCodeConstant.STATE_404);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(param.getEmail());
        criteria.andPasswordEqualTo(param.getPassword());
        User user = this.getUserServlce().queryOne(example);
        Preconditions.checkArgument(user != null, StateCodeConstant.STATE_404);
        HttpSession session = request.getSession();
        session.setAttribute(SysConstant.THE_LANDING_USER, user);
        return new Result();
    }

    /**
     * @api {post} /zi/base/user/register.htm 注册接口
     * @apiName register
     * @apiGroup user
     * @apiParam {String} email 用户名.
     * @apiParam {String} password 密码.
     * @apiParam {String} name 用户姓名.
     * @apiParam {String} phone 手机号.
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(User user) {
        Preconditions.checkArgument(StringUtils.isNotBlank(user.getEmail()), StateCodeConstant.STATE_404);
        Preconditions.checkArgument(StringUtils.isNotBlank(user.getPassword()), StateCodeConstant.STATE_404);
        Preconditions.checkArgument(StringUtils.isNotBlank(user.getName()), StateCodeConstant.STATE_404);
        Preconditions.checkArgument(StringUtils.isNotBlank(user.getPhone()), StateCodeConstant.STATE_404);
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(user.getEmail());
        Preconditions.checkArgument(this.getUserServlce().queryOne(example) == null, StateCodeConstant.STATE_412);
        this.getUserServlce().insert(user);
        Result result = new Result();
        result.setMessage("注册成功");
        return result;
    }
}
