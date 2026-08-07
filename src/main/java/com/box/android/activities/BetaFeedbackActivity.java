package com.box.android.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.R;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.compose.betafeedback.BetaFeedbackScreenKt;
import com.box.android.usercontext.UserContextManager;
import com.box.android.utilities.BetaFeedbackEmailSender;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: BetaFeedbackActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\"H\u0014J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0016\u0010*\u001a\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020 0,H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lcom/box/android/activities/BetaFeedbackActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "userContextManager", "Lcom/box/android/usercontext/UserContextManager;", "getUserContextManager", "()Lcom/box/android/usercontext/UserContextManager;", "setUserContextManager", "(Lcom/box/android/usercontext/UserContextManager;)V", "betaFeedbackManager", "Lcom/box/android/base/presentation/shake/BetaFeedbackManager;", "getBetaFeedbackManager", "()Lcom/box/android/base/presentation/shake/BetaFeedbackManager;", "setBetaFeedbackManager", "(Lcom/box/android/base/presentation/shake/BetaFeedbackManager;)V", "betaFeedbackEmailSender", "Lcom/box/android/utilities/BetaFeedbackEmailSender;", "getBetaFeedbackEmailSender", "()Lcom/box/android/utilities/BetaFeedbackEmailSender;", "setBetaFeedbackEmailSender", "(Lcom/box/android/utilities/BetaFeedbackEmailSender;)V", "<set-?>", "Landroid/net/Uri;", "screenshotUri", "getScreenshotUri", "()Landroid/net/Uri;", "setScreenshotUri", "(Landroid/net/Uri;)V", "screenshotUri$delegate", "Landroidx/compose/runtime/MutableState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "sendFeedback", "feedbackText", "", "includeScreenshot", "", "showConfirmDialog", "onConfirm", "Lkotlin/Function0;", "finishAndNotify", "onDestroy", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class BetaFeedbackActivity extends Hilt_BetaFeedbackActivity {
    public static final String EXTRA_SCREENSHOT_URI = "extra_screenshot_uri";

    @Inject
    public BetaFeedbackEmailSender betaFeedbackEmailSender;

    @Inject
    public BetaFeedbackManager betaFeedbackManager;

    /* JADX INFO: renamed from: screenshotUri$delegate, reason: from kotlin metadata */
    private final MutableState screenshotUri = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    @Inject
    public UserContextManager userContextManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final UserContextManager getUserContextManager() {
        UserContextManager userContextManager = this.userContextManager;
        if (userContextManager != null) {
            return userContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(UserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "<set-?>");
        this.userContextManager = userContextManager;
    }

    public final BetaFeedbackManager getBetaFeedbackManager() {
        BetaFeedbackManager betaFeedbackManager = this.betaFeedbackManager;
        if (betaFeedbackManager != null) {
            return betaFeedbackManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("betaFeedbackManager");
        return null;
    }

    public final void setBetaFeedbackManager(BetaFeedbackManager betaFeedbackManager) {
        Intrinsics.checkNotNullParameter(betaFeedbackManager, "<set-?>");
        this.betaFeedbackManager = betaFeedbackManager;
    }

    public final BetaFeedbackEmailSender getBetaFeedbackEmailSender() {
        BetaFeedbackEmailSender betaFeedbackEmailSender = this.betaFeedbackEmailSender;
        if (betaFeedbackEmailSender != null) {
            return betaFeedbackEmailSender;
        }
        Intrinsics.throwUninitializedPropertyAccessException("betaFeedbackEmailSender");
        return null;
    }

    public final void setBetaFeedbackEmailSender(BetaFeedbackEmailSender betaFeedbackEmailSender) {
        Intrinsics.checkNotNullParameter(betaFeedbackEmailSender, "<set-?>");
        this.betaFeedbackEmailSender = betaFeedbackEmailSender;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Uri getScreenshotUri() {
        return (Uri) this.screenshotUri.getValue();
    }

    private final void setScreenshotUri(Uri uri) {
        this.screenshotUri.setValue(uri);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0046  */
    @Override // com.box.android.activities.Hilt_BetaFeedbackActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        Intent intent;
        Parcelable parcelableExtra;
        Parcelable parcelable;
        Uri uri;
        Parcelable parcelable2;
        super.onMAMCreate(bundle);
        if (bundle == null) {
            intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) intent.getParcelableExtra(EXTRA_SCREENSHOT_URI, Uri.class);
            } else {
                parcelableExtra = intent.getParcelableExtra(EXTRA_SCREENSHOT_URI);
                if (!(parcelableExtra instanceof Uri)) {
                    parcelableExtra = null;
                }
                parcelable = (Uri) parcelableExtra;
            }
            uri = (Uri) parcelable;
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable2 = (Parcelable) bundle.getParcelable(EXTRA_SCREENSHOT_URI, Uri.class);
            } else {
                Parcelable parcelable3 = bundle.getParcelable(EXTRA_SCREENSHOT_URI);
                if (!(parcelable3 instanceof Uri)) {
                    parcelable3 = null;
                }
                parcelable2 = (Uri) parcelable3;
            }
            uri = (Uri) parcelable2;
            if (uri == null) {
                intent = getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) intent.getParcelableExtra(EXTRA_SCREENSHOT_URI, Uri.class);
                } else {
                    parcelableExtra = intent.getParcelableExtra(EXTRA_SCREENSHOT_URI);
                    if (!(parcelableExtra instanceof Uri)) {
                        parcelableExtra = null;
                    }
                    parcelable = (Uri) parcelableExtra;
                }
                uri = (Uri) parcelable;
            }
        }
        setScreenshotUri(uri);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-2075021882, true, new Function2() { // from class: com.box.android.activities.BetaFeedbackActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BetaFeedbackActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final BetaFeedbackActivity betaFeedbackActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@1824L475,51@1815L484:BetaFeedbackActivity.kt#tyuvh8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2075021882, i, -1, "com.box.android.activities.BetaFeedbackActivity.onCreate.<anonymous> (BetaFeedbackActivity.kt:51)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1882053009, true, new Function2() { // from class: com.box.android.activities.BetaFeedbackActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final BetaFeedbackActivity betaFeedbackActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C54@1950L128,57@2111L17,58@2178L89,52@1842L443:BetaFeedbackActivity.kt#tyuvh8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1882053009, i, -1, "com.box.android.activities.BetaFeedbackActivity.onCreate.<anonymous>.<anonymous> (BetaFeedbackActivity.kt:52)");
            }
            Uri screenshotUri = betaFeedbackActivity.getScreenshotUri();
            ComposerKt.sourceInformationMarkerStart(composer, 471714193, "CC(remember):BetaFeedbackActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(betaFeedbackActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.box.android.activities.BetaFeedbackActivity$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BetaFeedbackActivity.onCreate$lambda$0$0$0$0(this.f$0, (String) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 471719234, "CC(remember):BetaFeedbackActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(betaFeedbackActivity);
            BetaFeedbackActivity$onCreate$1$1$2$1 betaFeedbackActivity$onCreate$1$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || betaFeedbackActivity$onCreate$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                betaFeedbackActivity$onCreate$1$1$2$1RememberedValue = new BetaFeedbackActivity$onCreate$1$1$2$1(betaFeedbackActivity);
                composer.updateRememberedValue(betaFeedbackActivity$onCreate$1$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function0 = (Function0) ((KFunction) betaFeedbackActivity$onCreate$1$1$2$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 471721450, "CC(remember):BetaFeedbackActivity.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(betaFeedbackActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.activities.BetaFeedbackActivity$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BetaFeedbackActivity.onCreate$lambda$0$0$2$0(this.f$0, (Function0) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BetaFeedbackScreenKt.BetaFeedbackScreen(screenshotUri, function2, function0, (Function1) objRememberedValue2, null, composer, 0, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$0(BetaFeedbackActivity betaFeedbackActivity, String feedbackText, boolean z) {
        Intrinsics.checkNotNullParameter(feedbackText, "feedbackText");
        betaFeedbackActivity.sendFeedback(feedbackText, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$2$0(BetaFeedbackActivity betaFeedbackActivity, Function0 onConfirm) {
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        betaFeedbackActivity.showConfirmDialog(onConfirm);
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onMAMSaveInstanceState(outState);
        Uri screenshotUri = getScreenshotUri();
        if (screenshotUri != null) {
            outState.putParcelable(EXTRA_SCREENSHOT_URI, screenshotUri);
        }
    }

    private final void sendFeedback(String feedbackText, boolean includeScreenshot) {
        Uri screenshotUri;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (includeScreenshot && (screenshotUri = getScreenshotUri()) != null) {
            listCreateListBuilder.add(screenshotUri);
        }
        List<? extends Uri> listBuild = CollectionsKt.build(listCreateListBuilder);
        BetaFeedbackEmailSender betaFeedbackEmailSender = getBetaFeedbackEmailSender();
        String currentContextId = getUserContextManager().getCurrentContextId();
        Intrinsics.checkNotNullExpressionValue(currentContextId, "getCurrentContextId(...)");
        betaFeedbackEmailSender.send(currentContextId, feedbackText, listBuild);
        finishAndNotify();
    }

    private final void showConfirmDialog(final Function0<Unit> onConfirm) {
        new MaterialAlertDialogBuilder(this).setCancelable(false).setMessage(R.string.beta_feedback_discard_confirm).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.BetaFeedbackActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                onConfirm.invoke();
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.BetaFeedbackActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAndNotify() {
        getBetaFeedbackManager().onDialogDismissed();
        finish();
    }

    @Override // com.box.android.activities.Hilt_BetaFeedbackActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        getBetaFeedbackManager().onDialogDismissed();
    }

    /* JADX INFO: compiled from: BetaFeedbackActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/activities/BetaFeedbackActivity$Companion;", "", "<init>", "()V", "EXTRA_SCREENSHOT_URI", "", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "screenshotUri", "Landroid/net/Uri;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getLaunchIntent$default(Companion companion, Context context, Uri uri, int i, Object obj) {
            if ((i & 2) != 0) {
                uri = null;
            }
            return companion.getLaunchIntent(context, uri);
        }

        public final Intent getLaunchIntent(Context context, Uri screenshotUri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) BetaFeedbackActivity.class);
            if (screenshotUri != null) {
                intent.putExtra(BetaFeedbackActivity.EXTRA_SCREENSHOT_URI, screenshotUri);
            }
            return intent;
        }
    }
}
