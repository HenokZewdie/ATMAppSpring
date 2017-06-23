package ATMPackage;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 6/23/17.
 */
public interface AccountRepository extends CrudRepository<Customer, Integer> {
}
