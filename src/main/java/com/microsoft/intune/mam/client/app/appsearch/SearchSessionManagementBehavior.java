package com.microsoft.intune.mam.client.app.appsearch;

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
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public interface SearchSessionManagementBehavior {
    void getByDocumentId(AppSearchSession appSearchSession, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback);

    void getByDocumentId(EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback);

    void getByDocumentId(GlobalSearchSession globalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback);

    void getNamespaces(AppSearchSession appSearchSession, Executor executor, Consumer<AppSearchResult<Set<String>>> consumer);

    void getSchema(AppSearchSession appSearchSession, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer);

    void getSchema(EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer);

    void getSchema(GlobalSearchSession globalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer);

    void put(AppSearchSession appSearchSession, PutDocumentsRequest putDocumentsRequest, Executor executor, BatchResultCallback<String, Void> batchResultCallback);

    void remove(AppSearchSession appSearchSession, RemoveByDocumentIdRequest removeByDocumentIdRequest, Executor executor, BatchResultCallback<String, Void> batchResultCallback);

    void remove(AppSearchSession appSearchSession, String str, SearchSpec searchSpec, Executor executor, Consumer<AppSearchResult<Void>> consumer);

    void reportSystemUsage(GlobalSearchSession globalSearchSession, ReportSystemUsageRequest reportSystemUsageRequest, Executor executor, Consumer<AppSearchResult<Void>> consumer);

    void reportUsage(AppSearchSession appSearchSession, ReportUsageRequest reportUsageRequest, Executor executor, Consumer<AppSearchResult<Void>> consumer);

    void setSchema(AppSearchSession appSearchSession, SetSchemaRequest setSchemaRequest, Executor executor, Executor executor2, Consumer<AppSearchResult<SetSchemaResponse>> consumer);
}
