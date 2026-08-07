package com.box.android.data.service.impl;

import com.box.android.data.datasource.tasks.TaskRemoteDataSource;
import com.box.android.data.mappers.tasks.TaskDTOToTaskModelMapper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskService_Factory implements Factory<TaskService> {
    private final Provider<TaskRemoteDataSource> remoteDataSourceProvider;
    private final Provider<TaskDTOToTaskModelMapper> taskMapperProvider;

    private TaskService_Factory(Provider<TaskRemoteDataSource> remoteDataSourceProvider, Provider<TaskDTOToTaskModelMapper> taskMapperProvider) {
        this.remoteDataSourceProvider = remoteDataSourceProvider;
        this.taskMapperProvider = taskMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TaskService get() {
        return newInstance(this.remoteDataSourceProvider.get(), this.taskMapperProvider.get());
    }

    public static TaskService_Factory create(Provider<TaskRemoteDataSource> remoteDataSourceProvider, Provider<TaskDTOToTaskModelMapper> taskMapperProvider) {
        return new TaskService_Factory(remoteDataSourceProvider, taskMapperProvider);
    }

    public static TaskService newInstance(TaskRemoteDataSource remoteDataSource, TaskDTOToTaskModelMapper taskMapper) {
        return new TaskService(remoteDataSource, taskMapper);
    }
}
