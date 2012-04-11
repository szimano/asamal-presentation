package pl.softwaremill.asamal.presentation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.softwaremill.asamal.presentation.scoped.DepBeanScoped;
import pl.softwaremill.asamal.presentation.simple.DepBean;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class ScopedCDI {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DepBeanScoped.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    @Inject
    public void shouldUseDepBean(DepBeanScoped depBean) {
        // given

        //when
        depBean.setAppScopedProperty("foo");

        //then
        Assert.assertEquals(depBean.getAppScopedProperty(), "foo");
    }

    @Test
    @Inject
    public void shouldUseDepBeanAgain(DepBeanScoped depBean) {
        // given

        //when

        //then
        Assert.assertEquals(depBean.getAppScopedProperty(), "foo");
    }
}
