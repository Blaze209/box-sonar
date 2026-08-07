package com.box.android.data.api.utils;

import com.box.android.data.api.models.adapters.ActionStyleLevelAdapter;
import com.box.android.data.api.models.adapters.CollaborationRoleAdapter;
import com.box.android.data.api.models.adapters.CollaborationStatusAdapter;
import com.box.android.data.api.models.adapters.CollectionItemTypeAdapter;
import com.box.android.data.api.models.adapters.CollectionTypeAdapter;
import com.box.android.data.api.models.adapters.FileMetadataListDTOAdapter;
import com.box.android.data.api.models.adapters.ItemStatusAdapter;
import com.box.android.data.api.models.adapters.ItemTypeAdapter;
import com.box.android.data.api.models.adapters.MembershipOperationsAdapter;
import com.box.android.data.api.models.adapters.MetricsCategoryAdapter;
import com.box.android.data.api.models.adapters.MetricsEventTypeAdapter;
import com.box.android.data.api.models.adapters.RepresentationStateAdapter;
import com.box.android.data.api.models.adapters.RepresentationTypeAdapter;
import com.box.android.data.api.models.adapters.ScopeAdapter;
import com.box.android.data.api.models.adapters.ShapeTypeAdapter;
import com.box.android.data.api.models.adapters.SharedLinkAccessAdapter;
import com.box.android.data.api.models.adapters.SkipUnknownElementsListAdapter;
import com.box.android.data.api.models.adapters.StatusAdapter;
import com.box.android.data.api.models.adapters.TargetTypeAdapter;
import com.box.android.data.api.models.annotations.ActivityType;
import com.box.android.data.api.models.annotations.FileActivityDTO;
import com.box.android.data.api.models.annotations.TargetDTO;
import com.box.android.data.api.models.annotations.TargetType;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.api.models.items.mini.FileMiniDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.data.api.models.items.mini.IItemMiniDTO;
import com.box.android.data.api.models.items.mini.WebLinkMiniDTO;
import com.box.android.data.api.models.observability.ActionsMetricsDTO;
import com.box.android.data.api.models.observability.ApdexMetricsDTO;
import com.box.android.data.api.models.observability.DiagnosticsMetricsDTO;
import com.box.android.data.api.models.observability.MetricsDTO;
import com.box.android.data.api.models.upload.UploadFileRunningData;
import com.box.android.data.api.models.upload.UploadJobStates;
import com.box.android.data.datasource.gql.GetCollectionByIDDTOAdapter;
import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: MoshiProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/api/utils/MoshiProvider;", "", "<init>", "()V", "buildMoshi", "Lcom/squareup/moshi/Moshi;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MoshiProvider {
    public final Moshi buildMoshi() {
        Moshi moshiBuild = new Moshi.Builder().add(Date.class, new Rfc3339DateJsonAdapter()).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(ItemId.class, "className").withSubtype(ItemId.Local.class, Reflection.getOrCreateKotlinClass(ItemId.Local.class).getQualifiedName()).withSubtype(ItemId.Remote.class, Reflection.getOrCreateKotlinClass(ItemId.Remote.class).getQualifiedName())).add(new ScopeAdapter()).add(new CollectionTypeAdapter()).add(new CollectionItemTypeAdapter()).add(new SharedLinkAccessAdapter()).add(new CollaborationStatusAdapter()).add(new CollaborationRoleAdapter()).add(new ItemStatusAdapter()).add(new ItemTypeAdapter()).add(new MembershipOperationsAdapter()).add(new ShapeTypeAdapter()).add(new StatusAdapter()).add(new TargetTypeAdapter()).add(new RepresentationTypeAdapter()).add(new RepresentationStateAdapter()).add(new GetCollectionByIDDTOAdapter()).add(new FileMetadataListDTOAdapter()).add((JsonAdapter.Factory) SkipUnknownElementsListAdapter.Factory.INSTANCE).add(new ActionStyleLevelAdapter()).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(IItemMiniDTO.class, "type").withSubtype(FileMiniDTO.class, ItemType.FILE.toString()).withSubtype(FolderMiniDTO.class, ItemType.FOLDER.toString()).withSubtype(WebLinkMiniDTO.class, ItemType.WEBLINK.toString())).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(IItemDTO.class, "type").withSubtype(FileDTO.class, ItemType.FILE.toString()).withSubtype(FolderDTO.class, ItemType.FOLDER.toString()).withSubtype(WebLinkDTO.class, ItemType.WEBLINK.toString())).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(TargetDTO.class, "type").withSubtype(TargetDTO.Region.class, TargetType.REGION.toString()).withSubtype(TargetDTO.Highlight.class, TargetType.HIGHLIGHT.toString()).withSubtype(TargetDTO.Drawing.class, TargetType.DRAWING.toString())).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(FileActivityDTO.class, "activity_type").withSubtype(FileActivityDTO.AnnotationActivityDTO.class, ActivityType.ANNOTATION.toString()).withSubtype(FileActivityDTO.EnhancedAnnotationActivityDTO.class, ActivityType.ENHANCED_ANNOTATION.toString()).withSubtype(FileActivityDTO.CommentActivityDTO.class, ActivityType.COMMENT.toString()).withSubtype(FileActivityDTO.EnhancedCommentActivityDTO.class, ActivityType.ENHANCED_COMMENT.toString()).withSubtype(FileActivityDTO.VersionsActivityDTO.class, ActivityType.VERSIONS.toString())).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(MetricsDTO.class, "category").withSubtype(ActionsMetricsDTO.class, MetricsCategory.ACTIONS.getValue()).withSubtype(DiagnosticsMetricsDTO.class, MetricsCategory.DIAGNOSTICS.getValue()).withSubtype(ApdexMetricsDTO.class, MetricsCategory.APDEX.getValue())).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(UploadFileRunningData.class, "type").withSubtype(UploadFileRunningData.InitialData.class, UploadJobStates.INITIAL_STATE.getValue()).withSubtype(UploadFileRunningData.UploadWholeFileData.class, UploadJobStates.UPLOAD_WHOLE_FILE_STATE.getValue()).withSubtype(UploadFileRunningData.PreflightCheckData.class, UploadJobStates.PREFLIGHT_CHECK_STATE.getValue()).withSubtype(UploadFileRunningData.SessionCreationData.class, UploadJobStates.UPLOAD_SESSION_CREATION_STATE.getValue()).withSubtype(UploadFileRunningData.ChunkUploadingData.class, UploadJobStates.UPLOAD_CHUNK_STATE.getValue()).withSubtype(UploadFileRunningData.CommitSessionData.class, UploadJobStates.UPLOAD_COMMIT_SESSION_STATE.getValue())).add(new MetricsCategoryAdapter()).add(new MetricsEventTypeAdapter()).add((JsonAdapter.Factory) InboxNotificationPayloadAdapter.Factory.INSTANCE).addLast((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        Intrinsics.checkNotNullExpressionValue(moshiBuild, "build(...)");
        return moshiBuild;
    }
}
