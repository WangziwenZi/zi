package com.zi.controller;

import com.google.common.base.Preconditions;
import com.zi.dal.user.entity.User;
import com.zi.dal.user.entity.UserExample;
import com.zi.sys.constant.StateCodeConstant;
import com.zi.sys.constant.SysConstant;
import com.zi.sys.factory.ServiceImplFactory;
import com.zi.sys.result.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/8/16.
 */
@Controller
@RequestMapping("/")
public class UserController extends ServiceImplFactory {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

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
        UsernamePasswordToken token = new UsernamePasswordToken(param.getEmail(), param.getPassword());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            logger.info("对用户[" + param.getEmail() + "]进行登录验证..验证开始");
            subject.login(token);
            logger.info("对用户[" + param.getEmail() + "]进行登录验证..验证通过");
        } catch (UnknownAccountException e) {
            logger.info("权限验证失败");
        }
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(param.getEmail());
        User user = this.getUserService().findByUsername(example);
        subject.getSession().setAttribute(SysConstant.THE_LANDING_USER, user);
        return new Result(true, "登录成功");
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
        this.getUserService().insert(user);
        Result result = new Result();
        result.setMessage("注册成功");
        return result;
    }
}
