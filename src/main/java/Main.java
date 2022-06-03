import models.Passport;
import models.User;
import org.hibernate.Session;
import repository.UserRepositoryImpl;
import service.UserService;
import utils.SessionFactoryImpl;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
       UserService userService = new UserService(userRepository);

//       userService.createUser(new User("Al", "Villi", "Apple"));
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

        User userAl = User.builder()
                .firstName("Al")
                .lastName("Unnamed")
                .companyName("Home")
                .build();

        Passport belarusian = Passport.builder()
                .country("Belarus")
                .passportNumber(12345678)
                .build();

        Passport usa = Passport.builder()
                .country("usa")
                .passportNumber(12345678)
                .build();

        Set<Passport> passports = new HashSet<>();
        passports.add(belarusian);
        passports.add(usa);

        userAl.setPassports(passports);

        userService.createUser(userAl);

    }
}
