package com.box.android.tasks.addtask.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import com.box.android.tasks.addtask.cpl.AddTaskEnvironment;
import com.box.android.tasks.addtask.cpl.AddTaskReducer;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskViewModel.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/box/android/tasks/addtask/viewmodel/AddTaskViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/tasks/addtask/cpl/AddTaskEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/box/android/tasks/addtask/cpl/AddTaskEnvironment;Lcom/box/android/cpl/IStoreFactory;Landroidx/lifecycle/SavedStateHandle;)V", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "store$delegate", "Lkotlin/Lazy;", "Companion", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddTaskViewModel extends ViewModel {
    public static final String EXTRA_FILE_MODEL = "extraFileModel";
    private final AddTaskEnvironment environment;
    private final FileModel fileModel;

    /* JADX INFO: renamed from: store$delegate, reason: from kotlin metadata */
    private final Lazy store;
    private final IStoreFactory storeFactory;
    public static final int $stable = 8;

    @Inject
    public AddTaskViewModel(AddTaskEnvironment environment, IStoreFactory storeFactory, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.environment = environment;
        this.storeFactory = storeFactory;
        this.fileModel = (FileModel) savedStateHandle.get(EXTRA_FILE_MODEL);
        this.store = LazyKt.lazy(new Function0() { // from class: com.box.android.tasks.addtask.viewmodel.AddTaskViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AddTaskViewModel.store_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final Store<AddTaskReducer.State, AddTaskReducer.Action> getStore() {
        return (Store) this.store.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store store_delegate$lambda$0(AddTaskViewModel addTaskViewModel) {
        FileModel fileModel = addTaskViewModel.fileModel;
        if (fileModel == null) {
            throw new IllegalArgumentException("AddTaskViewModel requires a FileModel");
        }
        return addTaskViewModel.storeFactory.create(new AddTaskReducer.State.PickType(fileModel), new AddTaskReducer(addTaskViewModel.environment), ViewModelKt.getViewModelScope(addTaskViewModel));
    }
}
