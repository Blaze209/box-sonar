package com.box.android.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [GlobalState, LocalState] */
/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0006\"\u0010\b\u0004\u0010\u0007\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001a\u0002H\u0003H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "Lcom/box/android/cpl/Wrapped;", "LocalState", "GlobalState", "", "GlobalAction", "LocalAction", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "globalState", "invoke", "(Ljava/lang/Object;)Lcom/box/android/cpl/Wrapped;"}, k = 3, mv = {1, 9, 0}, xi = 176)
final class StoreKt$caseLet$1$1<GlobalState, LocalState> extends Lambda implements Function1<GlobalState, Wrapped<LocalState>> {
    public static final StoreKt$caseLet$1$1 INSTANCE = new StoreKt$caseLet$1$1();

    public StoreKt$caseLet$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Wrapped<LocalState> invoke(GlobalState globalState) {
        Object action;
        Intrinsics.checkNotNullParameter(globalState, "globalState");
        Intrinsics.reifiedOperationMarker(2, "ConcreteState");
        Embedded embedded = (Embedded) globalState;
        if (embedded == null || (action = embedded.getAction()) == null) {
            return null;
        }
        return StoreKt.wrap(action);
    }
}
