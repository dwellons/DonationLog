package RESTfulService;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/services") //You may want to add a value here so that all traffic isn't routed to the class below.

//The java class declares root resource and provider classes
public class Application extends javax.ws.rs.core.Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(GetDonations.class );
        h.add(GetDonationsJSON.class);
        return h;
    }
}
