package com.me.proofConcept.offices;

import java.util.List;

public interface OfficeService {
	
	int createOffice(Office office);
	
	Office getOffice(int officeId);
	
	List<Office> getOffices();
	/**
	 * Return the list of offices open
	 * @param time The time used to verify in ISO format. "now" is a valid value. 
	 * If this parameter is null all offices are returned.
	 * @return
	 */
	List<Office> findOfficesOpen(String time);
	
}
