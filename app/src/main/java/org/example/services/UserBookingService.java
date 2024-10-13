package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserBookingService {

    private User user;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<User> userList;

    // local database path
    private static final String USER_PATH = "../localDB/users.json";

    // Constructors
    public UserBookingService(User user) throws IOException {
        this.user = user;

        loadUserListFromFile();
    }

    private void loadUserListFromFile() throws IOException {

        // deserialization from JS to objects
        userList = objectMapper.readValue(new File(USER_PATH), new TypeReference<List<User>>() {});
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USER_PATH);
        objectMapper.writeValue(usersFile, userList);
    }





}
