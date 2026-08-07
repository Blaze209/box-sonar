package external.sdk.pendo.io.daimajia.back;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class BackEaseOut extends BaseEasingMethod {
    private float s;

    public BackEaseOut(float f) {
        super(f);
        this.s = 1.70158f;
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        float f6 = this.s;
        return Float.valueOf((f3 * ((f5 * f5 * (((f6 + 1.0f) * f5) + f6)) + 1.0f)) + f2);
    }

    public BackEaseOut(float f, float f2) {
        this(f);
        this.s = f2;
    }
}
