import models.User;
import org.hibernate.Session;
import repository.UserRepositoryImpl;
import service.UserService;
import utils.SessionFactoryImpl;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
       userRepository.createUser(new User("Al", "Villi", "Apple"));
        userRepository.createUser(new User("Nancy", "Samerson", "Apple"));

//        userRepository.readAllUsers().forEach(System.out::println);
//        System.out.println(userRepository.getById(1));
//        System.out.println(userRepository.update(1, new User("No name", "No name", "No name")));
//        userRepository.removeUser(1);
//        UserService userService = new UserService(new UserRepositoryImpl());
//        System.out.println( userService.getById(null) );
//        System.out.println(userService.readAllUsers());
//        System.out.println(userService.update(null,null));
//        userService.createUser(new User(null, null, null));
//        userService.removeUser(null);
    }
}
