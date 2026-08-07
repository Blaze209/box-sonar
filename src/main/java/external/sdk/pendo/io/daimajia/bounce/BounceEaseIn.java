package external.sdk.pendo.io.daimajia.bounce;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* JADX INFO: loaded from: classes4.dex */
public class BounceEaseIn extends BaseEasingMethod {
    private BounceEaseOut mBounceEaseOut;

    public BounceEaseIn(float f) {
        super(f);
        this.mBounceEaseOut = new BounceEaseOut(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        return Float.valueOf((f3 - this.mBounceEaseOut.calculate(f4 - f, 0.0f, f3, f4).floatValue()) + f2);
    }
}
