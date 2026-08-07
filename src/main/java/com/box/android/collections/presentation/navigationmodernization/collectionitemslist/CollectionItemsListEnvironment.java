package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.browse.cpl.itemsList.ItemEnvironment;
import com.box.android.collections.presentation.navigationmodernization.CollectionsAnalytics;
import com.box.android.domain.usecases.collections.ListCollectionItemsInteractor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListEnvironment;", "", "listCollectionItemsInteractor", "Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;", "itemEnvironment", "Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;", "multiselectEnvironment", "Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "analytics", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsAnalytics;", "<init>", "(Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;Lcom/box/android/collections/presentation/navigationmodernization/CollectionsAnalytics;)V", "getListCollectionItemsInteractor", "()Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;", "getItemEnvironment", "()Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;", "getMultiselectEnvironment", "()Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "getAnalytics", "()Lcom/box/android/collections/presentation/navigationmodernization/CollectionsAnalytics;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemsListEnvironment {
    public static final int $stable = 8;
    private final CollectionsAnalytics analytics;
    private final ItemEnvironment itemEnvironment;
    private final ListCollectionItemsInteractor listCollectionItemsInteractor;
    private final MultiselectEnvironment multiselectEnvironment;

    @Inject
    public CollectionItemsListEnvironment(ListCollectionItemsInteractor listCollectionItemsInteractor, ItemEnvironment itemEnvironment, MultiselectEnvironment multiselectEnvironment, CollectionsAnalytics analytics) {
        Intrinsics.checkNotNullParameter(listCollectionItemsInteractor, "listCollectionItemsInteractor");
        Intrinsics.checkNotNullParameter(itemEnvironment, "itemEnvironment");
        Intrinsics.checkNotNullParameter(multiselectEnvironment, "multiselectEnvironment");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.listCollectionItemsInteractor = listCollectionItemsInteractor;
        this.itemEnvironment = itemEnvironment;
        this.multiselectEnvironment = multiselectEnvironment;
        this.analytics = analytics;
    }

    public final ListCollectionItemsInteractor getListCollectionItemsInteractor() {
        return this.listCollectionItemsInteractor;
    }

    public final ItemEnvironment getItemEnvironment() {
        return this.itemEnvironment;
    }

    public final MultiselectEnvironment getMultiselectEnvironment() {
        return this.multiselectEnvironment;
    }

    public final CollectionsAnalytics getAnalytics() {
        return this.analytics;
    }
}
