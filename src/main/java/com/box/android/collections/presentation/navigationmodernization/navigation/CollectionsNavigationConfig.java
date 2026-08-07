package com.box.android.collections.presentation.navigationmodernization.navigation;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsNavigationConfig.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;", "", "startDestination", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$Collections;", "additionalDestinations", "", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$Collections;Ljava/util/List;)V", "getStartDestination", "()Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$InnerDestination$Collections;", "getAdditionalDestinations", "()Ljava/util/List;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsNavigationConfig {
    public static final int $stable = 8;
    private final List<CollectionsDestination.InnerDestination> additionalDestinations;
    private final CollectionsDestination.InnerDestination.Collections startDestination;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsNavigationConfig(CollectionsDestination.InnerDestination.Collections startDestination, List<? extends CollectionsDestination.InnerDestination> additionalDestinations) {
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(additionalDestinations, "additionalDestinations");
        this.startDestination = startDestination;
        this.additionalDestinations = additionalDestinations;
    }

    public final CollectionsDestination.InnerDestination.Collections getStartDestination() {
        return this.startDestination;
    }

    public /* synthetic */ CollectionsNavigationConfig(CollectionsDestination.InnerDestination.Collections collections, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collections, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<CollectionsDestination.InnerDestination> getAdditionalDestinations() {
        return this.additionalDestinations;
    }
}
