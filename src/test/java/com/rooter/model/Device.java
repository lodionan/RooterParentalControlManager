package com.rooter.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Device {
    private String name;
    private String macAddress;

    public Device(String name, String macAddress) {
        this.name = name;
        this.macAddress = macAddress;
    }
}
