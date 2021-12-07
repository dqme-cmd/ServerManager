package com.cpatt.server.enumeration;

//Provide strings for server status (up or down)


public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");
    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
