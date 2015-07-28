package com.me.proofConcept.offices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class OfficeServiceImplTest {

	OfficeServiceImpl service;
	
	OfficeDao dao;
	
	@Before
	public void initTest() {
		service = new OfficeServiceImpl();
		dao = Mockito.mock(OfficeDao.class);
		service.setDao(dao);
	}
	
	@Test
	public void testCreateOffice() {
		Office testOffice = new Office();
		Mockito.when(dao.createOffice(testOffice)).thenReturn(5);
		
		int officeId = service.createOffice(testOffice);
		
		assertEquals(5, officeId);
	}
	
	@Test
	public void testGetOffice() {
		Office testOffice = new Office();
		Mockito.when(dao.findOffice(5)).thenReturn(testOffice);
		Office returnOffice = service.getOffice(5);
		assertEquals(testOffice, returnOffice);
	}
	
	@Test
	public void testGetOffices() {
		Office testOffice = new Office();
		testOffice.setOfficeId(5);
		
		List<Office> testList = new ArrayList<Office>();
		
		Mockito.when(dao.findOffices(null)).thenReturn(testList);
		List<Office> returnList = service.getOffices();
		assertEquals(testList, returnList);
	}
	
	@Test
	public void testFindOpenOffices() {
		Office testOffice = new Office();
		testOffice.setOfficeId(5);
		
		List<Office> testList = new ArrayList<Office>();
		
		Mockito.when(dao.findOffices("now")).thenReturn(testList);
		List<Office> returnList = service.findOfficesOpen("now");
		assertEquals(testList, returnList);
	}

}
