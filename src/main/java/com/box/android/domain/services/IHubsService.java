package com.box.android.domain.services;

import android.graphics.Bitmap;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.hubs.HubAssetModel;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IHubsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IHubsService;", "", "getHubs", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/hubs/HubModel;", "Lcom/box/android/domain/models/DomainError;", "sort", "Lcom/box/android/domain/models/hubs/HubsSort;", "direction", "Lcom/box/android/domain/models/hubs/HubsDirection;", "dataPolicy", "Lcom/box/android/domain/configuration/DataPolicy;", "query", "", "loadHubAsset", "Landroid/graphics/Bitmap;", "hubAssetModel", "Lcom/box/android/domain/models/hubs/HubAssetModel;", "(Lcom/box/android/domain/models/hubs/HubAssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IHubsService {
    Flow<Result<List<HubModel>, DomainError>> getHubs(HubsSort sort, HubsDirection direction, DataPolicy dataPolicy, String query);

    Object loadHubAsset(HubAssetModel hubAssetModel, Continuation<? super Result<Bitmap, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: IHubsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Flow getHubs$default(IHubsService iHubsService, HubsSort hubsSort, HubsDirection hubsDirection, DataPolicy dataPolicy, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHubs");
        }
        if ((i & 4) != 0) {
            dataPolicy = DataPolicy.REMOTE;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return iHubsService.getHubs(hubsSort, hubsDirection, dataPolicy, str);
    }
}
