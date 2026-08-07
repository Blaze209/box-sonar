package com.box.android.tasksrepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.BoxIteratorTasks;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.box.boxandroidlibv2private.requests.BoxRequestGetInbox;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class TasksRepo {
    private static final String TASKS_REPO_CONTEXT_COMPONENT_NAME = "TasksRepo";
    private final IBaseModelController mBaseMoCo;
    private final BoxApiPrivate mBoxApiPrivate;
    private final MutableLiveData<TasksData> mMyBoxTasksData = new MutableLiveData<>();
    private final MutableLiveData<TasksData> mSentBoxTasksData = new MutableLiveData<>();
    private final RequestStatusMap<String, TasksData.TaskChangeCollabStatus> mTaskCollabChangeStatus = new RequestStatusMap<>();
    private final IUserContextManager mUserContextManager;

    @Inject
    public TasksRepo(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate, IUserContextManager iUserContextManager) {
        this.mBaseMoCo = iBaseModelController;
        this.mBoxApiPrivate = boxApiPrivate;
        this.mUserContextManager = iUserContextManager;
        iUserContextManager.addUserContextListener(TASKS_REPO_CONTEXT_COMPONENT_NAME, getUserContextListener());
    }

    public LiveData<TasksData> getMyTasksData() {
        return this.mMyBoxTasksData;
    }

    public void updateMyTasks(boolean z) {
        if (z) {
            fetchTasksFromRemote(createInboxRequest(BoxTaskCollaborator.ROLE_ASSIGNEE));
        } else {
            fetchTasksFromCache(createInboxRequest(BoxTaskCollaborator.ROLE_ASSIGNEE));
        }
    }

    public LiveData<TasksData> getSentTasksData() {
        return this.mSentBoxTasksData;
    }

    public void updateSentTasks(boolean z) {
        if (z) {
            fetchTasksFromRemote(createInboxRequest(BoxTaskCollaborator.ROLE_CREATOR));
        } else {
            fetchTasksFromCache(createInboxRequest(BoxTaskCollaborator.ROLE_CREATOR));
        }
    }

    private BoxRequestGetInbox createInboxRequest(String str) {
        return this.mBoxApiPrivate.getInboxAll().limitTaskCollaboratorRole(str);
    }

    private void fetchTasksFromRemote(final BoxRequestGetInbox boxRequestGetInbox) {
        this.mBaseMoCo.performRemote(boxRequestGetInbox, new BoxAppFutureTask.OnCompletedListener<BoxIteratorTasks>() { // from class: com.box.android.tasksrepo.TasksRepo.1
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxIteratorTasks> boxResponse) {
                if (boxResponse != null) {
                    if (!boxResponse.isSuccess()) {
                        TasksRepo.this.fetchTasksFromCache(boxRequestGetInbox, boxResponse.getException());
                        BoxLogUtils.e(TasksRepo.class.getName(), "Remote request to get tasks failed");
                    } else {
                        TasksRepo.this.fetchTasksFromCache(boxRequestGetInbox);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResultWithErrorInfo(BoxResponse<BoxIteratorTasks> boxResponse, Exception exc) {
        postResult(new BoxResponse<>((BoxIteratorTasks) boxResponse.getResult(), exc, boxResponse.getRequest()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(BoxResponse<BoxIteratorTasks> boxResponse) {
        BoxRequestGetInbox boxRequestGetInbox = (BoxRequestGetInbox) boxResponse.getRequest();
        if (boxRequestGetInbox.getTaskCollaboratorRoleLimit().equals(BoxTaskCollaborator.ROLE_ASSIGNEE)) {
            this.mMyBoxTasksData.postValue(createTaskData(boxResponse));
        } else if (boxRequestGetInbox.getTaskCollaboratorRoleLimit().equals(BoxTaskCollaborator.ROLE_CREATOR)) {
            this.mSentBoxTasksData.postValue(createTaskData(boxResponse));
        }
    }

    private TasksData createTaskData(BoxResponse<BoxIteratorTasks> boxResponse) {
        return new TasksData(boxResponse, this.mTaskCollabChangeStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchTasksFromCache(BoxRequestGetInbox boxRequestGetInbox) {
        this.mBaseMoCo.performLocal(boxRequestGetInbox, new BoxAppFutureTask.OnCompletedListener<BoxIteratorTasks>() { // from class: com.box.android.tasksrepo.TasksRepo.2
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxIteratorTasks> boxResponse) {
                if (boxResponse != null) {
                    if (!boxResponse.isSuccess()) {
                        TasksRepo.this.postResultWithErrorInfo(boxResponse, boxResponse.getException());
                    } else {
                        TasksRepo.this.postResult(boxResponse);
                    }
                }
            }
        });
    }

    public LiveData<BoxResponse<BoxTask>> updateStatus(final BoxTask boxTask, String str) {
        final MutableLiveData mutableLiveData = new MutableLiveData();
        if (this.mUserContextManager.getUserInfo() == null || SdkUtils.isBlank(this.mUserContextManager.getUserInfo().getUserId())) {
            mutableLiveData.postValue(null);
            return mutableLiveData;
        }
        this.mTaskCollabChangeStatus.put(boxTask.getUserId(), TasksData.TaskChangeCollabStatus.STARTED);
        repostTaskDataIfChanged();
        this.mBaseMoCo.performRemote(this.mBoxApiPrivate.updateTaskAssignmentCollaborator(boxTask, str), new BoxAppFutureTask.OnCompletedListener<BoxTask>() { // from class: com.box.android.tasksrepo.TasksRepo.3
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxTask> boxResponse) {
                if (boxResponse.isSuccess()) {
                    TasksRepo.this.mTaskCollabChangeStatus.put(boxTask.getUserId(), TasksData.TaskChangeCollabStatus.COMPLETED);
                } else {
                    TasksRepo.this.mTaskCollabChangeStatus.put(boxTask.getUserId(), TasksData.TaskChangeCollabStatus.ERROR);
                }
                TasksRepo.this.repostTaskDataIfChanged();
                mutableLiveData.postValue(boxResponse);
            }
        });
        return mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void repostTaskDataIfChanged() {
        ArrayList<MutableLiveData> arrayList = new ArrayList(2);
        arrayList.add(this.mMyBoxTasksData);
        arrayList.add(this.mSentBoxTasksData);
        for (MutableLiveData mutableLiveData : arrayList) {
            TasksData tasksData = (TasksData) mutableLiveData.getValue();
            if (tasksData != null) {
                if (this.mTaskCollabChangeStatus.getTotalPuts() == tasksData.getTaskChangeCollabStatusMap().getTotalPuts()) {
                    return;
                } else {
                    mutableLiveData.postValue(createTaskData(tasksData.mTaskResponse));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchTasksFromCache(BoxRequestGetInbox boxRequestGetInbox, final Exception exc) {
        this.mBaseMoCo.performLocal(boxRequestGetInbox, new BoxAppFutureTask.OnCompletedListener<BoxIteratorTasks>() { // from class: com.box.android.tasksrepo.TasksRepo.4
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxIteratorTasks> boxResponse) {
                if (boxResponse != null) {
                    TasksRepo.this.postResultWithErrorInfo(boxResponse, exc);
                }
            }
        });
    }

    IUserContextComponentListener getUserContextListener() {
        return new IUserContextComponentListener() { // from class: com.box.android.tasksrepo.TasksRepo.5
            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onCreate(String str) {
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onSoftDestroy() {
                onHardDestroy();
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onHardDestroy() {
                TasksRepo.this.mMyBoxTasksData.postValue(null);
                TasksRepo.this.mSentBoxTasksData.postValue(null);
                TasksRepo.this.mTaskCollabChangeStatus.clear();
            }
        };
    }

    public static class TasksData {
        private final RequestStatusMap<String, TaskChangeCollabStatus> mTaskChangeCollabStatus;
        private final BoxResponse<BoxIteratorTasks> mTaskResponse;

        public enum TaskChangeCollabStatus {
            STARTED,
            COMPLETED,
            ERROR
        }

        public TasksData(BoxResponse<BoxIteratorTasks> boxResponse) {
            this.mTaskResponse = boxResponse;
            this.mTaskChangeCollabStatus = new RequestStatusMap<>();
        }

        public TasksData(BoxResponse<BoxIteratorTasks> boxResponse, Map<String, TaskChangeCollabStatus> map) {
            this.mTaskResponse = boxResponse;
            RequestStatusMap<String, TaskChangeCollabStatus> requestStatusMap = new RequestStatusMap<>(map);
            this.mTaskChangeCollabStatus = requestStatusMap;
            if (map instanceof RequestStatusMap) {
                requestStatusMap.setTotalPuts(((RequestStatusMap) map).getTotalPuts());
            }
        }

        public TaskChangeCollabStatus getTaskChangeCollabStatus(String str) {
            return this.mTaskChangeCollabStatus.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RequestStatusMap getTaskChangeCollabStatusMap() {
            return this.mTaskChangeCollabStatus;
        }

        public BoxIteratorTasks getTasks() {
            return (BoxIteratorTasks) this.mTaskResponse.getResult();
        }

        public BoxResponse<BoxIteratorTasks> getResponse() {
            return this.mTaskResponse;
        }
    }

    private static class RequestStatusMap<String, Object> extends ConcurrentHashMap<String, Object> {
        private final AtomicLong mCounter;

        RequestStatusMap() {
            this.mCounter = new AtomicLong();
        }

        RequestStatusMap(Map<String, Object> map) {
            super(map);
            this.mCounter = new AtomicLong();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public Object put(String string, Object object) {
            this.mCounter.incrementAndGet();
            return (Object) super.put(string, object);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.mCounter.set(0L);
            super.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getTotalPuts() {
            return this.mCounter.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalPuts(long j) {
            this.mCounter.set(j);
        }
    }
}
