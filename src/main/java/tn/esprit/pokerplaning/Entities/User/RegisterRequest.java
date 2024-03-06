package tn.esprit.pokerplaning.Entities.User;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    private  String  firstName;
    private  String lastName;
    private  String email;
    private  String  password;
    private  Gender gender;
    private  String image;
    private  int skillRate;
    private  Role role;


}
