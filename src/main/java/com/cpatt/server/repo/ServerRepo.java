package com.cpatt.server.repo;

//repository for database using an interface

import com.cpatt.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
//here we're managing the server (update, delete, etc) with JPA using the long type
public interface ServerRepo extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress); //compares ip address that we pass through here, you could also use find by name.

}
