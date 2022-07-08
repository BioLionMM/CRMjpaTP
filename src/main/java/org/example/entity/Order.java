package org.example.entity;

import org.example.util.State;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    long id;
    @ManyToOne
    @JoinColumn(name="clientId")
    Client client;
    String typePresta;
    String designation;
    int nbDays;
    float unitPrice;
    @Column(columnDefinition = "BIT")
    State state;

    public Order(){}

    public Order(Client client, String typePresta, String designation, int nbDays, float unitPrice, State state) {
        this.client = client;
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setIt(long id) {
        this.id = id;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }



    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setNotNullData(Order newOrderData) {
        if(newOrderData.getDesignation()!=null){
            this.setDesignation(newOrderData.getDesignation());
        }
        if(newOrderData.getTypePresta()!=null){
            this.setTypePresta(newOrderData.getTypePresta());
        }
        if(newOrderData.getNbDays()!=0){
            this.setNbDays(newOrderData.getNbDays());
        }
        if(newOrderData.getClient()!=null){
            this.setClient(newOrderData.getClient());
        }
        if(newOrderData.getUnitPrice()!=0){
            this.setUnitPrice(newOrderData.getUnitPrice());
        }
        if(newOrderData.getState()!=null){
            this.setState(newOrderData.getState());
        }
    }

    @Override
    public String toString() {
        return "Order{ client=" + client +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                '}';
    }
}
