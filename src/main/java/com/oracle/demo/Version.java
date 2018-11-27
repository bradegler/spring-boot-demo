package com.oracle.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Version {
    private final transient String _version;
    private final transient String _revision;
    private final transient String _buildDate;
    private final transient String _application;

    @JsonCreator
    public Version(
            @JsonProperty("version") final String version,
            @JsonProperty("revision") final String revision,
            @JsonProperty("buildDate") final String buildDate,
            @JsonProperty("application") final String application
    ) {
        this._version = version;
        this._revision = revision;
        this._buildDate = buildDate;
        this._application = application;
    }

    public String getVersion(){ return _version; }
    public String getRevision(){ return _revision; }
    public String getBuildDate(){ return _buildDate; }
    public String getApplication(){ return _application; }


}