package pl.softwaremill.asamal.presentation.producer;

import pl.softwaremill.asamal.presentation.scoped.DepBeanScoped;

import javax.enterprise.inject.Produces;

public class BeanProducer {

    @Produces
    public DepBeanScoped produceDep() {
        System.out.println("Producing the bean");
        return new DepBeanScoped();
    }
}
