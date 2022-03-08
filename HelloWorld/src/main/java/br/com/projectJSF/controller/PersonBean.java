package br.com.projectJSF.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projectJSF.model.Person;


@Named("personBean")
@SessionScoped
public class PersonBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Person person;
	
	List<Person> people = new ArrayList <Person>();
	
	public String add() {
		people.add(person);
		person = new Person();
		return null;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}
	
}
