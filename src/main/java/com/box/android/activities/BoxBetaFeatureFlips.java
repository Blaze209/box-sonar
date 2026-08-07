package com.box.android.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.domain.configuration.FeatureFlip;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxBetaFeatureFlips.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0002\u0010\u001cR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/box/android/activities/BoxBetaFeatureFlips;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "deepLinkHandler", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler;", "getDeepLinkHandler", "()Lcom/box/android/activities/FeatureFlipDeepLinkHandler;", "setDeepLinkHandler", "(Lcom/box/android/activities/FeatureFlipDeepLinkHandler;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleIntent", "intent", "Landroid/content/Intent;", "showToggleConfirmation", "featureFlip", "Lcom/box/android/domain/configuration/FeatureFlip;", "enabled", "", "showToast", "message", "", "handleOnNewIntent", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class BoxBetaFeatureFlips extends Hilt_BoxBetaFeatureFlips {
    public static final int $stable = 8;

    @Inject
    public FeatureFlipDeepLinkHandler deepLinkHandler;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public final FeatureFlipDeepLinkHandler getDeepLinkHandler() {
        FeatureFlipDeepLinkHandler featureFlipDeepLinkHandler = this.deepLinkHandler;
        if (featureFlipDeepLinkHandler != null) {
            return featureFlipDeepLinkHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkHandler");
        return null;
    }

    public final void setDeepLinkHandler(FeatureFlipDeepLinkHandler featureFlipDeepLinkHandler) {
        Intrinsics.checkNotNullParameter(featureFlipDeepLinkHandler, "<set-?>");
        this.deepLinkHandler = featureFlipDeepLinkHandler;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        handleIntent(getIntent());
    }

    private final void handleIntent(Intent intent) {
        FeatureFlipDeepLinkHandler.Result resultValidate$default = FeatureFlipDeepLinkHandler.validate$default(getDeepLinkHandler(), intent != null ? intent.getData() : null, false, false, 6, null);
        if (resultValidate$default instanceof FeatureFlipDeepLinkHandler.Result.Rejected) {
            finish();
            return;
        }
        if (resultValidate$default instanceof FeatureFlipDeepLinkHandler.Result.UnsupportedBuild) {
            String string = getString(R.string.feature_flip_unsupported_build);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showToast(string);
            finish();
            return;
        }
        if (resultValidate$default instanceof FeatureFlipDeepLinkHandler.Result.InvalidUrl) {
            String string2 = getString(R.string.feature_flip_invalid_url);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            showToast(string2);
            finish();
            return;
        }
        if (resultValidate$default instanceof FeatureFlipDeepLinkHandler.Result.Valid) {
            FeatureFlipDeepLinkHandler.Result.Valid valid = (FeatureFlipDeepLinkHandler.Result.Valid) resultValidate$default;
            showToggleConfirmation(valid.getFeatureFlip(), valid.getEnabled());
        } else {
            if (!(resultValidate$default instanceof FeatureFlipDeepLinkHandler.Result.LaunchActivity)) {
                throw new NoWhenBranchMatchedException();
            }
            startActivity(new Intent(this, ((FeatureFlipDeepLinkHandler.Result.LaunchActivity) resultValidate$default).getActivityClass()));
            finish();
        }
    }

    private final void showToggleConfirmation(final FeatureFlip featureFlip, final boolean enabled) {
        String string = getString(enabled ? R.string.feature_flip_action_enable : R.string.feature_flip_action_disable);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.feature_flip_toggle_confirmation, new Object[]{string, featureFlip.getName()});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        new MaterialAlertDialogBuilder(this).setTitle(R.string.feature_flip_toggle_title).setMessage((CharSequence) string2).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.BoxBetaFeatureFlips$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.finish();
            }
        }).setPositiveButton(R.string.LO_continue, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.BoxBetaFeatureFlips$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BoxBetaFeatureFlips.showToggleConfirmation$lambda$1(this.f$0, featureFlip, enabled, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.box.android.activities.BoxBetaFeatureFlips$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.finish();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToggleConfirmation$lambda$1(BoxBetaFeatureFlips boxBetaFeatureFlips, FeatureFlip featureFlip, boolean z, DialogInterface dialogInterface, int i) {
        boxBetaFeatureFlips.getDeepLinkHandler().toggle(featureFlip, z);
        String string = boxBetaFeatureFlips.getString(z ? R.string.feature_flip_is_enabled : R.string.feature_flip_is_disabled, new Object[]{featureFlip.getName()});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        boxBetaFeatureFlips.showToast(string);
        boxBetaFeatureFlips.finish();
    }

    private final void showToast(String message) {
        BoxPresentationUtils.displayToast(message, this);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);
        handleIntent(intent);
    }
}
