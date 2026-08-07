package com.microsoft.identity.common.internal.providers.oauth2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.R;
import com.pspdfkit.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SilentAuthorizationActivity.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/SilentAuthorizationActivity;", "Lcom/microsoft/identity/common/internal/providers/oauth2/AuthorizationActivity;", "()V", "getThemeResId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setEdgeToEdge", "setFragment", BuildConfig.FLAVOR, "Landroidx/fragment/app/Fragment;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SilentAuthorizationActivity extends AuthorizationActivity {
    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivity, com.microsoft.identity.common.internal.ui.DualScreenActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        setEdgeToEdge();
    }

    @Override // com.microsoft.identity.common.internal.ui.DualScreenActivity
    public void setFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        frameLayout.setVisibility(8);
        setContentView(frameLayout);
        getSupportFragmentManager().beginTransaction().replace(frameLayout.getId(), fragment).commitNow();
    }

    @Override // com.microsoft.identity.common.internal.ui.DualScreenActivity
    protected int getThemeResId() {
        return R.style.TransparentActivityTheme;
    }

    @Override // com.microsoft.identity.common.internal.ui.DualScreenActivity
    protected void setEdgeToEdge() {
        EdgeToEdge.enable$default(this, null, null, 3, null);
        getWindow().setNavigationBarContrastEnforced(false);
    }
}
