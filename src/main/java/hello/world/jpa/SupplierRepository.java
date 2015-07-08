
package hello.world.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    List<Supplier> findByLastName(String lastName);
    
    List<Supplier> findByFirstName(String firstName);
}
