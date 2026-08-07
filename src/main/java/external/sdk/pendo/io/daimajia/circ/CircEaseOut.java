package external.sdk.pendo.io.daimajia.circ;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class CircEaseOut extends BaseEasingMethod {
    public CircEaseOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return Float.valueOf((f3 * ((float) Math.sqrt(1.0f - (f5 * f5)))) + f2);
    }
}
