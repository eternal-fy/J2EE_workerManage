package com.ld.controller;

import com.ld.pojo.Worker;
import com.ld.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class Search {
    @Autowired
    WorkerService workerService;
    @RequestMapping("getWorkers")
    public List<Worker> getWorkers(Worker worker){
        List<Worker> workers = workerService.queryByExample(worker);
        return workers;
    }
}
