package com.image.portal.constants;

public enum ImagePortalEnum {

    MVP_USERNAME("test1");
    private String value;

    private ImagePortalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
