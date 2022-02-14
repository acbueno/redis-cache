package br.com.acbueno.redis.cache.services;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import br.com.acbueno.redis.cache.model.Car;
import br.com.acbueno.redis.cache.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Cacheable(cacheNames = Car.CACHE_NAME, key = "#root.method.name" )
	public List<Car> findAll(){
		return carRepository.findAll();
	}
	
	@Cacheable(cacheNames = Car.CACHE_NAME, key = "#id")
	public Car findById(Long id) {
		return carRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Id not found %f", id)));
	}
	
	@CacheEvict(cacheNames = Car.CACHE_NAME, allEntries = true)
	public Car create(final Car car) {
		return carRepository.save(car);
	}
	
	@CachePut(cacheNames = Car.CACHE_NAME, key="#car.getId()")
	public Car update(final Car car) {
		if(car.getId() == null) {
			throw new EntityNotFoundException("Id not found");
		}
		return carRepository.save(car);
	}
	
	@CacheEvict(cacheNames = Car.CACHE_NAME, key = "#id")
	public void delete(final Long id) {
		if(id == null) {
			throw new EntityNotFoundException("id not found");
		}
		carRepository.deleteById(id);
	}

}
