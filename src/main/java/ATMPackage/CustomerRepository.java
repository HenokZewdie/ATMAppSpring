package ATMPackage;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/23/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByAccountNo(String accountNo);
}
