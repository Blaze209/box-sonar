package org.yaml.snakeyaml.events;

/* JADX INFO: loaded from: classes5.dex */
public class ImplicitTuple {
    private final boolean nonPlain;
    private final boolean plain;

    public ImplicitTuple(boolean z, boolean z2) {
        this.plain = z;
        this.nonPlain = z2;
    }

    public boolean canOmitTagInPlainScalar() {
        return this.plain;
    }

    public boolean canOmitTagInNonPlainScalar() {
        return this.nonPlain;
    }

    public boolean bothFalse() {
        return (this.plain || this.nonPlain) ? false : true;
    }

    public String toString() {
        return "implicit=[" + this.plain + ", " + this.nonPlain + "]";
    }
}
