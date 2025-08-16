package com.xworkz.army.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ArmyInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public ArmyInitializer(){
        System.out.println("Running in ArmyInitializer");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ArmyConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
