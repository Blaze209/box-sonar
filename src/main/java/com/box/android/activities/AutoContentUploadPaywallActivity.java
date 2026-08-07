package com.box.android.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.views.OKCancelView;

/* JADX INFO: loaded from: classes9.dex */
public class AutoContentUploadPaywallActivity extends Hilt_AutoContentUploadPaywallActivity {
    private static final String PRICING_PAGE_URL = "https://www.box.com/pricing/";

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_auto_content_upload_paywall);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        initializeButtons();
    }

    private void initializeButtons() {
        ((OKCancelView) findViewById(R.id.okCancelView)).setOnClickListener(new OKCancelView.OKCancelClickListener() { // from class: com.box.android.activities.AutoContentUploadPaywallActivity.1
            @Override // com.box.android.base.presentation.views.OKCancelView.OKCancelClickListener
            public void onOKClicked() {
                AutoContentUploadPaywallActivity.this.openPricingPage();
            }

            @Override // com.box.android.base.presentation.views.OKCancelView.OKCancelClickListener
            public void onCancelClicked() {
                AutoContentUploadPaywallActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPricingPage() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(PRICING_PAGE_URL));
        startActivity(intent);
    }
}
