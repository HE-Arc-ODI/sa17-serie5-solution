/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Autor: Myriam Schaffter
 * Date: 16.11.17 10:20
 * Module: jaxperiments
 */

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

    /**
     * service REST get a shopping list
     * @param id
     * @return a shopping list. Format XML
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public ShoppingList getShoppingList(@PathParam("id") Long id) {
        return sls.getShoppingList(id);
    }

    /**
     * service REST add a shopping list
     * @param id of shopping list
     * @param name of shopping list
     * @return the shopping that was created. Format XML
     * @throws WebApplicationException if the id of shopping list is null
     */
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList creatShoppingList(@QueryParam("id") Long id, @QueryParam("name") String name) throws WebApplicationException {
        boolean b = sls.createShoppingList(id, name);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    /**
     * service REST update a shopping list
     * @param id of shopping list
     * @param name of shopping list
     * @return the shopping that was updated. Format XML
     * @throws WebApplicationException if the id of shopping list is null
     */
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList updateShoppingList(@QueryParam("id") Long id, @QueryParam("name") String name) throws WebApplicationException {
        boolean b = sls.updateShoppingList(id, name);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    /**
     * service REST delete a shopping list
     * @param id of shopping list
     * @throws WebApplicationException if the id of shopping list is null
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public void deleteShoppingList(@PathParam("id") Long id) throws WebApplicationException {
        boolean b = sls.deleteShoppingList(id);
        if (b == false) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

    }

    /**
     * service REST add an item to a specific shopping list
     * @param id of shopping list
     * @param idItem of new item
     * @param nameItem of new item
     * @param quantityItem of new item
     * @return the shopping list where the item was added
     * @throws WebApplicationException if the id of item or/and id of shopping list is/are null or doesn't/don't exist
     */
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList addItemToShoppingList(@PathParam("id") Long id, @QueryParam("idItem") Long idItem, @QueryParam("nameItem") String nameItem, @QueryParam("quantityItem") int quantityItem) throws WebApplicationException {
        boolean b = sls.addItemShoppingList(id, idItem, nameItem, quantityItem);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);

        }
    }

    /**
     * service REST change quantity of an item
     * @param id of shopping list
     * @param idItem of item
     * @param quantityItem of item
     * @return the shopping list where the quantity of item was changed
     * @throws WebApplicationException if the id of item or/and id of shopping list is/are null or doesn't/don't exist
     */
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ShoppingList updateQuantityInShoppingList(@PathParam("id") Long id, @QueryParam("idItem") Long idItem, @QueryParam("quantityItem") int quantityItem) throws WebApplicationException {
        boolean b = sls.updateQuantityItemShoppingList(id, idItem, quantityItem);
        if (b == true) {
            return sls.getShoppingList(id);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);

        }
    }

    /**
     * service REST delete item from a specific shopping list
     * @param id of shopping list
     * @param idItem of item
     * @throws WebApplicationException if the id of item or/and id of shopping list is/are null or doesn't/don't exist
     */
    @DELETE
    @Path("{id}/{idItem}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void deleteItemInShoppingList(@PathParam("id") Long id, @PathParam("idItem") Long idItem) throws WebApplicationException {
        boolean b = sls.deleteItemShoppingList(id, idItem);
        if (b == false) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        }
    }
}