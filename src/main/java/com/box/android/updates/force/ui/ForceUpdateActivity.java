package com.box.android.updates.force.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.updates.force.ForceUpdateActionHandler;
import com.box.android.updates.force.ForceUpdateDialogConfig;
import com.box.android.updates.force.ForceUpdateDialogConfigProvider;
import com.box.android.updates.force.analytics.ForceUpdateAnalytics;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForceUpdateActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/box/android/updates/force/ui/ForceUpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "forceUpdateActionHandler", "Lcom/box/android/updates/force/ForceUpdateActionHandler;", "getForceUpdateActionHandler", "()Lcom/box/android/updates/force/ForceUpdateActionHandler;", "setForceUpdateActionHandler", "(Lcom/box/android/updates/force/ForceUpdateActionHandler;)V", "dialogConfigProvider", "Lcom/box/android/updates/force/ForceUpdateDialogConfigProvider;", "getDialogConfigProvider", "()Lcom/box/android/updates/force/ForceUpdateDialogConfigProvider;", "setDialogConfigProvider", "(Lcom/box/android/updates/force/ForceUpdateDialogConfigProvider;)V", "analytics", "Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;", "getAnalytics", "()Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;", "setAnalytics", "(Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class ForceUpdateActivity extends Hilt_ForceUpdateActivity {

    @Inject
    public ForceUpdateAnalytics analytics;

    @Inject
    public ForceUpdateDialogConfigProvider dialogConfigProvider;

    @Inject
    public ForceUpdateActionHandler forceUpdateActionHandler;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final ForceUpdateActionHandler getForceUpdateActionHandler() {
        ForceUpdateActionHandler forceUpdateActionHandler = this.forceUpdateActionHandler;
        if (forceUpdateActionHandler != null) {
            return forceUpdateActionHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("forceUpdateActionHandler");
        return null;
    }

    public final void setForceUpdateActionHandler(ForceUpdateActionHandler forceUpdateActionHandler) {
        Intrinsics.checkNotNullParameter(forceUpdateActionHandler, "<set-?>");
        this.forceUpdateActionHandler = forceUpdateActionHandler;
    }

    public final ForceUpdateDialogConfigProvider getDialogConfigProvider() {
        ForceUpdateDialogConfigProvider forceUpdateDialogConfigProvider = this.dialogConfigProvider;
        if (forceUpdateDialogConfigProvider != null) {
            return forceUpdateDialogConfigProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogConfigProvider");
        return null;
    }

    public final void setDialogConfigProvider(ForceUpdateDialogConfigProvider forceUpdateDialogConfigProvider) {
        Intrinsics.checkNotNullParameter(forceUpdateDialogConfigProvider, "<set-?>");
        this.dialogConfigProvider = forceUpdateDialogConfigProvider;
    }

    public final ForceUpdateAnalytics getAnalytics() {
        ForceUpdateAnalytics forceUpdateAnalytics = this.analytics;
        if (forceUpdateAnalytics != null) {
            return forceUpdateAnalytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final void setAnalytics(ForceUpdateAnalytics forceUpdateAnalytics) {
        Intrinsics.checkNotNullParameter(forceUpdateAnalytics, "<set-?>");
        this.analytics = forceUpdateAnalytics;
    }

    @Override // com.box.android.updates.force.ui.Hilt_ForceUpdateActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        final ForceUpdateDialogConfig dialogConfig = getDialogConfigProvider().getDialogConfig();
        getAnalytics().logDialogShown(dialogConfig);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1961743926, true, new Function2() { // from class: com.box.android.updates.force.ui.ForceUpdateActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ForceUpdateActivity.onCreate$lambda$0(this.f$0, dialogConfig, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final ForceUpdateActivity forceUpdateActivity, final ForceUpdateDialogConfig forceUpdateDialogConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C37@1378L721,37@1369L730:ForceUpdateActivity.kt#tvgx56");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1961743926, i, -1, "com.box.android.updates.force.ui.ForceUpdateActivity.onCreate.<anonymous> (ForceUpdateActivity.kt:37)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-1844611051, true, new Function2() { // from class: com.box.android.updates.force.ui.ForceUpdateActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForceUpdateActivity.onCreate$lambda$0$0(this.f$0, forceUpdateDialogConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final ForceUpdateActivity forceUpdateActivity, ForceUpdateDialogConfig forceUpdateDialogConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C38@1454L6,38@1396L689:ForceUpdateActivity.kt#tvgx56");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1844611051, i, -1, "com.box.android.updates.force.ui.ForceUpdateActivity.onCreate.<anonymous>.<anonymous> (ForceUpdateActivity.kt:38)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11575getTopBarBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1838735027, "C40@1556L118,43@1719L131,46@1889L115,39@1502L565:ForceUpdateActivity.kt#tvgx56");
            ComposerKt.sourceInformationMarkerStart(composer, -1049063343, "CC(remember):ForceUpdateActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(forceUpdateActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.updates.force.ui.ForceUpdateActivity$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ForceUpdateActivity.onCreate$lambda$0$0$0$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1049058114, "CC(remember):ForceUpdateActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(forceUpdateActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.updates.force.ui.ForceUpdateActivity$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ForceUpdateActivity.onCreate$lambda$0$0$0$1$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1049052690, "CC(remember):ForceUpdateActivity.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(forceUpdateActivity);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.updates.force.ui.ForceUpdateActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ForceUpdateActivity.onCreate$lambda$0$0$0$2$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ForceUpdateDialogKt.ForceUpdateDialog(function0, function1, (Function0) objRememberedValue3, forceUpdateDialogConfig, null, composer, 0, 16);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$0$0(ForceUpdateActivity forceUpdateActivity) {
        forceUpdateActivity.getForceUpdateActionHandler().startUpdate$app_updates_generalProdRelease(forceUpdateActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$1$0(ForceUpdateActivity forceUpdateActivity) {
        forceUpdateActivity.getForceUpdateActionHandler().openGooglePlayFromDialog$app_updates_generalProdRelease(forceUpdateActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$2$0(ForceUpdateActivity forceUpdateActivity) {
        forceUpdateActivity.getForceUpdateActionHandler().closeApp$app_updates_generalProdRelease(forceUpdateActivity);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        getForceUpdateActionHandler().resumeIfUpdateInProgress$app_updates_generalProdRelease(this);
    }

    /* JADX INFO: compiled from: ForceUpdateActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/updates/force/ui/ForceUpdateActivity$Companion;", "", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) ForceUpdateActivity.class);
        }
    }
}
