package com.box.android.data.service.impl;

import androidx.window.core.layout.WindowSizeClass;
import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.apollographql.apollo3.exception.ApolloException;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.data.CopyItemMutation;
import com.box.android.data.CreateFolderMutation;
import com.box.android.data.GetFolderItemsQuery;
import com.box.android.data.GetFolderMiniQuery;
import com.box.android.data.GetFolderMiniWithParentQuery;
import com.box.android.data.GetItemNamesInFolderQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.data.JobCancellationHelper;
import com.box.android.data.MoveItemMutation;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.data.datasource.gql.DebouncePolicy;
import com.box.android.data.datasource.gql.cache.GQLEdgeHelper;
import com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor;
import com.box.android.data.fragment.ItemConnectionFragment;
import com.box.android.data.mappers.DataPolicyMapperKt;
import com.box.android.data.mappers.GQLCreateFolderToFolderModelMapper;
import com.box.android.data.mappers.GQLGetFolderItemsQueryEdgeToItemModelMapper;
import com.box.android.data.mappers.GQLGetFolderMiniQueryDataToFolderModelMapper;
import com.box.android.data.mappers.GQLGetFolderMiniWithParentQueryDataToFolderModelMapper;
import com.box.android.data.mappers.GQLGetItemQueryDataToItemModelMapper;
import com.box.android.data.mappers.GQLGetItemWithWatermarkDataQueryDataToItemModelMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.observability.BrowsePerformanceEvent;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.modules.dialog.AlertFragment;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: RemoteItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001BS\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010!J*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010!J*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ&\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ*\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170'2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J2\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J*\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010\u001eJ*\u0010-\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010\u001eJ\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020+H\u0087@¢\u0006\u0002\u00102J(\u0010?\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180@\u0012\u0004\u0012\u00020\u00190\u00170'2\u0006\u0010A\u001a\u00020 H\u0016J(\u0010?\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180@\u0012\u0004\u0012\u00020\u00190\u00170'2\u0006\u0010B\u001a\u00020\u001bH\u0017J\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020D0@2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0@H\u0002J\u0010\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020DH\u0002J(\u0010H\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180@\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010I\u001a\u00020JH\u0096@¢\u0006\u0002\u0010KJ(\u0010L\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0@\u0012\u0004\u0012\u00020M0\u00170'2\u0006\u0010I\u001a\u00020JH\u0007J\u001c\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0$0'2\u0006\u0010I\u001a\u00020JH\u0007J\"\u0010P\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010QJ\"\u0010P\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010R\u001a\u00020 H\u0096@¢\u0006\u0002\u0010SJ\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010$2\u0006\u0010I\u001a\u00020JH\u0087@¢\u0006\u0002\u0010KJ&\u0010U\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010\u001eJ&\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010\u001eJ&\u0010Y\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010\u001eJ*\u0010[\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\\\u001a\u00020J2\u0006\u0010]\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010^J2\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020JH\u0096@¢\u0006\u0002\u0010bJR\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020J2\u0006\u0010a\u001a\u00020J2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010f\u001a\u00020g2\b\b\u0002\u0010h\u001a\u00020gH\u0086@¢\u0006\u0002\u0010iJ>\u0010j\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020J2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010JH\u0087@¢\u0006\u0002\u0010mJ2\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020JH\u0096@¢\u0006\u0002\u0010bJ\"\u0010o\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010SJR\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020J2\u0006\u0010a\u001a\u00020J2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010f\u001a\u00020g2\b\b\u0002\u0010h\u001a\u00020gH\u0086@¢\u0006\u0002\u0010iJ>\u0010q\u001a\n\u0012\u0004\u0012\u00020r\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020J2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010JH\u0086@¢\u0006\u0002\u0010mJ\u0010\u0010s\u001a\u00020+2\u0006\u0010t\u001a\u00020\u0019H\u0007J:\u0010u\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020g0v2\u0006\u0010a\u001a\u00020J2\u0006\u0010d\u001a\u00020J2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0087@¢\u0006\u0002\u0010wJ\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020J0@2\u0006\u0010I\u001a\u00020JH\u0087@¢\u0006\u0002\u0010KJ\u0018\u0010y\u001a\u00020J2\u0006\u0010z\u001a\u00020J2\u0006\u0010{\u001a\u00020gH\u0007J&\u0010|\u001a\n\u0012\u0004\u0012\u00020}\u0018\u00010$2\u0006\u0010\\\u001a\u00020J2\u0006\u0010d\u001a\u00020JH\u0087@¢\u0006\u0002\u0010~J\"\u0010\u007f\u001a\u00020/2\u0006\u00100\u001a\u00020\u00182\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010JH\u0087@¢\u0006\u0003\u0010\u0081\u0001J\u0018\u0010\u0082\u0001\u001a\u00020/2\u0006\u00100\u001a\u00020\u0018H\u0087@¢\u0006\u0003\u0010\u0083\u0001J%\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020/\u0012\u0005\u0012\u00030\u0085\u00010\u00172\u0006\u00100\u001a\u00020\u0018H\u0087@¢\u0006\u0003\u0010\u0083\u0001J\u0019\u0010\u0086\u0001\u001a\u0004\u0018\u00010J2\u0006\u0010\u001a\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010QR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0002048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0002048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b:\u00106\u001a\u0004\b;\u00108R\u001c\u0010<\u001a\u0002048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b=\u00106\u001a\u0004\b>\u00108¨\u0006\u0088\u0001"}, d2 = {"Lcom/box/android/data/service/impl/RemoteItemService;", "Lcom/box/android/domain/services/IRemoteItemService;", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", "legacyCacheDataSource", "Lcom/box/android/data/datasource/LegacyCacheDataSource;", "gqlCacheHelper", "Lcom/box/android/data/utilities/GQLCacheHelper;", "gen204PerformanceLogger", "Lcom/box/android/domain/metrics/Gen204PerformanceLogger;", "baseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "folderApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "gqlPartialDataExtractor", "Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialDataExtractor;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;Lcom/box/android/data/datasource/LegacyCacheDataSource;Lcom/box/android/data/utilities/GQLCacheHelper;Lcom/box/android/domain/metrics/Gen204PerformanceLogger;Lcom/box/android/coreservices/modelcontroller/IBaseModelController;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialDataExtractor;Lcom/box/android/domain/services/IdMappingService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "item", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "dataPolicy", "Lcom/box/android/domain/configuration/DataPolicy;", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/configuration/DataPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/configuration/DataPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemWithWatermarkData", "gqlItemWithWatermarkData", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Data;", "observeItem", "Lkotlinx/coroutines/flow/Flow;", "folderMini", "Lcom/box/android/domain/models/item/FolderModel;", "includeParent", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/configuration/DataPolicy;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "folderMiniWithParent", "saveItemToCache", "", "itemModel", "isFromGqlCache", "(Lcom/box/android/domain/models/item/ItemModel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayFactor", "", "getDelayFactor$annotations", "()V", "getDelayFactor", "()J", "maxDelayInSeconds", "getMaxDelayInSeconds$annotations", "getMaxDelayInSeconds", "maxRetryCount", "getMaxRetryCount$annotations", "getMaxRetryCount", AlertFragment.ARG_ITEMS, "", "parent", "folderRemoteId", "getDistinctEdges", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "edges", "isValidEdge", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "fetchItemsFromLegacyCache", "folderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlCollectOnFlow", "Lcom/apollographql/apollo3/api/Error;", "gqlFolderItemsWatcherFromCache", "Lcom/box/android/data/GetFolderItemsQuery$Data;", "fetchFolderItemsFromRemote", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "folderID", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlFetchFolderItemsFromRemote", "gqlFolderMini", "Lcom/box/android/data/GetFolderMiniQuery$Data;", "gqlFolderMiniWithParent", "Lcom/box/android/data/GetFolderMiniWithParentQuery$Data;", "gqlItem", "Lcom/box/android/data/GetItemQuery$Data;", "createFolder", "name", "parentRemoteId", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB, "destinationRemoteId", "itemName", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveItem", IdentificationData.FIELD_PARENT_ID, "newName", "startingNumericSuffix", "", "retryAttempt", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlMoveItem", "Lcom/box/android/data/MoveItemMutation$Data;", "clientMutationId", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "updateCacheItemFromRemote", "copyItem", "gqlCopyItem", "Lcom/box/android/data/CopyItemMutation$Data;", "isNameConflictError", "error", "calculateNonConflictingName", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", GetItemNamesInFolderQuery.OPERATION_NAME, "buildDuplicateName", "initialName", "count", "gqlResponseCreateFolder", "Lcom/box/android/data/CreateFolderMutation$Data;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMovedItemInCache", "initialParentFolder", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCopiedItemInCache", "(Lcom/box/android/domain/models/item/ItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveInLegacyCache", "Lcom/box/android/data/datasource/CacheError$SaveError;", "gqlGetParentForItemFromCache", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RemoteItemService implements IRemoteItemService {
    public static final String LOGTAG = "RemoteItemService";
    private final IBaseModelController baseModelController;
    private final long delayFactor;
    private final BoxExtendedApiFolder folderApi;
    private final Gen204PerformanceLogger gen204PerformanceLogger;
    private final GQLCacheHelper gqlCacheHelper;
    private final GQLPartialDataExtractor gqlPartialDataExtractor;
    private final BoxGraphQL graphQL;
    private final IdMappingService idMappingService;
    private final CoroutineDispatcher ioDispatcher;
    private final LegacyCacheDataSource legacyCacheDataSource;
    private final long maxDelayInSeconds;
    private final long maxRetryCount;

    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$calculateNonConflictingName$1, reason: invalid class name */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND, 849}, m = "calculateNonConflictingName", n = {"itemName", IdentificationData.FIELD_PARENT_ID, "startingNumericSuffix", "retryAttempt", "itemName", IdentificationData.FIELD_PARENT_ID, "names", "startingNumericSuffix", "retryAttempt"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.calculateNonConflictingName(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$createFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {554, 566, 575, 586}, m = "createFolder", n = {"name", "parentRemoteId", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$createFolder$2", "name", "parentRemoteId", "$this$flatMap$iv", "response", "createFolder", "mappedFolderModel", "store", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$createFolder$4", "$i$a$-let-RemoteItemService$createFolder$4$1", "$i$a$-let-RemoteItemService$createFolder$4$1$1", "$i$a$-let-RemoteItemService$createFolder$4$1$1$1", "name", "parentRemoteId", "$this$flatMap$iv", "response", "createFolder", "mappedFolderModel", "store", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$createFolder$4", "$i$a$-let-RemoteItemService$createFolder$4$1", "$i$a$-let-RemoteItemService$createFolder$4$1$1", "$i$a$-let-RemoteItemService$createFolder$4$1$1$1", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$createFolder$4$1$1$1$2", "name", "parentRemoteId", "$this$flatMap$iv", "response", "createFolder", "mappedFolderModel", "store", "$this$flatMap$iv", "it", "$this$flatMap$iv", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$createFolder$4", "$i$a$-let-RemoteItemService$createFolder$4$1", "$i$a$-let-RemoteItemService$createFolder$4$1$1", "$i$a$-let-RemoteItemService$createFolder$4$1$1$1", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$createFolder$4$1$1$1$2", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$createFolder$4$1$1$1$2$2"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "I$8"}, v = 1)
    static final class C14921 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        int I$8;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C14921(Continuation<? super C14921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.createFolder(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$fetchFolderItemsFromRemote$3, reason: invalid class name */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {510, 512}, m = "fetchFolderItemsFromRemote", n = {"folderID", "folderID", "$this$flatMap$iv", "remoteId", "convertedId", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$fetchFolderItemsFromRemote$4"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.fetchFolderItemsFromRemote((ItemId) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$getItemNamesInFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0}, l = {875}, m = GetItemNamesInFolderQuery.OPERATION_NAME, n = {"folderId"}, s = {"L$0"}, v = 1)
    static final class C14971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14971(Continuation<? super C14971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.getItemNamesInFolder(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$gqlGetParentForItemFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {977, 995}, m = "gqlGetParentForItemFromCache", n = {"remoteId", "store", "query", "$i$a$-let-RemoteItemService$gqlGetParentForItemFromCache$2", "remoteId", "store", "query", "$i$a$-let-RemoteItemService$gqlGetParentForItemFromCache$2"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C15001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15001(Continuation<? super C15001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.gqlGetParentForItemFromCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$item$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {120, 122}, m = "item", n = {"itemId", "dataPolicy", "itemId", "dataPolicy", "$this$flatMap$iv", "remoteId", "convertedID", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$item$4"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C15023 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C15023(Continuation<? super C15023> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.item((ItemId) null, (DataPolicy) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$itemWithWatermarkData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {129, Token.LABEL}, m = "itemWithWatermarkData", n = {"itemId", "dataPolicy", "itemId", "dataPolicy", "$this$flatMap$iv", "remoteId", "convertedID", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$itemWithWatermarkData$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C15031 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C15031(Continuation<? super C15031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.itemWithWatermarkData((ItemId) null, (DataPolicy) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$updateCacheItemFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService", f = "RemoteItemService.kt", i = {0}, l = {725}, m = "updateCacheItemFromRemote", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class C15091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15091(Continuation<? super C15091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteItemService.this.updateCacheItemFromRemote(null, this);
        }
    }

    public static /* synthetic */ void getDelayFactor$annotations() {
    }

    public static /* synthetic */ void getMaxDelayInSeconds$annotations() {
    }

    public static /* synthetic */ void getMaxRetryCount$annotations() {
    }

    @Inject
    public RemoteItemService(BoxGraphQL graphQL, LegacyCacheDataSource legacyCacheDataSource, GQLCacheHelper gqlCacheHelper, Gen204PerformanceLogger gen204PerformanceLogger, IBaseModelController baseModelController, BoxExtendedApiFolder folderApi, GQLPartialDataExtractor gqlPartialDataExtractor, IdMappingService idMappingService, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        Intrinsics.checkNotNullParameter(legacyCacheDataSource, "legacyCacheDataSource");
        Intrinsics.checkNotNullParameter(gqlCacheHelper, "gqlCacheHelper");
        Intrinsics.checkNotNullParameter(gen204PerformanceLogger, "gen204PerformanceLogger");
        Intrinsics.checkNotNullParameter(baseModelController, "baseModelController");
        Intrinsics.checkNotNullParameter(folderApi, "folderApi");
        Intrinsics.checkNotNullParameter(gqlPartialDataExtractor, "gqlPartialDataExtractor");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.graphQL = graphQL;
        this.legacyCacheDataSource = legacyCacheDataSource;
        this.gqlCacheHelper = gqlCacheHelper;
        this.gen204PerformanceLogger = gen204PerformanceLogger;
        this.baseModelController = baseModelController;
        this.folderApi = folderApi;
        this.gqlPartialDataExtractor = gqlPartialDataExtractor;
        this.idMappingService = idMappingService;
        this.ioDispatcher = ioDispatcher;
        this.delayFactor = 1L;
        this.maxDelayInSeconds = 10L;
        this.maxRetryCount = 30L;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$item$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$item$2", f = "RemoteItemService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {91, 105}, m = "invokeSuspend", n = {"$this$withContext", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$item$2$1", "$this$withContext", "$this$flatMap$iv", "response", "data", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$item$2$3", "$i$a$-let-RemoteItemService$item$2$3$1"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
    static final class C15012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        final /* synthetic */ ItemId.Remote $remoteId;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15012(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super C15012> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15012 c15012 = RemoteItemService.this.new C15012(this.$remoteId, this.$dataPolicy, continuation);
            c15012.L$0 = obj;
            return c15012;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
            return ((C15012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result.Error error;
            Result.Error error2;
            GetItemQuery.Data data;
            ItemModel itemModel;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteItemService remoteItemService = RemoteItemService.this;
                    ItemId.Remote remote = this.$remoteId;
                    DataPolicy dataPolicy = this.$dataPolicy;
                    this.L$0 = coroutineScope;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    obj = remoteItemService.gqlItem(remote, dataPolicy, this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    itemModel = (ItemModel) this.L$6;
                    ResultKt.throwOnFailure(obj);
                }
                error2 = new Result.Success(itemModel);
                return error2;
                error = new Result.Success((ApolloResponse) obj);
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to get an item from GraphQL"));
            }
            RemoteItemService remoteItemService2 = RemoteItemService.this;
            ItemId.Remote remote2 = this.$remoteId;
            if (error instanceof Result.Success) {
                ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                if (apolloResponse != null && apolloResponse.hasErrors()) {
                    DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                    List<Error> list = apolloResponse.errors;
                    Intrinsics.checkNotNull(list);
                    error2 = new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
                } else {
                    if (apolloResponse != null && (data = (GetItemQuery.Data) apolloResponse.data) != null) {
                        ItemModel itemModel2 = (ItemModel) GraphQLMapper.fromGraphQL$default(GQLGetItemQueryDataToItemModelMapper.INSTANCE, data, null, 2, null);
                        boolean zIsFromCache = NormalizedCache.isFromCache(apolloResponse);
                        this.L$0 = coroutineScope;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(error);
                        this.L$2 = remoteItemService2;
                        this.L$3 = remote2;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(apolloResponse);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(data);
                        this.L$6 = itemModel2;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 2;
                        if (remoteItemService2.saveItemToCache(itemModel2, zIsFromCache, this) != coroutine_suspended) {
                            itemModel = itemModel2;
                            error2 = new Result.Success(itemModel);
                        }
                        return coroutine_suspended;
                    }
                    remoteItemService2.gqlCacheHelper.logCacheError("Response is null for get an item " + remote2.getBoxId());
                    error2 = new Result.Error(new DomainError.UnknownError("Could not get an item " + remote2.getBoxId()));
                }
                return error2;
            }
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.services.IRemoteItemService
    public Object item(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C15012(remote, dataPolicy, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        if (r10 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IItemService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object item(com.box.android.domain.models.ItemId r8, com.box.android.domain.configuration.DataPolicy r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.domain.models.DomainError>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.box.android.data.service.impl.RemoteItemService.C15023
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.data.service.impl.RemoteItemService$item$3 r0 = (com.box.android.data.service.impl.RemoteItemService.C15023) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.data.service.impl.RemoteItemService$item$3 r0 = new com.box.android.data.service.impl.RemoteItemService$item$3
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5a
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            int r7 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r7 = r0.L$4
            com.box.android.domain.models.ItemId$Remote r7 = (com.box.android.domain.models.ItemId.Remote) r7
            java.lang.Object r7 = r0.L$3
            com.box.android.domain.models.ItemId$Remote r7 = (com.box.android.domain.models.ItemId.Remote) r7
            java.lang.Object r7 = r0.L$2
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            java.lang.Object r7 = r0.L$1
            com.box.android.domain.configuration.DataPolicy r7 = (com.box.android.domain.configuration.DataPolicy) r7
            java.lang.Object r7 = r0.L$0
            com.box.android.domain.models.ItemId r7 = (com.box.android.domain.models.ItemId) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lb8
        L45:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4d:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            com.box.android.domain.configuration.DataPolicy r9 = (com.box.android.domain.configuration.DataPolicy) r9
            java.lang.Object r8 = r0.L$0
            com.box.android.domain.models.ItemId r8 = (com.box.android.domain.models.ItemId) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L70
        L5a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.box.android.domain.services.IdMappingService r10 = r7.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r2
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r10.getRemoteIdOrError(r8, r0)
            if (r10 != r1) goto L70
            goto Lb7
        L70:
            com.box.android.domain.utils.result.Result r10 = (com.box.android.domain.utils.result.Result) r10
            boolean r2 = r10 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto Lbb
            r2 = r10
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.domain.models.ItemId$Remote r4 = new com.box.android.domain.models.ItemId$Remote
            java.lang.String r5 = r2.getBoxId()
            com.box.android.domain.models.item.ItemType r6 = r2.getType()
            r4.<init>(r5, r6)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$2 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$3 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$4 = r8
            r8 = 0
            r0.I$0 = r8
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r10 = r7.item(r4, r9, r0)
            if (r10 != r1) goto Lb8
        Lb7:
            return r1
        Lb8:
            com.box.android.domain.utils.result.Result r10 = (com.box.android.domain.utils.result.Result) r10
            return r10
        Lbb:
            boolean r7 = r10 instanceof com.box.android.domain.utils.result.Result.Error
            if (r7 == 0) goto Lc0
            return r10
        Lc0:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.item(com.box.android.domain.models.ItemId, com.box.android.domain.configuration.DataPolicy, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        if (r10 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IRemoteItemService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object itemWithWatermarkData(com.box.android.domain.models.ItemId r8, com.box.android.domain.configuration.DataPolicy r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.domain.models.DomainError>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.box.android.data.service.impl.RemoteItemService.C15031
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.data.service.impl.RemoteItemService$itemWithWatermarkData$1 r0 = (com.box.android.data.service.impl.RemoteItemService.C15031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.data.service.impl.RemoteItemService$itemWithWatermarkData$1 r0 = new com.box.android.data.service.impl.RemoteItemService$itemWithWatermarkData$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5a
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            int r7 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r7 = r0.L$4
            com.box.android.domain.models.ItemId$Remote r7 = (com.box.android.domain.models.ItemId.Remote) r7
            java.lang.Object r7 = r0.L$3
            com.box.android.domain.models.ItemId$Remote r7 = (com.box.android.domain.models.ItemId.Remote) r7
            java.lang.Object r7 = r0.L$2
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            java.lang.Object r7 = r0.L$1
            com.box.android.domain.configuration.DataPolicy r7 = (com.box.android.domain.configuration.DataPolicy) r7
            java.lang.Object r7 = r0.L$0
            com.box.android.domain.models.ItemId r7 = (com.box.android.domain.models.ItemId) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lb8
        L45:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4d:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            com.box.android.domain.configuration.DataPolicy r9 = (com.box.android.domain.configuration.DataPolicy) r9
            java.lang.Object r8 = r0.L$0
            com.box.android.domain.models.ItemId r8 = (com.box.android.domain.models.ItemId) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L70
        L5a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.box.android.domain.services.IdMappingService r10 = r7.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r2
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r10.getRemoteIdOrError(r8, r0)
            if (r10 != r1) goto L70
            goto Lb7
        L70:
            com.box.android.domain.utils.result.Result r10 = (com.box.android.domain.utils.result.Result) r10
            boolean r2 = r10 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto Lbb
            r2 = r10
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.domain.models.ItemId$Remote r4 = new com.box.android.domain.models.ItemId$Remote
            java.lang.String r5 = r2.getBoxId()
            com.box.android.domain.models.item.ItemType r6 = r2.getType()
            r4.<init>(r5, r6)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$2 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$3 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$4 = r8
            r8 = 0
            r0.I$0 = r8
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r10 = r7.itemWithWatermarkData(r4, r9, r0)
            if (r10 != r1) goto Lb8
        Lb7:
            return r1
        Lb8:
            com.box.android.domain.utils.result.Result r10 = (com.box.android.domain.utils.result.Result) r10
            return r10
        Lbb:
            boolean r7 = r10 instanceof com.box.android.domain.utils.result.Result.Error
            if (r7 == 0) goto Lc0
            return r10
        Lc0:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.itemWithWatermarkData(com.box.android.domain.models.ItemId, com.box.android.domain.configuration.DataPolicy, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$itemWithWatermarkData$4, reason: invalid class name */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$itemWithWatermarkData$4", f = "RemoteItemService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {Token.SCRIPT, Token.LET}, m = "invokeSuspend", n = {"$this$withContext", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$itemWithWatermarkData$4$1", "$this$withContext", "$this$flatMap$iv", "response", "data", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$itemWithWatermarkData$4$3", "$i$a$-let-RemoteItemService$itemWithWatermarkData$4$3$1"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        final /* synthetic */ ItemId.Remote $remoteId;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = RemoteItemService.this.new AnonymousClass4(this.$remoteId, this.$dataPolicy, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result.Error error;
            Result.Error error2;
            GetItemWithWatermarkDataQuery.Data data;
            ItemModel itemModel;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteItemService remoteItemService = RemoteItemService.this;
                    ItemId.Remote remote = this.$remoteId;
                    DataPolicy dataPolicy = this.$dataPolicy;
                    this.L$0 = coroutineScope;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    obj = remoteItemService.gqlItemWithWatermarkData(remote, dataPolicy, this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    itemModel = (ItemModel) this.L$6;
                    ResultKt.throwOnFailure(obj);
                }
                error2 = new Result.Success(itemModel);
                return error2;
                error = new Result.Success((ApolloResponse) obj);
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to get an item with watermark data from GraphQL"));
            }
            RemoteItemService remoteItemService2 = RemoteItemService.this;
            ItemId.Remote remote2 = this.$remoteId;
            if (error instanceof Result.Success) {
                ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                if (apolloResponse != null && apolloResponse.hasErrors()) {
                    DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                    List<Error> list = apolloResponse.errors;
                    Intrinsics.checkNotNull(list);
                    error2 = new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
                } else {
                    if (apolloResponse != null && (data = (GetItemWithWatermarkDataQuery.Data) apolloResponse.data) != null) {
                        ItemModel itemModel2 = (ItemModel) GraphQLMapper.fromGraphQL$default(GQLGetItemWithWatermarkDataQueryDataToItemModelMapper.INSTANCE, data, null, 2, null);
                        this.L$0 = coroutineScope;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(error);
                        this.L$2 = remoteItemService2;
                        this.L$3 = remote2;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(apolloResponse);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(data);
                        this.L$6 = itemModel2;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 2;
                        if (remoteItemService2.saveItemToCache(itemModel2, false, this) != coroutine_suspended) {
                            itemModel = itemModel2;
                            error2 = new Result.Success(itemModel);
                        }
                        return coroutine_suspended;
                    }
                    remoteItemService2.gqlCacheHelper.logCacheError("Response is null for get an item with watermark data " + remote2.getBoxId());
                    error2 = new Result.Error(new DomainError.UnknownError("Could not get an item with watermark data " + remote2.getBoxId()));
                }
                return error2;
            }
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object itemWithWatermarkData(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AnonymousClass4(remote, dataPolicy, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object gqlItemWithWatermarkData(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super ApolloResponse<GetItemWithWatermarkDataQuery.Data>> continuation) {
        ApolloCall<GetItemWithWatermarkDataQuery.Data> apolloCallItemWithWatermarkData = this.graphQL.itemWithWatermarkData(remote.getBoxId(), remote.getType().getValue(), DataPolicyMapperKt.cachePolicyRepresentation(dataPolicy));
        if (apolloCallItemWithWatermarkData == null) {
            return null;
        }
        Object objExecute = apolloCallItemWithWatermarkData.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$observeItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$observeItem$1", f = "RemoteItemService.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {178, 190, 199, JfifUtil.MARKER_RST7, 223}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "remoteId", "$this$mapError$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-RemoteItemService$observeItem$1$1", "$i$f$mapError", "$i$a$-mapError-RemoteItemService$observeItem$1$1$2", "$this$flow", "$this$onSuccess$iv", "remoteId", "$this$map$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-RemoteItemService$observeItem$1$1", "$i$f$map", "$i$a$-map-RemoteItemService$observeItem$1$1$3", "$this$flow", "$this$onSuccess$iv", "remoteId", "$this$map$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-RemoteItemService$observeItem$1$1", "$i$f$map", "$i$a$-map-RemoteItemService$observeItem$1$1$3", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-RemoteItemService$observeItem$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C15071 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends ItemModel, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        final /* synthetic */ ItemId $itemId;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15071(ItemId itemId, DataPolicy dataPolicy, Continuation<? super C15071> continuation) {
            super(2, continuation);
            this.$itemId = itemId;
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15071 c15071 = RemoteItemService.this.new C15071(this.$itemId, this.$dataPolicy, continuation);
            c15071.L$0 = obj;
            return c15071;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends ItemModel, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15071) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x013c  */
        /* JADX WARN: Code duplicated, block: B:39:0x0147  */
        /* JADX WARN: Code duplicated, block: B:42:0x0172  */
        /* JADX WARN: Code duplicated, block: B:47:0x01c4  */
        /* JADX WARN: Code duplicated, block: B:50:0x01c9  */
        /* JADX WARN: Code duplicated, block: B:58:0x01dd  */
        /* JADX WARN: Code duplicated, block: B:60:0x01e1  */
        /* JADX WARN: Code duplicated, block: B:63:0x0210  */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x016e, code lost:
        
            if (r10.collect(r4, r17) == r3) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x01b6, code lost:
        
            if (r2.emit(r8, r17) == r3) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x020d, code lost:
        
            if (r2.emit(r4, r17) == r3) goto L62;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 543
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.C15071.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IItemService
    public Flow<Result<ItemModel, DomainError>> observeItem(ItemId itemId, DataPolicy dataPolicy) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(dataPolicy, "dataPolicy");
        return FlowKt.flow(new C15071(itemId, dataPolicy, null));
    }

    @Override // com.box.android.domain.services.IRemoteItemService
    public Object folderMini(ItemId.Remote remote, DataPolicy dataPolicy, boolean z, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        boolean z2 = z && !Intrinsics.areEqual(remote.getBoxId(), "0");
        if (z2) {
            return folderMiniWithParent(remote, dataPolicy, continuation);
        }
        if (z2) {
            throw new NoWhenBranchMatchedException();
        }
        return folderMini(remote, dataPolicy, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$folderMini$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$folderMini$3", f = "RemoteItemService.kt", i = {0, 0, 0}, l = {236}, m = "invokeSuspend", n = {"$this$withContext", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$folderMini$3$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C14953 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FolderModel, ? extends DomainError>>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        final /* synthetic */ ItemId.Remote $item;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14953(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super C14953> continuation) {
            super(2, continuation);
            this.$item = remote;
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14953 c14953 = RemoteItemService.this.new C14953(this.$item, this.$dataPolicy, continuation);
            c14953.L$0 = obj;
            return c14953;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends FolderModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<FolderModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
            return ((C14953) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result.Error error;
            Result.Error error2;
            GetFolderMiniQuery.Data data;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteItemService remoteItemService = RemoteItemService.this;
                    ItemId.Remote remote = this.$item;
                    DataPolicy dataPolicy = this.$dataPolicy;
                    this.L$0 = coroutineScope;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    obj = remoteItemService.gqlFolderMini(remote, dataPolicy, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                error = new Result.Success((ApolloResponse) obj);
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to get a folder mini for an item from GraphQL"));
            }
            RemoteItemService remoteItemService2 = RemoteItemService.this;
            ItemId.Remote remote2 = this.$item;
            if (error instanceof Result.Success) {
                ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                if (apolloResponse != null && apolloResponse.hasErrors()) {
                    DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                    List<Error> list = apolloResponse.errors;
                    Intrinsics.checkNotNull(list);
                    return new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
                }
                if (apolloResponse != null && (data = (GetFolderMiniQuery.Data) apolloResponse.data) != null) {
                    error2 = new Result.Success((FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetFolderMiniQueryDataToFolderModelMapper.INSTANCE, data, null, 2, null));
                } else {
                    remoteItemService2.gqlCacheHelper.logCacheError("Response is null for get a folder mini for an item " + remote2.getBoxId());
                    error2 = new Result.Error(new DomainError.UnknownError("Could not get a folder mini for an item " + remote2.getBoxId()));
                }
                return error2;
            }
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final Object folderMini(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C14953(remote, dataPolicy, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$folderMiniWithParent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$folderMiniWithParent$2", f = "RemoteItemService.kt", i = {0, 0, 0}, l = {270}, m = "invokeSuspend", n = {"$this$withContext", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$folderMiniWithParent$2$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C14962 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FolderModel, ? extends DomainError>>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        final /* synthetic */ ItemId.Remote $remoteId;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14962(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super C14962> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14962 c14962 = RemoteItemService.this.new C14962(this.$remoteId, this.$dataPolicy, continuation);
            c14962.L$0 = obj;
            return c14962;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends FolderModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<FolderModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
            return ((C14962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result.Error error;
            Result.Error error2;
            GetFolderMiniWithParentQuery.Data data;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteItemService remoteItemService = RemoteItemService.this;
                    ItemId.Remote remote = this.$remoteId;
                    DataPolicy dataPolicy = this.$dataPolicy;
                    this.L$0 = coroutineScope;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    obj = remoteItemService.gqlFolderMiniWithParent(remote, dataPolicy, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                error = new Result.Success((ApolloResponse) obj);
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to get a folder mini with parent for an item from GraphQL"));
            }
            RemoteItemService remoteItemService2 = RemoteItemService.this;
            ItemId.Remote remote2 = this.$remoteId;
            if (error instanceof Result.Success) {
                ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                if (apolloResponse != null && apolloResponse.hasErrors()) {
                    DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                    List<Error> list = apolloResponse.errors;
                    Intrinsics.checkNotNull(list);
                    return new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
                }
                if (apolloResponse != null && (data = (GetFolderMiniWithParentQuery.Data) apolloResponse.data) != null) {
                    error2 = new Result.Success((FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetFolderMiniWithParentQueryDataToFolderModelMapper.INSTANCE, data, null, 2, null));
                } else {
                    remoteItemService2.gqlCacheHelper.logCacheError("Response is null for get a folder mini with parent for an item " + remote2.getBoxId());
                    error2 = new Result.Error(new DomainError.UnknownError("Could not get a folder mini with parent for an item " + remote2.getBoxId()));
                }
                return error2;
            }
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final Object folderMiniWithParent(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C14962(remote, dataPolicy, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$saveItemToCache$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$saveItemToCache$2", f = "RemoteItemService.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFromGqlCache;
        final /* synthetic */ ItemModel $itemModel;
        int label;
        final /* synthetic */ RemoteItemService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15082(boolean z, RemoteItemService remoteItemService, ItemModel itemModel, Continuation<? super C15082> continuation) {
            super(2, continuation);
            this.$isFromGqlCache = z;
            this.this$0 = remoteItemService;
            this.$itemModel = itemModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C15082(this.$isFromGqlCache, this.this$0, this.$itemModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$isFromGqlCache) {
                    this.label = 1;
                    obj = this.this$0.saveInLegacyCache(this.$itemModel, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (obj instanceof Result.Error) {
                this.this$0.gqlCacheHelper.logCacheError("Saving item to legacy cache unsuccessful: " + this.$itemModel);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object saveItemToCache(ItemModel itemModel, boolean z, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C15082(z, this, itemModel, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final long getDelayFactor() {
        return this.delayFactor;
    }

    public final long getMaxDelayInSeconds() {
        return this.maxDelayInSeconds;
    }

    public final long getMaxRetryCount() {
        return this.maxRetryCount;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$items$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$items$1", f = "RemoteItemService.kt", i = {0, 1, 1, 1, 2, 2}, l = {331, 334, 336}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "remoteId", "convertedId", "$this$flow", "remoteId"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
    static final class C15041 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $parent;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15041(ItemId itemId, Continuation<? super C15041> continuation) {
            super(2, continuation);
            this.$parent = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15041 c15041 = RemoteItemService.this.new C15041(this.$parent, continuation);
            c15041.L$0 = obj;
            return c15041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15041) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, r7.this$0.items(r2), r7) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x009b, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Success(kotlin.collections.CollectionsKt.emptyList()), r7) == r1) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L2f
                if (r2 == r5) goto L2b
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L22
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                java.lang.Object r0 = r7.L$2
                com.box.android.domain.models.ItemId$Remote r0 = (com.box.android.domain.models.ItemId.Remote) r0
            L22:
                java.lang.Object r7 = r7.L$1
                com.box.android.domain.models.ItemId$Remote r7 = (com.box.android.domain.models.ItemId.Remote) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L9e
            L2b:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L48
            L2f:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.data.service.impl.RemoteItemService r8 = com.box.android.data.service.impl.RemoteItemService.this
                com.box.android.domain.services.IdMappingService r8 = com.box.android.data.service.impl.RemoteItemService.access$getIdMappingService$p(r8)
                com.box.android.domain.models.ItemId r2 = r7.$parent
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.label = r5
                java.lang.Object r8 = r8.getRemoteId(r2, r6)
                if (r8 != r1) goto L48
                goto L9d
            L48:
                com.box.android.domain.models.ItemId$Remote r8 = (com.box.android.domain.models.ItemId.Remote) r8
                if (r8 == 0) goto L7d
                com.box.android.domain.models.ItemId$Remote r2 = new com.box.android.domain.models.ItemId$Remote
                java.lang.String r3 = r8.getBoxId()
                com.box.android.domain.models.item.ItemType r5 = r8.getType()
                r2.<init>(r3, r5)
                com.box.android.data.service.impl.RemoteItemService r3 = com.box.android.data.service.impl.RemoteItemService.this
                kotlinx.coroutines.flow.Flow r3 = r3.items(r2)
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r6
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r7.L$2 = r8
                r7.label = r4
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.emitAll(r0, r3, r5)
                if (r7 != r1) goto L9e
                goto L9d
            L7d:
                com.box.android.domain.utils.result.Result$Success r2 = new com.box.android.domain.utils.result.Result$Success
                java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
                r2.<init>(r4)
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                r7.label = r3
                java.lang.Object r7 = r0.emit(r2, r4)
                if (r7 != r1) goto L9e
            L9d:
                return r1
            L9e:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.C15041.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IItemService
    public Flow<Result<List<ItemModel>, DomainError>> items(ItemId parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return FlowKt.flow(new C15041(parent, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$items$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$items$2", f = "RemoteItemService.kt", i = {0}, l = {363}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
    static final class C15052 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $currentDelayInSeconds;
        final /* synthetic */ ItemId.Remote $folderRemoteId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15052(ItemId.Remote remote, Ref.LongRef longRef, Continuation<? super C15052> continuation) {
            super(2, continuation);
            this.$folderRemoteId = remote;
            this.$currentDelayInSeconds = longRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15052 c15052 = RemoteItemService.this.new C15052(this.$folderRemoteId, this.$currentDelayInSeconds, continuation);
            c15052.L$0 = obj;
            return c15052;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15052) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM16356catch = FlowKt.m16356catch(FlowKt.retry(RemoteItemService.this.gqlCollectOnFlow(this.$folderRemoteId.getBoxId()), RemoteItemService.this.getMaxRetryCount(), new AnonymousClass1(this.$currentDelayInSeconds, RemoteItemService.this, null)), new C01702(this.$folderRemoteId, flowCollector, null));
                final RemoteItemService remoteItemService = RemoteItemService.this;
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.label = 1;
                if (flowM16356catch.collect(new FlowCollector() { // from class: com.box.android.data.service.impl.RemoteItemService.items.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Result<? extends List<ItemConnectionFragment.Edge>, Error>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Result<? extends List<ItemConnectionFragment.Edge>, Error> result, Continuation<? super Unit> continuation) {
                        if (result instanceof Result.Success) {
                            List distinctEdges = remoteItemService.getDistinctEdges((List) ((Result.Success) result).getValue());
                            RemoteItemService remoteItemService2 = remoteItemService;
                            ArrayList arrayList = new ArrayList();
                            for (T t : distinctEdges) {
                                if (remoteItemService2.isValidEdge((ItemConnectionFragment.Edge) t)) {
                                    arrayList.add(t);
                                }
                            }
                            ArrayList arrayList2 = arrayList;
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                            Iterator<T> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList3.add((ItemModel) GraphQLMapper.fromGraphQL$default(GQLGetFolderItemsQueryEdgeToItemModelMapper.INSTANCE, (ItemConnectionFragment.Edge) it.next(), null, 2, null));
                            }
                            ArrayList arrayList4 = arrayList3;
                            BoxLogUtils.v("Emitting ItemModels " + arrayList4.size());
                            Object objEmit = flowCollector.emit(new Result.Success(arrayList4), continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }
                        if (!(result instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Object objEmit2 = flowCollector.emit(new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Error) ((Result.Error) result).getValue())), continuation);
                        return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$items$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RemoteItemService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$items$2$1", f = "RemoteItemService.kt", i = {0}, l = {349}, m = "invokeSuspend", n = {"cause"}, s = {"L$0"}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {
            final /* synthetic */ Ref.LongRef $currentDelayInSeconds;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ RemoteItemService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Ref.LongRef longRef, RemoteItemService remoteItemService, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$currentDelayInSeconds = longRef;
                this.this$0 = remoteItemService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentDelayInSeconds, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Throwable th, Continuation<? super Boolean> continuation) {
                return ((AnonymousClass1) create(th, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Throwable th = (Throwable) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                boolean z = true;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    BoxLogUtils.v("Retrying flow due to cause: " + th.getMessage());
                    if (th instanceof ApolloException) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(th);
                        this.label = 1;
                        if (DelayKt.delay(this.$currentDelayInSeconds.element * ((long) 1000), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        z = false;
                    }
                    return Boxing.boxBoolean(z);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$currentDelayInSeconds.element = Long.min(this.this$0.getMaxDelayInSeconds(), this.$currentDelayInSeconds.element + this.this$0.getDelayFactor());
                return Boxing.boxBoolean(z);
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$items$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RemoteItemService.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "Lcom/apollographql/apollo3/api/Error;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$items$2$2", f = "RemoteItemService.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01702 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends ItemConnectionFragment.Edge>, ? extends Error>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<Result<? extends List<? extends ItemModel>, ? extends DomainError>> $$this$flow;
            final /* synthetic */ ItemId.Remote $folderRemoteId;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01702(ItemId.Remote remote, FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation<? super C01702> continuation) {
                super(3, continuation);
                this.$folderRemoteId = remote;
                this.$$this$flow = flowCollector;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends ItemConnectionFragment.Edge>, ? extends Error>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super Result<? extends List<ItemConnectionFragment.Edge>, Error>>) flowCollector, th, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super Result<? extends List<ItemConnectionFragment.Edge>, Error>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new C01702(this.$folderRemoteId, this.$$this$flow, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    BoxLogUtils.v("Caught exception during items flow for folder id " + this.$folderRemoteId.getBoxId());
                    this.label = 1;
                    if (this.$$this$flow.emit(new Result.Error(new DomainError.CacheReadError(null, 1, null)), this) == coroutine_suspended) {
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
    }

    @Override // com.box.android.domain.services.IRemoteItemService
    public Flow<Result<List<ItemModel>, DomainError>> items(ItemId.Remote folderRemoteId) {
        Intrinsics.checkNotNullParameter(folderRemoteId, "folderRemoteId");
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = 1L;
        return FlowKt.flowOn(FlowKt.flow(new C15052(folderRemoteId, longRef, null)), this.ioDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ItemConnectionFragment.Edge> getDistinctEdges(List<ItemConnectionFragment.Edge> edges) {
        List<ItemConnectionFragment.Edge> listGqlDistinctEdgesById = this.gqlCacheHelper.gqlDistinctEdgesById(edges);
        if (listGqlDistinctEdgesById.size() != edges.size()) {
            BoxLogUtils.e(LOGTAG, "There are duplicate edge ids => Original edges: " + edges.size() + " size vs Distinct edges: " + listGqlDistinctEdgesById.size() + " size");
        }
        return listGqlDistinctEdgesById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidEdge(ItemConnectionFragment.Edge edge) {
        if (GQLEdgeHelper.INSTANCE.isCorrectEdgeIdFormat(edge.getId())) {
            return true;
        }
        BoxLogUtils.e(LOGTAG, "Edge id has incorrect format: " + edge.getId());
        return false;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$fetchItemsFromLegacyCache$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$fetchItemsFromLegacyCache$2", f = "RemoteItemService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C14942 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Object> {
        final /* synthetic */ String $folderId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14942(String str, Continuation<? super C14942> continuation) {
            super(2, continuation);
            this.$folderId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteItemService.this.new C14942(this.$folderId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
            return ((C14942) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                IBaseModelController iBaseModelController = RemoteItemService.this.baseModelController;
                BoxRequestsFolder.GetFolderWithAllItems folderWithAllItems = RemoteItemService.this.folderApi.getFolderWithAllItems(this.$folderId);
                Intrinsics.checkNotNullExpressionValue(folderWithAllItems, "getFolderWithAllItems(...)");
                BoxResponse boxResponse = iBaseModelController.performLocal(folderWithAllItems).get();
                BoxFolder boxFolder = (BoxFolder) boxResponse.getResult();
                if (boxResponse.isSuccess() && boxFolder != null) {
                    Iterable<BoxItem> entries = boxFolder.getItemCollection().getEntries();
                    Intrinsics.checkNotNullExpressionValue(entries, "getEntries(...)");
                    ArrayList arrayList = new ArrayList();
                    for (BoxItem boxItem : entries) {
                        ItemModelMapper itemModelMapper = ItemModelMapper.INSTANCE;
                        Intrinsics.checkNotNull(boxItem);
                        ItemModel itemModel = itemModelMapper.toItemModel(boxItem);
                        if (itemModel != null) {
                            arrayList.add(itemModel);
                        }
                    }
                    return new Result.Success(arrayList);
                }
                DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                Exception exception = boxResponse.getException();
                Intrinsics.checkNotNullExpressionValue(exception, "getException(...)");
                return new Result.Error(domainErrorMapper.toDomainError(exception, "Couldn't fetch items from legacy cache"));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.IRemoteItemService
    public Object fetchItemsFromLegacyCache(String str, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C14942(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$gqlCollectOnFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "Lcom/apollographql/apollo3/api/Error;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$gqlCollectOnFlow$1", f = "RemoteItemService.kt", i = {0}, l = {423}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
    static final class C14981 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends ItemConnectionFragment.Edge>, ? extends Error>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $folderId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14981(String str, Continuation<? super C14981> continuation) {
            super(2, continuation);
            this.$folderId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14981 c14981 = RemoteItemService.this.new C14981(this.$folderId, continuation);
            c14981.L$0 = obj;
            return c14981;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends ItemConnectionFragment.Edge>, ? extends Error>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<ItemConnectionFragment.Edge>, Error>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<ItemConnectionFragment.Edge>, Error>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C14981) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.label = 1;
                if (RemoteItemService.this.gqlFolderItemsWatcherFromCache(this.$folderId).collect(new FlowCollector() { // from class: com.box.android.data.service.impl.RemoteItemService.gqlCollectOnFlow.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ApolloResponse<GetFolderItemsQuery.Data>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ApolloResponse<GetFolderItemsQuery.Data> apolloResponse, Continuation<? super Unit> continuation) {
                        GetFolderItemsQuery.Folder folder;
                        GetFolderItemsQuery.ItemConnection itemConnection;
                        ItemConnectionFragment itemConnectionFragment;
                        List<ItemConnectionFragment.Edge> edges;
                        if (NormalizedCache.isFromCache(apolloResponse) && apolloResponse.data == 0) {
                            throw new ApolloException("Cold cache read", null, 2, null);
                        }
                        if (apolloResponse.hasErrors()) {
                            BoxLogUtils.w("Unexpected: Local cache query returning errors: " + apolloResponse.errors);
                            FlowCollector<Result<? extends List<ItemConnectionFragment.Edge>, Error>> flowCollector2 = flowCollector;
                            List<Error> list = apolloResponse.errors;
                            Intrinsics.checkNotNull(list);
                            Object objEmit = flowCollector2.emit(new Result.Error(CollectionsKt.first((List) list)), continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }
                        GetFolderItemsQuery.Data data = (GetFolderItemsQuery.Data) apolloResponse.data;
                        if (data != null && (folder = data.getFolder()) != null && (itemConnection = folder.getItemConnection()) != null && (itemConnectionFragment = itemConnection.getItemConnectionFragment()) != null && (edges = itemConnectionFragment.getEdges()) != null) {
                            FlowCollector<Result<? extends List<ItemConnectionFragment.Edge>, Error>> flowCollector3 = flowCollector;
                            BoxLogUtils.v("Fetched " + edges.size() + " edges from cache");
                            Object objEmit2 = flowCollector3.emit(new Result.Success(edges), continuation);
                            if (objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return objEmit2;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    public final Flow<Result<List<ItemConnectionFragment.Edge>, Error>> gqlCollectOnFlow(String folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return FlowKt.flow(new C14981(folderId, null));
    }

    public final Flow<ApolloResponse<GetFolderItemsQuery.Data>> gqlFolderItemsWatcherFromCache(String folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return this.graphQL.watchWithPreliminaryData(new GetFolderItemsQuery(folderId), new C14991(null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$gqlFolderItemsWatcherFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetFolderItemsQuery$Data;", "it", "Lcom/box/android/data/GetFolderItemsQuery;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$gqlFolderItemsWatcherFromCache$1", f = "RemoteItemService.kt", i = {0}, l = {445}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
    static final class C14991 extends SuspendLambda implements Function2<GetFolderItemsQuery, Continuation<? super ApolloResponse<GetFolderItemsQuery.Data>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C14991(Continuation<? super C14991> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14991 c14991 = RemoteItemService.this.new C14991(continuation);
            c14991.L$0 = obj;
            return c14991;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(GetFolderItemsQuery getFolderItemsQuery, Continuation<? super ApolloResponse<GetFolderItemsQuery.Data>> continuation) {
            return ((C14991) create(getFolderItemsQuery, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GetFolderItemsQuery getFolderItemsQuery = (GetFolderItemsQuery) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(getFolderItemsQuery);
            this.label = 1;
            Object objExtractPartialFolderItemsFromCache = RemoteItemService.this.gqlPartialDataExtractor.extractPartialFolderItemsFromCache(getFolderItemsQuery, this);
            return objExtractPartialFolderItemsFromCache == coroutine_suspended ? coroutine_suspended : objExtractPartialFolderItemsFromCache;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$fetchFolderItemsFromRemote$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$fetchFolderItemsFromRemote$2", f = "RemoteItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {456, 483, 481, 489}, m = "invokeSuspend", n = {"$this$withContext", "originalCachedEdges", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$fetchFolderItemsFromRemote$2$1", "$this$withContext", "originalCachedEdges", "$this$flatMap$iv", "response", "resp", "edges", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$fetchFolderItemsFromRemote$2$3", "$i$a$-let-RemoteItemService$fetchFolderItemsFromRemote$2$3$1", "$i$a$-let-RemoteItemService$fetchFolderItemsFromRemote$2$3$1$1", "$this$withContext", "originalCachedEdges", "$this$flatMap$iv", "response", "resp", "edges", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$fetchFolderItemsFromRemote$2$3", "$i$a$-let-RemoteItemService$fetchFolderItemsFromRemote$2$3$1", "$i$a$-let-RemoteItemService$fetchFolderItemsFromRemote$2$3$1$1", "$this$withContext", "originalCachedEdges", "$this$flatMap$iv", "response", "resp", "edges", "$this$forEach$iv", "element$iv", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$fetchFolderItemsFromRemote$2$3", "$i$a$-let-RemoteItemService$fetchFolderItemsFromRemote$2$3$1", "$i$a$-let-RemoteItemService$fetchFolderItemsFromRemote$2$3$1$1", "$i$f$forEach", "$i$a$-forEach-RemoteItemService$fetchFolderItemsFromRemote$2$3$1$1$3"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"}, v = 1)
    static final class C14932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId.Remote $remoteId;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14932(ItemId.Remote remote, Continuation<? super C14932> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14932 c14932 = RemoteItemService.this.new C14932(this.$remoteId, continuation);
            c14932.L$0 = obj;
            return c14932;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((C14932) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:58:0x0264 A[LOOP:0: B:56:0x025e->B:58:0x0264, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:62:0x02a9  */
        /* JADX WARN: Code duplicated, block: B:65:0x0304  */
        /* JADX WARN: Code duplicated, block: B:68:0x0317  */
        /* JADX WARN: Code duplicated, block: B:69:0x032c  */
        /* JADX WARN: Code duplicated, block: B:71:0x0337  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0304 -> B:66:0x030d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 898
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.C14932.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Gen204Event invokeSuspend$lambda$2$0$0$0(ItemId.Remote remote, List list, long j) {
            return new BrowsePerformanceEvent(new BrowsePerformanceEvent.Type.FullFolderLoad(remote.getBoxId()), j, list.size(), null, null, null, 56, null);
        }
    }

    @Override // com.box.android.domain.services.IRemoteItemService
    public Object fetchFolderItemsFromRemote(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C14932(remote, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a4, code lost:
    
        if (r9 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IItemService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object fetchFolderItemsFromRemote(com.box.android.domain.models.ItemId r8, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.box.android.data.service.impl.RemoteItemService.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.data.service.impl.RemoteItemService$fetchFolderItemsFromRemote$3 r0 = (com.box.android.data.service.impl.RemoteItemService.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.data.service.impl.RemoteItemService$fetchFolderItemsFromRemote$3 r0 = new com.box.android.data.service.impl.RemoteItemService$fetchFolderItemsFromRemote$3
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L49
            if (r2 != r3) goto L41
            int r7 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r7 = r0.L$3
            com.box.android.domain.models.ItemId$Remote r7 = (com.box.android.domain.models.ItemId.Remote) r7
            java.lang.Object r7 = r0.L$2
            com.box.android.domain.models.ItemId$Remote r7 = (com.box.android.domain.models.ItemId.Remote) r7
            java.lang.Object r7 = r0.L$1
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            java.lang.Object r7 = r0.L$0
            com.box.android.domain.models.ItemId r7 = (com.box.android.domain.models.ItemId) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto La7
        L41:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L49:
            java.lang.Object r8 = r0.L$0
            com.box.android.domain.models.ItemId r8 = (com.box.android.domain.models.ItemId) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L65
        L51:
            kotlin.ResultKt.throwOnFailure(r9)
            com.box.android.domain.services.IdMappingService r9 = r7.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r9.getRemoteIdOrError(r8, r0)
            if (r9 != r1) goto L65
            goto La6
        L65:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto Laa
            r2 = r9
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.domain.models.ItemId$Remote r4 = new com.box.android.domain.models.ItemId$Remote
            java.lang.String r5 = r2.getBoxId()
            com.box.android.domain.models.item.ItemType r6 = r2.getType()
            r4.<init>(r5, r6)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$2 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$3 = r8
            r8 = 0
            r0.I$0 = r8
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r9 = r7.fetchFolderItemsFromRemote(r4, r0)
            if (r9 != r1) goto La7
        La6:
            return r1
        La7:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            return r9
        Laa:
            boolean r7 = r9 instanceof com.box.android.domain.utils.result.Result.Error
            if (r7 == 0) goto Laf
            return r9
        Laf:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.fetchFolderItemsFromRemote(com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object gqlFetchFolderItemsFromRemote(String str, Continuation<? super ApolloResponse<GetFolderItemsQuery.Data>> continuation) {
        JobCancellationHelper.INSTANCE.bindCoroutineContext(JobCancellationHelper.INSTANCE.createFetchFolderKey(str), continuation.get$context());
        ApolloCall<GetFolderItemsQuery.Data> folderItemsFromNetwork = this.graphQL.getFolderItemsFromNetwork(str);
        if (folderItemsFromNetwork == null) {
            return null;
        }
        Object objExecute = folderItemsFromNetwork.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    public final Object gqlFolderMini(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super ApolloResponse<GetFolderMiniQuery.Data>> continuation) {
        ApolloCall<GetFolderMiniQuery.Data> apolloCallFolderMini = this.graphQL.folderMini(remote.getBoxId(), DataPolicyMapperKt.cachePolicyRepresentation(dataPolicy));
        if (apolloCallFolderMini == null) {
            return null;
        }
        Object objExecute = apolloCallFolderMini.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    public final Object gqlFolderMiniWithParent(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super ApolloResponse<GetFolderMiniWithParentQuery.Data>> continuation) {
        ApolloCall<GetFolderMiniWithParentQuery.Data> apolloCallFolderMiniWithParent = this.graphQL.folderMiniWithParent(remote.getBoxId(), DataPolicyMapperKt.cachePolicyRepresentation(dataPolicy));
        if (apolloCallFolderMiniWithParent == null) {
            return null;
        }
        Object objExecute = apolloCallFolderMiniWithParent.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    public final Object gqlItem(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super ApolloResponse<GetItemQuery.Data>> continuation) {
        ApolloCall<GetItemQuery.Data> apolloCallItem = this.graphQL.item(remote.getBoxId(), remote.getType().getValue(), DataPolicyMapperKt.cachePolicyRepresentation(dataPolicy));
        if (apolloCallItem == null) {
            return null;
        }
        Object objExecute = apolloCallItem.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:105:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:106:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:108:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:110:0x03df  */
    /* JADX WARN: Code duplicated, block: B:114:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:116:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:118:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:122:0x0406  */
    /* JADX WARN: Code duplicated, block: B:127:0x041e  */
    /* JADX WARN: Code duplicated, block: B:129:0x043f  */
    /* JADX WARN: Code duplicated, block: B:132:0x0444  */
    /* JADX WARN: Code duplicated, block: B:134:0x044a  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0172  */
    /* JADX WARN: Code duplicated, block: B:46:0x0176  */
    /* JADX WARN: Code duplicated, block: B:49:0x0191  */
    /* JADX WARN: Code duplicated, block: B:51:0x019c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0214  */
    /* JADX WARN: Code duplicated, block: B:66:0x0219  */
    /* JADX WARN: Code duplicated, block: B:68:0x021d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0255  */
    /* JADX WARN: Code duplicated, block: B:74:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:77:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:83:0x0308  */
    /* JADX WARN: Code duplicated, block: B:86:0x0368  */
    @Override // com.box.android.domain.services.IRemoteItemService
    public Object createFolder(String str, ItemId.Remote remote, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        C14921 c14921;
        String str2;
        ItemId.Remote remote2;
        Object objGqlResponseCreateFolder;
        Result.Error error;
        ApolloResponse apolloResponse;
        Result.Error error2;
        Result.Error error3;
        List<Error> list;
        Error error4;
        CreateFolderMutation.Data data;
        CreateFolderMutation.CreateFolder createFolder;
        CreateFolderMutation.Value value;
        ApolloStore apolloStore;
        ApolloResponse apolloResponse2;
        String str3;
        ItemId.Remote remote3;
        Result result;
        FolderModel folderModel;
        Object obj;
        int i;
        int i2;
        int i3;
        int i4;
        CreateFolderMutation.Value value2;
        int i5;
        CreateFolderMutation.Value value3;
        Unit unit;
        Object objGqlInsertItemToParentInCache;
        ApolloStore apolloStore2;
        Result result2;
        int i6;
        int i7;
        int i8;
        Unit unit2;
        int i9;
        CreateFolderMutation.Value value4;
        int i10;
        Object obj2;
        int i11;
        Result.Error error5;
        ApolloStore apolloStore3;
        ItemModel itemModel;
        ItemModel itemModel2;
        if (continuation instanceof C14921) {
            c14921 = (C14921) continuation;
            if ((c14921.label & Integer.MIN_VALUE) != 0) {
                c14921.label -= Integer.MIN_VALUE;
            } else {
                c14921 = new C14921(continuation);
            }
        } else {
            c14921 = new C14921(continuation);
        }
        Object objSaveInLegacyCache = c14921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i12 = c14921.label;
        if (i12 == 0) {
            ResultKt.throwOnFailure(objSaveInLegacyCache);
            try {
                String boxId = remote.getBoxId();
                c14921.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c14921.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                c14921.I$0 = 0;
                c14921.I$1 = 0;
                c14921.label = 1;
                str2 = str;
                try {
                    objGqlResponseCreateFolder = gqlResponseCreateFolder(str2, boxId, c14921);
                    if (objGqlResponseCreateFolder != coroutine_suspended) {
                        remote2 = remote;
                        error = new Result.Success((ApolloResponse) objGqlResponseCreateFolder);
                        if (!(error instanceof Result.Success)) {
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to create folder in GraphQL"));
                        }
                        if (error instanceof Result.Success) {
                            if (error instanceof Result.Error) {
                                return error;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                        if (apolloResponse != null) {
                        }
                        if (apolloResponse != null) {
                            BoxLogUtils.w("Unexpected: response contains no folder data and no error: " + apolloResponse);
                            error2 = new Result.Error(new DomainError.NetworkError(null, 1, null));
                        } else {
                            BoxLogUtils.w("Unexpected: response contains no folder data and no error: " + apolloResponse);
                            error2 = new Result.Error(new DomainError.NetworkError(null, 1, null));
                        }
                        error3 = error2;
                    }
                } catch (Exception e) {
                    e = e;
                    remote2 = remote;
                    error = new Result.Error(e);
                    if (!(error instanceof Result.Success)) {
                        if (error instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to create folder in GraphQL"));
                    }
                    if (error instanceof Result.Success) {
                        if (error instanceof Result.Error) {
                            return error;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                    if (apolloResponse != null) {
                    }
                    if (apolloResponse != null) {
                        BoxLogUtils.w("Unexpected: response contains no folder data and no error: " + apolloResponse);
                        error2 = new Result.Error(new DomainError.NetworkError(null, 1, null));
                    } else {
                        BoxLogUtils.w("Unexpected: response contains no folder data and no error: " + apolloResponse);
                        error2 = new Result.Error(new DomainError.NetworkError(null, 1, null));
                    }
                    error3 = error2;
                    return error3;
                }
            } catch (Exception e2) {
                e = e2;
                str2 = str;
            }
            return coroutine_suspended;
        }
        if (i12 == 1) {
            int i13 = c14921.I$1;
            int i14 = c14921.I$0;
            ItemId.Remote remote4 = (ItemId.Remote) c14921.L$1;
            String str4 = (String) c14921.L$0;
            try {
                ResultKt.throwOnFailure(objSaveInLegacyCache);
                remote2 = remote4;
                str2 = str4;
                objGqlResponseCreateFolder = objSaveInLegacyCache;
                try {
                    error = new Result.Success((ApolloResponse) objGqlResponseCreateFolder);
                } catch (Exception e3) {
                    e = e3;
                    error = new Result.Error(e);
                }
            } catch (Exception e4) {
                e = e4;
                remote2 = remote4;
                str2 = str4;
                error = new Result.Error(e);
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to create folder in GraphQL"));
                }
                if (error instanceof Result.Success) {
                    if (error instanceof Result.Error) {
                        return error;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                if (apolloResponse != null) {
                }
                if (apolloResponse != null) {
                    BoxLogUtils.w("Unexpected: response contains no folder data and no error: " + apolloResponse);
                    error2 = new Result.Error(new DomainError.NetworkError(null, 1, null));
                } else {
                    BoxLogUtils.w("Unexpected: response contains no folder data and no error: " + apolloResponse);
                    error2 = new Result.Error(new DomainError.NetworkError(null, 1, null));
                }
                error3 = error2;
                return error3;
            }
            if (!(error instanceof Result.Success)) {
                if (error instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to create folder in GraphQL"));
            }
            if (error instanceof Result.Success) {
                if (error instanceof Result.Error) {
                    return error;
                }
                throw new NoWhenBranchMatchedException();
            }
            apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
            if (apolloResponse != null || (data = (CreateFolderMutation.Data) apolloResponse.data) == null || (createFolder = data.getCreateFolder()) == null || (value = createFolder.getValue()) == null) {
                if (apolloResponse != null || (list = apolloResponse.errors) == null || (error4 = (Error) CollectionsKt.firstOrNull((List) list)) == null) {
                    BoxLogUtils.w("Unexpected: response contains no folder data and no error: " + apolloResponse);
                    error2 = new Result.Error(new DomainError.NetworkError(null, 1, null));
                } else {
                    error2 = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError(error4));
                }
                error3 = error2;
            } else {
                FolderModel folderModel2 = (FolderModel) GraphQLMapper.fromGraphQL$default(GQLCreateFolderToFolderModelMapper.INSTANCE, value, null, 2, null);
                apolloStore = this.gqlCacheHelper.getGqlCache().getApolloStore();
                if (apolloStore != null) {
                    GQLCacheHelper gQLCacheHelper = this.gqlCacheHelper;
                    c14921.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    c14921.L$1 = SpillingKt.nullOutSpilledVariable(remote2);
                    c14921.L$2 = SpillingKt.nullOutSpilledVariable(error);
                    c14921.L$3 = apolloResponse;
                    c14921.L$4 = SpillingKt.nullOutSpilledVariable(value);
                    c14921.L$5 = folderModel2;
                    c14921.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore);
                    c14921.I$0 = 0;
                    c14921.I$1 = 0;
                    c14921.I$2 = 0;
                    c14921.I$3 = 0;
                    c14921.I$4 = 0;
                    c14921.label = 2;
                    Object objGqlWriteFolderToCache = gQLCacheHelper.gqlWriteFolderToCache(apolloStore, folderModel2, c14921);
                    if (objGqlWriteFolderToCache != coroutine_suspended) {
                        apolloResponse2 = apolloResponse;
                        str3 = str2;
                        remote3 = remote2;
                        result = error;
                        folderModel = folderModel2;
                        obj = objGqlWriteFolderToCache;
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        value2 = value;
                        i5 = 0;
                        error3 = (Result) obj;
                        value3 = value2;
                        if (!(error3 instanceof Result.Success)) {
                            if (error3 instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            CacheError cacheError = (CacheError) ((Result.Error) error3).getValue();
                            BoxLogUtils.w("Failed to write item to GraphQL cache: " + folderModel);
                            error3 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError, null, 2, null));
                        }
                        if (error3 instanceof Result.Success) {
                            unit = (Unit) ((Result.Success) error3).getValue();
                            c14921.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            c14921.L$1 = SpillingKt.nullOutSpilledVariable(remote3);
                            c14921.L$2 = SpillingKt.nullOutSpilledVariable(result);
                            c14921.L$3 = apolloResponse2;
                            c14921.L$4 = SpillingKt.nullOutSpilledVariable(value3);
                            c14921.L$5 = folderModel;
                            c14921.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore);
                            c14921.L$7 = SpillingKt.nullOutSpilledVariable(error3);
                            c14921.L$8 = SpillingKt.nullOutSpilledVariable(unit);
                            c14921.I$0 = i3;
                            c14921.I$1 = i5;
                            c14921.I$2 = i2;
                            c14921.I$3 = i;
                            c14921.I$4 = i4;
                            c14921.I$5 = 0;
                            c14921.I$6 = 0;
                            c14921.label = 3;
                            objGqlInsertItemToParentInCache = this.gqlCacheHelper.gqlInsertItemToParentInCache(folderModel, c14921);
                            if (objGqlInsertItemToParentInCache != coroutine_suspended) {
                                apolloStore2 = apolloStore;
                                result2 = error3;
                                i6 = i;
                                i7 = i2;
                                i8 = i5;
                                unit2 = unit;
                                i9 = 0;
                                value4 = value3;
                                i10 = i3;
                                obj2 = objGqlInsertItemToParentInCache;
                                i11 = 0;
                                error5 = (Result) obj2;
                                apolloStore3 = apolloStore2;
                                if (!(error5 instanceof Result.Success)) {
                                    if (!(error5 instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    CacheError cacheError2 = (CacheError) ((Result.Error) error5).getValue();
                                    BoxLogUtils.w("Failed to save to parent in GraphQL cache: " + folderModel);
                                    error5 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError2, null, 2, null));
                                }
                                if (error5 instanceof Result.Success) {
                                    itemModel = (ItemModel) ((Result.Success) error5).getValue();
                                    c14921.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                    c14921.L$1 = SpillingKt.nullOutSpilledVariable(remote3);
                                    c14921.L$2 = SpillingKt.nullOutSpilledVariable(result);
                                    c14921.L$3 = apolloResponse2;
                                    c14921.L$4 = SpillingKt.nullOutSpilledVariable(value4);
                                    c14921.L$5 = SpillingKt.nullOutSpilledVariable(folderModel);
                                    c14921.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore3);
                                    c14921.L$7 = SpillingKt.nullOutSpilledVariable(result2);
                                    c14921.L$8 = SpillingKt.nullOutSpilledVariable(unit2);
                                    c14921.L$9 = SpillingKt.nullOutSpilledVariable(error5);
                                    c14921.L$10 = itemModel;
                                    c14921.I$0 = i10;
                                    c14921.I$1 = i8;
                                    c14921.I$2 = i7;
                                    c14921.I$3 = i6;
                                    c14921.I$4 = i4;
                                    c14921.I$5 = i11;
                                    c14921.I$6 = i9;
                                    c14921.I$7 = 0;
                                    c14921.I$8 = 0;
                                    c14921.label = 4;
                                    objSaveInLegacyCache = saveInLegacyCache(itemModel, c14921);
                                    if (objSaveInLegacyCache != coroutine_suspended) {
                                        itemModel2 = itemModel;
                                    }
                                } else {
                                    if (!(error5 instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error3 = error5;
                                }
                            }
                        } else if (!(error3 instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (error3 == null) {
                            error3 = new Result.Error(new DomainError.CacheInitError(null, 1, null));
                        }
                    }
                    return coroutine_suspended;
                }
                error3 = new Result.Error(new DomainError.CacheInitError(null, 1, null));
            }
        } else if (i12 == 2) {
            int i15 = c14921.I$4;
            i = c14921.I$3;
            i2 = c14921.I$2;
            int i16 = c14921.I$1;
            int i17 = c14921.I$0;
            ApolloStore apolloStore4 = (ApolloStore) c14921.L$6;
            FolderModel folderModel3 = (FolderModel) c14921.L$5;
            CreateFolderMutation.Value value5 = (CreateFolderMutation.Value) c14921.L$4;
            apolloResponse2 = (ApolloResponse) c14921.L$3;
            result = (Result) c14921.L$2;
            remote3 = (ItemId.Remote) c14921.L$1;
            str3 = (String) c14921.L$0;
            ResultKt.throwOnFailure(objSaveInLegacyCache);
            i3 = i17;
            i5 = i16;
            folderModel = folderModel3;
            apolloStore = apolloStore4;
            value2 = value5;
            i4 = i15;
            obj = objSaveInLegacyCache;
            error3 = (Result) obj;
            value3 = value2;
            if (!(error3 instanceof Result.Success)) {
                if (error3 instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                CacheError cacheError3 = (CacheError) ((Result.Error) error3).getValue();
                BoxLogUtils.w("Failed to write item to GraphQL cache: " + folderModel);
                error3 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError3, null, 2, null));
            }
            if (error3 instanceof Result.Success) {
                unit = (Unit) ((Result.Success) error3).getValue();
                c14921.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                c14921.L$1 = SpillingKt.nullOutSpilledVariable(remote3);
                c14921.L$2 = SpillingKt.nullOutSpilledVariable(result);
                c14921.L$3 = apolloResponse2;
                c14921.L$4 = SpillingKt.nullOutSpilledVariable(value3);
                c14921.L$5 = folderModel;
                c14921.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore);
                c14921.L$7 = SpillingKt.nullOutSpilledVariable(error3);
                c14921.L$8 = SpillingKt.nullOutSpilledVariable(unit);
                c14921.I$0 = i3;
                c14921.I$1 = i5;
                c14921.I$2 = i2;
                c14921.I$3 = i;
                c14921.I$4 = i4;
                c14921.I$5 = 0;
                c14921.I$6 = 0;
                c14921.label = 3;
                objGqlInsertItemToParentInCache = this.gqlCacheHelper.gqlInsertItemToParentInCache(folderModel, c14921);
                if (objGqlInsertItemToParentInCache != coroutine_suspended) {
                    apolloStore2 = apolloStore;
                    result2 = error3;
                    i6 = i;
                    i7 = i2;
                    i8 = i5;
                    unit2 = unit;
                    i9 = 0;
                    value4 = value3;
                    i10 = i3;
                    obj2 = objGqlInsertItemToParentInCache;
                    i11 = 0;
                    error5 = (Result) obj2;
                    apolloStore3 = apolloStore2;
                    if (!(error5 instanceof Result.Success)) {
                        if (!(error5 instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        CacheError cacheError4 = (CacheError) ((Result.Error) error5).getValue();
                        BoxLogUtils.w("Failed to save to parent in GraphQL cache: " + folderModel);
                        error5 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError4, null, 2, null));
                    }
                    if (error5 instanceof Result.Success) {
                        itemModel = (ItemModel) ((Result.Success) error5).getValue();
                        c14921.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        c14921.L$1 = SpillingKt.nullOutSpilledVariable(remote3);
                        c14921.L$2 = SpillingKt.nullOutSpilledVariable(result);
                        c14921.L$3 = apolloResponse2;
                        c14921.L$4 = SpillingKt.nullOutSpilledVariable(value4);
                        c14921.L$5 = SpillingKt.nullOutSpilledVariable(folderModel);
                        c14921.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore3);
                        c14921.L$7 = SpillingKt.nullOutSpilledVariable(result2);
                        c14921.L$8 = SpillingKt.nullOutSpilledVariable(unit2);
                        c14921.L$9 = SpillingKt.nullOutSpilledVariable(error5);
                        c14921.L$10 = itemModel;
                        c14921.I$0 = i10;
                        c14921.I$1 = i8;
                        c14921.I$2 = i7;
                        c14921.I$3 = i6;
                        c14921.I$4 = i4;
                        c14921.I$5 = i11;
                        c14921.I$6 = i9;
                        c14921.I$7 = 0;
                        c14921.I$8 = 0;
                        c14921.label = 4;
                        objSaveInLegacyCache = saveInLegacyCache(itemModel, c14921);
                        if (objSaveInLegacyCache != coroutine_suspended) {
                            itemModel2 = itemModel;
                        }
                    } else {
                        if (!(error5 instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error3 = error5;
                    }
                }
                return coroutine_suspended;
            }
            if (!(error3 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (error3 == null) {
                error3 = new Result.Error(new DomainError.CacheInitError(null, 1, null));
            }
        } else if (i12 == 3) {
            i9 = c14921.I$6;
            i11 = c14921.I$5;
            i4 = c14921.I$4;
            int i18 = c14921.I$3;
            int i19 = c14921.I$2;
            int i20 = c14921.I$1;
            int i21 = c14921.I$0;
            Unit unit3 = (Unit) c14921.L$8;
            Result result3 = (Result) c14921.L$7;
            apolloStore2 = (ApolloStore) c14921.L$6;
            folderModel = (FolderModel) c14921.L$5;
            CreateFolderMutation.Value value6 = (CreateFolderMutation.Value) c14921.L$4;
            ApolloResponse apolloResponse3 = (ApolloResponse) c14921.L$3;
            Result result4 = (Result) c14921.L$2;
            ItemId.Remote remote5 = (ItemId.Remote) c14921.L$1;
            String str5 = (String) c14921.L$0;
            ResultKt.throwOnFailure(objSaveInLegacyCache);
            apolloResponse2 = apolloResponse3;
            obj2 = objSaveInLegacyCache;
            result2 = result3;
            i10 = i21;
            str3 = str5;
            i7 = i19;
            i6 = i18;
            result = result4;
            unit2 = unit3;
            i8 = i20;
            remote3 = remote5;
            value4 = value6;
            error5 = (Result) obj2;
            apolloStore3 = apolloStore2;
            if (!(error5 instanceof Result.Success)) {
                if (!(error5 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                CacheError cacheError5 = (CacheError) ((Result.Error) error5).getValue();
                BoxLogUtils.w("Failed to save to parent in GraphQL cache: " + folderModel);
                error5 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, cacheError5, null, 2, null));
            }
            if (error5 instanceof Result.Success) {
                itemModel = (ItemModel) ((Result.Success) error5).getValue();
                c14921.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                c14921.L$1 = SpillingKt.nullOutSpilledVariable(remote3);
                c14921.L$2 = SpillingKt.nullOutSpilledVariable(result);
                c14921.L$3 = apolloResponse2;
                c14921.L$4 = SpillingKt.nullOutSpilledVariable(value4);
                c14921.L$5 = SpillingKt.nullOutSpilledVariable(folderModel);
                c14921.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore3);
                c14921.L$7 = SpillingKt.nullOutSpilledVariable(result2);
                c14921.L$8 = SpillingKt.nullOutSpilledVariable(unit2);
                c14921.L$9 = SpillingKt.nullOutSpilledVariable(error5);
                c14921.L$10 = itemModel;
                c14921.I$0 = i10;
                c14921.I$1 = i8;
                c14921.I$2 = i7;
                c14921.I$3 = i6;
                c14921.I$4 = i4;
                c14921.I$5 = i11;
                c14921.I$6 = i9;
                c14921.I$7 = 0;
                c14921.I$8 = 0;
                c14921.label = 4;
                objSaveInLegacyCache = saveInLegacyCache(itemModel, c14921);
                if (objSaveInLegacyCache != coroutine_suspended) {
                    itemModel2 = itemModel;
                }
                return coroutine_suspended;
            }
            if (!(error5 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error3 = error5;
            if (error3 == null) {
                error3 = new Result.Error(new DomainError.CacheInitError(null, 1, null));
            }
        } else {
            if (i12 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i22 = c14921.I$8;
            int i23 = c14921.I$7;
            int i24 = c14921.I$6;
            int i25 = c14921.I$5;
            int i26 = c14921.I$4;
            int i27 = c14921.I$3;
            int i28 = c14921.I$2;
            int i29 = c14921.I$1;
            int i30 = c14921.I$0;
            itemModel2 = (ItemModel) c14921.L$10;
            ResultKt.throwOnFailure(objSaveInLegacyCache);
        }
        error3 = (Result) objSaveInLegacyCache;
        if (!(error3 instanceof Result.Success)) {
            if (!(error3 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            CacheError.SaveError saveError = (CacheError.SaveError) ((Result.Error) error3).getValue();
            BoxLogUtils.w("Failed to save to legacy cache: " + itemModel2);
            error3 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, saveError, null, 2, null));
        }
        if (error3 instanceof Result.Success) {
            Intrinsics.checkNotNull(itemModel2, "null cannot be cast to non-null type com.box.android.domain.models.item.FolderModel");
            error3 = new Result.Success((FolderModel) itemModel2);
        } else if (!(error3 instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error3 == null) {
            error3 = new Result.Error(new DomainError.CacheInitError(null, 1, null));
        }
        return error3;
    }

    @Override // com.box.android.domain.services.IRemoteItemService
    public Object move(ItemId.Remote remote, ItemId.Remote remote2, String str, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return moveItem$default(this, remote, remote2.getBoxId(), str, null, 0, 0, continuation, 56, null);
    }

    public static /* synthetic */ Object moveItem$default(RemoteItemService remoteItemService, ItemId.Remote remote, String str, String str2, String str3, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str3 = null;
        }
        return remoteItemService.moveItem(remote, str, str2, str3, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$moveItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$moveItem$2", f = "RemoteItemService.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {638, 643, 660, 666, 680}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "initialParentFolder", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$moveItem$2$1", "$this$withContext", "initialParentFolder", "$this$flatMap$iv", "response", "conflictNameValues", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$moveItem$2$3", "$this$withContext", "initialParentFolder", "$this$flatMap$iv", "response", "conflictNameValues", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$moveItem$2$3", "$this$withContext", "initialParentFolder", "$this$flatMap$iv", "response", "moveItem", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$moveItem$2$3", "$i$a$-let-RemoteItemService$moveItem$2$3$1"}, s = {"L$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$7", "L$8", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
    static final class C15062 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>>, Object> {
        final /* synthetic */ String $itemName;
        final /* synthetic */ String $newName;
        final /* synthetic */ String $parentId;
        final /* synthetic */ ItemId.Remote $remoteId;
        final /* synthetic */ int $retryAttempt;
        final /* synthetic */ int $startingNumericSuffix;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15062(ItemId.Remote remote, String str, String str2, String str3, int i, int i2, Continuation<? super C15062> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$parentId = str;
            this.$newName = str2;
            this.$itemName = str3;
            this.$startingNumericSuffix = i;
            this.$retryAttempt = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15062 c15062 = RemoteItemService.this.new C15062(this.$remoteId, this.$parentId, this.$newName, this.$itemName, this.$startingNumericSuffix, this.$retryAttempt, continuation);
            c15062.L$0 = obj;
            return c15062;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
            return ((C15062) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x0102  */
        /* JADX WARN: Code duplicated, block: B:38:0x0104  */
        /* JADX WARN: Code duplicated, block: B:40:0x0108  */
        /* JADX WARN: Code duplicated, block: B:43:0x0131  */
        /* JADX WARN: Code duplicated, block: B:70:0x029b  */
        /* JADX WARN: Code duplicated, block: B:73:0x02a0  */
        /* JADX WARN: Code duplicated, block: B:75:0x02a6  */
        /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x01f8, code lost:
        
            if (r0 == r8) goto L66;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 684
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.C15062.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object moveItem(ItemId.Remote remote, String str, String str2, String str3, int i, int i2, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C15062(remote, str, str3, str2, i, i2, null), continuation);
    }

    public static /* synthetic */ Object gqlMoveItem$default(RemoteItemService remoteItemService, ItemId.Remote remote, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return remoteItemService.gqlMoveItem(remote, str, str2, str3, continuation);
    }

    public final Object gqlMoveItem(ItemId.Remote remote, String str, String str2, String str3, Continuation<? super ApolloResponse<MoveItemMutation.Data>> continuation) {
        ApolloCall<MoveItemMutation.Data> apolloCallMoveItem = this.graphQL.moveItem(remote.getBoxId(), remote.getType().getValue(), str, str2, str3);
        if (apolloCallMoveItem == null) {
            return null;
        }
        Object objExecute = apolloCallMoveItem.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    @Override // com.box.android.domain.services.IRemoteItemService
    public Object copy(ItemId.Remote remote, ItemId.Remote remote2, String str, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return copyItem$default(this, remote, remote2.getBoxId(), str, null, 0, 0, continuation, 56, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IRemoteItemService
    public Object updateCacheItemFromRemote(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C15091 c15091;
        if (continuation instanceof C15091) {
            c15091 = (C15091) continuation;
            if ((c15091.label & Integer.MIN_VALUE) != 0) {
                c15091.label -= Integer.MIN_VALUE;
            } else {
                c15091 = new C15091(continuation);
            }
        } else {
            c15091 = new C15091(continuation);
        }
        Object objItem = c15091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            DataPolicy dataPolicy = DataPolicy.REMOTE;
            c15091.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c15091.label = 1;
            objItem = item(itemId, dataPolicy, c15091);
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
            return new Result.Success(Unit.INSTANCE);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object copyItem$default(RemoteItemService remoteItemService, ItemId.Remote remote, String str, String str2, String str3, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str3 = null;
        }
        return remoteItemService.copyItem(remote, str, str2, str3, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$copyItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$copyItem$2", f = "RemoteItemService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {747, 764, 770, 784}, m = "invokeSuspend", n = {"$this$withContext", "$i$f$resultOf", "$i$a$-resultOf-RemoteItemService$copyItem$2$1", "$this$withContext", "$this$flatMap$iv", "response", "conflictNameValues", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$copyItem$2$3", "$this$withContext", "$this$flatMap$iv", "response", "conflictNameValues", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$copyItem$2$3", "$this$withContext", "$this$flatMap$iv", "response", "copyItem", "itemModel", "$i$f$flatMap", "$i$a$-flatMap-RemoteItemService$copyItem$2$3", "$i$a$-let-RemoteItemService$copyItem$2$3$1"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "L$6", "L$7", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
    static final class C14912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>>, Object> {
        final /* synthetic */ String $itemName;
        final /* synthetic */ String $newName;
        final /* synthetic */ String $parentId;
        final /* synthetic */ ItemId.Remote $remoteId;
        final /* synthetic */ int $retryAttempt;
        final /* synthetic */ int $startingNumericSuffix;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14912(ItemId.Remote remote, String str, String str2, String str3, int i, int i2, Continuation<? super C14912> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$parentId = str;
            this.$newName = str2;
            this.$itemName = str3;
            this.$startingNumericSuffix = i;
            this.$retryAttempt = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14912 c14912 = RemoteItemService.this.new C14912(this.$remoteId, this.$parentId, this.$newName, this.$itemName, this.$startingNumericSuffix, this.$retryAttempt, continuation);
            c14912.L$0 = obj;
            return c14912;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
            return ((C14912) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x01b3, code lost:
        
            if (r0 == r8) goto L57;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 607
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.C14912.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object copyItem(ItemId.Remote remote, String str, String str2, String str3, int i, int i2, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C14912(remote, str, str3, str2, i, i2, null), continuation);
    }

    public static /* synthetic */ Object gqlCopyItem$default(RemoteItemService remoteItemService, ItemId.Remote remote, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return remoteItemService.gqlCopyItem(remote, str, str2, str3, continuation);
    }

    public final Object gqlCopyItem(ItemId.Remote remote, String str, String str2, String str3, Continuation<? super ApolloResponse<CopyItemMutation.Data>> continuation) {
        ApolloCall<CopyItemMutation.Data> apolloCallCopyItem = this.graphQL.copyItem(remote.getBoxId(), remote.getType().getValue(), str, str2, str3);
        if (apolloCallCopyItem == null) {
            return null;
        }
        Object objExecute = apolloCallCopyItem.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    public final boolean isNameConflictError(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return error instanceof DomainError.NameConflict;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ae A[LOOP:0: B:27:0x009b->B:31:0x00ae, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object calculateNonConflictingName(String str, String str2, int i, int i2, Continuation<? super Pair<String, Integer>> continuation) {
        AnonymousClass1 anonymousClass1;
        List list;
        String str3;
        int i3;
        List list2;
        int i4;
        String strBuildDuplicateName;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object itemNamesInFolder = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass1.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(itemNamesInFolder);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = str2;
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = i2;
            anonymousClass1.label = 1;
            itemNamesInFolder = getItemNamesInFolder(str2, anonymousClass1);
            if (itemNamesInFolder != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            i2 = anonymousClass1.I$1;
            i = anonymousClass1.I$0;
            str2 = (String) anonymousClass1.L$1;
            str = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(itemNamesInFolder);
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = anonymousClass1.I$1;
            i3 = anonymousClass1.I$0;
            list2 = (List) anonymousClass1.L$2;
            str3 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(itemNamesInFolder);
        }
        String str4 = str3;
        i = i3;
        str = str4;
        list = list2;
        i4 = i + 1;
        while (true) {
            strBuildDuplicateName = buildDuplicateName(str, i4);
            if (!list.contains(strBuildDuplicateName)) {
                return TuplesKt.to(strBuildDuplicateName, Boxing.boxInt(i4));
            }
            i4++;
        }
        list = (List) itemNamesInFolder;
        if (i2 >= 3) {
            CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str2, null);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$2 = list;
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = i2;
            anonymousClass1.label = 2;
            if (BuildersKt.withContext(coroutineDispatcher, anonymousClass2, anonymousClass1) != coroutine_suspended) {
                int i7 = i;
                str3 = str;
                i3 = i7;
                list2 = list;
                String str5 = str3;
                i = i3;
                str = str5;
                list = list2;
            }
            return coroutine_suspended;
        }
        i4 = i + 1;
        while (true) {
            strBuildDuplicateName = buildDuplicateName(str, i4);
            if (!list.contains(strBuildDuplicateName)) {
                return TuplesKt.to(strBuildDuplicateName, Boxing.boxInt(i4));
            }
            i4++;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$calculateNonConflictingName$2, reason: invalid class name */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$calculateNonConflictingName$2", f = "RemoteItemService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Unit>>, Object> {
        final /* synthetic */ String $parentId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$parentId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = RemoteItemService.this.new AnonymousClass2(this.$parentId, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Deferred<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Deferred<Unit>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$calculateNonConflictingName$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RemoteItemService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$calculateNonConflictingName$2$1", f = "RemoteItemService.kt", i = {}, l = {851}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $parentId;
            int label;
            final /* synthetic */ RemoteItemService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RemoteItemService remoteItemService, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = remoteItemService;
                this.$parentId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$parentId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.graphQL.batch(new GetFolderItemsQuery(this.$parentId), DebouncePolicy.Standard, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(RemoteItemService.this, this.$parentId, null), 3, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getItemNamesInFolder(String str, Continuation<? super List<String>> continuation) {
        C14971 c14971;
        ApolloResponse apolloResponse;
        GetItemNamesInFolderQuery.Data data;
        GetItemNamesInFolderQuery.Folder folder;
        GetItemNamesInFolderQuery.ItemConnection itemConnection;
        List<GetItemNamesInFolderQuery.Edge> edges;
        if (continuation instanceof C14971) {
            c14971 = (C14971) continuation;
            if ((c14971.label & Integer.MIN_VALUE) != 0) {
                c14971.label -= Integer.MIN_VALUE;
            } else {
                c14971 = new C14971(continuation);
            }
        } else {
            c14971 = new C14971(continuation);
        }
        Object objExecute = c14971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14971.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objExecute);
            ApolloCall<GetItemNamesInFolderQuery.Data> itemNamesInFolder = this.graphQL.getItemNamesInFolder(str);
            if (itemNamesInFolder != null) {
                c14971.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c14971.label = 1;
                objExecute = itemNamesInFolder.execute(c14971);
                if (objExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                apolloResponse = null;
            }
            if (apolloResponse != null || (data = (GetItemNamesInFolderQuery.Data) apolloResponse.data) == null || (folder = data.getFolder()) == null || (itemConnection = folder.getItemConnection()) == null || (edges = itemConnection.getEdges()) == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = edges.iterator();
            while (it.hasNext()) {
                GetItemNamesInFolderQuery.OnCoreItem onCoreItem = ((GetItemNamesInFolderQuery.Edge) it.next()).getNode().getOnCoreItem();
                String name = onCoreItem != null ? onCoreItem.getName() : null;
                if (name != null) {
                    arrayList.add(name);
                }
            }
            return arrayList;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objExecute);
        apolloResponse = (ApolloResponse) objExecute;
        if (apolloResponse != null) {
        }
        return CollectionsKt.emptyList();
    }

    public final String buildDuplicateName(String initialName, int count) {
        Intrinsics.checkNotNullParameter(initialName, "initialName");
        File file = new File(initialName);
        String nameWithoutExtension = FilesKt.getNameWithoutExtension(file);
        String extension = FilesKt.getExtension(file);
        if (initialName.length() <= 0) {
            return initialName;
        }
        if (extension.length() > 0) {
            extension = "." + extension;
        }
        return nameWithoutExtension + " (" + count + ")" + extension;
    }

    public final Object gqlResponseCreateFolder(String str, String str2, Continuation<? super ApolloResponse<CreateFolderMutation.Data>> continuation) {
        ApolloCall apolloCallCreateFolder$default = BoxGraphQL.createFolder$default(this.graphQL, str, str2, null, 4, null);
        if (apolloCallCreateFolder$default == null) {
            return null;
        }
        Object objExecute = apolloCallCreateFolder$default.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$updateMovedItemInCache$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$updateMovedItemInCache$2", f = "RemoteItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {930, 931, 932}, m = "invokeSuspend", n = {"$this$withContext", "insertItemInCacheJob", "removeItemFromCacheJob", "saveInLegacyCacheJob", "$this$withContext", "insertItemInCacheJob", "removeItemFromCacheJob", "saveInLegacyCacheJob", "$this$withContext", "insertItemInCacheJob", "removeItemFromCacheJob", "saveInLegacyCacheJob"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C15112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>>, Object> {
        final /* synthetic */ String $initialParentFolder;
        final /* synthetic */ ItemModel $itemModel;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15112(ItemModel itemModel, String str, Continuation<? super C15112> continuation) {
            super(2, continuation);
            this.$itemModel = itemModel;
            this.$initialParentFolder = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15112 c15112 = RemoteItemService.this.new C15112(this.$itemModel, this.$initialParentFolder, continuation);
            c15112.L$0 = obj;
            return c15112;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, Unit>> continuation) {
            return ((C15112) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00f0 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred deferredAsync$default;
            Deferred deferred;
            Deferred deferred2;
            Object objAwait;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteItemService$updateMovedItemInCache$2$insertItemInCacheJob$1(RemoteItemService.this, this.$itemModel, null), 3, null);
                Deferred deferredAsync$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteItemService$updateMovedItemInCache$2$removeItemFromCacheJob$1(RemoteItemService.this, this.$itemModel, this.$initialParentFolder, null), 3, null);
                deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteItemService$updateMovedItemInCache$2$saveInLegacyCacheJob$1(RemoteItemService.this, this.$itemModel, null), 3, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                this.L$2 = deferredAsync$default3;
                this.L$3 = deferredAsync$default;
                this.label = 1;
                if (deferredAsync$default2.await(this) != coroutine_suspended) {
                    deferred = deferredAsync$default2;
                    deferred2 = deferredAsync$default3;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                deferredAsync$default = (Deferred) this.L$3;
                deferred2 = (Deferred) this.L$2;
                deferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                deferredAsync$default = (Deferred) this.L$3;
                deferred2 = (Deferred) this.L$2;
                deferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
            this.L$2 = SpillingKt.nullOutSpilledVariable(deferred2);
            this.L$3 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
            this.label = 3;
            objAwait = deferredAsync$default.await(this);
            if (objAwait != coroutine_suspended) {
                return coroutine_suspended;
            }
            return objAwait;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
            this.L$2 = SpillingKt.nullOutSpilledVariable(deferred2);
            this.L$3 = deferredAsync$default;
            this.label = 2;
            if (deferred2.await(this) != coroutine_suspended) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
                this.L$2 = SpillingKt.nullOutSpilledVariable(deferred2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
                this.label = 3;
                objAwait = deferredAsync$default.await(this);
                if (objAwait != coroutine_suspended) {
                    return objAwait;
                }
            }
            return coroutine_suspended;
        }
    }

    public final Object updateMovedItemInCache(ItemModel itemModel, String str, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C15112(itemModel, str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RemoteItemService$updateCopiedItemInCache$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteItemService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$updateCopiedItemInCache$2", f = "RemoteItemService.kt", i = {0, 0, 0, 1, 1, 1}, l = {955, 956}, m = "invokeSuspend", n = {"$this$withContext", "insertItemInCacheJob", "saveInLegacyCacheJob", "$this$withContext", "insertItemInCacheJob", "saveInLegacyCacheJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C15102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>>, Object> {
        final /* synthetic */ ItemModel $itemModel;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15102(ItemModel itemModel, Continuation<? super C15102> continuation) {
            super(2, continuation);
            this.$itemModel = itemModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15102 c15102 = RemoteItemService.this.new C15102(this.$itemModel, continuation);
            c15102.L$0 = obj;
            return c15102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, Unit>> continuation) {
            return ((C15102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred deferredAsync$default;
            Deferred deferred;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteItemService$updateCopiedItemInCache$2$insertItemInCacheJob$1(RemoteItemService.this, this.$itemModel, null), 3, null);
                deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteItemService$updateCopiedItemInCache$2$saveInLegacyCacheJob$1(RemoteItemService.this, this.$itemModel, null), 3, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                this.L$2 = deferredAsync$default;
                this.label = 1;
                if (deferredAsync$default2.await(this) != coroutine_suspended) {
                    deferred = deferredAsync$default2;
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            deferredAsync$default = (Deferred) this.L$2;
            deferred = (Deferred) this.L$1;
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
            this.L$2 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
            this.label = 2;
            Object objAwait = deferredAsync$default.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    public final Object updateCopiedItemInCache(ItemModel itemModel, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C15102(itemModel, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final Object saveInLegacyCache(ItemModel itemModel, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        return this.legacyCacheDataSource.saveItem(itemModel, false, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0123, code lost:
    
        if (r11 == r0) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object gqlGetParentForItemFromCache(com.box.android.domain.models.ItemId.Remote r10, kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService.gqlGetParentForItemFromCache(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
