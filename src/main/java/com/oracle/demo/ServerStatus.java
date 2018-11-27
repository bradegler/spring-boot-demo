package com.oracle.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerStatus {
    private final transient String _status;
    private final transient String _ipAddress;
    private final transient Version _version;

    @JsonCreator
    public ServerStatus(@JsonProperty("status") final String status, @JsonProperty("ipAddress") final String ipAddress,
            @JsonProperty("version") final Version version) {
        this._version = version;
        this._status = status;
        this._ipAddress = ipAddress;
    }

    public String getStatus() {
        return _status;
    }

    public Version getVersion() {
        return _version;
    }

    public String getIpAddress() {
        return _ipAddress;
    }
}