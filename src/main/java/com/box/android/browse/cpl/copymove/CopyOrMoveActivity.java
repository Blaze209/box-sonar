package com.box.android.browse.cpl.copymove;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.ItemsListReducerKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: CopyOrMoveActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0015R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "vm", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveViewModel;", "getVm", "()Lcom/box/android/browse/cpl/copymove/CopyOrMoveViewModel;", "vm$delegate", "Lkotlin/Lazy;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CopyOrMoveActivity extends Hilt_CopyOrMoveActivity {
    private static final String INITIAL_FOLDER_HIERARCHY = "INITIAL_FOLDER_HIERARCHY";
    private static final String ITEMS_TO_COPY_KEY = "ITEMS_TO_COPY_KEY";

    /* JADX INFO: renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public CopyOrMoveActivity() {
        final CopyOrMoveActivity copyOrMoveActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = copyOrMoveActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final CopyOrMoveActivity copyOrMoveActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<CopyOrMoveViewModel>, ViewModel>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<CopyOrMoveViewModel> factory) {
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList(ItemsListReducerKt.FOLDER_HIERARCHY, copyOrMoveActivity2.getIntent().getParcelableArrayListExtra("INITIAL_FOLDER_HIERARCHY"));
                        bundle.putParcelableArrayList(ItemsListReducerKt.ITEMS_TO_COPY, copyOrMoveActivity2.getIntent().getParcelableArrayListExtra("ITEMS_TO_COPY_KEY"));
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.vm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CopyOrMoveViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return copyOrMoveActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return copyOrMoveActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? copyOrMoveActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final CopyOrMoveViewModel getVm() {
        return (CopyOrMoveViewModel) this.vm.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        CopyOrMoveActivity copyOrMoveActivity = this;
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(copyOrMoveActivity);
        if (!getResources().getBoolean(R.bool.is7inchOrLarger)) {
            setRequestedOrientation(1);
        }
        ComponentActivityKt.setContent$default(copyOrMoveActivity, null, ComposableLambdaKt.composableLambdaInstance(-208769874, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CopyOrMoveActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final CopyOrMoveActivity copyOrMoveActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C45@1734L233,45@1725L242:CopyOrMoveActivity.kt#oxn7jq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-208769874, i, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveActivity.onCreate.<anonymous> (CopyOrMoveActivity.kt:45)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-872618045, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CopyOrMoveActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(CopyOrMoveActivity copyOrMoveActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C48@1838L8,46@1752L201:CopyOrMoveActivity.kt#oxn7jq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-872618045, i, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveActivity.onCreate.<anonymous>.<anonymous> (CopyOrMoveActivity.kt:46)");
            }
            Store<CopyOrMoveReducer.State, CopyOrMoveReducer.Action> store = copyOrMoveActivity.getVm().getStore();
            ComposerKt.sourceInformationMarkerStart(composer, -1067315189, "CC(remember):CopyOrMoveActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(copyOrMoveActivity);
            CopyOrMoveActivity$onCreate$1$1$1$1 copyOrMoveActivity$onCreate$1$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || copyOrMoveActivity$onCreate$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                copyOrMoveActivity$onCreate$1$1$1$1RememberedValue = new CopyOrMoveActivity$onCreate$1$1$1$1(copyOrMoveActivity);
                composer.updateRememberedValue(copyOrMoveActivity$onCreate$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CopyOrMoveScreenKt.CopyOrMoveScreen(store, (Function0) ((KFunction) copyOrMoveActivity$onCreate$1$1$1$1RememberedValue), copyOrMoveActivity.mFeatureFlips.getMainScreenRedesign().getEnabled(), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: CopyOrMoveActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveActivity$Companion;", "", "<init>", "()V", CopyOrMoveActivity.INITIAL_FOLDER_HIERARCHY, "", CopyOrMoveActivity.ITEMS_TO_COPY_KEY, "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", ComposeIdentificationData.HIERARCHY, "", "Lcom/box/android/domain/models/item/ItemModel;", "itemsToCopy", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getLaunchIntent(Context context, List<? extends ItemModel> hierarchy, List<? extends ItemModel> itemsToCopy) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(hierarchy, "hierarchy");
            Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
            Intent intent = new Intent(context, (Class<?>) CopyOrMoveActivity.class);
            intent.putParcelableArrayListExtra(CopyOrMoveActivity.INITIAL_FOLDER_HIERARCHY, new ArrayList<>(hierarchy));
            intent.putParcelableArrayListExtra(CopyOrMoveActivity.ITEMS_TO_COPY_KEY, new ArrayList<>(itemsToCopy));
            return intent;
        }
    }
}
