package com.reservation;

public class Ticket {
   private String name;
   private int age;
   private String gender;
   private String birthPreference;
   private String confirmationStatus;


   
 
  public Ticket(String name, int age, String gender, String birthPreference) {
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.birthPreference = birthPreference;
}



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getBirthPreference() {
	return birthPreference;
}

public void setBirthPreference(String birthPreference) {
	this.birthPreference = birthPreference;
}

public String getConfirmationStatus() {
	return confirmationStatus;
}

public void setConfirmationStatus(String confirmationStatus) {
	this.confirmationStatus = confirmationStatus;
}



   
}
