package com.box.android.collections.presentation.navigationmodernization;

import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListEnvironment;
import com.box.android.domain.usecases.collections.CreateCollectionInteractor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsEnvironment;", "", "collectionsListEnvironment", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListEnvironment;", "createCollectionUseCase", "Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;", "analytics", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsAnalytics;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListEnvironment;Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;Lcom/box/android/collections/presentation/navigationmodernization/CollectionsAnalytics;)V", "getCollectionsListEnvironment", "()Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListEnvironment;", "getCreateCollectionUseCase", "()Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;", "getAnalytics", "()Lcom/box/android/collections/presentation/navigationmodernization/CollectionsAnalytics;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsEnvironment {
    public static final int $stable = 8;
    private final CollectionsAnalytics analytics;
    private final CollectionsListEnvironment collectionsListEnvironment;
    private final CreateCollectionInteractor createCollectionUseCase;

    @Inject
    public CollectionsEnvironment(CollectionsListEnvironment collectionsListEnvironment, CreateCollectionInteractor createCollectionUseCase, CollectionsAnalytics analytics) {
        Intrinsics.checkNotNullParameter(collectionsListEnvironment, "collectionsListEnvironment");
        Intrinsics.checkNotNullParameter(createCollectionUseCase, "createCollectionUseCase");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.collectionsListEnvironment = collectionsListEnvironment;
        this.createCollectionUseCase = createCollectionUseCase;
        this.analytics = analytics;
    }

    public final CollectionsListEnvironment getCollectionsListEnvironment() {
        return this.collectionsListEnvironment;
    }

    public final CreateCollectionInteractor getCreateCollectionUseCase() {
        return this.createCollectionUseCase;
    }

    public final CollectionsAnalytics getAnalytics() {
        return this.analytics;
    }
}
