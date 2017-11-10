package com.springboot.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.services.CustomerService;

@Path("/customer")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class CustomerRest {

	@Autowired
	@Qualifier("csJpaImpl")
	private CustomerService cs;

	@POST
	public Response create(final CustomerData customer) {
		final CustomerData entity = cs.createCustomer(customer);
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/{custId}")
	public Response find(@PathParam("custId") final Long key) {
		final CustomerData entity = cs.findCustomer(key);
		return Response.ok().entity(entity).build();
	}

	@PUT
	public Response modify(final CustomerData customer) {
		cs.modifyCustomer(customer);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{custId}")
	public Response remove(@PathParam("custId") final Long key) {
		cs.removeCustomer(key);
		return Response.noContent().build();
	}

	@GET
	public Response search(@QueryParam("searchStr") final String name) {
		final List<CustomerData> customerResult = cs.searchCustomer(name);
		CustomerSearchResults entity = new CustomerSearchResults(customerResult);
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/searchByMatrix")
	public Response searchByMatrix(@MatrixParam("searchStr") final String name) {
		final List<CustomerData> customerResult = cs.searchCustomer(name);
		CustomerSearchResults entity = new CustomerSearchResults(customerResult);
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/hdr")
	public Response sampleHdr(@HeaderParam("auth-key") final String authKey,
			@HeaderParam("app-version") final String appVersion) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("authKey", authKey);
		jsonObj.put("appVersion", appVersion);
		return Response.ok().entity(jsonObj.toString()).build();
	}
}
