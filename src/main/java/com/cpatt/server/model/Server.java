package com.cpatt.server.model;

import com.cpatt.server.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

//makes sure ip address must be unique, prevents empty or null IP addresses,
// sets up all required variables for other jobs in the code, sets up code for use in the database
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP Address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;
}
