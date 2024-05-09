package dataBaseHandler.service;

import dataBaseHandler.ResultEntity;

import java.util.List;

public interface resultService {

    void addResult(ResultEntity result);
    void cleanResults();
    List<ResultEntity> getAllResults();
    void deleteResult(ResultEntity result);

}
