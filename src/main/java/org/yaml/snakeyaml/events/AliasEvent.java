package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class AliasEvent extends NodeEvent {
    public AliasEvent(String str, Mark mark, Mark mark2) {
        super(str, mark, mark2);
        if (str == null) {
            throw new NullPointerException("anchor is not specified for alias");
        }
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.Alias;
    }
}
