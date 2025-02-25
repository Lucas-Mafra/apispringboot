package lucidez.apispringboot.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucidez.apispringboot.auth.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

}
