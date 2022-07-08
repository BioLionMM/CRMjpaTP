package org.example.entity;

import org.example.util.State;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
  String companyName;
  String firstName;
  String lastName;
  String email;
  String phone;
  String address;
  String zipCode;
  String city;
  String country;
    State state;

}
