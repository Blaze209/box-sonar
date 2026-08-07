package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.fragments.EmailSupportFragment;

/* JADX INFO: loaded from: classes9.dex */
public class EmailSupportActivity extends Hilt_EmailSupportActivity {
    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        EmailSupportFragment emailSupportFragment = new EmailSupportFragment();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransactionBeginTransaction.replace(R.id.emailSupportFragmentContainer, emailSupportFragment, EmailSupportFragment.TAG).commit();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.activity_email_support);
    }

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, (Class<?>) EmailSupportActivity.class);
    }
}
