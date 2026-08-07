package external.sdk.pendo.io.daimajia.elastic;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class ElasticEaseOut extends BaseEasingMethod {
    public ElasticEaseOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        if (f == 0.0f) {
            return Float.valueOf(f2);
        }
        float f5 = f / f4;
        if (f5 == 1.0f) {
            return Float.valueOf(f2 + f3);
        }
        float f6 = 0.3f * f4;
        return Float.valueOf((((float) Math.pow(2.0d, (-10.0f) * f5)) * f3 * ((float) Math.sin((((f5 * f4) - (f6 / 4.0f)) * 6.2831855f) / f6))) + f3 + f2);
    }
}
