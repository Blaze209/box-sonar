package com.box.android.browse.cpl;

import com.box.android.browse.cpl.browse.BrowseReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionReducer$build$3 extends FunctionReferenceImpl implements Function1<BrowseReducer.State, CollectionReducer.Route.Folder> {
    public static final CollectionReducer$build$3 INSTANCE = new CollectionReducer$build$3();

    CollectionReducer$build$3() {
        super(1, CollectionReducer.Route.Folder.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/BrowseReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CollectionReducer.Route.Folder invoke(BrowseReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CollectionReducer.Route.Folder(p0);
    }
}
