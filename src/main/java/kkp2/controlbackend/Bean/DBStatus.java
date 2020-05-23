package kkp2.controlbackend.Bean;

public class DBStatus {
    private String host;
    private String version;
    private double uptime;
    private int connections_current;
    private int connections_active;
    private int connections_available;
    private int connections_totalCreated;
    private double bytesIn;
    private double bytesOut;

    public DBStatus() {
    }

    public DBStatus(String host, String version, double uptime, int connections_current, int connections_active, int connections_available, int connections_totalCreated, double bytesIn, double bytesOut) {
        this.host = host;
        this.version = version;
        this.uptime = uptime;
        this.connections_current = connections_current;
        this.connections_active = connections_active;
        this.connections_available = connections_available;
        this.connections_totalCreated = connections_totalCreated;
        this.bytesIn = bytesIn;
        this.bytesOut = bytesOut;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getUptime() {
        return uptime;
    }

    public void setUptime(double uptime) {
        this.uptime = uptime;
    }

    public int getConnections_current() {
        return connections_current;
    }

    public void setConnections_current(int connections_current) {
        this.connections_current = connections_current;
    }

    public int getConnections_active() {
        return connections_active;
    }

    public void setConnections_active(int connections_active) {
        this.connections_active = connections_active;
    }

    public int getConnections_available() {
        return connections_available;
    }

    public void setConnections_available(int connections_available) {
        this.connections_available = connections_available;
    }

    public int getConnections_totalCreated() {
        return connections_totalCreated;
    }

    public void setConnections_totalCreated(int connections_totalCreated) {
        this.connections_totalCreated = connections_totalCreated;
    }

    public double getBytesIn() {
        return bytesIn;
    }

    public void setBytesIn(double bytesIn) {
        this.bytesIn = bytesIn;
    }

    public double getBytesOut() {
        return bytesOut;
    }

    public void setBytesOut(double bytesOut) {
        this.bytesOut = bytesOut;
    }
}
