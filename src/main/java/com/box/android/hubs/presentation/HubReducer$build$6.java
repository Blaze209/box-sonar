package com.box.android.hubs.presentation;

import com.box.android.base.cpl.ItemThumbnailReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubReducer$build$6 extends FunctionReferenceImpl implements Function1<ItemThumbnailReducer.Action, HubReducer.Action.IconThumbnailAction> {
    public static final HubReducer$build$6 INSTANCE = new HubReducer$build$6();

    HubReducer$build$6() {
        super(1, HubReducer.Action.IconThumbnailAction.class, "<init>", "<init>(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final HubReducer.Action.IconThumbnailAction invoke(ItemThumbnailReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new HubReducer.Action.IconThumbnailAction(p0);
    }
}
