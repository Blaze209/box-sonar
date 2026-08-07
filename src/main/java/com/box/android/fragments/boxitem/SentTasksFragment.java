package com.box.android.fragments.boxitem;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.adapters.TasksAdapter;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.tasksrepo.TasksRepo;
import com.box.android.vm.SentTasksVM;
import com.box.android.vm.TasksVMFactory;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTask;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class SentTasksFragment extends Hilt_SentTasksFragment {
    private TasksAdapter mAdapter;
    private SentTasksVM mSentTasksVM;

    @Inject
    TasksVMFactory mTasksVMFactory;

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 23;
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.fragments.BaseListingFragment
    protected void loadItems() {
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public boolean shouldUpdateFragment(BoxMessage<?> boxMessage) {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        resetPrevTasksSize();
        this.mAdapter = createAdapter();
        this.mSentTasksVM = (SentTasksVM) new ViewModelProvider(this, this.mTasksVMFactory).get(SentTasksVM.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mSentTasksVM.getSentTasksData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.boxitem.SentTasksFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onActivityCreated$0((TasksRepo.TasksData) obj);
            }
        });
        this.mSentTasksVM.loadItems(false);
        this.mSentTasksVM.loadItems(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$0(TasksRepo.TasksData tasksData) {
        if (tasksData != null && tasksData.getResponse().getResult() != null) {
            this.mAdapter.updateTasksData(tasksData);
            updateItems();
            updateUI();
            logTasksViewed(tasksData.getTasks().getEntries().size());
        }
        if (tasksData != null) {
            processBoxResponse(tasksData.getResponse());
        }
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (viewOnCreateView != null) {
            ((TextView) viewOnCreateView.findViewById(R.id.empty_folder_text)).setText(getResources().getString(R.string.empty_sent_tasks_text));
        }
        return viewOnCreateView;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return CommonBoxUtil.LS(R.string.sent_tasks);
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment
    protected void handleClickTaskChangeStatus(BoxTask boxTask, String str) {
        this.mSentTasksVM.updateTaskCollaborationStatus(boxTask, str).observe(this, new Observer<BoxResponse<BoxTask>>() { // from class: com.box.android.fragments.boxitem.SentTasksFragment.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(BoxResponse<BoxTask> boxResponse) {
                if (boxResponse != null) {
                    SentTasksFragment.this.mSentTasksVM.loadItems(true);
                }
            }
        });
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
        SentTasksVM sentTasksVM = this.mSentTasksVM;
        if (sentTasksVM != null) {
            sentTasksVM.loadItems(true);
        }
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_SENT_TASKS;
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.fragments.BaseListingFragment
    protected boolean isContentAvailable() {
        return this.mSentTasksVM.isContentAvailable();
    }
}
