package com.box.android.activities.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.fragments.boxitem.SingleTaskFragment;
import com.box.android.fragments.boxitem.TaskCollaboratorsFragment;

/* JADX INFO: loaded from: classes9.dex */
public class SingleTaskActivity extends Hilt_SingleTaskActivity {
    public static final String EXTRA_IS_MY_TASK = "extraIsMyTask";
    public static final String QUERY_PARAM_ROLE = "role";
    public static final String QUERY_PARAM_TASK_ID = "task_id";
    public static final String VIEW_SOURCE = "viewSource";

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.activity_task_collaborators);
    }

    public static Intent createIntent(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SingleTaskActivity.class);
        intent.putExtra(TaskCollaboratorsFragment.TASK_ID, str);
        intent.putExtra(EXTRA_IS_MY_TASK, z);
        intent.putExtra(VIEW_SOURCE, str2);
        return intent;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        Intent intent = getIntent();
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        SingleTaskFragment singleTaskFragmentNewInstance = fragmentFindFragmentById instanceof SingleTaskFragment ? (SingleTaskFragment) fragmentFindFragmentById : null;
        if (singleTaskFragmentNewInstance == null) {
            if (intent.hasExtra(TaskCollaboratorsFragment.TASK_ID)) {
                FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.setTransition(0);
                singleTaskFragmentNewInstance = SingleTaskFragment.newInstance(intent.getStringExtra(TaskCollaboratorsFragment.TASK_ID), intent.getStringExtra(VIEW_SOURCE), intent.getBooleanExtra(EXTRA_IS_MY_TASK, true));
                fragmentTransactionBeginTransaction.replace(R.id.fragment_container, singleTaskFragmentNewInstance);
                fragmentTransactionBeginTransaction.commit();
            } else {
                finish();
                return;
            }
        }
        initToolbar(singleTaskFragmentNewInstance.getTitle(this));
    }

    private void initToolbar(String str) {
        final IntentServices.NavigationIntentTarget navigationIntentTarget;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(CommonBoxUtil.getDrawable(this, R.drawable.ic_toolbar_back_btn));
        toolbar.setTitle(str);
        setSupportActionBar(toolbar);
        if (getIntent().getBooleanExtra(EXTRA_IS_MY_TASK, true)) {
            navigationIntentTarget = IntentServices.NavigationIntentTarget.MY_TASKS;
        } else {
            navigationIntentTarget = IntentServices.NavigationIntentTarget.SENT_TASKS;
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.tasks.SingleTaskActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initToolbar$0(navigationIntentTarget, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initToolbar$0(IntentServices.NavigationIntentTarget navigationIntentTarget, View view) {
        startActivity(this.mIntentServices.navigationActivityIntent(this, this.mFeatureFlips.getMainScreenRedesign().getEnabled(), navigationIntentTarget));
        finish();
    }
}
