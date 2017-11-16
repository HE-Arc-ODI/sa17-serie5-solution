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


    public ShoppingList getShoppingList(Long id) {
        return mapShoppingList.get(id);
    }

    public boolean createShoppingList(Long id, String name) {
        if (id != null){
            this.mapShoppingList.put(id, new ShoppingList(id, name));
        return true;
        }
            return false;
    }

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

    public boolean deleteShoppingList(Long id){
        ShoppingList s = this.mapShoppingList.remove(id);
        if(s==null) {
            return false;
        }
            return true;
    }

    public boolean addItemShoppingList(Long idShoppingList, Long idItem, String nameItem, int quantityItem){

        if (existShoppingList(idShoppingList)==true){
            this.mapShoppingList.get(idShoppingList).addItem(new Item(idItem, nameItem, quantityItem));
            return true;
        }
        return false;
    }

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

    public boolean updateQuantityItemShoppingList(Long idShoppingList, Long idItem, int quantityItem){
        if (existShoppingList(idShoppingList)==true){
            if(this.mapShoppingList.get(idShoppingList).getItem(idItem)!=null){
            this.mapShoppingList.get(idShoppingList).getItem(idItem).setQuantity(quantityItem);
            return true;
        }
        }
        return false;
    }

    private boolean existShoppingList(Long id){

        if(this.mapShoppingList.get(id)!=null){
            return true;
        }else{
            return false;
        }

    }

}