package com.xworkz.earbuds.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EarbudsInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
    public EarbudsInitializer(){
        System.out.println("Running in EarbudsInitializer");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{EarbudsConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
