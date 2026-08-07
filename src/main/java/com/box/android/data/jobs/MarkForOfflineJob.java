package com.box.android.data.jobs;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.Data;
import com.box.android.common.extensions.FileExtensionsKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.data.datasource.PreviewDownloadRemoteDataSource;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapperKt;
import com.box.android.data.persistence.jobs.DomainErrorConverter;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MarkForOfflineJobDisplayInfoProvider;
import com.box.android.domain.models.MetricKeysParam;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.models.OfflineDomainError;
import com.box.android.domain.models.annotations.FileVersionIdModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileModelKt;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.observability.Gen204ItemStateKt;
import com.box.android.domain.preview.PreviewerTypeResolver;
import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IFileActivitiesService;
import com.box.android.domain.services.IFileWithRepresentationsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: MarkForOfflineJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u009b\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u009b\u0001\u009c\u0001B}\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u000e\u0010E\u001a\u00020FH\u0096@¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u000208H\u0002J\"\u0010K\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0L2\u0006\u0010M\u001a\u00020/H\u0087@¢\u0006\u0002\u0010NJ\u001a\u0010O\u001a\u00020I2\u0006\u0010M\u001a\u00020/2\b\b\u0002\u0010P\u001a\u00020IH\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020/H\u0002J2\u0010T\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0L2\u0006\u0010J\u001a\u0002082\u0006\u0010S\u001a\u00020/2\u0006\u0010U\u001a\u00020RH\u0082@¢\u0006\u0002\u0010VJ\"\u0010W\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0L2\u0006\u0010M\u001a\u00020/H\u0087@¢\u0006\u0002\u0010NJ\"\u0010X\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0L2\u0006\u0010M\u001a\u00020/H\u0087@¢\u0006\u0002\u0010NJ\u0016\u0010Y\u001a\u00020F2\u0006\u0010M\u001a\u00020/H\u0087@¢\u0006\u0002\u0010NJ\u0016\u0010Z\u001a\u00020F2\u0006\u0010M\u001a\u00020/H\u0087@¢\u0006\u0002\u0010NJ\u001c\u0010[\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0L2\u0006\u0010M\u001a\u00020/H\u0007J\u001c\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0L2\u0006\u0010M\u001a\u00020/H\u0007J\u0016\u0010]\u001a\u00020I2\u0006\u0010M\u001a\u00020/H\u0087@¢\u0006\u0002\u0010NJ\u0016\u0010^\u001a\u00020I2\u0006\u0010M\u001a\u00020/H\u0087@¢\u0006\u0002\u0010NJ&\u0010_\u001a\u00020F2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010aH\u0082@¢\u0006\u0002\u0010cJ\u001c\u0010d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0004\u0012\u00020>0LH\u0086@¢\u0006\u0002\u0010GJ\u0010\u0010e\u001a\u0002082\u0006\u0010f\u001a\u00020gH\u0007J\u001a\u0010h\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020>0LH\u0087@¢\u0006\u0002\u0010GJ,\u0010i\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020>0L2\u0006\u0010j\u001a\u00020k2\b\b\u0002\u0010l\u001a\u00020mH\u0087@¢\u0006\u0002\u0010nJ\u001c\u0010o\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0L2\u0006\u0010M\u001a\u00020/H\u0002J\u0016\u0010p\u001a\u00020F2\u0006\u0010q\u001a\u00020>H\u0082@¢\u0006\u0002\u0010rJ\u000e\u0010s\u001a\u00020FH\u0096@¢\u0006\u0002\u0010GJ\u000e\u0010t\u001a\u00020IH\u0096@¢\u0006\u0002\u0010GJ\u0010\u0010u\u001a\u00020g2\u0006\u0010J\u001a\u000208H\u0007J\u0016\u0010v\u001a\u00020F2\u0006\u0010w\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010xJ\u000e\u0010y\u001a\u00020FH\u0087@¢\u0006\u0002\u0010GJ\u0010\u0010z\u001a\u00020>2\u0006\u0010J\u001a\u000208H\u0007J\u0016\u0010{\u001a\u00020F2\u0006\u0010|\u001a\u00020kH\u0082@¢\u0006\u0002\u0010}J\u0016\u0010~\u001a\u00020F2\u0006\u0010M\u001a\u00020/H\u0082@¢\u0006\u0002\u0010NJ\u000e\u0010\u007f\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ \u0010\u0080\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0005\u0012\u00030\u0083\u00010\u0081\u00012\u0006\u0010J\u001a\u000208H\u0002JC\u0010\u0084\u0001\u001a\u00020F2\t\b\u0002\u0010\u0085\u0001\u001a\u00020I2&\u0010\u0086\u0001\u001a!\b\u0001\u0012\u0004\u0012\u000208\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020F0\u0088\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00010\u0087\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J!\u0010\u008a\u0001\u001a\u00020F2\u0006\u0010w\u001a\u00020\u00072\u0007\u0010\u008b\u0001\u001a\u00020>H\u0096@¢\u0006\u0003\u0010\u008c\u0001J,\u0010\u008d\u0001\u001a\u00020F2\u0006\u0010w\u001a\u00020\u00072\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0096@¢\u0006\u0003\u0010\u0091\u0001J!\u0010\u0092\u0001\u001a\u00020F2\u0006\u0010w\u001a\u00020\u00072\u0007\u0010\u0093\u0001\u001a\u00020gH\u0096@¢\u0006\u0003\u0010\u0094\u0001J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\t\u0010\u0097\u0001\u001a\u00020IH\u0016J\n\u0010\u0098\u0001\u001a\u00030\u0082\u0001H\u0016J\u001e\u0010\u0099\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0005\u0012\u00030\u0083\u00010\u009a\u0001H\u0096@¢\u0006\u0002\u0010GR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R?\u00106\u001a&\u0012\f\u0012\n 9*\u0004\u0018\u00010808 9*\u0012\u0012\f\u0012\n 9*\u0004\u0018\u00010808\u0018\u000107078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00105\u001a\u0004\b:\u0010;R&\u0010=\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006\u009d\u0001"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineJob;", "Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "moshi", "Lcom/squareup/moshi/Moshi;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "fileWithRepresentationsService", "Lcom/box/android/domain/services/IFileWithRepresentationsService;", "representationsService", "Lcom/box/android/domain/services/IRepresentationsService;", "previewerTypeResolver", "Lcom/box/android/domain/preview/PreviewerTypeResolver;", "previewDownloadRemoteDataSource", "Lcom/box/android/data/datasource/PreviewDownloadRemoteDataSource;", "annotationsService", "Lcom/box/android/domain/services/IAnnotationsService;", "fileActivitiesService", "Lcom/box/android/domain/services/IFileActivitiesService;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IFileWithRepresentationsService;Lcom/box/android/domain/services/IRepresentationsService;Lcom/box/android/domain/preview/PreviewerTypeResolver;Lcom/box/android/data/datasource/PreviewDownloadRemoteDataSource;Lcom/box/android/domain/services/IAnnotationsService;Lcom/box/android/domain/services/IFileActivitiesService;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getRemoteItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "cachedFileModel", "Lcom/box/android/domain/models/item/FileModel;", "userPrefs", "Landroid/content/SharedPreferences;", "getUserPrefs", "()Landroid/content/SharedPreferences;", "userPrefs$delegate", "Lkotlin/Lazy;", "runningInfoAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;", "kotlin.jvm.PlatformType", "getRunningInfoAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "runningInfoAdapter$delegate", "lastRecordError", "Lcom/box/android/domain/models/DomainError;", "getLastRecordError$annotations", "()V", "getLastRecordError", "()Lcom/box/android/domain/models/DomainError;", "setLastRecordError", "(Lcom/box/android/domain/models/DomainError;)V", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasDownloadsInProgress", "", "runningInfo", "enqueueOriginalFileDownloadIfNeeded", "Lcom/box/android/domain/utils/result/Result;", "fileModel", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasValidOfflineOriginalFile", "checkTempFile", "createTempFileForDownload", "Ljava/io/File;", "itemModel", "enqueueDownloadJob", "tempOfflineFile", "(Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;Lcom/box/android/domain/models/item/FileModel;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadPreviewIfNeeded", "downloadPreview", "fetchAnnotationsForOffline", "fetchFileActivitiesForOffline", "validatePreviewDownload", "validateBasicEligibility", "shouldDownloadPreview", "shouldDownloadOriginal", "updateDownloadStatuses", "downloadOriginalStatus", "Lcom/box/android/data/jobs/DownloadStatus;", "downloadPreviewStatus", "(Lcom/box/android/data/jobs/DownloadStatus;Lcom/box/android/data/jobs/DownloadStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRunningInfo", "byteArrayToRunningInfo", "byteArray", "", "initialRunningInfo", "getFileModel", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "policy", "Lcom/box/android/domain/configuration/DataPolicy;", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/configuration/DataPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameTempToTargetFile", "markNotOfflinedAndFailJob", "error", "(Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "runningInfoToByteArray", "childSucceeded", "childJobId", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCompletion", "determineUserFacingError", "setOfflineStatusOnJobCompletion", "remoteItemId", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileOfflineSavedIfNeeded", "updateLogDataFromRunningInfo", "buildLogDataMap", "", "", "", "updatingRunningInfo", "isLockNeeded", "updateRunningData", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "", "estimatedWork", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", BoxRepresentation.FIELD_INFO, "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "shouldDisplay", "getAmplitudeJobType", "getAmplitudeInfos", "", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkForOfflineJob implements ParentJob, DisplayableJob, MetricsInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IS_USER_OFFLINED = "isUserOfflined";
    public static final String REMOTE_ITEM_ID_PARAM = "remoteIdParam";
    public static final String TEMP_FILE_TAG = "temp";
    public static final String TRY_DOWNLOAD_ORIGINAL = "tryDownloadOriginal";
    private final IAnnotationsService annotationsService;
    private final Context appContext;
    private FileModel cachedFileModel;
    private final FeatureFlips featureFlips;
    private final IFileActivitiesService fileActivitiesService;
    private final IFileWithRepresentationsService fileWithRepresentationsService;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private DomainError lastRecordError;
    private final Moshi moshi;
    private final PreviewDownloadRemoteDataSource previewDownloadRemoteDataSource;
    private final PreviewerTypeResolver previewerTypeResolver;
    private final IRemoteItemService remoteItemService;
    private final IRepresentationsService representationsService;

    /* JADX INFO: renamed from: runningInfoAdapter$delegate, reason: from kotlin metadata */
    private final Lazy runningInfoAdapter;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: userPrefs$delegate, reason: from kotlin metadata */
    private final Lazy userPrefs;

    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/MarkForOfflineJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        MarkForOfflineJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadStatus.values().length];
            try {
                iArr[DownloadStatus.Successful.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadStatus.Failed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadStatus.NotNeeded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$checkCompletion$1, reason: invalid class name */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {1, 2, 3, 3, 3, 4, 4, 4, 4}, l = {681, 684, 686, 697, 700}, m = "checkCompletion", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningInfo", "previewSucceeded", "originalSucceeded", "runningInfo", "userFacingError", "previewSucceeded", "originalSucceeded"}, s = {"L$0", "L$0", "L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.checkCompletion(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$childFailed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 0, 1, 1}, l = {811, 820}, m = "childFailed", n = {"childJobId", "domainError", "childJobId", "domainError"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C13111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13111(Continuation<? super C13111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.childFailed(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 1}, l = {655, 676}, m = "childSucceeded", n = {"childJobId", "childJobId"}, s = {"L$0", "L$0"}, v = 1)
    static final class C13121 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13121(Continuation<? super C13121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.childSucceeded(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$downloadPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {282, 289, BoxRequestsFile.DownloadThumbnail.SIZE_320, 325, 335}, m = "downloadPreview", n = {"fileModel", "fileExtension", "isNonWatermarkedPdf", "fileModel", "fileExtension", "isNonWatermarkedPdf", "fileModel", "fileExtension", "representationsResult", "fileWithRepresentations", "previewerMappings", "representationModel", "isNonWatermarkedPdf", "fileModel", "fileExtension", "representationsResult", "fileWithRepresentations", "previewerMappings", "representationModel", "isNonWatermarkedPdf", "fileModel", "fileExtension", "representationsResult", "fileWithRepresentations", "previewerMappings", "representationModel", "previewContentType", "isNonWatermarkedPdf"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 1)
    static final class C13141 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C13141(Continuation<? super C13141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.downloadPreview(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$downloadPreviewIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 1, 2, 2, 3, 3}, l = {248, 250, 256, 261}, m = "downloadPreviewIfNeeded", n = {"fileModel", "fileModel", "fileModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "fileModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C13151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13151(Continuation<? super C13151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.downloadPreviewIfNeeded(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$enqueueDownloadJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {236, 242}, m = "enqueueDownloadJob", n = {"runningInfo", "itemModel", "tempOfflineFile", "downloadRequest", "runningInfo", "itemModel", "tempOfflineFile", "downloadRequest", "$this$map$iv", "it", "updatedRunningInfo", "$i$f$map", "$i$a$-map-MarkForOfflineJob$enqueueDownloadJob$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C13171 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C13171(Continuation<? super C13171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.enqueueDownloadJob(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$enqueueOriginalFileDownloadIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 1, 1, 1}, l = {191, 197}, m = "enqueueOriginalFileDownloadIfNeeded", n = {"fileModel", "fileModel", "runningInfo", "tempOfflineFile"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
    static final class C13181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13181(Continuation<? super C13181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.enqueueOriginalFileDownloadIfNeeded(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$fetchAnnotationsForOffline$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 0, 0, 0}, l = {357}, m = "fetchAnnotationsForOffline", n = {"fileModel", "fileVersionId", "fileId", "fileVersionIdModel"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C13191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13191(Continuation<? super C13191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.fetchAnnotationsForOffline(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$fetchFileActivitiesForOffline$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 0}, l = {366}, m = "fetchFileActivitiesForOffline", n = {"fileModel", "remoteId"}, s = {"L$0", "L$1"}, v = 1)
    static final class C13201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13201(Continuation<? super C13201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.fetchFileActivitiesForOffline(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$getAmplitudeInfos$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0}, l = {847}, m = "getAmplitudeInfos", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class C13211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13211(Continuation<? super C13211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.getAmplitudeInfos(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$getFileModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 0}, l = {601}, m = "getFileModel", n = {"remoteId", "policy"}, s = {"L$0", "L$1"}, v = 1)
    static final class C13221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13221(Continuation<? super C13221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.getFileModel(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$getRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {}, l = {546}, m = "getRunningInfo", n = {}, s = {}, v = 1)
    static final class C13231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C13231(Continuation<? super C13231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.getRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$initialRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 1, 1, 2, 2, 2}, l = {566, 573, 583}, m = "initialRunningInfo", n = {"remoteItemId", "remoteItemId", "itemModel", "remoteItemId", "itemModel", "newRunningInfo"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C13241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13241(Continuation<? super C13241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.initialRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$markNotOfflinedAndFailJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 3}, l = {633, 634, 635, 642}, m = "markNotOfflinedAndFailJob", n = {"error", "error", "runningInfo", "$i$a$-let-MarkForOfflineJob$markNotOfflinedAndFailJob$2", "error", "runningInfo", "fileModel", "$i$a$-let-MarkForOfflineJob$markNotOfflinedAndFailJob$2", "$i$a$-let-MarkForOfflineJob$markNotOfflinedAndFailJob$2$1", "error"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0"}, v = 1)
    static final class C13251 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13251(Continuation<? super C13251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.markNotOfflinedAndFailJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$setOfflineStatusOnJobCompletion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {731, 733, 734, 735, 738}, m = "setOfflineStatusOnJobCompletion", n = {"remoteItemId", "remoteItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "remoteItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "remoteItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "remoteItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C13261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13261(Continuation<? super C13261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.setOfflineStatusOnJobCompletion(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadOriginal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8}, l = {472, 475, 482, 501, 502, 510, 518, 524, 528}, m = "shouldDownloadOriginal", n = {"fileModel", "fileModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$shouldDownloadOriginal_u24lambda_u240", "$i$a$-run-MarkForOfflineJob$shouldDownloadOriginal$runningInfo$1", "fileModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "fileModel", "runningInfo", "previewFailed", "previewSucceeded", "requestedOriginal", "isOriginalFilePreviewable", "fileModel", "runningInfo", "previewFailed", "previewSucceeded", "requestedOriginal", "isOriginalFilePreviewable", "fileModel", "runningInfo", "previewFailed", "previewSucceeded", "requestedOriginal", "isOriginalFilePreviewable", "hasDownloadPermission", "fileModel", "runningInfo", "previewFailed", "previewSucceeded", "requestedOriginal", "isOriginalFilePreviewable", "hasDownloadPermission", "shouldDownload", "fileModel", "runningInfo", "previewFailed", "previewSucceeded", "requestedOriginal", "isOriginalFilePreviewable", "hasDownloadPermission", "shouldDownload", "fileModel", "runningInfo", "previewFailed", "previewSucceeded", "requestedOriginal", "isOriginalFilePreviewable", "hasDownloadPermission", "shouldDownload"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "I$0", "I$1", "Z$0", "Z$1", "L$0", "L$1", "I$0", "I$1", "Z$0", "Z$1", "L$0", "L$1", "I$0", "I$1", "Z$0", "Z$1", "I$2", "L$0", "L$1", "I$0", "I$1", "Z$0", "Z$1", "I$2", "I$3", "L$0", "L$1", "I$0", "I$1", "Z$0", "Z$1", "I$2", "I$3", "L$0", "L$1", "I$0", "I$1", "Z$0", "Z$1", "I$2", "I$3"}, v = 1)
    static final class C13271 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C13271(Continuation<? super C13271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.shouldDownloadOriginal(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {0, 0, 1, 1}, l = {447, 458}, m = "shouldDownloadPreview", n = {"fileModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "fileModel", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C13281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13281(Continuation<? super C13281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.shouldDownloadPreview(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {2, 3, 3, 4, 5, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 18}, l = {123, 124, 125, 130, 136, Token.SETELEM_OP, Token.SET_REF_OP, 150, Token.SETCONST, Token.GENEXPR, Token.METHOD, Token.LAST_TOKEN, 168, external.sdk.pendo.io.mozilla.javascript.Context.VERSION_1_7, 171, 174, 179, 180, 182}, m = "start", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "initResult", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningInfo", "runningInfo", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningInfo", "fileModel", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-MarkForOfflineJob$start$2", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "$this$onError$iv", "it", "isUserOfflined", "$i$f$onError", "$i$a$-onError-MarkForOfflineJob$start$3", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "isUserOfflined", "runningInfo", "fileModel", "updatedRunningInfo", "isUserOfflined"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 1)
    static final class C13301 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C13301(Continuation<? super C13301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.start(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$updateLogDataFromRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob", f = "MarkForOfflineJob.kt", i = {1, 1, 1}, l = {754, 756}, m = "updateLogDataFromRunningInfo", n = {"runningInfo", "logDataMap", "$i$a$-let-MarkForOfflineJob$updateLogDataFromRunningInfo$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C13321 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13321(Continuation<? super C13321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJob.this.updateLogDataFromRunningInfo(this);
        }
    }

    public static /* synthetic */ void getLastRecordError$annotations() {
    }

    @AssistedInject
    public MarkForOfflineJob(Moshi moshi, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService, IRemoteItemService remoteItemService, IUserContextManager userContextManager, IFileWithRepresentationsService fileWithRepresentationsService, IRepresentationsService representationsService, PreviewerTypeResolver previewerTypeResolver, PreviewDownloadRemoteDataSource previewDownloadRemoteDataSource, IAnnotationsService annotationsService, IFileActivitiesService fileActivitiesService, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(fileWithRepresentationsService, "fileWithRepresentationsService");
        Intrinsics.checkNotNullParameter(representationsService, "representationsService");
        Intrinsics.checkNotNullParameter(previewerTypeResolver, "previewerTypeResolver");
        Intrinsics.checkNotNullParameter(previewDownloadRemoteDataSource, "previewDownloadRemoteDataSource");
        Intrinsics.checkNotNullParameter(annotationsService, "annotationsService");
        Intrinsics.checkNotNullParameter(fileActivitiesService, "fileActivitiesService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.moshi = moshi;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.remoteItemService = remoteItemService;
        this.userContextManager = userContextManager;
        this.fileWithRepresentationsService = fileWithRepresentationsService;
        this.representationsService = representationsService;
        this.previewerTypeResolver = previewerTypeResolver;
        this.previewDownloadRemoteDataSource = previewDownloadRemoteDataSource;
        this.annotationsService = annotationsService;
        this.fileActivitiesService = fileActivitiesService;
        this.featureFlips = featureFlips;
        this.userPrefs = LazyKt.lazy(new Function0() { // from class: com.box.android.data.jobs.MarkForOfflineJob$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MarkForOfflineJob.userPrefs_delegate$lambda$0(this.f$0);
            }
        });
        this.runningInfoAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.jobs.MarkForOfflineJob$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MarkForOfflineJob.runningInfoAdapter_delegate$lambda$0(this.f$0);
            }
        });
    }

    @Override // com.box.android.data.jobs.Job
    public /* bridge */ Object run(JobEntity jobEntity, Continuation<? super Unit> continuation) {
        return super.run(jobEntity, continuation);
    }

    public final JobId getJobId() {
        return this.jobId;
    }

    public final Data getInputData() {
        return this.inputData;
    }

    @Override // com.box.android.data.jobs.Job
    public Context getAppContext() {
        return this.appContext;
    }

    @Override // com.box.android.data.jobs.Job
    public JobService getJobService() {
        return this.jobService;
    }

    public final IRemoteItemService getRemoteItemService() {
        return this.remoteItemService;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    private final SharedPreferences getUserPrefs() {
        Object value = this.userPrefs.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences userPrefs_delegate$lambda$0(MarkForOfflineJob markForOfflineJob) {
        return markForOfflineJob.userContextManager.getUserSharedPrefs();
    }

    private final JsonAdapter<MarkForOfflineRunningInfo> getRunningInfoAdapter() {
        return (JsonAdapter) this.runningInfoAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter runningInfoAdapter_delegate$lambda$0(MarkForOfflineJob markForOfflineJob) {
        DomainErrorConverter.Companion companion = DomainErrorConverter.INSTANCE;
        Moshi.Builder builderNewBuilder = markForOfflineJob.moshi.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        return companion.appendTo(builderNewBuilder).build().adapter(MarkForOfflineRunningInfo.class);
    }

    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineJob$Companion;", "", "<init>", "()V", "TRY_DOWNLOAD_ORIGINAL", "", "REMOTE_ITEM_ID_PARAM", "IS_USER_OFFLINED", "TEMP_FILE_TAG", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "remoteItemId", "Lcom/box/android/domain/models/ItemId$Remote;", "tags", "", "downloadOriginal", "", "isUserOfflined", JobConstants.SHOW_NOTIFICATION, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId.Remote remote, Set set, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getRequest(remote, set, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? true : z3);
        }

        public final JobRequest getRequest(ItemId.Remote remoteItemId, Set<String> tags, boolean downloadOriginal, boolean isUserOfflined, boolean showNotification) {
            Intrinsics.checkNotNullParameter(remoteItemId, "remoteItemId");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.MARK_FOR_OFFLINE, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString("remoteIdParam", remoteItemId.toString());
            builder2.putBoolean("tryDownloadOriginal", downloadOriginal);
            builder2.putBoolean(JobConstants.SHOULD_DISPLAY_JOB, isUserOfflined);
            builder2.putBoolean("isUserOfflined", isUserOfflined);
            builder2.putBoolean(JobConstants.SHOW_NOTIFICATION, showNotification);
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("mark_offline:" + remoteItemId), (Iterable) tags));
            return builder.build();
        }
    }

    public final DomainError getLastRecordError() {
        return this.lastRecordError;
    }

    public final void setLastRecordError(DomainError domainError) {
        this.lastRecordError = domainError;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0323  */
    /* JADX WARN: Code duplicated, block: B:105:0x0327  */
    /* JADX WARN: Code duplicated, block: B:109:0x0378  */
    /* JADX WARN: Code duplicated, block: B:111:0x037e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0381 A[PHI: r1 r2 r3
      0x0381: PHI (r1v46 boolean) = (r1v33 boolean), (r1v49 boolean) binds: [B:97:0x0301, B:15:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0381: PHI (r2v37 com.box.android.domain.models.item.FileModel) = (r2v27 com.box.android.domain.models.item.FileModel), (r2v43 com.box.android.domain.models.item.FileModel) binds: [B:97:0x0301, B:15:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0381: PHI (r3v37 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v23 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v39 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:97:0x0301, B:15:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:116:0x03a2 A[PHI: r1 r2 r3 r4 r5
      0x03a2: PHI (r1v50 boolean) = (r1v45 boolean), (r1v51 boolean) binds: [B:114:0x039e, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x03a2: PHI (r2v44 com.box.android.domain.models.item.FileModel) = (r2v36 com.box.android.domain.models.item.FileModel), (r2v46 com.box.android.domain.models.item.FileModel) binds: [B:114:0x039e, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x03a2: PHI (r3v40 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v36 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v42 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:114:0x039e, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x03a2: PHI (r4v8 com.box.android.data.jobs.MarkForOfflineJob) = (r4v6 com.box.android.data.jobs.MarkForOfflineJob), (r4v9 com.box.android.data.jobs.MarkForOfflineJob) binds: [B:114:0x039e, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x03a2: PHI (r5v14 com.box.android.data.jobs.MarkForOfflineJob$start$1) = 
      (r5v12 com.box.android.data.jobs.MarkForOfflineJob$start$1)
      (r5v15 com.box.android.data.jobs.MarkForOfflineJob$start$1)
     binds: [B:114:0x039e, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:119:0x03bc A[PHI: r1 r2 r3 r4 r5 r12
      0x03bc: PHI (r1v52 boolean) = (r1v50 boolean), (r1v53 boolean) binds: [B:117:0x03b8, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x03bc: PHI (r2v47 com.box.android.domain.models.item.FileModel) = (r2v44 com.box.android.domain.models.item.FileModel), (r2v50 com.box.android.domain.models.item.FileModel) binds: [B:117:0x03b8, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x03bc: PHI (r3v43 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v40 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v46 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:117:0x03b8, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x03bc: PHI (r4v10 com.box.android.data.jobs.MarkForOfflineJob) = (r4v8 com.box.android.data.jobs.MarkForOfflineJob), (r4v12 com.box.android.data.jobs.MarkForOfflineJob) binds: [B:117:0x03b8, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x03bc: PHI (r5v16 com.box.android.data.jobs.MarkForOfflineJob$start$1) = 
      (r5v14 com.box.android.data.jobs.MarkForOfflineJob$start$1)
      (r5v17 com.box.android.data.jobs.MarkForOfflineJob$start$1)
     binds: [B:117:0x03b8, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x03bc: PHI (r12v70 java.lang.Object) = (r12v69 java.lang.Object), (r12v1 java.lang.Object) binds: [B:117:0x03b8, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:121:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:130:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:132:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:137:0x041f  */
    /* JADX WARN: Code duplicated, block: B:139:0x0425  */
    /* JADX WARN: Code duplicated, block: B:141:0x042b  */
    /* JADX WARN: Code duplicated, block: B:146:0x0450  */
    /* JADX WARN: Code duplicated, block: B:17:0x008c A[PHI: r1 r2 r3 r12
      0x008c: PHI (r1v35 boolean) = (r1v33 boolean), (r1v44 boolean) binds: [B:99:0x0319, B:16:0x007f] A[DONT_GENERATE, DONT_INLINE]
      0x008c: PHI (r2v30 com.box.android.domain.models.item.FileModel) = (r2v27 com.box.android.domain.models.item.FileModel), (r2v35 com.box.android.domain.models.item.FileModel) binds: [B:99:0x0319, B:16:0x007f] A[DONT_GENERATE, DONT_INLINE]
      0x008c: PHI (r3v26 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v23 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v35 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:99:0x0319, B:16:0x007f] A[DONT_GENERATE, DONT_INLINE]
      0x008c: PHI (r12v65 java.lang.Object) = (r12v64 java.lang.Object), (r12v1 java.lang.Object) binds: [B:99:0x0319, B:16:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x0165 A[PHI: r12
      0x0165: PHI (r12v6 java.lang.Object) = (r12v5 java.lang.Object), (r12v1 java.lang.Object) binds: [B:36:0x0161, B:30:0x0139] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x016c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0177  */
    /* JADX WARN: Code duplicated, block: B:45:0x0188 A[PHI: r1 r12
      0x0188: PHI (r1v7 com.box.android.domain.utils.result.Result) = (r1v4 com.box.android.domain.utils.result.Result), (r1v10 com.box.android.domain.utils.result.Result) binds: [B:43:0x0184, B:29:0x0131] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r12v20 java.lang.Object) = (r12v17 java.lang.Object), (r12v1 java.lang.Object) binds: [B:43:0x0184, B:29:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x018e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0197  */
    /* JADX WARN: Code duplicated, block: B:50:0x019b  */
    /* JADX WARN: Code duplicated, block: B:55:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:57:0x01cd A[PHI: r12
      0x01cd: PHI (r12v18 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r12v14 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r12v26 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:41:0x0175, B:47:0x018e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:60:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:65:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:67:0x0201  */
    /* JADX WARN: Code duplicated, block: B:72:0x024b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0251  */
    /* JADX WARN: Code duplicated, block: B:76:0x025b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0285 A[PHI: r1 r2 r3
      0x0285: PHI (r1v23 boolean) = (r1v15 boolean), (r1v15 boolean), (r1v24 boolean) binds: [B:75:0x0259, B:77:0x0281, B:23:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x0285: PHI (r2v12 com.box.android.domain.models.item.FileModel) = 
      (r2v10 com.box.android.domain.models.item.FileModel)
      (r2v10 com.box.android.domain.models.item.FileModel)
      (r2v14 com.box.android.domain.models.item.FileModel)
     binds: [B:75:0x0259, B:77:0x0281, B:23:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x0285: PHI (r3v8 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v5 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v5 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v10 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:75:0x0259, B:77:0x0281, B:23:0x00dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:82:0x029b A[PHI: r1 r2 r3 r12
      0x029b: PHI (r1v25 boolean) = (r1v23 boolean), (r1v26 boolean) binds: [B:80:0x0297, B:22:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x029b: PHI (r2v15 com.box.android.domain.models.item.FileModel) = (r2v12 com.box.android.domain.models.item.FileModel), (r2v17 com.box.android.domain.models.item.FileModel) binds: [B:80:0x0297, B:22:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x029b: PHI (r3v11 com.box.android.data.jobs.MarkForOfflineRunningInfo) = (r3v8 com.box.android.data.jobs.MarkForOfflineRunningInfo), (r3v13 com.box.android.data.jobs.MarkForOfflineRunningInfo) binds: [B:80:0x0297, B:22:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x029b: PHI (r12v43 java.lang.Object) = (r12v42 java.lang.Object), (r12v1 java.lang.Object) binds: [B:80:0x0297, B:22:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:84:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:87:0x02b9 A[PHI: r1 r2 r3
      0x02b9: PHI (r1v27 boolean) = (r1v25 boolean), (r1v25 boolean), (r1v28 boolean) binds: [B:83:0x02a1, B:85:0x02b5, B:21:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x02b9: PHI (r2v18 com.box.android.domain.models.item.FileModel) = 
      (r2v15 com.box.android.domain.models.item.FileModel)
      (r2v15 com.box.android.domain.models.item.FileModel)
      (r2v20 com.box.android.domain.models.item.FileModel)
     binds: [B:83:0x02a1, B:85:0x02b5, B:21:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x02b9: PHI (r3v14 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v11 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v11 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v16 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:83:0x02a1, B:85:0x02b5, B:21:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:90:0x02cf A[PHI: r1 r2 r3
      0x02cf: PHI (r1v29 boolean) = (r1v27 boolean), (r1v30 boolean) binds: [B:88:0x02cb, B:20:0x00af] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r2v21 com.box.android.domain.models.item.FileModel) = (r2v18 com.box.android.domain.models.item.FileModel), (r2v23 com.box.android.domain.models.item.FileModel) binds: [B:88:0x02cb, B:20:0x00af] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r3v17 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v14 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v19 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:88:0x02cb, B:20:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x02e5 A[PHI: r1 r2 r3
      0x02e5: PHI (r1v31 boolean) = (r1v29 boolean), (r1v32 boolean) binds: [B:91:0x02e1, B:19:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x02e5: PHI (r2v24 com.box.android.domain.models.item.FileModel) = (r2v21 com.box.android.domain.models.item.FileModel), (r2v26 com.box.android.domain.models.item.FileModel) binds: [B:91:0x02e1, B:19:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x02e5: PHI (r3v20 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v17 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v22 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:91:0x02e1, B:19:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x02fb A[PHI: r1 r2 r3 r12
      0x02fb: PHI (r1v33 boolean) = (r1v31 boolean), (r1v34 boolean) binds: [B:94:0x02f7, B:18:0x0091] A[DONT_GENERATE, DONT_INLINE]
      0x02fb: PHI (r2v27 com.box.android.domain.models.item.FileModel) = (r2v24 com.box.android.domain.models.item.FileModel), (r2v29 com.box.android.domain.models.item.FileModel) binds: [B:94:0x02f7, B:18:0x0091] A[DONT_GENERATE, DONT_INLINE]
      0x02fb: PHI (r3v23 com.box.android.data.jobs.MarkForOfflineRunningInfo) = 
      (r3v20 com.box.android.data.jobs.MarkForOfflineRunningInfo)
      (r3v25 com.box.android.data.jobs.MarkForOfflineRunningInfo)
     binds: [B:94:0x02f7, B:18:0x0091] A[DONT_GENERATE, DONT_INLINE]
      0x02fb: PHI (r12v58 java.lang.Object) = (r12v57 java.lang.Object), (r12v1 java.lang.Object) binds: [B:94:0x02f7, B:18:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x0303  */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0370, code lost:
    
        if (r11 == r0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x03ee, code lost:
    
        if (r12.waitForChildren(r4, r5) == r0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0419, code lost:
    
        if (markNotOfflinedAndFailJob(r11, r4) == r0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x044a, code lost:
    
        if (markNotOfflinedAndFailJob(r11, r4) == r0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01c0, code lost:
    
        if (markNotOfflinedAndFailJob(r2, r4) == r0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0244, code lost:
    
        if (markNotOfflinedAndFailJob(r1, r4) == r0) goto L143;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean hasDownloadsInProgress(MarkForOfflineRunningInfo runningInfo) {
        return runningInfo.isOriginalDownloadInProgress() || runningInfo.getDownloadPreviewStatus() == DownloadStatus.InProgress;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object enqueueOriginalFileDownloadIfNeeded(FileModel fileModel, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C13181 c13181;
        if (continuation instanceof C13181) {
            c13181 = (C13181) continuation;
            if ((c13181.label & Integer.MIN_VALUE) != 0) {
                c13181.label -= Integer.MIN_VALUE;
            } else {
                c13181 = new C13181(continuation);
            }
        } else {
            c13181 = new C13181(continuation);
        }
        Object runningInfo = c13181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13181.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            c13181.L$0 = fileModel;
            c13181.label = 1;
            runningInfo = getRunningInfo(c13181);
            if (runningInfo != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(runningInfo);
            return runningInfo;
        }
        fileModel = (FileModel) c13181.L$0;
        ResultKt.throwOnFailure(runningInfo);
        Result result = (Result) runningInfo;
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
        MarkForOfflineRunningInfo markForOfflineRunningInfo = (MarkForOfflineRunningInfo) ((Result.Success) result).getValue();
        if (markForOfflineRunningInfo == null) {
            return new Result.Error(new OfflineDomainError.RunningInfoNotAvailable(null, 1, null));
        }
        File fileCreateTempFileForDownload = createTempFileForDownload(fileModel);
        c13181.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
        c13181.L$1 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfo);
        c13181.L$2 = SpillingKt.nullOutSpilledVariable(fileCreateTempFileForDownload);
        c13181.label = 2;
        Object objEnqueueDownloadJob = enqueueDownloadJob(markForOfflineRunningInfo, fileModel, fileCreateTempFileForDownload, c13181);
        return objEnqueueDownloadJob == coroutine_suspended ? coroutine_suspended : objEnqueueDownloadJob;
    }

    static /* synthetic */ boolean hasValidOfflineOriginalFile$default(MarkForOfflineJob markForOfflineJob, FileModel fileModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return markForOfflineJob.hasValidOfflineOriginalFile(fileModel, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasValidOfflineOriginalFile(FileModel fileModel, boolean checkTempFile) {
        BoxItem boxItem = ItemModelMapper.INSTANCE.toBoxItem(fileModel, true);
        Intrinsics.checkNotNull(boxItem, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
        BoxFile boxFile = (BoxFile) boxItem;
        File offlineFile = this.userContextManager.getPreviewStorage().getOfflineFile(boxFile, checkTempFile ? "temp" : null);
        if (!offlineFile.exists()) {
            return false;
        }
        Intrinsics.checkNotNull(offlineFile);
        return Intrinsics.areEqual(FileExtensionsKt.computeFileSha1(offlineFile), boxFile.getSha1());
    }

    private final File createTempFileForDownload(FileModel itemModel) {
        BoxItem boxItem = ItemModelMapper.INSTANCE.toBoxItem(itemModel, true);
        Intrinsics.checkNotNull(boxItem, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
        File offlineFile = this.userContextManager.getPreviewStorage().getOfflineFile((BoxFile) boxItem, "temp");
        if (offlineFile.exists()) {
            offlineFile.delete();
        }
        Intrinsics.checkNotNull(offlineFile);
        return offlineFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0152, code lost:
    
        if (r9.updateRunningInfo(r12, r0, r7) == r2) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object enqueueDownloadJob(com.box.android.data.jobs.MarkForOfflineRunningInfo r21, com.box.android.domain.models.item.FileModel r22, java.io.File r23, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r24) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.enqueueDownloadJob(com.box.android.data.jobs.MarkForOfflineRunningInfo, com.box.android.domain.models.item.FileModel, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadPreviewIfNeeded(FileModel fileModel, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C13151 c13151;
        MarkForOfflineJob markForOfflineJob;
        Result result;
        C13162 c13162;
        DownloadStatus downloadStatus;
        if (continuation instanceof C13151) {
            c13151 = (C13151) continuation;
            if ((c13151.label & Integer.MIN_VALUE) != 0) {
                c13151.label -= Integer.MIN_VALUE;
            } else {
                c13151 = new C13151(continuation);
            }
        } else {
            c13151 = new C13151(continuation);
        }
        C13151 c13152 = c13151;
        Object objDownloadPreview = c13152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13152.label;
        if (i != 0) {
            if (i == 1) {
                fileModel = (FileModel) c13152.L$0;
                ResultKt.throwOnFailure(objDownloadPreview);
                markForOfflineJob = this;
            } else {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result result2 = (Result) c13152.L$1;
                    ResultKt.throwOnFailure(objDownloadPreview);
                    return result2;
                }
                fileModel = (FileModel) c13152.L$0;
                ResultKt.throwOnFailure(objDownloadPreview);
                markForOfflineJob = this;
            }
            result = (Result) objDownloadPreview;
            if (result instanceof Result.Success) {
                BoxLogUtils.d(ExtensionsKt.getTAG(markForOfflineJob), "Preview download succeeded");
                downloadStatus = DownloadStatus.Successful;
                c13152.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
                c13152.L$1 = result;
                c13152.label = 3;
                if (updateDownloadStatuses$default(markForOfflineJob, null, downloadStatus, c13152, 1, null) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            }
            if (result instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.d(ExtensionsKt.getTAG(markForOfflineJob), "Preview download failed: " + ((Result.Error) result).getValue());
            c13162 = new C13162(result, markForOfflineJob, null);
            c13152.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c13152.L$1 = result;
            c13152.label = 4;
            if (updatingRunningInfo$default(markForOfflineJob, false, c13162, c13152, 1, null) != coroutine_suspended) {
                return coroutine_suspended;
            }
            return result;
        }
        ResultKt.throwOnFailure(objDownloadPreview);
        DownloadStatus downloadStatus2 = DownloadStatus.InProgress;
        c13152.L$0 = fileModel;
        c13152.label = 1;
        markForOfflineJob = this;
        if (updateDownloadStatuses$default(markForOfflineJob, null, downloadStatus2, c13152, 1, null) != coroutine_suspended) {
        }
        return coroutine_suspended;
        c13152.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
        c13152.label = 2;
        objDownloadPreview = markForOfflineJob.downloadPreview(fileModel, c13152);
        if (objDownloadPreview != coroutine_suspended) {
            result = (Result) objDownloadPreview;
            if (result instanceof Result.Success) {
                BoxLogUtils.d(ExtensionsKt.getTAG(markForOfflineJob), "Preview download succeeded");
                downloadStatus = DownloadStatus.Successful;
                c13152.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
                c13152.L$1 = result;
                c13152.label = 3;
                if (updateDownloadStatuses$default(markForOfflineJob, null, downloadStatus, c13152, 1, null) != coroutine_suspended) {
                    return result;
                }
            } else {
                if (result instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.d(ExtensionsKt.getTAG(markForOfflineJob), "Preview download failed: " + ((Result.Error) result).getValue());
                c13162 = new C13162(result, markForOfflineJob, null);
                c13152.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
                c13152.L$1 = result;
                c13152.label = 4;
                if (updatingRunningInfo$default(markForOfflineJob, false, c13162, c13152, 1, null) != coroutine_suspended) {
                    return result;
                }
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$downloadPreviewIfNeeded$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", BoxRepresentation.FIELD_INFO, "Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob$downloadPreviewIfNeeded$2", f = "MarkForOfflineJob.kt", i = {0, 0}, l = {266}, m = "invokeSuspend", n = {BoxRepresentation.FIELD_INFO, "updatedInfo"}, s = {"L$0", "L$1"}, v = 1)
    static final class C13162 extends SuspendLambda implements Function2<MarkForOfflineRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ Result<Unit, DomainError> $result;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MarkForOfflineJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13162(Result<Unit, ? extends DomainError> result, MarkForOfflineJob markForOfflineJob, Continuation<? super C13162> continuation) {
            super(2, continuation);
            this.$result = result;
            this.this$0 = markForOfflineJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13162 c13162 = new C13162(this.$result, this.this$0, continuation);
            c13162.L$0 = obj;
            return c13162;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineRunningInfo markForOfflineRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13162) create(markForOfflineRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MarkForOfflineRunningInfo markForOfflineRunningInfo = (MarkForOfflineRunningInfo) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MarkForOfflineRunningInfo markForOfflineRunningInfoCopy$default = MarkForOfflineRunningInfo.copy$default(markForOfflineRunningInfo, null, null, null, DownloadStatus.Failed, null, (DomainError) ((Result.Error) this.$result).getValue(), 23, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfo);
                this.L$1 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfoCopy$default);
                this.label = 1;
                if (this.this$0.getJobService().updateRunningInfo(this.this$0.runningInfoToByteArray(markForOfflineRunningInfoCopy$default), this.this$0.getJobId(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0295  */
    /* JADX WARN: Code duplicated, block: B:102:0x0299  */
    /* JADX WARN: Code duplicated, block: B:104:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:106:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x016d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0171  */
    /* JADX WARN: Code duplicated, block: B:60:0x0175  */
    /* JADX WARN: Code duplicated, block: B:62:0x018a  */
    /* JADX WARN: Code duplicated, block: B:64:0x018e  */
    /* JADX WARN: Code duplicated, block: B:68:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01de  */
    /* JADX WARN: Code duplicated, block: B:85:0x0208  */
    /* JADX WARN: Code duplicated, block: B:88:0x0216  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0247  */
    /* JADX WARN: Code duplicated, block: B:96:0x024f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0294 A[RETURN] */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0102, code lost:
    
        if (r2 == r4) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object downloadPreview(com.box.android.domain.models.item.FileModel r18, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r19) {
        /*
            Method dump skipped, instruction units count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.downloadPreview(com.box.android.domain.models.item.FileModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchAnnotationsForOffline(FileModel fileModel, Continuation<? super Unit> continuation) {
        C13191 c13191;
        String id;
        String boxId;
        if (continuation instanceof C13191) {
            c13191 = (C13191) continuation;
            if ((c13191.label & Integer.MIN_VALUE) != 0) {
                c13191.label -= Integer.MIN_VALUE;
            } else {
                c13191 = new C13191(continuation);
            }
        } else {
            c13191 = new C13191(continuation);
        }
        Object objFetchAnnotationsFromRemote = c13191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchAnnotationsFromRemote);
            if (!this.featureFlips.getViewAnnotations().getEnabled()) {
                BoxLogUtils.d(ExtensionsKt.getTAG(this), "Skipping annotation offline fetch - feature disabled");
                return Unit.INSTANCE;
            }
            PermissionsModel permissions = fileModel.getPermissions();
            if (permissions == null || !permissions.getCanViewAnnotations()) {
                BoxLogUtils.d(ExtensionsKt.getTAG(this), "Skipping annotation offline fetch - no view permission");
                return Unit.INSTANCE;
            }
            FileVersionMiniModel fileVersion = fileModel.getFileVersion();
            if (fileVersion == null || (id = fileVersion.getId()) == null) {
                BoxLogUtils.d(ExtensionsKt.getTAG(this), "Skipping annotation offline fetch - no file version ID");
                return Unit.INSTANCE;
            }
            ItemId itemId = fileModel.getItemId();
            ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
            if (remote == null || (boxId = remote.getBoxId()) == null) {
                BoxLogUtils.d(ExtensionsKt.getTAG(this), "Skipping annotation offline fetch - no remote file ID");
                return Unit.INSTANCE;
            }
            FileVersionIdModel fileVersionIdModel = new FileVersionIdModel(id, boxId);
            IAnnotationsService iAnnotationsService = this.annotationsService;
            c13191.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c13191.L$1 = SpillingKt.nullOutSpilledVariable(id);
            c13191.L$2 = SpillingKt.nullOutSpilledVariable(boxId);
            c13191.L$3 = SpillingKt.nullOutSpilledVariable(fileVersionIdModel);
            c13191.label = 1;
            objFetchAnnotationsFromRemote = iAnnotationsService.fetchAnnotationsFromRemote(fileVersionIdModel, c13191);
            if (objFetchAnnotationsFromRemote == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetchAnnotationsFromRemote);
        }
        Result result = (Result) objFetchAnnotationsFromRemote;
        if (result instanceof Result.Success) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Annotations cached for offline");
        } else {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Failed to cache annotations for offline: " + ((Result.Error) result).getValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchFileActivitiesForOffline(FileModel fileModel, Continuation<? super Unit> continuation) {
        C13201 c13201;
        if (continuation instanceof C13201) {
            c13201 = (C13201) continuation;
            if ((c13201.label & Integer.MIN_VALUE) != 0) {
                c13201.label -= Integer.MIN_VALUE;
            } else {
                c13201 = new C13201(continuation);
            }
        } else {
            c13201 = new C13201(continuation);
        }
        Object objFetchActivitiesFromRemote = c13201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13201.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchActivitiesFromRemote);
            ItemId itemId = fileModel.getItemId();
            ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
            if (remote == null) {
                return Unit.INSTANCE;
            }
            c13201.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c13201.L$1 = SpillingKt.nullOutSpilledVariable(remote);
            c13201.label = 1;
            objFetchActivitiesFromRemote = this.fileActivitiesService.fetchActivitiesFromRemote(remote, c13201);
            if (objFetchActivitiesFromRemote == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetchActivitiesFromRemote);
        }
        Result result = (Result) objFetchActivitiesFromRemote;
        if (result instanceof Result.Success) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "File activities cached for offline");
        } else {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Failed to cache file activities for offline: " + ((Result.Error) result).getValue());
        }
        return Unit.INSTANCE;
    }

    public final Result<Unit, DomainError> validatePreviewDownload(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        String extension = fileModel.getExtension();
        PermissionsModel permissions = fileModel.getPermissions();
        if (permissions == null || !permissions.getCanPreview()) {
            return new Result.Error(new OfflineDomainError.NoPreviewPermission(null, 1, null));
        }
        PermissionsModel permissions2 = fileModel.getPermissions();
        if ((permissions2 == null || !permissions2.getCanDownload()) && !BoxAccountManager.isMobilePreviewOnlyOffliningEnabled(getUserPrefs())) {
            return new Result.Error(new AdminSettingsDomainError.PreviewOnlyOffliningDisabled(null, 1, null));
        }
        if (!SupportedFileExtensions.INSTANCE.isSupportedExtension(extension)) {
            return new Result.Error(new OfflineDomainError.UnsupportedFileExtensionForPreview("." + extension));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    public final Result<Unit, DomainError> validateBasicEligibility(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        String extension = fileModel.getExtension();
        if (FileModelKt.isWatermarkedVideo(fileModel)) {
            return new Result.Error(new OfflineDomainError.WatermarkedVideosCannotBeOfflined(null, 1, null));
        }
        if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(extension)) {
            return new Result.Error(new OfflineDomainError.BoxNotesCannotBeOfflined(null, 1, null));
        }
        if (SupportedFileExtensions.INSTANCE.isBoxCanvasExtension(extension)) {
            return new Result.Error(new OfflineDomainError.BoxCanvasCannotBeOfflined(null, 1, null));
        }
        if (BoxAccountManager.isSaveOnDeviceAdminDisabled(getUserPrefs())) {
            return new Result.Error(new AdminSettingsDomainError.SavingOnDeviceDisabled(null, 1, null));
        }
        if (BoxAccountManager.doesSaveOnDeviceRequireEncryptedDevice(getUserPrefs())) {
            return new Result.Error(new AdminSettingsDomainError.EncryptedDeviceRequired(null, 1, null));
        }
        if (fileModel.getPermissions() == null) {
            return new Result.Error(new OfflineDomainError.MissingFilePermissions(null, 1, null));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
    
        if (updatingRunningInfo$default(r8, false, r3, r4, 1, null) == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b3, code lost:
    
        if (updateDownloadStatuses$default(r8, null, r3, r4, 1, null) == r0) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object shouldDownloadPreview(com.box.android.domain.models.item.FileModel r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.box.android.data.jobs.MarkForOfflineJob.C13281
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$1 r0 = (com.box.android.data.jobs.MarkForOfflineJob.C13281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$1 r0 = new com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$1
            r0.<init>(r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r7 = 1
            if (r1 == 0) goto L4b
            if (r1 == r7) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r4.L$1
            com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
            java.lang.Object r8 = r4.L$0
            com.box.android.domain.models.item.FileModel r8 = (com.box.android.domain.models.item.FileModel) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lb6
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r8 = r4.L$1
            com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
            java.lang.Object r8 = r4.L$0
            com.box.android.domain.models.item.FileModel r8 = (com.box.android.domain.models.item.FileModel) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L95
        L4b:
            kotlin.ResultKt.throwOnFailure(r10)
            com.box.android.domain.utils.result.Result r10 = r8.validatePreviewDownload(r9)
            boolean r1 = r10 instanceof com.box.android.domain.utils.result.Result.Error
            if (r1 == 0) goto L97
            java.lang.String r1 = com.box.android.domain.utils.ExtensionsKt.getTAG(r8)
            r2 = r10
            com.box.android.domain.utils.result.Result$Error r2 = (com.box.android.domain.utils.result.Result.Error) r2
            java.lang.Object r2 = r2.getValue()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Preview download not eligible: "
            r3.<init>(r5)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            com.box.androidsdk.content.utils.BoxLogUtils.d(r1, r2)
            com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$2 r1 = new com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$2
            r2 = 0
            r1.<init>(r10, r8, r2)
            r3 = r1
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r9
            r4.label = r7
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r8
            java.lang.Object r8 = updatingRunningInfo$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L95
            goto Lb5
        L95:
            r7 = 0
            goto Lb6
        L97:
            r1 = r8
            boolean r8 = r10 instanceof com.box.android.domain.utils.result.Result.Success
            if (r8 == 0) goto Lbb
            com.box.android.data.jobs.DownloadStatus r3 = com.box.android.data.jobs.DownloadStatus.NotStarted
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r8
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r8 = updateDownloadStatuses$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto Lb6
        Lb5:
            return r0
        Lb6:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r8
        Lbb:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.shouldDownloadPreview(com.box.android.domain.models.item.FileModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob$shouldDownloadPreview$2", f = "MarkForOfflineJob.kt", i = {0, 0}, l = {452}, m = "invokeSuspend", n = {"runningInfo", "updatedInfo"}, s = {"L$0", "L$1"}, v = 1)
    static final class C13292 extends SuspendLambda implements Function2<MarkForOfflineRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ Result<Unit, DomainError> $result;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MarkForOfflineJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13292(Result<Unit, ? extends DomainError> result, MarkForOfflineJob markForOfflineJob, Continuation<? super C13292> continuation) {
            super(2, continuation);
            this.$result = result;
            this.this$0 = markForOfflineJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13292 c13292 = new C13292(this.$result, this.this$0, continuation);
            c13292.L$0 = obj;
            return c13292;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineRunningInfo markForOfflineRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13292) create(markForOfflineRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MarkForOfflineRunningInfo markForOfflineRunningInfo = (MarkForOfflineRunningInfo) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MarkForOfflineRunningInfo markForOfflineRunningInfoCopy$default = MarkForOfflineRunningInfo.copy$default(markForOfflineRunningInfo, null, null, null, DownloadStatus.Failed, null, (DomainError) ((Result.Error) this.$result).getValue(), 23, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfo);
                this.L$1 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfoCopy$default);
                this.label = 1;
                if (this.this$0.getJobService().updateRunningInfo(this.this$0.runningInfoToByteArray(markForOfflineRunningInfoCopy$default), this.this$0.getJobId(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0104  */
    /* JADX WARN: Code duplicated, block: B:29:0x0111  */
    /* JADX WARN: Code duplicated, block: B:34:0x0149  */
    /* JADX WARN: Code duplicated, block: B:36:0x0151  */
    /* JADX WARN: Code duplicated, block: B:37:0x0153  */
    /* JADX WARN: Code duplicated, block: B:40:0x015c  */
    /* JADX WARN: Code duplicated, block: B:41:0x015e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0203  */
    /* JADX WARN: Code duplicated, block: B:56:0x0209  */
    /* JADX WARN: Code duplicated, block: B:57:0x020e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0211  */
    /* JADX WARN: Code duplicated, block: B:64:0x024e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0250 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x0252 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x025b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0288  */
    /* JADX WARN: Code duplicated, block: B:78:0x028e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:88:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:90:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:93:0x030e  */
    /* JADX WARN: Code duplicated, block: B:96:0x031e  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0137, code lost:
    
        if (updateDownloadStatuses$default(r0, r2, null, r3, 2, null) == r6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01fa, code lost:
    
        if (r0.markNotOfflinedAndFailJob(r1, r3) == r6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x023c, code lost:
    
        if (updateDownloadStatuses$default(r0, r1, null, r3, 2, null) == r6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x027f, code lost:
    
        if (updateDownloadStatuses$default(r0, r1, null, r3, 2, null) == r6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02b3, code lost:
    
        if (updateDownloadStatuses$default(r0, r1, null, r3, 2, null) == r6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02e2, code lost:
    
        if (updateDownloadStatuses$default(r16, r1, null, r3, 2, null) == r6) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16, types: [int] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object shouldDownloadOriginal(com.box.android.domain.models.item.FileModel r17, kotlin.coroutines.Continuation<? super java.lang.Boolean> r18) {
        /*
            Method dump skipped, instruction units count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.shouldDownloadOriginal(com.box.android.domain.models.item.FileModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object updateDownloadStatuses$default(MarkForOfflineJob markForOfflineJob, DownloadStatus downloadStatus, DownloadStatus downloadStatus2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            downloadStatus = null;
        }
        if ((i & 2) != 0) {
            downloadStatus2 = null;
        }
        return markForOfflineJob.updateDownloadStatuses(downloadStatus, downloadStatus2, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$updateDownloadStatuses$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob$updateDownloadStatuses$2", f = "MarkForOfflineJob.kt", i = {0, 0}, l = {541}, m = "invokeSuspend", n = {"runningInfo", "updatedRunningInfo"}, s = {"L$0", "L$1"}, v = 1)
    static final class C13312 extends SuspendLambda implements Function2<MarkForOfflineRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadStatus $downloadOriginalStatus;
        final /* synthetic */ DownloadStatus $downloadPreviewStatus;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MarkForOfflineJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13312(DownloadStatus downloadStatus, DownloadStatus downloadStatus2, MarkForOfflineJob markForOfflineJob, Continuation<? super C13312> continuation) {
            super(2, continuation);
            this.$downloadOriginalStatus = downloadStatus;
            this.$downloadPreviewStatus = downloadStatus2;
            this.this$0 = markForOfflineJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13312 c13312 = new C13312(this.$downloadOriginalStatus, this.$downloadPreviewStatus, this.this$0, continuation);
            c13312.L$0 = obj;
            return c13312;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineRunningInfo markForOfflineRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13312) create(markForOfflineRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MarkForOfflineRunningInfo markForOfflineRunningInfo = (MarkForOfflineRunningInfo) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DownloadStatus downloadOriginalStatus = this.$downloadOriginalStatus;
                if (downloadOriginalStatus == null) {
                    downloadOriginalStatus = markForOfflineRunningInfo.getDownloadOriginalStatus();
                }
                DownloadStatus downloadStatus = downloadOriginalStatus;
                DownloadStatus downloadPreviewStatus = this.$downloadPreviewStatus;
                if (downloadPreviewStatus == null) {
                    downloadPreviewStatus = markForOfflineRunningInfo.getDownloadPreviewStatus();
                }
                MarkForOfflineRunningInfo markForOfflineRunningInfoCopy$default = MarkForOfflineRunningInfo.copy$default(markForOfflineRunningInfo, null, null, downloadStatus, downloadPreviewStatus, null, null, 51, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfo);
                this.L$1 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfoCopy$default);
                this.label = 1;
                if (this.this$0.getJobService().updateRunningInfo(this.this$0.runningInfoToByteArray(markForOfflineRunningInfoCopy$default), this.this$0.getJobId(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateDownloadStatuses(DownloadStatus downloadStatus, DownloadStatus downloadStatus2, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13312(downloadStatus, downloadStatus2, this, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRunningInfo(Continuation<? super Result<MarkForOfflineRunningInfo, ? extends DomainError>> continuation) {
        C13231 c13231;
        if (continuation instanceof C13231) {
            c13231 = (C13231) continuation;
            if ((c13231.label & Integer.MIN_VALUE) != 0) {
                c13231.label -= Integer.MIN_VALUE;
            } else {
                c13231 = new C13231(continuation);
            }
        } else {
            c13231 = new C13231(continuation);
        }
        Object runningInfo = c13231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c13231.label = 1;
            runningInfo = jobService.getRunningInfo(jobId, c13231);
            if (runningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(runningInfo);
        }
        Result result = (Result) runningInfo;
        if (result instanceof Result.Success) {
            byte[] bArr = (byte[]) ((Result.Success) result).getValue();
            return new Result.Success(bArr == null ? null : byteArrayToRunningInfo(bArr));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final MarkForOfflineRunningInfo byteArrayToRunningInfo(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        String str = new String(byteArray, Charsets.UTF_8);
        JsonAdapter<MarkForOfflineRunningInfo> runningInfoAdapter = getRunningInfoAdapter();
        Intrinsics.checkNotNullExpressionValue(runningInfoAdapter, "<get-runningInfoAdapter>(...)");
        MarkForOfflineRunningInfo markForOfflineRunningInfo = (MarkForOfflineRunningInfo) AnnotationEntityDomainMapperKt.fromJsonOrNull(runningInfoAdapter, str);
        if (markForOfflineRunningInfo != null) {
            return markForOfflineRunningInfo;
        }
        throw new IllegalStateException("Failed to parse running info from JSON".toString());
    }

    /* JADX WARN: Code duplicated, block: B:43:0x010f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0116  */
    /* JADX WARN: Code duplicated, block: B:48:0x011e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0123  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object initialRunningInfo(Continuation<? super Result<MarkForOfflineRunningInfo, ? extends DomainError>> continuation) {
        C13241 c13241;
        ItemId.Remote remote;
        ItemId.Remote remote2;
        ItemModel itemModel;
        MarkForOfflineRunningInfo markForOfflineRunningInfo;
        MarkForOfflineRunningInfo markForOfflineRunningInfo2;
        Result result;
        if (continuation instanceof C13241) {
            c13241 = (C13241) continuation;
            if ((c13241.label & Integer.MIN_VALUE) != 0) {
                c13241.label -= Integer.MIN_VALUE;
            } else {
                c13241 = new C13241(continuation);
            }
        } else {
            c13241 = new C13241(continuation);
        }
        Object objUpdateRunningInfo = c13241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13241.label;
        if (i != 0) {
            if (i == 1) {
                remote = (ItemId.Remote) c13241.L$0;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
            } else {
                if (i == 2) {
                    itemModel = (ItemModel) c13241.L$1;
                    remote2 = (ItemId.Remote) c13241.L$0;
                    ResultKt.throwOnFailure(objUpdateRunningInfo);
                    String name = itemModel.getName();
                    ItemId itemId = itemModel.getItemId();
                    Intrinsics.checkNotNull(itemId, "null cannot be cast to non-null type com.box.android.domain.models.ItemId.Remote");
                    markForOfflineRunningInfo = new MarkForOfflineRunningInfo(name, (ItemId.Remote) itemId, null, null, null, null, 60, null);
                    JobService jobService = getJobService();
                    byte[] bArrRunningInfoToByteArray = runningInfoToByteArray(markForOfflineRunningInfo);
                    JobId jobId = this.jobId;
                    c13241.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                    c13241.L$1 = SpillingKt.nullOutSpilledVariable(itemModel);
                    c13241.L$2 = markForOfflineRunningInfo;
                    c13241.label = 3;
                    objUpdateRunningInfo = jobService.updateRunningInfo(bArrRunningInfoToByteArray, jobId, c13241);
                    if (objUpdateRunningInfo != coroutine_suspended) {
                        markForOfflineRunningInfo2 = markForOfflineRunningInfo;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                markForOfflineRunningInfo2 = (MarkForOfflineRunningInfo) c13241.L$2;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
            }
            result = (Result) objUpdateRunningInfo;
            if (result instanceof Result.Success) {
                return new Result.Success(markForOfflineRunningInfo2);
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
        ResultKt.throwOnFailure(objUpdateRunningInfo);
        String string = this.inputData.getString("remoteIdParam");
        if (string != null) {
            ItemId itemIdCreate = ItemId.INSTANCE.create(string);
            ItemId.Remote remote3 = itemIdCreate instanceof ItemId.Remote ? (ItemId.Remote) itemIdCreate : null;
            if (remote3 != null) {
                IRemoteItemService iRemoteItemService = this.remoteItemService;
                DataPolicy dataPolicy = DataPolicy.REMOTE_OR_CACHE;
                c13241.L$0 = remote3;
                c13241.label = 1;
                Object objItem = iRemoteItemService.item(remote3, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) c13241);
                if (objItem != coroutine_suspended) {
                    remote = remote3;
                    objUpdateRunningInfo = objItem;
                }
                return coroutine_suspended;
            }
        }
        throw new IllegalStateException("Unable to get remote itemId".toString());
        Result result2 = (Result) objUpdateRunningInfo;
        if (!(result2 instanceof Result.Success)) {
            if (result2 instanceof Result.Error) {
                return result2;
            }
            throw new NoWhenBranchMatchedException();
        }
        ItemModel itemModel2 = (ItemModel) ((Result.Success) result2).getValue();
        FileModel fileModel = itemModel2 instanceof FileModel ? (FileModel) itemModel2 : null;
        if (fileModel != null) {
            this.cachedFileModel = fileModel;
        }
        JobService jobService2 = getJobService();
        JobId jobId2 = this.jobId;
        Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_ID, remote.toString()));
        c13241.L$0 = SpillingKt.nullOutSpilledVariable(remote);
        c13241.L$1 = itemModel2;
        c13241.label = 2;
        if (jobService2.updateLogData(jobId2, mapMapOf, c13241) != coroutine_suspended) {
            remote2 = remote;
            itemModel = itemModel2;
            String name2 = itemModel.getName();
            ItemId itemId2 = itemModel.getItemId();
            Intrinsics.checkNotNull(itemId2, "null cannot be cast to non-null type com.box.android.domain.models.ItemId.Remote");
            markForOfflineRunningInfo = new MarkForOfflineRunningInfo(name2, (ItemId.Remote) itemId2, null, null, null, null, 60, null);
            JobService jobService3 = getJobService();
            byte[] bArrRunningInfoToByteArray2 = runningInfoToByteArray(markForOfflineRunningInfo);
            JobId jobId3 = this.jobId;
            c13241.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
            c13241.L$1 = SpillingKt.nullOutSpilledVariable(itemModel);
            c13241.L$2 = markForOfflineRunningInfo;
            c13241.label = 3;
            objUpdateRunningInfo = jobService3.updateRunningInfo(bArrRunningInfoToByteArray2, jobId3, c13241);
            if (objUpdateRunningInfo != coroutine_suspended) {
                markForOfflineRunningInfo2 = markForOfflineRunningInfo;
                result = (Result) objUpdateRunningInfo;
                if (result instanceof Result.Success) {
                    return new Result.Success(markForOfflineRunningInfo2);
                }
                if (result instanceof Result.Error) {
                    return result;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return coroutine_suspended;
    }

    public static /* synthetic */ Object getFileModel$default(MarkForOfflineJob markForOfflineJob, ItemId.Remote remote, DataPolicy dataPolicy, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            dataPolicy = DataPolicy.REMOTE_OR_CACHE;
        }
        return markForOfflineJob.getFileModel(remote, dataPolicy, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileModel(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
        C13221 c13221;
        if (continuation instanceof C13221) {
            c13221 = (C13221) continuation;
            if ((c13221.label & Integer.MIN_VALUE) != 0) {
                c13221.label -= Integer.MIN_VALUE;
            } else {
                c13221 = new C13221(continuation);
            }
        } else {
            c13221 = new C13221(continuation);
        }
        Object objItem = c13221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13221.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            FileModel fileModel = this.cachedFileModel;
            if (fileModel != null && Intrinsics.areEqual(fileModel.getItemId(), remote)) {
                return new Result.Success(fileModel);
            }
            IRemoteItemService iRemoteItemService = this.remoteItemService;
            c13221.L$0 = SpillingKt.nullOutSpilledVariable(remote);
            c13221.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy);
            c13221.label = 1;
            objItem = iRemoteItemService.item(remote, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) c13221);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objItem);
        }
        Result result = (Result) objItem;
        if (result instanceof Result.Success) {
            Object value = ((Result.Success) result).getValue();
            FileModel fileModel2 = value instanceof FileModel ? (FileModel) value : null;
            if (fileModel2 == null) {
                return new Result.Error(new DomainError.UnknownError("Item fetched is not a fileModel"));
            }
            this.cachedFileModel = fileModel2;
            return new Result.Success(fileModel2);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<Unit, DomainError> renameTempToTargetFile(FileModel fileModel) {
        BoxItem boxItem = ItemModelMapper.INSTANCE.toBoxItem(fileModel, true);
        Intrinsics.checkNotNull(boxItem, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
        BoxFile boxFile = (BoxFile) boxItem;
        File offlineFile = this.userContextManager.getPreviewStorage().getOfflineFile(boxFile, null);
        File offlineFile2 = this.userContextManager.getPreviewStorage().getOfflineFile(boxFile, "temp");
        if (!offlineFile2.exists()) {
            return new Result.Error(new OfflineDomainError.TempFileDoesNotExist(null, 1, null));
        }
        if (!offlineFile2.renameTo(offlineFile)) {
            return new Result.Error(new OfflineDomainError.FailedToRenameTempFile(null, 1, null));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e0 A[PHI: r13
      0x00e0: PHI (r13v3 com.box.android.domain.models.DomainError) = 
      (r13v1 com.box.android.domain.models.DomainError)
      (r13v2 com.box.android.domain.models.DomainError)
      (r13v2 com.box.android.domain.models.DomainError)
      (r13v15 com.box.android.domain.models.DomainError)
     binds: [B:24:0x0089, B:30:0x00af, B:32:0x00dd, B:17:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:
    
        if (r14.jobFailed(r12, com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE, r13, r0) == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object markNotOfflinedAndFailJob(com.box.android.domain.models.DomainError r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.markNotOfflinedAndFailJob(com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    public final byte[] runningInfoToByteArray(MarkForOfflineRunningInfo runningInfo) {
        Intrinsics.checkNotNullParameter(runningInfo, "runningInfo");
        String json = getRunningInfoAdapter().toJson(runningInfo);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$2", f = "MarkForOfflineJob.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {657, 661, 667, 673}, m = "invokeSuspend", n = {"runningInfo", "runningInfo", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningInfo", "fileModel", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-MarkForOfflineJob$childSucceeded$2$newRunningInfo$1", "runningInfo", "fileModel", "newRunningInfo"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C13132 extends SuspendLambda implements Function2<MarkForOfflineRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        int I$0;
        int I$1;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MarkForOfflineJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13132(JobId jobId, MarkForOfflineJob markForOfflineJob, Continuation<? super C13132> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.this$0 = markForOfflineJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13132 c13132 = new C13132(this.$childJobId, this.this$0, continuation);
            c13132.L$0 = obj;
            return c13132;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineRunningInfo markForOfflineRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13132) create(markForOfflineRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0082  */
        /* JADX WARN: Code duplicated, block: B:25:0x0092  */
        /* JADX WARN: Code duplicated, block: B:27:0x009e  */
        /* JADX WARN: Code duplicated, block: B:29:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:34:0x00d5  */
        /* JADX WARN: Code duplicated, block: B:36:0x00db  */
        /* JADX WARN: Code duplicated, block: B:37:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:41:0x0128  */
        /* JADX WARN: Code duplicated, block: B:43:0x012c  */
        /* JADX WARN: Code duplicated, block: B:48:0x0152  */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00ce, code lost:
        
            if (r4.markNotOfflinedAndFailJob(r5, r11) == r0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0125, code lost:
        
            if (r11.this$0.getJobService().updateRunningInfo(r11.this$0.runningInfoToByteArray(r2), r11.this$0.getJobId(), r11) == r0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x014c, code lost:
        
            if (r11.this$0.markNotOfflinedAndFailJob((com.box.android.domain.models.DomainError) ((com.box.android.domain.utils.result.Result.Error) r12).getValue(), r11) == r0) goto L45;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 347
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.C13132.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (r1.checkCompletion(r4) == r0) goto L21;
     */
    @Override // com.box.android.data.jobs.ParentJob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childSucceeded(com.box.android.domain.jobs.JobId r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.box.android.data.jobs.MarkForOfflineJob.C13121
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$1 r0 = (com.box.android.data.jobs.MarkForOfflineJob.C13121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$1 r0 = new com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$1
            r0.<init>(r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L43
            if (r1 == r2) goto L3a
            if (r1 != r7) goto L32
            java.lang.Object r8 = r4.L$0
            com.box.android.domain.jobs.JobId r8 = (com.box.android.domain.jobs.JobId) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L71
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.Object r9 = r4.L$0
            com.box.android.domain.jobs.JobId r9 = (com.box.android.domain.jobs.JobId) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r1 = r8
            goto L62
        L43:
            kotlin.ResultKt.throwOnFailure(r10)
            com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$2 r10 = new com.box.android.data.jobs.MarkForOfflineJob$childSucceeded$2
            r1 = 0
            r10.<init>(r9, r8, r1)
            r3 = r10
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r10
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r8
            java.lang.Object r8 = updatingRunningInfo$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L62
            goto L70
        L62:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r8
            r4.label = r7
            java.lang.Object r8 = r1.checkCompletion(r4)
            if (r8 != r0) goto L71
        L70:
            return r0
        L71:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.childSucceeded(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        if (markNotOfflinedAndFailJob(r2, r0) == r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e4, code lost:
    
        if (markNotOfflinedAndFailJob(r4, r0) == r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fe, code lost:
    
        if (setOfflineStatusOnJobCompletion(r3, r0) == r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011d, code lost:
    
        if (markNotOfflinedAndFailJob(r2, r0) == r1) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkCompletion(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.checkCompletion(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DomainError determineUserFacingError(MarkForOfflineRunningInfo runningInfo) {
        Intrinsics.checkNotNullParameter(runningInfo, "runningInfo");
        DomainError previewError = runningInfo.getPreviewError();
        if (previewError != null) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Preview download error: " + previewError);
            return previewError;
        }
        if (runningInfo.getDownloadPreviewStatus() == DownloadStatus.Failed) {
            return new OfflineDomainError.PreviewDownloadFailed(null, 1, null);
        }
        if (runningInfo.getDownloadOriginalStatus() == DownloadStatus.Failed) {
            DomainError domainError = this.lastRecordError;
            return domainError == null ? new OfflineDomainError.DownloadingOriginalFileFailed(null, 1, null) : domainError;
        }
        return new OfflineDomainError.BothDownloadOptionsNotAvailable(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00c4 A[PHI: r2 r9
      0x00c4: PHI (r2v15 com.box.android.domain.models.ItemId$Remote) = (r2v14 com.box.android.domain.models.ItemId$Remote), (r2v20 com.box.android.domain.models.ItemId$Remote) binds: [B:32:0x00c1, B:19:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x00c4: PHI (r9v6 com.box.android.domain.utils.result.Result) = (r9v5 com.box.android.domain.utils.result.Result), (r9v13 com.box.android.domain.utils.result.Result) binds: [B:32:0x00c1, B:19:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dc, code lost:
    
        if (r10.jobSucceeded(r8, r0) == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0101, code lost:
    
        if (markNotOfflinedAndFailJob(r2, r0) == r1) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setOfflineStatusOnJobCompletion(com.box.android.domain.models.ItemId.Remote r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.setOfflineStatusOnJobCompletion(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setFileOfflineSavedIfNeeded(FileModel fileModel, Continuation<? super Unit> continuation) {
        if (this.inputData.getBoolean("isUserOfflined", true)) {
            BoxModelOfflineManager boxModelOfflineManager = BoxModelOfflineManager.INSTANCE;
            BoxItem boxItem = ItemModelMapper.INSTANCE.toBoxItem(fileModel, true);
            Intrinsics.checkNotNull(boxItem, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
            Object fileOfflineSavedCompleted = boxModelOfflineManager.setFileOfflineSavedCompleted((BoxFile) boxItem, true, this.userContextManager, continuation);
            return fileOfflineSavedCompleted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fileOfflineSavedCompleted : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if (r6 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateLogDataFromRunningInfo(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.box.android.data.jobs.MarkForOfflineJob.C13321
            if (r0 == 0) goto L14
            r0 = r6
            com.box.android.data.jobs.MarkForOfflineJob$updateLogDataFromRunningInfo$1 r0 = (com.box.android.data.jobs.MarkForOfflineJob.C13321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.box.android.data.jobs.MarkForOfflineJob$updateLogDataFromRunningInfo$1 r0 = new com.box.android.data.jobs.MarkForOfflineJob$updateLogDataFromRunningInfo$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$1
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.data.jobs.MarkForOfflineRunningInfo r5 = (com.box.android.data.jobs.MarkForOfflineRunningInfo) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L7b
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L43:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r4
            java.lang.Object r6 = r5.getRunningInfo(r0)
            if (r6 != r1) goto L4f
            goto L7a
        L4f:
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            java.lang.Object r6 = com.box.android.domain.utils.result.ResultKt.getOrNull(r6)
            com.box.android.data.jobs.MarkForOfflineRunningInfo r6 = (com.box.android.data.jobs.MarkForOfflineRunningInfo) r6
            if (r6 == 0) goto L7d
            java.util.Map r2 = r5.buildLogDataMap(r6)
            com.box.android.data.jobs.JobService r4 = r5.getJobService()
            com.box.android.domain.jobs.JobId r5 = r5.jobId
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r6
            r6 = 0
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r6 = r4.updateLogData(r5, r2, r0)
            if (r6 != r1) goto L7b
        L7a:
            return r1
        L7b:
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
        L7d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.updateLogDataFromRunningInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Map<String, Object> buildLogDataMap(MarkForOfflineRunningInfo runningInfo) {
        String gen204ItemState;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = WhenMappings.$EnumSwitchMapping$0[runningInfo.getDownloadOriginalStatus().ordinal()];
        if (i == 1) {
            linkedHashMap.put("downloadOriginalStatus", "original_success");
        } else if (i != 2 && i == 3) {
            linkedHashMap.put("downloadOriginalStatus", "original_not_needed");
        } else {
            linkedHashMap.put("downloadOriginalStatus", "original_failed");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[runningInfo.getDownloadPreviewStatus().ordinal()];
        if (i2 == 1) {
            linkedHashMap.put("downloadPreviewStatus", "preview_success");
        } else if (i2 != 2 && i2 == 3) {
            linkedHashMap.put("downloadPreviewStatus", "preview_not_needed");
        } else {
            linkedHashMap.put("downloadPreviewStatus", "preview_failed");
        }
        FileModel fileModel = this.cachedFileModel;
        if (fileModel != null && (gen204ItemState = Gen204ItemStateKt.getGen204ItemState(fileModel)) != null) {
            linkedHashMap.put(MetricKeysParam.METRIC_ITEM_STATE, gen204ItemState);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ Object updatingRunningInfo$default(MarkForOfflineJob markForOfflineJob, boolean z, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return markForOfflineJob.updatingRunningInfo(z, function2, continuation);
    }

    public final Object updatingRunningInfo(boolean z, Function2<? super MarkForOfflineRunningInfo, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        MarkForOfflineJob$updatingRunningInfo$update$1 markForOfflineJob$updatingRunningInfo$update$1 = new MarkForOfflineJob$updatingRunningInfo$update$1(this, function2, null);
        if (z) {
            Object objWithTransaction = getJobService().withTransaction(markForOfflineJob$updatingRunningInfo$update$1, continuation);
            return objWithTransaction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithTransaction : Unit.INSTANCE;
        }
        Object objInvoke = markForOfflineJob$updatingRunningInfo$update$1.invoke(continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0085, code lost:
    
        if (r1.checkCompletion(r4) == r0) goto L21;
     */
    @Override // com.box.android.data.jobs.ParentJob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childFailed(com.box.android.domain.jobs.JobId r9, com.box.android.domain.models.DomainError r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.box.android.data.jobs.MarkForOfflineJob.C13111
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.jobs.MarkForOfflineJob$childFailed$1 r0 = (com.box.android.data.jobs.MarkForOfflineJob.C13111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.jobs.MarkForOfflineJob$childFailed$1 r0 = new com.box.android.data.jobs.MarkForOfflineJob$childFailed$1
            r0.<init>(r11)
        L19:
            r4 = r0
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L4c
            if (r1 == r2) goto L3e
            if (r1 != r7) goto L36
            java.lang.Object r8 = r4.L$1
            com.box.android.domain.models.DomainError r8 = (com.box.android.domain.models.DomainError) r8
            java.lang.Object r8 = r4.L$0
            com.box.android.domain.jobs.JobId r8 = (com.box.android.domain.jobs.JobId) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L88
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            java.lang.Object r9 = r4.L$1
            r10 = r9
            com.box.android.domain.models.DomainError r10 = (com.box.android.domain.models.DomainError) r10
            java.lang.Object r9 = r4.L$0
            com.box.android.domain.jobs.JobId r9 = (com.box.android.domain.jobs.JobId) r9
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r8
            goto L73
        L4c:
            kotlin.ResultKt.throwOnFailure(r11)
            r8.lastRecordError = r10
            com.box.android.data.jobs.MarkForOfflineJob$childFailed$2 r11 = new com.box.android.data.jobs.MarkForOfflineJob$childFailed$2
            r1 = 0
            r11.<init>(r9, r8, r10, r1)
            r3 = r11
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r11
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r8
            java.lang.Object r8 = updatingRunningInfo$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L73
            goto L87
        L73:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r8
            r4.label = r7
            java.lang.Object r8 = r1.checkCompletion(r4)
            if (r8 != r0) goto L88
        L87:
            return r0
        L88:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob.childFailed(com.box.android.domain.jobs.JobId, com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob$childFailed$2, reason: invalid class name */
    /* JADX INFO: compiled from: MarkForOfflineJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob$childFailed$2", f = "MarkForOfflineJob.kt", i = {0, 0}, l = {817}, m = "invokeSuspend", n = {"runningInfo", "newRunningInfo"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MarkForOfflineRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        final /* synthetic */ DomainError $domainError;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MarkForOfflineJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(JobId jobId, MarkForOfflineJob markForOfflineJob, DomainError domainError, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.this$0 = markForOfflineJob;
            this.$domainError = domainError;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$childJobId, this.this$0, this.$domainError, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineRunningInfo markForOfflineRunningInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(markForOfflineRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MarkForOfflineRunningInfo markForOfflineRunningInfo = (MarkForOfflineRunningInfo) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (markForOfflineRunningInfo.isOriginalDownloadInProgress() && Intrinsics.areEqual(markForOfflineRunningInfo.getDownloadOriginalJobId(), this.$childJobId.getIdentifier())) {
                    BoxLogUtils.d(ExtensionsKt.getTAG(this.this$0), "Original download failed: " + this.$domainError);
                    MarkForOfflineRunningInfo markForOfflineRunningInfoCopy$default = MarkForOfflineRunningInfo.copy$default(markForOfflineRunningInfo, null, null, DownloadStatus.Failed, null, null, null, 59, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfo);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(markForOfflineRunningInfoCopy$default);
                    this.label = 1;
                    if (this.this$0.getJobService().updateRunningInfo(this.this$0.runningInfoToByteArray(markForOfflineRunningInfoCopy$default), this.this$0.getJobId(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childProgressed(JobId jobId, double d, double d2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString("remoteIdParam");
        Intrinsics.checkNotNull(string);
        ItemId itemIdCreate = companion.create(string);
        Intrinsics.checkNotNull(itemIdCreate, "null cannot be cast to non-null type com.box.android.domain.models.ItemId.Remote");
        return new MarkForOfflineJobDisplayInfoProvider((ItemId.Remote) itemIdCreate, this.remoteItemService, this.inputData.getBoolean(JobConstants.SHOW_NOTIFICATION, true));
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public boolean shouldDisplay() {
        return this.inputData.getBoolean(JobConstants.SHOULD_DISPLAY_JOB, true);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return "mark_offline";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        C13211 c13211;
        if (continuation instanceof C13211) {
            c13211 = (C13211) continuation;
            if ((c13211.label & Integer.MIN_VALUE) != 0) {
                c13211.label -= Integer.MIN_VALUE;
            } else {
                c13211 = new C13211(continuation);
            }
        } else {
            c13211 = new C13211(continuation);
        }
        Object objItem = c13211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13211.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            ItemId.Companion companion = ItemId.INSTANCE;
            String string = this.inputData.getString("remoteIdParam");
            Intrinsics.checkNotNull(string);
            ItemId itemIdCreate = companion.create(string);
            IRemoteItemService iRemoteItemService = this.remoteItemService;
            DataPolicy dataPolicy = DataPolicy.REMOTE_OR_CACHE;
            c13211.L$0 = SpillingKt.nullOutSpilledVariable(itemIdCreate);
            c13211.label = 1;
            objItem = iRemoteItemService.item(itemIdCreate, dataPolicy, c13211);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objItem);
        }
        ItemModel itemModel = (ItemModel) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
        String name = itemModel != null ? itemModel.getName() : null;
        if (name != null) {
            String fileExtension = CommonBoxUtil.getFileExtension(name, "");
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_EXTENSION, fileExtension), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_TYPE, BoxAnalyticsParams.INSTANCE.calculateFileType(fileExtension)));
            if (mapMapOf != null) {
                return mapMapOf;
            }
        }
        return MapsKt.emptyMap();
    }
}
