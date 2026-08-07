package com.margelo.nitro.boxcontext.providers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StyleVariantDelegate.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H&¨\u0006\b"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/StyleVariantDelegate;", "", "onStyleVariantChanged", "Lkotlin/Function0;", "", "callback", "Lkotlin/Function1;", "Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface StyleVariantDelegate {
    Function0<Unit> onStyleVariantChanged(Function1<? super StyleVariant, Unit> callback);
}
