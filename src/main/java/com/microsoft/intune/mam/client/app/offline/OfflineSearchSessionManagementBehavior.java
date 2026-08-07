package com.microsoft.intune.mam.client.app.offline;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.AppSearchSession;
import android.app.appsearch.BatchResultCallback;
import android.app.appsearch.EnterpriseGlobalSearchSession;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.GetSchemaResponse;
import android.app.appsearch.GlobalSearchSession;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.RemoveByDocumentIdRequest;
import android.app.appsearch.ReportSystemUsageRequest;
import android.app.appsearch.ReportUsageRequest;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.SetSchemaRequest;
import android.app.appsearch.SetSchemaResponse;
import com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineSearchSessionManagementBehavior implements SearchSessionManagementBehavior {
    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void getByDocumentId(AppSearchSession appSearchSession, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback) {
        appSearchSession.getByDocumentId(getByDocumentIdRequest, executor, batchResultCallback);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void getByDocumentId(GlobalSearchSession globalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback) {
        globalSearchSession.getByDocumentId(str, str2, getByDocumentIdRequest, executor, batchResultCallback);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void getByDocumentId(EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback) {
        enterpriseGlobalSearchSession.getByDocumentId(str, str2, getByDocumentIdRequest, executor, batchResultCallback);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void getNamespaces(AppSearchSession appSearchSession, Executor executor, Consumer<AppSearchResult<Set<String>>> consumer) {
        appSearchSession.getNamespaces(executor, consumer);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void remove(AppSearchSession appSearchSession, RemoveByDocumentIdRequest removeByDocumentIdRequest, Executor executor, BatchResultCallback<String, Void> batchResultCallback) {
        appSearchSession.remove(removeByDocumentIdRequest, executor, batchResultCallback);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void remove(AppSearchSession appSearchSession, String str, SearchSpec searchSpec, Executor executor, Consumer<AppSearchResult<Void>> consumer) {
        appSearchSession.remove(str, searchSpec, executor, consumer);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void reportUsage(AppSearchSession appSearchSession, ReportUsageRequest reportUsageRequest, Executor executor, Consumer<AppSearchResult<Void>> consumer) {
        appSearchSession.reportUsage(reportUsageRequest, executor, consumer);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void put(AppSearchSession appSearchSession, PutDocumentsRequest putDocumentsRequest, Executor executor, BatchResultCallback<String, Void> batchResultCallback) {
        appSearchSession.put(putDocumentsRequest, executor, batchResultCallback);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void reportSystemUsage(GlobalSearchSession globalSearchSession, ReportSystemUsageRequest reportSystemUsageRequest, Executor executor, Consumer<AppSearchResult<Void>> consumer) {
        globalSearchSession.reportSystemUsage(reportSystemUsageRequest, executor, consumer);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void setSchema(AppSearchSession appSearchSession, SetSchemaRequest setSchemaRequest, Executor executor, Executor executor2, Consumer<AppSearchResult<SetSchemaResponse>> consumer) {
        appSearchSession.setSchema(setSchemaRequest, executor, executor2, consumer);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void getSchema(AppSearchSession appSearchSession, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
        appSearchSession.getSchema(executor, consumer);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void getSchema(GlobalSearchSession globalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
        globalSearchSession.getSchema(str, str2, executor, consumer);
    }

    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior
    public void getSchema(EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
        enterpriseGlobalSearchSession.getSchema(str, str2, executor, consumer);
    }
}
