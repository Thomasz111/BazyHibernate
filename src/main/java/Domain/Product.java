package Domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductID;

    @ManyToOne
    @JoinColumn(name="CategoryID")
    private Category category;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Transactionx> transactions = new ArrayList<Transactionx>();

    @Column(name = "ProductName")
    private String ProductName;

    @Column(name = "UnitsOnStock")
    private int UnitsOnStock;

    @ManyToOne
    private Supplier supplier;

    public void setSupplier(Supplier supplier){
        this.supplier = supplier;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void addTransaction(Transactionx t){
        transactions.add(t);
    }

    public Product(){

    }

    public Product(String productName, int unitsOnStock) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getUnitsOnStock() {
        return UnitsOnStock;
    }

    public void setUnitsOnStock(int unitsOnStock) {
        UnitsOnStock = unitsOnStock;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }
}
