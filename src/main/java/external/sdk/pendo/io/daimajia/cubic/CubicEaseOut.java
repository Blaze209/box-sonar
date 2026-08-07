package external.sdk.pendo.io.daimajia.cubic;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class CubicEaseOut extends BaseEasingMethod {
    public CubicEaseOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return Float.valueOf((f3 * ((f5 * f5 * f5) + 1.0f)) + f2);
    }
}
