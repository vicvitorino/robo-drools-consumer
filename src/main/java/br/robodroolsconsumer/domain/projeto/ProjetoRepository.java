package br.robodroolsconsumer.domain.projeto;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = {"projeto"})
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Override
    @Cacheable
    List<Projeto> findAll();

}
