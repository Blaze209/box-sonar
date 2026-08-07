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
import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMSearchSessionManagement {
    private static CachedBehaviorProvider<SearchSessionManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(SearchSessionManagementBehavior.class);

    private MAMSearchSessionManagement() {
    }

    public static void getByDocumentId(AppSearchSession appSearchSession, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback) {
        getBehavior().getByDocumentId(appSearchSession, getByDocumentIdRequest, executor, batchResultCallback);
    }

    public static void getByDocumentId(GlobalSearchSession globalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback) {
        getBehavior().getByDocumentId(globalSearchSession, str, str2, getByDocumentIdRequest, executor, batchResultCallback);
    }

    public static void getByDocumentId(EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback<String, GenericDocument> batchResultCallback) {
        getBehavior().getByDocumentId(enterpriseGlobalSearchSession, str, str2, getByDocumentIdRequest, executor, batchResultCallback);
    }

    public static void getNamespaces(AppSearchSession appSearchSession, Executor executor, Consumer<AppSearchResult<Set<String>>> consumer) {
        getBehavior().getNamespaces(appSearchSession, executor, consumer);
    }

    public static void remove(AppSearchSession appSearchSession, RemoveByDocumentIdRequest removeByDocumentIdRequest, Executor executor, BatchResultCallback<String, Void> batchResultCallback) {
        getBehavior().remove(appSearchSession, removeByDocumentIdRequest, executor, batchResultCallback);
    }

    public static void remove(AppSearchSession appSearchSession, String str, SearchSpec searchSpec, Executor executor, Consumer<AppSearchResult<Void>> consumer) {
        getBehavior().remove(appSearchSession, str, searchSpec, executor, consumer);
    }

    public static void reportUsage(AppSearchSession appSearchSession, ReportUsageRequest reportUsageRequest, Executor executor, Consumer<AppSearchResult<Void>> consumer) {
        getBehavior().reportUsage(appSearchSession, reportUsageRequest, executor, consumer);
    }

    public static void put(AppSearchSession appSearchSession, PutDocumentsRequest putDocumentsRequest, Executor executor, BatchResultCallback<String, Void> batchResultCallback) {
        getBehavior().put(appSearchSession, putDocumentsRequest, executor, batchResultCallback);
    }

    public static void reportSystemUsage(GlobalSearchSession globalSearchSession, ReportSystemUsageRequest reportSystemUsageRequest, Executor executor, Consumer<AppSearchResult<Void>> consumer) {
        getBehavior().reportSystemUsage(globalSearchSession, reportSystemUsageRequest, executor, consumer);
    }

    public static void setSchema(AppSearchSession appSearchSession, SetSchemaRequest setSchemaRequest, Executor executor, Executor executor2, Consumer<AppSearchResult<SetSchemaResponse>> consumer) {
        getBehavior().setSchema(appSearchSession, setSchemaRequest, executor, executor2, consumer);
    }

    public static void getSchema(AppSearchSession appSearchSession, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
        getBehavior().getSchema(appSearchSession, executor, consumer);
    }

    public static void getSchema(GlobalSearchSession globalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
        getBehavior().getSchema(globalSearchSession, str, str2, executor, consumer);
    }

    public static void getSchema(EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
        getBehavior().getSchema(enterpriseGlobalSearchSession, str, str2, executor, consumer);
    }

    private static SearchSessionManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }
}
