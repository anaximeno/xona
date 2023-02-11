package pdm.group.uno.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import pdm.group.uno.enums.Reaction;
import pdm.group.uno.helpers.UpdatableEntity;


@Entity
@Table(name = "user_reactions")
public class UserReaction extends PanacheEntity implements UpdatableEntity<UserReaction> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_that_received_reaction_id")
    protected User userThatReceivesReaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_that_reacts_id")
    protected User userThatReacts;

    protected Reaction reaction;

    public void setReaction(Reaction reaction) {
        if (reaction != null) {
            this.reaction = reaction;
        }
    }

    public Reaction getReaction() {
        return this.reaction;
    }

    public void setUserThatReceivesReaction(User user) {
        if (user != null) {
            this.userThatReceivesReaction = user;
        }
    }

    public User getUserThatReceivesReaction() {
        return this.userThatReceivesReaction;
    }

    public void setUserThatReacts(User user) {
        if (user != null) {
            this.userThatReacts = user;
        }
    }

    public User getUserThatReacts() {
        return this.userThatReacts;
    }

    @Override
    public void update(UserReaction entity) {
        setUserThatReacts(entity.getUserThatReacts());
        setUserThatReceivesReaction(entity.getUserThatReceivesReaction());
        setReaction(entity.getReaction());
        persist();
    }
}
