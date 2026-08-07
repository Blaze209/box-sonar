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
import com.box.android.activities.tasks.SingleTaskActivity;
import com.box.android.adapters.TasksAdapter;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.tasksrepo.TasksRepo;
import com.box.android.vm.SingleTaskVM;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxIteratorTasks;
import com.box.boxandroidlibv2private.model.BoxTask;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class SingleTaskFragment extends Hilt_SingleTaskFragment {
    private static final String EXTRA_FRAGMENT_TYPE = "extraFragmentType";
    private static final String EXTRA_TASK_ID = "extraTaskId";
    private TasksAdapter mAdapter;
    private int mFragmentType = 22;
    private SingleTaskVM mSingleTaskVM;
    private String mTaskId;
    private BoxIteratorTasks mTasks;
    private String mViewSource;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.mTaskId = getArguments().getString(EXTRA_TASK_ID);
        this.mFragmentType = getArguments().getInt(EXTRA_FRAGMENT_TYPE);
        this.mViewSource = getArguments().getString(SingleTaskActivity.VIEW_SOURCE);
        this.mAdapter = createAdapter();
        this.mSingleTaskVM = (SingleTaskVM) new ViewModelProvider(this).get(SingleTaskVM.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mSingleTaskVM.getTask(this.mTaskId).observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.boxitem.SingleTaskFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onActivityCreated$0((TasksRepo.TasksData) obj);
            }
        });
        this.mSingleTaskVM.loadItems(false);
        this.mSingleTaskVM.loadItems(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$0(TasksRepo.TasksData tasksData) {
        if (tasksData != null && tasksData.getTasks() != null) {
            this.mAdapter.updateTasksData(tasksData);
            updateItems();
            updateUI();
            if (!tasksData.getTasks().getEntries().isEmpty()) {
                logTask(tasksData.getTasks().getEntries().get(0));
            }
        }
        if (tasksData != null) {
            processBoxResponse(tasksData.getResponse());
            if (tasksData.getResponse() != null && tasksData.getResponse().isSuccess()) {
                if (Objects.equals(this.mTasks, tasksData.getTasks())) {
                    return;
                }
                this.mTasks = (BoxIteratorTasks) tasksData.getResponse().getResult();
                return;
            }
            new SingleTaskErrorPresenter(tasksData.getResponse()).present();
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
        return CommonBoxUtil.LS(R.string.task);
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return this.mFragmentType;
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
        SingleTaskVM singleTaskVM = this.mSingleTaskVM;
        if (singleTaskVM != null) {
            singleTaskVM.loadItems(true);
        }
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment
    protected void handleClickTaskChangeStatus(BoxTask boxTask, String str) {
        this.mSingleTaskVM.updateTaskCollaborationStatus(boxTask, str).observe(this, new Observer<BoxResponse<BoxTask>>() { // from class: com.box.android.fragments.boxitem.SingleTaskFragment.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(BoxResponse<BoxTask> boxResponse) {
                if (boxResponse != null) {
                    SingleTaskFragment.this.mSingleTaskVM.loadItems(false);
                }
            }
        });
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.fragments.BaseListingFragment
    protected boolean isContentAvailable() {
        return this.mSingleTaskVM.isContentAvailable();
    }

    @Override // com.box.android.fragments.boxitem.TasksFragment, com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_TASK;
    }

    public static SingleTaskFragment newInstance(String str, String str2, boolean z) {
        SingleTaskFragment singleTaskFragment = new SingleTaskFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SingleTaskActivity.VIEW_SOURCE, str2);
        bundle.putString(EXTRA_TASK_ID, str);
        if (z) {
            bundle.putInt(EXTRA_FRAGMENT_TYPE, 22);
        } else {
            bundle.putInt(EXTRA_FRAGMENT_TYPE, 23);
        }
        singleTaskFragment.setArguments(bundle);
        return singleTaskFragment;
    }

    class SingleTaskErrorPresenter {
        final BoxResponse<BoxIteratorTasks> mResponse;

        public SingleTaskErrorPresenter(BoxResponse<BoxIteratorTasks> boxResponse) {
            this.mResponse = boxResponse;
        }

        public void present() {
            if (this.mResponse.getException() instanceof BoxException.CacheResultUnavailable) {
                return;
            }
            if (this.mResponse.getException() instanceof BoxException) {
                if (((BoxException) this.mResponse.getException()).getErrorType() == BoxException.ErrorType.NETWORK_ERROR) {
                    BoxPresentationUtils.displayToast(R.string.check_connection_try_again, SingleTaskFragment.this.getActivity(), new String[0]);
                    return;
                }
                if (((BoxException) this.mResponse.getException()).getResponseCode() == 404) {
                    BoxPresentationUtils.displayToast(R.string.error_item_unavailable, SingleTaskFragment.this.getActivity(), new String[0]);
                } else {
                    BoxLogUtils.logException(getClass().getName(), "Unexpected box exception", this.mResponse.getException());
                    BoxPresentationUtils.displayToast(R.string.err_unknown, SingleTaskFragment.this.getActivity(), new String[0]);
                }
                SingleTaskFragment.this.getActivity().finish();
                return;
            }
            BoxLogUtils.logException(getClass().getName(), "Unexpected non box exception", this.mResponse.getException());
            BoxPresentationUtils.displayToast(R.string.err_unknown, SingleTaskFragment.this.getActivity(), new String[0]);
            SingleTaskFragment.this.getActivity().finish();
        }
    }

    private void logTask(BoxTask boxTask) {
        BoxAmplitudeAnalytics.TaskEventPropertyBuilder taskEventPropertyBuilderCreateTaskEventBuilder = BoxAmplitudeAnalytics.createTaskEventBuilder();
        taskEventPropertyBuilderCreateTaskEventBuilder.setFlow(BoxAnalyticsParams.FLOW_TASK_ACTION);
        taskEventPropertyBuilderCreateTaskEventBuilder.setViewSource(this.mViewSource);
        taskEventPropertyBuilderCreateTaskEventBuilder.setTask(boxTask);
        taskEventPropertyBuilderCreateTaskEventBuilder.logEvent(BoxAnalyticsParams.EVENT_SINGLE_TASK_VIEWED);
    }
}
