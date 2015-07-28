package com.me.proofConcept.offices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


@Path("/office_manager")
public class OfficeController {
	
	private OfficeService service = new OfficeServiceImpl();

	
	@POST
	@Path("/office")
	@Consumes("application/json")
	@Produces("application/json")
	public Office createOffice(Office office) {
		
		Integer officeId = service.createOffice(office);
		
		office.setOfficeId(officeId);
		
		return office;
	}
	
	@GET
	@Path("/office/{officeId}")
	@Produces("application/json")
	public Office getOffice(@PathParam("officeId") Integer officeId) {
		
		Office retVal = service.getOffice(officeId);
		
		//For the REST service we decided to send 404
		if(retVal==null) {
			throw new WebApplicationException("No Office found with the ID: " + officeId, Response.Status.NOT_FOUND);
		}
		
		return retVal;
	}
	
	@GET
	@Path("/office")
	@Produces("application/json")
	public List<Office> getOffices(@QueryParam("open") String time) {
		if(time == null) {
			return service.getOffices();
		} else {
			return service.findOfficesOpen(time);
		}
	}
	
	public void setService(OfficeService service) {
		this.service = service;
	}
	

}
