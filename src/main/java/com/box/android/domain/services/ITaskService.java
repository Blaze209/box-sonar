package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.tasks.CompletionRule;
import com.box.android.domain.models.tasks.TaskModel;
import com.box.android.domain.models.tasks.TaskType;
import com.box.android.domain.utils.result.Result;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ITaskService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ITaskService;", "", "createTask", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/tasks/TaskModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "", "type", "Lcom/box/android/domain/models/tasks/TaskType;", "message", "dueAt", "Ljava/util/Date;", "assigneeUserIds", "", "completionRule", "Lcom/box/android/domain/models/tasks/CompletionRule;", "(Ljava/lang/String;Lcom/box/android/domain/models/tasks/TaskType;Ljava/lang/String;Ljava/util/Date;Ljava/util/List;Lcom/box/android/domain/models/tasks/CompletionRule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ITaskService {
    Object createTask(String str, TaskType taskType, String str2, Date date, List<String> list, CompletionRule completionRule, Continuation<? super Result<TaskModel, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: ITaskService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object createTask$default(ITaskService iTaskService, String str, TaskType taskType, String str2, Date date, List list, CompletionRule completionRule, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTask");
        }
        if ((i & 32) != 0) {
            completionRule = CompletionRule.ALL_ASSIGNEES;
        }
        return iTaskService.createTask(str, taskType, str2, date, list, completionRule, continuation);
    }
}
