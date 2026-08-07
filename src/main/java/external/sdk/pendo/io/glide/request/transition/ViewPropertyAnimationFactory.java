package external.sdk.pendo.io.glide.request.transition;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPropertyAnimationFactory<R> implements sdk.pendo.io.w.a<R> {
    private ViewPropertyTransition<R> animation;
    private final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.animator = animator;
    }

    @Override // sdk.pendo.io.w.a
    public a<R> build(sdk.pendo.io.e.a aVar, boolean z) {
        if (aVar == sdk.pendo.io.e.a.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.animation == null) {
            this.animation = new ViewPropertyTransition<>(this.animator);
        }
        return this.animation;
    }
}
