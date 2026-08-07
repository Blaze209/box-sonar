package com.box.android.data.mappers.tasks;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskDTOToTaskModelMapper_Factory implements Factory<TaskDTOToTaskModelMapper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TaskDTOToTaskModelMapper get() {
        return newInstance();
    }

    public static TaskDTOToTaskModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TaskDTOToTaskModelMapper newInstance() {
        return new TaskDTOToTaskModelMapper();
    }

    private static final class InstanceHolder {
        static final TaskDTOToTaskModelMapper_Factory INSTANCE = new TaskDTOToTaskModelMapper_Factory();

        private InstanceHolder() {
        }
    }
}
