package com.box.android.cpl.mainphone;

import com.box.android.browse.cpl.browse.BrowseReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneReducer$build$6 extends FunctionReferenceImpl implements Function1<BrowseReducer.Action, MainPhoneReducer.Action.BrowseNestedAction> {
    public static final MainPhoneReducer$build$6 INSTANCE = new MainPhoneReducer$build$6();

    MainPhoneReducer$build$6() {
        super(1, MainPhoneReducer.Action.BrowseNestedAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainPhoneReducer.Action.BrowseNestedAction invoke(BrowseReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new MainPhoneReducer.Action.BrowseNestedAction(p0);
    }
}
