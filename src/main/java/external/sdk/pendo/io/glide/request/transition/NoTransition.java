package external.sdk.pendo.io.glide.request.transition;

/* JADX INFO: loaded from: classes4.dex */
public class NoTransition<R> implements a<R> {
    static final NoTransition<?> NO_ANIMATION = new NoTransition<>();
    private static final sdk.pendo.io.w.a<?> NO_ANIMATION_FACTORY = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements sdk.pendo.io.w.a<R> {
        @Override // sdk.pendo.io.w.a
        public a<R> build(sdk.pendo.io.e.a aVar, boolean z) {
            return NoTransition.NO_ANIMATION;
        }
    }

    public static <R> a<R> get() {
        return NO_ANIMATION;
    }

    public static <R> sdk.pendo.io.w.a<R> getFactory() {
        return (sdk.pendo.io.w.a<R>) NO_ANIMATION_FACTORY;
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a
    public boolean transition(Object obj, a.InterfaceC0321a interfaceC0321a) {
        return false;
    }
}
