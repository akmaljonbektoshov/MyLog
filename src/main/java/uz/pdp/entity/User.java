package uz.pdp.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String password;
    private String email;
    private People people;
}


