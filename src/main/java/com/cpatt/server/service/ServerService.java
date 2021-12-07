package com.cpatt.server.service;

import com.cpatt.server.model.Server;

import java.io.IOException;
import java.util.Collection;

//class to define all the functionalities I want the program to have
public interface ServerService {
    Server create(Server server);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
