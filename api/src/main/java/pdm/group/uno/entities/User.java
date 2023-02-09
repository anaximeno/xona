package pdm.group.uno.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import pdm.group.uno.enums.Genre;
import pdm.group.uno.enums.SexualOrientation;
import pdm.group.uno.enums.RelationType;

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

    protected Genre genre;

    @Column(length = 512)
    protected String bio;

    @Column(name = "sexual_orientation")
    protected SexualOrientation sexualOrientation;

    @Column(name = "relation_type")
    protected RelationType relationType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userThatReceivesReaction")
    protected List<UserReaction> reactionsReceived;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userThatReacts")
    protected List<UserReaction> reactionsGiven;

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

    public SexualOrientation getSexualOrientation() {
        return this.sexualOrientation;
    }

    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        if (sexualOrientation != null) {
            this.sexualOrientation = sexualOrientation;
        }
    }

    public RelationType getRelationType() {
        return this.relationType;
    }

    public void setRelationType(RelationType relationType) {
        if (relationType != null) {
            this.relationType = relationType;
        }
    }

    public List<UserReaction> getReactionsReceived() {
        return reactionsReceived;
    }

    public List<UserReaction> getReactionsGiven() {
        return reactionsGiven;
    }

    @Override
    public void update(User entity) {
        setName(entity.getName());
        setLastName(entity.getLastName());
        setEmail(entity.getEmail());
        setBirthDate(entity.getBirthDate());
        setBio(entity.getBio());
        setSexualOrientation(entity.getSexualOrientation());
        setRelationType(entity.getRelationType());
        persist();
    }
}
