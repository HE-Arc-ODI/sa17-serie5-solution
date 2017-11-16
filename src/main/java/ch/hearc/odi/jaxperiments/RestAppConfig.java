/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Autor: Myriam Schaffter
 * Date: 16.11.17 10:21
 * Module: jaxperiments
 */

package ch.hearc.odi.jaxperiments;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("rest")
public class RestAppConfig extends Application {

    /**
     * Add services to the REST Services
     * @return set of services
     */
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ShoppingListServiceREST.class);
        return resources;
    }
}
