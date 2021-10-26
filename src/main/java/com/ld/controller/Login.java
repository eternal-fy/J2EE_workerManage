package com.ld.controller;

import com.ld.pojo.Worker;
import com.ld.service.WorkerService;
import com.ld.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class Login {
    @Autowired
    WorkerService workerService;
    @RequestMapping(value="login",produces = "application/text; charset=utf-8")
    @ResponseBody
    public String login(String workerId,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if ("".equals(password)) {
            System.out.println("密码为空，客户端传值错误");
            return "密码为空，客户端传值错误";
        }
        Worker worker = new Worker();
        worker.setId(workerId);
        List<Worker> workers = workerService.queryByExample(worker);
        if (workers.size() == 0) {
            return "无此用户名";
        }
        if (workers.size() > 1) {
            System.out.println("数据库错误");
            return "数据库错误";
        }
        String realPassword = workers.get(0).getPassword();
        String transPassword = Md5.encryptPass(password);
        if (realPassword.equals(transPassword)){
            return "success";
        } else {
            return "密码错误";
        }
    }

}
