package dataBaseHandler.DAO;

import dataBaseHandler.ResultEntity;

import java.util.List;

public interface resultDao {
    public void save(ResultEntity result);
    public void delete(ResultEntity result);
    public void cleanAll();
    public List<ResultEntity> showAll();
}
