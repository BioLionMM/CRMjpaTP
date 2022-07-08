package org.example.entity;

import org.example.util.State;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long it;
    @ManyToOne
    @JoinColumn(name="client_id")
    int clientId;
    String typePresta;
    String designation;
    int nbDays;
    float unitPrice;
    float totalExcludeTaxes;
    float totalWithTaxes;
    State state;

}
