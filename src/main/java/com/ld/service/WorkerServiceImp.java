package com.ld.service;

import com.ld.dao.WorkerDao;
import com.ld.pojo.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImp implements WorkerService {
    @Autowired
    WorkerDao workerDao;
    @Override
    public List<Worker> queryAll() {
        return workerDao.queryAll();
    }

    @Override
    public List<Worker> queryByExample(Worker worker) {
        return workerDao.queryByExample(worker);
    }

    @Override
    public void deleteById(String id) {
        workerDao.deleteById(id);
    }

    @Override
    public int modifyByExample(Worker worker) {
        return workerDao.modifyByExample(worker);
    }

    @Override
    public int addWorker(Worker worker) {
        return workerDao.addWorker(worker);
    }
}
