package pl.softwaremill.asamal.presentation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.softwaremill.asamal.presentation.simple.DepBean;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class TestSimpleCDI {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DepBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    @Test
    public void shouldUseDepBean(DepBean depBean) {
        // given
        Assert.assertEquals(depBean.getSomeString(), null);

        //when
        depBean.setSomeString("foo");

        //then
        Assert.assertEquals(depBean.getSomeString(), "foo");
    }

    @Inject
    @Test
    public void shouldUseDepBeanAgain(DepBean depBean) {
        // given
        Assert.assertEquals(depBean.getSomeString(), null);

        //when
        depBean.setSomeString("bar");

        //then
        Assert.assertEquals(depBean.getSomeString(), "bar");
    }
}
