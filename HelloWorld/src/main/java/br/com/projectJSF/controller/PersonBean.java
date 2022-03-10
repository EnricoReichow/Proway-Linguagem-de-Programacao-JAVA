package br.com.projectJSF.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projectJSF.model.Person;

@Named("personBean")
@SessionScoped
public class PersonBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Person person;

	List<Person> people = new ArrayList<Person>();
	private int counter = 1;

	public String add() {
		person.setId(this.counter);
		this.counter++;
		people.add(person);
		person = new Person();
		return "/pages/listPeople.xhtml";
	}

	public String delete(Person p) {
		int index = people.indexOf(p);
		people.remove(index);
		return "/pages/listPeople.xhtml";
	}

	public String edit() {
		int index = people.indexOf(person);
		Person p = person;

		for (Person p2 : people) {
			if (p2.getId() == person.getId()) {
				index = people.indexOf(p2);
			}
		}

		people.set(index, p);
		person = new Person();
		return "/pages/listPeople.xhtml";
	}

	public String editScreen() {
		return "/pages/editPerson.xhtml";
	}

	public void loadEdits(ActionEvent event) {
		Person p = (Person) event.getComponent().getAttributes().get("person");

		person.setId(p.getId());
		person.setAge(p.getAge());
		person.setName(p.getName());
		person.setJob(p.getJob());
		person.setCity(p.getCity());

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
