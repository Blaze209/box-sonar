package external.sdk.pendo.io.daimajia.quad;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class QuadEaseInOut extends BaseEasingMethod {
    public QuadEaseInOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5;
        float f6 = f / (f4 / 2.0f);
        if (f6 < 1.0f) {
            f5 = (f3 / 2.0f) * f6;
        } else {
            f5 = (-f3) / 2.0f;
            float f7 = f6 - 1.0f;
            f6 = (f7 * (f7 - 2.0f)) - 1.0f;
        }
        return Float.valueOf((f5 * f6) + f2);
    }
}
