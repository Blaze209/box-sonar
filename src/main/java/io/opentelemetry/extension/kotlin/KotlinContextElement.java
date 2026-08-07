package io.opentelemetry.extension.kotlin;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes4.dex */
class KotlinContextElement implements ThreadContextElement<Scope> {
    static final CoroutineContext.Key<KotlinContextElement> KEY = new CoroutineContext.Key<KotlinContextElement>() { // from class: io.opentelemetry.extension.kotlin.KotlinContextElement.1
    };
    private final Context otelContext;

    KotlinContextElement(Context context) {
        this.otelContext = context;
    }

    Context getContext() {
        return this.otelContext;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.ThreadContextElement
    public Scope updateThreadContext(CoroutineContext coroutineContext) {
        return this.otelContext.makeCurrent();
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(CoroutineContext coroutineContext, Scope scope) {
        scope.close();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }
}
