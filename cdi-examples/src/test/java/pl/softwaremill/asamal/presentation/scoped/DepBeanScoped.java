package pl.softwaremill.asamal.presentation.scoped;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepBeanScoped {

    private String appScopedProperty;

    public String getAppScopedProperty() {
        return appScopedProperty;
    }

    public void setAppScopedProperty(String appScopedProperty) {
        this.appScopedProperty = appScopedProperty;
    }
}
