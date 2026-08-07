package com.box.android.hubs.presentation;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubsReducer$build$4 extends FunctionReferenceImpl implements Function1<MultiselectReducer.Action, HubsReducer.Action.Multiselect> {
    public static final HubsReducer$build$4 INSTANCE = new HubsReducer$build$4();

    HubsReducer$build$4() {
        super(1, HubsReducer.Action.Multiselect.class, "<init>", "<init>(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final HubsReducer.Action.Multiselect invoke(MultiselectReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new HubsReducer.Action.Multiselect(p0);
    }
}
