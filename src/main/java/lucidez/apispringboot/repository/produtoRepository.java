package lucidez.apispringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucidez.apispringboot.entity.Produto;

@Repository
public interface produtoRepository extends JpaRepository<Produto, Long> {

}
