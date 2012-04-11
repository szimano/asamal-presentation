package pl.softwaremill.asamal.presentation.scoped;

import pl.softwaremill.asamal.presentation.simple.DepBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DepBeanScoped {

    private DepBean depBean;

    private String appScopedProperty;

    public String getAppScopedProperty() {
        return appScopedProperty;
    }

    public void setAppScopedProperty(String appScopedProperty) {
        this.appScopedProperty = appScopedProperty;
    }

    public DepBean getDepBean() {
        return depBean;
    }

    @Inject
    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;

        depBean.setSomeString("depFromDep");
    }
}
