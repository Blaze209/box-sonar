package com.box.android.activities.addcontent;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.usecases.notes.ResolveNewNoteLocationUseCase;
import com.box.android.domain.usecases.notes.SetDefaultNoteFolderUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewNoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationViewModel;", "Landroidx/lifecycle/ViewModel;", "resolveNewNoteLocationUseCase", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;", "setDefaultNoteFolderUseCase", "Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderUseCase;", "defaultNoteFolderService", "Lcom/box/android/domain/services/IDefaultNoteFolderService;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderUseCase;Lcom/box/android/domain/services/IDefaultNoteFolderService;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$State;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewNoteCreationViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<NewNoteCreationReducer.State, NewNoteCreationReducer.Action> store;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public NewNoteCreationViewModel(ResolveNewNoteLocationUseCase resolveNewNoteLocationUseCase, SetDefaultNoteFolderUseCase setDefaultNoteFolderUseCase, IDefaultNoteFolderService defaultNoteFolderService, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(resolveNewNoteLocationUseCase, "resolveNewNoteLocationUseCase");
        Intrinsics.checkNotNullParameter(setDefaultNoteFolderUseCase, "setDefaultNoteFolderUseCase");
        Intrinsics.checkNotNullParameter(defaultNoteFolderService, "defaultNoteFolderService");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.store = storeFactory.create(new NewNoteCreationReducer.State(false, null, 3, 0 == true ? 1 : 0), new NewNoteCreationReducer(new NewNoteCreationEnvironment(resolveNewNoteLocationUseCase, setDefaultNoteFolderUseCase, defaultNoteFolderService)), ViewModelKt.getViewModelScope(this));
    }

    public final Store<NewNoteCreationReducer.State, NewNoteCreationReducer.Action> getStore() {
        return this.store;
    }
}
