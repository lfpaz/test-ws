/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testjaxrs.test;

import br.com.testjaxrs.rws.ApplicationConfig;
import br.com.testjaxrs.rws.RestServiceResource;
import java.io.Serializable;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author lfpaz
 */
public class RestServiceTest extends Arquillian implements Serializable {

    @ArquillianResource
    private URL baseURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {

        return ShrinkWrap.create(WebArchive.class)
                .addClass(ApplicationConfig.class)
                .addClass(RestServiceResource.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }

    @Test    
    public void testGetRestServiceAndReturnCorrectString() {

        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(baseURL + "webresources/service");

        Response responseMsg = target.request().get();
      
        Assert.assertEquals(200, responseMsg.getStatus());
        Assert.assertEquals("TEST_123", responseMsg.readEntity(String.class));
    }

    
    @Test    
    public void testGetRestServiceAndReturnWrongString() {

        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(baseURL + "webresources/service");

        Response responseMsg = target.request().get();
      
        Assert.assertEquals(200, responseMsg.getStatus());
        Assert.assertNotEquals("TEST_123X", responseMsg.readEntity(String.class));
    }
}
