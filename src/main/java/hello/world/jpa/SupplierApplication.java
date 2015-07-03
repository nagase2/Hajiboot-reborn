package hello.world.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupplierApplication implements CommandLineRunner {

    @Autowired
    SupplierRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of customers
        repository.save(new Supplier(1,"Jack", "Bauer"));
        repository.save(new Supplier(2,"Chloe", "O'Brian"));
//        repository.save(new Supplier("Kim", "Bauer"));
//        repository.save(new Supplier("David", "Palmer"));
//        repository.save(new Supplier("Michelle", "Dessler"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Supplier supplier : repository.findAll()) {
            System.out.println(supplier);
        }
        System.out.println();

        // fetch an individual customer by ID
        Supplier supplier = repository.findOne(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(supplier);
        System.out.println();

        // fetch customers by last name
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Supplier bauer : repository.findByLastName("Bauer")) {
            System.out.println(bauer);
        }
    }

}