package external.sdk.pendo.io.glide;

import external.sdk.pendo.io.glide.e;
import external.sdk.pendo.io.glide.request.transition.NoTransition;
import external.sdk.pendo.io.glide.request.transition.ViewAnimationFactory;
import external.sdk.pendo.io.glide.request.transition.ViewPropertyAnimationFactory;
import external.sdk.pendo.io.glide.request.transition.ViewPropertyTransition;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e<CHILD extends e<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private sdk.pendo.io.w.a<? super TranscodeType> transitionFactory = NoTransition.getFactory();

    private CHILD self() {
        return this;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m14713clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final CHILD dontTransition() {
        return (CHILD) transition(NoTransition.getFactory());
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return l.b(this.transitionFactory, ((e) obj).transitionFactory);
        }
        return false;
    }

    final sdk.pendo.io.w.a<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    public int hashCode() {
        sdk.pendo.io.w.a<? super TranscodeType> aVar = this.transitionFactory;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public final CHILD transition(int i) {
        return (CHILD) transition(new ViewAnimationFactory(i));
    }

    public final CHILD transition(ViewPropertyTransition.Animator animator) {
        return (CHILD) transition(new ViewPropertyAnimationFactory(animator));
    }

    public final CHILD transition(sdk.pendo.io.w.a<? super TranscodeType> aVar) {
        this.transitionFactory = (sdk.pendo.io.w.a) k.a(aVar);
        return (CHILD) self();
    }
}
