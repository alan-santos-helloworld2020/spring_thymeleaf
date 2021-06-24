package com.base.spring_thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.base.spring_thymeleaf.model.ClienteModel;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel,Integer>{
	
	@Modifying
	@Query(value = "SELECT nome FROM ClienteModel  WHERE nome = ?", nativeQuery = true)
	ClienteModel getClienteModelByName(String  nome);

}
