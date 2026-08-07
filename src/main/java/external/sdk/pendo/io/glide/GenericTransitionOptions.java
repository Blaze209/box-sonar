package external.sdk.pendo.io.glide;

import external.sdk.pendo.io.glide.request.transition.ViewPropertyTransition;

/* JADX INFO: loaded from: classes4.dex */
public final class GenericTransitionOptions<TranscodeType> extends e<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int i) {
        return new GenericTransitionOptions().transition(i);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return new GenericTransitionOptions().dontTransition();
    }

    @Override // external.sdk.pendo.io.glide.e
    public boolean equals(Object obj) {
        return (obj instanceof GenericTransitionOptions) && super.equals(obj);
    }

    @Override // external.sdk.pendo.io.glide.e
    public int hashCode() {
        return super.hashCode();
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(ViewPropertyTransition.Animator animator) {
        return new GenericTransitionOptions().transition(animator);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(sdk.pendo.io.w.a<? super TranscodeType> aVar) {
        return new GenericTransitionOptions().transition(aVar);
    }
}
