package com.oracle.demo;

class StatusServiceImpl implements StatusService {
  private final Version _version;
  private final String _ipAddress;

  public StatusServiceImpl(final Version version, final String ipAddress) {
    _version = version;
    _ipAddress = ipAddress;
  }

  public ServerStatus getStatus() {
    return new ServerStatus("OK", _ipAddress, _version);
  }
}