package com.box.android.data.api.requests;

import com.box.android.data.api.models.tasks.CreateTaskDTO;
import com.box.android.data.api.models.tasks.TaskDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: TaskRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/TaskRequest;", "", "createTaskWithDependencies", "Lcom/box/android/data/api/models/tasks/TaskDTO;", "body", "Lcom/box/android/data/api/models/tasks/CreateTaskDTO;", "(Lcom/box/android/data/api/models/tasks/CreateTaskDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TaskRequest {
    @POST("undoc/tasks/with_dependencies")
    Object createTaskWithDependencies(@Body CreateTaskDTO createTaskDTO, Continuation<? super TaskDTO> continuation);
}
