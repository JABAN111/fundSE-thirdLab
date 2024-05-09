package dataBaseHandler.DAO;

import dataBaseHandler.ResultEntity;
import dataBaseHandler.utils.HibernateSessionFactoryUtil;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
@ManagedBean
@RequestScoped
@NoArgsConstructor
public class ResultDaoImpl implements resultDao {

    @Override
    public List<ResultEntity> showAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Query<ResultEntity> query = session.createQuery("FROM ResultEntity", ResultEntity.class);
            List<ResultEntity> results = query.list();

            tx.commit();
            return results;
        } catch (Exception e) {
            System.err.println("Can't show all");
        }
        return null;
    }


    @Override
    public void save(ResultEntity result) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(result);
            tx.commit();
        } catch (Exception e) {
            System.err.println("can't save this result");
        }
    }

    @Override
    public void delete(ResultEntity result) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(result);

            tx.commit();
        } catch (Exception e) {
            System.err.println("Can't delete the file");
        }
    }
    @Override
    public void cleanAll(){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Query<?> query = session.createQuery("DELETE FROM ResultEntity");

            query.executeUpdate();

            tx.commit();
        } catch (Exception e) {
            System.err.println("Не удалось очистить всю таблицу");
        }
    }
}
