package com.box.android.data.api.requests;

import com.box.android.data.api.ItemCollaborationsDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ItemCollaborationsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH§@¢\u0006\u0002\u0010\tJ0\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH§@¢\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/ItemCollaborationsRequest;", "", "getFileCollaborations", "Lcom/box/android/data/api/ItemCollaborationsDTO;", "fileId", "", "fields", BoxIterator.FIELD_LIMIT, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderCollaborations", "folderId", "deleteCollaboration", "", "collaborationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ItemCollaborationsRequest {
    @DELETE("collaborations/{collaborationId}")
    Object deleteCollaboration(@Path("collaborationId") String str, Continuation<? super Unit> continuation);

    @GET("files/{fileId}/collaborations")
    Object getFileCollaborations(@Path("fileId") String str, @Query("fields") String str2, @Query(BoxIterator.FIELD_LIMIT) Integer num, Continuation<? super ItemCollaborationsDTO> continuation);

    @GET("folders/{folderId}/collaborations")
    Object getFolderCollaborations(@Path("folderId") String str, @Query("fields") String str2, @Query(BoxIterator.FIELD_LIMIT) Integer num, Continuation<? super ItemCollaborationsDTO> continuation);
}
