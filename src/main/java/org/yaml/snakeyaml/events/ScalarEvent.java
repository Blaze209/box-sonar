package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class ScalarEvent extends NodeEvent {
    private final ImplicitTuple implicit;
    private final DumperOptions.ScalarStyle style;
    private final String tag;
    private final String value;

    public ScalarEvent(String str, String str2, ImplicitTuple implicitTuple, String str3, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(str, mark, mark2);
        this.tag = str2;
        this.implicit = implicitTuple;
        if (str3 == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.value = str3;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = scalarStyle;
    }

    public String getTag() {
        return this.tag;
    }

    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }

    public String getValue() {
        return this.value;
    }

    public ImplicitTuple getImplicit() {
        return this.implicit;
    }

    @Override // org.yaml.snakeyaml.events.NodeEvent, org.yaml.snakeyaml.events.Event
    protected String getArguments() {
        return super.getArguments() + ", tag=" + this.tag + ", " + this.implicit + ", value=" + this.value;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.Scalar;
    }

    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }
}
