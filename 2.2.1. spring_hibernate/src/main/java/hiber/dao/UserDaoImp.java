package hiber.dao;

import hiber.model.User;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }


   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> userByCar(String model, int series) {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User WHERE car.model = :model and car.series = :series", User.class);
      query.setParameter("model", model).setParameter("series", series);
      return query.getResultList();
   }

}
