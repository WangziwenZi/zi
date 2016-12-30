package com.zi.sys.common;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/21.
 */
public class BaseController {

    public void write(HttpServletResponse response, Object param) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            Gson gson = new Gson();
            String result = gson.toJson(param);
            pw.write(result);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) pw.close();
        }
    }
}
