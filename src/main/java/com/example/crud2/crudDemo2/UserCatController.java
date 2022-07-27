package com.example.crud2.crudDemo2;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class UserCatController {
	@Autowired
	private UserCatService catService;
	
	public UserCatController(UserCatService catService) {
		super();
		this.catService = catService;
	}
	
    // RESTful API methods for Retrieval operations
	@GetMapping("/usercats")
	public List<Mstm_User_Category> list() {
		return catService.listAll();
	}
	
	@GetMapping("/usercats/{id}")
	public Mstm_User_Category get(@PathVariable Integer id) {
		return catService.get(id);
	}
	
    // RESTful API method for Create operation
	@PostMapping("/usercats")
	public void add(@RequestBody Mstm_User_Category_DTO userCatDTO) {
		catService.save(userCatDTO);
	}
	
    // RESTful API method for Update operation
	@PutMapping("/usercats/{id}")
	public ResponseEntity<?> update(@RequestBody Mstm_User_Category_DTO userCatDTO, @PathVariable Integer id) {
	    try {
	        catService.update(userCatDTO, id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);      
	    	}
	}
	
    // RESTful API method for Delete operation
	@DeleteMapping("/usercats/{id}")
	public void delete(@PathVariable Integer id) {
		catService.delete(id); 
	}
	
	@GetMapping("/usercats/query")
	public List<String> retrieveQuery() {
		return catService.getCodeQuery();
	}

}
