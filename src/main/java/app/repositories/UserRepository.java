package app.repositories;

import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User getUserByLoginAndPassword(String login, String password);
}
