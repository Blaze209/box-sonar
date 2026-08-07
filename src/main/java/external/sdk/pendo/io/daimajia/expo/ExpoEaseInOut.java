package external.sdk.pendo.io.daimajia.expo;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class ExpoEaseInOut extends BaseEasingMethod {
    public ExpoEaseInOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        if (f == 0.0f) {
            return Float.valueOf(f2);
        }
        if (f == f4) {
            return Float.valueOf(f2 + f3);
        }
        float f5 = f / (f4 / 2.0f);
        float f6 = f3 / 2.0f;
        float f7 = f5 - 1.0f;
        return f5 < 1.0f ? Float.valueOf((f6 * ((float) Math.pow(2.0d, f7 * 10.0f))) + f2) : Float.valueOf((f6 * ((-((float) Math.pow(2.0d, f7 * (-10.0f)))) + 2.0f)) + f2);
    }
}
