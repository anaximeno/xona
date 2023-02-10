package pdm.group.uno.xona.entities;

import pdm.group.uno.xona.enums.Reaction;

public class UserReaction {
    User userThatReacts;
    User userThatReceivesReaction;
    Reaction reaction;

    public UserReaction(User userThatReacts, User userThatReceivesReaction, Reaction reaction) {
        this.userThatReacts = userThatReacts;
        this.userThatReceivesReaction = userThatReceivesReaction;
        this.reaction = reaction;
    }

    public UserReaction() {}
}
