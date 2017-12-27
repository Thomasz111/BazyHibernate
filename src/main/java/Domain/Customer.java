package Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Customer extends Company {

    public Customer(){}

    public Customer(String companyName, String street, String city, String zipCode, double discount) {
        super(companyName, street, city, zipCode);
        this.discount = discount;
    }

    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
