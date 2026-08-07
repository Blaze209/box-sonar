package com.box.android.data.api.requests;

import com.box.android.data.api.models.InboxCollaborationResponseDTO;
import com.box.android.data.api.models.inboxnotifications.UpdateInboxCollaborationDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/* JADX INFO: compiled from: InboxCollaborationRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/InboxCollaborationRequest;", "", "updateCollaboration", "Lcom/box/android/data/api/models/InboxCollaborationResponseDTO;", "collaborationId", "", "updateInboxCollaborationDTO", "Lcom/box/android/data/api/models/inboxnotifications/UpdateInboxCollaborationDTO;", "(Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/UpdateInboxCollaborationDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface InboxCollaborationRequest {
    @PUT("collaborations/{collaborationId}")
    Object updateCollaboration(@Path("collaborationId") String str, @Body UpdateInboxCollaborationDTO updateInboxCollaborationDTO, Continuation<? super InboxCollaborationResponseDTO> continuation);
}
