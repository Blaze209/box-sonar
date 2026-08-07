package com.box.android.hubs.presentation;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.domain.localrepo.HubsScreenPreferences;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.services.IHubsService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/box/android/hubs/presentation/HubsEnvironment;", "", "hubsService", "Lcom/box/android/domain/services/IHubsService;", "hubsScreenPreferences", "Lcom/box/android/domain/localrepo/HubsScreenPreferences;", "hubsObservability", "Lcom/box/android/domain/metrics/hubs/HubsObservability;", "thumbnailEnvironment", "Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "multiselectEnvironment", "Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "analytics", "Lcom/box/android/hubs/presentation/HubsAnalytics;", "<init>", "(Lcom/box/android/domain/services/IHubsService;Lcom/box/android/domain/localrepo/HubsScreenPreferences;Lcom/box/android/domain/metrics/hubs/HubsObservability;Lcom/box/android/base/cpl/ItemThumbnailEnvironment;Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;Lcom/box/android/hubs/presentation/HubsAnalytics;)V", "getHubsService", "()Lcom/box/android/domain/services/IHubsService;", "getHubsScreenPreferences", "()Lcom/box/android/domain/localrepo/HubsScreenPreferences;", "getHubsObservability", "()Lcom/box/android/domain/metrics/hubs/HubsObservability;", "getThumbnailEnvironment", "()Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "getMultiselectEnvironment", "()Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "getAnalytics", "()Lcom/box/android/hubs/presentation/HubsAnalytics;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsEnvironment {
    public static final int $stable = 8;
    private final HubsAnalytics analytics;
    private final HubsObservability hubsObservability;
    private final HubsScreenPreferences hubsScreenPreferences;
    private final IHubsService hubsService;
    private final MultiselectEnvironment multiselectEnvironment;
    private final ItemThumbnailEnvironment thumbnailEnvironment;

    @Inject
    public HubsEnvironment(IHubsService hubsService, HubsScreenPreferences hubsScreenPreferences, HubsObservability hubsObservability, ItemThumbnailEnvironment thumbnailEnvironment, MultiselectEnvironment multiselectEnvironment, HubsAnalytics analytics) {
        Intrinsics.checkNotNullParameter(hubsService, "hubsService");
        Intrinsics.checkNotNullParameter(hubsScreenPreferences, "hubsScreenPreferences");
        Intrinsics.checkNotNullParameter(hubsObservability, "hubsObservability");
        Intrinsics.checkNotNullParameter(thumbnailEnvironment, "thumbnailEnvironment");
        Intrinsics.checkNotNullParameter(multiselectEnvironment, "multiselectEnvironment");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.hubsService = hubsService;
        this.hubsScreenPreferences = hubsScreenPreferences;
        this.hubsObservability = hubsObservability;
        this.thumbnailEnvironment = thumbnailEnvironment;
        this.multiselectEnvironment = multiselectEnvironment;
        this.analytics = analytics;
    }

    public final IHubsService getHubsService() {
        return this.hubsService;
    }

    public final HubsScreenPreferences getHubsScreenPreferences() {
        return this.hubsScreenPreferences;
    }

    public final HubsObservability getHubsObservability() {
        return this.hubsObservability;
    }

    public final ItemThumbnailEnvironment getThumbnailEnvironment() {
        return this.thumbnailEnvironment;
    }

    public final MultiselectEnvironment getMultiselectEnvironment() {
        return this.multiselectEnvironment;
    }

    public final HubsAnalytics getAnalytics() {
        return this.analytics;
    }
}
