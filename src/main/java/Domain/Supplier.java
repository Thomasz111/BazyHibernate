package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Suppliers")
public class Supplier extends Company{

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product prod){
        products.add(prod);
        prod.setSupplier(this);
    }

    private String bankAccountNumber;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bandAccountNumber) {
        this.bankAccountNumber = bandAccountNumber;
    }

    public Supplier(){

    }

    public Supplier(String companyName, String street, String city, String zipCode, String bankAccountNumber) {
        super(companyName, street, city, zipCode);
        this.bankAccountNumber = bankAccountNumber;
    }

}
