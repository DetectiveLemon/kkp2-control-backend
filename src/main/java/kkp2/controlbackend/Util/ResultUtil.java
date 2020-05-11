package kkp2.controlbackend.Util;

import kkp2.controlbackend.Bean.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result r = new Result();
        r.setCode(0);
        r.setMsg("success!");
        r.setData(object);
        return r;
    }

    public static Result error(int code, String msg){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
