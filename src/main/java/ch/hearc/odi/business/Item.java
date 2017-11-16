/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Autor: Myriam Schaffter
 * Date: 16.11.17 10:21
 * Module: jaxperiments
 */

package ch.hearc.odi.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Item")
public class Item implements Serializable {

    Long id;
    String name;
    int quantity;

    /**
     * Constructor
     */
    public Item(){}

    /**
     * Constructor
     * @param id of item
     * @param name of item
     * @param quantity of item
     */
    public Item(Long id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * getter of id
     * @return id of Item class
     */
    public Long getId() {
        return id;
    }

    /**
     * setter of id
     * @param id of item
     */
    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter of name
     * @return name of Item class
     */
    public String getName() {
        return name;
    }

    /**
     * setter of name
     * @param name of item
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter of quantity
     * @return quantity of Item class
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * setter of quantity
     * @param quantity of item
     */
    @XmlElement
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
