package com.me.proofConcept.offices;

import java.util.List;

public class OfficeServiceImpl implements OfficeService {
	
	private OfficeDao dao = new OfficeDaoImpl();

	public int createOffice(Office office) {
		return dao.createOffice(office);
	}

	public Office getOffice(int officeId) {
		return dao.findOffice(officeId);
	}

	public List<Office> getOffices() {
		return dao.findOffices(null);
	}

	public List<Office> findOfficesOpen(String time) {
		return dao.findOffices(time);
	}
	
	public void setDao(OfficeDao dao) {
		this.dao = dao;
	}
	
}
