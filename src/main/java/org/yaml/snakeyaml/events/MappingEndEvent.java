package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class MappingEndEvent extends CollectionEndEvent {
    public MappingEndEvent(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.MappingEnd;
    }
}
