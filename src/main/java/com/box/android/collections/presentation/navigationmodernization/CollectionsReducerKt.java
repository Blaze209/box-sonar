package com.box.android.collections.presentation.navigationmodernization;

import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: CollectionsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001¨\u0006\u0006"}, d2 = {"scopeCollectionsList", "Lcom/box/android/cpl/Store;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "collections_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionsReducerKt {

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.CollectionsReducerKt$scopeCollectionsList$2, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<CollectionsListReducer.Action, CollectionsReducer.Action.CollectionsListAction> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, CollectionsReducer.Action.CollectionsListAction.class, "<init>", "<init>(Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CollectionsReducer.Action.CollectionsListAction invoke(CollectionsListReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new CollectionsReducer.Action.CollectionsListAction(p0);
        }
    }

    public static final Store<CollectionsListReducer.State, CollectionsListReducer.Action> scopeCollectionsList(Store<CollectionsReducer.State, CollectionsReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsReducerKt.scopeCollectionsList.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CollectionsReducer.State) obj).getCollectionsListState();
            }
        }, AnonymousClass2.INSTANCE);
    }
}
