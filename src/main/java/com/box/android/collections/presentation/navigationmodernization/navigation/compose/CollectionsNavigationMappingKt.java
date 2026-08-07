package com.box.android.collections.presentation.navigationmodernization.navigation.compose;

import android.net.Uri;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsDestination;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsNavigationMapping.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\b\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"COLLECTIONS_GRAPH_ROUTE", "", "COLLECTIONS_ROUTE", "COLLECTION_ITEMS_LIST_ROUTE_PREFIX", "COLLECTION_ITEMS_LIST_ROUTE", "graphToRoute", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$Companion;", "toRoute", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$Collections;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$CollectionItemsList$Companion;", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination;", "collections_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionsNavigationMappingKt {
    private static final String COLLECTIONS_GRAPH_ROUTE = "collections_graph_route";
    private static final String COLLECTIONS_ROUTE = "collections_route";
    private static final String COLLECTION_ITEMS_LIST_ROUTE = "collection_items_list/{collection_id}/{collection_name}/{collection_type}";
    private static final String COLLECTION_ITEMS_LIST_ROUTE_PREFIX = "collection_items_list";

    public static final String graphToRoute(CollectionsDestination.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return COLLECTIONS_GRAPH_ROUTE;
    }

    public static final String toRoute(CollectionsDestination.InnerDestination.Collections collections) {
        Intrinsics.checkNotNullParameter(collections, "<this>");
        return COLLECTIONS_ROUTE;
    }

    public static final String toRoute(CollectionsDestination.InnerDestination.CollectionItemsList.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return COLLECTION_ITEMS_LIST_ROUTE;
    }

    public static final String toRoute(CollectionsDestination.InnerDestination innerDestination) {
        Intrinsics.checkNotNullParameter(innerDestination, "<this>");
        if (Intrinsics.areEqual(innerDestination, CollectionsDestination.InnerDestination.Collections.INSTANCE)) {
            return COLLECTIONS_ROUTE;
        }
        if (!(innerDestination instanceof CollectionsDestination.InnerDestination.CollectionItemsList)) {
            throw new NoWhenBranchMatchedException();
        }
        CollectionsDestination.InnerDestination.CollectionItemsList collectionItemsList = (CollectionsDestination.InnerDestination.CollectionItemsList) innerDestination;
        return "collection_items_list/" + collectionItemsList.getCollection().getId() + "/" + Uri.encode(collectionItemsList.getCollection().getName()) + "/" + collectionItemsList.getCollection().getType();
    }
}
