package com.box.android.preview.preview;

import android.content.Intent;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.routing.PreviewRouter;
import com.box.android.preview.utils.ImmersiveModeManager;
import com.box.android.utilities.FlowExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PreviewActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/preview/PreviewActivityContent;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "previewRouter", "Lcom/box/android/preview/routing/PreviewRouter;", "previewActivityIntentHandler", "Lcom/box/android/preview/preview/PreviewActivityIntentHandler;", "uiDependencyProvider", "Lcom/box/android/preview/preview/PreviewUIDependencyProvider;", "useAiCenter", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/box/android/cpl/Store;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/preview/routing/PreviewRouter;Lcom/box/android/preview/preview/PreviewActivityIntentHandler;Lcom/box/android/preview/preview/PreviewUIDependencyProvider;Z)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getStore", "()Lcom/box/android/cpl/Store;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewActivityContent {
    public static final int $stable = 8;
    private final FragmentActivity activity;
    private final IntentServices intentServices;
    private final PreviewRouter previewRouter;
    private final Store<PreviewReducer.State, PreviewReducer.Action> store;

    public PreviewActivityContent(FragmentActivity activity, Store<PreviewReducer.State, PreviewReducer.Action> store, IntentServices intentServices, PreviewRouter previewRouter, final PreviewActivityIntentHandler previewActivityIntentHandler, final PreviewUIDependencyProvider uiDependencyProvider, final boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewRouter, "previewRouter");
        Intrinsics.checkNotNullParameter(previewActivityIntentHandler, "previewActivityIntentHandler");
        Intrinsics.checkNotNullParameter(uiDependencyProvider, "uiDependencyProvider");
        this.activity = activity;
        this.store = store;
        this.intentServices = intentServices;
        this.previewRouter = previewRouter;
        String stringExtra = activity.getIntent().getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL);
        if (stringExtra != null) {
            uiDependencyProvider.getSession().setSharedLink(stringExtra);
        }
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.core.app.OnNewIntentProvider");
        activity.addOnNewIntentListener(new Consumer() { // from class: com.box.android.preview.preview.PreviewActivityContent$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                PreviewActivityContent._init_$lambda$1(previewActivityIntentHandler, this, (Intent) obj);
            }
        });
        ComponentActivityKt.setContent$default(activity, null, ComposableLambdaKt.composableLambdaInstance(2123567063, true, new Function2() { // from class: com.box.android.preview.preview.PreviewActivityContent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PreviewActivityContent._init_$lambda$2(this.f$0, uiDependencyProvider, z, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        if (((PreviewReducer.State) StoreKt.stateValue(store)).getPreviewItem().getItemState() instanceof ItemState.Uninitialized) {
            store.send(PreviewReducer.Action.Initialize.INSTANCE);
        }
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        previewActivityIntentHandler.handleIntent(store, activity, intent, true);
        ImmersiveModeManager.INSTANCE.configureSystemBarVisibility(activity, FlowExtensionsKt.observe(store.getState(), new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewActivityContent.4
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((PreviewReducer.State) obj).isImmersiveMode());
            }
        }));
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new AnonymousClass5(null), 3, null);
    }

    public /* synthetic */ PreviewActivityContent(FragmentActivity fragmentActivity, Store store, IntentServices intentServices, PreviewRouter previewRouter, PreviewActivityIntentHandler previewActivityIntentHandler, PreviewUIDependencyProvider previewUIDependencyProvider, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, store, intentServices, previewRouter, previewActivityIntentHandler, previewUIDependencyProvider, (i & 64) != 0 ? false : z);
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final Store<PreviewReducer.State, PreviewReducer.Action> getStore() {
        return this.store;
    }

    public final IntentServices getIntentServices() {
        return this.intentServices;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(PreviewActivityIntentHandler previewActivityIntentHandler, PreviewActivityContent previewActivityContent, Intent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        previewActivityIntentHandler.handleIntent(previewActivityContent.store, previewActivityContent.activity, it, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(final PreviewActivityContent previewActivityContent, final PreviewUIDependencyProvider previewUIDependencyProvider, final boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C214@9345L87,214@9336L96:PreviewActivity.kt#viiktp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2123567063, i, -1, "com.box.android.preview.preview.PreviewActivityContent.<anonymous> (PreviewActivity.kt:214)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2027129964, true, new Function2() { // from class: com.box.android.preview.preview.PreviewActivityContent$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewActivityContent.lambda$2$0(this.f$0, previewUIDependencyProvider, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$2$0(PreviewActivityContent previewActivityContent, PreviewUIDependencyProvider previewUIDependencyProvider, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C215@9363L55:PreviewActivity.kt#viiktp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027129964, i, -1, "com.box.android.preview.preview.PreviewActivityContent.<anonymous>.<anonymous> (PreviewActivity.kt:215)");
            }
            PreviewScreenKt.PreviewScreen(previewActivityContent.store, previewUIDependencyProvider, z, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewActivityContent$5, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewActivityContent$5", f = "PreviewActivity.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreviewActivityContent.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewActivityContent$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: PreviewActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.preview.preview.PreviewActivityContent$5$1", f = "PreviewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PreviewActivityContent this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PreviewActivityContent previewActivityContent, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = previewActivityContent;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.previewRouter.initRouting();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(PreviewActivityContent.this.getActivity(), Lifecycle.State.STARTED, new AnonymousClass1(PreviewActivityContent.this, null), this) == coroutine_suspended) {
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
}
