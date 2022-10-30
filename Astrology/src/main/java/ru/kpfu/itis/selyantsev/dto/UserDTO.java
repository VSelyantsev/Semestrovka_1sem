package ru.kpfu.itis.selyantsev.dto;

import ru.kpfu.itis.selyantsev.models.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String login;

    private String email;

    public UserDTO(String firstName, String lastName, String login, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
    }

    public String getEmail() {
        return email;
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
