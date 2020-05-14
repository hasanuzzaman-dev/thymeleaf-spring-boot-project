package com.hasan.thymeleaf.example.installer;

import com.hasan.thymeleaf.example.entity.User;
import com.hasan.thymeleaf.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DummyUserInstaller {

    public static final String[] FIRST_NAMES = {
            "James",
            "David",
            "Christopher",
            "George",
            "Ronald",
            "John",
            "Richard"
    };

    public static final String[] LAST_NAMES = {
            "Smith",
            "Johnson",
            "Williams",
            "Jones",
            "Brown",
            "Davis",
            "Miller",
            "Wilson"
    };

    public static final String[] EMAIL_PROVIDERS = {
            "gmail.com",
            "hotmail.com",
            "outlook.com",
            "yahoo.com"
    };
    public static final int RANDOM_USER_COUNT = 10000;

    private final UserRepository userRepository;

    @PostConstruct
    public void installUsers() {
        userRepository.deleteAll();
        Random random = new Random();
        for (int i = 0; i < RANDOM_USER_COUNT; i++) {
            userRepository.save(createRandomUser(random));
        }
    }

    private User createRandomUser(Random random) {
        String randomFirstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String randomLastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return User.builder()
                .displayName(String.format("%s %s", randomFirstName, randomLastName))
                .firstName(randomFirstName)
                .lastName(randomLastName)
                .email(String.format("%s_%s%d@%s", randomFirstName, randomLastName,
                        random.nextInt(100), EMAIL_PROVIDERS[random.nextInt(EMAIL_PROVIDERS.length)]))
                .build();
    }

}
