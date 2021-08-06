package com.example.authservice;

import com.example.authservice.domain.dto.CreateUserRequest;
import com.example.authservice.domain.model.Role;
import com.example.authservice.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final List<String> usernames = List.of(
            "abc@admin.com",
            "abc@teacher.com",
            "abc@ostaff.com",
            "abc@student.com"
    );
    private final List<String> fullNames = List.of(
            "Admin-X",
            "Teacher-Y",
            "O-Staff-Z",
            "Student-A"
    );
    private final List<String> roles = List.of(
            Role.ADMIN,
            Role.TEACHER,
            Role.OTHER_STAFF,
            Role.STUDENT
    );
    private final String password = "12345";

    private final UserService userService;

    public DatabaseInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        for (int i = 0; i < usernames.size(); ++i) {
            CreateUserRequest request = new CreateUserRequest();
            request.setUsername(usernames.get(i));
            request.setFullName(fullNames.get(i));
            request.setPassword(password);
            request.setRePassword(password);
            request.setAuthorities(Set.of(roles.get(i)));

            userService.upsert(request);
        }
    }

}
