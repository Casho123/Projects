package bg.softuni.space.service;

import bg.softuni.space.model.dto.UserRegistrationDTO;
import bg.softuni.space.model.entity.User;
import bg.softuni.space.model.entity.UserRole;
import bg.softuni.space.model.entity.enums.UserRoleEnum;
import bg.softuni.space.repository.UserRepository;
import bg.softuni.space.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserRoleRepository userRoleRepository;


    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public void initUserRoles() {
        if (this.userRoleRepository.count() == 0) {
            UserRole user = new UserRole(UserRoleEnum.USER);
            UserRole admin = new UserRole(UserRoleEnum.ADMIN);

            this.userRoleRepository.save(user);
            this.userRoleRepository.save(admin);

        }


    }

    public void initAdmin() {
        if (this.userRepository.count() == 0) {

            List<UserRole> roles = new ArrayList<>();
            roles.add(this.userRoleRepository.findRoleById(2L));

            User user  = new User();
            user.setName("admin");
            user.setUsername("admin");
            user.setEmail("admin@admin.com");
            user.setPassword(passwordEncoder.encode("password"));
            user.setAge(36);
            user.setUserRoles(roles);
            this.userRepository.save(user);
        }
    }

    public boolean register(UserRegistrationDTO userRegistrationDTO) {
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            return false;
        }
        Optional<User> byUsername = this.userRepository.findByUsername(userRegistrationDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }
        Optional<User> byEmail = this.userRepository.findByEmail(userRegistrationDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        User user = modelMapper.map(userRegistrationDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        List<UserRole> roles = new ArrayList<>();
        roles.add(this.userRoleRepository.findRoleById(1L));
        user.setUserRoles(roles);

        this.userRepository.save(user);




        return true;
    }
}
