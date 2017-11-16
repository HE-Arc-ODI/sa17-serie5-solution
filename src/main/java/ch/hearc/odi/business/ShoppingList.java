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

    public ShoppingList() {
    }

    public ShoppingList(Long id, String name) {
        this.id = id;
        this.name = name;
        this.listItems = new ArrayList<Item>();
    }

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    @XmlElement
    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public boolean addItem(Item item){
        return this.listItems.add(item);
    }

    public Item getItem(Long id) {
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getId().longValue()==(id.longValue())) {
                return listItems.get(i);
            }
        }
        return null;
    }

    public int getIndex(Long id) {
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getId().longValue()==id.longValue()) {
                return i;
            }
        }
        return -1;
    }

}