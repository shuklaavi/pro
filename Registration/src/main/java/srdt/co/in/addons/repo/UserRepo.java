package srdt.co.in.addons.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import srdt.co.in.addons.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
