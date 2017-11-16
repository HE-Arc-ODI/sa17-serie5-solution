package ch.hearc.odi.jaxperiments;


import ch.hearc.odi.business.ShoppingList;
import ch.hearc.odi.services.ShoppingListService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Path("shopping")
@RequestScoped
public class ShoppingListServiceREST implements Serializable {

    @Inject
    ShoppingListService sls;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public ShoppingList getShoppingList(@PathParam("id") Long id) {
        return sls.getShoppingList(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList creatShoppingList(@QueryParam("id") Long id, @QueryParam("name") String name) throws IllegalArgumentException {
        boolean b = sls.createShoppingList(id, name);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList updateShoppingList(@QueryParam("id") Long id, @QueryParam("name") String name) throws IllegalArgumentException {
        boolean b = sls.updateShoppingList(id, name);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public void deleteShoppingList(@PathParam("id") Long id) {
        boolean b = sls.deleteShoppingList(id);
        if (b == false) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList addItemToShoppingList(@PathParam("id") Long id, @QueryParam("idItem") Long idItem, @QueryParam("nameItem") String nameItem, @QueryParam("quantityItem") int quantityItem) {
        boolean b = sls.addItemShoppingList(id, idItem, nameItem, quantityItem);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);

        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList updateQuantityInShoppingList(@PathParam("id") Long id, @QueryParam("idItem") Long idItem, @QueryParam("quantityItem") int quantityItem) {
        boolean b = sls.updateQuantityItemShoppingList(id, idItem, quantityItem);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);

        }
    }

    @DELETE
    @Path("{id}/{idItem}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void deleteItemInShoppingList(@PathParam("id") Long id, @PathParam("idItem") Long idItem) {
        boolean b = sls.deleteItemShoppingList(id, idItem);
        if (b == false) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        }
    }
}