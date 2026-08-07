package com.microsoft.intune.mam.client.app.offline;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.TextView;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.client.app.MAMApplication;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.app.ThemeManagerBehavior;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OfflineBlockedActivityBase extends Activity {
    protected abstract void showUI();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ((ThemeManagerBehavior) MAMComponents.get(ThemeManagerBehavior.class)).applyAppThemeOrDefault(this, R.style.MAMActivityBaseTheme);
        super.onCreate(bundle);
        if (!MAMComponents.isAppOffline()) {
            finish();
        } else {
            setupBackground();
        }
    }

    protected void setupBackground() {
        requestWindowFeature(1);
        setFinishOnTouchOutside(false);
        setContentView(R.layout.wg_offline_startup_blocked);
        try {
            setLogo(getPackageManager().getApplicationInfo(getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError();
        }
    }

    private void setLogo(ApplicationInfo applicationInfo) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{getDrawable(R.drawable.offline_startup_app_icon_container), new InsetDrawable(getDrawable(applicationInfo.icon), getResources().getDimensionPixelSize(R.dimen.offline_startup_app_icon_container_inset))});
        ThemeManagerBehavior themeManagerBehavior = (ThemeManagerBehavior) MAMComponents.get(ThemeManagerBehavior.class);
        TextView textView = (TextView) findViewById(R.id.offline_logo_textView);
        if (!themeManagerBehavior.hasAppTheme()) {
            textView.setTextColor(Color.parseColor("#363636"));
        }
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, layerDrawable, (Drawable) null, (Drawable) null);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        showUI();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (OfflineActivityBehavior.getRestartRequired()) {
            MAMApplication.endProcess();
        }
    }
}
