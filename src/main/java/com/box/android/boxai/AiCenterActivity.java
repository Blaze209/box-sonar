package com.box.android.boxai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.models.item.ItemModel;
import com.box.brownfieldApi.featuresNavigator.AiCenterInitialContext;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import com.swmansion.rnscreens.fragment.restoration.RNScreensFragmentFactory;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiCenterActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/box/android/boxai/AiCenterActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "getPreviewLauncher", "()Lcom/box/android/base/cpl/IPreviewLauncher;", "setPreviewLauncher", "(Lcom/box/android/base/cpl/IPreviewLauncher;)V", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class AiCenterActivity extends Hilt_AiCenterActivity {
    public static final String RESULT_SESSION_ID = "RESULT_SESSION_ID";

    @Inject
    public IntentServices intentServices;

    @Inject
    public IPreviewLauncher previewLauncher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public final IntentServices getIntentServices() {
        IntentServices intentServices = this.intentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intentServices");
        return null;
    }

    public final void setIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.intentServices = intentServices;
    }

    public final IPreviewLauncher getPreviewLauncher() {
        IPreviewLauncher iPreviewLauncher = this.previewLauncher;
        if (iPreviewLauncher != null) {
            return iPreviewLauncher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("previewLauncher");
        return null;
    }

    public final void setPreviewLauncher(IPreviewLauncher iPreviewLauncher) {
        Intrinsics.checkNotNullParameter(iPreviewLauncher, "<set-?>");
        this.previewLauncher = iPreviewLauncher;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        AiCenterActivity aiCenterActivity = this;
        EdgeToEdgeUtils.INSTANCE.enableTransparentEdgeToEdge(aiCenterActivity);
        getSupportFragmentManager().setFragmentFactory(new RNScreensFragmentFactory());
        super.onMAMCreate(bundle);
        ComponentActivityKt.setContent$default(aiCenterActivity, null, ComposableLambdaKt.composableLambdaInstance(-1432935444, true, new Function2() { // from class: com.box.android.boxai.AiCenterActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AiCenterActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final AiCenterActivity aiCenterActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C73@3285L216,73@3276L225:AiCenterActivity.kt#6z2y90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1432935444, i, -1, "com.box.android.boxai.AiCenterActivity.onCreate.<anonymous> (AiCenterActivity.kt:73)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1149807169, true, new Function2() { // from class: com.box.android.boxai.AiCenterActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AiCenterActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(AiCenterActivity aiCenterActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C74@3303L184:AiCenterActivity.kt#6z2y90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1149807169, i, -1, "com.box.android.boxai.AiCenterActivity.onCreate.<anonymous>.<anonymous> (AiCenterActivity.kt:74)");
            }
            Intent intent = aiCenterActivity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            AiCenterActivityKt.AiCenterContent(intent, aiCenterActivity.getIntentServices(), aiCenterActivity.getPreviewLauncher(), null, null, composer, 0, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AiCenterActivity.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/AiCenterActivity$Companion;", "", "<init>", "()V", AiCenterActivity.RESULT_SESSION_ID, "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "hostSurface", "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "sessionId", "itemModels", "", "Lcom/box/android/domain/models/item/ItemModel;", "sharedLinkContext", AiCenterInitialContext.INITIAL_PROMPT_KEY, "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, HostSurface hostSurface, String str, List list, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            if ((i & 8) != 0) {
                list = CollectionsKt.emptyList();
            }
            if ((i & 16) != 0) {
                str2 = null;
            }
            if ((i & 32) != 0) {
                str3 = null;
            }
            return companion.createIntent(context, hostSurface, str, list, str2, str3);
        }

        public final Intent createIntent(Context context, HostSurface hostSurface, String sessionId, List<? extends ItemModel> itemModels, String sharedLinkContext, String initialPrompt) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(hostSurface, "hostSurface");
            Intrinsics.checkNotNullParameter(itemModels, "itemModels");
            Intent intent = new Intent(context, (Class<?>) AiCenterActivity.class);
            intent.putExtra("EXTRA_HOST_SURFACE", hostSurface.name());
            intent.putExtra("EXTRA_SESSION_ID", sessionId);
            intent.putParcelableArrayListExtra("EXTRA_ITEM_MODELS", new ArrayList<>(itemModels));
            intent.putExtra("EXTRA_SHARED_LINK", sharedLinkContext);
            intent.putExtra("EXTRA_INITIAL_PROMPT", initialPrompt);
            return intent;
        }
    }
}
