package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FragmentOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH ¢\u0006\u0002\b\n\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperation;", "", "<init>", "()V", "execute", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "executor", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperationExecutor;", "execute$react_native_screens_release", "Lcom/swmansion/rnscreens/gamma/stack/host/AddAndSetAsPrimaryOp;", "Lcom/swmansion/rnscreens/gamma/stack/host/FlushNowOp;", "Lcom/swmansion/rnscreens/gamma/stack/host/OnCommitCallbackOp;", "Lcom/swmansion/rnscreens/gamma/stack/host/PopBackStackOp;", "Lcom/swmansion/rnscreens/gamma/stack/host/RemoveOp;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FragmentOperation {
    public /* synthetic */ FragmentOperation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void execute$react_native_screens_release(FragmentManager fragmentManager, FragmentOperationExecutor executor);

    private FragmentOperation() {
    }
}
