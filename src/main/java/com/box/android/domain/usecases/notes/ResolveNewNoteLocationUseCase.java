package com.box.android.domain.usecases.notes;

import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ResolveNewNoteLocationUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦B¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;", "", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "(Lcom/box/android/domain/models/NewNoteLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ResolveNewNoteLocationUseCase {
    Object invoke(NewNoteLocation newNoteLocation, Continuation<? super Result<NewNoteData, ? extends NoteCreationError>> continuation);
}
