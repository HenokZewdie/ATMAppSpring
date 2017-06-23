package ATMPackage;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/23/17.
 */
public interface userRepository extends CrudRepository <User, Integer> {
    List<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
