package telran.java47.user.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java47.user.model.User;

public interface ServiceRepository extends MongoRepository<User, Integer>{
	
	Optional<User> findByLogin(String login);
	
	boolean existsByLogin(String login);
	
	User deleteByLogin(String login);

}
