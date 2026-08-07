package sdk.pendo.io.c;

/* JADX INFO: loaded from: classes4.dex */
public enum a {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    private final float multiplier;

    a(float f) {
        this.multiplier = f;
    }
}
