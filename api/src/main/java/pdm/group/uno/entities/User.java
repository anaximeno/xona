package pdm.group.uno.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import pdm.group.uno.enums.Genre;
import pdm.group.uno.helpers.UpdatableEntity;

@Entity
@Table(name = "users")
public class User extends PanacheEntity implements UpdatableEntity<User> {
    @Column(length = 100)
    protected String name;

    @Column(length = 100, name = "last_name")
    protected String lastName;

    @Column(name = "birth_date")
    protected LocalDate birthDate;

    @Column(length = 255, unique = true)
    protected String email;

    protected String password;

    protected Genre genre;

    @Column(length = 512)
    protected String bio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id != null) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        if (genre != null) {
            this.genre = genre;
        }
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate != null) {
            this.birthDate = birthDate;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        if (bio != null) {
            this.bio = bio;
        }
    }

    public void update(User user) {
        setName(user.name);
        setLastName(user.lastName);
        setEmail(user.email);
        setBirthDate(user.birthDate);
        setBio(user.bio);
        persist();
    }
}
