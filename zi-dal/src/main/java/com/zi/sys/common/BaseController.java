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
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String result = gson.toJson(param);
        pw.write(result);
        pw.close();
    }
}
