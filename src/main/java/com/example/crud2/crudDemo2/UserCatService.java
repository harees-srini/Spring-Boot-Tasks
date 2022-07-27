package com.example.crud2.crudDemo2;

import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
@Service
@Transactional
public class UserCatService {
	  	@Autowired
	    private UserCatRepository repo;
	  	private Mstm_User_Category_DTO userCatDTO;
	  	@Autowired
	  	private Mstm_User_Category_DAO userCatDAO;
	  	
	  	
	     
	    public List<Mstm_User_Category> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Mstm_User_Category_DTO userCatDTO) {
	    	Mstm_User_Category entity = new Mstm_User_Category();
	    	entity.setName(userCatDTO.getName());
	    	entity.setCode(userCatDTO.getCode());
	    	entity.setDescription(userCatDTO.getDescription());
	        repo.save(entity);
	    }
	     
	    public Mstm_User_Category get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
	    
		public ResponseEntity<?> update(@RequestBody Mstm_User_Category_DTO userCatDTO, @PathVariable Integer id) {
		    try {
		    	Mstm_User_Category userCat = get(id);
		        userCat.setName(userCatDTO.getName());
		        userCat.setCode(userCatDTO.getCode());
		        userCat.setDescription(userCatDTO.getDescription());
		        repo.save(userCat);
		        return new ResponseEntity<>(HttpStatus.OK);
		    } catch (NoSuchElementException e) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);      
		    	}
		}
		
		public List<String> getCodeQuery() {
			return userCatDAO.getUserCatCode();
			
		}
}
