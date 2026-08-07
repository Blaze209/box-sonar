package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.box.androidsdk.content.requests.BoxRequestsMetadata;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelperKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentOperationExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u001d\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u001d\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u001d\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\"\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0002¨\u0006$"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperationExecutor;", "", "<init>", "()V", "executeOperations", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "ops", "", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperation;", "flushSync", "", "executeOperations$react_native_screens_release", "executeAddAndSetAsPrimaryOp", BoxRequestsMetadata.UpdateItemMetadata.BoxMetadataUpdateTask.OPERATION, "Lcom/swmansion/rnscreens/gamma/stack/host/AddAndSetAsPrimaryOp;", "executeAddAndSetAsPrimaryOp$react_native_screens_release", "executePopBackStackOp", "Lcom/swmansion/rnscreens/gamma/stack/host/PopBackStackOp;", "executePopBackStackOp$react_native_screens_release", "executeRemoveOp", "Lcom/swmansion/rnscreens/gamma/stack/host/RemoveOp;", "executeRemoveOp$react_native_screens_release", "executeFlushOp", "Lcom/swmansion/rnscreens/gamma/stack/host/FlushNowOp;", "executeFlushOp$react_native_screens_release", "executeOnCommitCallbackOp", "Lcom/swmansion/rnscreens/gamma/stack/host/OnCommitCallbackOp;", "executeOnCommitCallbackOp$react_native_screens_release", "commitTransaction", "tx", "Landroidx/fragment/app/FragmentTransaction;", "allowStateLoss", "commitAsync", "commitSync", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FragmentOperationExecutor {
    public static /* synthetic */ void executeOperations$react_native_screens_release$default(FragmentOperationExecutor fragmentOperationExecutor, FragmentManager fragmentManager, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        fragmentOperationExecutor.executeOperations$react_native_screens_release(fragmentManager, list, z);
    }

    public final void executeOperations$react_native_screens_release(FragmentManager fragmentManager, List<? extends FragmentOperation> ops, boolean flushSync) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(ops, "ops");
        Iterator<T> it = ops.iterator();
        while (it.hasNext()) {
            ((FragmentOperation) it.next()).execute$react_native_screens_release(fragmentManager, this);
        }
        if (flushSync) {
            fragmentManager.executePendingTransactions();
        }
    }

    public final void executeAddAndSetAsPrimaryOp$react_native_screens_release(FragmentManager fragmentManager, AddAndSetAsPrimaryOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        FragmentTransaction fragmentTransactionCreateTransactionWithReordering = FragmentManagerHelperKt.createTransactionWithReordering(fragmentManager);
        if (op.getAddToBackStack()) {
            fragmentTransactionCreateTransactionWithReordering.addToBackStack(op.getFragment().getStackScreen().getScreenKey());
        }
        fragmentTransactionCreateTransactionWithReordering.add(op.getContainerViewId(), op.getFragment());
        fragmentTransactionCreateTransactionWithReordering.setPrimaryNavigationFragment(op.getFragment());
        commitTransaction$default(this, fragmentTransactionCreateTransactionWithReordering, op.getAllowStateLoss(), false, 4, null);
    }

    public final void executePopBackStackOp$react_native_screens_release(FragmentManager fragmentManager, PopBackStackOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        fragmentManager.popBackStack(op.getFragment().getStackScreen().getScreenKey(), 1);
    }

    public final void executeRemoveOp$react_native_screens_release(FragmentManager fragmentManager, RemoveOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        FragmentTransaction fragmentTransactionCreateTransactionWithReordering = FragmentManagerHelperKt.createTransactionWithReordering(fragmentManager);
        fragmentTransactionCreateTransactionWithReordering.remove(op.getFragment());
        commitTransaction(fragmentTransactionCreateTransactionWithReordering, op.getAllowStateLoss(), op.getFlushSync());
    }

    public final void executeFlushOp$react_native_screens_release(FragmentManager fragmentManager, FlushNowOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        fragmentManager.executePendingTransactions();
    }

    public final void executeOnCommitCallbackOp$react_native_screens_release(FragmentManager fragmentManager, OnCommitCallbackOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        FragmentTransaction fragmentTransactionRunOnCommit = FragmentManagerHelperKt.createTransactionWithReordering(fragmentManager).runOnCommit(op.getOnCommitCallback());
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionRunOnCommit, "runOnCommit(...)");
        commitTransaction(fragmentTransactionRunOnCommit, op.getAllowStateLoss(), op.getFlushSync());
    }

    static /* synthetic */ void commitTransaction$default(FragmentOperationExecutor fragmentOperationExecutor, FragmentTransaction fragmentTransaction, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        fragmentOperationExecutor.commitTransaction(fragmentTransaction, z, z2);
    }

    private final void commitTransaction(FragmentTransaction tx, boolean allowStateLoss, boolean flushSync) {
        if (flushSync) {
            commitSync(tx, allowStateLoss);
        } else {
            commitAsync(tx, allowStateLoss);
        }
    }

    private final void commitAsync(FragmentTransaction tx, boolean allowStateLoss) {
        if (allowStateLoss) {
            tx.commitAllowingStateLoss();
        } else {
            tx.commit();
        }
    }

    private final void commitSync(FragmentTransaction tx, boolean allowStateLoss) {
        if (allowStateLoss) {
            tx.commitNowAllowingStateLoss();
        } else {
            tx.commitNow();
        }
    }
}
