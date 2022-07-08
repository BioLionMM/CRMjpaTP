package org.example.entity;

import org.example.util.State;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(columnDefinition = "INT")
    long id;
  String companyName;
  String firstName;
  String lastName;
  String email;
  String phone;
  @Column(columnDefinition = "TEXT")
  String address;
  String zipCode;
  String city;
  String country;
  @Column(columnDefinition = "BIT")
  private State state;

  public Client(){};
  public Client( String firstName, String lastName, String email,
                 String phone,String companyName,
                 String address, String zipCode, String city, String country, State state) {
    this.companyName = companyName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
    this.state = state;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public void setNotNullData(Client newClientData) {
    if(newClientData.getFirstName()!=null){
      System.out.println("Prenom change");
      this.setFirstName(newClientData.getFirstName());
    }
    if(newClientData.getLastName()!=null){
      System.out.println("Nom change");
      this.setLastName(newClientData.getLastName());
    }
    if(newClientData.getEmail()!=null){
      System.out.println("Mail change");
      this.setEmail(newClientData.getEmail());
    }
    if(newClientData.getPhone()!=null){
      this.setPhone(newClientData.getPhone());
    }
    if(newClientData.getAddress()!=null){
      this.setAddress(newClientData.getAddress());
    }
    if(newClientData.getCity()!=null){
      this.setAddress(newClientData.getAddress());
    }
    if(newClientData.getCountry()!=null){
      this.setCountry(newClientData.getCountry());
    }
    if(newClientData.getZipCode()!=null){
      this.setZipCode(newClientData.getZipCode());
    }
    if(newClientData.getCompanyName()!=null){
      this.setCompanyName(newClientData.getCompanyName());
    }
    if(newClientData.getState()!=null){
      this.setState(newClientData.getState());
    }

  }

  @Override
  public String toString() {
    return "Client{" +
            "companyName='" + companyName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", zipCode='" + zipCode + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            ", state=" + state +
            '}';
  }
}
