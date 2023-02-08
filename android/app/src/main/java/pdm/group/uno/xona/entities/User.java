package pdm.group.uno.xona.entities;

import java.time.LocalDate;

import pdm.group.uno.xona.enums.Genre;
import pdm.group.uno.xona.enums.RelationType;
import pdm.group.uno.xona.enums.SexualOrientation;

public class User {
    Long id;
    String name;
    String lastName;
    LocalDate birthDate;
    String email;
    Genre genre;
    String bio;
    SexualOrientation sexualOrientation;
    RelationType relationType;

    public User(Long id, String name, String lastName, LocalDate birthDate, String email, Genre genre,
                String bio, SexualOrientation sexualOrientation, RelationType relationType) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.genre = genre;
        this.bio = bio;
        this.sexualOrientation = sexualOrientation;
        this.relationType = relationType;
    }

    public User() {
        this.id = null;
        this.name = null;
        this.lastName = null;
        this.birthDate = null;
        this.email = null;
        this.genre = null;
        this.bio = null;
        this.sexualOrientation = null;
        this.relationType = null;
    }
}
