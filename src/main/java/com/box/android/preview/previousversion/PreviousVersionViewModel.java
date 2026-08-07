package com.box.android.preview.previousversion;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.item.ItemState;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "environment", "Lcom/box/android/preview/previousversion/PreviousVersionEnvironment;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/preview/previousversion/PreviousVersionEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previousversion/PreviousVersionEnvironment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "Factory", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionViewModel extends ViewModel {
    public static final String VM_ANNOTATION_ID_KEY = "VM_ANNOTATION_ID_KEY";
    public static final String VM_FILE_MODEL_KEY = "VM_INITIAL_FILE_MODEL_KEY";
    public static final String VM_OBSERVABILITY_ID_KEY = "VM_OBSERVABILITY_ID_KEY";
    public static final String VM_PREVIOUS_VERSION_ID_KEY = "VM_PREVIOUS_VERSION_ID_KEY";
    private final PreviousVersionEnvironment environment;
    private final Store<PreviousVersionReducer.State, PreviousVersionReducer.Action> store;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PreviousVersionViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/preview/previousversion/PreviousVersionViewModel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<PreviousVersionViewModel> {
    }

    @AssistedInject
    public PreviousVersionViewModel(@Assisted Bundle args, IStoreFactory storeFactory, PreviousVersionEnvironment environment) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) args.getParcelable("VM_INITIAL_FILE_MODEL_KEY", FileModel.class);
        } else {
            Parcelable parcelable2 = args.getParcelable("VM_INITIAL_FILE_MODEL_KEY");
            parcelable = (FileModel) (parcelable2 instanceof FileModel ? parcelable2 : null);
        }
        if (parcelable != null) {
            ItemState.Uninitialized uninitialized = new ItemState.Uninitialized((FileModel) parcelable);
            String string = args.getString(VM_PREVIOUS_VERSION_ID_KEY);
            Intrinsics.checkNotNull(string);
            this.store = storeFactory.create(new PreviousVersionReducer.State(string, args.getString(VM_ANNOTATION_ID_KEY), uninitialized, null, null, false, null, 88, null), new PreviousVersionReducer(environment, args.getString(VM_OBSERVABILITY_ID_KEY)), ViewModelKt.getViewModelScope(this));
            return;
        }
        throw new IllegalArgumentException("Parcelable with key VM_INITIAL_FILE_MODEL_KEY not found in Bundle".toString());
    }

    public final PreviousVersionEnvironment getEnvironment() {
        return this.environment;
    }

    public final Store<PreviousVersionReducer.State, PreviousVersionReducer.Action> getStore() {
        return this.store;
    }
}
