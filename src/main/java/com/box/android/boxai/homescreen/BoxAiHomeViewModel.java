package com.box.android.boxai.homescreen;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiHomeViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/boxai/homescreen/BoxAiHomeEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/box/android/boxai/homescreen/BoxAiHomeEnvironment;Lcom/box/android/cpl/IStoreFactory;Landroidx/lifecycle/SavedStateHandle;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$State;", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "value", "", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "Companion", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiHomeViewModel extends ViewModel {

    @Deprecated
    public static final String KEY_SESSION_ID = "KEY_SESSION_ID";
    private final SavedStateHandle savedStateHandle;
    private final Store<BoxAiHomeReducer.State, BoxAiHomeReducer.Action> store;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public BoxAiHomeViewModel(BoxAiHomeEnvironment environment, IStoreFactory storeFactory, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.savedStateHandle = savedStateHandle;
        this.store = storeFactory.create(BoxAiHomeReducer.State.INSTANCE, new BoxAiHomeReducer(environment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<BoxAiHomeReducer.State, BoxAiHomeReducer.Action> getStore() {
        return this.store;
    }

    public final String getSessionId() {
        return (String) this.savedStateHandle.get(KEY_SESSION_ID);
    }

    public final void setSessionId(String str) {
        this.savedStateHandle.set(KEY_SESSION_ID, str);
    }

    /* JADX INFO: compiled from: BoxAiHomeViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeViewModel$Companion;", "", "<init>", "()V", BoxAiHomeViewModel.KEY_SESSION_ID, "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
