package br.com.daniel.loteria.repository;

import br.com.daniel.loteria.model.Sorteio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SorteioRepository extends JpaRepository<Sorteio, Long> {

    boolean existsByNumeroSorteadoAndUsuario_Cpf(String numero, String cpf);

    List<Sorteio> findAllByUsuario_Id(Long id);


}
