package br.com.fiap.user.repository;

import br.com.fiap.user.entity.VerMaisTarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerMaisTardeRepository extends JpaRepository<VerMaisTarde,Long> {

    @Async
    @Query(value = "SELECT * FROM user.ver_mais_tarde where user_id = :id",nativeQuery=true)
    List<Long> findVerMaisTarde(@Param("id") Long id);
//
}
