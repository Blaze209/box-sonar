package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.utilities.BoxCollectionUtils;
import com.box.androidsdk.content.models.BoxUser;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class SwitchAccountActivity extends Hilt_SwitchAccountActivity {
    public static final int MULTI_USER_NOT_SUPPORTED = 100;

    public interface AccountSwitchable {
        void softSwitchTo(String str);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (!BoxBaseApplication.getInstance().getConfigManager().getBoolean(BoxConfigConstants.CONFIG_KEY_ACCOUNT_SWITCHING_ENABLED_BOOL).booleanValue()) {
            setResult(0);
            finish();
        } else if (BoxAccountManager.isIntuneMAMEnabled(this.mUserContextManager.getUserSharedPrefs())) {
            setResult(100);
            finish();
        } else {
            setContentView(R.layout.layout_switch_user);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxInitialize(Bundle bundle) {
        super.onBoxInitialize(bundle);
        if (getUserInfo() == null) {
            return;
        }
        setupView();
    }

    private static class BoxSwitchUser extends BoxUser {
        private BoxSwitchUser() {
        }
    }

    private void setupView() {
        if (!BoxBaseApplication.getInstance().getConfigManager().getBoolean(BoxConfigConstants.CONFIG_KEY_ACCOUNT_SWITCHING_ENABLED_BOOL).booleanValue() || BoxAccountManager.isIntuneMAMEnabled(this.mUserContextManager.getUserSharedPrefs())) {
            return;
        }
        List<BoxUser> usersExcludingInvalid = BoxCollectionUtils.getUsersExcludingInvalid(this.mGlobalSettings);
        usersExcludingInvalid.add(new BoxSwitchUser());
        AccountSwitchAdapter accountSwitchAdapter = new AccountSwitchAdapter(this, usersExcludingInvalid);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter((ListAdapter) accountSwitchAdapter);
        listView.setOnItemClickListener(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.box.android.activities.SwitchAccountActivity$1, reason: invalid class name */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SwitchAccountActivity.softSwitchWithOptionalWarning(((BoxUser) adapterView.getAdapter().getItem(i)).getUserId(), SwitchAccountActivity.this, new AccountSwitchable() { // from class: com.box.android.activities.SwitchAccountActivity.1.1
                /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.activities.SwitchAccountActivity$1$1$1] */
                @Override // com.box.android.activities.SwitchAccountActivity.AccountSwitchable
                public void softSwitchTo(final String str) {
                    new Thread() { // from class: com.box.android.activities.SwitchAccountActivity.1.1.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            SwitchAccountActivity.this.showSpinner(CommonBoxUtil.LS(R.string.Please_wait_clearing_user_information));
                            SwitchAccountActivity.this.mUserContextManager.softSwitch(str);
                            SwitchAccountActivity.this.broadcastDismissSpinner();
                            SwitchAccountActivity.this.setResult(-1);
                            SwitchAccountActivity.this.finish();
                        }
                    }.start();
                }
            });
        }
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, (Class<?>) SwitchAccountActivity.class);
    }

    public static void softSwitchWithOptionalWarning(String str, Context context, AccountSwitchable accountSwitchable) {
        accountSwitchable.softSwitchTo(str);
    }

    public class AccountSwitchAdapter extends ArrayAdapter<BoxUser> {
        public AccountSwitchAdapter(Context context, List<BoxUser> list) {
            super(context, 0, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SwitchAccountActivity.this.getLayoutInflater().inflate(R.layout.stored_user_item, viewGroup, false);
            }
            BoxUser item = getItem(i);
            ((TextView) view.findViewById(R.id.userName)).setText(item instanceof BoxSwitchUser ? getContext().getString(R.string.Login_as_a_new_user) : item.getLogin());
            return view;
        }
    }
}
