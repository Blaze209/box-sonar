package com.box.android.data.api.requests;

import com.box.android.data.api.models.notes.DefaultNoteFolderDTO;
import com.box.android.data.api.models.notes.SetDefaultNoteFolderRequestDTO;
import com.box.android.data.api.models.notes.UserSettingsDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* JADX INFO: compiled from: DefaultNoteFolderRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/DefaultNoteFolderRequest;", "", "getOrCreateDefaultNoteFolder", "Lcom/box/android/data/api/models/notes/DefaultNoteFolderDTO;", "acceptLanguage", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultNoteFolder", "Lcom/box/android/data/api/models/notes/UserSettingsDTO;", "body", "Lcom/box/android/data/api/models/notes/SetDefaultNoteFolderRequestDTO;", "(Lcom/box/android/data/api/models/notes/SetDefaultNoteFolderRequestDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DefaultNoteFolderRequest {
    @POST("default_note_folder")
    Object getOrCreateDefaultNoteFolder(@Header("Accept-Language") String str, Continuation<? super DefaultNoteFolderDTO> continuation);

    @PUT("default_note_folder")
    Object setDefaultNoteFolder(@Body SetDefaultNoteFolderRequestDTO setDefaultNoteFolderRequestDTO, Continuation<? super UserSettingsDTO> continuation);
}
