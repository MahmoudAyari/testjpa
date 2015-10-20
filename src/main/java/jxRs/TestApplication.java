package jxRs;

import javax.ws.rs.core.Application;

import service.DeveloperService;

import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(StatusEndpoint.class);
        clazzes.add(DeveloperService.class);

        return clazzes;
    }

}