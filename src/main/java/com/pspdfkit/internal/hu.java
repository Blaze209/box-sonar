package com.pspdfkit.internal;

import com.pspdfkit.ui.PageObjectProvider;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.processors.BehaviorProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class hu<T extends PageObjectProvider> {
    public final BehaviorProcessor<t10> a = BehaviorProcessor.createDefault(new t10());
    public final go<T> b = new go<>(new go.a() { // from class: com.pspdfkit.internal.hu$$ExternalSyntheticLambda0
        @Override // com.pspdfkit.internal.go.a
        public final void a(go goVar) {
            this.f$0.a(goVar);
        }
    });
    public final Scheduler c;

    public hu(Scheduler scheduler) {
        this.c = scheduler;
    }

    public final void a(go goVar) {
        this.a.onNext(new t10());
    }

    public final Function<t10, List<T>> a() {
        return new Function() { // from class: com.pspdfkit.internal.hu$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a((t10) obj);
            }
        };
    }

    public final List a(t10 t10Var) throws Throwable {
        return new ArrayList(this.b.a);
    }

    public final Function<t10, List<T>> a(final int i) {
        return new Function() { // from class: com.pspdfkit.internal.hu$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a(i, (t10) obj);
            }
        };
    }

    public final /* synthetic */ List a(int i, t10 t10Var) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (T t : this.b) {
            Set<Integer> filteredPages = t.getFilteredPages();
            if (filteredPages.isEmpty() || filteredPages.contains(Integer.valueOf(i))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
