package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import com.pspdfkit.BuildConfig;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreenFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/PopBackStackOp;", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperation;", BuildConfig.FLAVOR, "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenFragment;", "<init>", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenFragment;)V", "getFragment", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenFragment;", "execute", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "executor", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperationExecutor;", "execute$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopBackStackOp extends FragmentOperation {
    private final StackScreenFragment fragment;

    public final StackScreenFragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopBackStackOp(StackScreenFragment fragment) {
        super(null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.FragmentOperation
    public void execute$react_native_screens_release(FragmentManager fragmentManager, FragmentOperationExecutor executor) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.executePopBackStackOp$react_native_screens_release(fragmentManager, this);
    }
}
