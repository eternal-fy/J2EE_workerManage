package com.ld.controller;

import com.ld.pojo.Worker;
import com.ld.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Modify {
    @Autowired
    WorkerService workerService;

    @ResponseBody
    @RequestMapping("modifyWorker")
    public String modifyWorker(Worker worker){
        int i = workerService.modifyByExample(worker);
        if(i>0)
            return "success";
        else
            return "false";
    }
}
