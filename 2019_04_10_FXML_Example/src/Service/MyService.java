package Service;
/**
 * Copyright 2005-2014 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

import java.util.List;

import org.restlet.data.MediaType;
import org.restlet.data.Preference;
import org.restlet.data.Reference;
import org.restlet.ext.odata.Query;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ticketdbmodel.Ticket;
import ticketdbmodel.User;

/**
* Generated by the generator tool for the OData extension for the Restlet framework.<br>
*
* @see <a href="http://localhost:54613/Service.svc/$metadata">Metadata of the target OData service</a>
*
*/
public class MyService extends org.restlet.ext.odata.Service {

	private static MyService instance = new MyService();
    /**
     * Constructor.
     * 
     */
    public MyService() {
        super("http://localhost:54613/Service.svc/");
    }
    
    public static MyService getInstance() {
    	return instance;
    }

    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(ticketdbmodel.Ticket entity) throws Exception {
        addEntity("/Tickets", entity);
    }

    /**
     * Creates a query for ticket entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<ticketdbmodel.Ticket> createTicketQuery(String subpath) {
        return createQuery(subpath, ticketdbmodel.Ticket.class);
    }


    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(ticketdbmodel.User entity) throws Exception {
        addEntity("/Users", entity);
    }

    /**
     * Creates a query for user entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<ticketdbmodel.User> createUserQuery(String subpath) {
        return createQuery(subpath, ticketdbmodel.User.class);
    }


}