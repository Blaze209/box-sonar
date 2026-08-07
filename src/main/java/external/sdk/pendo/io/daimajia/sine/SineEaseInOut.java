package external.sdk.pendo.io.daimajia.sine;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class SineEaseInOut extends BaseEasingMethod {
    public SineEaseInOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        return Float.valueOf((((-f3) / 2.0f) * (((float) Math.cos((((double) f) * 3.141592653589793d) / ((double) f4))) - 1.0f)) + f2);
    }
}
