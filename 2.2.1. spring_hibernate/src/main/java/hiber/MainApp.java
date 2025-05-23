package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

/*
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
*/
      User user5 = new User("User5", "Lastname5", "user5@mail.ru");
      User user6 = new User("User6", "LastName6", "user6@mail.ru");
      User user7 = new User("User7", "Lastname7", "user7@mail.ru");
      User user8 = new User("User8", "LastName8", "user8@mail.ru");



      Car car5 = new Car("Mercedes", 124);
      Car car6 = new Car("Lada", 2101);
      Car car7 = new Car("Mercedes", 124);
      Car car8 = new Car("Lada", 2121);

      userService.add(user5.setCar(car5).setUser(user5));
      userService.add(user6.setCar(car6).setUser(user6));
      userService.add(user7.setCar(car7).setUser(user7));
      userService.add(user8.setCar(car8).setUser(user8));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List<User> users1 = userService.userByCar("Mercedes", 124);
      for (User user : users1) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Model = " + user.getUserCar().getModel());
         System.out.println("Car series = " + user.getUserCar().getSeries());
         System.out.println();
      }
      context.close();
   }
}
