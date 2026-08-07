package com.box.android.data.service.impl;

import com.box.android.data.api.models.tasks.TaskDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.tasks.TaskRemoteDataSource;
import com.box.android.data.mappers.tasks.TaskDTOToTaskModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.tasks.CompletionRule;
import com.box.android.domain.models.tasks.TaskModel;
import com.box.android.domain.models.tasks.TaskType;
import com.box.android.domain.services.ITaskService;
import com.box.android.domain.utils.result.Result;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JR\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/service/impl/TaskService;", "Lcom/box/android/domain/services/ITaskService;", "remoteDataSource", "Lcom/box/android/data/datasource/tasks/TaskRemoteDataSource;", "taskMapper", "Lcom/box/android/data/mappers/tasks/TaskDTOToTaskModelMapper;", "<init>", "(Lcom/box/android/data/datasource/tasks/TaskRemoteDataSource;Lcom/box/android/data/mappers/tasks/TaskDTOToTaskModelMapper;)V", "createTask", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/tasks/TaskModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "", "type", "Lcom/box/android/domain/models/tasks/TaskType;", "message", "dueAt", "Ljava/util/Date;", "assigneeUserIds", "", "completionRule", "Lcom/box/android/domain/models/tasks/CompletionRule;", "(Ljava/lang/String;Lcom/box/android/domain/models/tasks/TaskType;Ljava/lang/String;Ljava/util/Date;Ljava/util/List;Lcom/box/android/domain/models/tasks/CompletionRule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TaskService implements ITaskService {
    private final TaskRemoteDataSource remoteDataSource;
    private final TaskDTOToTaskModelMapper taskMapper;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.TaskService$createTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.TaskService", f = "TaskService.kt", i = {0, 0, 0, 0, 0, 0}, l = {43}, m = "createTask", n = {"fileId", "type", "message", "dueAt", "assigneeUserIds", "completionRule"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TaskService.this.createTask(null, null, null, null, null, null, this);
        }
    }

    @Inject
    public TaskService(TaskRemoteDataSource remoteDataSource, TaskDTOToTaskModelMapper taskMapper) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(taskMapper, "taskMapper");
        this.remoteDataSource = remoteDataSource;
        this.taskMapper = taskMapper;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.box.android.domain.services.ITaskService
    public Object createTask(String str, TaskType taskType, String str2, Date date, List<String> list, CompletionRule completionRule, Continuation<? super Result<TaskModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objCreateTask = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateTask);
            if (list.isEmpty()) {
                return new Result.Error(new DomainError.InputValidationError("At least one assignee is required to create a task"));
            }
            TaskRemoteDataSource taskRemoteDataSource = this.remoteDataSource;
            anonymousClass2.L$0 = str;
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(taskType);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(date);
            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list);
            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(completionRule);
            anonymousClass2.label = 1;
            objCreateTask = taskRemoteDataSource.createTask(str, taskType, str2, date, list, completionRule, anonymousClass2);
            if (objCreateTask == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objCreateTask);
        }
        Result.Success success = (Result) objCreateTask;
        TaskDTOToTaskModelMapper taskDTOToTaskModelMapper = this.taskMapper;
        if (success instanceof Result.Success) {
            success = new Result.Success(taskDTOToTaskModelMapper.toDomain((TaskDTO) ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while creating task on file " + str));
    }
}
