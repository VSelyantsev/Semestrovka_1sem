package ru.kpfu.itis.selyantsev.dto;

import ru.kpfu.itis.selyantsev.models.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String login;

    public UserDTO(String firstName, String lastName, String login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }

    public UserDTO(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }
}
