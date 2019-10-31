package comt.tieunt.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import comt.tieunt.springboot.model.User;
import comt.tieunt.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringBootLearningApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootLearningApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		System.out.println("Tim user voi Agi trong khoang (25, 30)");
		System.out.println("findAllByAgiBetween: ");
		userRepository.findAllByAgiBetween(25, 30).forEach(System.out::println);

		System.out.println("=========================================");
		System.out.println("Tim user voi Agi trong lon hon 97");
		System.out.println("findAllByAgiGreaterThan: ");
		userRepository.findAllByAgiGreaterThan(97).forEach(System.out::println);

		System.out.println("=========================================");
		System.out.println("Tim User voi Atk = 74");
		System.out.println("findAllByAtk: ");
		userRepository.findAllByAtk(74).forEach(System.out::println);

		System.out.println("=========================================");
		System.out.println("Tim User voi def = 49");
		System.out.println("SELECT u FROM User u WHERE u.def = :def");
		User user = userRepository.findUserByDefQuery(49);
		System.out.println("User: " + user);
	}

}
