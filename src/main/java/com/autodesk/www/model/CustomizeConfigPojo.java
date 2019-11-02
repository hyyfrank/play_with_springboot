package com.autodesk.www.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "frank.customize")
@PropertySource(value="classpath:customize.properties")
public class CustomizeConfigPojo {
    private String customize_key1;
    private String customize_key2;

    public String getCustomize_key1() {
        return customize_key1;
    }

    public void setCustomize_key1(String customize_key1) {
        this.customize_key1 = customize_key1;
    }

    public String getCustomize_key2() {
        return customize_key2;
    }

    public void setCustomize_key2(String customize_key2) {
        this.customize_key2 = customize_key2;
    }
}
