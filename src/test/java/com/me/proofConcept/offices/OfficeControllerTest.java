package com.me.proofConcept.offices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class OfficeControllerTest {
	
	OfficeService service;
	
	OfficeController controller;

	@Before
	public void initTest() {
		service = Mockito.mock(OfficeService.class);
		controller = new OfficeController();
		controller.setService(service);
	}
	
	@Test
	public void testCreateOffice() {
		Office testOffice = new Office();
		Mockito.when(service.createOffice(testOffice)).thenReturn(5);
		Office returnOffice = controller.createOffice(testOffice);
		assertEquals(5, returnOffice.getOfficeId().intValue());
	}

	@Test
	public void testGetOffice() {
		Office testOffice = new Office();
		testOffice.setOfficeId(5);
		Mockito.when(service.getOffice(5)).thenReturn(testOffice);
		Office returnOffice = controller.getOffice(5);
		assertEquals(5, returnOffice.getOfficeId().intValue());
	}
	
	@Test
	public void testGetOfficeNotFound() {
		Office testOffice = new Office();
		testOffice.setOfficeId(5);
		Mockito.when(service.getOffice(5)).thenReturn(null);
		
		try {
			controller.getOffice(5);
		} catch(WebApplicationException e) {
			assertEquals(Response.Status.NOT_FOUND, e.getResponse().getStatusInfo());
			return;
		}
		fail();
	}
	
	@Test
	public void testGetOffices() {
		Office testOffice = new Office();
		testOffice.setOfficeId(5);
		
		List<Office> testList = new ArrayList<Office>();
		testList.add(testOffice);
		Mockito.when(service.getOffices()).thenReturn(testList);
		List<Office> listResult = controller.getOffices(null);
		
		assertEquals(testList,listResult);
	}
	
	@Test
	public void testGetOfficesOpen() {
		Office testOffice = new Office();
		testOffice.setOfficeId(5);
		
		List<Office> testList = new ArrayList<Office>();
		testList.add(testOffice);
		Mockito.when(service.findOfficesOpen("now")).thenReturn(testList);
		
		List<Office> listResult = controller.getOffices("now");
		
		assertEquals(testList,listResult);
	}
}
