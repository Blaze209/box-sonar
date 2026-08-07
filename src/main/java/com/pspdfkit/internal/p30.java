package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p30<T, R> implements Function {
    public final /* synthetic */ lm a;

    public p30(lm lmVar) {
        this.a = lmVar;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Maybe apply(final wu wuVar) {
        wuVar.getClass();
        final lm lmVar = this.a;
        return lmVar == null ? Maybe.empty() : Maybe.defer(new Supplier() { // from class: com.pspdfkit.internal.p30$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return p30.a(wuVar, lmVar);
            }
        });
    }

    public static final MaybeSource a(wu wuVar, lm lmVar) {
        Annotation annotation = (Annotation) BuildersKt__BuildersKt.runBlocking$default(null, new o30(wuVar, lmVar, null), 1, null);
        if (annotation != null) {
            return Maybe.just(annotation);
        }
        return Maybe.empty();
    }
}
