package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;

/* JADX INFO: loaded from: classes5.dex */
public interface Parser {
    boolean checkEvent(Event.ID id);

    Event getEvent();

    Event peekEvent();
}
