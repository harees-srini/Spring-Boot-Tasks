package com.example.crud2.crudDemo2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class Mstm_User_Category_DAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<String> getUserCatCode() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT code FROM Mstm_User_Category");
//		query.append("ORDER BY id");
		Query createNativeQuery = this.entityManager.createNativeQuery(query.toString());
		List<String> result = (createNativeQuery).getResultList();
		return result;
	}
}
