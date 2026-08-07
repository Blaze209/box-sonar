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
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.tasksrepo.TasksRepo;
import com.box.android.vm.InboxBadgeVM;
import com.box.android.vm.MyTasksVM;
import com.box.android.vm.TasksVMFactory;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxIteratorTasks;
import com.box.boxandroidlibv2private.model.BoxTask;
import java.util.Objects;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class MyTasksFragment extends Hilt_MyTasksFragment {
    private TasksAdapter mAdapter;
    private InboxBadgeVM mInboxBadgeVM;
    private MyTasksVM mMyTaskVM;
    private BoxIteratorTasks mTasks;

    @Inject
    TasksVMFactory mTasksVMFactory;

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 22;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        resetPrevTasksSize();
        this.mAdapter = createAdapter();
        this.mMyTaskVM = (MyTasksVM) new ViewModelProvider(this, this.mTasksVMFactory).get(MyTasksVM.class);
        this.mInboxBadgeVM = (InboxBadgeVM) new ViewModelProvider(requireActivity()).get(InboxBadgeVM.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mMyTaskVM.getMyTasksData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.boxitem.MyTasksFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onActivityCreated$0((TasksRepo.TasksData) obj);
            }
        });
        this.mMyTaskVM.loadItems(false);
        this.mMyTaskVM.loadItems(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$0(TasksRepo.TasksData tasksData) {
        if (tasksData != null && tasksData.getTasks() != null) {
            this.mAdapter.updateTasksData(tasksData);
            updateItems();
            updateUI();
            logTasksViewed(tasksData.getTasks().getEntries().size());
        }
        if (tasksData != null) {
            processBoxResponse(tasksData.getResponse());
            if (tasksData.getResponse() == null || !tasksData.getResponse().isSuccess() || Objects.equals(this.mTasks, tasksData.getTasks())) {
                return;
            }
            this.mTasks = (BoxIteratorTasks) tasksData.getResponse().getResult();
        }
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (viewOnCreateView != null) {
            ((TextView) viewOnCreateView.findViewById(R.id.empty_folder_text)).setText(getResources().getString(R.string.empty_my_tasks_text));
        }
        return viewOnCreateView;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return CommonBoxUtil.LS(R.string.my_tasks);
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
        MyTasksVM myTasksVM = this.mMyTaskVM;
        if (myTasksVM != null) {
            myTasksVM.loadItems(true);
        }
        InboxBadgeVM inboxBadgeVM = this.mInboxBadgeVM;
        if (inboxBadgeVM != null) {
            inboxBadgeVM.fetchBadgeData();
        }
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment
    protected void handleClickTaskChangeStatus(BoxTask boxTask, String str) {
        this.mMyTaskVM.updateTaskCollaborationStatus(boxTask, str).observe(this, new Observer<BoxResponse<BoxTask>>() { // from class: com.box.android.fragments.boxitem.MyTasksFragment.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(BoxResponse<BoxTask> boxResponse) {
                if (boxResponse != null) {
                    MyTasksFragment.this.mMyTaskVM.loadItems(true);
                    if (boxResponse.isSuccess()) {
                        MyTasksFragment.this.mInboxBadgeVM.fetchBadgeData();
                    }
                }
            }
        });
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.fragments.BaseListingFragment
    protected boolean isContentAvailable() {
        return this.mMyTaskVM.isContentAvailable();
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_MY_TASKS;
    }
}
