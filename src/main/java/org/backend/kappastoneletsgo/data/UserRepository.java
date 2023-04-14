package org.backend.kappastoneletsgo.data;

import org.backend.kappastoneletsgo.models.usermodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findByUserName(String username);

}
