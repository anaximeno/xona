package pdm.group.uno.helpers;

import pdm.group.uno.entities.UserReaction;
import pdm.group.uno.enums.Reaction;

abstract public class Match {
    public static boolean isFromReaction(UserReaction reaction) {
        boolean match = false;

        if (reaction.getReaction() != Reaction.Like)
            return match;

        for (UserReaction userReactionReceived : reaction.getUserThatReacts().getReactionsReceived()) {
            if (userReactionReceived.getUserThatReacts().getId() == reaction.getUserThatReceivesReaction().getId()) {
                match = true;
                break;
            }
        }

        return match;
    }
}
