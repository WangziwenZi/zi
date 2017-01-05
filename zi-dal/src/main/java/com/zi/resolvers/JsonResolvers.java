package com.zi.resolvers;

import com.google.gson.JsonObject;
import com.zi.annotation.JsonAnnotation;
import com.zi.sys.constant.SysConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by Administrator on 2016/8/11.
 */
public class JsonResolvers implements HandlerMethodArgumentResolver {

    Logger log = org.apache.log4j.Logger.getLogger(JsonResolvers.class);

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(JsonAnnotation.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        Enumeration<String> names = request.getParameterNames();
        JsonObject json = new JsonObject();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            log.info("JsonArgument-Name:" + name);
            String[] values = request.getParameterValues(name);
            log.info("JsonArgument-Values:" + values);
            log.info("JsonArgument-Values:" + values);
            String value = StringUtils.join(values);
            json.addProperty(name, value);
        }
        if (json.get("save") != null && StringUtils.equalsIgnoreCase(json.get("save").getAsString(), SysConstant.YES.getValue())) {
            json.addProperty("createTime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            json.addProperty("modifyTime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            json.addProperty("isDeleted", SysConstant.NO.getValue());
        } else if (json.get("update") != null && StringUtils.equalsIgnoreCase(json.get("update").getAsString(), SysConstant.YES.getValue())) {
            json.addProperty("modifyTime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        }
        return json;
    }
}
