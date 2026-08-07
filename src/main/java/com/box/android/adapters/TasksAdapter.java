package com.box.android.adapters;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.tasksrepo.TasksRepo;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.androidsdk.content.views.DefaultAvatarController;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class TasksAdapter extends RecyclerView.Adapter<TasksViewHolder> {
    private static final String COLOR_HTML = "<font color='%s'>%s</font>";
    private static final String TAG = "TasksAdapter";
    private static final int VIEW_TYPE_APPROVE = 1;
    private DefaultAvatarController mAvatarController;
    final DateFormat mDateFormat;
    private String mFileNotFoundHtml;
    private final int mFragmentType;
    private TaskClickHandler mTaskClickHandler;
    private final List<BoxTask> mTasks = new ArrayList();
    private TasksRepo.TasksData mTasksData;
    DateFormat mTimeFormat;
    private IUserContextManager mUserContextManager;

    public interface TaskClickHandler {
        void onClickTask(BoxTask boxTask);

        void onClickTaskChangeStatus(BoxTask boxTask, String str);

        void onClickTaskCollaboratorsCount(String str);
    }

    public TasksAdapter(Context context, IUserContextManager iUserContextManager, TaskClickHandler taskClickHandler, int i) {
        this.mFileNotFoundHtml = "";
        this.mUserContextManager = iUserContextManager;
        this.mAvatarController = iUserContextManager.getPreviewStorage().getAvatarController();
        this.mTaskClickHandler = taskClickHandler;
        this.mFragmentType = i;
        setHasStableIds(true);
        this.mFileNotFoundHtml = String.format(COLOR_HTML, "#" + Integer.toHexString(CommonBoxUtil.getColorFromAttribute(context, R.attr.fileNotFound) & ViewCompat.MEASURED_SIZE_MASK), CommonBoxUtil.LS(R.string.File_Not_Found));
        this.mTasksData = null;
        this.mDateFormat = android.text.format.DateFormat.getMediumDateFormat(BoxBaseApplication.getInstance());
        this.mTimeFormat = android.text.format.DateFormat.getTimeFormat(BoxBaseApplication.getInstance());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TasksViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new TasksApproveViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_list_item_approve, viewGroup, false));
        }
        return new TasksGeneralViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_list_item_general, viewGroup, false));
    }

    private void setTaskStatus(TextView textView, BoxTask boxTask) {
        Context context = textView.getContext();
        int taskStatusString = getTaskStatusString(boxTask);
        textView.setText(taskStatusString);
        textView.setTextColor(getColor(context, taskStatusString));
    }

    private int getColor(Context context, int i) {
        int colorFromAttribute = CommonBoxUtil.getColorFromAttribute(context, R.attr.contentSecondary);
        if (i == R.string.Approved || i == R.string.Completed) {
            return CommonBoxUtil.getColorFromAttribute(context, R.attr.statusDone);
        }
        return i == R.string.Rejected ? CommonBoxUtil.getColorFromAttribute(context, R.attr.notification) : colorFromAttribute;
    }

    private int getTaskStatusString(BoxTask boxTask) {
        if (boxTask.getStatus().equals("APPROVED")) {
            return R.string.Approved;
        }
        if (boxTask.getStatus().equals("REJECTED")) {
            return R.string.Rejected;
        }
        return boxTask.getStatus().equals("COMPLETED") ? R.string.Completed : R.string.In_Progress;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TasksViewHolder tasksViewHolder, int i) {
        Context context = tasksViewHolder.mHeader.getContext();
        final BoxTask boxTask = this.mTasks.get(i);
        String id = this.mUserContextManager.getUserInfo().getUserId();
        Spanned taskHeader = getTaskHeader(boxTask, id);
        String description = boxTask.getDescription();
        CharSequence taskCreationDate = getTaskCreationDate(boxTask);
        CharSequence taskDueDate = getTaskDueDate(boxTask, context);
        tasksViewHolder.mAvatar.loadUser(boxTask.getCreatedByCollaborator().getTarget(), this.mAvatarController);
        tasksViewHolder.mHeader.setText(taskHeader);
        tasksViewHolder.mMessage.setText(description);
        tasksViewHolder.mCreationDate.setText(taskCreationDate);
        if (taskDueDate != null) {
            tasksViewHolder.mDueDate.setVisibility(0);
            tasksViewHolder.mDueDateLabel.setVisibility(0);
            tasksViewHolder.mDueDate.setText(taskDueDate);
        } else {
            tasksViewHolder.mDueDate.setVisibility(8);
            tasksViewHolder.mDueDateLabel.setVisibility(8);
        }
        tasksViewHolder.mTaskStatus.setText(getTaskStatusString(boxTask));
        setTaskStatus(tasksViewHolder.mTaskStatus, boxTask);
        BoxIteratorTaskCollaborators assignmentCollaborators = boxTask.getAssignmentCollaborators();
        int size = assignmentCollaborators.size();
        if (size > 0) {
            tasksViewHolder.mtaskAssignees.setVisibility(0);
            if (size == 1) {
                try {
                    if (assignmentCollaborators.getEntries().get(0).getTarget().getUserId().equals(id)) {
                        tasksViewHolder.mtaskAssignees.setVisibility(8);
                    }
                } catch (NullPointerException e) {
                    BoxLogUtils.e(TAG, "While fetching task collaborator Id", e);
                }
            }
            if (assignmentCollaborators.getNextMarker() == null) {
                tasksViewHolder.mAssignees.setText(CommonBoxUtil.quantityWithZero(R.string.assignees_none, R.plurals.Assignees_less_than_20, size, Integer.valueOf(size)));
            } else {
                tasksViewHolder.mAssignees.setText(CommonBoxUtil.LS(R.string.assignees_more_than_20));
            }
            tasksViewHolder.mtaskAssignees.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.adapters.TasksAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TasksAdapter.this.mTaskClickHandler.onClickTaskCollaboratorsCount(boxTask.getUserId());
                }
            });
        }
        tasksViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.adapters.TasksAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TasksAdapter.this.mTaskClickHandler.onClickTask(boxTask);
            }
        });
        if (tasksViewHolder instanceof TasksApproveViewHolder) {
            bindApproveTask(boxTask, (TasksApproveViewHolder) tasksViewHolder);
        } else if (tasksViewHolder instanceof TasksGeneralViewHolder) {
            bindCompleteTask(boxTask, (TasksGeneralViewHolder) tasksViewHolder);
        } else {
            BoxLogUtils.e("TasksAdapter.onBindViewHolder", "unhandled view holder " + tasksViewHolder);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    private void bindCompleteTask(final BoxTask boxTask, TasksGeneralViewHolder tasksGeneralViewHolder) {
        int i;
        String status = boxTask.getStatus();
        if (!boxTask.getTaskType().equals(BoxTask.TASK_TYPE_GENERAL)) {
            tasksGeneralViewHolder.mCompleteButton.setVisibility(8);
            tasksGeneralViewHolder.mCompleteIcon.setVisibility(8);
            tasksGeneralViewHolder.mCompleteMessage.setVisibility(8);
            return;
        }
        String taskCollaboratorStatus = getTaskCollaboratorStatus(boxTask);
        if (SdkUtils.isEmptyString(taskCollaboratorStatus)) {
            tasksGeneralViewHolder.mCompleteButton.setVisibility(8);
            tasksGeneralViewHolder.mCompleteIcon.setVisibility(8);
            tasksGeneralViewHolder.mCompleteMessage.setVisibility(8);
            return;
        }
        TasksRepo.TasksData.TaskChangeCollabStatus taskChangeCollabStatus = this.mTasksData.getTaskChangeCollabStatus(boxTask.getUserId());
        if (taskChangeCollabStatus != null) {
            if (taskChangeCollabStatus == TasksRepo.TasksData.TaskChangeCollabStatus.COMPLETED) {
                i = 8;
            } else {
                tasksGeneralViewHolder.mCompleteButton.setEnabled(taskChangeCollabStatus != TasksRepo.TasksData.TaskChangeCollabStatus.STARTED);
                i = 0;
            }
        } else if (status.equals("COMPLETED")) {
            i = 8;
        } else {
            i = taskCollaboratorStatus.equals("COMPLETED") ? 8 : 0;
            if (i == 0) {
                tasksGeneralViewHolder.mCompleteButton.setEnabled(true);
            }
        }
        tasksGeneralViewHolder.mCompleteButton.setVisibility(i);
        if (i == 0) {
            tasksGeneralViewHolder.mCompleteIcon.setVisibility(8);
            tasksGeneralViewHolder.mCompleteMessage.setVisibility(8);
            tasksGeneralViewHolder.mCompleteButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.adapters.TasksAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TasksAdapter.this.logTaskAction(boxTask, "COMPLETED");
                    TasksAdapter.this.mTaskClickHandler.onClickTaskChangeStatus(boxTask, "COMPLETED");
                }
            });
        } else if (taskCollaboratorStatus.equals("COMPLETED")) {
            tasksGeneralViewHolder.mCompleteIcon.setVisibility(0);
            tasksGeneralViewHolder.mCompleteMessage.setVisibility(0);
        } else {
            tasksGeneralViewHolder.mCompleteIcon.setVisibility(8);
            tasksGeneralViewHolder.mCompleteMessage.setVisibility(8);
        }
    }

    private void bindApproveTask(final BoxTask boxTask, TasksApproveViewHolder tasksApproveViewHolder) {
        String taskCollaboratorStatus = getTaskCollaboratorStatus(boxTask);
        if (SdkUtils.isEmptyString(taskCollaboratorStatus)) {
            tasksApproveViewHolder.mTaskBtnGroup.setVisibility(8);
            setUserActionOnTask(taskCollaboratorStatus, tasksApproveViewHolder);
            return;
        }
        String status = boxTask.getStatus();
        if (status.equals("APPROVED")) {
            tasksApproveViewHolder.mTaskBtnGroup.setVisibility(8);
            setUserActionOnTask(taskCollaboratorStatus, tasksApproveViewHolder);
            return;
        }
        if (status.equals("REJECTED")) {
            tasksApproveViewHolder.mTaskBtnGroup.setVisibility(8);
            setUserActionOnTask(taskCollaboratorStatus, tasksApproveViewHolder);
            return;
        }
        if (status.equals("IN_PROGRESS") || status.equals("NOT_STARTED")) {
            tasksApproveViewHolder.mTaskBtnGroup.setVisibility(0);
            setUserActionOnTask(taskCollaboratorStatus, tasksApproveViewHolder);
        }
        TasksRepo.TasksData.TaskChangeCollabStatus taskChangeCollabStatus = this.mTasksData.getTaskChangeCollabStatus(boxTask.getUserId());
        if (taskChangeCollabStatus != null && new HashSet(Arrays.asList(TasksRepo.TasksData.TaskChangeCollabStatus.STARTED, TasksRepo.TasksData.TaskChangeCollabStatus.COMPLETED)).contains(taskChangeCollabStatus)) {
            tasksApproveViewHolder.mApproveButton.setEnabled(false);
            tasksApproveViewHolder.mRejectButton.setEnabled(false);
            return;
        }
        tasksApproveViewHolder.mApproveButton.setEnabled(true);
        tasksApproveViewHolder.mRejectButton.setEnabled(true);
        tasksApproveViewHolder.mApproveButton.setTag(boxTask.getUserId());
        tasksApproveViewHolder.mRejectButton.setTag(boxTask.getUserId());
        tasksApproveViewHolder.mApproveButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.adapters.TasksAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TasksAdapter.this.logTaskAction(boxTask, "APPROVED");
                TasksAdapter.this.mTaskClickHandler.onClickTaskChangeStatus(boxTask, "APPROVED");
            }
        });
        tasksApproveViewHolder.mRejectButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.adapters.TasksAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TasksAdapter.this.logTaskAction(boxTask, "REJECTED");
                TasksAdapter.this.mTaskClickHandler.onClickTaskChangeStatus(boxTask, "REJECTED");
            }
        });
    }

    private String getTaskCollaboratorStatus(BoxTask boxTask) {
        for (BoxTaskCollaborator boxTaskCollaborator : boxTask.getAssignmentCollaborators()) {
            if (boxTaskCollaborator.getTarget().getUserId().equals(this.mUserContextManager.getCurrentContextId())) {
                return boxTaskCollaborator.getStatus();
            }
        }
        return "";
    }

    private void setUserActionOnTask(String str, TasksApproveViewHolder tasksApproveViewHolder) {
        if (str == null) {
            tasksApproveViewHolder.mTaskCollabStatusGroup.setVisibility(8);
            return;
        }
        if (str.equals("APPROVED")) {
            tasksApproveViewHolder.mTaskCollabStatusGroup.setVisibility(0);
            tasksApproveViewHolder.mTaskCollabStatusMessage.setText(R.string.User_Approved_Task);
            tasksApproveViewHolder.mTaskCollabStatusIcon.setImageResource(R.drawable.ic_completed_check);
            tasksApproveViewHolder.mTaskBtnGroup.setVisibility(8);
            return;
        }
        if (str.equals("REJECTED")) {
            tasksApproveViewHolder.mTaskCollabStatusGroup.setVisibility(0);
            tasksApproveViewHolder.mTaskCollabStatusMessage.setText(R.string.User_Rejected_Task);
            tasksApproveViewHolder.mTaskCollabStatusIcon.setImageResource(R.drawable.ic_reject);
            tasksApproveViewHolder.mTaskBtnGroup.setVisibility(8);
            return;
        }
        tasksApproveViewHolder.mTaskCollabStatusGroup.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mTasks.get(i).getTaskType().equals(BoxTask.TASK_TYPE_APPROVAL)) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    private BoxTask getTaskAt(int i) {
        return this.mTasks.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return Long.valueOf(getTaskAt(i).getUserId()).longValue();
    }

    private CharSequence getTaskDueDate(BoxTask boxTask, Context context) {
        if (boxTask.getDueAt() == null) {
            return null;
        }
        String string = context.getString(R.string.tasks_due_date, this.mDateFormat.format(boxTask.getCreatedAt()), this.mDateFormat.format(boxTask.getDueAt()), this.mTimeFormat.format(boxTask.getDueAt()));
        boolean zAfter = new Date().after(boxTask.getDueAt());
        boolean zIsTaskComplete = boxTask.isTaskComplete();
        String taskCollaboratorStatus = getTaskCollaboratorStatus(boxTask);
        boolean z = !SdkUtils.isEmptyString(taskCollaboratorStatus) && taskCollaboratorStatus.equals("NOT_STARTED");
        if (!zAfter || zIsTaskComplete || !z) {
            return string;
        }
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(CommonBoxUtil.getColorFromAttribute(context, R.attr.notification)), 0, string.length(), 33);
        return spannableString;
    }

    private CharSequence getTaskCreationDate(BoxTask boxTask) {
        return this.mDateFormat.format(boxTask.getCreatedAt());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x004a  */
    private Spanned getTaskHeader(BoxTask boxTask, String str) {
        String strQuantityWithZeroAndSingular;
        String firstLinkTaskName = getFirstLinkTaskName(boxTask);
        int linksTaskSize = getLinksTaskSize(boxTask);
        int i = this.mFragmentType;
        if (i == 22) {
            BoxCollaborator target = boxTask.getCreatedByCollaborator().getTarget();
            String userName = target.getUserName();
            if (SdkUtils.isBlank(userName)) {
                if (target instanceof BoxUser) {
                    BoxUser boxUser = (BoxUser) target;
                    if (!SdkUtils.isBlank(boxUser.getLogin())) {
                        userName = boxUser.getLogin();
                    } else {
                        userName = CommonBoxUtil.LS(R.string.Prior_Collaborator);
                    }
                } else {
                    userName = CommonBoxUtil.LS(R.string.Prior_Collaborator);
                }
            }
            if (target.getUserId().equalsIgnoreCase(str)) {
                if (boxTask.getTaskType().equals(BoxTask.TASK_TYPE_APPROVAL)) {
                    strQuantityWithZeroAndSingular = CommonBoxUtil.quantityWithZeroAndSingular(R.string.Sent_approval_task_file_zero, R.string.Sent_approval_task_file_name, R.plurals.Sent_approval_task_file, linksTaskSize, firstLinkTaskName);
                } else {
                    strQuantityWithZeroAndSingular = CommonBoxUtil.quantityWithZeroAndSingular(R.string.Sent_task_file_zero, R.string.Sent_task_file_name, R.plurals.Sent_task_file, linksTaskSize, firstLinkTaskName);
                }
            } else if (boxTask.getTaskType().equals(BoxTask.TASK_TYPE_APPROVAL)) {
                strQuantityWithZeroAndSingular = CommonBoxUtil.quantityWithZeroAndSingular(R.string.assigned_task_file_zero, R.string.assigned_approval_task_file_name, R.plurals.Assigned_approval_task_file, linksTaskSize, userName, firstLinkTaskName);
            } else {
                strQuantityWithZeroAndSingular = CommonBoxUtil.quantityWithZeroAndSingular(R.string.assigned_task_file_zero, R.string.assigned_task_file_name, R.plurals.Assigned_task_file, linksTaskSize, userName, firstLinkTaskName);
            }
        } else if (i != 23) {
            strQuantityWithZeroAndSingular = null;
        } else if (boxTask.getTaskType().equals(BoxTask.TASK_TYPE_APPROVAL)) {
            strQuantityWithZeroAndSingular = CommonBoxUtil.quantityWithZeroAndSingular(R.string.Sent_approval_task_file_zero, R.string.Sent_approval_task_file_name, R.plurals.Sent_approval_task_file, linksTaskSize, firstLinkTaskName);
        } else {
            strQuantityWithZeroAndSingular = CommonBoxUtil.quantityWithZeroAndSingular(R.string.Sent_task_file_zero, R.string.Sent_task_file_name, R.plurals.Sent_task_file, linksTaskSize, firstLinkTaskName);
        }
        return Html.fromHtml(strQuantityWithZeroAndSingular);
    }

    private String getFirstLinkTaskName(BoxTask boxTask) {
        if (getLinksTaskSize(boxTask) > 0) {
            BoxEntity target = boxTask.getTaskLinks().get(0).getTarget();
            if (target instanceof BoxItem) {
                String name = ((BoxItem) target).getName();
                return name == null ? this.mFileNotFoundHtml : name;
            }
            return "";
        }
        return "";
    }

    private int getLinksTaskSize(BoxTask boxTask) {
        return boxTask.getTaskLinks().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logTaskAction(BoxTask boxTask, String str) {
        BoxAmplitudeAnalytics.TaskEventPropertyBuilder taskEventPropertyBuilderCreateTaskEventBuilder = BoxAmplitudeAnalytics.createTaskEventBuilder();
        taskEventPropertyBuilderCreateTaskEventBuilder.setFlow(BoxAnalyticsParams.FLOW_TASK_ACTION);
        taskEventPropertyBuilderCreateTaskEventBuilder.setTask(boxTask);
        str.hashCode();
        switch (str) {
            case "REJECTED":
                taskEventPropertyBuilderCreateTaskEventBuilder.logEvent(BoxAnalyticsParams.EVENT_TASK_REJECTED);
                break;
            case "COMPLETED":
                taskEventPropertyBuilderCreateTaskEventBuilder.logEvent(BoxAnalyticsParams.EVENT_TASK_COMPLETED);
                break;
            case "APPROVED":
                taskEventPropertyBuilderCreateTaskEventBuilder.logEvent(BoxAnalyticsParams.EVENT_TASK_APPROVED);
                break;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTasks.size();
    }

    public static class TasksViewHolder extends RecyclerView.ViewHolder {
        protected final TextView mAssignees;
        protected final BoxAvatarView mAvatar;
        protected final TextView mCreationDate;
        protected final TextView mDueDate;
        protected final TextView mDueDateLabel;
        protected final TextView mHeader;
        protected final TextView mMessage;
        protected final View mTaskCollabActionAndStatus;
        protected final TextView mTaskStatus;
        protected final View mtaskAssignees;

        public TasksViewHolder(View view) {
            super(view);
            this.mAvatar = (BoxAvatarView) view.findViewById(R.id.task_avatar);
            this.mHeader = (TextView) view.findViewById(R.id.task_header);
            this.mMessage = (TextView) view.findViewById(R.id.task_message);
            this.mtaskAssignees = view.findViewById(R.id.task_assignees);
            this.mAssignees = (TextView) view.findViewById(R.id.assignee_count);
            this.mCreationDate = (TextView) view.findViewById(R.id.task_creation_date);
            this.mDueDate = (TextView) view.findViewById(R.id.task_due_date);
            this.mDueDateLabel = (TextView) view.findViewById(R.id.due_date_label);
            this.mTaskStatus = (TextView) view.findViewById(R.id.task_status);
            this.mTaskCollabActionAndStatus = view.findViewById(R.id.task_collaborator_status);
        }
    }

    public static class TasksGeneralViewHolder extends TasksViewHolder {
        private final View mCompleteButton;
        private final ImageView mCompleteIcon;
        private final TextView mCompleteMessage;

        public TasksGeneralViewHolder(View view) {
            super(view);
            this.mCompleteButton = view.findViewById(R.id.task_complete_action);
            this.mCompleteMessage = (TextView) view.findViewById(R.id.task_complete_message);
            this.mCompleteIcon = (ImageView) view.findViewById(R.id.task_collab_status_icon);
        }
    }

    public static class TasksApproveViewHolder extends TasksViewHolder {
        private final View mApproveButton;
        private final View mRejectButton;
        private final Group mTaskBtnGroup;
        private final Group mTaskCollabStatusGroup;
        private final ImageView mTaskCollabStatusIcon;
        private final TextView mTaskCollabStatusMessage;

        public TasksApproveViewHolder(View view) {
            super(view);
            this.mApproveButton = view.findViewById(R.id.task_approve_btn);
            this.mRejectButton = view.findViewById(R.id.task_reject_btn);
            this.mTaskCollabStatusMessage = (TextView) view.findViewById(R.id.task_collab_status_message);
            this.mTaskCollabStatusIcon = (ImageView) view.findViewById(R.id.task_collab_status_icon);
            this.mTaskCollabStatusGroup = (Group) view.findViewById(R.id.task_collab_status_views);
            this.mTaskBtnGroup = (Group) view.findViewById(R.id.task_approve_reject_btn_group);
        }
    }

    public void updateTasksData(TasksRepo.TasksData tasksData) {
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new TasksDiff(this.mTasksData, tasksData));
        this.mTasksData = tasksData;
        this.mTasks.clear();
        this.mTasks.addAll(this.mTasksData.getTasks().getEntries());
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    private static class TasksDiff extends DiffUtil.Callback {
        private final TasksRepo.TasksData mNewTasksData;
        private final TasksRepo.TasksData mOldTasksData;

        TasksDiff(TasksRepo.TasksData tasksData, TasksRepo.TasksData tasksData2) {
            this.mOldTasksData = tasksData;
            this.mNewTasksData = tasksData2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            TasksRepo.TasksData tasksData = this.mOldTasksData;
            if (tasksData == null) {
                return 0;
            }
            return tasksData.getTasks().getEntries().size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            TasksRepo.TasksData tasksData = this.mNewTasksData;
            if (tasksData == null) {
                return 0;
            }
            return tasksData.getTasks().getEntries().size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.mOldTasksData.getTasks().get(i).getUserId().equals(this.mNewTasksData.getTasks().get(i2).getUserId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            boolean zEquals;
            BoxTask boxTask = this.mOldTasksData.getTasks().get(i);
            BoxTask boxTask2 = this.mNewTasksData.getTasks().get(i2);
            TasksRepo.TasksData.TaskChangeCollabStatus taskChangeCollabStatus = this.mOldTasksData.getTaskChangeCollabStatus(boxTask.getUserId());
            String strName = taskChangeCollabStatus == null ? null : taskChangeCollabStatus.name();
            TasksRepo.TasksData.TaskChangeCollabStatus taskChangeCollabStatus2 = this.mNewTasksData.getTaskChangeCollabStatus(boxTask2.getUserId());
            String strName2 = taskChangeCollabStatus2 != null ? taskChangeCollabStatus2.name() : null;
            if (strName == null) {
                zEquals = strName2 == null;
            } else {
                zEquals = strName.equals(strName2);
            }
            return zEquals && Objects.equals(boxTask, boxTask2);
        }
    }
}
