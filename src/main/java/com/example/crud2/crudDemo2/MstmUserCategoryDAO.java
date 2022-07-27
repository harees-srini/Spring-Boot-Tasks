package com.example.crud2.crudDemo2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class MstmUserCategoryDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<UserCatResponseDTO> getUserCatCode() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT id, code FROM Mstm_User_Category ORDER BY id");
		Query createNativeQuery = entityManager.createNativeQuery(query.toString(), "userCatMap");
		List<UserCatResponseDTO> result = (createNativeQuery).getResultList();
		return result;
	}
}
