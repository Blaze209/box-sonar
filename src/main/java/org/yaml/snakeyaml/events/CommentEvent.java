package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class CommentEvent extends Event {
    private final CommentType type;
    private final String value;

    public CommentEvent(CommentType commentType, String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        if (commentType == null) {
            throw new NullPointerException("Event Type must be provided.");
        }
        this.type = commentType;
        if (str == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public CommentType getCommentType() {
        return this.type;
    }

    @Override // org.yaml.snakeyaml.events.Event
    protected String getArguments() {
        return super.getArguments() + "type=" + this.type + ", value=" + this.value;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.Comment;
    }
}
