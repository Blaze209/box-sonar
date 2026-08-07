package com.box.android.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [GlobalState] */
/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u0002H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "old", "new", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;", "com/box/android/cpl/StoreKt$switchScope$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
public final class StoreKt$switchScope$$inlined$switchScope$1<GlobalState> extends Lambda implements Function2<GlobalState, GlobalState, Boolean> {
    public static final StoreKt$switchScope$$inlined$switchScope$1 INSTANCE = new StoreKt$switchScope$$inlined$switchScope$1();

    public StoreKt$switchScope$$inlined$switchScope$1() {
        super(2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(GlobalState old, GlobalState globalstate) {
        boolean z;
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(globalstate, "new");
        Intrinsics.reifiedOperationMarker(3, "ConcreteState");
        if (old instanceof Object) {
            Intrinsics.reifiedOperationMarker(3, "ConcreteState");
            if (globalstate instanceof Object) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
