package com.me.proofConcept.offices;

import java.util.List;

public interface OfficeDao {
	
	int createOffice(Office office);
	
	Office findOffice(Integer officeId);
	
	List<Office> findOffices(String time);

}
