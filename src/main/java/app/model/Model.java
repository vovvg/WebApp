package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {
	private static Model instance = new Model();

	private List<User> model;

	public static Model getInstance() {
		return instance;
	}

	private Model() {
		model = new ArrayList<>();
	}

	public void add(User user) {
		model.add(user);
	}

	public List<String> list() {
		return model.stream()
				.map(User::getName)
				.collect(Collectors.toList());
	}
	public String password(String name){
		return model.stream()
				.filter(x -> x.getName().equals(name))
				.map(User::getPassword)
				.collect(Collectors.joining());
	}
}
