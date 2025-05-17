package reciclaville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reciclaville.entities.Declaracao;

@Repository
public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> {

}
