package pdm.group.uno.xona.entities;

import java.io.Serializable;

import pdm.group.uno.xona.enums.Genre;
import pdm.group.uno.xona.enums.RelationType;
import pdm.group.uno.xona.enums.SexualOrientation;

public class User implements Serializable {
    Long id;
    String name;
    String lastName;
    String birthDate;
    String email;
    String password;
    Genre genre;
    String bio;
    SexualOrientation sexualOrientation;
    RelationType relationType;

    public User(Long id, String name, String lastName, String birthDate, String email, Genre genre,
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

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public SexualOrientation getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }
}


//public class User implements Serializable {
//   protected String name;
//   protected String lastName;
//   protected String birthDate;
//    protected String email;
//    protected String password;
//   protected String bio;
//   protected String sexualOrientation;
//   protected String relationType;
//   //myObject = (User) getIntent().getSerializableExtra("KEY_NAME");
//
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(String birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getBio() {
//        return bio;
//    }
//
//    public void setBio(String bio) {
//        this.bio = bio;
//    }
//
//    public String getSexualOrientation() {
//        return sexualOrientation;
//    }
//
//    public void setSexualOrientation(String sexualOrientation) {
//        this.sexualOrientation = sexualOrientation;
//    }
//
//    public String getRelationType() {
//        return relationType;
//    }
//
//    public void setRelationType(String relationType) {
//        this.relationType = relationType;
//    }
//}
