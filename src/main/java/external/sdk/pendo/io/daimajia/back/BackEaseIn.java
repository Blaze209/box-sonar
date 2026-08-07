package external.sdk.pendo.io.daimajia.back;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class BackEaseIn extends BaseEasingMethod {
    private float s;

    public BackEaseIn(float f) {
        super(f);
        this.s = 1.70158f;
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        float f6 = this.s;
        return Float.valueOf((f3 * f5 * f5 * (((1.0f + f6) * f5) - f6)) + f2);
    }

    public BackEaseIn(float f, float f2) {
        this(f);
        this.s = f2;
    }
}
