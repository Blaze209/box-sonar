package com.box.android.data.datasource.tasks;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.items.mini.FileIdDTO;
import com.box.android.data.api.models.tasks.AssigneeTargetDTO;
import com.box.android.data.api.models.tasks.CreateTaskDTO;
import com.box.android.data.api.models.tasks.TaskBodyDTO;
import com.box.android.data.api.models.tasks.TaskDTO;
import com.box.android.data.api.models.tasks.TaskLinkTargetDTO;
import com.box.android.data.api.requests.TaskRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.tasks.CompletionRule;
import com.box.android.domain.models.tasks.TaskType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JR\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/datasource/tasks/TaskRemoteDataSource;", "", "taskRequest", "Lcom/box/android/data/api/requests/TaskRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/TaskRequest;Lcom/squareup/moshi/Moshi;)V", "createTask", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/tasks/TaskDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileId", "", "type", "Lcom/box/android/domain/models/tasks/TaskType;", "message", "dueAt", "Ljava/util/Date;", "assigneeUserIds", "", "completionRule", "Lcom/box/android/domain/models/tasks/CompletionRule;", "(Ljava/lang/String;Lcom/box/android/domain/models/tasks/TaskType;Ljava/lang/String;Ljava/util/Date;Ljava/util/List;Lcom/box/android/domain/models/tasks/CompletionRule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TaskRemoteDataSource {
    private final Moshi moshi;
    private final TaskRequest taskRequest;

    /* JADX INFO: renamed from: com.box.android.data.datasource.tasks.TaskRemoteDataSource$createTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.tasks.TaskRemoteDataSource", f = "TaskRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {43}, m = "createTask", n = {"fileId", "type", "message", "dueAt", "assigneeUserIds", "completionRule", "$i$f$resultOf", "$i$a$-resultOf-TaskRemoteDataSource$createTask$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return TaskRemoteDataSource.this.createTask(null, null, null, null, null, null, this);
        }
    }

    @Inject
    public TaskRemoteDataSource(TaskRequest taskRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(taskRequest, "taskRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.taskRequest = taskRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object createTask(String str, TaskType taskType, String str2, Date date, List<String> list, CompletionRule completionRule, Continuation<? super Result<TaskDTO, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        String str3 = str;
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
        Object objCreateTaskWithDependencies = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateTaskWithDependencies);
                TaskRequest taskRequest = this.taskRequest;
                TaskBodyDTO taskBodyDTO = new TaskBodyDTO(str2, date, taskType, completionRule);
                List<String> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new AssigneeTargetDTO(new UserMiniDTO((String) it.next(), "user", null, null)));
                }
                CreateTaskDTO createTaskDTO = new CreateTaskDTO(taskBodyDTO, arrayList, CollectionsKt.listOf(new TaskLinkTargetDTO(new FileIdDTO(str3, null, 2, null))));
                anonymousClass1.L$0 = str3;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(taskType);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(date);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(list);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(completionRule);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objCreateTaskWithDependencies = taskRequest.createTaskWithDependencies(createTaskDTO, anonymousClass1);
                if (objCreateTaskWithDependencies == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                str3 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objCreateTaskWithDependencies);
            }
            error = new Result.Success((TaskDTO) objCreateTaskWithDependencies);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Exception while creating task on file " + str3, exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }
}
