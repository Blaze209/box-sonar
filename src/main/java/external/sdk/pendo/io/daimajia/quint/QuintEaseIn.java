package external.sdk.pendo.io.daimajia.quint;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class QuintEaseIn extends BaseEasingMethod {
    public QuintEaseIn(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return Float.valueOf((f3 * f5 * f5 * f5 * f5 * f5) + f2);
    }
}
