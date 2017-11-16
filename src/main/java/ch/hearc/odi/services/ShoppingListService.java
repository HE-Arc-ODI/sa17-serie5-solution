/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Autor: Myriam Schaffter
 * Date: 16.11.17 10:21
 * Module: jaxperiments
 */

package ch.hearc.odi.services;

import ch.hearc.odi.business.ShoppingList;
import ch.hearc.odi.business.Item;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.HashMap;

@Stateless
public class ShoppingListService implements Serializable {

    private HashMap<Long, ShoppingList> mapShoppingList;

    /**
     * init the bean ShoppingListService
     */
    @PostConstruct
    public void init() {

        mapShoppingList = new HashMap<Long, ShoppingList>();

        Item i1 = new Item(Long.valueOf(1001), "sucre", 3);
        Item i2 = new Item(Long.valueOf(1002), "farine", 2);
        Item i3 = new Item(Long.valueOf(1003), "pomme", 10);
        Item i4 = new Item(Long.valueOf(1004), "salade", 1);
        Item i5 = new Item(Long.valueOf(1005), "fromage", 3);
        Item i6 = new Item(Long.valueOf(1006), "chocolat", 2);


        ShoppingList s1 = new ShoppingList(Long.valueOf(2001), "Pannier 1");
        s1.addItem(i1);
        s1.addItem(i2);
        s1.addItem(i3);
        s1.addItem(i4);

        ShoppingList s2 = new ShoppingList(Long.valueOf(2002), "Pannier 2");
        s2.addItem(i5);
        s1.addItem(i6);

        mapShoppingList.put(s1.getId(), s1);
        mapShoppingList.put(s2.getId(), s2);
    }


    /**
     * method get a shopping list
     * @param id of shopping list
     * @return Shopping list from the Map
     */
    public ShoppingList getShoppingList(Long id) {
        return mapShoppingList.get(id);
    }

    /**
     * method create a shopping list
     * @param id of shopping list
     * @param name of shopping list
     * @return <tt>true</tt> if the shopping list is created. <tt>false</tt> if the shopping list isn't created. The shopping list can't be create if the id is null
     */
    public boolean createShoppingList(Long id, String name) {
        if (id != null){
            this.mapShoppingList.put(id, new ShoppingList(id, name));
        return true;
        }
            return false;
    }

    /**
     * method update a shopping list
     * @param id of shopping list
     * @param name of shopping list
     * @return <tt>true</tt> if the shopping list is updated. <tt>false</tt> if the shopping list isn't update. the shopping list can't be update if the id is null.
     */
    public boolean updateShoppingList(Long id, String name){
        if (id != null) {
            ShoppingList s = this.mapShoppingList.get(id);
            if (s != null) {
                s.setName(name);;
                return true;
            }
        }

        return false;
    }

    /**
     * method delete a shopping list
     * @param id of shopping list
     * @return <tt>true</tt> if the shopping list is deleted. <tt>false</tt> if the shopping list isn't deleted. the shopping list can't be delete if the id is null.
     */
    public boolean deleteShoppingList(Long id){
        ShoppingList s = this.mapShoppingList.remove(id);
        if(s==null) {
            return false;
        }
            return true;
    }

    /**
     * method add item to a specific shopping list
     * @param idShoppingList of shopping list
     * @param idItem of item
     * @param nameItem of item
     * @param quantityItem of item
     * @return <tt>true</tt> if the item is added to a specific shopping list. <tt>false</tt> if the item isn't added to a specific shopping list. The item can't be add to a specific shopping list if this id is null or/and if the id of shopping list is null.
     */
    public boolean addItemShoppingList(Long idShoppingList, Long idItem, String nameItem, int quantityItem){

        if (existShoppingList(idShoppingList)==true){
            this.mapShoppingList.get(idShoppingList).addItem(new Item(idItem, nameItem, quantityItem));
            return true;
        }
        return false;
    }

    /**
     * method deleted item of a specific shopping list
     * @param idShoppingList of shopping list
     * @param idItem of item
     * @return <tt>true</tt> if the item is deleted from a specific shopping list. <tt>false</tt> if the item isn't deleted from a specific shopping list. The item can't be delete from a specific shopping list if this id is null or/and if the id of shopping list is null.
     */
    public boolean deleteItemShoppingList(Long idShoppingList, Long idItem){
        int i = -1;
        if (existShoppingList(idShoppingList)==true){
            if(this.mapShoppingList.get(idShoppingList).getItem(idItem)!=null)

                i = this.mapShoppingList.get(idShoppingList).getIndex(idItem);
                if(i>=0){
                    this.mapShoppingList.get(idShoppingList).getListItems().remove(i);
                    return true;
                }
        }
        return false;
    }

    /**
     * change quantity of item
     * @param idShoppingList of shopping list
     * @param idItem of item
     * @param quantityItem of item
     * @return <tt>true</tt> if the quantity of item is changed. <tt>false</tt> if the quantity of item isn't changed. The quantity of item can't be change if the id of item is null or/and if the id of shopping list is null.
     */
    public boolean updateQuantityItemShoppingList(Long idShoppingList, Long idItem, int quantityItem){
        if (existShoppingList(idShoppingList)==true){
            if(this.mapShoppingList.get(idShoppingList).getItem(idItem)!=null){
            this.mapShoppingList.get(idShoppingList).getItem(idItem).setQuantity(quantityItem);
            return true;
        }
        }
        return false;
    }

    /**
     * method test if shopping list exist in the Map
     * @param id of shopping list
     * @return <tt>true</tt> if the shopping list is in the Map. <tt>false</tt> if the shopping list isn't in the Map
     */
    private boolean existShoppingList(Long id){

        if(this.mapShoppingList.get(id)!=null){
            return true;
        }else{
            return false;
        }

    }

}