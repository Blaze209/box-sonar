package com.box.android.hubs.presentation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubsReducer$build$7 extends FunctionReferenceImpl implements Function2<String, HubReducer.Action, HubsReducer.Action.HubAction> {
    public static final HubsReducer$build$7 INSTANCE = new HubsReducer$build$7();

    HubsReducer$build$7() {
        super(2, HubsReducer.Action.HubAction.class, "<init>", "<init>(Ljava/lang/String;Lcom/box/android/hubs/presentation/HubReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final HubsReducer.Action.HubAction invoke(String p0, HubReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new HubsReducer.Action.HubAction(p0, p1);
    }
}
