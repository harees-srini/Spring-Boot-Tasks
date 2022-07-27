package com.example.crud2.crudDemo2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;

//@SqlResultSetMapping (name = "userCatMap", entities = {
//		@EntityResult(entityClass = UserCatResponseDTO.class , fields = {
//				@FieldResult(name = "id", column = "id"),
//				@FieldResult(name = "userCatCode", column = "code"),
//		}),
//	})

@Entity
public class UserCatResponseDTO {
	@Id
	private Integer id;
	private String userCatCode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCatCode() {
		return userCatCode;
	}
	public void setUserCatCode(String userCatCode) {
		this.userCatCode = userCatCode;
	}
}
