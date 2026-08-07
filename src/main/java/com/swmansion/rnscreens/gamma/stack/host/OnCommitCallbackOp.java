package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0010¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/OnCommitCallbackOp;", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperation;", "onCommitCallback", "Ljava/lang/Runnable;", "allowStateLoss", "", "flushSync", "<init>", "(Ljava/lang/Runnable;ZZ)V", "getOnCommitCallback", "()Ljava/lang/Runnable;", "getAllowStateLoss", "()Z", "getFlushSync", "execute", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "executor", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperationExecutor;", "execute$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnCommitCallbackOp extends FragmentOperation {
    private final boolean allowStateLoss;
    private final boolean flushSync;
    private final Runnable onCommitCallback;

    public /* synthetic */ OnCommitCallbackOp(Runnable runnable, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2);
    }

    public final Runnable getOnCommitCallback() {
        return this.onCommitCallback;
    }

    public final boolean getAllowStateLoss() {
        return this.allowStateLoss;
    }

    public final boolean getFlushSync() {
        return this.flushSync;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnCommitCallbackOp(Runnable onCommitCallback, boolean z, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(onCommitCallback, "onCommitCallback");
        this.onCommitCallback = onCommitCallback;
        this.allowStateLoss = z;
        this.flushSync = z2;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.FragmentOperation
    public void execute$react_native_screens_release(FragmentManager fragmentManager, FragmentOperationExecutor executor) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.executeOnCommitCallbackOp$react_native_screens_release(fragmentManager, this);
    }
}
