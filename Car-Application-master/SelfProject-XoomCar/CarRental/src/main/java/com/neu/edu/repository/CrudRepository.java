//package com.neu.edu.repository;
//
//import java.io.Serializable;
//import java.util.Optional;
//
//import org.springframework.data.repository.Repository;
//
//public interface CrudRepository <T, ID extends Serializable> extends Repository<T, ID>{
//
//	<S extends T> S saveAll(S entity);
//	
//	Optional<T> findById(ID primaryKey);
//	
//	Iterable<T> findAll();
//	
//	Long count();
//	
//	void delete(T entity);
//	
//	boolean existsById(ID primaryKey);
//
//}
