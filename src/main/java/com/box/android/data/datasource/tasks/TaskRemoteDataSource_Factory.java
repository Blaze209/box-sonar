package com.box.android.data.datasource.tasks;

import com.box.android.data.api.requests.TaskRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskRemoteDataSource_Factory implements Factory<TaskRemoteDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<TaskRequest> taskRequestProvider;

    private TaskRemoteDataSource_Factory(Provider<TaskRequest> taskRequestProvider, Provider<Moshi> moshiProvider) {
        this.taskRequestProvider = taskRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TaskRemoteDataSource get() {
        return newInstance(this.taskRequestProvider.get(), this.moshiProvider.get());
    }

    public static TaskRemoteDataSource_Factory create(Provider<TaskRequest> taskRequestProvider, Provider<Moshi> moshiProvider) {
        return new TaskRemoteDataSource_Factory(taskRequestProvider, moshiProvider);
    }

    public static TaskRemoteDataSource newInstance(TaskRequest taskRequest, Moshi moshi) {
        return new TaskRemoteDataSource(taskRequest, moshi);
    }
}
