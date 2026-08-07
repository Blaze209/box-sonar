package com.box.android.fragments.boxitem;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.adapters.TaskCollaboratorsAdapter;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.vm.TaskCollaboratorsVM;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxTask;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class TaskCollaboratorsFragment extends Hilt_TaskCollaboratorsFragment {
    public static final String TASK_ID = "TaskCollaboratorsFragment.TaskId";
    private TaskCollaboratorsAdapter mAdapter;
    private String mCompletionRule;
    private TaskCollaboratorsVM mTaskCollabVM;
    private String mTaskId;

    @Inject
    IUserContextManager mUserContextManager;
    private LiveData<BoxResponse<BoxIteratorTaskCollaborators>> taskCollaborators;

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return null;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    public BoxItemDividerDecoration getItemDividerDecoration() {
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 0;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean shouldUpdateFragment(BoxMessage<?> boxMessage) {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFragment(BoxMessage<?> boxMessage) {
    }

    public static TaskCollaboratorsFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(TASK_ID, str);
        TaskCollaboratorsFragment taskCollaboratorsFragment = new TaskCollaboratorsFragment();
        taskCollaboratorsFragment.setArguments(bundle);
        return taskCollaboratorsFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTaskId = getArguments().getString(TASK_ID);
        this.mTaskCollabVM = (TaskCollaboratorsVM) new ViewModelProvider(this).get(TaskCollaboratorsVM.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        observeTaskCollaborators();
        handleCompletionRule();
        loadItems();
    }

    private LiveData<BoxResponse<BoxIteratorTaskCollaborators>> taskCollaboratorsLiveData() {
        if (this.taskCollaborators == null) {
            this.taskCollaborators = this.mTaskCollabVM.getTaskCollaborators(this.mTaskId);
        }
        return this.taskCollaborators;
    }

    private void observeTaskCollaborators() {
        taskCollaboratorsLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.boxitem.TaskCollaboratorsFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$observeTaskCollaborators$0((BoxResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observeTaskCollaborators$0(BoxResponse boxResponse) {
        if (boxResponse == null || boxResponse.getResult() == null) {
            return;
        }
        this.mAdapter.updateTaskCollaborators((BoxIteratorTaskCollaborators) boxResponse.getResult());
        updateItems();
        updateUI();
    }

    private void handleCompletionRule() {
        this.mTaskCollabVM.getTask(this.mTaskId).observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.boxitem.TaskCollaboratorsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$handleCompletionRule$1((BoxResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleCompletionRule$1(BoxResponse boxResponse) {
        String completionRule = ((BoxTask) boxResponse.getResult()).getCompletionRule();
        this.mCompletionRule = completionRule;
        if (completionRule != null && completionRule.equalsIgnoreCase(BoxTask.COMPLETION_RULE_ANY_ASSIGNEE)) {
            this.mAdapter.setShouldShowCompletionRule(true);
        } else {
            this.mAdapter.setShouldShowCompletionRule(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    public TaskCollaboratorsAdapter createAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new TaskCollaboratorsAdapter(this.mUserContextManager);
        }
        return this.mAdapter;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected void loadItems() {
        taskCollaboratorsLiveData();
        this.mTaskCollabVM.updateTaskCollaborators(this.mTaskId);
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected boolean isContentAvailable() {
        LiveData<BoxResponse<BoxIteratorTaskCollaborators>> liveData = this.taskCollaborators;
        return (liveData == null || liveData.getValue() == null) ? false : true;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return CommonBoxUtil.LS(R.string.assignees);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
        this.mTaskCollabVM.updateTaskCollaborators(this.mTaskId);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_TASK_COLLABORATORS;
    }
}
