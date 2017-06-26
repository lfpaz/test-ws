package br.com.testjaxrs.test;

import br.com.testjaxrs.control.IndexControl;
import br.com.testjaxrs.ejb.EjbService;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
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
public class TestEjbServiceTest extends Arquillian {

    @Inject
    private EjbService ejbService;

    @Deployment
    public static WebArchive createDeployment() {

        return ShrinkWrap.create(WebArchive.class)
                .addClass(IndexControl.class)
                .addClass(EjbService.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }

    @Test()
    public void isTextCorrect() {
        String x = ejbService.testEjb();
        Assert.assertEquals("THE POWER IS THE SOURCE CODE", x);
    }

    @Test()
    public void isNotTextCorrect() {
        String x = ejbService.testEjb();
        Assert.assertNotEquals("THE POWER IS THE BINARY", x);
    }

}
