package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class MappingStartEvent extends CollectionStartEvent {
    public MappingStartEvent(String str, String str2, boolean z, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(str, str2, z, mark, mark2, flowStyle);
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.MappingStart;
    }
}
