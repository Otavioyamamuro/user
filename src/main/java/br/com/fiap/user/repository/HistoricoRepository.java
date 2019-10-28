package br.com.fiap.user.repository;

import br.com.fiap.user.entity.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico,Long> {

    @Async
    @Query(value = "SELECT * FROM historico where user_id = :id",nativeQuery=true)
    List<Long> findHistorico(@Param("id") Long id);

}
