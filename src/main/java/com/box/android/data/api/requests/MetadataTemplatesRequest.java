package com.box.android.data.api.requests;

import com.box.android.data.api.models.MetadataTemplatesListDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: compiled from: MetadataTemplatesRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/MetadataTemplatesRequest;", "", "listGlobalMetadataTemplates", "Lcom/box/android/data/api/models/MetadataTemplatesListDTO;", BoxIterator.FIELD_LIMIT, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listEnterpriseMetadataTemplates", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MetadataTemplatesRequest {
    @GET("metadata_templates/enterprise")
    Object listEnterpriseMetadataTemplates(@Query(BoxIterator.FIELD_LIMIT) int i, Continuation<? super MetadataTemplatesListDTO> continuation);

    @GET("metadata_templates/global")
    Object listGlobalMetadataTemplates(@Query(BoxIterator.FIELD_LIMIT) int i, Continuation<? super MetadataTemplatesListDTO> continuation);

    /* JADX INFO: compiled from: MetadataTemplatesRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object listGlobalMetadataTemplates$default(MetadataTemplatesRequest metadataTemplatesRequest, int i, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listGlobalMetadataTemplates");
        }
        if ((i2 & 1) != 0) {
            i = 1000;
        }
        return metadataTemplatesRequest.listGlobalMetadataTemplates(i, continuation);
    }

    static /* synthetic */ Object listEnterpriseMetadataTemplates$default(MetadataTemplatesRequest metadataTemplatesRequest, int i, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listEnterpriseMetadataTemplates");
        }
        if ((i2 & 1) != 0) {
            i = 1000;
        }
        return metadataTemplatesRequest.listEnterpriseMetadataTemplates(i, continuation);
    }
}
