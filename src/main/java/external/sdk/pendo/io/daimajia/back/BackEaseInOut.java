package external.sdk.pendo.io.daimajia.back;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class BackEaseInOut extends BaseEasingMethod {
    private float s;

    public BackEaseInOut(float f) {
        super(f);
        this.s = 1.70158f;
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5;
        float f6 = f / (f4 / 2.0f);
        float f7 = f3 / 2.0f;
        if (f6 < 1.0f) {
            float f8 = this.s;
            f5 = f7 * f6 * f6 * (((1.0f + f8) * f6) - f8);
        } else {
            float f9 = f6 - 2.0f;
            float f10 = this.s;
            f5 = f7 * ((f9 * f9 * (((1.0f + f10) * f9) + f10)) + 2.0f);
        }
        return Float.valueOf(f5 + f2);
    }

    public BackEaseInOut(float f, float f2) {
        this(f);
        this.s = f2;
    }
}
