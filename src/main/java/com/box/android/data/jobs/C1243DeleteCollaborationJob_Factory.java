package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.services.IItemCollaborationsService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.DeleteCollaborationJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1243DeleteCollaborationJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IItemCollaborationsService> itemCollaborationsServiceProvider;
    private final Provider<ILocalItemService> itemServiceProvider;
    private final Provider<JobService> jobServiceProvider;

    private C1243DeleteCollaborationJob_Factory(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IItemCollaborationsService> itemCollaborationsServiceProvider, Provider<ILocalItemService> itemServiceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.itemCollaborationsServiceProvider = itemCollaborationsServiceProvider;
        this.itemServiceProvider = itemServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    public DeleteCollaborationJob get(JobId jobId, Data inputData) {
        return newInstance(this.appContextProvider.get(), this.jobServiceProvider.get(), this.itemCollaborationsServiceProvider.get(), this.itemServiceProvider.get(), jobId, inputData, this.idMappingServiceProvider.get());
    }

    public static C1243DeleteCollaborationJob_Factory create(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IItemCollaborationsService> itemCollaborationsServiceProvider, Provider<ILocalItemService> itemServiceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new C1243DeleteCollaborationJob_Factory(appContextProvider, jobServiceProvider, itemCollaborationsServiceProvider, itemServiceProvider, idMappingServiceProvider);
    }

    public static DeleteCollaborationJob newInstance(Context appContext, JobService jobService, IItemCollaborationsService itemCollaborationsService, ILocalItemService itemService, JobId jobId, Data inputData, IdMappingService idMappingService) {
        return new DeleteCollaborationJob(appContext, jobService, itemCollaborationsService, itemService, jobId, inputData, idMappingService);
    }
}
