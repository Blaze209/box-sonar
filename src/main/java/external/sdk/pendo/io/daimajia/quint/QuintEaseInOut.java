package external.sdk.pendo.io.daimajia.quint;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class QuintEaseInOut extends BaseEasingMethod {
    public QuintEaseInOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5;
        float f6 = f / (f4 / 2.0f);
        float f7 = f3 / 2.0f;
        if (f6 < 1.0f) {
            f5 = f7 * f6 * f6 * f6 * f6 * f6;
        } else {
            float f8 = f6 - 2.0f;
            f5 = f7 * ((f8 * f8 * f8 * f8 * f8) + 2.0f);
        }
        return Float.valueOf(f5 + f2);
    }
}
