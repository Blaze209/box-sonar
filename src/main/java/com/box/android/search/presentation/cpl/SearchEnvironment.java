package com.box.android.search.presentation.cpl;

import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.browse.cpl.itemsList.ItemEnvironment;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.services.ISearchService;
import com.box.android.hubs.presentation.HubsEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "", "searchService", "Lcom/box/android/domain/services/ISearchService;", "hubsEnvironment", "Lcom/box/android/hubs/presentation/HubsEnvironment;", "itemEnvironment", "Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;", "multiselectEnvironment", "Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "clientSettingsService", "Lcom/box/android/domain/services/IClientSettingsService;", "boxAiService", "Lcom/box/android/domain/services/IBoxAiService;", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/services/ISearchService;Lcom/box/android/hubs/presentation/HubsEnvironment;Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;Lcom/box/android/domain/services/IClientSettingsService;Lcom/box/android/domain/services/IBoxAiService;Lcom/box/android/domain/configuration/IBoxAccountSettings;Lcom/box/android/domain/services/IOfflineService;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getSearchService", "()Lcom/box/android/domain/services/ISearchService;", "getHubsEnvironment", "()Lcom/box/android/hubs/presentation/HubsEnvironment;", "getItemEnvironment", "()Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;", "getMultiselectEnvironment", "()Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "getClientSettingsService", "()Lcom/box/android/domain/services/IClientSettingsService;", "getBoxAiService", "()Lcom/box/android/domain/services/IBoxAiService;", "getBoxAccountSettings", "()Lcom/box/android/domain/configuration/IBoxAccountSettings;", "getOfflineService", "()Lcom/box/android/domain/services/IOfflineService;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchEnvironment {
    public static final int $stable = 8;
    private final IBoxAccountSettings boxAccountSettings;
    private final IBoxAiService boxAiService;
    private final IClientSettingsService clientSettingsService;
    private final FeatureFlips featureFlips;
    private final HubsEnvironment hubsEnvironment;
    private final ItemEnvironment itemEnvironment;
    private final MultiselectEnvironment multiselectEnvironment;
    private final IOfflineService offlineService;
    private final ISearchService searchService;

    @Inject
    public SearchEnvironment(ISearchService searchService, HubsEnvironment hubsEnvironment, ItemEnvironment itemEnvironment, MultiselectEnvironment multiselectEnvironment, IClientSettingsService clientSettingsService, IBoxAiService boxAiService, IBoxAccountSettings boxAccountSettings, IOfflineService offlineService, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(searchService, "searchService");
        Intrinsics.checkNotNullParameter(hubsEnvironment, "hubsEnvironment");
        Intrinsics.checkNotNullParameter(itemEnvironment, "itemEnvironment");
        Intrinsics.checkNotNullParameter(multiselectEnvironment, "multiselectEnvironment");
        Intrinsics.checkNotNullParameter(clientSettingsService, "clientSettingsService");
        Intrinsics.checkNotNullParameter(boxAiService, "boxAiService");
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.searchService = searchService;
        this.hubsEnvironment = hubsEnvironment;
        this.itemEnvironment = itemEnvironment;
        this.multiselectEnvironment = multiselectEnvironment;
        this.clientSettingsService = clientSettingsService;
        this.boxAiService = boxAiService;
        this.boxAccountSettings = boxAccountSettings;
        this.offlineService = offlineService;
        this.featureFlips = featureFlips;
    }

    public final ISearchService getSearchService() {
        return this.searchService;
    }

    public final HubsEnvironment getHubsEnvironment() {
        return this.hubsEnvironment;
    }

    public final ItemEnvironment getItemEnvironment() {
        return this.itemEnvironment;
    }

    public final MultiselectEnvironment getMultiselectEnvironment() {
        return this.multiselectEnvironment;
    }

    public final IClientSettingsService getClientSettingsService() {
        return this.clientSettingsService;
    }

    public final IBoxAiService getBoxAiService() {
        return this.boxAiService;
    }

    public final IBoxAccountSettings getBoxAccountSettings() {
        return this.boxAccountSettings;
    }

    public final IOfflineService getOfflineService() {
        return this.offlineService;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }
}
