package com.gateway.utils;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties implements EnvironmentAware {
    private Environment env;

    @Override
    public void setEnvironment(final Environment environment) {
        this.env = environment;
    }

    public String getConfigValue(String configKey){
        return env.getProperty(configKey);
    }
}