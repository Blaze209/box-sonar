package com.swmansion.rnscreens.gamma.stack.host;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.pspdfkit.BuildConfig;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelper;
import com.swmansion.rnscreens.gamma.helpers.ViewIdGenerator;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreenFragment;
import com.swmansion.rnscreens.utils.RNSLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\r\u0010!\u001a\u00020\u001fH\u0000¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u001fH\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b*J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\u0018\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020\u0017H\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u001fH\u0002J\b\u00105\u001a\u00020\u001fH\u0016J\u0018\u00106\u001a\u00020\u001f2\u0006\u0010.\u001a\u0002072\u0006\u00108\u001a\u00020\u0017H\u0016J\r\u00109\u001a\u00020\u001fH\u0000¢\u0006\u0002\b:R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/StackContainer;", "Landroid/widget/FrameLayout;", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "context", "Landroid/content/Context;", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/stack/host/StackContainerDelegate;", "<init>", "(Landroid/content/Context;Ljava/lang/ref/WeakReference;)V", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "requireFragmentManager", "containerParentOrNull", "Lcom/swmansion/rnscreens/gamma/stack/host/StackContainerParent;", "stackModel", "", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenFragment;", "pendingPopOperations", "Lcom/swmansion/rnscreens/gamma/stack/host/PopOperation;", "pendingPushOperations", "Lcom/swmansion/rnscreens/gamma/stack/host/PushOperation;", "hasPendingOperations", "", "getHasPendingOperations", "()Z", "fragmentOpExecutor", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperationExecutor;", "fragmentOps", "Lcom/swmansion/rnscreens/gamma/stack/host/FragmentOperation;", "onAttachedToWindow", "", "onDetachedFromWindow", "setupFragmentManger", "setupFragmentManger$react_native_screens_release", "performContainerUpdateIfNeeded", "performContainerUpdateIfNeeded$react_native_screens_release", "enqueuePushOperation", "stackScreen", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "enqueuePushOperation$react_native_screens_release", "enqueuePopOperation", "enqueuePopOperation$react_native_screens_release", "performOperations", "applyOperationsAndComputeFragmentManagerOperations", "onNativeFragmentPop", BuildConfig.FLAVOR, "dumpStackModel", "createFragmentForScreen", "screen", "canNavigateBack", "updateTopFragment", "updateLaidOutFlagIfNeededAndPossible", "onBackStackChanged", "onBackStackChangeCommitted", "Landroidx/fragment/app/Fragment;", TokenRequest.TokenType.POP, "forceSubtreeMeasureAndLayoutPass", "forceSubtreeMeasureAndLayoutPass$react_native_screens_release", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackContainer extends FrameLayout implements FragmentManager.OnBackStackChangedListener {
    public static final String TAG = "StackContainer";
    private final WeakReference<StackContainerDelegate> delegate;
    private FragmentManager fragmentManager;
    private final FragmentOperationExecutor fragmentOpExecutor;
    private final List<FragmentOperation> fragmentOps;
    private final List<PopOperation> pendingPopOperations;
    private final List<PushOperation> pendingPushOperations;
    private final List<StackScreenFragment> stackModel;

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackContainer(Context context, WeakReference<StackContainerDelegate> delegate) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.stackModel = new ArrayList();
        this.pendingPopOperations = new ArrayList();
        this.pendingPushOperations = new ArrayList();
        this.fragmentOpExecutor = new FragmentOperationExecutor();
        this.fragmentOps = new ArrayList();
        setId(ViewIdGenerator.INSTANCE.generateViewId());
    }

    private final FragmentManager requireFragmentManager() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("[RNScreens] Attempt to use nullish FragmentManager".toString());
    }

    private final StackContainerParent containerParentOrNull() {
        return (StackContainerParent) getParent();
    }

    private final boolean getHasPendingOperations() {
        return (this.pendingPushOperations.isEmpty() && this.pendingPopOperations.isEmpty()) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.d(TAG, "StackContainer [" + getId() + "] attached to window");
        super.onAttachedToWindow();
        setupFragmentManger$react_native_screens_release();
        updateLaidOutFlagIfNeededAndPossible();
        performContainerUpdateIfNeeded$react_native_screens_release();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        requireFragmentManager().removeOnBackStackChangedListener(this);
        this.fragmentManager = null;
    }

    public final void setupFragmentManger$react_native_screens_release() {
        FragmentManager fragmentManagerFindFragmentManagerForView = FragmentManagerHelper.INSTANCE.findFragmentManagerForView(this);
        if (fragmentManagerFindFragmentManagerForView == null) {
            throw new IllegalStateException("[RNScreens] Nullish fragment manager - can't run container operations".toString());
        }
        fragmentManagerFindFragmentManagerForView.addOnBackStackChangedListener(this);
        this.fragmentManager = fragmentManagerFindFragmentManagerForView;
    }

    public final void performContainerUpdateIfNeeded$react_native_screens_release() {
        if (getHasPendingOperations() && isAttachedToWindow()) {
            performOperations(requireFragmentManager());
        }
    }

    public final void enqueuePushOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPushOperations.add(new PushOperation(stackScreen));
    }

    public final void enqueuePopOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPopOperations.add(new PopOperation(stackScreen));
    }

    private final void performOperations(FragmentManager fragmentManager) {
        applyOperationsAndComputeFragmentManagerOperations();
        this.fragmentOpExecutor.executeOperations$react_native_screens_release(fragmentManager, this.fragmentOps, false);
        dumpStackModel();
    }

    private final void applyOperationsAndComputeFragmentManagerOperations() {
        Object next;
        this.fragmentOps.clear();
        if (getHasPendingOperations()) {
            this.fragmentOps.add(new OnCommitCallbackOp(new Runnable() { // from class: com.swmansion.rnscreens.gamma.stack.host.StackContainer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.updateTopFragment();
                }
            }, true, false));
        }
        for (PopOperation popOperation : this.pendingPopOperations) {
            Iterator<T> it = this.stackModel.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((StackScreenFragment) next).getStackScreen() != popOperation.getScreen());
            if (next == null) {
                throw new IllegalStateException("[RNScreens] Unable to find a fragment to pop".toString());
            }
            StackScreenFragment stackScreenFragment = (StackScreenFragment) next;
            if (this.stackModel.size() <= 1) {
                throw new IllegalStateException("[RNScreens] Attempt to pop last screen from the stack".toString());
            }
            this.fragmentOps.add(new PopBackStackOp(stackScreenFragment));
            List<StackScreenFragment> list = this.stackModel;
            if (list.remove(CollectionsKt.getLastIndex(list)) != stackScreenFragment) {
                throw new IllegalStateException("[RNScreens] Attempt to pop non-top screen".toString());
            }
        }
        Iterator<T> it2 = this.pendingPushOperations.iterator();
        while (it2.hasNext()) {
            StackScreenFragment stackScreenFragmentCreateFragmentForScreen = createFragmentForScreen(((PushOperation) it2.next()).getScreen(), !this.stackModel.isEmpty());
            this.fragmentOps.add(new AddAndSetAsPrimaryOp(stackScreenFragmentCreateFragmentForScreen, getId(), !this.stackModel.isEmpty(), false, 8, null));
            this.stackModel.add(stackScreenFragmentCreateFragmentForScreen);
        }
        if (this.stackModel.isEmpty()) {
            throw new IllegalStateException("[RNScreens] Stack should never be empty after updates".toString());
        }
        this.pendingPopOperations.clear();
        this.pendingPushOperations.clear();
    }

    private final void onNativeFragmentPop(StackScreenFragment fragment) {
        if (!this.stackModel.remove(fragment)) {
            throw new IllegalArgumentException("[RNScreens] onNativeFragmentPop must be called with the fragment present in stack model".toString());
        }
        if (this.stackModel.isEmpty()) {
            throw new IllegalStateException("[RNScreens] Stack model should not be empty after a native pop".toString());
        }
        if (requireFragmentManager().getPrimaryNavigationFragment() == fragment) {
            throw new IllegalStateException("[RNScreens] Primary navigation fragment not updated by native pop".toString());
        }
        updateTopFragment();
    }

    private final void dumpStackModel() {
        Log.d(TAG, "StackContainer [" + getId() + "] MODEL BEGIN");
        Iterator<T> it = this.stackModel.iterator();
        while (it.hasNext()) {
            Log.d(TAG, String.valueOf(((StackScreenFragment) it.next()).getStackScreen().getScreenKey()));
        }
    }

    private final StackScreenFragment createFragmentForScreen(StackScreen screen, boolean canNavigateBack) {
        StackScreenFragment stackScreenFragment = new StackScreenFragment(screen, canNavigateBack);
        Log.d(TAG, "Created Fragment " + stackScreenFragment + " for screen " + screen.getScreenKey());
        return stackScreenFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTopFragment() {
        FragmentManager fragmentManagerRequireFragmentManager = requireFragmentManager();
        List<Fragment> fragments = fragmentManagerRequireFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof StackScreenFragment) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            throw new IllegalStateException("[RNScreens] Empty fragment manager while attempting to update top fragment".toString());
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StackScreenFragment) it.next()).onResignTopFragment$react_native_screens_release();
        }
        ((StackScreenFragment) CollectionsKt.last((List) arrayList2)).onBecomeTopFragment$react_native_screens_release();
        if (fragmentManagerRequireFragmentManager.getPrimaryNavigationFragment() != CollectionsKt.last((List) arrayList2)) {
            throw new IllegalStateException("[RNScreens] Top fragment different from primary navigation fragment".toString());
        }
    }

    private final void updateLaidOutFlagIfNeededAndPossible() {
        StackContainerParent stackContainerParentContainerParentOrNull;
        if (!isAttachedToWindow() || !ViewExtKt.isMeasured(this) || isLaidOut() || isInLayout() || (stackContainerParentContainerParentOrNull = containerParentOrNull()) == null) {
            return;
        }
        stackContainerParentContainerParentOrNull.layoutContainerNow();
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChangeCommitted(Fragment fragment, boolean pop) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!(fragment instanceof StackScreenFragment)) {
            Log.w(TAG, "[RNScreens] Unexpected type of fragment: " + fragment.getClass().getSimpleName());
            return;
        }
        StackScreenFragment stackScreenFragment = (StackScreenFragment) fragment;
        if (stackScreenFragment.isRemoving()) {
            StackContainerDelegate stackContainerDelegate = this.delegate.get();
            if (stackContainerDelegate != null) {
                stackContainerDelegate.onScreenDismissCommitted(stackScreenFragment.getStackScreen());
            }
            if (this.stackModel.contains(fragment)) {
                onNativeFragmentPop(stackScreenFragment);
            }
        }
    }

    public final void forceSubtreeMeasureAndLayoutPass$react_native_screens_release() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }
}
