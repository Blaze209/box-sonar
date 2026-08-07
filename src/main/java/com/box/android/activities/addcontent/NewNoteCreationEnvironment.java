package com.box.android.activities.addcontent;

import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.usecases.notes.ResolveNewNoteLocationUseCase;
import com.box.android.domain.usecases.notes.SetDefaultNoteFolderUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewNoteCreationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationEnvironment;", "", "resolveNewNoteLocationUseCase", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;", "setDefaultNoteFolderUseCase", "Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderUseCase;", "defaultNoteFolderService", "Lcom/box/android/domain/services/IDefaultNoteFolderService;", "<init>", "(Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderUseCase;Lcom/box/android/domain/services/IDefaultNoteFolderService;)V", "getResolveNewNoteLocationUseCase", "()Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;", "getSetDefaultNoteFolderUseCase", "()Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderUseCase;", "getDefaultNoteFolderService", "()Lcom/box/android/domain/services/IDefaultNoteFolderService;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewNoteCreationEnvironment {
    public static final int $stable = 8;
    private final IDefaultNoteFolderService defaultNoteFolderService;
    private final ResolveNewNoteLocationUseCase resolveNewNoteLocationUseCase;
    private final SetDefaultNoteFolderUseCase setDefaultNoteFolderUseCase;

    public NewNoteCreationEnvironment(ResolveNewNoteLocationUseCase resolveNewNoteLocationUseCase, SetDefaultNoteFolderUseCase setDefaultNoteFolderUseCase, IDefaultNoteFolderService defaultNoteFolderService) {
        Intrinsics.checkNotNullParameter(resolveNewNoteLocationUseCase, "resolveNewNoteLocationUseCase");
        Intrinsics.checkNotNullParameter(setDefaultNoteFolderUseCase, "setDefaultNoteFolderUseCase");
        Intrinsics.checkNotNullParameter(defaultNoteFolderService, "defaultNoteFolderService");
        this.resolveNewNoteLocationUseCase = resolveNewNoteLocationUseCase;
        this.setDefaultNoteFolderUseCase = setDefaultNoteFolderUseCase;
        this.defaultNoteFolderService = defaultNoteFolderService;
    }

    public final ResolveNewNoteLocationUseCase getResolveNewNoteLocationUseCase() {
        return this.resolveNewNoteLocationUseCase;
    }

    public final SetDefaultNoteFolderUseCase getSetDefaultNoteFolderUseCase() {
        return this.setDefaultNoteFolderUseCase;
    }

    public final IDefaultNoteFolderService getDefaultNoteFolderService() {
        return this.defaultNoteFolderService;
    }
}
