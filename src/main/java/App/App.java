package App;

import Domain.Category;
import Domain.Product;
import Domain.Transactionx;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class App {

    Session session;
    Scanner reader;
    int transactionNumber = 0;

    public App(Session session){
        this.session = session;
    }

    public void run(){
        int option;
        reader = new Scanner(System.in);
        while(true){
            System.out.println("1. show products");
            System.out.println("2. show categories");
            System.out.println("3. show products from category");
            System.out.println("4. order products");
            System.out.println("5. exit");

            option = reader.nextInt();
            if(option == 1){
                showProducts();
            } else if(option == 2){
                showCategories();
            }else if(option == 3){
                showProductsFromCategory();
            }else if(option == 4){
                orderProducts();
            }else if(option == 5){
                return;
            }
        }
    }

    private void showProducts(){
        Query query = session.createQuery("from Product");
        List<Product> products = query.getResultList();

        for(Product p : products)
            System.out.println(p.getProductName());
    }

    private void showProductsFromCategory(){
        System.out.println("Category name:");
        String category = reader.next();
        Query query = session.createQuery("from Product as p where p.category.name=:cat");
        query.setParameter("cat", category);
        List<Product> products = query.getResultList();

        for(Product p : products)
            System.out.println(p.getProductName());
    }

    private void showCategories(){
        Query query = session.createQuery("from Category ");
        List<Category> categories = query.getResultList();

        for(Category c : categories)
            System.out.println(c.getName());
    }

    private void orderProducts(){
        System.out.println("Quantity:");
        int quantity = reader.nextInt();
        Transactionx t = new Transactionx(transactionNumber,quantity);
        transactionNumber++;
        int option;
        while(true){
            System.out.println("1. order next product");
            System.out.println("2. exit");
            option = reader.nextInt();
            if(option == 1){
                System.out.println("product name");
                String productName = reader.next();
                Query query = session.createQuery("from Product as p where p.ProductName=:name");
                query.setParameter("name", productName);
                Product p = (Product)query.getSingleResult();
                t.addProduct(p);
            } else if(option == 2){
                session.persist(t);
                return;
            }
        }
    }
}
