package external.sdk.pendo.io.daimajia;

import android.animation.TypeEvaluator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseEasingMethod implements TypeEvaluator<Number> {
    protected float mDuration;
    private ArrayList<EasingListener> mListeners = new ArrayList<>();

    public interface EasingListener {
        void on(float f, float f2, float f3, float f4, float f5);
    }

    public BaseEasingMethod(float f) {
        this.mDuration = f;
    }

    public void addEasingListener(EasingListener easingListener) {
        this.mListeners.add(easingListener);
    }

    public void addEasingListeners(EasingListener... easingListenerArr) {
        for (EasingListener easingListener : easingListenerArr) {
            this.mListeners.add(easingListener);
        }
    }

    public abstract Float calculate(float f, float f2, float f3, float f4);

    public void clearEasingListeners() {
        this.mListeners.clear();
    }

    @Override // android.animation.TypeEvaluator
    public final Float evaluate(float f, Number number, Number number2) {
        float f2 = this.mDuration * f;
        float fFloatValue = number.floatValue();
        float fFloatValue2 = number2.floatValue() - number.floatValue();
        float f3 = this.mDuration;
        float fFloatValue3 = calculate(f2, fFloatValue, fFloatValue2, f3).floatValue();
        Iterator<EasingListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().on(f2, fFloatValue3, fFloatValue, fFloatValue2, f3);
        }
        return Float.valueOf(fFloatValue3);
    }

    public void removeEasingListener(EasingListener easingListener) {
        this.mListeners.remove(easingListener);
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }
}
