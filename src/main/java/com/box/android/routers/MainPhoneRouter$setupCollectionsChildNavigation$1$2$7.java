package com.box.android.routers;

import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.utilities.DataClassUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneRouter$setupCollectionsChildNavigation$1$2$7 extends FunctionReferenceImpl implements Function1<CollectionReducer.Action, CollectionReducer.Action> {
    public static final MainPhoneRouter$setupCollectionsChildNavigation$1$2$7 INSTANCE = new MainPhoneRouter$setupCollectionsChildNavigation$1$2$7();

    MainPhoneRouter$setupCollectionsChildNavigation$1$2$7() {
        super(1, DataClassUtilsKt.class, "self", "self(Ljava/lang/Object;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CollectionReducer.Action invoke(CollectionReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (CollectionReducer.Action) DataClassUtilsKt.self(p0);
    }
}
