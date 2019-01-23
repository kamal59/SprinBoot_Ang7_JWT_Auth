package com.training.jwt.services.admin.assoManagement;

import java.util.List;

import com.training.jwt.entities.OperationBO;

public interface IOperationManagement {
	
	OperationBO addOperation(OperationBO op);
	OperationBO updateOperation(OperationBO op);
	OperationBO getOperation(String criteria);
	List<OperationBO> getAllOperations();
	void deleteOperation(String operation);
	

}
