package org.yaml.snakeyaml.events;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Event {
    private final Mark endMark;
    private final Mark startMark;

    public enum ID {
        Alias,
        Comment,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    public abstract ID getEventId();

    public Event(Mark mark, Mark mark2) {
        this.startMark = mark;
        this.endMark = mark2;
    }

    public String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + "(" + getArguments() + ")>";
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    protected String getArguments() {
        return "";
    }

    public boolean is(ID id) {
        return getEventId() == id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
