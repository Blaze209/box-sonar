package com.box.android.base.presentation.watermarking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.WatermarkableItem;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WatermarkingActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0002\u0010\u0010R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "viewModel", "Lcom/box/android/base/presentation/watermarking/WatermarkingViewModel;", "getViewModel", "()Lcom/box/android/base/presentation/watermarking/WatermarkingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "Companion", "base_generalProdRelease", "state", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class WatermarkingActivity extends Hilt_WatermarkingActivity {

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public WatermarkingActivity() {
        final WatermarkingActivity watermarkingActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(WatermarkingViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.base.presentation.watermarking.WatermarkingActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return watermarkingActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.base.presentation.watermarking.WatermarkingActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return watermarkingActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.base.presentation.watermarking.WatermarkingActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? watermarkingActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final WatermarkingViewModel getViewModel() {
        return (WatermarkingViewModel) this.viewModel.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-363301730, true, new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatermarkingActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final WatermarkingActivity watermarkingActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C29@1065L570,29@1056L579:WatermarkingActivity.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-363301730, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingActivity.onCreate.<anonymous> (WatermarkingActivity.kt:29)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-21246743, true, new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final WatermarkingActivity watermarkingActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C30@1118L29,32@1212L177,32@1165L224,41@1502L12,39@1407L214:WatermarkingActivity.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-21246743, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingActivity.onCreate.<anonymous>.<anonymous> (WatermarkingActivity.kt:30)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(watermarkingActivity.getViewModel().getStore().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            Boolean boolValueOf = Boolean.valueOf(onCreate$lambda$0$0$0(stateCollectAsStateWithLifecycle).getShouldDismissWithSuccess());
            ComposerKt.sourceInformationMarkerStart(composer, 1056721338, "CC(remember):WatermarkingActivity.kt#9igjgp");
            boolean zChanged = composer.changed(stateCollectAsStateWithLifecycle) | composer.changedInstance(watermarkingActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function2) new WatermarkingActivity$onCreate$1$1$1$1(watermarkingActivity, stateCollectAsStateWithLifecycle, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composer, 0);
            Store<WatermarkingReducer.State, WatermarkingReducer.Action> store = watermarkingActivity.getViewModel().getStore();
            ComposerKt.sourceInformationMarkerStart(composer, 1056730453, "CC(remember):WatermarkingActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(watermarkingActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingActivity$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WatermarkingActivity.onCreate$lambda$0$0$2$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WatermarkingScreenKt.WatermarkingScreen(store, (Function0) objRememberedValue2, watermarkingActivity.mFeatureFlips.getMainScreenRedesign().getEnabled(), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$2$0(WatermarkingActivity watermarkingActivity) {
        watermarkingActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: WatermarkingActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingActivity$Companion;", "", "<init>", "()V", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "item", "Lcom/box/android/domain/models/item/WatermarkableItem;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getLaunchIntent(Context context, WatermarkableItem item) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(item, "item");
            Intent intent = new Intent(context, (Class<?>) WatermarkingActivity.class);
            intent.putExtra(WatermarkingViewModel.EXTRA_WATERMARKABLE_ITEM, item);
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WatermarkingReducer.State onCreate$lambda$0$0$0(State<? extends WatermarkingReducer.State> state) {
        return state.getValue();
    }
}
