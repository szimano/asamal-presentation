package pl.softwaremill.asamal.presentation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.softwaremill.asamal.presentation.qualified.Blue;
import pl.softwaremill.asamal.presentation.qualified.Green;
import pl.softwaremill.asamal.presentation.qualified.Paint;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class TestQualifiedCDI {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(Paint.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    @Test
    public void shouldUseBluePaint(@Blue Paint paint) {
        // given

        //when
        String colour = paint.getColour();

        //then
        Assert.assertEquals(colour, "blue");
    }

    @Inject
    @Test
    public void shouldUseGreenPaint(@Green Paint paint) {
        // given

        //when
        String colour = paint.getColour();

        //then
        Assert.assertEquals(colour, "green");
    }
}
