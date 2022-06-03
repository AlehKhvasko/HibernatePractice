import models.User;
import org.hibernate.Session;
import repository.UserRepositoryImpl;
import service.UserService;
import utils.SessionFactoryImpl;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
       UserService userService = new UserService(userRepository);

//        userRepository.createUser(new User("Al", "Villi", "Apple"));
//        userRepository.createUser(new User("Nancy", "Samerson", "Apple"));
//        userService.removeUser(2);
        /*
        userService.update(2, User.builder()
                .lastName("Edward")
                .firstName("Hopkins")
                .companyName("GMC")
                .build());
*/
//        System.out.println(userService.readAllUsers());



    }
}
