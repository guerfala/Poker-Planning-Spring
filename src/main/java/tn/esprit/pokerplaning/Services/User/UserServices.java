package tn.esprit.pokerplaning.Services.User;

import tn.esprit.pokerplaning.Entities.User.User;
import tn.esprit.pokerplaning.Repositories.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {


    @Autowired
    private UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;

    public List<User> ShowAllUsers()
    {
        List<User> users = userRepository.findAll();
        return users;
    }

    public void DeleteUser(Long id)
    {

        User user = userRepository.findById(id).get();
        this.userRepository.delete(user);
    }
    public ResponseEntity<User> GetUserById(@PathVariable Long id)
    {
        User user  = userRepository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    public  ResponseEntity<User> UpdateUser(Long id , User userDetails )
    {
         User user = userRepository.findById(id).get();

         user.setEmail(userDetails.getEmail());
         user.setFirstName(userDetails.getFirstName());
         user.setLastName(userDetails.getLastName());
         user.setImage(userDetails.getImage());
         //user.setPassword(userDetails.getPassword());
         user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
         user.setSkillRate(userDetails.getSkillRate());
         user.setRole(userDetails.getRole());

         user.setGender(userDetails.getGender());

           User  upuser = userRepository.save(user);
           return  ResponseEntity.ok(upuser);

    }
}
