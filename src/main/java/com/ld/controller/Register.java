package com.ld.controller;

import com.ld.pojo.Worker;
import com.ld.service.WorkerService;
import com.ld.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class Register {
    @Autowired
    WorkerService workerService;
    @RequestMapping(value="regist",produces = "application/text; charset=utf-8")
    @ResponseBody
    public String register(Worker worker) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Worker worker1 = new Worker();
        String id = worker.getId();
        String password = worker.getPassword();
        if(id==null){
            return "工号未填写";
        }
        if(password==null){
            return "密码未填写";
        }
        worker1.setId(id);
        List<Worker> workers = workerService.queryByExample(worker1);
        if(workers.size()!=0){
            return "该工号已存在";
        }
        String enPassword = Md5.encryptPass(worker.getPassword());
        worker.setPassword(enPassword);
        workerService.addWorker(worker);
        return "success";
    }
}
