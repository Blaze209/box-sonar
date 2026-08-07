package com.box.android.cpl.mainphone;

import com.box.android.browse.cpl.CollectionReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneReducer$build$3 extends FunctionReferenceImpl implements Function1<CollectionReducer.Action, MainPhoneReducer.Action.CollectionAction> {
    public static final MainPhoneReducer$build$3 INSTANCE = new MainPhoneReducer$build$3();

    MainPhoneReducer$build$3() {
        super(1, MainPhoneReducer.Action.CollectionAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/CollectionReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainPhoneReducer.Action.CollectionAction invoke(CollectionReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new MainPhoneReducer.Action.CollectionAction(p0);
    }
}
