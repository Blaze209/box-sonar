package com.box.android.browse.cpl.offlined;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import com.box.android.base.presentation.views.menu.SortSheetFragment;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.databinding.GenericComposeViewBinding;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.RemoveOfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.cpl.ScopesStore;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IFeatureFlip;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: OfflinedFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 H\u0017J\u0016\u0010!\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 H\u0017J\u0014\u0010\"\u001a\u0004\u0018\u00010\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u001dH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "<init>", "()V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "onResume", "", "onPause", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "openSortingMenu", "getType", "", "getGenericId", "", "updateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "shouldUpdateFragment", "getTitle", "context", "Landroid/content/Context;", "updateFromRemote", "onBackPressed", "isFloatingMenuAvailable", "getAmplitudePageName", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflinedFragment extends Fragment implements BoxFragmentInterface {
    private static final String STORE_KEY = "storeKey";
    private Store<OfflinedReducer.State, OfflinedReducer.Action> store;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String[] SUCCESS_MESSAGES_TO_TRIGGER_UPDATE = {Controller.ACTION_SORT_PREFERENCES_CHANGED, Controller.ACTION_REMOVE_OFFLINE_ITEM, Controller.ACTION_ADD_OFFLINE_ITEM, Controller.ACTION_ADD_OFFLINE_ITEM_ALL_FINISHED, Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE, OfflineBoxJob.class.getName(), OfflineBoxJobCollection.class.getName(), RemoveOfflineBoxJobCollection.class.getName(), Controller.ACTION_DELETED_FOLDER, Controller.ACTION_DELETED_FILE};
    private static final String[] MESSAGES_TO_TRIGGER_UPDATE = {BoxSwitchUserMessage.ACTION_SWITCHED_USER};

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 8;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Store<OfflinedReducer.State, OfflinedReducer.Action> store = this.store;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        store.send(new OfflinedReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        KeyEventDispatcher.Component activity = getActivity();
        IBoxFragmentActivity iBoxFragmentActivity = activity instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity : null;
        if (iBoxFragmentActivity != null) {
            iBoxFragmentActivity.dismissSnackbar(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("storeKey") : null;
        if (string != null) {
            this.store = ScopesStore.INSTANCE.requireStore(string);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GenericComposeViewBinding genericComposeViewBindingInflate = GenericComposeViewBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(genericComposeViewBindingInflate, "inflate(...)");
        ComposeView composeView = genericComposeViewBindingInflate.composeView;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        FragmentActivity activity = getActivity();
        final BoxFragmentActivity boxFragmentActivity = activity instanceof BoxFragmentActivity ? (BoxFragmentActivity) activity : null;
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-584857075, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return OfflinedFragment.onCreateView$lambda$0$0(this.f$0, boxFragmentActivity, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(null), 3, null);
        ConstraintLayout root = genericComposeViewBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(OfflinedFragment offlinedFragment, BoxFragmentActivity boxFragmentActivity, Composer composer, int i) {
        FeatureFlips featureFlips;
        IFeatureFlip mainScreenRedesign;
        ComposerKt.sourceInformation(composer, "C81@3353L184:OfflinedFragment.kt#t6qdi3");
        boolean enabled = false;
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-584857075, i, -1, "com.box.android.browse.cpl.offlined.OfflinedFragment.onCreateView.<anonymous>.<anonymous> (OfflinedFragment.kt:81)");
            }
            Store<OfflinedReducer.State, OfflinedReducer.Action> store = offlinedFragment.store;
            if (store == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
                store = null;
            }
            Store<OfflinedReducer.State, OfflinedReducer.Action> store2 = store;
            if (boxFragmentActivity != null && (featureFlips = boxFragmentActivity.mFeatureFlips) != null && (mainScreenRedesign = featureFlips.getMainScreenRedesign()) != null) {
                enabled = mainScreenRedesign.getEnabled();
            }
            OfflinedContentKt.OfflinedContent(store2, null, null, enabled, false, composer, 0, 22);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflinedFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2", f = "OfflinedFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OfflinedFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: OfflinedFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2$1", f = "OfflinedFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ OfflinedFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(OfflinedFragment offlinedFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = offlinedFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Store store = this.this$0.store;
                if (store == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("store");
                    store = null;
                }
                C01281 c01281 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.offlined.OfflinedFragment.onCreateView.2.1.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((OfflinedReducer.State) obj2).getVisible());
                    }
                };
                final OfflinedFragment offlinedFragment = this.this$0;
                StoreKt.observe(store, c01281, coroutineScope, new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return OfflinedFragment.AnonymousClass2.AnonymousClass1.invokeSuspend$lambda$0(objectRef, offlinedFragment, coroutineScope, ((Boolean) obj2).booleanValue());
                    }
                });
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlinx.coroutines.Job] */
            public static final Unit invokeSuspend$lambda$0(Ref.ObjectRef objectRef, final OfflinedFragment offlinedFragment, CoroutineScope coroutineScope, boolean z) {
                Store store = null;
                if (z) {
                    Store store2 = offlinedFragment.store;
                    if (store2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("store");
                    } else {
                        store = store2;
                    }
                    objectRef.element = StoreKt.observe(store, new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2$1$2$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((OfflinedReducer.State) obj).getOutdatedItems();
                        }
                    }, coroutineScope, new Function1() { // from class: com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2$1$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfflinedFragment.AnonymousClass2.AnonymousClass1.invokeSuspend$lambda$0$0(offlinedFragment, (List) obj);
                        }
                    });
                } else {
                    Job job = (Job) objectRef.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    FragmentActivity activity = offlinedFragment.getActivity();
                    IBoxFragmentActivity iBoxFragmentActivity = activity instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity : null;
                    if (iBoxFragmentActivity != null) {
                        iBoxFragmentActivity.dismissSnackbar(offlinedFragment);
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0$0(final OfflinedFragment offlinedFragment, List list) {
                IBoxFragmentActivity iBoxFragmentActivity;
                if (!list.isEmpty()) {
                    KeyEventDispatcher.Component activity = offlinedFragment.getActivity();
                    iBoxFragmentActivity = activity instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity : null;
                    if (iBoxFragmentActivity != null) {
                        iBoxFragmentActivity.displaySnackbar(R.string.Update_offline_files, R.string.Update_all, new View.OnClickListener() { // from class: com.box.android.browse.cpl.offlined.OfflinedFragment$onCreateView$2$1$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                OfflinedFragment.AnonymousClass2.AnonymousClass1.invokeSuspend$lambda$0$0$0(offlinedFragment, view);
                            }
                        });
                    }
                } else {
                    KeyEventDispatcher.Component activity2 = offlinedFragment.getActivity();
                    iBoxFragmentActivity = activity2 instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity2 : null;
                    if (iBoxFragmentActivity != null) {
                        iBoxFragmentActivity.dismissSnackbar(offlinedFragment);
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0$0$0(OfflinedFragment offlinedFragment, View view) {
                Store store = offlinedFragment.store;
                if (store == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("store");
                    store = null;
                }
                store.send(OfflinedReducer.Action.SyncItems.INSTANCE);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = OfflinedFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(OfflinedFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (getActivity() == null) {
            return false;
        }
        if (item.getItemId() == R.id.folder_sort) {
            openSortingMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private final void openSortingMenu() {
        SortSheetFragment.newInstance(getActivity()).showAndHideSoftInput(getActivity(), requireView().getWindowToken());
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return "-1";
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public void updateFragment(BoxMessage<?> message) {
        if (message == null) {
            return;
        }
        if ((message.wasSuccessful() && ArraysKt.contains(SUCCESS_MESSAGES_TO_TRIGGER_UPDATE, message.getAction())) || ArraysKt.contains(MESSAGES_TO_TRIGGER_UPDATE, message.getAction())) {
            Store<OfflinedReducer.State, OfflinedReducer.Action> store = this.store;
            if (store == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
                store = null;
            }
            store.send(OfflinedReducer.Action.LoadItems.INSTANCE);
        }
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldUpdateFragment(BoxMessage<?> message) {
        if (message == null) {
            return false;
        }
        return (message.wasSuccessful() && ArraysKt.contains(SUCCESS_MESSAGES_TO_TRIGGER_UPDATE, message.getAction())) || ArraysKt.contains(MESSAGES_TO_TRIGGER_UPDATE, message.getAction());
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Offlined_Items);
        }
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_OFFLINE;
    }

    /* JADX INFO: compiled from: OfflinedFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u001e\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedFragment$Companion;", "", "<init>", "()V", "SUCCESS_MESSAGES_TO_TRIGGER_UPDATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "MESSAGES_TO_TRIGGER_UPDATE", "STORE_KEY", "getInstance", "Lcom/box/android/browse/cpl/offlined/OfflinedFragment;", "storeKey", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OfflinedFragment getInstance(String storeKey) {
            Intrinsics.checkNotNullParameter(storeKey, "storeKey");
            Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("storeKey", storeKey));
            OfflinedFragment offlinedFragment = new OfflinedFragment();
            offlinedFragment.setArguments(bundleBundleOf);
            return offlinedFragment;
        }
    }
}
