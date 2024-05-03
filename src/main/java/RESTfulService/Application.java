package RESTfulService;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to control the RESTful service.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */

// Defines the base URI for all resource URIs.
@ApplicationPath("/services")

// The java class declares root resource and provider classes.
public class Application extends javax.ws.rs.core.Application {

    /*
     * The method returns a non-empty collection with classes,
     * that must be included in the published JAX-RS application.
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(GetDonations.class );
        h.add(GetDonationsJSON.class);
        return h;
    }
}
