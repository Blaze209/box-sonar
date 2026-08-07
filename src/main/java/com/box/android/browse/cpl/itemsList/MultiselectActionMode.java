package com.box.android.browse.cpl.itemsList;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.MenuKt;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuAction;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuActionsVisibility;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MultiselectActionMode.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/MultiselectActionMode;", "", "activity", "Landroidx/activity/ComponentActivity;", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "actionableItemsListStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "(Landroidx/activity/ComponentActivity;Landroidx/activity/result/ActivityResultLauncher;Lcom/box/android/cpl/Store;)V", "multiselectActionsCallback", "Landroidx/appcompat/view/ActionMode$Callback;", "getMultiselectActionsCallback", "()Landroidx/appcompat/view/ActionMode$Callback;", "multiselectActionsCallback$delegate", "Lkotlin/Lazy;", "actionMode", "Landroidx/appcompat/view/ActionMode;", "init", "", "viewOwnerScope", "Lkotlinx/coroutines/CoroutineScope;", "createMultiselectActionsCallback", "toggleActionMode", "multiselectEnabled", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultiselectActionMode {
    public static final int $stable = 8;
    private ActionMode actionMode;
    private final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> actionableItemsListStore;
    private final ComponentActivity activity;

    /* JADX INFO: renamed from: multiselectActionsCallback$delegate, reason: from kotlin metadata */
    private final Lazy multiselectActionsCallback;
    private final ActivityResultLauncher<String> permissionLauncher;

    public MultiselectActionMode(ComponentActivity activity, ActivityResultLauncher<String> permissionLauncher, Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> actionableItemsListStore) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissionLauncher, "permissionLauncher");
        Intrinsics.checkNotNullParameter(actionableItemsListStore, "actionableItemsListStore");
        this.activity = activity;
        this.permissionLauncher = permissionLauncher;
        this.actionableItemsListStore = actionableItemsListStore;
        this.multiselectActionsCallback = LazyKt.lazy(new Function0() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.createMultiselectActionsCallback();
            }
        });
    }

    private final ActionMode.Callback getMultiselectActionsCallback() {
        return (ActionMode.Callback) this.multiselectActionsCallback.getValue();
    }

    public final void init(CoroutineScope viewOwnerScope) {
        Intrinsics.checkNotNullParameter(viewOwnerScope, "viewOwnerScope");
        StoreKt.observe(this.actionableItemsListStore, new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode.init.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((ActionableItemsListReducer.State) obj).getIsSelecting());
            }
        }, viewOwnerScope, new Function1() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiselectActionMode.init$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        StoreKt.observe(this.actionableItemsListStore, new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode.init.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getMultiselect();
            }
        }, viewOwnerScope, new Function1() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiselectActionMode.init$lambda$1(this.f$0, (MultiselectReducer.State) obj);
            }
        });
        StoreKt.observe(this.actionableItemsListStore, new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode.init.5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getMenuActionsVisibility();
            }
        }, viewOwnerScope, new Function1() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiselectActionMode.init$lambda$2(this.f$0, (MultiselectMenuActionsVisibility) obj);
            }
        });
        StoreKt.observe(this.actionableItemsListStore, new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode.init.7
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getPermissionRequest();
            }
        }, viewOwnerScope, new Function1() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiselectActionMode.init$lambda$3(this.f$0, (ActionableItemsListReducer.State.PermissionRequest) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$0(MultiselectActionMode multiselectActionMode, boolean z) {
        multiselectActionMode.toggleActionMode(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$1(MultiselectActionMode multiselectActionMode, MultiselectReducer.State multiselect) {
        Intrinsics.checkNotNullParameter(multiselect, "multiselect");
        String str = null;
        MultiselectReducer.State.Selecting selecting = multiselect instanceof MultiselectReducer.State.Selecting ? (MultiselectReducer.State.Selecting) multiselect : null;
        int iItemCount = selecting != null ? selecting.itemCount() : 0;
        ActionMode actionMode = multiselectActionMode.actionMode;
        if (actionMode != null) {
            if (iItemCount > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = String.format(CommonBoxUtil.plural(R.array.n_items_selected, iItemCount), Arrays.copyOf(new Object[]{Integer.valueOf(iItemCount)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                str = str2;
            }
            actionMode.setTitle(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$2(MultiselectActionMode multiselectActionMode, MultiselectMenuActionsVisibility it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ActionMode actionMode = multiselectActionMode.actionMode;
        if (actionMode != null) {
            actionMode.invalidate();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$3(MultiselectActionMode multiselectActionMode, ActionableItemsListReducer.State.PermissionRequest permissionRequest) {
        if (permissionRequest != null) {
            multiselectActionMode.permissionLauncher.launch(permissionRequest.getPermission());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActionMode.Callback createMultiselectActionsCallback() {
        return new ActionMode.Callback() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode.createMultiselectActionsCallback.1
            @Override // androidx.appcompat.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater;
                if (menu == null) {
                    return false;
                }
                KeyEventDispatcher.Component component = MultiselectActionMode.this.activity;
                IBoxFragmentActivity iBoxFragmentActivity = component instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) component : null;
                if (iBoxFragmentActivity != null) {
                    iBoxFragmentActivity.onActionModeCreated(this);
                }
                if (mode != null && (menuInflater = mode.getMenuInflater()) != null) {
                    menuInflater.inflate(R.menu.folder_batch, menu);
                }
                MenuItem menuItemFindItem = menu.findItem(R.id.folder_box_ai);
                if (menuItemFindItem == null) {
                    return true;
                }
                setupBoxAiButton(menuItemFindItem);
                return true;
            }

            @Override // androidx.appcompat.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                Iterator<MenuItem> it;
                MultiselectMenuActionsVisibility menuActionsVisibility = ((ActionableItemsListReducer.State) StoreKt.stateValue(MultiselectActionMode.this.actionableItemsListStore)).getMenuActionsVisibility();
                if (menu == null || (it = MenuKt.iterator(menu)) == null) {
                    return true;
                }
                while (it.hasNext()) {
                    MenuItem next = it.next();
                    next.setVisible(menuActionsVisibility.isVisible(MultiselectMenuAction.INSTANCE.from(next.getItemId())));
                }
                return true;
            }

            private final void setupBoxAiButton(MenuItem menuItem) {
                final FrameLayout frameLayout;
                View actionView = menuItem.getActionView();
                if (actionView == null || (frameLayout = (FrameLayout) actionView.findViewById(R.id.box_ai_button_container)) == null) {
                    return;
                }
                final FrameLayout frameLayout2 = frameLayout;
                final MultiselectActionMode multiselectActionMode = MultiselectActionMode.this;
                if (frameLayout2.isAttachedToWindow()) {
                    Context context = frameLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    ComposeView composeView = new ComposeView(context, null, 0, 6, null);
                    composeView.setContent(ComposableLambdaKt.composableLambdaInstance(879470506, true, new MultiselectActionMode$createMultiselectActionsCallback$1$setupBoxAiButton$1$composeView$1$1(multiselectActionMode)));
                    frameLayout.addView(composeView, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                frameLayout2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$createMultiselectActionsCallback$1$setupBoxAiButton$$inlined$doOnAttach$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        frameLayout2.removeOnAttachStateChangeListener(this);
                        Context context2 = frameLayout.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        ComposeView composeView2 = new ComposeView(context2, null, 0, 6, null);
                        composeView2.setContent(ComposableLambdaKt.composableLambdaInstance(879470506, true, new MultiselectActionMode$createMultiselectActionsCallback$1$setupBoxAiButton$1$composeView$1$1(multiselectActionMode)));
                        frameLayout.addView(composeView2, new ViewGroup.LayoutParams(-1, -1));
                    }
                });
            }

            @Override // androidx.appcompat.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                ActionableItemsListReducer.Action.ExitMultiselectMode exitMultiselectMode = null;
                Integer numValueOf = item != null ? Integer.valueOf(item.getItemId()) : null;
                int i = R.id.folder_box_ai;
                if (numValueOf != null && numValueOf.intValue() == i) {
                    exitMultiselectMode = ActionableItemsListReducer.Action.OpenBoxAiForSelectedFiles.INSTANCE;
                } else {
                    int i2 = R.id.folder_batch_select;
                    if (numValueOf != null && numValueOf.intValue() == i2) {
                        exitMultiselectMode = ActionableItemsListReducer.Action.BatchSelect.INSTANCE;
                    } else {
                        int i3 = R.id.folder_batch_copy_move;
                        if (numValueOf != null && numValueOf.intValue() == i3) {
                            exitMultiselectMode = ActionableItemsListReducer.Action.BatchCopyMove.INSTANCE;
                        } else {
                            int i4 = R.id.folder_batch_delete;
                            if (numValueOf != null && numValueOf.intValue() == i4) {
                                exitMultiselectMode = ActionableItemsListReducer.Action.BatchDelete.INSTANCE;
                            } else {
                                int i5 = R.id.folder_batch_export;
                                if (numValueOf != null && numValueOf.intValue() == i5) {
                                    exitMultiselectMode = ActionableItemsListReducer.Action.BatchExport.INSTANCE;
                                } else {
                                    int i6 = R.id.folder_batch_save_for_offline;
                                    if (numValueOf != null && numValueOf.intValue() == i6) {
                                        exitMultiselectMode = ActionableItemsListReducer.Action.BatchSaveOffline.INSTANCE;
                                    } else {
                                        int i7 = R.id.folder_batch_remove_offline;
                                        if (numValueOf != null && numValueOf.intValue() == i7) {
                                            exitMultiselectMode = ActionableItemsListReducer.Action.BatchRemoveOffline.INSTANCE;
                                        } else {
                                            int i8 = R.id.folder_batch_deselect;
                                            if (numValueOf != null && numValueOf.intValue() == i8) {
                                                exitMultiselectMode = ActionableItemsListReducer.Action.ExitMultiselectMode.INSTANCE;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (exitMultiselectMode == null) {
                    return true;
                }
                MultiselectActionMode.this.actionableItemsListStore.send(exitMultiselectMode);
                return true;
            }

            @Override // androidx.appcompat.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                KeyEventDispatcher.Component component = MultiselectActionMode.this.activity;
                IBoxFragmentActivity iBoxFragmentActivity = component instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) component : null;
                if (iBoxFragmentActivity != null) {
                    iBoxFragmentActivity.onActionModeDestroyed(this);
                }
                MultiselectActionMode.this.actionableItemsListStore.send(ActionableItemsListReducer.Action.ExitMultiselectMode.INSTANCE);
            }
        };
    }

    private final void toggleActionMode(boolean multiselectEnabled) {
        ComponentActivity componentActivity = this.activity;
        if (componentActivity instanceof AppCompatActivity) {
            if (multiselectEnabled) {
                if (this.actionMode == null) {
                    this.actionMode = ((AppCompatActivity) componentActivity).startSupportActionMode(getMultiselectActionsCallback());
                }
            } else {
                ActionMode actionMode = this.actionMode;
                if (actionMode != null) {
                    actionMode.finish();
                }
                this.actionMode = null;
            }
        }
    }
}
