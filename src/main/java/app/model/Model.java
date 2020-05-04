package app.model;

import app.entities.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
	private static Model instance = new Model();

	private List<User> model;

	public static Model getInstance() {
		return instance;
	}

	private Model() {
		model = new ArrayList<>();
		User user = new User("admin", "admin");
		model.add(user);
	}

	public void add(User user) {
		model.add(user);
	}

	private List<String> list() {
		return model.stream()
				.map(User::getName)
				.collect(Collectors.toList());
	}
	private String password(String name){
		return model.stream()
				.filter(x -> x.getName().equals(name))
				.map(User::getPassword)
				.collect(Collectors.joining());
	}
	public boolean isExists(String name, String password){
		Model	model 		= Model.getInstance();
		List<String> names	= model.list();
		for(String user : names)
			if(model.password(name).equals(password) && user.equals(name)) {
				return true;
			}
		return false;
	}
}
