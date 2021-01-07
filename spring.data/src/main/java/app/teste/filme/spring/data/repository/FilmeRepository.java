package app.teste.filme.spring.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.teste.filme.spring.data.orm.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

}
