package external.sdk.pendo.io.daimajia;

import external.sdk.pendo.io.daimajia.back.BackEaseIn;
import external.sdk.pendo.io.daimajia.back.BackEaseInOut;
import external.sdk.pendo.io.daimajia.back.BackEaseOut;
import external.sdk.pendo.io.daimajia.bounce.BounceEaseIn;
import external.sdk.pendo.io.daimajia.bounce.BounceEaseInOut;
import external.sdk.pendo.io.daimajia.bounce.BounceEaseOut;
import external.sdk.pendo.io.daimajia.circ.CircEaseIn;
import external.sdk.pendo.io.daimajia.circ.CircEaseInOut;
import external.sdk.pendo.io.daimajia.circ.CircEaseOut;
import external.sdk.pendo.io.daimajia.cubic.CubicEaseIn;
import external.sdk.pendo.io.daimajia.cubic.CubicEaseInOut;
import external.sdk.pendo.io.daimajia.cubic.CubicEaseOut;
import external.sdk.pendo.io.daimajia.elastic.ElasticEaseIn;
import external.sdk.pendo.io.daimajia.elastic.ElasticEaseOut;
import external.sdk.pendo.io.daimajia.expo.ExpoEaseIn;
import external.sdk.pendo.io.daimajia.expo.ExpoEaseInOut;
import external.sdk.pendo.io.daimajia.expo.ExpoEaseOut;
import external.sdk.pendo.io.daimajia.linear.Linear;
import external.sdk.pendo.io.daimajia.quad.QuadEaseIn;
import external.sdk.pendo.io.daimajia.quad.QuadEaseInOut;
import external.sdk.pendo.io.daimajia.quad.QuadEaseOut;
import external.sdk.pendo.io.daimajia.quint.QuintEaseIn;
import external.sdk.pendo.io.daimajia.quint.QuintEaseInOut;
import external.sdk.pendo.io.daimajia.quint.QuintEaseOut;
import external.sdk.pendo.io.daimajia.sine.SineEaseIn;
import external.sdk.pendo.io.daimajia.sine.SineEaseInOut;
import external.sdk.pendo.io.daimajia.sine.SineEaseOut;

/* JADX INFO: loaded from: classes4.dex */
public enum Skill {
    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),
    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),
    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),
    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),
    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),
    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),
    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),
    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),
    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),
    Linear(Linear.class);

    private Class easingMethod;

    Skill(Class cls) {
        this.easingMethod = cls;
    }

    public BaseEasingMethod getMethod(float f) {
        try {
            return (BaseEasingMethod) this.easingMethod.getConstructor(Float.TYPE).newInstance(Float.valueOf(f));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
