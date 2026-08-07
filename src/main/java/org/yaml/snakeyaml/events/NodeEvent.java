package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NodeEvent extends Event {
    private final String anchor;

    public NodeEvent(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.anchor = str;
    }

    public String getAnchor() {
        return this.anchor;
    }

    @Override // org.yaml.snakeyaml.events.Event
    protected String getArguments() {
        return "anchor=" + this.anchor;
    }
}
