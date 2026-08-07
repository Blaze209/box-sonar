package com.box.android.data.service.impl;

import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.common.extensions.FileExtensionsKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.localItems.LocalItemsDataSource;
import com.box.android.data.jobs.AutoUploadJob;
import com.box.android.data.jobs.CopyItemJob;
import com.box.android.data.jobs.DeleteCollaborationJob;
import com.box.android.data.jobs.DeleteFileJob;
import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.MoveItemJob;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.jobs.UploadFolderJob;
import com.box.android.data.persistence.localItems.LocalIdToServerIdRelationEntity;
import com.box.android.data.persistence.localItems.LocalItemEntity;
import com.box.android.data.utilities.LocalItemServiceItemsCreator;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.localrepo.ILocalAutoContentUploadInformation;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.react.modules.dialog.AlertFragment;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: LocalItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 y2\u00020\u0001:\u0001yB[\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J*\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010'J*\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ*\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00190.2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0016J*\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u00102J$\u00103\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\"\u00104\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ8\u00105\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a072\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0096@¢\u0006\u0002\u0010;J8\u0010<\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a072\u0006\u0010=\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0096@¢\u0006\u0002\u0010>J*\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010'J@\u0010A\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020%0EH\u0096@¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u0004\u0018\u00010C2\u0006\u0010H\u001a\u00020CH\u0007JT\u0010I\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020%0E2\u0006\u0010K\u001a\u00020!2\b\u0010L\u001a\u0004\u0018\u00010\u001dH\u0096@¢\u0006\u0002\u0010MJ\u001a\u0010N\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u0019H\u0096@¢\u0006\u0002\u0010OJ4\u0010P\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010B\u001a\u00020CH\u0096@¢\u0006\u0002\u0010QJ2\u0010R\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020CH\u0096@¢\u0006\u0002\u0010QJ\u0010\u0010S\u001a\u0004\u0018\u00010%2\u0006\u0010B\u001a\u00020CJ\"\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020U0\u00192\u0006\u0010V\u001a\u00020WH\u0087@¢\u0006\u0002\u0010XJ6\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020U0\u00192\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u0004\u0018\u00010@2\u0006\u0010V\u001a\u00020WH\u0082@¢\u0006\u0002\u0010XJ\u0010\u0010]\u001a\u00020^2\u0006\u0010B\u001a\u00020%H\u0007J*\u0010_\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u00102J\"\u0010`\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u001e\u0010a\u001a\u0002002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020%H\u0096@¢\u0006\u0002\u0010cJ8\u0010d\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020\u001d2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020%0EH\u0096@¢\u0006\u0002\u0010fJ8\u0010g\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020\u001d2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020%0EH\u0096@¢\u0006\u0002\u0010fJ(\u00106\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a07\u0012\u0004\u0012\u00020\u001b0\u00190.2\u0006\u0010h\u001a\u00020\u001dH\u0016J:\u0010i\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020W0k\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0m0j2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020W07H\u0087@¢\u0006\u0002\u0010oJ6\u0010p\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a07\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010q\u001a\u00020\u001d2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001a07H\u0087@¢\u0006\u0002\u0010sJ\"\u0010t\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010u\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ6\u0010v\u001a\b\u0012\u0004\u0012\u00020\u001a072\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001a072\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020W0kH\u0082@¢\u0006\u0002\u0010xR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/box/android/data/service/impl/LocalItemService;", "Lcom/box/android/domain/services/ILocalItemService;", "localItemsDataSource", "Lcom/box/android/data/datasource/localItems/LocalItemsDataSource;", "itemsCreator", "Lcom/box/android/data/utilities/LocalItemServiceItemsCreator;", "legacyCacheDataSource", "Lcom/box/android/data/datasource/LegacyCacheDataSource;", "jobService", "Lcom/box/android/data/jobs/JobService;", "remoteItemService", "Lcom/box/android/data/service/impl/RemoteItemService;", "idMappingService", "Lcom/box/android/data/service/impl/ItemIdMappingService;", "baseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "fileApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/datasource/localItems/LocalItemsDataSource;Lcom/box/android/data/utilities/LocalItemServiceItemsCreator;Lcom/box/android/data/datasource/LegacyCacheDataSource;Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/service/impl/RemoteItemService;Lcom/box/android/data/service/impl/ItemIdMappingService;Lcom/box/android/coreservices/modelcontroller/IBaseModelController;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;Lcom/box/android/domain/identity/IUserContextManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getItemByLocalId", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localId", "withParent", "", "(Lcom/box/android/domain/models/ItemId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItem", "name", "", IdentificationData.FIELD_PARENT_ID, "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "item", "dataPolicy", "Lcom/box/android/domain/configuration/DataPolicy;", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/configuration/DataPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileFromLegacyCache", "observeItem", "Lkotlinx/coroutines/flow/Flow;", "setServerId", "", "serverId", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContentUrl", "cleanup", "enqueueDownloadJobForItems", AlertFragment.ARG_ITEMS, "", "targetFolderUrl", "jobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "(Ljava/util/List;Ljava/lang/String;Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueMarkOfflineJobForItems", "downloadOriginal", "(Ljava/util/List;ZLcom/box/android/domain/usecases/jobs/JobTags$JobSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFolder", "Lcom/box/android/domain/models/item/FolderModel;", "uploadFolder", "contentUrl", "Landroid/net/Uri;", "tags", "", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDocumentUri", "uri", "uploadFile", "Lcom/box/android/domain/models/item/FileModel;", JobConstants.SHOW_NOTIFICATION, "fileId", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Ljava/util/Set;ZLcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initiateAutoUpload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalFile", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalFolder", "getLocalFileSha1", "createLocalItemModel", "Lcom/box/android/data/datasource/CacheError;", "localItemEntity", "Lcom/box/android/data/persistence/localItems/LocalItemEntity;", "(Lcom/box/android/data/persistence/localItems/LocalItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeLocalRemoteItemModels", "remoteModel", "(Lcom/box/android/data/persistence/localItems/LocalItemEntity;Lcom/box/android/domain/models/item/ItemModel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParentFolderModel", "fetchFile", "Ljava/io/File;", "setParentFolderId", "deleteFile", "deleteCollaboration", OAuthActivity.USER_ID, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveItem", "destinationFolderId", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/ItemId;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyItem", "parent", "separateServerAndLocalOnlyItems", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/ItemId$Remote;", "", "input", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndJoinLocalItems", "parentItemId", "remoteItems", "(Lcom/box/android/domain/models/ItemId;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFolderItemsFromRemote", "folderID", "replaceWithServerMappedLocalItems", "serverMappedLocals", "(Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalItemService implements ILocalItemService {
    private static final String LOGTAG = "LocalItemService";
    private final IBaseModelController baseModelController;
    private final CoroutineDispatcher coroutineDispatcher;
    private final BoxExtendedApiFile fileApi;
    private final ItemIdMappingService idMappingService;
    private final LocalItemServiceItemsCreator itemsCreator;
    private final JobService jobService;
    private final LegacyCacheDataSource legacyCacheDataSource;
    private final LocalItemsDataSource localItemsDataSource;
    private final RemoteItemService remoteItemService;
    private final IUserContextManager userContextManager;

    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.WEBLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$cleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0}, l = {BoxCommonConstants.REQUEST_DELETE_CURRENT_FOLDER}, m = "cleanup", n = {"itemId", "localId"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return LocalItemService.this.cleanup(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$copyItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {554, 561}, m = "copyItem", n = {"itemId", "destinationFolderId", "tags", "itemId", "destinationFolderId", "tags", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C14461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14461(Continuation<? super C14461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.copyItem(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$createFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {291, BoxCommonConstants.REQUEST_RETRY_SHARED_LINK, 300, 305}, m = "createFolder", n = {"name", IdentificationData.FIELD_PARENT_ID, "name", IdentificationData.FIELD_PARENT_ID, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "localItem", "name", IdentificationData.FIELD_PARENT_ID, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "localItem", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$createFolder$2", "name", IdentificationData.FIELD_PARENT_ID, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "localItem", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$createFolder$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C14471 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14471(Continuation<? super C14471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.createFolder(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$createLocalFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {385, 386}, m = "createLocalFile", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "localItem", "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "localItem", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$createLocalFile$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C14481 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14481(Continuation<? super C14481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.createLocalFile(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$createLocalFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {399, 400}, m = "createLocalFolder", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "localItem", "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "localItem", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$createLocalFolder$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C14491 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14491(Continuation<? super C14491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.createLocalFolder(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$createLocalItemModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 1, 1, 1}, l = {413, 421}, m = "createLocalItemModel", n = {"localItemEntity", "permissionsModel", "localItemEntity", "permissionsModel", "parentFolderModel"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C14501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C14501(Continuation<? super C14501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.createLocalItemModel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$enqueueDownloadJobForItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {233, 234, 245, 246}, m = "enqueueDownloadJobForItems", n = {AlertFragment.ARG_ITEMS, "targetFolderUrl", "jobSource", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "item", "$i$f$map", "$i$f$mapTo", "$i$a$-map-LocalItemService$enqueueDownloadJobForItems$errorResults$1", AlertFragment.ARG_ITEMS, "targetFolderUrl", "jobSource", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "item", "$this$flatMap$iv", "remoteId", "$i$f$map", "$i$f$mapTo", "$i$a$-map-LocalItemService$enqueueDownloadJobForItems$errorResults$1", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$enqueueDownloadJobForItems$errorResults$1$1", AlertFragment.ARG_ITEMS, "targetFolderUrl", "jobSource", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "item", "$i$f$map", "$i$f$mapTo", "$i$a$-map-LocalItemService$enqueueDownloadJobForItems$errorResults$1", AlertFragment.ARG_ITEMS, "targetFolderUrl", "jobSource", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "item", "$this$flatMap$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-LocalItemService$enqueueDownloadJobForItems$errorResults$1", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$enqueueDownloadJobForItems$errorResults$1$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C14511 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
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
        /* synthetic */ Object result;

        C14511(Continuation<? super C14511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.enqueueDownloadJobForItems(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$fetchAndJoinLocalItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {601, TypedValues.MotionType.TYPE_EASING, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, TypedValues.MotionType.TYPE_POLAR_RELATIVETO}, m = "fetchAndJoinLocalItems", n = {"parentItemId", "remoteItems", "parentItemId", "remoteItems", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "parentItemId", "remoteItems", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "serverMappedLocals", "unmappedLocals", "parentItemId", "remoteItems", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "serverMappedLocals", "unmappedLocals", "updatedRemoteItems", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "it", "$i$f$mapNotNull", "$i$f$mapNotNullTo", "$i$f$forEach", "$i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv", "$i$a$-mapNotNull-LocalItemService$fetchAndJoinLocalItems$remainingLocals$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C14521 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
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

        C14521(Continuation<? super C14521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.fetchAndJoinLocalItems(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$getContentUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0}, l = {214}, m = "getContentUrl", n = {"itemId", "it", "$i$a$-let-LocalItemService$getContentUrl$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C14541 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14541(Continuation<? super C14541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.getContentUrl(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$getItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {107, 108}, m = "getItem", n = {"name", IdentificationData.FIELD_PARENT_ID, "name", IdentificationData.FIELD_PARENT_ID, "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$getItem$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C14551 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14551(Continuation<? super C14551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.getItem(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$getItemByLocalId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {92, 93, 98, 102}, m = "getItemByLocalId", n = {"localId", "withParent", "localId", "$this$flatMap$iv", "serverId", "withParent", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$getItemByLocalId$remoteModel$1", "localId", "remoteModel", "it", "withParent", "$i$a$-let-LocalItemService$getItemByLocalId$localItem$1", "localId", "remoteModel", "localItem", "withParent"}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "L$1", "L$2", "Z$0"}, v = 1)
    static final class C14562 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C14562(Continuation<? super C14562> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.getItemByLocalId(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$getParentFolderModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0}, l = {512}, m = "getParentFolderModel", n = {"localItemEntity", IdentificationData.FIELD_PARENT_ID, "$i$a$-let-LocalItemService$getParentFolderModel$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C14571 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14571(Continuation<? super C14571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.getParentFolderModel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$initiateAutoUpload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {370, 372}, m = "initiateAutoUpload", n = {"uploadInfo", "uploadFolderBoxId", "uploadFolderRemoteId", "sourceFolderDevicePath", "uploadInfo", "uploadFolderBoxId", "uploadFolderRemoteId", "sourceFolderDevicePath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C14581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14581(Continuation<? super C14581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.initiateAutoUpload(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$item$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5}, l = {114, 117, 121, Token.TARGET, 136, Token.XMLEND}, m = "item", n = {"itemId", "dataPolicy", "itemId", "dataPolicy", "$this$flatMap$iv", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "it", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$item$2", "$i$a$-let-LocalItemService$item$2$localItem$1", "itemId", "dataPolicy", "$this$flatMap$iv", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "localItem", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$item$2", "itemId", "dataPolicy", "$this$flatMapError$iv", "it", "it", "$i$f$flatMapError", "$i$a$-flatMapError-LocalItemService$item$3", "$i$a$-let-LocalItemService$item$3$localItem$1", "itemId", "dataPolicy", "$this$flatMapError$iv", "it", "localItem", "$i$f$flatMapError", "$i$a$-flatMapError-LocalItemService$item$3", "itemId", "dataPolicy", "$this$onError$iv", "fetchItemError", "$i$f$onError", "$i$a$-onError-LocalItemService$item$4"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C14591 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C14591(Continuation<? super C14591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.item(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$mergeLocalRemoteItemModels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {450, 456, 505}, m = "mergeLocalRemoteItemModels", n = {"localItemEntity", "remoteModel", "withParent", "localItemEntity", "remoteModel", "parentFolderModel", "it", "withParent", "$i$a$-let-LocalItemService$mergeLocalRemoteItemModels$2", "localItemEntity", "remoteModel", "parentFolderModel", "it", "withParent", "$i$a$-let-LocalItemService$mergeLocalRemoteItemModels$3"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0"}, v = 1)
    static final class C14601 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C14601(Continuation<? super C14601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.mergeLocalRemoteItemModels(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$moveItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {535, 542}, m = "moveItem", n = {"itemId", "destinationFolderId", "tags", "itemId", "destinationFolderId", "tags", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C14611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14611(Continuation<? super C14611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.moveItem(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$replaceWithServerMappedLocalItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {638}, m = "replaceWithServerMappedLocalItems", n = {"remoteItems", "serverMappedLocals", "updatedRemoteItems", "remote", "foundLocal", "i", "$i$a$-let-LocalItemService$replaceWithServerMappedLocalItems$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$2"}, v = 1)
    static final class C14631 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C14631(Continuation<? super C14631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.replaceWithServerMappedLocalItems(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$separateServerAndLocalOnlyItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {590}, m = "separateServerAndLocalOnlyItems", n = {"input", "serverMappedLocals", "unmappedLocals", "$this$forEach$iv", "element$iv", "entity", "$i$f$forEach", "$i$a$-forEach-LocalItemService$separateServerAndLocalOnlyItems$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C14641 extends ContinuationImpl {
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

        C14641(Continuation<? super C14641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.separateServerAndLocalOnlyItems(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$setParentFolderId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {519, 522}, m = "setParentFolderId", n = {"itemId", IdentificationData.FIELD_PARENT_ID, "it", "$i$a$-let-LocalItemService$setParentFolderId$2", "itemId", IdentificationData.FIELD_PARENT_ID, "it", "$this$flatMap$iv", "it", "localItem", "$i$a$-let-LocalItemService$setParentFolderId$2", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$setParentFolderId$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
    static final class C14651 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14651(Continuation<? super C14651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.setParentFolderId(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$setServerId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0}, l = {205}, m = "setServerId", n = {"itemId", "serverId", "localId", "remoteId"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C14661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14661(Continuation<? super C14661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.setServerId(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {347, 351, 353}, m = "uploadFile", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "fileId", JobConstants.SHOW_NOTIFICATION, "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "fileId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, JobConstants.SHOW_NOTIFICATION, "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "fileId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "fileModel", JobConstants.SHOW_NOTIFICATION, "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$uploadFile$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1"}, v = 1)
    static final class C14671 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C14671(Continuation<? super C14671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.uploadFile(null, null, null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$uploadFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService", f = "LocalItemService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {TypedValues.AttributesType.TYPE_EASING, 321, 323}, m = "uploadFolder", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "folderModel", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$uploadFolder$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C14681 extends ContinuationImpl {
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

        C14681(Continuation<? super C14681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalItemService.this.uploadFolder(null, null, null, null, this);
        }
    }

    @Inject
    public LocalItemService(LocalItemsDataSource localItemsDataSource, LocalItemServiceItemsCreator itemsCreator, LegacyCacheDataSource legacyCacheDataSource, JobService jobService, RemoteItemService remoteItemService, ItemIdMappingService idMappingService, IBaseModelController baseModelController, BoxExtendedApiFile fileApi, IUserContextManager userContextManager, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(localItemsDataSource, "localItemsDataSource");
        Intrinsics.checkNotNullParameter(itemsCreator, "itemsCreator");
        Intrinsics.checkNotNullParameter(legacyCacheDataSource, "legacyCacheDataSource");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(baseModelController, "baseModelController");
        Intrinsics.checkNotNullParameter(fileApi, "fileApi");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.localItemsDataSource = localItemsDataSource;
        this.itemsCreator = itemsCreator;
        this.legacyCacheDataSource = legacyCacheDataSource;
        this.jobService = jobService;
        this.remoteItemService = remoteItemService;
        this.idMappingService = idMappingService;
        this.baseModelController = baseModelController;
        this.fileApi = fileApi;
        this.userContextManager = userContextManager;
        this.coroutineDispatcher = coroutineDispatcher;
    }

    @Override // com.box.android.domain.services.ILocalItemService
    public Object getItemByLocalId(ItemId itemId, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) throws UnsupportedEncodingException {
        return getItemByLocalId(itemId, true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:40:0x0100  */
    /* JADX WARN: Code duplicated, block: B:41:0x0104  */
    /* JADX WARN: Code duplicated, block: B:43:0x0107  */
    /* JADX WARN: Code duplicated, block: B:47:0x0130  */
    /* JADX WARN: Code duplicated, block: B:60:0x0177  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0124, code lost:
    
        if (r15 == r1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014b, code lost:
    
        if (r15 == r1) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getItemByLocalId(com.box.android.domain.models.ItemId r13, boolean r14, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.domain.models.DomainError>> r15) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.getItemByLocalId(com.box.android.domain.models.ItemId, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r8 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.ILocalItemService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getItem(java.lang.String r6, com.box.android.domain.models.ItemId r7, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.domain.models.DomainError>> r8) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.getItem(java.lang.String, com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:102:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:104:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:25:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:26:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:28:0x0101  */
    /* JADX WARN: Code duplicated, block: B:31:0x012c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0140  */
    /* JADX WARN: Code duplicated, block: B:37:0x0170  */
    /* JADX WARN: Code duplicated, block: B:41:0x0178  */
    /* JADX WARN: Code duplicated, block: B:43:0x017c  */
    /* JADX WARN: Code duplicated, block: B:45:0x0198  */
    /* JADX WARN: Code duplicated, block: B:47:0x019e  */
    /* JADX WARN: Code duplicated, block: B:49:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:55:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:57:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:63:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:65:0x0205  */
    /* JADX WARN: Code duplicated, block: B:69:0x0233  */
    /* JADX WARN: Code duplicated, block: B:72:0x023a  */
    /* JADX WARN: Code duplicated, block: B:73:0x023c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0240  */
    /* JADX WARN: Code duplicated, block: B:77:0x025a A[PHI: r7 r8 r9
      0x025a: PHI (r7v18 com.box.android.domain.utils.result.Result) = (r7v8 com.box.android.domain.utils.result.Result), (r7v20 com.box.android.domain.utils.result.Result) binds: [B:51:0x01a6, B:76:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x025a: PHI (r8v21 com.box.android.domain.configuration.DataPolicy) = (r8v12 com.box.android.domain.configuration.DataPolicy), (r8v22 com.box.android.domain.configuration.DataPolicy) binds: [B:51:0x01a6, B:76:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x025a: PHI (r9v15 com.box.android.domain.models.ItemId) = (r9v9 com.box.android.domain.models.ItemId), (r9v16 com.box.android.domain.models.ItemId) binds: [B:51:0x01a6, B:76:0x0258] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:80:0x025f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0263  */
    /* JADX WARN: Code duplicated, block: B:84:0x0270  */
    /* JADX WARN: Code duplicated, block: B:87:0x0294  */
    /* JADX WARN: Code duplicated, block: B:90:0x029b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x029c  */
    /* JADX WARN: Code duplicated, block: B:93:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:98:0x02b9  */
    @Override // com.box.android.domain.services.IItemService
    public Object item(ItemId itemId, DataPolicy dataPolicy, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) throws UnsupportedEncodingException {
        C14591 c14591;
        Result error;
        ItemId itemId2;
        DataPolicy dataPolicy2;
        ItemModel itemModel;
        ItemId.Local local;
        ItemId itemId3;
        DataPolicy dataPolicy3;
        int i;
        int i2;
        Result result;
        ItemModel itemModel2;
        LocalItemEntity localItemEntity;
        DataPolicy dataPolicy4;
        int i3;
        int i4;
        ItemId itemId4;
        DomainError domainError;
        ItemId.Local local2;
        int i5;
        int i6;
        DataPolicy dataPolicy5;
        Result result2;
        DomainError domainError2;
        LocalItemEntity localItemEntity2;
        int i7;
        int i8;
        Result.Error error2;
        ItemId itemId5;
        DomainError domainError3;
        DomainError domainError4;
        Result result3;
        Result result4;
        if (continuation instanceof C14591) {
            c14591 = (C14591) continuation;
            if ((c14591.label & Integer.MIN_VALUE) != 0) {
                c14591.label -= Integer.MIN_VALUE;
            } else {
                c14591 = new C14591(continuation);
            }
        } else {
            c14591 = new C14591(continuation);
        }
        Object objItem = c14591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c14591.label) {
            case 0:
                ResultKt.throwOnFailure(objItem);
                RemoteItemService remoteItemService = this.remoteItemService;
                c14591.L$0 = itemId;
                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy);
                c14591.label = 1;
                objItem = remoteItemService.item(itemId, dataPolicy, c14591);
                if (objItem != coroutine_suspended) {
                    error = (Result) objItem;
                    if (error instanceof Result.Success) {
                        itemModel = (ItemModel) ((Result.Success) error).getValue();
                        if (itemId instanceof ItemId.Local) {
                            local = (ItemId.Local) itemId;
                        } else {
                            local = null;
                        }
                        if (local != null) {
                            c14591.L$0 = itemId;
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                            c14591.L$3 = itemModel;
                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(local);
                            c14591.I$0 = 0;
                            c14591.I$1 = 0;
                            c14591.I$2 = 0;
                            c14591.label = 2;
                            objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId, c14591);
                            if (objItem != coroutine_suspended) {
                                itemId3 = itemId;
                                dataPolicy4 = dataPolicy;
                                i3 = 0;
                                i4 = 0;
                                int i9 = i4;
                                i = i3;
                                dataPolicy3 = dataPolicy4;
                                result = error;
                                itemModel2 = itemModel;
                                localItemEntity = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                                i2 = i9;
                                c14591.L$0 = itemId3;
                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy3);
                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(result);
                                c14591.L$3 = SpillingKt.nullOutSpilledVariable(itemModel2);
                                c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity);
                                c14591.I$0 = i2;
                                c14591.I$1 = i;
                                c14591.label = 3;
                                objItem = mergeLocalRemoteItemModels(localItemEntity, itemModel2, true, c14591);
                                if (objItem != coroutine_suspended) {
                                    itemId4 = itemId3;
                                    error2 = (Result) objItem;
                                    if (!(error2 instanceof Result.Success)) {
                                        if (error2 instanceof Result.Error) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        error2 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error2).getValue(), null, 2, null));
                                    }
                                    dataPolicy2 = dataPolicy3;
                                    itemId2 = itemId4;
                                    error = error2;
                                    if (!(error instanceof Result.Success)) {
                                        if (!(error instanceof Result.Success)) {
                                            if (error instanceof Result.Error) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            domainError3 = (DomainError) ((Result.Error) error).getValue();
                                            if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                c14591.L$3 = domainError3;
                                                c14591.L$4 = null;
                                                c14591.I$0 = 0;
                                                c14591.I$1 = 0;
                                                c14591.label = 6;
                                                objItem = fileFromLegacyCache(itemId2, c14591);
                                                if (objItem != coroutine_suspended) {
                                                    domainError4 = domainError3;
                                                    result4 = (Result) objItem;
                                                    if (result4 instanceof Result.Success) {
                                                        return result4;
                                                    }
                                                    if (!(result4 instanceof Result.Error)) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                }
                                            }
                                        }
                                        return error;
                                    }
                                    if (error instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    domainError = (DomainError) ((Result.Error) error).getValue();
                                    if (itemId2 instanceof ItemId.Local) {
                                        local2 = (ItemId.Local) itemId2;
                                    } else {
                                        local2 = null;
                                    }
                                    if (local2 != null) {
                                        c14591.L$0 = itemId2;
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                                        c14591.I$0 = 0;
                                        c14591.I$1 = 0;
                                        c14591.I$2 = 0;
                                        c14591.label = 4;
                                        objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                                        if (objItem != coroutine_suspended) {
                                            i7 = 0;
                                            i8 = 0;
                                            int i10 = i8;
                                            i5 = i7;
                                            dataPolicy5 = dataPolicy2;
                                            result2 = error;
                                            domainError2 = domainError;
                                            localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                                            i6 = i10;
                                            c14591.L$0 = itemId2;
                                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                            c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                            c14591.I$0 = i6;
                                            c14591.I$1 = i5;
                                            c14591.label = 5;
                                            objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                            if (objItem != coroutine_suspended) {
                                                itemId5 = itemId2;
                                                result3 = (Result) objItem;
                                                if (result3 instanceof Result.Success) {
                                                    error = result3;
                                                } else {
                                                    if (result3 instanceof Result.Error) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                                }
                                                dataPolicy2 = dataPolicy5;
                                                itemId2 = itemId5;
                                                if (!(error instanceof Result.Success)) {
                                                    if (error instanceof Result.Error) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    domainError3 = (DomainError) ((Result.Error) error).getValue();
                                                    if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                        c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                        c14591.L$3 = domainError3;
                                                        c14591.L$4 = null;
                                                        c14591.I$0 = 0;
                                                        c14591.I$1 = 0;
                                                        c14591.label = 6;
                                                        objItem = fileFromLegacyCache(itemId2, c14591);
                                                        if (objItem != coroutine_suspended) {
                                                            domainError4 = domainError3;
                                                            result4 = (Result) objItem;
                                                            if (result4 instanceof Result.Success) {
                                                                return result4;
                                                            }
                                                            if (!(result4 instanceof Result.Error)) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                        }
                                                    }
                                                }
                                                return error;
                                            }
                                        }
                                    } else {
                                        i5 = 0;
                                        i6 = 0;
                                        dataPolicy5 = dataPolicy2;
                                        result2 = error;
                                        domainError2 = domainError;
                                        localItemEntity2 = null;
                                        c14591.L$0 = itemId2;
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                        c14591.I$0 = i6;
                                        c14591.I$1 = i5;
                                        c14591.label = 5;
                                        objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                        if (objItem != coroutine_suspended) {
                                            itemId5 = itemId2;
                                            result3 = (Result) objItem;
                                            if (result3 instanceof Result.Success) {
                                                error = result3;
                                            } else {
                                                if (result3 instanceof Result.Error) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                            }
                                            dataPolicy2 = dataPolicy5;
                                            itemId2 = itemId5;
                                            if (!(error instanceof Result.Success)) {
                                                if (error instanceof Result.Error) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                domainError3 = (DomainError) ((Result.Error) error).getValue();
                                                if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                    c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                    c14591.L$3 = domainError3;
                                                    c14591.L$4 = null;
                                                    c14591.I$0 = 0;
                                                    c14591.I$1 = 0;
                                                    c14591.label = 6;
                                                    objItem = fileFromLegacyCache(itemId2, c14591);
                                                    if (objItem != coroutine_suspended) {
                                                        domainError4 = domainError3;
                                                        result4 = (Result) objItem;
                                                        if (result4 instanceof Result.Success) {
                                                            return result4;
                                                        }
                                                        if (!(result4 instanceof Result.Error)) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                    }
                                                }
                                            }
                                            return error;
                                        }
                                    }
                                }
                            }
                        } else {
                            itemId3 = itemId;
                            dataPolicy3 = dataPolicy;
                            i = 0;
                            i2 = 0;
                            result = error;
                            itemModel2 = itemModel;
                            localItemEntity = null;
                            c14591.L$0 = itemId3;
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy3);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(result);
                            c14591.L$3 = SpillingKt.nullOutSpilledVariable(itemModel2);
                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity);
                            c14591.I$0 = i2;
                            c14591.I$1 = i;
                            c14591.label = 3;
                            objItem = mergeLocalRemoteItemModels(localItemEntity, itemModel2, true, c14591);
                            if (objItem != coroutine_suspended) {
                                itemId4 = itemId3;
                                error2 = (Result) objItem;
                                if (!(error2 instanceof Result.Success)) {
                                    if (error2 instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error2 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error2).getValue(), null, 2, null));
                                }
                                dataPolicy2 = dataPolicy3;
                                itemId2 = itemId4;
                                error = error2;
                                if (!(error instanceof Result.Success)) {
                                    if (!(error instanceof Result.Success)) {
                                        if (error instanceof Result.Error) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        domainError3 = (DomainError) ((Result.Error) error).getValue();
                                        if (domainError3 instanceof DomainError.NoResultFoundError) {
                                            c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                            c14591.L$3 = domainError3;
                                            c14591.L$4 = null;
                                            c14591.I$0 = 0;
                                            c14591.I$1 = 0;
                                            c14591.label = 6;
                                            objItem = fileFromLegacyCache(itemId2, c14591);
                                            if (objItem != coroutine_suspended) {
                                                domainError4 = domainError3;
                                                result4 = (Result) objItem;
                                                if (result4 instanceof Result.Success) {
                                                    return result4;
                                                }
                                                if (!(result4 instanceof Result.Error)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                            }
                                        }
                                    }
                                    return error;
                                }
                                if (error instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                domainError = (DomainError) ((Result.Error) error).getValue();
                                if (itemId2 instanceof ItemId.Local) {
                                    local2 = (ItemId.Local) itemId2;
                                } else {
                                    local2 = null;
                                }
                                if (local2 != null) {
                                    c14591.L$0 = itemId2;
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                    c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                                    c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                                    c14591.I$0 = 0;
                                    c14591.I$1 = 0;
                                    c14591.I$2 = 0;
                                    c14591.label = 4;
                                    objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                                    if (objItem != coroutine_suspended) {
                                        i7 = 0;
                                        i8 = 0;
                                        int i11 = i8;
                                        i5 = i7;
                                        dataPolicy5 = dataPolicy2;
                                        result2 = error;
                                        domainError2 = domainError;
                                        localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                                        i6 = i11;
                                        c14591.L$0 = itemId2;
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                        c14591.I$0 = i6;
                                        c14591.I$1 = i5;
                                        c14591.label = 5;
                                        objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                        if (objItem != coroutine_suspended) {
                                            itemId5 = itemId2;
                                            result3 = (Result) objItem;
                                            if (result3 instanceof Result.Success) {
                                                error = result3;
                                            } else {
                                                if (result3 instanceof Result.Error) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                            }
                                            dataPolicy2 = dataPolicy5;
                                            itemId2 = itemId5;
                                            if (!(error instanceof Result.Success)) {
                                                if (error instanceof Result.Error) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                domainError3 = (DomainError) ((Result.Error) error).getValue();
                                                if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                    c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                    c14591.L$3 = domainError3;
                                                    c14591.L$4 = null;
                                                    c14591.I$0 = 0;
                                                    c14591.I$1 = 0;
                                                    c14591.label = 6;
                                                    objItem = fileFromLegacyCache(itemId2, c14591);
                                                    if (objItem != coroutine_suspended) {
                                                        domainError4 = domainError3;
                                                        result4 = (Result) objItem;
                                                        if (result4 instanceof Result.Success) {
                                                            return result4;
                                                        }
                                                        if (!(result4 instanceof Result.Error)) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                    }
                                                }
                                            }
                                            return error;
                                        }
                                    }
                                } else {
                                    i5 = 0;
                                    i6 = 0;
                                    dataPolicy5 = dataPolicy2;
                                    result2 = error;
                                    domainError2 = domainError;
                                    localItemEntity2 = null;
                                    c14591.L$0 = itemId2;
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                    c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                    c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                    c14591.I$0 = i6;
                                    c14591.I$1 = i5;
                                    c14591.label = 5;
                                    objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                    if (objItem != coroutine_suspended) {
                                        itemId5 = itemId2;
                                        result3 = (Result) objItem;
                                        if (result3 instanceof Result.Success) {
                                            error = result3;
                                        } else {
                                            if (result3 instanceof Result.Error) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                        }
                                        dataPolicy2 = dataPolicy5;
                                        itemId2 = itemId5;
                                        if (!(error instanceof Result.Success)) {
                                            if (error instanceof Result.Error) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            domainError3 = (DomainError) ((Result.Error) error).getValue();
                                            if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                c14591.L$3 = domainError3;
                                                c14591.L$4 = null;
                                                c14591.I$0 = 0;
                                                c14591.I$1 = 0;
                                                c14591.label = 6;
                                                objItem = fileFromLegacyCache(itemId2, c14591);
                                                if (objItem != coroutine_suspended) {
                                                    domainError4 = domainError3;
                                                    result4 = (Result) objItem;
                                                    if (result4 instanceof Result.Success) {
                                                        return result4;
                                                    }
                                                    if (!(result4 instanceof Result.Error)) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                }
                                            }
                                        }
                                        return error;
                                    }
                                }
                            }
                        }
                    } else {
                        if (error instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        itemId2 = itemId;
                        dataPolicy2 = dataPolicy;
                        if (!(error instanceof Result.Success)) {
                            if (!(error instanceof Result.Success)) {
                                if (error instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                domainError3 = (DomainError) ((Result.Error) error).getValue();
                                if (domainError3 instanceof DomainError.NoResultFoundError) {
                                    c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                    c14591.L$3 = domainError3;
                                    c14591.L$4 = null;
                                    c14591.I$0 = 0;
                                    c14591.I$1 = 0;
                                    c14591.label = 6;
                                    objItem = fileFromLegacyCache(itemId2, c14591);
                                    if (objItem != coroutine_suspended) {
                                        domainError4 = domainError3;
                                        result4 = (Result) objItem;
                                        if (result4 instanceof Result.Success) {
                                            return result4;
                                        }
                                        if (!(result4 instanceof Result.Error)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                    }
                                }
                            }
                            return error;
                        }
                        if (error instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        domainError = (DomainError) ((Result.Error) error).getValue();
                        if (itemId2 instanceof ItemId.Local) {
                            local2 = (ItemId.Local) itemId2;
                        } else {
                            local2 = null;
                        }
                        if (local2 != null) {
                            c14591.L$0 = itemId2;
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                            c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                            c14591.I$0 = 0;
                            c14591.I$1 = 0;
                            c14591.I$2 = 0;
                            c14591.label = 4;
                            objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                            if (objItem != coroutine_suspended) {
                                i7 = 0;
                                i8 = 0;
                                int i12 = i8;
                                i5 = i7;
                                dataPolicy5 = dataPolicy2;
                                result2 = error;
                                domainError2 = domainError;
                                localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                                i6 = i12;
                                c14591.L$0 = itemId2;
                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                c14591.I$0 = i6;
                                c14591.I$1 = i5;
                                c14591.label = 5;
                                objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                if (objItem != coroutine_suspended) {
                                    itemId5 = itemId2;
                                    result3 = (Result) objItem;
                                    if (result3 instanceof Result.Success) {
                                        error = result3;
                                    } else {
                                        if (result3 instanceof Result.Error) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                    }
                                    dataPolicy2 = dataPolicy5;
                                    itemId2 = itemId5;
                                    if (!(error instanceof Result.Success)) {
                                        if (error instanceof Result.Error) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        domainError3 = (DomainError) ((Result.Error) error).getValue();
                                        if (domainError3 instanceof DomainError.NoResultFoundError) {
                                            c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                            c14591.L$3 = domainError3;
                                            c14591.L$4 = null;
                                            c14591.I$0 = 0;
                                            c14591.I$1 = 0;
                                            c14591.label = 6;
                                            objItem = fileFromLegacyCache(itemId2, c14591);
                                            if (objItem != coroutine_suspended) {
                                                domainError4 = domainError3;
                                                result4 = (Result) objItem;
                                                if (result4 instanceof Result.Success) {
                                                    return result4;
                                                }
                                                if (!(result4 instanceof Result.Error)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                            }
                                        }
                                    }
                                    return error;
                                }
                            }
                        } else {
                            i5 = 0;
                            i6 = 0;
                            dataPolicy5 = dataPolicy2;
                            result2 = error;
                            domainError2 = domainError;
                            localItemEntity2 = null;
                            c14591.L$0 = itemId2;
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                            c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                            c14591.I$0 = i6;
                            c14591.I$1 = i5;
                            c14591.label = 5;
                            objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                            if (objItem != coroutine_suspended) {
                                itemId5 = itemId2;
                                result3 = (Result) objItem;
                                if (result3 instanceof Result.Success) {
                                    error = result3;
                                } else {
                                    if (result3 instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                }
                                dataPolicy2 = dataPolicy5;
                                itemId2 = itemId5;
                                if (!(error instanceof Result.Success)) {
                                    if (error instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    domainError3 = (DomainError) ((Result.Error) error).getValue();
                                    if (domainError3 instanceof DomainError.NoResultFoundError) {
                                        c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                        c14591.L$3 = domainError3;
                                        c14591.L$4 = null;
                                        c14591.I$0 = 0;
                                        c14591.I$1 = 0;
                                        c14591.label = 6;
                                        objItem = fileFromLegacyCache(itemId2, c14591);
                                        if (objItem != coroutine_suspended) {
                                            domainError4 = domainError3;
                                            result4 = (Result) objItem;
                                            if (result4 instanceof Result.Success) {
                                                return result4;
                                            }
                                            if (!(result4 instanceof Result.Error)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                        }
                                    }
                                }
                                return error;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                dataPolicy = (DataPolicy) c14591.L$1;
                itemId = (ItemId) c14591.L$0;
                ResultKt.throwOnFailure(objItem);
                error = (Result) objItem;
                if (error instanceof Result.Success) {
                    itemModel = (ItemModel) ((Result.Success) error).getValue();
                    if (itemId instanceof ItemId.Local) {
                        local = (ItemId.Local) itemId;
                    } else {
                        local = null;
                    }
                    if (local != null) {
                        c14591.L$0 = itemId;
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                        c14591.L$3 = itemModel;
                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(local);
                        c14591.I$0 = 0;
                        c14591.I$1 = 0;
                        c14591.I$2 = 0;
                        c14591.label = 2;
                        objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId, c14591);
                        if (objItem != coroutine_suspended) {
                            itemId3 = itemId;
                            dataPolicy4 = dataPolicy;
                            i3 = 0;
                            i4 = 0;
                            int i13 = i4;
                            i = i3;
                            dataPolicy3 = dataPolicy4;
                            result = error;
                            itemModel2 = itemModel;
                            localItemEntity = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                            i2 = i13;
                            c14591.L$0 = itemId3;
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy3);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(result);
                            c14591.L$3 = SpillingKt.nullOutSpilledVariable(itemModel2);
                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity);
                            c14591.I$0 = i2;
                            c14591.I$1 = i;
                            c14591.label = 3;
                            objItem = mergeLocalRemoteItemModels(localItemEntity, itemModel2, true, c14591);
                            if (objItem != coroutine_suspended) {
                                itemId4 = itemId3;
                                error2 = (Result) objItem;
                                if (!(error2 instanceof Result.Success)) {
                                    if (error2 instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error2 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error2).getValue(), null, 2, null));
                                }
                                dataPolicy2 = dataPolicy3;
                                itemId2 = itemId4;
                                error = error2;
                                if (!(error instanceof Result.Success)) {
                                    if (!(error instanceof Result.Success)) {
                                        if (error instanceof Result.Error) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        domainError3 = (DomainError) ((Result.Error) error).getValue();
                                        if (domainError3 instanceof DomainError.NoResultFoundError) {
                                            c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                            c14591.L$3 = domainError3;
                                            c14591.L$4 = null;
                                            c14591.I$0 = 0;
                                            c14591.I$1 = 0;
                                            c14591.label = 6;
                                            objItem = fileFromLegacyCache(itemId2, c14591);
                                            if (objItem != coroutine_suspended) {
                                                domainError4 = domainError3;
                                                result4 = (Result) objItem;
                                                if (result4 instanceof Result.Success) {
                                                    return result4;
                                                }
                                                if (!(result4 instanceof Result.Error)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                            }
                                        }
                                    }
                                    return error;
                                }
                                if (error instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                domainError = (DomainError) ((Result.Error) error).getValue();
                                if (itemId2 instanceof ItemId.Local) {
                                    local2 = (ItemId.Local) itemId2;
                                } else {
                                    local2 = null;
                                }
                                if (local2 != null) {
                                    c14591.L$0 = itemId2;
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                    c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                                    c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                                    c14591.I$0 = 0;
                                    c14591.I$1 = 0;
                                    c14591.I$2 = 0;
                                    c14591.label = 4;
                                    objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                                    if (objItem != coroutine_suspended) {
                                        i7 = 0;
                                        i8 = 0;
                                        int i14 = i8;
                                        i5 = i7;
                                        dataPolicy5 = dataPolicy2;
                                        result2 = error;
                                        domainError2 = domainError;
                                        localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                                        i6 = i14;
                                        c14591.L$0 = itemId2;
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                        c14591.I$0 = i6;
                                        c14591.I$1 = i5;
                                        c14591.label = 5;
                                        objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                        if (objItem != coroutine_suspended) {
                                            itemId5 = itemId2;
                                            result3 = (Result) objItem;
                                            if (result3 instanceof Result.Success) {
                                                error = result3;
                                            } else {
                                                if (result3 instanceof Result.Error) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                            }
                                            dataPolicy2 = dataPolicy5;
                                            itemId2 = itemId5;
                                            if (!(error instanceof Result.Success)) {
                                                if (error instanceof Result.Error) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                domainError3 = (DomainError) ((Result.Error) error).getValue();
                                                if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                    c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                    c14591.L$3 = domainError3;
                                                    c14591.L$4 = null;
                                                    c14591.I$0 = 0;
                                                    c14591.I$1 = 0;
                                                    c14591.label = 6;
                                                    objItem = fileFromLegacyCache(itemId2, c14591);
                                                    if (objItem != coroutine_suspended) {
                                                        domainError4 = domainError3;
                                                        result4 = (Result) objItem;
                                                        if (result4 instanceof Result.Success) {
                                                            return result4;
                                                        }
                                                        if (!(result4 instanceof Result.Error)) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                    }
                                                }
                                            }
                                            return error;
                                        }
                                    }
                                } else {
                                    i5 = 0;
                                    i6 = 0;
                                    dataPolicy5 = dataPolicy2;
                                    result2 = error;
                                    domainError2 = domainError;
                                    localItemEntity2 = null;
                                    c14591.L$0 = itemId2;
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                    c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                    c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                    c14591.I$0 = i6;
                                    c14591.I$1 = i5;
                                    c14591.label = 5;
                                    objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                    if (objItem != coroutine_suspended) {
                                        itemId5 = itemId2;
                                        result3 = (Result) objItem;
                                        if (result3 instanceof Result.Success) {
                                            error = result3;
                                        } else {
                                            if (result3 instanceof Result.Error) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                        }
                                        dataPolicy2 = dataPolicy5;
                                        itemId2 = itemId5;
                                        if (!(error instanceof Result.Success)) {
                                            if (error instanceof Result.Error) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            domainError3 = (DomainError) ((Result.Error) error).getValue();
                                            if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                c14591.L$3 = domainError3;
                                                c14591.L$4 = null;
                                                c14591.I$0 = 0;
                                                c14591.I$1 = 0;
                                                c14591.label = 6;
                                                objItem = fileFromLegacyCache(itemId2, c14591);
                                                if (objItem != coroutine_suspended) {
                                                    domainError4 = domainError3;
                                                    result4 = (Result) objItem;
                                                    if (result4 instanceof Result.Success) {
                                                        return result4;
                                                    }
                                                    if (!(result4 instanceof Result.Error)) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                }
                                            }
                                        }
                                        return error;
                                    }
                                }
                            }
                        }
                    } else {
                        itemId3 = itemId;
                        dataPolicy3 = dataPolicy;
                        i = 0;
                        i2 = 0;
                        result = error;
                        itemModel2 = itemModel;
                        localItemEntity = null;
                        c14591.L$0 = itemId3;
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy3);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(result);
                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(itemModel2);
                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity);
                        c14591.I$0 = i2;
                        c14591.I$1 = i;
                        c14591.label = 3;
                        objItem = mergeLocalRemoteItemModels(localItemEntity, itemModel2, true, c14591);
                        if (objItem != coroutine_suspended) {
                            itemId4 = itemId3;
                            error2 = (Result) objItem;
                            if (!(error2 instanceof Result.Success)) {
                                if (error2 instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error2 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error2).getValue(), null, 2, null));
                            }
                            dataPolicy2 = dataPolicy3;
                            itemId2 = itemId4;
                            error = error2;
                            if (!(error instanceof Result.Success)) {
                                if (!(error instanceof Result.Success)) {
                                    if (error instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    domainError3 = (DomainError) ((Result.Error) error).getValue();
                                    if (domainError3 instanceof DomainError.NoResultFoundError) {
                                        c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                        c14591.L$3 = domainError3;
                                        c14591.L$4 = null;
                                        c14591.I$0 = 0;
                                        c14591.I$1 = 0;
                                        c14591.label = 6;
                                        objItem = fileFromLegacyCache(itemId2, c14591);
                                        if (objItem != coroutine_suspended) {
                                            domainError4 = domainError3;
                                            result4 = (Result) objItem;
                                            if (result4 instanceof Result.Success) {
                                                return result4;
                                            }
                                            if (!(result4 instanceof Result.Error)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                        }
                                    }
                                }
                                return error;
                            }
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            domainError = (DomainError) ((Result.Error) error).getValue();
                            if (itemId2 instanceof ItemId.Local) {
                                local2 = (ItemId.Local) itemId2;
                            } else {
                                local2 = null;
                            }
                            if (local2 != null) {
                                c14591.L$0 = itemId2;
                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                                c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                                c14591.I$0 = 0;
                                c14591.I$1 = 0;
                                c14591.I$2 = 0;
                                c14591.label = 4;
                                objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                                if (objItem != coroutine_suspended) {
                                    i7 = 0;
                                    i8 = 0;
                                    int i15 = i8;
                                    i5 = i7;
                                    dataPolicy5 = dataPolicy2;
                                    result2 = error;
                                    domainError2 = domainError;
                                    localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                                    i6 = i15;
                                    c14591.L$0 = itemId2;
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                    c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                    c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                    c14591.I$0 = i6;
                                    c14591.I$1 = i5;
                                    c14591.label = 5;
                                    objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                    if (objItem != coroutine_suspended) {
                                        itemId5 = itemId2;
                                        result3 = (Result) objItem;
                                        if (result3 instanceof Result.Success) {
                                            error = result3;
                                        } else {
                                            if (result3 instanceof Result.Error) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                        }
                                        dataPolicy2 = dataPolicy5;
                                        itemId2 = itemId5;
                                        if (!(error instanceof Result.Success)) {
                                            if (error instanceof Result.Error) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            domainError3 = (DomainError) ((Result.Error) error).getValue();
                                            if (domainError3 instanceof DomainError.NoResultFoundError) {
                                                c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                                c14591.L$3 = domainError3;
                                                c14591.L$4 = null;
                                                c14591.I$0 = 0;
                                                c14591.I$1 = 0;
                                                c14591.label = 6;
                                                objItem = fileFromLegacyCache(itemId2, c14591);
                                                if (objItem != coroutine_suspended) {
                                                    domainError4 = domainError3;
                                                    result4 = (Result) objItem;
                                                    if (result4 instanceof Result.Success) {
                                                        return result4;
                                                    }
                                                    if (!(result4 instanceof Result.Error)) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                                }
                                            }
                                        }
                                        return error;
                                    }
                                }
                            } else {
                                i5 = 0;
                                i6 = 0;
                                dataPolicy5 = dataPolicy2;
                                result2 = error;
                                domainError2 = domainError;
                                localItemEntity2 = null;
                                c14591.L$0 = itemId2;
                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                                c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                                c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                                c14591.I$0 = i6;
                                c14591.I$1 = i5;
                                c14591.label = 5;
                                objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                                if (objItem != coroutine_suspended) {
                                    itemId5 = itemId2;
                                    result3 = (Result) objItem;
                                    if (result3 instanceof Result.Success) {
                                        error = result3;
                                    } else {
                                        if (result3 instanceof Result.Error) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                    }
                                    dataPolicy2 = dataPolicy5;
                                    itemId2 = itemId5;
                                    if (!(error instanceof Result.Success)) {
                                        if (error instanceof Result.Error) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        domainError3 = (DomainError) ((Result.Error) error).getValue();
                                        if (domainError3 instanceof DomainError.NoResultFoundError) {
                                            c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                            c14591.L$3 = domainError3;
                                            c14591.L$4 = null;
                                            c14591.I$0 = 0;
                                            c14591.I$1 = 0;
                                            c14591.label = 6;
                                            objItem = fileFromLegacyCache(itemId2, c14591);
                                            if (objItem != coroutine_suspended) {
                                                domainError4 = domainError3;
                                                result4 = (Result) objItem;
                                                if (result4 instanceof Result.Success) {
                                                    return result4;
                                                }
                                                if (!(result4 instanceof Result.Error)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                            }
                                        }
                                    }
                                    return error;
                                }
                            }
                        }
                    }
                } else {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    itemId2 = itemId;
                    dataPolicy2 = dataPolicy;
                    if (!(error instanceof Result.Success)) {
                        if (!(error instanceof Result.Success)) {
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            domainError3 = (DomainError) ((Result.Error) error).getValue();
                            if (domainError3 instanceof DomainError.NoResultFoundError) {
                                c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                c14591.L$3 = domainError3;
                                c14591.L$4 = null;
                                c14591.I$0 = 0;
                                c14591.I$1 = 0;
                                c14591.label = 6;
                                objItem = fileFromLegacyCache(itemId2, c14591);
                                if (objItem != coroutine_suspended) {
                                    domainError4 = domainError3;
                                    result4 = (Result) objItem;
                                    if (result4 instanceof Result.Success) {
                                        return result4;
                                    }
                                    if (!(result4 instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                }
                            }
                        }
                        return error;
                    }
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    domainError = (DomainError) ((Result.Error) error).getValue();
                    if (itemId2 instanceof ItemId.Local) {
                        local2 = (ItemId.Local) itemId2;
                    } else {
                        local2 = null;
                    }
                    if (local2 != null) {
                        c14591.L$0 = itemId2;
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                        c14591.I$0 = 0;
                        c14591.I$1 = 0;
                        c14591.I$2 = 0;
                        c14591.label = 4;
                        objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                        if (objItem != coroutine_suspended) {
                            i7 = 0;
                            i8 = 0;
                            int i16 = i8;
                            i5 = i7;
                            dataPolicy5 = dataPolicy2;
                            result2 = error;
                            domainError2 = domainError;
                            localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                            i6 = i16;
                            c14591.L$0 = itemId2;
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                            c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                            c14591.I$0 = i6;
                            c14591.I$1 = i5;
                            c14591.label = 5;
                            objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                            if (objItem != coroutine_suspended) {
                                itemId5 = itemId2;
                                result3 = (Result) objItem;
                                if (result3 instanceof Result.Success) {
                                    error = result3;
                                } else {
                                    if (result3 instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                }
                                dataPolicy2 = dataPolicy5;
                                itemId2 = itemId5;
                                if (!(error instanceof Result.Success)) {
                                    if (error instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    domainError3 = (DomainError) ((Result.Error) error).getValue();
                                    if (domainError3 instanceof DomainError.NoResultFoundError) {
                                        c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                        c14591.L$3 = domainError3;
                                        c14591.L$4 = null;
                                        c14591.I$0 = 0;
                                        c14591.I$1 = 0;
                                        c14591.label = 6;
                                        objItem = fileFromLegacyCache(itemId2, c14591);
                                        if (objItem != coroutine_suspended) {
                                            domainError4 = domainError3;
                                            result4 = (Result) objItem;
                                            if (result4 instanceof Result.Success) {
                                                return result4;
                                            }
                                            if (!(result4 instanceof Result.Error)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                        }
                                    }
                                }
                                return error;
                            }
                        }
                    } else {
                        i5 = 0;
                        i6 = 0;
                        dataPolicy5 = dataPolicy2;
                        result2 = error;
                        domainError2 = domainError;
                        localItemEntity2 = null;
                        c14591.L$0 = itemId2;
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                        c14591.I$0 = i6;
                        c14591.I$1 = i5;
                        c14591.label = 5;
                        objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                        if (objItem != coroutine_suspended) {
                            itemId5 = itemId2;
                            result3 = (Result) objItem;
                            if (result3 instanceof Result.Success) {
                                error = result3;
                            } else {
                                if (result3 instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                            }
                            dataPolicy2 = dataPolicy5;
                            itemId2 = itemId5;
                            if (!(error instanceof Result.Success)) {
                                if (error instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                domainError3 = (DomainError) ((Result.Error) error).getValue();
                                if (domainError3 instanceof DomainError.NoResultFoundError) {
                                    c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                    c14591.L$3 = domainError3;
                                    c14591.L$4 = null;
                                    c14591.I$0 = 0;
                                    c14591.I$1 = 0;
                                    c14591.label = 6;
                                    objItem = fileFromLegacyCache(itemId2, c14591);
                                    if (objItem != coroutine_suspended) {
                                        domainError4 = domainError3;
                                        result4 = (Result) objItem;
                                        if (result4 instanceof Result.Success) {
                                            return result4;
                                        }
                                        if (!(result4 instanceof Result.Error)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                    }
                                }
                            }
                            return error;
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                int i17 = c14591.I$2;
                i3 = c14591.I$1;
                i4 = c14591.I$0;
                itemModel = (ItemModel) c14591.L$3;
                error = (Result) c14591.L$2;
                dataPolicy4 = (DataPolicy) c14591.L$1;
                itemId3 = (ItemId) c14591.L$0;
                ResultKt.throwOnFailure(objItem);
                int i18 = i4;
                i = i3;
                dataPolicy3 = dataPolicy4;
                result = error;
                itemModel2 = itemModel;
                localItemEntity = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                i2 = i18;
                c14591.L$0 = itemId3;
                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy3);
                c14591.L$2 = SpillingKt.nullOutSpilledVariable(result);
                c14591.L$3 = SpillingKt.nullOutSpilledVariable(itemModel2);
                c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity);
                c14591.I$0 = i2;
                c14591.I$1 = i;
                c14591.label = 3;
                objItem = mergeLocalRemoteItemModels(localItemEntity, itemModel2, true, c14591);
                if (objItem != coroutine_suspended) {
                    itemId4 = itemId3;
                    error2 = (Result) objItem;
                    if (!(error2 instanceof Result.Success)) {
                        if (error2 instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error2 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error2).getValue(), null, 2, null));
                    }
                    dataPolicy2 = dataPolicy3;
                    itemId2 = itemId4;
                    error = error2;
                    if (!(error instanceof Result.Success)) {
                        if (!(error instanceof Result.Success)) {
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            domainError3 = (DomainError) ((Result.Error) error).getValue();
                            if (domainError3 instanceof DomainError.NoResultFoundError) {
                                c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                c14591.L$3 = domainError3;
                                c14591.L$4 = null;
                                c14591.I$0 = 0;
                                c14591.I$1 = 0;
                                c14591.label = 6;
                                objItem = fileFromLegacyCache(itemId2, c14591);
                                if (objItem != coroutine_suspended) {
                                    domainError4 = domainError3;
                                    result4 = (Result) objItem;
                                    if (result4 instanceof Result.Success) {
                                        return result4;
                                    }
                                    if (!(result4 instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                }
                            }
                        }
                        return error;
                    }
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    domainError = (DomainError) ((Result.Error) error).getValue();
                    if (itemId2 instanceof ItemId.Local) {
                        local2 = (ItemId.Local) itemId2;
                    } else {
                        local2 = null;
                    }
                    if (local2 != null) {
                        c14591.L$0 = itemId2;
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                        c14591.I$0 = 0;
                        c14591.I$1 = 0;
                        c14591.I$2 = 0;
                        c14591.label = 4;
                        objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                        if (objItem != coroutine_suspended) {
                            i7 = 0;
                            i8 = 0;
                            int i19 = i8;
                            i5 = i7;
                            dataPolicy5 = dataPolicy2;
                            result2 = error;
                            domainError2 = domainError;
                            localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                            i6 = i19;
                            c14591.L$0 = itemId2;
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                            c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                            c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                            c14591.I$0 = i6;
                            c14591.I$1 = i5;
                            c14591.label = 5;
                            objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                            if (objItem != coroutine_suspended) {
                                itemId5 = itemId2;
                                result3 = (Result) objItem;
                                if (result3 instanceof Result.Success) {
                                    error = result3;
                                } else {
                                    if (result3 instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                                }
                                dataPolicy2 = dataPolicy5;
                                itemId2 = itemId5;
                                if (!(error instanceof Result.Success)) {
                                    if (error instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    domainError3 = (DomainError) ((Result.Error) error).getValue();
                                    if (domainError3 instanceof DomainError.NoResultFoundError) {
                                        c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                        c14591.L$3 = domainError3;
                                        c14591.L$4 = null;
                                        c14591.I$0 = 0;
                                        c14591.I$1 = 0;
                                        c14591.label = 6;
                                        objItem = fileFromLegacyCache(itemId2, c14591);
                                        if (objItem != coroutine_suspended) {
                                            domainError4 = domainError3;
                                            result4 = (Result) objItem;
                                            if (result4 instanceof Result.Success) {
                                                return result4;
                                            }
                                            if (!(result4 instanceof Result.Error)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                        }
                                    }
                                }
                                return error;
                            }
                        }
                    } else {
                        i5 = 0;
                        i6 = 0;
                        dataPolicy5 = dataPolicy2;
                        result2 = error;
                        domainError2 = domainError;
                        localItemEntity2 = null;
                        c14591.L$0 = itemId2;
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                        c14591.I$0 = i6;
                        c14591.I$1 = i5;
                        c14591.label = 5;
                        objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                        if (objItem != coroutine_suspended) {
                            itemId5 = itemId2;
                            result3 = (Result) objItem;
                            if (result3 instanceof Result.Success) {
                                error = result3;
                            } else {
                                if (result3 instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                            }
                            dataPolicy2 = dataPolicy5;
                            itemId2 = itemId5;
                            if (!(error instanceof Result.Success)) {
                                if (error instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                domainError3 = (DomainError) ((Result.Error) error).getValue();
                                if (domainError3 instanceof DomainError.NoResultFoundError) {
                                    c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                    c14591.L$3 = domainError3;
                                    c14591.L$4 = null;
                                    c14591.I$0 = 0;
                                    c14591.I$1 = 0;
                                    c14591.label = 6;
                                    objItem = fileFromLegacyCache(itemId2, c14591);
                                    if (objItem != coroutine_suspended) {
                                        domainError4 = domainError3;
                                        result4 = (Result) objItem;
                                        if (result4 instanceof Result.Success) {
                                            return result4;
                                        }
                                        if (!(result4 instanceof Result.Error)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                    }
                                }
                            }
                            return error;
                        }
                    }
                }
                return coroutine_suspended;
            case 3:
                int i20 = c14591.I$1;
                int i21 = c14591.I$0;
                dataPolicy3 = (DataPolicy) c14591.L$1;
                itemId4 = (ItemId) c14591.L$0;
                ResultKt.throwOnFailure(objItem);
                error2 = (Result) objItem;
                if (!(error2 instanceof Result.Success)) {
                    if (error2 instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error2 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error2).getValue(), null, 2, null));
                }
                dataPolicy2 = dataPolicy3;
                itemId2 = itemId4;
                error = error2;
                if (!(error instanceof Result.Success)) {
                    if (!(error instanceof Result.Success)) {
                        if (error instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        domainError3 = (DomainError) ((Result.Error) error).getValue();
                        if (domainError3 instanceof DomainError.NoResultFoundError) {
                            c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                            c14591.L$3 = domainError3;
                            c14591.L$4 = null;
                            c14591.I$0 = 0;
                            c14591.I$1 = 0;
                            c14591.label = 6;
                            objItem = fileFromLegacyCache(itemId2, c14591);
                            if (objItem != coroutine_suspended) {
                                domainError4 = domainError3;
                                result4 = (Result) objItem;
                                if (result4 instanceof Result.Success) {
                                    return result4;
                                }
                                if (!(result4 instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                return new Result.Error((DomainError.NoResultFoundError) domainError4);
                            }
                        }
                    }
                    return error;
                }
                if (error instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                domainError = (DomainError) ((Result.Error) error).getValue();
                if (itemId2 instanceof ItemId.Local) {
                    local2 = (ItemId.Local) itemId2;
                } else {
                    local2 = null;
                }
                if (local2 != null) {
                    c14591.L$0 = itemId2;
                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                    c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError);
                    c14591.L$4 = SpillingKt.nullOutSpilledVariable(local2);
                    c14591.I$0 = 0;
                    c14591.I$1 = 0;
                    c14591.I$2 = 0;
                    c14591.label = 4;
                    objItem = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId2, c14591);
                    if (objItem != coroutine_suspended) {
                        i7 = 0;
                        i8 = 0;
                        int i110 = i8;
                        i5 = i7;
                        dataPolicy5 = dataPolicy2;
                        result2 = error;
                        domainError2 = domainError;
                        localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                        i6 = i110;
                        c14591.L$0 = itemId2;
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                        c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                        c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                        c14591.I$0 = i6;
                        c14591.I$1 = i5;
                        c14591.label = 5;
                        objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                        if (objItem != coroutine_suspended) {
                            itemId5 = itemId2;
                            result3 = (Result) objItem;
                            if (result3 instanceof Result.Success) {
                                error = result3;
                            } else {
                                if (result3 instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                            }
                            dataPolicy2 = dataPolicy5;
                            itemId2 = itemId5;
                            if (!(error instanceof Result.Success)) {
                                if (error instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                domainError3 = (DomainError) ((Result.Error) error).getValue();
                                if (domainError3 instanceof DomainError.NoResultFoundError) {
                                    c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                    c14591.L$3 = domainError3;
                                    c14591.L$4 = null;
                                    c14591.I$0 = 0;
                                    c14591.I$1 = 0;
                                    c14591.label = 6;
                                    objItem = fileFromLegacyCache(itemId2, c14591);
                                    if (objItem != coroutine_suspended) {
                                        domainError4 = domainError3;
                                        result4 = (Result) objItem;
                                        if (result4 instanceof Result.Success) {
                                            return result4;
                                        }
                                        if (!(result4 instanceof Result.Error)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                    }
                                }
                            }
                            return error;
                        }
                    }
                } else {
                    i5 = 0;
                    i6 = 0;
                    dataPolicy5 = dataPolicy2;
                    result2 = error;
                    domainError2 = domainError;
                    localItemEntity2 = null;
                    c14591.L$0 = itemId2;
                    c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                    c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                    c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                    c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                    c14591.I$0 = i6;
                    c14591.I$1 = i5;
                    c14591.label = 5;
                    objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                    if (objItem != coroutine_suspended) {
                        itemId5 = itemId2;
                        result3 = (Result) objItem;
                        if (result3 instanceof Result.Success) {
                            error = result3;
                        } else {
                            if (result3 instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                        }
                        dataPolicy2 = dataPolicy5;
                        itemId2 = itemId5;
                        if (!(error instanceof Result.Success)) {
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            domainError3 = (DomainError) ((Result.Error) error).getValue();
                            if (domainError3 instanceof DomainError.NoResultFoundError) {
                                c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                                c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                                c14591.L$3 = domainError3;
                                c14591.L$4 = null;
                                c14591.I$0 = 0;
                                c14591.I$1 = 0;
                                c14591.label = 6;
                                objItem = fileFromLegacyCache(itemId2, c14591);
                                if (objItem != coroutine_suspended) {
                                    domainError4 = domainError3;
                                    result4 = (Result) objItem;
                                    if (result4 instanceof Result.Success) {
                                        return result4;
                                    }
                                    if (!(result4 instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return new Result.Error((DomainError.NoResultFoundError) domainError4);
                                }
                            }
                        }
                        return error;
                    }
                }
                return coroutine_suspended;
            case 4:
                int i22 = c14591.I$2;
                i7 = c14591.I$1;
                i8 = c14591.I$0;
                domainError = (DomainError) c14591.L$3;
                error = (Result) c14591.L$2;
                dataPolicy2 = (DataPolicy) c14591.L$1;
                itemId2 = (ItemId) c14591.L$0;
                ResultKt.throwOnFailure(objItem);
                int i111 = i8;
                i5 = i7;
                dataPolicy5 = dataPolicy2;
                result2 = error;
                domainError2 = domainError;
                localItemEntity2 = (LocalItemEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
                i6 = i111;
                c14591.L$0 = itemId2;
                c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy5);
                c14591.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                c14591.L$3 = SpillingKt.nullOutSpilledVariable(domainError2);
                c14591.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity2);
                c14591.I$0 = i6;
                c14591.I$1 = i5;
                c14591.label = 5;
                objItem = mergeLocalRemoteItemModels(localItemEntity2, null, true, c14591);
                if (objItem != coroutine_suspended) {
                    itemId5 = itemId2;
                    result3 = (Result) objItem;
                    if (result3 instanceof Result.Success) {
                        error = result3;
                    } else {
                        if (result3 instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                    }
                    dataPolicy2 = dataPolicy5;
                    itemId2 = itemId5;
                    if (!(error instanceof Result.Success)) {
                        if (error instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        domainError3 = (DomainError) ((Result.Error) error).getValue();
                        if (domainError3 instanceof DomainError.NoResultFoundError) {
                            c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                            c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                            c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                            c14591.L$3 = domainError3;
                            c14591.L$4 = null;
                            c14591.I$0 = 0;
                            c14591.I$1 = 0;
                            c14591.label = 6;
                            objItem = fileFromLegacyCache(itemId2, c14591);
                            if (objItem != coroutine_suspended) {
                                domainError4 = domainError3;
                                result4 = (Result) objItem;
                                if (result4 instanceof Result.Success) {
                                    return result4;
                                }
                                if (!(result4 instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                return new Result.Error((DomainError.NoResultFoundError) domainError4);
                            }
                        }
                    }
                    return error;
                }
                return coroutine_suspended;
            case 5:
                int i23 = c14591.I$1;
                int i24 = c14591.I$0;
                dataPolicy5 = (DataPolicy) c14591.L$1;
                itemId5 = (ItemId) c14591.L$0;
                ResultKt.throwOnFailure(objItem);
                result3 = (Result) objItem;
                if (result3 instanceof Result.Success) {
                    error = result3;
                } else {
                    if (result3 instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result3).getValue(), null, 2, null));
                }
                dataPolicy2 = dataPolicy5;
                itemId2 = itemId5;
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    domainError3 = (DomainError) ((Result.Error) error).getValue();
                    if (domainError3 instanceof DomainError.NoResultFoundError) {
                        c14591.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                        c14591.L$1 = SpillingKt.nullOutSpilledVariable(dataPolicy2);
                        c14591.L$2 = SpillingKt.nullOutSpilledVariable(error);
                        c14591.L$3 = domainError3;
                        c14591.L$4 = null;
                        c14591.I$0 = 0;
                        c14591.I$1 = 0;
                        c14591.label = 6;
                        objItem = fileFromLegacyCache(itemId2, c14591);
                        if (objItem != coroutine_suspended) {
                            domainError4 = domainError3;
                            result4 = (Result) objItem;
                            if (result4 instanceof Result.Success) {
                                return result4;
                            }
                            if (!(result4 instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return new Result.Error((DomainError.NoResultFoundError) domainError4);
                        }
                        return coroutine_suspended;
                    }
                }
                return error;
            case 6:
                int i25 = c14591.I$1;
                int i26 = c14591.I$0;
                domainError4 = (DomainError) c14591.L$3;
                ResultKt.throwOnFailure(objItem);
                result4 = (Result) objItem;
                if (result4 instanceof Result.Success) {
                    return result4;
                }
                if (!(result4 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error((DomainError.NoResultFoundError) domainError4);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$fileFromLegacyCache$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService$fileFromLegacyCache$2", f = "LocalItemService.kt", i = {}, l = {Token.SETCONST}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C14532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId $itemId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14532(ItemId itemId, Continuation<? super C14532> continuation) {
            super(2, continuation);
            this.$itemId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalItemService.this.new C14532(this.$itemId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
            return ((C14532) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LocalItemService.this.idMappingService.getRemoteIdOrError(this.$itemId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            LocalItemService localItemService = LocalItemService.this;
            if (result instanceof Result.Success) {
                ItemId.Remote remote = (ItemId.Remote) ((Result.Success) result).getValue();
                IBaseModelController iBaseModelController = localItemService.baseModelController;
                BoxRequestsFile.GetFileInfo infoRequest = localItemService.fileApi.getInfoRequest(remote.getBoxId());
                Intrinsics.checkNotNullExpressionValue(infoRequest, "getInfoRequest(...)");
                BoxResponse boxResponse = iBaseModelController.performLocal(infoRequest).get();
                BoxFile boxFile = (BoxFile) boxResponse.getResult();
                ItemModel itemModel = boxFile != null ? ItemModelMapper.INSTANCE.toItemModel(boxFile) : null;
                if (boxResponse.isSuccess() && itemModel != null) {
                    return new Result.Success(itemModel);
                }
                DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                Exception exception = boxResponse.getException();
                Intrinsics.checkNotNullExpressionValue(exception, "getException(...)");
                return new Result.Error(domainErrorMapper.toDomainError(exception, "Couldn't fetch file info from legacy cache"));
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fileFromLegacyCache(ItemId itemId, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new C14532(itemId, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$observeItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService$observeItem$1", f = "LocalItemService.kt", i = {0}, l = {174}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
    static final class C14621 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends ItemModel, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        final /* synthetic */ ItemId $itemId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14621(ItemId itemId, DataPolicy dataPolicy, Continuation<? super C14621> continuation) {
            super(2, continuation);
            this.$itemId = itemId;
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14621 c14621 = LocalItemService.this.new C14621(this.$itemId, this.$dataPolicy, continuation);
            c14621.L$0 = obj;
            return c14621;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends ItemModel, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C14621) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.label = 1;
                if (FlowKt.distinctUntilChangedBy(LocalItemService.this.idMappingService.observeRemoteId(this.$itemId), new Function1() { // from class: com.box.android.data.service.impl.LocalItemService$observeItem$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return LocalItemService.C14621.invokeSuspend$lambda$0((ItemId.Remote) obj2);
                    }
                }).collect(new AnonymousClass2(this.$itemId, flowCollector, LocalItemService.this, this.$dataPolicy), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$observeItem$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: LocalItemService.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class AnonymousClass2<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<Result<? extends ItemModel, ? extends DomainError>> $$this$flow;
            final /* synthetic */ DataPolicy $dataPolicy;
            final /* synthetic */ ItemId $itemId;
            final /* synthetic */ LocalItemService this$0;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(ItemId itemId, FlowCollector<? super Result<? extends ItemModel, ? extends DomainError>> flowCollector, LocalItemService localItemService, DataPolicy dataPolicy) {
                this.$itemId = itemId;
                this.$$this$flow = flowCollector;
                this.this$0 = localItemService;
                this.$dataPolicy = dataPolicy;
            }

            /* JADX WARN: Code duplicated, block: B:38:0x010c  */
            /* JADX WARN: Code duplicated, block: B:41:0x013a  */
            /* JADX WARN: Code duplicated, block: B:45:0x0148  */
            /* JADX WARN: Code duplicated, block: B:47:0x014c  */
            /* JADX WARN: Code duplicated, block: B:52:0x018b  */
            /* JADX WARN: Code duplicated, block: B:54:0x0191  */
            /* JADX WARN: Code duplicated, block: B:63:0x01bb  */
            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x00c9, code lost:
            
                if (kotlinx.coroutines.flow.FlowKt.emitAll(r15, r13, r0) == r1) goto L50;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x0186, code lost:
            
                if (r2.emit(r15, r0) == r1) goto L50;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.box.android.domain.models.ItemId.Remote r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.io.UnsupportedEncodingException {
                /*
                    Method dump skipped, instruction units count: 452
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.C14621.AnonymousClass2.emit(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((ItemId.Remote) obj, (Continuation<? super Unit>) continuation);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(ItemId.Remote remote) {
            if (remote != null) {
                return remote.getBoxId();
            }
            return null;
        }
    }

    @Override // com.box.android.domain.services.IItemService
    public Flow<Result<ItemModel, DomainError>> observeItem(ItemId itemId, DataPolicy dataPolicy) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(dataPolicy, "dataPolicy");
        return FlowKt.flow(new C14621(itemId, dataPolicy, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object setServerId(ItemId itemId, ItemId itemId2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14661 c14661;
        if (continuation instanceof C14661) {
            c14661 = (C14661) continuation;
            if ((c14661.label & Integer.MIN_VALUE) != 0) {
                c14661.label -= Integer.MIN_VALUE;
            } else {
                c14661 = new C14661(continuation);
            }
        } else {
            c14661 = new C14661(continuation);
        }
        Object objInsertOrUpdateLocalIdToServerIdRelation = c14661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14661.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInsertOrUpdateLocalIdToServerIdRelation);
            ItemId.Local local = itemId instanceof ItemId.Local ? (ItemId.Local) itemId : null;
            if (local == null) {
                return new Result.Error(new DomainError.CacheWriteError("Server id cannot be set for item with remote id " + itemId));
            }
            ItemId.Remote remote = itemId2 instanceof ItemId.Remote ? (ItemId.Remote) itemId2 : null;
            if (remote == null) {
                return new Result.Error(new DomainError.CacheWriteError("Server id cannot be set for item with local id " + itemId2));
            }
            LocalItemsDataSource localItemsDataSource = this.localItemsDataSource;
            LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity = new LocalIdToServerIdRelationEntity(local, remote.getType(), remote.getBoxId());
            c14661.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c14661.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
            c14661.L$2 = SpillingKt.nullOutSpilledVariable(local);
            c14661.L$3 = SpillingKt.nullOutSpilledVariable(remote);
            c14661.label = 1;
            objInsertOrUpdateLocalIdToServerIdRelation = localItemsDataSource.insertOrUpdateLocalIdToServerIdRelation(localIdToServerIdRelationEntity, c14661);
            if (objInsertOrUpdateLocalIdToServerIdRelation == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objInsertOrUpdateLocalIdToServerIdRelation);
        }
        Result result = (Result) objInsertOrUpdateLocalIdToServerIdRelation;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError.SaveError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object getContentUrl(ItemId itemId, Continuation<? super Result<String, ? extends DomainError>> continuation) throws UnsupportedEncodingException {
        C14541 c14541;
        if (continuation instanceof C14541) {
            c14541 = (C14541) continuation;
            if ((c14541.label & Integer.MIN_VALUE) != 0) {
                c14541.label -= Integer.MIN_VALUE;
            } else {
                c14541 = new C14541(continuation);
            }
        } else {
            c14541 = new C14541(continuation);
        }
        Object localItemById = c14541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14541.label;
        if (i == 0) {
            ResultKt.throwOnFailure(localItemById);
            ItemId.Local local = itemId instanceof ItemId.Local ? (ItemId.Local) itemId : null;
            if (local != null) {
                c14541.L$0 = itemId;
                c14541.L$1 = SpillingKt.nullOutSpilledVariable(local);
                c14541.I$0 = 0;
                c14541.label = 1;
                localItemById = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId, c14541);
                if (localItemById == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return new Result.Error(new DomainError.CacheReadError("Content url cannot be read for item with id " + itemId + " as this is not a local id."));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c14541.I$0;
        itemId = (ItemId) c14541.L$0;
        ResultKt.throwOnFailure(localItemById);
        Result.Error error = (Result) localItemById;
        if (error instanceof Result.Success) {
            error = new Result.Success(((LocalItemEntity) ((Result.Success) error).getValue()).getContentUrl());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            String str = (String) ((Result.Success) error).getValue();
            error = new Result.Success(str != null ? URLDecoder.decode(str, "UTF-8") : null);
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error).getValue(), null, 2, null));
        }
        if (error != null) {
            return error;
        }
        return new Result.Error(new DomainError.CacheReadError("Content url cannot be read for item with id " + itemId + " as this is not a local id."));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object cleanup(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objDeleteLocalItem = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteLocalItem);
            ItemId.Local local = itemId instanceof ItemId.Local ? (ItemId.Local) itemId : null;
            if (local == null) {
                return new Result.Success(Unit.INSTANCE);
            }
            LocalItemsDataSource localItemsDataSource = this.localItemsDataSource;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(local);
            anonymousClass1.label = 1;
            objDeleteLocalItem = localItemsDataSource.deleteLocalItem(local, anonymousClass1);
            if (objDeleteLocalItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objDeleteLocalItem);
        }
        Result result = (Result) objDeleteLocalItem;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError.DeleteError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x017f  */
    /* JADX WARN: Code duplicated, block: B:26:0x018a  */
    /* JADX WARN: Code duplicated, block: B:29:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:32:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:35:0x0276  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x038a -> B:55:0x0398). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x03b5 -> B:56:0x03a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x03d2 -> B:64:0x03f7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.services.ILocalItemService
    public java.lang.Object enqueueDownloadJobForItems(java.util.List<? extends com.box.android.domain.models.item.ItemModel> r32, java.lang.String r33, com.box.android.domain.usecases.jobs.JobTags.JobSource r34, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r35) {
        /*
            Method dump skipped, instruction units count: 1086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.enqueueDownloadJobForItems(java.util.List, java.lang.String, com.box.android.domain.usecases.jobs.JobTags$JobSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$enqueueMarkOfflineJobForItems$2, reason: invalid class name */
    /* JADX INFO: compiled from: LocalItemService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService$enqueueMarkOfflineJobForItems$2", f = "LocalItemService.kt", i = {0, 0}, l = {286}, m = "invokeSuspend", n = {"$this$withContext", "jobs"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ boolean $downloadOriginal;
        final /* synthetic */ List<ItemModel> $items;
        final /* synthetic */ JobTags.JobSource $jobSource;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LocalItemService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(List<? extends ItemModel> list, LocalItemService localItemService, JobTags.JobSource jobSource, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$items = list;
            this.this$0 = localItemService;
            this.$jobSource = jobSource;
            this.$downloadOriginal = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$items, this.this$0, this.$jobSource, this.$downloadOriginal, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objAwaitAll;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<ItemModel> list = this.$items;
                LocalItemService localItemService = this.this$0;
                JobTags.JobSource jobSource = this.$jobSource;
                boolean z = this.$downloadOriginal;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1(localItemService, (ItemModel) it.next(), jobSource, z, null), 3, null));
                }
                ArrayList arrayList2 = arrayList;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList2);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll(arrayList2, this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objAwaitAll = obj;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : (List) objAwaitAll) {
                if (obj2 instanceof Result.Error) {
                    arrayList3.add(obj2);
                }
            }
            Result.Error error = (Result.Error) CollectionsKt.firstOrNull((List) arrayList3);
            return error != null ? error : new Result.Success(Unit.INSTANCE);
        }
    }

    @Override // com.box.android.domain.services.ILocalItemService
    public Object enqueueMarkOfflineJobForItems(List<? extends ItemModel> list, boolean z, JobTags.JobSource jobSource, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new AnonymousClass2(list, this, jobSource, z, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0116  */
    /* JADX WARN: Code duplicated, block: B:35:0x014d A[LOOP:0: B:33:0x0147->B:35:0x014d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x0190  */
    /* JADX WARN: Code duplicated, block: B:41:0x0197  */
    /* JADX WARN: Code duplicated, block: B:45:0x019f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0203  */
    /* JADX WARN: Code duplicated, block: B:60:0x020d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x020e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0212  */
    /* JADX WARN: Code duplicated, block: B:65:0x0228  */
    /* JADX WARN: Code duplicated, block: B:67:0x022e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0234  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01d6, code lost:
    
        if (r2 == r4) goto L47;
     */
    @Override // com.box.android.domain.services.ILocalItemService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createFolder(java.lang.String r23, com.box.android.domain.models.ItemId r24, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FolderModel, ? extends com.box.android.domain.models.DomainError>> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.createFolder(java.lang.String, com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:35:0x013b A[LOOP:0: B:33:0x0135->B:35:0x013b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x0186  */
    /* JADX WARN: Code duplicated, block: B:42:0x018d  */
    /* JADX WARN: Code duplicated, block: B:44:0x019d  */
    /* JADX WARN: Code duplicated, block: B:46:0x01a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:49:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:51:0x01ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object uploadFolder(String str, ItemId itemId, Uri uri, Set<String> set, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) throws Throwable {
        C14681 c14681;
        String str2;
        Uri uri2;
        Set<String> set2;
        ItemId itemId2;
        Result result;
        String str3;
        Uri uri3;
        Set<String> set3;
        Result result2;
        FolderModel folderModel;
        ArrayList arrayList;
        Iterator it;
        FolderModel folderModel2;
        Result result3;
        ItemId itemId3 = itemId;
        if (continuation instanceof C14681) {
            c14681 = (C14681) continuation;
            if ((c14681.label & Integer.MIN_VALUE) != 0) {
                c14681.label -= Integer.MIN_VALUE;
            } else {
                c14681 = new C14681(continuation);
            }
        } else {
            c14681 = new C14681(continuation);
        }
        Object jobInfos = c14681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14681.label;
        if (i == 0) {
            ResultKt.throwOnFailure(jobInfos);
            JobService jobService = this.jobService;
            List<String> listListOf = CollectionsKt.listOf("create_folder:" + itemId3);
            str2 = str;
            c14681.L$0 = str2;
            c14681.L$1 = itemId3;
            uri2 = uri;
            c14681.L$2 = uri2;
            set2 = set;
            c14681.L$3 = set2;
            c14681.label = 1;
            jobInfos = jobService.getJobInfos(listListOf, c14681);
            if (jobInfos != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            Set<String> set4 = (Set) c14681.L$3;
            Uri uri4 = (Uri) c14681.L$2;
            ItemId itemId4 = (ItemId) c14681.L$1;
            str2 = (String) c14681.L$0;
            ResultKt.throwOnFailure(jobInfos);
            set2 = set4;
            uri2 = uri4;
            itemId3 = itemId4;
        } else {
            if (i == 2) {
                result = (Result) c14681.L$4;
                Set<String> set5 = (Set) c14681.L$3;
                Uri uri5 = (Uri) c14681.L$2;
                ItemId itemId5 = (ItemId) c14681.L$1;
                String str4 = (String) c14681.L$0;
                ResultKt.throwOnFailure(jobInfos);
                itemId2 = itemId5;
                str3 = str4;
                set3 = set5;
                uri3 = uri5;
                result2 = (Result) jobInfos;
                if (result2 instanceof Result.Success) {
                    if (result2 instanceof Result.Error) {
                        return result2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                folderModel = (FolderModel) ((Result.Success) result2).getValue();
                JobService jobService2 = this.jobService;
                JobRequest request$default = UploadFolderJob.Companion.getRequest$default(UploadFolderJob.INSTANCE, folderModel.getItemId(), set3, false, false, 12, null);
                Iterable iterable = (Iterable) ((Result.Success) result).getValue();
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((JobInfo) it.next()).getId());
                }
                Set<JobId> set6 = CollectionsKt.toSet(arrayList);
                c14681.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                c14681.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                c14681.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                c14681.L$3 = SpillingKt.nullOutSpilledVariable(set3);
                c14681.L$4 = SpillingKt.nullOutSpilledVariable(result);
                c14681.L$5 = SpillingKt.nullOutSpilledVariable(result2);
                c14681.L$6 = folderModel;
                c14681.I$0 = 0;
                c14681.I$1 = 0;
                c14681.label = 3;
                jobInfos = jobService2.enqueue(request$default, set6, c14681);
                if (jobInfos != coroutine_suspended) {
                    folderModel2 = folderModel;
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14681.I$1;
            int i3 = c14681.I$0;
            folderModel2 = (FolderModel) c14681.L$6;
            ResultKt.throwOnFailure(jobInfos);
        }
        result3 = (Result) jobInfos;
        if (result3 instanceof Result.Success) {
            return new Result.Success(folderModel2);
        }
        if (result3 instanceof Result.Error) {
            return result3;
        }
        throw new NoWhenBranchMatchedException();
        Result result4 = (Result) jobInfos;
        if (result4 instanceof Result.Error) {
            return result4;
        }
        if (!(result4 instanceof Result.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        c14681.L$0 = SpillingKt.nullOutSpilledVariable(str2);
        c14681.L$1 = SpillingKt.nullOutSpilledVariable(itemId3);
        c14681.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
        c14681.L$3 = set2;
        c14681.L$4 = result4;
        c14681.label = 2;
        Object objCreateLocalFolder = createLocalFolder(str2, itemId3, uri2, c14681);
        if (objCreateLocalFolder != coroutine_suspended) {
            itemId2 = itemId3;
            result = result4;
            jobInfos = objCreateLocalFolder;
            str3 = str2;
            uri3 = uri2;
            set3 = set2;
            result2 = (Result) jobInfos;
            if (result2 instanceof Result.Success) {
                if (result2 instanceof Result.Error) {
                    return result2;
                }
                throw new NoWhenBranchMatchedException();
            }
            folderModel = (FolderModel) ((Result.Success) result2).getValue();
            JobService jobService3 = this.jobService;
            JobRequest request$default2 = UploadFolderJob.Companion.getRequest$default(UploadFolderJob.INSTANCE, folderModel.getItemId(), set3, false, false, 12, null);
            Iterable iterable2 = (Iterable) ((Result.Success) result).getValue();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            it = iterable2.iterator();
            while (it.hasNext()) {
                arrayList.add(((JobInfo) it.next()).getId());
            }
            Set<JobId> set7 = CollectionsKt.toSet(arrayList);
            c14681.L$0 = SpillingKt.nullOutSpilledVariable(str3);
            c14681.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
            c14681.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
            c14681.L$3 = SpillingKt.nullOutSpilledVariable(set3);
            c14681.L$4 = SpillingKt.nullOutSpilledVariable(result);
            c14681.L$5 = SpillingKt.nullOutSpilledVariable(result2);
            c14681.L$6 = folderModel;
            c14681.I$0 = 0;
            c14681.I$1 = 0;
            c14681.label = 3;
            jobInfos = jobService3.enqueue(request$default2, set7, c14681);
            if (jobInfos != coroutine_suspended) {
                folderModel2 = folderModel;
                result3 = (Result) jobInfos;
                if (result3 instanceof Result.Success) {
                    return new Result.Success(folderModel2);
                }
                if (result3 instanceof Result.Error) {
                    return result3;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return coroutine_suspended;
    }

    public final Uri getDocumentUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual("com.android.externalstorage.documents", uri.getAuthority())) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0118  */
    /* JADX WARN: Code duplicated, block: B:36:0x015c A[LOOP:0: B:34:0x0156->B:36:0x015c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x01af  */
    /* JADX WARN: Code duplicated, block: B:43:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:45:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:47:0x01ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:50:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:52:0x01d5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object uploadFile(String str, ItemId itemId, Uri uri, Set<String> set, boolean z, ItemId itemId2, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) throws Throwable {
        C14671 c14671;
        String str2;
        ItemId itemId3;
        boolean z2;
        ItemId itemId4;
        Uri uri2;
        Set<String> set2;
        Result result;
        String str3;
        ItemId itemId5;
        Uri uri3;
        boolean z3;
        Result result2;
        FileModel fileModel;
        ArrayList arrayList;
        Iterator it;
        FileModel fileModel2;
        Result result3;
        if (continuation instanceof C14671) {
            c14671 = (C14671) continuation;
            if ((c14671.label & Integer.MIN_VALUE) != 0) {
                c14671.label -= Integer.MIN_VALUE;
            } else {
                c14671 = new C14671(continuation);
            }
        } else {
            c14671 = new C14671(continuation);
        }
        Object jobInfos = c14671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(jobInfos);
            JobService jobService = this.jobService;
            List<String> listListOf = CollectionsKt.listOf("create_folder:" + itemId);
            str2 = str;
            c14671.L$0 = str2;
            c14671.L$1 = itemId;
            c14671.L$2 = uri;
            c14671.L$3 = set;
            itemId3 = itemId2;
            c14671.L$4 = itemId3;
            z2 = z;
            c14671.Z$0 = z2;
            c14671.label = 1;
            jobInfos = jobService.getJobInfos(listListOf, c14671);
            if (jobInfos != coroutine_suspended) {
                itemId4 = itemId;
                uri2 = uri;
                set2 = set;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            boolean z4 = c14671.Z$0;
            ItemId itemId6 = (ItemId) c14671.L$4;
            set2 = (Set) c14671.L$3;
            Uri uri4 = (Uri) c14671.L$2;
            itemId4 = (ItemId) c14671.L$1;
            String str4 = (String) c14671.L$0;
            ResultKt.throwOnFailure(jobInfos);
            z2 = z4;
            itemId3 = itemId6;
            uri2 = uri4;
            str2 = str4;
        } else {
            if (i == 2) {
                z3 = c14671.Z$0;
                result = (Result) c14671.L$5;
                itemId5 = (ItemId) c14671.L$4;
                set2 = (Set) c14671.L$3;
                uri3 = (Uri) c14671.L$2;
                itemId4 = (ItemId) c14671.L$1;
                str3 = (String) c14671.L$0;
                ResultKt.throwOnFailure(jobInfos);
                result2 = (Result) jobInfos;
                if (result2 instanceof Result.Success) {
                    if (result2 instanceof Result.Error) {
                        return result2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                fileModel = (FileModel) ((Result.Success) result2).getValue();
                JobService jobService2 = this.jobService;
                boolean z5 = z3;
                JobRequest request = UploadFileJobV2.INSTANCE.getRequest(fileModel.getItemId(), itemId5, set2, true, z5);
                Iterable iterable = (Iterable) ((Result.Success) result).getValue();
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((JobInfo) it.next()).getId());
                }
                Set<JobId> set3 = CollectionsKt.toSet(arrayList);
                c14671.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                c14671.L$1 = SpillingKt.nullOutSpilledVariable(itemId4);
                c14671.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                c14671.L$3 = SpillingKt.nullOutSpilledVariable(set2);
                c14671.L$4 = SpillingKt.nullOutSpilledVariable(itemId5);
                c14671.L$5 = SpillingKt.nullOutSpilledVariable(result);
                c14671.L$6 = SpillingKt.nullOutSpilledVariable(result2);
                c14671.L$7 = fileModel;
                c14671.Z$0 = z5;
                c14671.I$0 = 0;
                c14671.I$1 = 0;
                c14671.label = 3;
                jobInfos = jobService2.enqueue(request, set3, c14671);
                if (jobInfos != coroutine_suspended) {
                    fileModel2 = fileModel;
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14671.I$1;
            int i3 = c14671.I$0;
            boolean z6 = c14671.Z$0;
            fileModel2 = (FileModel) c14671.L$7;
            ResultKt.throwOnFailure(jobInfos);
        }
        result3 = (Result) jobInfos;
        if (result3 instanceof Result.Success) {
            return new Result.Success(fileModel2);
        }
        if (result3 instanceof Result.Error) {
            return result3;
        }
        throw new NoWhenBranchMatchedException();
        result = (Result) jobInfos;
        if (result instanceof Result.Error) {
            return result;
        }
        if (!(result instanceof Result.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        c14671.L$0 = SpillingKt.nullOutSpilledVariable(str2);
        c14671.L$1 = SpillingKt.nullOutSpilledVariable(itemId4);
        c14671.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
        c14671.L$3 = set2;
        c14671.L$4 = itemId3;
        c14671.L$5 = result;
        c14671.Z$0 = z2;
        c14671.label = 2;
        jobInfos = createLocalFile(str2, itemId4, uri2, c14671);
        if (jobInfos != coroutine_suspended) {
            str3 = str2;
            itemId5 = itemId3;
            uri3 = uri2;
            z3 = z2;
            result2 = (Result) jobInfos;
            if (result2 instanceof Result.Success) {
                if (result2 instanceof Result.Error) {
                    return result2;
                }
                throw new NoWhenBranchMatchedException();
            }
            fileModel = (FileModel) ((Result.Success) result2).getValue();
            JobService jobService3 = this.jobService;
            boolean z7 = z3;
            JobRequest request2 = UploadFileJobV2.INSTANCE.getRequest(fileModel.getItemId(), itemId5, set2, true, z7);
            Iterable iterable2 = (Iterable) ((Result.Success) result).getValue();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            it = iterable2.iterator();
            while (it.hasNext()) {
                arrayList.add(((JobInfo) it.next()).getId());
            }
            Set<JobId> set4 = CollectionsKt.toSet(arrayList);
            c14671.L$0 = SpillingKt.nullOutSpilledVariable(str3);
            c14671.L$1 = SpillingKt.nullOutSpilledVariable(itemId4);
            c14671.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
            c14671.L$3 = SpillingKt.nullOutSpilledVariable(set2);
            c14671.L$4 = SpillingKt.nullOutSpilledVariable(itemId5);
            c14671.L$5 = SpillingKt.nullOutSpilledVariable(result);
            c14671.L$6 = SpillingKt.nullOutSpilledVariable(result2);
            c14671.L$7 = fileModel;
            c14671.Z$0 = z7;
            c14671.I$0 = 0;
            c14671.I$1 = 0;
            c14671.label = 3;
            jobInfos = jobService3.enqueue(request2, set4, c14671);
            if (jobInfos != coroutine_suspended) {
                fileModel2 = fileModel;
                result3 = (Result) jobInfos;
                if (result3 instanceof Result.Success) {
                    return new Result.Success(fileModel2);
                }
                if (result3 instanceof Result.Error) {
                    return result3;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object initiateAutoUpload(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14581 c14581;
        ILocalAutoContentUploadInformation iLocalAutoContentUploadInformation;
        String uploadFolderId;
        String uploadFolder;
        ItemId.Remote remote;
        if (continuation instanceof C14581) {
            c14581 = (C14581) continuation;
            if ((c14581.label & Integer.MIN_VALUE) != 0) {
                c14581.label -= Integer.MIN_VALUE;
            } else {
                c14581 = new C14581(continuation);
            }
        } else {
            c14581 = new C14581(continuation);
        }
        C14581 c14582 = c14581;
        Object obj = c14582.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14582.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IUserContextComponent userContextComponent = this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
            Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.localrepo.ILocalAutoContentUploadInformation");
            iLocalAutoContentUploadInformation = (ILocalAutoContentUploadInformation) userContextComponent;
            uploadFolderId = iLocalAutoContentUploadInformation.getUploadFolderId();
            if (uploadFolderId == null) {
                throw new IllegalStateException("Failed to get the Upload folder id".toString());
            }
            ItemId.Remote remote2 = new ItemId.Remote(uploadFolderId, ItemType.FOLDER);
            uploadFolder = iLocalAutoContentUploadInformation.getUploadFolder();
            if (uploadFolder == null) {
                throw new IllegalStateException("Failed to get source folder path".toString());
            }
            JobService jobService = this.jobService;
            c14582.L$0 = SpillingKt.nullOutSpilledVariable(iLocalAutoContentUploadInformation);
            c14582.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderId);
            c14582.L$2 = remote2;
            c14582.L$3 = uploadFolder;
            c14582.label = 1;
            if (jobService.cancelEnqueuedAutoUploadJobs(c14582) != coroutine_suspended) {
                remote = remote2;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        uploadFolder = (String) c14582.L$3;
        remote = (ItemId.Remote) c14582.L$2;
        uploadFolderId = (String) c14582.L$1;
        iLocalAutoContentUploadInformation = (ILocalAutoContentUploadInformation) c14582.L$0;
        ResultKt.throwOnFailure(obj);
        String str = uploadFolder;
        JobService jobService2 = this.jobService;
        JobRequest request$default = AutoUploadJob.Companion.getRequest$default(AutoUploadJob.INSTANCE, remote, str, null, 4, null);
        c14582.L$0 = SpillingKt.nullOutSpilledVariable(iLocalAutoContentUploadInformation);
        c14582.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderId);
        c14582.L$2 = SpillingKt.nullOutSpilledVariable(remote);
        c14582.L$3 = SpillingKt.nullOutSpilledVariable(str);
        c14582.label = 2;
        Object objEnqueue$default = IJobService.enqueue$default(jobService2, request$default, null, c14582, 2, null);
        return objEnqueue$default == coroutine_suspended ? coroutine_suspended : objEnqueue$default;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0104  */
    /* JADX WARN: Code duplicated, block: B:31:0x011d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0127 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0128  */
    /* JADX WARN: Code duplicated, block: B:38:0x012c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0141  */
    /* JADX WARN: Code duplicated, block: B:42:0x0147  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f5, code lost:
    
        if (r1 == r3) goto L24;
     */
    @Override // com.box.android.domain.services.ILocalItemService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createLocalFile(java.lang.String r21, com.box.android.domain.models.ItemId r22, android.net.Uri r23, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FileModel, ? extends com.box.android.domain.models.DomainError>> r24) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.createLocalFile(java.lang.String, com.box.android.domain.models.ItemId, android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:31:0x0117  */
    /* JADX WARN: Code duplicated, block: B:35:0x0121 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0122  */
    /* JADX WARN: Code duplicated, block: B:38:0x0126  */
    /* JADX WARN: Code duplicated, block: B:40:0x013b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0141  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f1, code lost:
    
        if (r1 == r3) goto L24;
     */
    @Override // com.box.android.domain.services.ILocalItemService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createLocalFolder(java.lang.String r21, com.box.android.domain.models.ItemId r22, android.net.Uri r23, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FolderModel, ? extends com.box.android.domain.models.DomainError>> r24) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.createLocalFolder(java.lang.String, com.box.android.domain.models.ItemId, android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getLocalFileSha1(Uri contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        String path = contentUrl.getPath();
        if (path != null) {
            return FileExtensionsKt.computeFileSha1(new File(path));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createLocalItemModel(LocalItemEntity localItemEntity, Continuation<? super Result<? extends ItemModel, ? extends CacheError>> continuation) throws UnsupportedEncodingException {
        C14501 c14501;
        PermissionsModel permissionsModel;
        LocalItemEntity localItemEntity2;
        FolderModel folderModel;
        PermissionsModel permissionsModel2;
        FolderModel folderModelCreateLocalFolderModel;
        String str;
        File fileFetchFile;
        if (continuation instanceof C14501) {
            c14501 = (C14501) continuation;
            if ((c14501.label & Integer.MIN_VALUE) != 0) {
                c14501.label -= Integer.MIN_VALUE;
            } else {
                c14501 = new C14501(continuation);
            }
        } else {
            c14501 = new C14501(continuation);
        }
        Object obj = c14501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14501.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PermissionsModel permissionsModelCreatePermissionModel = this.itemsCreator.createPermissionModel();
            c14501.L$0 = localItemEntity;
            c14501.L$1 = permissionsModelCreatePermissionModel;
            c14501.label = 1;
            Object parentFolderModel = getParentFolderModel(localItemEntity, c14501);
            if (parentFolderModel != coroutine_suspended) {
                permissionsModel = permissionsModelCreatePermissionModel;
                obj = parentFolderModel;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            PermissionsModel permissionsModel3 = (PermissionsModel) c14501.L$1;
            LocalItemEntity localItemEntity3 = (LocalItemEntity) c14501.L$0;
            ResultKt.throwOnFailure(obj);
            permissionsModel = permissionsModel3;
            localItemEntity = localItemEntity3;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            folderModel = (FolderModel) c14501.L$2;
            permissionsModel2 = (PermissionsModel) c14501.L$1;
            localItemEntity2 = (LocalItemEntity) c14501.L$0;
            ResultKt.throwOnFailure(obj);
        }
        str = (String) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
        if (str != null || (fileFetchFile = fetchFile(str)) == null) {
            return new Result.Error(CacheError.NoResultFound.INSTANCE);
        }
        folderModelCreateLocalFolderModel = this.itemsCreator.createLocalFileModel(localItemEntity2, folderModel, fileFetchFile, permissionsModel2);
        return new Result.Success(folderModelCreateLocalFolderModel);
        FolderModel folderModel$default = (FolderModel) obj;
        if (folderModel$default == null) {
            ItemId parentId = localItemEntity.getParentId();
            if (parentId != null) {
                FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
                BoxFolder boxFolderCreateFromId = BoxFolder.createFromId(parentId.toString());
                Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromId, "createFromId(...)");
                folderModel$default = FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromId, false, 1, null);
            } else {
                folderModel$default = null;
            }
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[localItemEntity.getItemId().getType().ordinal()];
        if (i2 == 1) {
            ItemId itemId = localItemEntity.getItemId();
            c14501.L$0 = localItemEntity;
            c14501.L$1 = permissionsModel;
            c14501.L$2 = folderModel$default;
            c14501.label = 2;
            Object contentUrl = getContentUrl(itemId, c14501);
            if (contentUrl != coroutine_suspended) {
                localItemEntity2 = localItemEntity;
                folderModel = folderModel$default;
                obj = contentUrl;
                permissionsModel2 = permissionsModel;
                str = (String) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                if (str != null) {
                }
                return new Result.Error(CacheError.NoResultFound.INSTANCE);
            }
            return coroutine_suspended;
        }
        if (i2 == 2) {
            folderModelCreateLocalFolderModel = this.itemsCreator.createLocalFolderModel(localItemEntity, folderModel$default, permissionsModel);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            folderModelCreateLocalFolderModel = this.itemsCreator.createLocalWebLinkModel(localItemEntity, folderModel$default, permissionsModel);
        }
        return new Result.Success(folderModelCreateLocalFolderModel);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:45:0x0102  */
    /* JADX WARN: Code duplicated, block: B:48:0x0145  */
    /* JADX WARN: Code duplicated, block: B:51:0x0150  */
    /* JADX WARN: Code duplicated, block: B:53:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0156  */
    /* JADX WARN: Code duplicated, block: B:56:0x0167  */
    /* JADX WARN: Code duplicated, block: B:59:0x0173  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x01af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:79:0x022b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:80:0x022d  */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0251, code lost:
    
        if (r4 == r6) goto L82;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mergeLocalRemoteItemModels(com.box.android.data.persistence.localItems.LocalItemEntity r45, com.box.android.domain.models.item.ItemModel r46, boolean r47, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.data.datasource.CacheError>> r48) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.mergeLocalRemoteItemModels(com.box.android.data.persistence.localItems.LocalItemEntity, com.box.android.domain.models.item.ItemModel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0067  */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getParentFolderModel(LocalItemEntity localItemEntity, Continuation<? super FolderModel> continuation) throws UnsupportedEncodingException {
        C14571 c14571;
        Object obj;
        if (continuation instanceof C14571) {
            c14571 = (C14571) continuation;
            if ((c14571.label & Integer.MIN_VALUE) != 0) {
                c14571.label -= Integer.MIN_VALUE;
            } else {
                c14571 = new C14571(continuation);
            }
        } else {
            c14571 = new C14571(continuation);
        }
        Object itemByLocalId = c14571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemByLocalId);
            ItemId parentId = localItemEntity.getParentId();
            if (parentId != null) {
                c14571.L$0 = SpillingKt.nullOutSpilledVariable(localItemEntity);
                c14571.L$1 = SpillingKt.nullOutSpilledVariable(parentId);
                c14571.I$0 = 0;
                c14571.label = 1;
                itemByLocalId = getItemByLocalId(parentId, false, c14571);
                if (itemByLocalId == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                obj = null;
            }
            if (obj instanceof FolderModel) {
                return (FolderModel) obj;
            }
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c14571.I$0;
        ResultKt.throwOnFailure(itemByLocalId);
        Result result = (Result) itemByLocalId;
        if (result != null) {
            obj = com.box.android.domain.utils.result.ResultKt.get(result);
        } else {
            obj = null;
        }
        if (obj instanceof FolderModel) {
            return (FolderModel) obj;
        }
        return null;
    }

    public final File fetchFile(String contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        return new File(contentUrl);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:36:0x0103  */
    /* JADX WARN: Code duplicated, block: B:37:0x0117  */
    /* JADX WARN: Code duplicated, block: B:45:0x0127  */
    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0144 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0145  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object setParentFolderId(ItemId itemId, ItemId itemId2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14651 c14651;
        ItemId itemId3;
        ItemId.Local local;
        ItemId itemId4;
        Object obj;
        int i;
        Result.Error error;
        Result.Error error2;
        DomainErrorMapper domainErrorMapper;
        ItemId itemId5 = itemId;
        if (continuation instanceof C14651) {
            c14651 = (C14651) continuation;
            if ((c14651.label & Integer.MIN_VALUE) != 0) {
                c14651.label -= Integer.MIN_VALUE;
            } else {
                c14651 = new C14651(continuation);
            }
        } else {
            c14651 = new C14651(continuation);
        }
        Object objInsertOrUpdateLocalItem = c14651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14651.label;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = c14651.I$0;
                ItemId.Local local2 = (ItemId.Local) c14651.L$2;
                ItemId itemId6 = (ItemId) c14651.L$1;
                ItemId itemId7 = (ItemId) c14651.L$0;
                ResultKt.throwOnFailure(objInsertOrUpdateLocalItem);
                itemId4 = itemId6;
                local = local2;
                obj = objInsertOrUpdateLocalItem;
                i = i3;
                itemId5 = itemId7;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = c14651.I$2;
                int i5 = c14651.I$1;
                int i6 = c14651.I$0;
                itemId3 = (ItemId) c14651.L$0;
                ResultKt.throwOnFailure(objInsertOrUpdateLocalItem);
            }
            error2 = (Result) objInsertOrUpdateLocalItem;
            domainErrorMapper = DomainErrorMapper.INSTANCE;
            if (!(error2 instanceof Result.Success)) {
                if (error2 instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                error2 = new Result.Error(DomainErrorMapper.toDomainError$default(domainErrorMapper, (IGenericError) ((Result.Error) error2).getValue(), null, 2, null));
            }
            error = error2;
            if (!(error instanceof Result.Success)) {
                if (error instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) error).getValue(), null, 2, null));
            }
            if (error != null) {
                return error;
            }
            return new Result.Error(new DomainError.CacheWriteError("Parent folder id cannot be set for item with id " + itemId3 + " as this is not a local id."));
        }
        ResultKt.throwOnFailure(objInsertOrUpdateLocalItem);
        ItemId.Local local3 = itemId5 instanceof ItemId.Local ? (ItemId.Local) itemId5 : null;
        if (local3 != null) {
            c14651.L$0 = itemId5;
            c14651.L$1 = itemId2;
            c14651.L$2 = SpillingKt.nullOutSpilledVariable(local3);
            c14651.I$0 = 0;
            c14651.label = 1;
            Object localItemById = this.localItemsDataSource.getLocalItemById((ItemId.Local) itemId5, c14651);
            if (localItemById != coroutine_suspended) {
                local = local3;
                itemId4 = itemId2;
                obj = localItemById;
                i = 0;
            }
            return coroutine_suspended;
        }
        itemId3 = itemId5;
        return new Result.Error(new DomainError.CacheWriteError("Parent folder id cannot be set for item with id " + itemId3 + " as this is not a local id."));
        error = (Result) obj;
        if (error instanceof Result.Success) {
            LocalItemEntity localItemEntity = (LocalItemEntity) ((Result.Success) error).getValue();
            LocalItemEntity localItemEntityCopy$default = LocalItemEntity.copy$default(localItemEntity, null, null, null, null, itemId4, null, null, null, 239, null);
            LocalItemsDataSource localItemsDataSource = this.localItemsDataSource;
            c14651.L$0 = itemId5;
            c14651.L$1 = SpillingKt.nullOutSpilledVariable(itemId4);
            c14651.L$2 = SpillingKt.nullOutSpilledVariable(local);
            c14651.L$3 = SpillingKt.nullOutSpilledVariable(error);
            c14651.L$4 = SpillingKt.nullOutSpilledVariable(localItemEntity);
            c14651.L$5 = SpillingKt.nullOutSpilledVariable(localItemEntityCopy$default);
            c14651.I$0 = i;
            c14651.I$1 = 0;
            c14651.I$2 = 0;
            c14651.label = 2;
            objInsertOrUpdateLocalItem = localItemsDataSource.insertOrUpdateLocalItem(localItemEntityCopy$default, c14651);
            if (objInsertOrUpdateLocalItem != coroutine_suspended) {
                itemId3 = itemId5;
                error2 = (Result) objInsertOrUpdateLocalItem;
                domainErrorMapper = DomainErrorMapper.INSTANCE;
                if (!(error2 instanceof Result.Success)) {
                    if (error2 instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error2 = new Result.Error(DomainErrorMapper.toDomainError$default(domainErrorMapper, (IGenericError) ((Result.Error) error2).getValue(), null, 2, null));
                }
                error = error2;
            }
            return coroutine_suspended;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        itemId3 = itemId5;
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) error).getValue(), null, 2, null));
        }
        if (error != null) {
            return error;
        }
        return new Result.Error(new DomainError.CacheWriteError("Parent folder id cannot be set for item with id " + itemId3 + " as this is not a local id."));
    }

    @Override // com.box.android.domain.services.ILocalItemService
    public Object deleteFile(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return IJobService.enqueue$default(this.jobService, DeleteFileJob.Companion.getRequest$default(DeleteFileJob.INSTANCE, itemId, null, 2, null), null, continuation, 2, null);
    }

    @Override // com.box.android.domain.services.ILocalItemService
    public Object deleteCollaboration(ItemId itemId, String str, Continuation<? super Unit> continuation) {
        Object objEnqueue$default = IJobService.enqueue$default(this.jobService, DeleteCollaborationJob.Companion.getRequest$default(DeleteCollaborationJob.INSTANCE, itemId, str, null, 4, null), null, continuation, 2, null);
        return objEnqueue$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEnqueue$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object moveItem(ItemId itemId, ItemId itemId2, Set<String> set, Continuation<? super Result<Unit, ? extends DomainError>> continuation) throws Throwable {
        C14611 c14611;
        if (continuation instanceof C14611) {
            c14611 = (C14611) continuation;
            if ((c14611.label & Integer.MIN_VALUE) != 0) {
                c14611.label -= Integer.MIN_VALUE;
            } else {
                c14611 = new C14611(continuation);
            }
        } else {
            c14611 = new C14611(continuation);
        }
        Object jobInfos = c14611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(jobInfos);
            JobService jobService = this.jobService;
            List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"create_folder:" + itemId2, "upload_file_v2:" + itemId});
            c14611.L$0 = itemId;
            c14611.L$1 = itemId2;
            c14611.L$2 = set;
            c14611.label = 1;
            jobInfos = jobService.getJobInfos(listListOf, c14611);
            if (jobInfos != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(jobInfos);
            return jobInfos;
        }
        set = (Set) c14611.L$2;
        itemId2 = (ItemId) c14611.L$1;
        itemId = (ItemId) c14611.L$0;
        ResultKt.throwOnFailure(jobInfos);
        Result result = (Result) jobInfos;
        if (result instanceof Result.Error) {
            return result;
        }
        if (!(result instanceof Result.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        JobService jobService2 = this.jobService;
        JobRequest request = MoveItemJob.INSTANCE.getRequest(itemId, itemId2, set);
        Iterable iterable = (Iterable) ((Result.Success) result).getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((JobInfo) it.next()).getId());
        }
        Set<JobId> set2 = CollectionsKt.toSet(arrayList);
        c14611.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
        c14611.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
        c14611.L$2 = SpillingKt.nullOutSpilledVariable(set);
        c14611.L$3 = SpillingKt.nullOutSpilledVariable(result);
        c14611.label = 2;
        Object objEnqueue = jobService2.enqueue(request, set2, c14611);
        return objEnqueue == coroutine_suspended ? coroutine_suspended : objEnqueue;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ILocalItemService
    public Object copyItem(ItemId itemId, ItemId itemId2, Set<String> set, Continuation<? super Result<Unit, ? extends DomainError>> continuation) throws Throwable {
        C14461 c14461;
        if (continuation instanceof C14461) {
            c14461 = (C14461) continuation;
            if ((c14461.label & Integer.MIN_VALUE) != 0) {
                c14461.label -= Integer.MIN_VALUE;
            } else {
                c14461 = new C14461(continuation);
            }
        } else {
            c14461 = new C14461(continuation);
        }
        Object jobInfos = c14461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(jobInfos);
            JobService jobService = this.jobService;
            List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"create_folder:" + itemId2, "upload_file_v2:" + itemId});
            c14461.L$0 = itemId;
            c14461.L$1 = itemId2;
            c14461.L$2 = set;
            c14461.label = 1;
            jobInfos = jobService.getJobInfos(listListOf, c14461);
            if (jobInfos != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(jobInfos);
            return jobInfos;
        }
        set = (Set) c14461.L$2;
        itemId2 = (ItemId) c14461.L$1;
        itemId = (ItemId) c14461.L$0;
        ResultKt.throwOnFailure(jobInfos);
        Result result = (Result) jobInfos;
        if (result instanceof Result.Error) {
            return result;
        }
        if (!(result instanceof Result.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        JobService jobService2 = this.jobService;
        JobRequest request = CopyItemJob.INSTANCE.getRequest(itemId, itemId2, set);
        Iterable iterable = (Iterable) ((Result.Success) result).getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((JobInfo) it.next()).getId());
        }
        Set<JobId> set2 = CollectionsKt.toSet(arrayList);
        c14461.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
        c14461.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
        c14461.L$2 = SpillingKt.nullOutSpilledVariable(set);
        c14461.L$3 = SpillingKt.nullOutSpilledVariable(result);
        c14461.label = 2;
        Object objEnqueue = jobService2.enqueue(request, set2, c14461);
        return objEnqueue == coroutine_suspended ? coroutine_suspended : objEnqueue;
    }

    @Override // com.box.android.domain.services.IItemService
    public Flow<Result<List<ItemModel>, DomainError>> items(final ItemId parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        final Flow<Result<List<ItemModel>, DomainError>> flowItems = this.remoteItemService.items(parent);
        return (Flow) new Flow<Result<? extends List<? extends ItemModel>, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.LocalItemService$items$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = flowItems.collect(new AnonymousClass2(flowCollector, this, parent), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$items$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ ItemId $parent$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ LocalItemService this$0;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.LocalItemService$items$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService$items$$inlined$map$1$2", f = "LocalItemService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {52, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-LocalItemService$items$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
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

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, LocalItemService localItemService, ItemId itemId) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = localItemService;
                    this.$parent$inlined = itemId;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x00f0, code lost:
                
                    if (r13.emit(r2, r0) == r1) goto L28;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r12, kotlin.coroutines.Continuation r13) throws java.io.UnsupportedEncodingException {
                    /*
                        Method dump skipped, instruction units count: 252
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService$items$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007a  */
    /* JADX WARN: Code duplicated, block: B:19:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:24:0x00be  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b0 -> B:21:0x00b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object separateServerAndLocalOnlyItems(java.util.List<com.box.android.data.persistence.localItems.LocalItemEntity> r18, kotlin.coroutines.Continuation<? super kotlin.Pair<? extends java.util.Map<com.box.android.domain.models.ItemId.Remote, com.box.android.data.persistence.localItems.LocalItemEntity>, ? extends java.util.List<com.box.android.data.persistence.localItems.LocalItemEntity>>> r19) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.separateServerAndLocalOnlyItems(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x018c  */
    /* JADX WARN: Code duplicated, block: B:40:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x020e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0217  */
    /* JADX WARN: Code duplicated, block: B:46:0x021b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0240  */
    /* JADX WARN: Code duplicated, block: B:50:0x0259  */
    /* JADX WARN: Code duplicated, block: B:52:0x025f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01f1 -> B:41:0x0206). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fetchAndJoinLocalItems(com.box.android.domain.models.ItemId r20, java.util.List<? extends com.box.android.domain.models.item.ItemModel> r21, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends java.util.List<? extends com.box.android.domain.models.item.ItemModel>, ? extends com.box.android.domain.models.DomainError>> r22) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.fetchAndJoinLocalItems(com.box.android.domain.models.ItemId, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.domain.services.IItemService
    public Object fetchFolderItemsFromRemote(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.remoteItemService.fetchFolderItemsFromRemote(itemId, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0068  */
    /* JADX WARN: Code duplicated, block: B:18:0x007a  */
    /* JADX WARN: Code duplicated, block: B:20:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x009b  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f9 A[PHI: r0 r2 r5 r12 r13 r14
      0x00f9: PHI (r0v6 java.util.Map<com.box.android.domain.models.ItemId$Remote, com.box.android.data.persistence.localItems.LocalItemEntity>) = 
      (r0v4 java.util.Map<com.box.android.domain.models.ItemId$Remote, com.box.android.data.persistence.localItems.LocalItemEntity>)
      (r0v8 java.util.Map<com.box.android.domain.models.ItemId$Remote, com.box.android.data.persistence.localItems.LocalItemEntity>)
     binds: [B:17:0x0078, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r2v7 com.box.android.data.service.impl.LocalItemService$replaceWithServerMappedLocalItems$1) = 
      (r2v5 com.box.android.data.service.impl.LocalItemService$replaceWithServerMappedLocalItems$1)
      (r2v10 com.box.android.data.service.impl.LocalItemService$replaceWithServerMappedLocalItems$1)
     binds: [B:17:0x0078, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r5v4 java.util.List) = (r5v3 java.util.List), (r5v5 java.util.List) binds: [B:17:0x0078, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r12v3 int) = (r12v2 int), (r12v4 int) binds: [B:17:0x0078, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r13v4 java.util.List<? extends com.box.android.domain.models.item.ItemModel>) = 
      (r13v2 java.util.List<? extends com.box.android.domain.models.item.ItemModel>)
      (r13v6 java.util.List<? extends com.box.android.domain.models.item.ItemModel>)
     binds: [B:17:0x0078, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r14v8 int) = (r14v6 int), (r14v12 int) binds: [B:17:0x0078, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0078 -> B:36:0x00f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009b -> B:22:0x00a3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object replaceWithServerMappedLocalItems(java.util.List<? extends com.box.android.domain.models.item.ItemModel> r12, java.util.Map<com.box.android.domain.models.ItemId.Remote, com.box.android.data.persistence.localItems.LocalItemEntity> r13, kotlin.coroutines.Continuation<? super java.util.List<? extends com.box.android.domain.models.item.ItemModel>> r14) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService.replaceWithServerMappedLocalItems(java.util.List, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
