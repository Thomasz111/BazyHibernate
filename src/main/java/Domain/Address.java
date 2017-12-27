package Domain;

import javax.persistence.*;

@Embeddable
public class Address {

    @Column(name = "Street")
    private String Street;

    @Column(name = "City")
    private String City;

    public Address(){}

    public Address(String street, String city){
        Street = street;
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

}
