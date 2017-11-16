/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Autor: Myriam Schaffter
 * Date: 16.11.17 10:22
 * Module: jaxperiments
 */

package ch.hearc.odi.business;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ShoppingList")
public class ShoppingList implements Serializable {

    Long id;
    String name;
    List<Item> listItems;

    /**
     * Constructor
     */
    public ShoppingList() {
    }

    /**
     * Constructor
     * @param id of shopping list
     * @param name of shopping list
     */
    public ShoppingList(Long id, String name) {
        this.id = id;
        this.name = name;
        this.listItems = new ArrayList<Item>();
    }

    /**
     * getter id
     * @return id of ShoppingList class
     */
    public Long getId() {
        return id;
    }

    /**
     * setter id
     * @param id of shopping list
     */
    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter name
     * @return name of ShoppingList class
     */
    public String getName() {
        return name;
    }

    /**
     * setter name
     * @param name of shopping list
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter list of items
     * @return list of items of ShoppingList class
     */
    public List<Item> getListItems() {
        return listItems;
    }

    /**
     * setter list of items
     * @param listItems of shopping list
     */
    @XmlElement
    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    /**
     * method add item to list of items
     * @param item
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean addItem(Item item){
        return this.listItems.add(item);
    }

    /**
     * method get item from list of items
     * @param id of shopping list
     * @return item from list of items
     */
    public Item getItem(Long id) {
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getId().longValue()==(id.longValue())) {
                return listItems.get(i);
            }
        }
        return null;
    }

    /**
     * method get index of item from list of items
     * @param id of shopping list
     * @return index of item
     */
    public int getIndex(Long id) {
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getId().longValue()==id.longValue()) {
                return i;
            }
        }
        return -1;
    }

}