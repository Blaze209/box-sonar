package com.box.android.navigationmodernization;

import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: MainNavigationViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/box/android/navigationmodernization/MainNavigationViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mutableRequestedTargets", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "requestedTargets", "Lkotlinx/coroutines/flow/SharedFlow;", "getRequestedTargets", "()Lkotlinx/coroutines/flow/SharedFlow;", "submit", "", "target", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainNavigationViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<MainNavigationTarget> mutableRequestedTargets;
    private final SharedFlow<MainNavigationTarget> requestedTargets;

    @Inject
    public MainNavigationViewModel() {
        MutableSharedFlow<MainNavigationTarget> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        this.mutableRequestedTargets = MutableSharedFlow;
        this.requestedTargets = FlowKt.asSharedFlow(MutableSharedFlow);
    }

    public final SharedFlow<MainNavigationTarget> getRequestedTargets() {
        return this.requestedTargets;
    }

    public final void submit(MainNavigationTarget target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.mutableRequestedTargets.tryEmit(target);
    }
}
