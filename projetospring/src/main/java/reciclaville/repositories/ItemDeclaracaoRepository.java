package reciclaville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reciclaville.entities.ItemDeclaracao;

@Repository
public interface ItemDeclaracaoRepository extends JpaRepository<ItemDeclaracao, Long> {

}
