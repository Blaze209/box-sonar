package com.box.android.hubs.presentation;

import com.box.android.base.cpl.ItemThumbnailReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubReducer$build$3 extends FunctionReferenceImpl implements Function1<ItemThumbnailReducer.Action, HubReducer.Action.BannerThumbnailAction> {
    public static final HubReducer$build$3 INSTANCE = new HubReducer$build$3();

    HubReducer$build$3() {
        super(1, HubReducer.Action.BannerThumbnailAction.class, "<init>", "<init>(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final HubReducer.Action.BannerThumbnailAction invoke(ItemThumbnailReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new HubReducer.Action.BannerThumbnailAction(p0);
    }
}
