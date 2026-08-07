package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import com.pspdfkit.BuildConfig;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreenFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0010¢\u0006\u0002\b\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/AddAndSetAsPrimaryOp;", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperation;", BuildConfig.FLAVOR, "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenFragment;", "containerViewId", "", "addToBackStack", "", "allowStateLoss", "<init>", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenFragment;IZZ)V", "getFragment", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenFragment;", "getContainerViewId", "()I", "getAddToBackStack", "()Z", "getAllowStateLoss", "execute", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "executor", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperationExecutor;", "execute$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddAndSetAsPrimaryOp extends FragmentOperation {
    private final boolean addToBackStack;
    private final boolean allowStateLoss;
    private final int containerViewId;
    private final StackScreenFragment fragment;

    public /* synthetic */ AddAndSetAsPrimaryOp(StackScreenFragment stackScreenFragment, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackScreenFragment, i, z, (i2 & 8) != 0 ? true : z2);
    }

    public final StackScreenFragment getFragment() {
        return this.fragment;
    }

    public final int getContainerViewId() {
        return this.containerViewId;
    }

    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final boolean getAllowStateLoss() {
        return this.allowStateLoss;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAndSetAsPrimaryOp(StackScreenFragment fragment, int i, boolean z, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.containerViewId = i;
        this.addToBackStack = z;
        this.allowStateLoss = z2;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.FragmentOperation
    public void execute$react_native_screens_release(FragmentManager fragmentManager, FragmentOperationExecutor executor) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.executeAddAndSetAsPrimaryOp$react_native_screens_release(fragmentManager, this);
    }
}
