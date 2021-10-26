package com.ld.dao;

import com.ld.pojo.Worker;

import java.util.List;

public interface WorkerDao {
    public List<Worker> queryAll();
    public List<Worker> queryByExample(Worker worker);
    public void deleteById(String id);
    public int modifyByExample(Worker worker);
    public int addWorker(Worker worker);

}
