package pl.softwaremill.asamal.presentation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.softwaremill.asamal.presentation.interceptor.MouthSoupInterceptor;
import pl.softwaremill.asamal.presentation.interceptor.Twitter;
import pl.softwaremill.asamal.presentation.simple.DepBean;

import javax.inject.Inject;
import java.util.Arrays;

@RunWith(Arquillian.class)
public class TestInterceptorCDI {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Twitter.class)
                .addClass(MouthSoupInterceptor.class)
                .addAsManifestResource("intercepted-beans.xml", "beans.xml");
    }

    @Inject
    @Test
    public void shouldPassGoodWords(Twitter twitter) {
        // given

        //when
        twitter.tweet("Hello");

        //then
        Assert.assertEquals(twitter.getMessages(), Arrays.asList("Hello"));
    }

    @Inject
    @Test
    public void shouldCensorBadWords(Twitter twitter) {
        // given

        //when
        twitter.tweet("motyla noga");

        //then
        Assert.assertEquals(twitter.getMessages(), Arrays.asList("$%&#!!"));
    }
}
