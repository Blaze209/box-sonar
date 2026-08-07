package com.box.android.contentpicker;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentPickerViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/contentpicker/ContentPickerEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/contentpicker/ContentPickerEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "getEnvironment", "()Lcom/box/android/contentpicker/ContentPickerEnvironment;", "getStoreFactory", "()Lcom/box/android/cpl/IStoreFactory;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/contentpicker/ContentPickerReducer$State;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContentPickerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final ContentPickerEnvironment environment;
    private final Store<ContentPickerReducer.State, ContentPickerReducer.Action> store;
    private final IStoreFactory storeFactory;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public ContentPickerViewModel(ContentPickerEnvironment environment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.environment = environment;
        this.storeFactory = storeFactory;
        this.store = storeFactory.create(new ContentPickerReducer.State(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), new ContentPickerReducer(environment), ViewModelKt.getViewModelScope(this));
    }

    public final ContentPickerEnvironment getEnvironment() {
        return this.environment;
    }

    public final IStoreFactory getStoreFactory() {
        return this.storeFactory;
    }

    public final Store<ContentPickerReducer.State, ContentPickerReducer.Action> getStore() {
        return this.store;
    }
}
