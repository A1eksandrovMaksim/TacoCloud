package com.example.TacoCloud.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author aleksandrov_maksim
 */
@Data
public class RegistrationForm {
    
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public UserData toUser(PasswordEncoder passwordEncoder) {
        return new UserData(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}
