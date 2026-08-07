package com.box.android.activities.urlsinterceptor;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.activities.SwitchAccountActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.utilities.BoxUtils;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class SharedLinkStopScreenActivity extends Hilt_SharedLinkStopScreenActivity {
    private Uri url;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresAuthToken() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int i, int i2, Intent intent) {
        if (298 != i) {
            super.handleOnActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            retrySharedLink();
        } else if (i2 == 100) {
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.intune_not_supported_multi_user);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_shared_link_stopscreen);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        this.url = Uri.parse((String) StringUtils.defaultIfEmpty(getIntent().getStringExtra(SharedLinkInterceptorActivity.EXTRA_PARAM_SHARED_URI), ""));
        initUI();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        MAMPackageManagement.setComponentEnabledSetting(getPackageManager(), new ComponentName(BoxBaseApplication.getInstance(), (Class<?>) SharedLinkInterceptorActivity.class), 1, 1);
    }

    public static Intent newSharedLinkStopScreenActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SharedLinkStopScreenActivity.class);
        intent.putExtra(SharedLinkInterceptorActivity.EXTRA_PARAM_SHARED_URI, str);
        return intent;
    }

    private void initUI() {
        ((TextView) findViewById(R.id.stop_screen_redirect)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkStopScreenActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedLinkStopScreenActivity.this.redirect();
            }
        });
        TextView textView = (TextView) findViewById(R.id.stop_screen_try_different_account);
        if (!BoxBaseApplication.getInstance().getConfigManager().getBoolean(BoxConfigConstants.CONFIG_KEY_ACCOUNT_SWITCHING_ENABLED_BOOL).booleanValue()) {
            textView.setVisibility(8);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkStopScreenActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedLinkStopScreenActivity sharedLinkStopScreenActivity = SharedLinkStopScreenActivity.this;
                sharedLinkStopScreenActivity.startActivityForResult(SwitchAccountActivity.newIntent(sharedLinkStopScreenActivity), BoxCommonConstants.REQUEST_RETRY_SHARED_LINK);
            }
        });
    }

    private void retrySharedLink() {
        Intent intent = new Intent(this, (Class<?>) SharedLinkInterceptorActivity.class);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(SharedLinkInterceptorActivity.BOX_SHARED_SCHEME);
        builder.appendQueryParameter("url", this.url.toString());
        intent.setData(builder.build());
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redirect() {
        BoxUtils.launchSafeExternalLink(this, this.url);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
