package external.sdk.pendo.io.daimajia.bounce;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class BounceEaseOut extends BaseEasingMethod {
    public BounceEaseOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8 = f / f4;
        if (f8 < 0.36363637f) {
            f7 = 7.5625f * f8 * f8;
        } else {
            if (f8 < 0.72727275f) {
                float f9 = f8 - 0.54545456f;
                f5 = 7.5625f * f9 * f9;
                f6 = 0.75f;
            } else if (f8 < 0.9090909090909091d) {
                float f10 = f8 - 0.8181818f;
                f5 = 7.5625f * f10 * f10;
                f6 = 0.9375f;
            } else {
                float f11 = f8 - 0.95454544f;
                f5 = 7.5625f * f11 * f11;
                f6 = 0.984375f;
            }
            f7 = f5 + f6;
        }
        return Float.valueOf((f3 * f7) + f2);
    }
}
