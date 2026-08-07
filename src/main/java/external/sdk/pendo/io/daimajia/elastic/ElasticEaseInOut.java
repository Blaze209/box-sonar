package external.sdk.pendo.io.daimajia.elastic;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class ElasticEaseInOut extends BaseEasingMethod {
    public ElasticEaseInOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        if (f == 0.0f) {
            return Float.valueOf(f2);
        }
        float f5 = f / (f4 / 2.0f);
        if (f5 == 2.0f) {
            return Float.valueOf(f2 + f3);
        }
        float f6 = 0.45000002f * f4;
        float f7 = f6 / 4.0f;
        float f8 = f5 - 1.0f;
        return f5 < 1.0f ? Float.valueOf((f3 * ((float) Math.pow(2.0d, 10.0f * f8)) * ((float) Math.sin((((f8 * f4) - f7) * 6.2831855f) / f6)) * (-0.5f)) + f2) : Float.valueOf((((float) Math.pow(2.0d, (-10.0f) * f8)) * f3 * ((float) Math.sin((((f8 * f4) - f7) * 6.2831855f) / f6)) * 0.5f) + f3 + f2);
    }
}
