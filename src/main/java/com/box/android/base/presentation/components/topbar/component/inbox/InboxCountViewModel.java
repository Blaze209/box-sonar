package com.box.android.base.presentation.components.topbar.component.inbox;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxCountViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountViewModel;", "Landroidx/lifecycle/ViewModel;", "inboxCountEnvironment", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$State;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxCountViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<InboxCountReducer.State, InboxCountReducer.Action> store;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public InboxCountViewModel(InboxCountEnvironment inboxCountEnvironment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(inboxCountEnvironment, "inboxCountEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.store = storeFactory.create(new InboxCountReducer.State(null, 1, 0 == true ? 1 : 0), new InboxCountReducer(inboxCountEnvironment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<InboxCountReducer.State, InboxCountReducer.Action> getStore() {
        return this.store;
    }
}
