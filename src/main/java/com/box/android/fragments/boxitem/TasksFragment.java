package com.box.android.fragments.boxitem;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.compose.material3.SnackbarDuration;
import androidx.fragment.app.FragmentActivity;
import com.box.android.R;
import com.box.android.activities.MainParent;
import com.box.android.activities.tasks.TaskCollaboratorsActivity;
import com.box.android.adapters.TasksAdapter;
import com.box.android.base.presentation.fragments.BaseListingFragment;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.fragments.NotificationsTasksTabFragment;
import com.box.android.navigationmodernization.MainBaseActivity;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.boxandroidlibv2private.model.BoxTaskLink;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes11.dex */
public abstract class TasksFragment extends BaseListingFragment implements NotificationsTasksTabFragment.TabVisibility {
    public Function1<ItemModel, Unit> itemClickListener;
    private TasksAdapter mAdapter;

    @Inject
    protected BoxExtendedApiFile mBoxExtendedApiFile;

    @Inject
    protected FeatureFlips mFeatureFlips;

    @Inject
    IUserContextManager mUserContextManager;
    protected int prevTasksSize;
    public Function4<String, String, SnackbarDuration, Function0<Unit>, Unit> showSnackbarListener;
    protected boolean isTaskLogEnabled = false;
    private TasksAdapter.TaskClickHandler mTaskClickHandler = new TasksAdapter.TaskClickHandler() { // from class: com.box.android.fragments.boxitem.TasksFragment.1
        @Override // com.box.android.adapters.TasksAdapter.TaskClickHandler
        public void onClickTask(BoxTask boxTask) {
            TasksFragment.this.handleTaskClick(boxTask);
        }

        @Override // com.box.android.adapters.TasksAdapter.TaskClickHandler
        public void onClickTaskChangeStatus(BoxTask boxTask, String str) {
            TasksFragment.this.handleClickTaskChangeStatus(boxTask, str);
        }

        @Override // com.box.android.adapters.TasksAdapter.TaskClickHandler
        public void onClickTaskCollaboratorsCount(String str) {
            TasksFragment.this.showTaskCollaborators(str);
        }
    };

    public abstract String getAmplitudePageName();

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return null;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected int getLayout() {
        return R.layout.tasks_layout;
    }

    public abstract int getType();

    protected abstract void handleClickTaskChangeStatus(BoxTask boxTask, String str);

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected abstract boolean isContentAvailable();

    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected void loadItems() {
    }

    public boolean onBackPressed() {
        return false;
    }

    public boolean shouldUpdateFragment(BoxMessage<?> boxMessage) {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFragment(BoxMessage<?> boxMessage) {
    }

    public abstract void updateFromRemote();

    public void showTaskCollaborators(String str) {
        startActivity(TaskCollaboratorsActivity.createIntent(getActivity(), str));
    }

    protected void handleTaskClick(BoxTask boxTask) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (boxTask == null || boxTask.getTaskLinks() == null) {
            showNotFoundErrorDialog();
            return;
        }
        ArrayList arrayList = new ArrayList(boxTask.getTaskLinks().size());
        for (BoxTaskLink boxTaskLink : boxTask.getTaskLinks()) {
            if (boxTaskLink.getTarget() instanceof BoxFile) {
                arrayList.add((BoxFile) boxTaskLink.getTarget());
            }
        }
        if (arrayList.size() == 1) {
            BoxFile boxFileSendForCachedResult = (BoxFile) arrayList.get(0);
            boolean z = activity instanceof MainParent;
            if (z || (activity instanceof MainBaseActivity)) {
                if (!SdkUtils.isBlank(boxFileSendForCachedResult.getName())) {
                    try {
                        boxFileSendForCachedResult = this.mBoxExtendedApiFile.getInfoRequest(boxFileSendForCachedResult.getUserId()).sendForCachedResult();
                    } catch (BoxException e) {
                        BoxLogUtils.e(MainParent.class.getName(), e);
                    }
                    if (boxFileSendForCachedResult.getFileVersion() == null || SdkUtils.isBlank(boxFileSendForCachedResult.getFileVersion().getUserId())) {
                        checkFileExistsAndLaunch(activity, boxFileSendForCachedResult);
                        return;
                    }
                    if (z) {
                        ((MainParent) activity).onItemClick(boxFileSendForCachedResult);
                        return;
                    }
                    ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(boxFileSendForCachedResult);
                    Function1<ItemModel, Unit> function1 = this.itemClickListener;
                    if (function1 == null || itemModel == null) {
                        return;
                    }
                    function1.invoke(itemModel);
                    return;
                }
                checkFileExistsAndLaunch(activity, boxFileSendForCachedResult);
                return;
            }
            return;
        }
        if (arrayList.size() > 1) {
            showNotFoundErrorDialog();
        } else {
            showNotFoundErrorDialog();
        }
    }

    private void checkFileExistsAndLaunch(Activity activity, BoxFile boxFile) {
        if (activity instanceof MainParent) {
            ((MainParent) activity).checkFileExistsAndLaunch(boxFile, new Runnable() { // from class: com.box.android.fragments.boxitem.TasksFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.showNotFoundErrorDialog();
                }
            });
        } else if (activity instanceof MainBaseActivity) {
            ((MainBaseActivity) activity).checkFileExistsAndLaunch(boxFile, new Function0() { // from class: com.box.android.fragments.boxitem.TasksFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$checkFileExistsAndLaunch$0();
                }
            }, new Function1() { // from class: com.box.android.fragments.boxitem.TasksFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$checkFileExistsAndLaunch$1((ItemModel) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$checkFileExistsAndLaunch$0() {
        showNotFoundErrorDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$checkFileExistsAndLaunch$1(ItemModel itemModel) {
        Function1<ItemModel, Unit> function1 = this.itemClickListener;
        if (function1 != null) {
            function1.invoke(itemModel);
        }
        return Unit.INSTANCE;
    }

    protected void logTasksViewed(int i) {
        if (!this.isTaskLogEnabled || this.prevTasksSize == i) {
            return;
        }
        this.prevTasksSize = i;
        if (this.mFeatureFlips.getMainScreenRedesign().getEnabled()) {
            BoxAmplitudeAnalytics.getInstance().setCurrentPage(getAmplitudePageName());
        }
        BoxAmplitudeAnalytics.TaskEventPropertyBuilder taskEventPropertyBuilderCreateTaskEventBuilder = BoxAmplitudeAnalytics.createTaskEventBuilder();
        taskEventPropertyBuilderCreateTaskEventBuilder.setFlow(BoxAnalyticsParams.FLOW_TASK_ACTION);
        taskEventPropertyBuilderCreateTaskEventBuilder.setTotalTasks(i);
        int type = getType();
        if (type == 22) {
            taskEventPropertyBuilderCreateTaskEventBuilder.logEvent(BoxAnalyticsParams.EVENT_MY_TASKS_VIEWED);
        } else {
            if (type != 23) {
                return;
            }
            taskEventPropertyBuilderCreateTaskEventBuilder.logEvent(BoxAnalyticsParams.EVENT_SENT_TASKS_VIEWED);
        }
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected BoxItemDividerDecoration getItemDividerDecoration() {
        return new BoxItemDividerDecoration(getResources().getDrawable(R.drawable.content_divider_with_inset, getContext().getTheme()), 0, 0);
    }

    protected void processBoxResponse(BoxResponse<?> boxResponse) {
        if (boxResponse == null || boxResponse.getException() == null || getView() == null || getActivity() == null || !(boxResponse.getException() instanceof BoxException) || ((BoxException) boxResponse.getException()).getErrorType() != BoxException.ErrorType.NETWORK_ERROR) {
            return;
        }
        Function4<String, String, SnackbarDuration, Function0<Unit>, Unit> function4 = this.showSnackbarListener;
        if (function4 != null) {
            function4.invoke(CommonBoxUtil.LS(R.string.boxsdk_error_network_connection), CommonBoxUtil.LS(R.string.box_browsesdk_tap_to_retry), SnackbarDuration.Indefinite, new Function0() { // from class: com.box.android.fragments.boxitem.TasksFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$processBoxResponse$2();
                }
            });
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof MainParent) {
            ((MainParent) activity).displaySnackbar(R.string.boxsdk_error_network_connection, R.string.box_browsesdk_tap_to_retry, new View.OnClickListener() { // from class: com.box.android.fragments.boxitem.TasksFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$processBoxResponse$3(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$processBoxResponse$2() {
        updateFromRemote();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processBoxResponse$3(View view) {
        updateFromRemote();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    public TasksAdapter createAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new TasksAdapter(getContext(), this.mUserContextManager, this.mTaskClickHandler, getType());
        }
        return this.mAdapter;
    }

    @Override // com.box.android.fragments.NotificationsTasksTabFragment.TabVisibility
    public void setTabVisibility(boolean z) {
        this.isTaskLogEnabled = z;
        if (z) {
            return;
        }
        resetPrevTasksSize();
    }

    protected void resetPrevTasksSize() {
        this.prevTasksSize = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotFoundErrorDialog() {
        String strLS = CommonBoxUtil.LS(R.string.File_Not_Found);
        String strLS2 = CommonBoxUtil.LS(R.string.File_not_found_error_for_task_description);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(activity);
        materialAlertDialogBuilder.setMessage((CharSequence) strLS2);
        materialAlertDialogBuilder.setTitle((CharSequence) strLS);
        materialAlertDialogBuilder.setNegativeButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.box.android.fragments.boxitem.TasksFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.create().show();
    }
}
