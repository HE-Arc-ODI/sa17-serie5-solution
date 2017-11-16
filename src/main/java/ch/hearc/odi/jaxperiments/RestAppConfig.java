package ch.hearc.odi.jaxperiments;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class RestAppConfig extends Application {

    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ShoppingListServiceREST.class);
        return resources;
    }
}
