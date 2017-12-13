package com.azportal.service.warning.httpcontroller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface HTTPController {
	public Response startAPICallServices();

	public Response startAPIPingServices();

	public Response stopAPICallServices();

	public Response stoptAPIPingServices();
}
