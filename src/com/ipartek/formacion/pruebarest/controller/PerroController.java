package com.ipartek.formacion.pruebarest.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ipartek.formacion.pruebarest.pojo.Perro;

@Path("/perro")
public class PerroController {

	private ArrayList<Perro> listaPerros = new ArrayList<Perro>(Arrays.asList(
			new Perro("perro1", "raza1"), new Perro("perro2", "raza2")));

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.status(200).entity(this.listaPerros).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByID(@PathParam("id") int idPerro) {
		if ((idPerro > 0) && (this.listaPerros.size() > idPerro)) {
			return Response.status(200).entity(this.listaPerros.get(idPerro))
					.build();
		} else {
			return Response.status(204).build();
		}

	}

	@DELETE
	@Path("/{id}")
	public Response deleteByID(@PathParam("id") int idPerro) {
		try {
			this.listaPerros.remove(idPerro);
			return Response.status(200).entity("Perro " + idPerro + " borrado")
					.build();
		} catch (IndexOutOfBoundsException e) {
			return Response.status(500)
					.entity("El Perro " + idPerro + " no existe").build();
		}
	}

	@POST
	@Path("/{nombre}/{raza}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertarNuevo(@PathParam("nombre") String nombrePerro,
			@PathParam("raza") String razaPerro) {

		Perro perro = new Perro(nombrePerro, razaPerro);
		this.listaPerros.add(perro);

		return Response.status(200).entity(this.listaPerros).build();
	}

	@PUT
	@Path("/{id}/{nombre}/{raza}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response modificar(@PathParam("id") int idPerro,
			@PathParam("nombre") String nombrePerro,
			@PathParam("raza") String razaPerro) {

		Perro perro = new Perro(nombrePerro, razaPerro);
		try {
			this.listaPerros.set(idPerro, perro);
			return Response.status(200).entity(this.listaPerros).build();
		} catch (IndexOutOfBoundsException e) {
			return Response.status(500)
					.entity("El Perro " + idPerro + " no existe").build();
		}
	}
}
