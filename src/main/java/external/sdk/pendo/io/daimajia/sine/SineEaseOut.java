package external.sdk.pendo.io.daimajia.sine;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class SineEaseOut extends BaseEasingMethod {
    public SineEaseOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        return Float.valueOf((f3 * ((float) Math.sin(((double) (f / f4)) * 1.5707963267948966d))) + f2);
    }
}
