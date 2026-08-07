package com.box.android.browse.cpl.recents;

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
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import com.box.android.base.presentation.views.menu.RecentItemsFilterFragment;
import com.box.android.browse.R;
import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.databinding.GenericComposeViewBinding;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.cpl.ScopesStore;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IFeatureFlip;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import com.facebook.react.uimanager.ViewProps;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RecentsFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0016\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"H\u0017J\u0016\u0010#\u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"H\u0017J\u0014\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\u0006\u0010+\u001a\u00020,R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "<init>", "()V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "actionableItemsListStore", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onResume", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "getType", "", "getGenericId", "", "updateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "shouldUpdateFragment", "getTitle", "context", "Landroid/content/Context;", "updateFromRemote", "onBackPressed", "isFloatingMenuAvailable", "getAmplitudePageName", ViewProps.FILTER, "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiRecentItems$FILTER;", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsFragment extends Fragment implements BoxFragmentInterface {
    private static final String STORE_KEY = "storeKey";
    private Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> actionableItemsListStore;
    private Store<RecentsReducer.State, RecentsReducer.Action> store;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String[] SUCCESS_MESSAGES_TO_TRIGGER_UPDATE = {Controller.ACTION_GET_FILE_INFO, Controller.ACTION_REMOVE_OFFLINE_ITEM, Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE, Controller.ACTION_ADD_OFFLINE_ITEM, Controller.ACTION_ADD_OFFLINE_ITEM_ALL_FINISHED, Controller.ACTION_DELETED_FILE};
    private static final String[] MESSAGES_TO_TRIGGER_UPDATE = {BoxSwitchUserMessage.ACTION_SWITCHED_USER};

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 13;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        Store<RecentsReducer.State, RecentsReducer.Action> store = null;
        String string = arguments != null ? arguments.getString("storeKey") : null;
        if (string != null) {
            Store<RecentsReducer.State, RecentsReducer.Action> storeRequireStore = ScopesStore.INSTANCE.requireStore(string);
            this.store = storeRequireStore;
            if (storeRequireStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
            } else {
                store = storeRequireStore;
            }
            this.actionableItemsListStore = store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.recents.RecentsFragment.onCreate.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((RecentsReducer.State) obj).getActionableItemsListState();
                }
            }, AnonymousClass2.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.recents.RecentsFragment$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: RecentsFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, RecentsReducer.Action.ChildActionableItemsListAction> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, RecentsReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final RecentsReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new RecentsReducer.Action.ChildActionableItemsListAction(p0);
        }
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GenericComposeViewBinding genericComposeViewBindingInflate = GenericComposeViewBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(genericComposeViewBindingInflate, "inflate(...)");
        ComposeView composeView = genericComposeViewBindingInflate.composeView;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        FragmentActivity activity = getActivity();
        final BoxFragmentActivity boxFragmentActivity = activity instanceof BoxFragmentActivity ? (BoxFragmentActivity) activity : null;
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(933784862, true, new Function2() { // from class: com.box.android.browse.cpl.recents.RecentsFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return RecentsFragment.onCreateView$lambda$0$0(this.f$0, boxFragmentActivity, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09602(null), 3, null);
        ConstraintLayout root = genericComposeViewBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(RecentsFragment recentsFragment, BoxFragmentActivity boxFragmentActivity, Composer composer, int i) {
        FeatureFlips featureFlips;
        IFeatureFlip mainScreenRedesign;
        ComposerKt.sourceInformation(composer, "C72@3204L183:RecentsFragment.kt#cf7xak");
        boolean enabled = false;
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(933784862, i, -1, "com.box.android.browse.cpl.recents.RecentsFragment.onCreateView.<anonymous>.<anonymous> (RecentsFragment.kt:72)");
            }
            Store<RecentsReducer.State, RecentsReducer.Action> store = recentsFragment.store;
            if (store == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
                store = null;
            }
            Store<RecentsReducer.State, RecentsReducer.Action> store2 = store;
            if (boxFragmentActivity != null && (featureFlips = boxFragmentActivity.mFeatureFlips) != null && (mainScreenRedesign = featureFlips.getMainScreenRedesign()) != null) {
                enabled = mainScreenRedesign.getEnabled();
            }
            RecentsContentKt.RecentsContent(store2, null, null, enabled, false, composer, 0, 22);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecentsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2", f = "RecentsFragment.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09602(Continuation<? super C09602> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecentsFragment.this.new C09602(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09602) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RecentsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1", f = "RecentsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ RecentsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RecentsFragment recentsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = recentsFragment;
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
                C01291 c01291 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.recents.RecentsFragment.onCreateView.2.1.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((RecentsReducer.State) obj2).getVisible());
                    }
                };
                final RecentsFragment recentsFragment = this.this$0;
                StoreKt.observe(store, c01291, coroutineScope, new Function1() { // from class: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return RecentsFragment.C09602.AnonymousClass1.invokeSuspend$lambda$0(objectRef, recentsFragment, coroutineScope, ((Boolean) obj2).booleanValue());
                    }
                });
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlinx.coroutines.Job] */
            public static final Unit invokeSuspend$lambda$0(Ref.ObjectRef objectRef, final RecentsFragment recentsFragment, CoroutineScope coroutineScope, boolean z) {
                Store store = null;
                if (z) {
                    Store store2 = recentsFragment.store;
                    if (store2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("store");
                    } else {
                        store = store2;
                    }
                    objectRef.element = StoreKt.observe(store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1$2$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((RecentsReducer.State) obj).getActionableItemsListState();
                        }
                    }).scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1$2$2
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                        }
                    }), new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1$2$3
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ItemsListReducer.State) obj).getFilesConfigState();
                        }
                    }, coroutineScope, new Function1() { // from class: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RecentsFragment.C09602.AnonymousClass1.invokeSuspend$lambda$0$0(recentsFragment, (FilesDisplayConfigReducer.State) obj);
                        }
                    });
                } else {
                    Job job = (Job) objectRef.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    FragmentActivity activity = recentsFragment.getActivity();
                    IBoxFragmentActivity iBoxFragmentActivity = activity instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity : null;
                    if (iBoxFragmentActivity != null) {
                        iBoxFragmentActivity.dismissSnackbar(recentsFragment);
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0$0(final RecentsFragment recentsFragment, FilesDisplayConfigReducer.State state) {
                IBoxFragmentActivity iBoxFragmentActivity;
                ItemsFilter selectedFilter = state.getSelectedFilter();
                if (!Intrinsics.areEqual(selectedFilter, ItemsFilter.AllRecents.INSTANCE)) {
                    String string = recentsFragment.getResources().getString(R.string.Filtered_By, recentsFragment.getResources().getString(selectedFilter.getStringRes()));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    KeyEventDispatcher.Component activity = recentsFragment.getActivity();
                    iBoxFragmentActivity = activity instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity : null;
                    if (iBoxFragmentActivity != null) {
                        iBoxFragmentActivity.displaySnackbar(string, R.string.Show_All, new View.OnClickListener() { // from class: com.box.android.browse.cpl.recents.RecentsFragment$onCreateView$2$1$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                RecentsFragment.C09602.AnonymousClass1.invokeSuspend$lambda$0$0$0(recentsFragment, view);
                            }
                        });
                    }
                } else {
                    KeyEventDispatcher.Component activity2 = recentsFragment.getActivity();
                    iBoxFragmentActivity = activity2 instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity2 : null;
                    if (iBoxFragmentActivity != null) {
                        iBoxFragmentActivity.dismissSnackbar(recentsFragment);
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0$0$0(RecentsFragment recentsFragment, View view) {
                Store store = recentsFragment.store;
                if (store == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("store");
                    store = null;
                }
                store.send(RecentsReducerKt.updateRecentsFilter(ItemsFilter.AllRecents.INSTANCE));
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = RecentsFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(RecentsFragment.this, null), this) == coroutine_suspended) {
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
    public void onResume() {
        super.onResume();
        Store<RecentsReducer.State, RecentsReducer.Action> store = this.store;
        Store<RecentsReducer.State, RecentsReducer.Action> store2 = null;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        store.send(RecentsReducer.Action.LoadItems.INSTANCE);
        Store<RecentsReducer.State, RecentsReducer.Action> store3 = this.store;
        if (store3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
        } else {
            store2 = store3;
        }
        store2.send(new RecentsReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE)));
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.recentItemsFilter) {
            return false;
        }
        FragmentActivity activity = getActivity();
        Store<RecentsReducer.State, RecentsReducer.Action> store = this.store;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        RecentItemsFilterFragment.newInstance(activity, Integer.valueOf(((RecentsReducer.State) StoreKt.stateValue(store)).getSelectedFilter().getMenuId())).show(getParentFragmentManager(), BottomSheetMenuFragment.TAG);
        return true;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return BoxCommonConstants.RECENTS_ROOT_FOLDER_ID;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public void updateFragment(BoxMessage<?> message) {
        if (message == null) {
            return;
        }
        String action = message.getAction();
        if (ArraysKt.contains(SUCCESS_MESSAGES_TO_TRIGGER_UPDATE, action) || ArraysKt.contains(MESSAGES_TO_TRIGGER_UPDATE, action)) {
            Store<RecentsReducer.State, RecentsReducer.Action> store = this.store;
            if (store == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
                store = null;
            }
            store.send(RecentsReducer.Action.LoadItems.INSTANCE);
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
            return context.getString(R.string.recents);
        }
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_RECENT;
    }

    public final BoxExtendedApiRecentItems.FILTER filter() {
        Store<RecentsReducer.State, RecentsReducer.Action> store = this.store;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        ItemsFilter selectedFilter = ((RecentsReducer.State) StoreKt.stateValue(store)).getSelectedFilter();
        if (Intrinsics.areEqual(selectedFilter, ItemsFilter.AllRecents.INSTANCE)) {
            return BoxExtendedApiRecentItems.FILTER.ALL;
        }
        if (Intrinsics.areEqual(selectedFilter, ItemsFilter.BoxNotes.INSTANCE)) {
            return BoxExtendedApiRecentItems.FILTER.BOX_NOTE;
        }
        if (Intrinsics.areEqual(selectedFilter, ItemsFilter.SharedLinks.INSTANCE)) {
            return BoxExtendedApiRecentItems.FILTER.SHARED_LINKS;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: RecentsFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u001e\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsFragment$Companion;", "", "<init>", "()V", "SUCCESS_MESSAGES_TO_TRIGGER_UPDATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "MESSAGES_TO_TRIGGER_UPDATE", "STORE_KEY", "getInstance", "Lcom/box/android/browse/cpl/recents/RecentsFragment;", "storeKey", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RecentsFragment getInstance(String storeKey) {
            Intrinsics.checkNotNullParameter(storeKey, "storeKey");
            Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("storeKey", storeKey));
            RecentsFragment recentsFragment = new RecentsFragment();
            recentsFragment.setArguments(bundleBundleOf);
            return recentsFragment;
        }
    }
}
