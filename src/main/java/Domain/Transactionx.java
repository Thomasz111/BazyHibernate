package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transactionx {

    @Id
    @Column(name = "Transactionid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TransactionID;

    private int TransactionNumber;

    private int Quantity;

    @ManyToMany(mappedBy = "transactions", cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<Product>();

    public Transactionx(){}

    public Transactionx(int transactionNumber, int quantity){
        TransactionNumber = transactionNumber;
        Quantity = quantity;
    }

    public void addProduct(Product prod){
        products.add(prod);
        prod.addTransaction(this);
    }

    public int getTransactionID(){
        return TransactionID;
    }

}
