package com.box.android.domain.usecases.notes;

import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: ResolveNewNoteDataUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0002¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/notes/ResolveNewNoteDataUseCase;", "", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ResolveNewNoteDataUseCase {
    Result<NewNoteData, NoteCreationError> invoke(NewNoteLocation location);
}
