package com.box.android.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.data.api.interceptors.AiRequestInterceptor;
import com.box.android.data.api.interceptors.DevpodInterceptor;
import com.box.android.data.api.interceptors.EmptyBodyInterceptor;
import com.box.android.data.api.interceptors.Gen204RequestInterceptor;
import com.box.android.data.api.interceptors.RetryRequestInterceptor;
import com.box.android.data.api.interceptors.auth.AuthInterceptor;
import com.box.android.data.api.interceptors.auth.RequestHeaderInterceptor;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.data.api.requests.AnnotationsRequest;
import com.box.android.data.api.requests.AuthRequest;
import com.box.android.data.api.requests.BoxAiRequest;
import com.box.android.data.api.requests.ChunkedFileUploadRequest;
import com.box.android.data.api.requests.ClientSettingsRequest;
import com.box.android.data.api.requests.CollectionItemsRequest;
import com.box.android.data.api.requests.CollectionsRequest;
import com.box.android.data.api.requests.CommentRequest;
import com.box.android.data.api.requests.CommentV2Request;
import com.box.android.data.api.requests.CreateFolderRequest;
import com.box.android.data.api.requests.DefaultNoteFolderRequest;
import com.box.android.data.api.requests.DeleteItemRequest;
import com.box.android.data.api.requests.DownloadFileRequest;
import com.box.android.data.api.requests.FileActivitiesRequest;
import com.box.android.data.api.requests.FileMetadataRequest;
import com.box.android.data.api.requests.FileRepresentationsRequest;
import com.box.android.data.api.requests.FileVersionRequest;
import com.box.android.data.api.requests.FilesSearchRequest;
import com.box.android.data.api.requests.FolderItemsRequest;
import com.box.android.data.api.requests.HubAssetDownloadRequest;
import com.box.android.data.api.requests.InboxCollaborationRequest;
import com.box.android.data.api.requests.InboxNotificationRequest;
import com.box.android.data.api.requests.ItemCollaborationsRequest;
import com.box.android.data.api.requests.ItemInfoRequest;
import com.box.android.data.api.requests.MetadataTemplatesRequest;
import com.box.android.data.api.requests.MetricsLoggingRequest;
import com.box.android.data.api.requests.PreflightCheckRequest;
import com.box.android.data.api.requests.PreviewDownloadRequest;
import com.box.android.data.api.requests.PushNotificationSettingsRequest;
import com.box.android.data.api.requests.RecentNotesRequest;
import com.box.android.data.api.requests.RecentsRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.api.requests.TaskRequest;
import com.box.android.data.api.requests.UpdateItemInfoRequest;
import com.box.android.data.api.requests.UpdateItemRequest;
import com.box.android.data.api.requests.UploadFileRequest;
import com.box.android.data.api.requests.WatermarkRequest;
import com.box.android.data.api.utils.ApiConstants;
import com.box.android.data.api.utils.HttpStreamLoggingInterceptor;
import com.box.android.data.api.utils.MoshiProvider;
import com.box.android.data.api.utils.OkHttpLogger;
import com.box.android.data.controller.impl.BoxCommentsController;
import com.box.android.data.controller.impl.BrowseModelController;
import com.box.android.data.controller.impl.CompletionListener;
import com.box.android.data.observability.ApdexTracker;
import com.box.android.data.observability.OpenTelemetryInstrumentation;
import com.box.android.data.observability.RumInstrumentation;
import com.box.android.data.observability.RumObservability;
import com.box.android.data.service.impl.AppRestrictionsManager;
import com.box.android.data.service.impl.BVEManager;
import com.box.android.data.service.impl.ItemIdMappingService;
import com.box.android.data.service.impl.preview.helpers.FileCanBePreviewedChecker;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.controller.ICommentsController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.preview.IFileCanBePreviewedChecker;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.ISessionManager;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.webBridgeAuth.BoxCsrfTokenManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiSearch;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: compiled from: DataModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000ø\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007JV\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\b\u0010(\u001a\u00020\u001fH\u0007J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010/\u001a\u0002002\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u00101\u001a\u0002022\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u00103\u001a\u0002042\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u00105\u001a\u0002062\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u00107\u001a\u0002082\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u00109\u001a\u00020:2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010;\u001a\u00020<2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010=\u001a\u00020>2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010?\u001a\u00020@2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010A\u001a\u00020B2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010C\u001a\u00020D2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010E\u001a\u00020F2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010G\u001a\u00020H2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010I\u001a\u00020J2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010K\u001a\u00020L2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010M\u001a\u00020N2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010O\u001a\u00020P2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010Q\u001a\u00020R2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010S\u001a\u00020T2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010U\u001a\u00020V2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010W\u001a\u00020X2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010Y\u001a\u00020Z2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\\H\u0007J\u0018\u0010]\u001a\u00020^2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010_\u001a\u00020`2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010a\u001a\u00020b2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010c\u001a\u00020d2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010e\u001a\u00020fH\u0007J\u0018\u0010g\u001a\u00020h2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010i\u001a\u00020j2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010k\u001a\u00020l2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010m\u001a\u00020n2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010o\u001a\u00020p2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010q\u001a\u00020r2\u0006\u0010+\u001a\u00020,2\u0006\u0010[\u001a\u00020\\H\u0007J\u0018\u0010s\u001a\u00020t2\u0006\u0010+\u001a\u00020,2\u0006\u0010[\u001a\u00020\\H\u0007J\u0018\u0010u\u001a\u00020v2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010w\u001a\u00020!H\u0007J \u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fH\u0007JQ\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020{2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010|\u001a\u00020}2\n\b\u0001\u0010\u0089\u0001\u001a\u00030\u008a\u00012\n\b\u0001\u0010\u008b\u0001\u001a\u00030\u008a\u0001H\u0007J\u0013\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u0082\u0001\u001a\u00020{H\u0007J\u0013\u0010\u008e\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u0082\u0001\u001a\u00020{H\u0007J\u0013\u0010\u008f\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u0082\u0001\u001a\u00020{H\u0007J\u0013\u0010\u0090\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u0082\u0001\u001a\u00020{H\u0007J\u0014\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0007J'\u0010\u0095\u0001\u001a\u00030\u0096\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010[\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0007J\u001e\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\b\u0010 \u0001\u001a\u00030\u0096\u0001H\u0007J\n\u0010¡\u0001\u001a\u00030¢\u0001H\u0007J\u0014\u0010£\u0001\u001a\u00030¤\u00012\b\u0010¥\u0001\u001a\u00030¢\u0001H\u0007J\u0019\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030¨\u00010§\u00012\u0006\u0010|\u001a\u00020}H\u0007J\u0019\u0010©\u0001\u001a\n\u0012\u0005\u0012\u00030¨\u00010§\u00012\u0006\u0010|\u001a\u00020}H\u0007J\n\u0010ª\u0001\u001a\u00030«\u0001H\u0007J\u0014\u0010¬\u0001\u001a\u00030\u00ad\u00012\b\u0010®\u0001\u001a\u00030¯\u0001H\u0007¨\u0006°\u0001"}, d2 = {"Lcom/box/android/data/di/DataProvidesModule;", "", "<init>", "()V", "collectionsApi", "", "appRestrictionsManager", "Lcom/box/android/data/service/impl/AppRestrictionsManager;", "app20", "isAppFedrampHighCompliant", "", "appApiBase", "notesServerApi", "uploadFileApi", "preflightCheckApi", "provideHttpLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideHttpStreamLoggingInterceptor", "Lcom/box/android/data/api/utils/HttpStreamLoggingInterceptor;", "httpLoggingInterceptor", "provideGen204RequestInterceptor", "Lcom/box/android/data/api/interceptors/Gen204RequestInterceptor;", "provideInterceptors", "", "Lokhttp3/Interceptor;", "authInterceptor", "Lcom/box/android/data/api/interceptors/auth/AuthInterceptor;", "requestHeaderInterceptor", "Lcom/box/android/data/api/interceptors/auth/RequestHeaderInterceptor;", "gen204RequestInterceptor", "retryRequestInterceptor", "Lcom/box/android/data/api/interceptors/RetryRequestInterceptor;", "emptyBodyInterceptor", "Lcom/box/android/data/api/interceptors/EmptyBodyInterceptor;", "sharedLinkAuthInterceptor", "Lcom/box/android/data/api/interceptors/auth/SharedLinkAuthInterceptor;", "devpodInterceptor", "Lcom/box/android/data/api/interceptors/DevpodInterceptor;", "aiRequestInterceptor", "Lcom/box/android/data/api/interceptors/AiRequestInterceptor;", "provideNetworkInterceptor", "provideCollectionRequest", "Lcom/box/android/data/api/requests/CollectionsRequest;", "requestFactory", "Lcom/box/android/data/api/requests/RequestFactory;", "provideAnnotationRequest", "Lcom/box/android/data/api/requests/AnnotationsRequest;", "provideFileActivitiesRequest", "Lcom/box/android/data/api/requests/FileActivitiesRequest;", "provideCollectionItemsRequest", "Lcom/box/android/data/api/requests/CollectionItemsRequest;", "provideItemInfoRequest", "Lcom/box/android/data/api/requests/ItemInfoRequest;", "provideFileRepresentationsRequest", "Lcom/box/android/data/api/requests/FileRepresentationsRequest;", "provideFileVersionRequest", "Lcom/box/android/data/api/requests/FileVersionRequest;", "provideUploadFileRequest", "Lcom/box/android/data/api/requests/UploadFileRequest;", "provideChunkedUploadFileRequest", "Lcom/box/android/data/api/requests/ChunkedFileUploadRequest;", "provideDeleteItemRequest", "Lcom/box/android/data/api/requests/DeleteItemRequest;", "provideUpdateItemInfoRequest", "Lcom/box/android/data/api/requests/UpdateItemInfoRequest;", "provideFileMetadataRequest", "Lcom/box/android/data/api/requests/FileMetadataRequest;", "provideMetadataTemplatesRequest", "Lcom/box/android/data/api/requests/MetadataTemplatesRequest;", "provideItemCollaborationsRequest", "Lcom/box/android/data/api/requests/ItemCollaborationsRequest;", "providePreflightCheckRequest", "Lcom/box/android/data/api/requests/PreflightCheckRequest;", "provideCreateFolderRequest", "Lcom/box/android/data/api/requests/CreateFolderRequest;", "provideCommentRequest", "Lcom/box/android/data/api/requests/CommentRequest;", "provideTaskRequest", "Lcom/box/android/data/api/requests/TaskRequest;", "provideCommentV2Request", "Lcom/box/android/data/api/requests/CommentV2Request;", "provideInboxCollaborationRequest", "Lcom/box/android/data/api/requests/InboxCollaborationRequest;", "providePreviewDownloadRequest", "Lcom/box/android/data/api/requests/PreviewDownloadRequest;", "provideGetFolderItemsRequest", "Lcom/box/android/data/api/requests/FolderItemsRequest;", "provideUpdateItemRequest", "Lcom/box/android/data/api/requests/UpdateItemRequest;", "provideGen204Request", "Lcom/box/android/data/api/requests/MetricsLoggingRequest;", "bveManager", "Lcom/box/android/data/service/impl/BVEManager;", "provideRecentsRequest", "Lcom/box/android/data/api/requests/RecentsRequest;", "provideRecentNotesRequest", "Lcom/box/android/data/api/requests/RecentNotesRequest;", "provideDefaultNoteFolderRequest", "Lcom/box/android/data/api/requests/DefaultNoteFolderRequest;", "provideFilesSearchRequest", "Lcom/box/android/data/api/requests/FilesSearchRequest;", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "providePushNotificationSettingsRequest", "Lcom/box/android/data/api/requests/PushNotificationSettingsRequest;", "provideInboxNotificationRequest", "Lcom/box/android/data/api/requests/InboxNotificationRequest;", "provideAnonymousAuthRequest", "Lcom/box/android/data/api/requests/AuthRequest;", "provideClientSettingsRequest", "Lcom/box/android/data/api/requests/ClientSettingsRequest;", "provideFileDownloadRequest", "Lcom/box/android/data/api/requests/DownloadFileRequest;", "provideBoxAiRequest", "Lcom/box/android/data/api/requests/BoxAiRequest;", "provideHubAssetDownloadRequest", "Lcom/box/android/data/api/requests/HubAssetDownloadRequest;", "provideWatermarkRequest", "Lcom/box/android/data/api/requests/WatermarkRequest;", "provideEmptyBodyInterceptor", "provideCommentsController", "Lcom/box/android/domain/controller/ICommentsController;", "contextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "context", "Landroid/content/Context;", "baseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "providesBrowseController", "Lcom/box/android/domain/controller/IBrowseController;", "userContextManager", "fileApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "folderApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "searchApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiSearch;", "apiExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "thumbnailExecutor", "captureSharedPreferences", "Landroid/content/SharedPreferences;", "featureFlipDebugSharedPreferences", "geniusScanLicenseSharedPreferences", "appUpdatesSharedPreferences", "providesIdMappingService", "Lcom/box/android/domain/services/IdMappingService;", "itemIdMappingService", "Lcom/box/android/data/service/impl/ItemIdMappingService;", "provideRumService", "Lcom/box/android/domain/services/RumService;", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "Lcom/box/android/domain/services/IBVEManager;", "rumInstrumentation", "Lcom/box/android/data/observability/RumInstrumentation;", "providesApdexService", "Lcom/box/android/domain/services/ApdexService;", "openTelemetryInstrumentation", "Lcom/box/android/data/observability/OpenTelemetryInstrumentation;", "rumService", "providesCookieManager", "Landroid/webkit/CookieManager;", "providesBoxCsrfTokenManager", "Lcom/box/android/domain/webBridgeAuth/BoxCsrfTokenManager;", "cookieManager", "providePreferencesDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "provideLastUsedTabDataStore", "providesFirebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "providesFileCanBePreviewedChecker", "Lcom/box/android/domain/preview/IFileCanBePreviewedChecker;", "checker", "Lcom/box/android/data/service/impl/preview/helpers/FileCanBePreviewedChecker;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class DataProvidesModule {
    private final String collectionsApi(AppRestrictionsManager appRestrictionsManager) {
        if (appRestrictionsManager.isAppFedrampHighCompliant()) {
            return "https://api.box-gov.com/app-api/collections_cff/";
        }
        return "https://api.box.com/app-api/collections_cff/";
    }

    private final String app20(boolean isAppFedrampHighCompliant) {
        if (isAppFedrampHighCompliant) {
            return "https://api.box-gov.com/2.0/";
        }
        return "https://api.box.com/2.0/";
    }

    private final String appApiBase(AppRestrictionsManager appRestrictionsManager) {
        if (appRestrictionsManager.isAppFedrampHighCompliant()) {
            return "https://api.box-gov.com/app-api/";
        }
        return "https://api.box.com/app-api/";
    }

    private final String notesServerApi(AppRestrictionsManager appRestrictionsManager) {
        if (appRestrictionsManager.isAppFedrampHighCompliant()) {
            return "https://notes.services.box-gov.com/";
        }
        return "https://notes.services.box.com/";
    }

    private final String uploadFileApi(AppRestrictionsManager appRestrictionsManager) {
        if (appRestrictionsManager.isAppFedrampHighCompliant()) {
            return "https://upload.box-gov.com/api/2.0/files/";
        }
        return "https://upload.box.com/api/2.0/files/";
    }

    private final String preflightCheckApi(AppRestrictionsManager appRestrictionsManager) {
        return app20(appRestrictionsManager.isAppFedrampHighCompliant()) + ApiConstants.FILES_RESOURCE;
    }

    @Provides
    @Singleton
    public final HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OkHttpLogger());
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            level = HttpLoggingInterceptor.Level.BODY;
        } else {
            level = HttpLoggingInterceptor.Level.NONE;
        }
        httpLoggingInterceptor.level(level);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    public final HttpStreamLoggingInterceptor provideHttpStreamLoggingInterceptor(HttpLoggingInterceptor httpLoggingInterceptor) {
        Intrinsics.checkNotNullParameter(httpLoggingInterceptor, "httpLoggingInterceptor");
        return new HttpStreamLoggingInterceptor(httpLoggingInterceptor);
    }

    @Provides
    @Singleton
    public final Gen204RequestInterceptor provideGen204RequestInterceptor() {
        return new Gen204RequestInterceptor();
    }

    @Provides
    @Singleton
    public final List<Interceptor> provideInterceptors(AuthInterceptor authInterceptor, RequestHeaderInterceptor requestHeaderInterceptor, Gen204RequestInterceptor gen204RequestInterceptor, RetryRequestInterceptor retryRequestInterceptor, EmptyBodyInterceptor emptyBodyInterceptor, SharedLinkAuthInterceptor sharedLinkAuthInterceptor, DevpodInterceptor devpodInterceptor, AiRequestInterceptor aiRequestInterceptor, HttpStreamLoggingInterceptor httpLoggingInterceptor) {
        Intrinsics.checkNotNullParameter(authInterceptor, "authInterceptor");
        Intrinsics.checkNotNullParameter(requestHeaderInterceptor, "requestHeaderInterceptor");
        Intrinsics.checkNotNullParameter(gen204RequestInterceptor, "gen204RequestInterceptor");
        Intrinsics.checkNotNullParameter(retryRequestInterceptor, "retryRequestInterceptor");
        Intrinsics.checkNotNullParameter(emptyBodyInterceptor, "emptyBodyInterceptor");
        Intrinsics.checkNotNullParameter(sharedLinkAuthInterceptor, "sharedLinkAuthInterceptor");
        Intrinsics.checkNotNullParameter(devpodInterceptor, "devpodInterceptor");
        Intrinsics.checkNotNullParameter(aiRequestInterceptor, "aiRequestInterceptor");
        Intrinsics.checkNotNullParameter(httpLoggingInterceptor, "httpLoggingInterceptor");
        return CollectionsKt.listOf((Object[]) new Interceptor[]{authInterceptor, requestHeaderInterceptor, gen204RequestInterceptor, retryRequestInterceptor, emptyBodyInterceptor, sharedLinkAuthInterceptor, devpodInterceptor, aiRequestInterceptor, httpLoggingInterceptor});
    }

    @Provides
    @Singleton
    public final RetryRequestInterceptor provideNetworkInterceptor() {
        int i = 0;
        return new RetryRequestInterceptor(i, i, 3, null);
    }

    @Provides
    @Singleton
    public final CollectionsRequest provideCollectionRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (CollectionsRequest) requestFactory.createRequest(CollectionsRequest.class, collectionsApi(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final AnnotationsRequest provideAnnotationRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (AnnotationsRequest) requestFactory.createRequest(AnnotationsRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final FileActivitiesRequest provideFileActivitiesRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (FileActivitiesRequest) requestFactory.createRequest(FileActivitiesRequest.class, appApiBase(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final CollectionItemsRequest provideCollectionItemsRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (CollectionItemsRequest) requestFactory.createRequest(CollectionItemsRequest.class, collectionsApi(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final ItemInfoRequest provideItemInfoRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (ItemInfoRequest) requestFactory.createRequest(ItemInfoRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final FileRepresentationsRequest provideFileRepresentationsRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (FileRepresentationsRequest) requestFactory.createRequest(FileRepresentationsRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final FileVersionRequest provideFileVersionRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (FileVersionRequest) requestFactory.createRequest(FileVersionRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final UploadFileRequest provideUploadFileRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (UploadFileRequest) requestFactory.createRequest(UploadFileRequest.class, uploadFileApi(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final ChunkedFileUploadRequest provideChunkedUploadFileRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (ChunkedFileUploadRequest) requestFactory.createRequest(ChunkedFileUploadRequest.class, uploadFileApi(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final DeleteItemRequest provideDeleteItemRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (DeleteItemRequest) requestFactory.createRequest(DeleteItemRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final UpdateItemInfoRequest provideUpdateItemInfoRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (UpdateItemInfoRequest) requestFactory.createRequest(UpdateItemInfoRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final FileMetadataRequest provideFileMetadataRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (FileMetadataRequest) requestFactory.createRequest(FileMetadataRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final MetadataTemplatesRequest provideMetadataTemplatesRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (MetadataTemplatesRequest) requestFactory.createRequest(MetadataTemplatesRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final ItemCollaborationsRequest provideItemCollaborationsRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (ItemCollaborationsRequest) requestFactory.createRequest(ItemCollaborationsRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final PreflightCheckRequest providePreflightCheckRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (PreflightCheckRequest) requestFactory.createRequest(PreflightCheckRequest.class, preflightCheckApi(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final CreateFolderRequest provideCreateFolderRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (CreateFolderRequest) requestFactory.createRequest(CreateFolderRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final CommentRequest provideCommentRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (CommentRequest) requestFactory.createRequest(CommentRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()) + ApiConstants.UNDOC);
    }

    @Provides
    @Singleton
    public final TaskRequest provideTaskRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (TaskRequest) requestFactory.createRequest(TaskRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final CommentV2Request provideCommentV2Request(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (CommentV2Request) requestFactory.createRequest(CommentV2Request.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final InboxCollaborationRequest provideInboxCollaborationRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (InboxCollaborationRequest) requestFactory.createRequest(InboxCollaborationRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final PreviewDownloadRequest providePreviewDownloadRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (PreviewDownloadRequest) requestFactory.createRequest(PreviewDownloadRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final FolderItemsRequest provideGetFolderItemsRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (FolderItemsRequest) requestFactory.createRequest(FolderItemsRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final UpdateItemRequest provideUpdateItemRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (UpdateItemRequest) requestFactory.createRequest(UpdateItemRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final MetricsLoggingRequest provideGen204Request(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager, BVEManager bveManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        return (MetricsLoggingRequest) requestFactory.createRequest(MetricsLoggingRequest.class, bveManager.getBaseUri());
    }

    @Provides
    @Singleton
    public final RecentsRequest provideRecentsRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (RecentsRequest) requestFactory.createRequest(RecentsRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final RecentNotesRequest provideRecentNotesRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (RecentNotesRequest) requestFactory.createRequest(RecentNotesRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final DefaultNoteFolderRequest provideDefaultNoteFolderRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (DefaultNoteFolderRequest) requestFactory.createRequest(DefaultNoteFolderRequest.class, notesServerApi(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final FilesSearchRequest provideFilesSearchRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (FilesSearchRequest) requestFactory.createRequest(FilesSearchRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final Moshi provideMoshi() {
        return new MoshiProvider().buildMoshi();
    }

    @Provides
    @Singleton
    public final PushNotificationSettingsRequest providePushNotificationSettingsRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (PushNotificationSettingsRequest) requestFactory.createRequest(PushNotificationSettingsRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final InboxNotificationRequest provideInboxNotificationRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (InboxNotificationRequest) requestFactory.createRequest(InboxNotificationRequest.class, appApiBase(appRestrictionsManager));
    }

    @Provides
    @Singleton
    public final AuthRequest provideAnonymousAuthRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        if (appRestrictionsManager.isAppFedrampHighCompliant()) {
            return (AuthRequest) requestFactory.createRequest(AuthRequest.class, ApiConstants.BASE_URI_FEDRAMP);
        }
        return (AuthRequest) requestFactory.createRequest(AuthRequest.class, ApiConstants.BASE_URI);
    }

    @Provides
    @Singleton
    public final ClientSettingsRequest provideClientSettingsRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (ClientSettingsRequest) requestFactory.createRequest(ClientSettingsRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final DownloadFileRequest provideFileDownloadRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (DownloadFileRequest) requestFactory.createRequest(DownloadFileRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final BoxAiRequest provideBoxAiRequest(RequestFactory requestFactory, BVEManager bveManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        return (BoxAiRequest) requestFactory.createRequest(BoxAiRequest.class, bveManager.getBaseUri() + "app-api/intelligence/");
    }

    @Provides
    @Singleton
    public final HubAssetDownloadRequest provideHubAssetDownloadRequest(RequestFactory requestFactory, BVEManager bveManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        return (HubAssetDownloadRequest) requestFactory.createRequest(HubAssetDownloadRequest.class, bveManager.getCloudBaseUri());
    }

    @Provides
    @Singleton
    public final WatermarkRequest provideWatermarkRequest(RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        return (WatermarkRequest) requestFactory.createRequest(WatermarkRequest.class, app20(appRestrictionsManager.isAppFedrampHighCompliant()));
    }

    @Provides
    @Singleton
    public final EmptyBodyInterceptor provideEmptyBodyInterceptor() {
        return new EmptyBodyInterceptor();
    }

    @Provides
    @Singleton
    public final ICommentsController provideCommentsController(IUserContextManager contextManager, Context context, IBaseModelController baseModelController) {
        Intrinsics.checkNotNullParameter(contextManager, "contextManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseModelController, "baseModelController");
        return new BoxCommentsController(contextManager.getBoxSession(context), baseModelController, context);
    }

    @Provides
    @Singleton
    public final IBrowseController providesBrowseController(IUserContextManager userContextManager, BoxExtendedApiFile fileApi, BoxExtendedApiFolder folderApi, BoxExtendedApiSearch searchApi, Context context, @Named("api-executor") ThreadPoolExecutor apiExecutor, @Named("thumbnail-executor") ThreadPoolExecutor thumbnailExecutor) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(fileApi, "fileApi");
        Intrinsics.checkNotNullParameter(folderApi, "folderApi");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiExecutor, "apiExecutor");
        Intrinsics.checkNotNullParameter(thumbnailExecutor, "thumbnailExecutor");
        IBrowseController completedListener = new BrowseModelController(userContextManager.getBoxSession(context), fileApi, folderApi, searchApi, apiExecutor, thumbnailExecutor).setCompletedListener(new CompletionListener(LocalBroadcastManager.getInstance(context)));
        Intrinsics.checkNotNullExpressionValue(completedListener, "setCompletedListener(...)");
        return completedListener;
    }

    @Provides
    @Named("capture_shared_preferences")
    public final SharedPreferences captureSharedPreferences(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        SharedPreferences userSharedPrefs = userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.CAPTURE);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        return userSharedPrefs;
    }

    @Provides
    @Named("feature_flip_shared_preferences")
    public final SharedPreferences featureFlipDebugSharedPreferences(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        SharedPreferences userSharedPrefs = userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FEATURE_FLIP_DEBUG_OVERRIDE);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        return userSharedPrefs;
    }

    @Provides
    @Named("genius_scan_license_shared_preferences")
    public final SharedPreferences geniusScanLicenseSharedPreferences(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        SharedPreferences encryptedSharedPrefs = userContextManager.getEncryptedSharedPrefs(ILocalSharedPreferences.PreferenceName.GENIUS_SCAN_SDK_LICENSE);
        Intrinsics.checkNotNullExpressionValue(encryptedSharedPrefs, "getEncryptedSharedPrefs(...)");
        return encryptedSharedPrefs;
    }

    @Provides
    @Named("app_updates_shared_preferences")
    public final SharedPreferences appUpdatesSharedPreferences(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        SharedPreferences userSharedPrefs = userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.APP_UPDATES);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        return userSharedPrefs;
    }

    @Provides
    public final IdMappingService providesIdMappingService(ItemIdMappingService itemIdMappingService) {
        Intrinsics.checkNotNullParameter(itemIdMappingService, "itemIdMappingService");
        return itemIdMappingService;
    }

    @Provides
    @Singleton
    public final RumService provideRumService(ISessionManager sessionManager, IBVEManager bveManager, RumInstrumentation rumInstrumentation) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        Intrinsics.checkNotNullParameter(rumInstrumentation, "rumInstrumentation");
        return new RumObservability(sessionManager, rumInstrumentation, bveManager, BuildConfigProvider.INSTANCE.isDebugBuild());
    }

    @Provides
    @Singleton
    public final ApdexService providesApdexService(OpenTelemetryInstrumentation openTelemetryInstrumentation, RumService rumService) {
        Intrinsics.checkNotNullParameter(openTelemetryInstrumentation, "openTelemetryInstrumentation");
        Intrinsics.checkNotNullParameter(rumService, "rumService");
        return new ApdexTracker(openTelemetryInstrumentation, rumService);
    }

    @Provides
    @Singleton
    public final CookieManager providesCookieManager() {
        CookieManager cookieManager = CookieManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(cookieManager, "getInstance(...)");
        return cookieManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String providesBoxCsrfTokenManager$lambda$0() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Provides
    @Singleton
    public final BoxCsrfTokenManager providesBoxCsrfTokenManager(CookieManager cookieManager) {
        Intrinsics.checkNotNullParameter(cookieManager, "cookieManager");
        return new BoxCsrfTokenManager(cookieManager, new Function0() { // from class: com.box.android.data.di.DataProvidesModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DataProvidesModule.providesBoxCsrfTokenManager$lambda$0();
            }
        });
    }

    @Provides
    @Singleton
    @Named("recent_search_queries")
    public final DataStore<Preferences> providePreferencesDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DataModuleKt.getRecentSearchDataStore(context);
    }

    @Provides
    @Singleton
    @Named("last_used_tab")
    public final DataStore<Preferences> provideLastUsedTabDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DataModuleKt.getLastUsedTabDataStore(context);
    }

    @Provides
    @Singleton
    public final FirebaseRemoteConfig providesFirebaseRemoteConfig() {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        return firebaseRemoteConfig;
    }

    @Provides
    @Singleton
    public final IFileCanBePreviewedChecker providesFileCanBePreviewedChecker(FileCanBePreviewedChecker checker) {
        Intrinsics.checkNotNullParameter(checker, "checker");
        return checker;
    }
}
