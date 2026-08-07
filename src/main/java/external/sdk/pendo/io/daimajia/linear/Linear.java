package external.sdk.pendo.io.daimajia.linear;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class Linear extends BaseEasingMethod {
    public Linear(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        return Float.valueOf(((f3 * f) / f4) + f2);
    }
}
