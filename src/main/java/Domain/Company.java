package Domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Company {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "CompanyName")
    private String CompanyName;

    @Column(name = "Street")
    private String Street;

    @Column(name = "City")
    private String City;

    @Column(name = "ZpCode")
    private String ZipCode;

    public Company(){}

    public Company(String companyName, String street, String city, String zipCode){
        CompanyName = companyName;
        Street = street;
        City = city;
        ZipCode = zipCode;
    }

    public int getSupplierID() {
        return ID;
    }

    public void setSupplierID(int supplierID) {
        ID = supplierID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
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
