package nstarlike.jcm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nstarlike.jcm.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
