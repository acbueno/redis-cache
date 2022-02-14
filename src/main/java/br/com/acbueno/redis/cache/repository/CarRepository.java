package br.com.acbueno.redis.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acbueno.redis.cache.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
