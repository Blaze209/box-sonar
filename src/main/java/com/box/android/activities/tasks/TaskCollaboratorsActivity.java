package com.box.android.activities.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.fragments.boxitem.TaskCollaboratorsFragment;

/* JADX INFO: loaded from: classes9.dex */
public class TaskCollaboratorsActivity extends Hilt_TaskCollaboratorsActivity {
    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.activity_task_collaborators);
    }

    public static Intent createIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) TaskCollaboratorsActivity.class);
        intent.putExtra(TaskCollaboratorsFragment.TASK_ID, str);
        return intent;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        Intent intent = getIntent();
        TaskCollaboratorsFragment taskCollaboratorsFragment = (TaskCollaboratorsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (intent.hasExtra(TaskCollaboratorsFragment.TASK_ID) && taskCollaboratorsFragment == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.setTransition(0);
            TaskCollaboratorsFragment taskCollaboratorsFragmentNewInstance = TaskCollaboratorsFragment.newInstance(intent.getStringExtra(TaskCollaboratorsFragment.TASK_ID));
            fragmentTransactionBeginTransaction.add(R.id.fragment_container, taskCollaboratorsFragmentNewInstance);
            fragmentTransactionBeginTransaction.commit();
            taskCollaboratorsFragment = taskCollaboratorsFragmentNewInstance;
        }
        initToolbar(taskCollaboratorsFragment.getTitle(this));
    }

    private void initToolbar(String str) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_left);
        toolbar.setTitle(str);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.tasks.TaskCollaboratorsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initToolbar$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initToolbar$0(View view) {
        finish();
    }
}
