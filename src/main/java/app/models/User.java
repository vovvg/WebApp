package app.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;

	public static User from(UserForm form) {
		return User.builder()
				.login(form.getLogin())
				.password(form.getPassword())
				.build();
	}
}
