package br.robodroolsconsumer.domain.curso;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = {"curso"})
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Override
    @Cacheable
    List<Curso> findAll();

}

