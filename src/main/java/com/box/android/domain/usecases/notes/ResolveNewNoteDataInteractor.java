package com.box.android.domain.usecases.notes;

import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResolveNewNoteDataInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/usecases/notes/ResolveNewNoteDataInteractor;", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteDataUseCase;", "noteNameGenerator", "Lcom/box/android/domain/usecases/notes/NoteNameGenerator;", "<init>", "(Lcom/box/android/domain/usecases/notes/NoteNameGenerator;)V", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "resolveNoteLocation", "", "getDefaultNotesFolderId", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ResolveNewNoteDataInteractor implements ResolveNewNoteDataUseCase {
    private final NoteNameGenerator noteNameGenerator;

    @Inject
    public ResolveNewNoteDataInteractor(NoteNameGenerator noteNameGenerator) {
        Intrinsics.checkNotNullParameter(noteNameGenerator, "noteNameGenerator");
        this.noteNameGenerator = noteNameGenerator;
    }

    @Override // com.box.android.domain.usecases.notes.ResolveNewNoteDataUseCase
    public Result<NewNoteData, NoteCreationError> invoke(NewNoteLocation location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Result resultResolveNoteLocation = resolveNoteLocation(location);
        if (resultResolveNoteLocation instanceof Result.Success) {
            return new Result.Success(new NewNoteData((String) ((Result.Success) resultResolveNoteLocation).getValue(), this.noteNameGenerator.generate()));
        }
        if (resultResolveNoteLocation instanceof Result.Error) {
            return resultResolveNoteLocation;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<String, NoteCreationError> resolveNoteLocation(NewNoteLocation location) {
        if (location instanceof NewNoteLocation.Folder) {
            NewNoteLocation.Folder folder = (NewNoteLocation.Folder) location;
            if (NoteFolderPermissionsKt.canCreateNotes(folder.getFolder())) {
                return new Result.Success(ItemModelKt.toItemIdRemoteId(folder.getFolder()).getBoxId());
            }
            return new Result.Error(new NoteCreationError.PermissionDenied(null, 1, null));
        }
        if (!Intrinsics.areEqual(location, NewNoteLocation.DefaultNotesFolder.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Success(getDefaultNotesFolderId());
    }

    public final String getDefaultNotesFolderId() {
        return "0";
    }
}
