package com.box.android.data.api.requests;

import com.box.android.common.utilities.BoxCommonConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: DeleteItemRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/DeleteItemRequest;", "", "deleteFile", "", "fileId", "", "ifMatchEtag", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFolder", "folderId", "isRecursiveDelete", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWebLink", BoxCommonConstants.EXTRA_WEB_LINK_ID, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeleteItemRequest {
    @DELETE("files/{id}")
    Object deleteFile(@Path("id") String str, @Header("If-Match") String str2, Continuation<? super Unit> continuation);

    @DELETE("folders/{id}")
    Object deleteFolder(@Path("id") String str, @Query("recursive") boolean z, Continuation<? super Unit> continuation);

    @DELETE("web_links/{id}")
    Object deleteWebLink(@Path("id") String str, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: DeleteItemRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object deleteFolder$default(DeleteItemRequest deleteItemRequest, String str, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteFolder");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return deleteItemRequest.deleteFolder(str, z, continuation);
    }
}
