package com.box.android.data.api.models.items;

import androidx.media3.common.C;
import com.box.android.data.api.models.ClassificationDTO;
import com.box.android.data.api.models.FileLockDTO;
import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.fileversions.FileVersionMiniDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollaborationRole;
import com.box.android.domain.models.SharedLinkModel;
import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.android.domain.models.item.ItemStatus;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b_\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¹\u0003\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0010\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018\u0012\u0010\b\u0003\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0010\b\u0003\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0018\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0010\b\u0003\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0018\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\"\u0012\n\b\u0003\u0010'\u001a\u0004\u0018\u00010 \u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010 \u0012\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0003\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0003\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0003\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0003\u00105\u001a\u0004\u0018\u000106¢\u0006\u0004\b7\u00108J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0012\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018HÆ\u0003J\u0012\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018HÆ\u0003J\u0012\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0018HÆ\u0003J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010[J\u0012\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0018HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010XJ\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u000106HÆ\u0003JÂ\u0003\u0010\u0092\u0001\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00182\u0010\b\u0003\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0010\b\u0003\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00182\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\"2\u0010\b\u0003\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00182\n\b\u0003\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\"2\n\b\u0003\u0010'\u001a\u0004\u0018\u00010 2\n\b\u0003\u0010(\u001a\u0004\u0018\u00010 2\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0003\u0010/\u001a\u0004\u0018\u0001002\n\b\u0003\u00101\u001a\u0004\u0018\u0001022\n\b\u0003\u00103\u001a\u0004\u0018\u0001042\n\b\u0003\u00105\u001a\u0004\u0018\u000106HÆ\u0001¢\u0006\u0003\u0010\u0093\u0001J\u0016\u0010\u0094\u0001\u001a\u00020\"2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001HÖ\u0003J\u000b\u0010\u0097\u0001\u001a\u00030\u0098\u0001HÖ\u0001J\n\u0010\u0099\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010:R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010:\"\u0004\bA\u0010<R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010:R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010:R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010:R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010:R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010:R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010NR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010SR\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010SR\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010SR\u0018\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bW\u0010XR\u0018\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u0004¢\u0006\n\n\u0002\u0010\\\u001a\u0004\bZ\u0010[R\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010SR\u0016\u0010%\u001a\u0004\u0018\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0018\u0010&\u001a\u0004\u0018\u00010\"X\u0096\u0004¢\u0006\n\n\u0002\u0010\\\u001a\u0004\b&\u0010[R\u0018\u0010'\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\n\n\u0002\u0010Y\u001a\u0004\b`\u0010XR\u0018\u0010(\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\n\n\u0002\u0010Y\u001a\u0004\ba\u0010XR\u0016\u0010)\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010:R\u0016\u0010*\u001a\u0004\u0018\u00010+X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0016\u0010,\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010:R\u0016\u0010-\u001a\u0004\u0018\u00010.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0016\u0010/\u001a\u0004\u0018\u000100X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u00101\u001a\u0004\u0018\u000102X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0016\u00103\u001a\u0004\u0018\u000104X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0016\u00105\u001a\u0004\u0018\u000106X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o¨\u0006\u009a\u0001"}, d2 = {"Lcom/box/android/data/api/models/items/FileDTO;", "Lcom/box/android/data/api/models/items/IFileDTO;", "id", "", "type", "name", BoxItem.FIELD_ETAG, "parent", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/api/models/SharedLinkDTO;", "createdAt", "modifiedAt", "contentCreatedAt", "contentModifiedAt", "description", "pathCollection", "Lcom/box/android/data/api/models/PathCollectionDTO;", "modifiedBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "ownedBy", "permissions", "Lcom/box/android/data/api/models/PermissionsDTO;", "sharedLinkPermissions", "", "Lcom/box/android/domain/models/SharedLinkPermissionOptionType;", "allowedSharedLinkAccessLevels", "Lcom/box/android/domain/models/SharedLinkModel$Access;", "tags", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/data/api/models/collections/CollectionDTO;", "size", "", "hasCollaborations", "", "allowedInviteeRoles", "Lcom/box/android/domain/models/CollaborationRole;", "defaultInviteeRole", "isExternallyOwned", "commentCount", "annotationCount", "sha1", "fileVersion", "Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "versionNumber", "itemStatus", "Lcom/box/android/domain/models/item/ItemStatus;", "fileLock", "Lcom/box/android/data/api/models/FileLockDTO;", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/data/api/models/RepresentationsDTO;", BoxItem.FIELD_CLASSIFICATION, "Lcom/box/android/data/api/models/ClassificationDTO;", "watermark", "Lcom/box/android/data/api/models/WatermarkDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;Lcom/box/android/data/api/models/SharedLinkDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/PathCollectionDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/PermissionsDTO;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Lcom/box/android/domain/models/CollaborationRole;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;Ljava/lang/String;Lcom/box/android/domain/models/item/ItemStatus;Lcom/box/android/data/api/models/FileLockDTO;Lcom/box/android/data/api/models/RepresentationsDTO;Lcom/box/android/data/api/models/ClassificationDTO;Lcom/box/android/data/api/models/WatermarkDTO;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getType", "getName", "setName", "getEtag", "setEtag", "getParent", "()Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "getSharedLink", "()Lcom/box/android/data/api/models/SharedLinkDTO;", "getCreatedAt", "getModifiedAt", "getContentCreatedAt", "getContentModifiedAt", "getDescription", "getPathCollection", "()Lcom/box/android/data/api/models/PathCollectionDTO;", "getModifiedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getOwnedBy", "getPermissions", "()Lcom/box/android/data/api/models/PermissionsDTO;", "getSharedLinkPermissions", "()Ljava/util/List;", "getAllowedSharedLinkAccessLevels", "getTags", "getCollections", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHasCollaborations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowedInviteeRoles", "getDefaultInviteeRole", "()Lcom/box/android/domain/models/CollaborationRole;", "getCommentCount", "getAnnotationCount", "getSha1", "getFileVersion", "()Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "getVersionNumber", "getItemStatus", "()Lcom/box/android/domain/models/item/ItemStatus;", "getFileLock", "()Lcom/box/android/data/api/models/FileLockDTO;", "getRepresentations", "()Lcom/box/android/data/api/models/RepresentationsDTO;", "getClassification", "()Lcom/box/android/data/api/models/ClassificationDTO;", "getWatermark", "()Lcom/box/android/data/api/models/WatermarkDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;Lcom/box/android/data/api/models/SharedLinkDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/PathCollectionDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/PermissionsDTO;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Lcom/box/android/domain/models/CollaborationRole;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;Ljava/lang/String;Lcom/box/android/domain/models/item/ItemStatus;Lcom/box/android/data/api/models/FileLockDTO;Lcom/box/android/data/api/models/RepresentationsDTO;Lcom/box/android/data/api/models/ClassificationDTO;Lcom/box/android/data/api/models/WatermarkDTO;)Lcom/box/android/data/api/models/items/FileDTO;", "equals", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileDTO implements IFileDTO {
    private final List<CollaborationRole> allowedInviteeRoles;
    private final List<SharedLinkModel.Access> allowedSharedLinkAccessLevels;
    private final Long annotationCount;
    private final ClassificationDTO classification;
    private final List<CollectionDTO> collections;
    private final Long commentCount;
    private final String contentCreatedAt;
    private final String contentModifiedAt;
    private final String createdAt;
    private final CollaborationRole defaultInviteeRole;
    private final String description;
    private String etag;
    private final FileLockDTO fileLock;
    private final FileVersionMiniDTO fileVersion;
    private final Boolean hasCollaborations;
    private String id;
    private final Boolean isExternallyOwned;
    private final ItemStatus itemStatus;
    private final String modifiedAt;
    private final UserMiniDTO modifiedBy;
    private String name;
    private final UserMiniDTO ownedBy;
    private final FolderMiniDTO parent;
    private final PathCollectionDTO pathCollection;
    private final PermissionsDTO permissions;
    private final RepresentationsDTO representations;
    private final String sha1;
    private final SharedLinkDTO sharedLink;
    private final List<SharedLinkPermissionOptionType> sharedLinkPermissions;
    private final Long size;
    private final List<String> tags;
    private final String type;
    private final String versionNumber;
    private final WatermarkDTO watermark;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileDTO copy$default(FileDTO fileDTO, String str, String str2, String str3, String str4, FolderMiniDTO folderMiniDTO, SharedLinkDTO sharedLinkDTO, String str5, String str6, String str7, String str8, String str9, PathCollectionDTO pathCollectionDTO, UserMiniDTO userMiniDTO, UserMiniDTO userMiniDTO2, PermissionsDTO permissionsDTO, List list, List list2, List list3, List list4, Long l, Boolean bool, List list5, CollaborationRole collaborationRole, Boolean bool2, Long l2, Long l3, String str10, FileVersionMiniDTO fileVersionMiniDTO, String str11, ItemStatus itemStatus, FileLockDTO fileLockDTO, RepresentationsDTO representationsDTO, ClassificationDTO classificationDTO, WatermarkDTO watermarkDTO, int i, int i2, Object obj) {
        WatermarkDTO watermarkDTO2;
        ClassificationDTO classificationDTO2;
        String str12 = (i & 1) != 0 ? fileDTO.id : str;
        String str13 = (i & 2) != 0 ? fileDTO.type : str2;
        String str14 = (i & 4) != 0 ? fileDTO.name : str3;
        String str15 = (i & 8) != 0 ? fileDTO.etag : str4;
        FolderMiniDTO folderMiniDTO2 = (i & 16) != 0 ? fileDTO.parent : folderMiniDTO;
        SharedLinkDTO sharedLinkDTO2 = (i & 32) != 0 ? fileDTO.sharedLink : sharedLinkDTO;
        String str16 = (i & 64) != 0 ? fileDTO.createdAt : str5;
        String str17 = (i & 128) != 0 ? fileDTO.modifiedAt : str6;
        String str18 = (i & 256) != 0 ? fileDTO.contentCreatedAt : str7;
        String str19 = (i & 512) != 0 ? fileDTO.contentModifiedAt : str8;
        String str20 = (i & 1024) != 0 ? fileDTO.description : str9;
        PathCollectionDTO pathCollectionDTO2 = (i & 2048) != 0 ? fileDTO.pathCollection : pathCollectionDTO;
        UserMiniDTO userMiniDTO3 = (i & 4096) != 0 ? fileDTO.modifiedBy : userMiniDTO;
        UserMiniDTO userMiniDTO4 = (i & 8192) != 0 ? fileDTO.ownedBy : userMiniDTO2;
        String str21 = str12;
        PermissionsDTO permissionsDTO2 = (i & 16384) != 0 ? fileDTO.permissions : permissionsDTO;
        List list6 = (i & 32768) != 0 ? fileDTO.sharedLinkPermissions : list;
        List list7 = (i & 65536) != 0 ? fileDTO.allowedSharedLinkAccessLevels : list2;
        List list8 = (i & 131072) != 0 ? fileDTO.tags : list3;
        List list9 = (i & 262144) != 0 ? fileDTO.collections : list4;
        Long l4 = (i & 524288) != 0 ? fileDTO.size : l;
        Boolean bool3 = (i & 1048576) != 0 ? fileDTO.hasCollaborations : bool;
        List list10 = (i & 2097152) != 0 ? fileDTO.allowedInviteeRoles : list5;
        CollaborationRole collaborationRole2 = (i & 4194304) != 0 ? fileDTO.defaultInviteeRole : collaborationRole;
        Boolean bool4 = (i & 8388608) != 0 ? fileDTO.isExternallyOwned : bool2;
        Long l5 = (i & 16777216) != 0 ? fileDTO.commentCount : l2;
        Long l6 = (i & 33554432) != 0 ? fileDTO.annotationCount : l3;
        String str22 = (i & 67108864) != 0 ? fileDTO.sha1 : str10;
        FileVersionMiniDTO fileVersionMiniDTO2 = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? fileDTO.fileVersion : fileVersionMiniDTO;
        String str23 = (i & 268435456) != 0 ? fileDTO.versionNumber : str11;
        ItemStatus itemStatus2 = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? fileDTO.itemStatus : itemStatus;
        FileLockDTO fileLockDTO2 = (i & 1073741824) != 0 ? fileDTO.fileLock : fileLockDTO;
        RepresentationsDTO representationsDTO2 = (i & Integer.MIN_VALUE) != 0 ? fileDTO.representations : representationsDTO;
        ClassificationDTO classificationDTO3 = (i2 & 1) != 0 ? fileDTO.classification : classificationDTO;
        if ((i2 & 2) != 0) {
            classificationDTO2 = classificationDTO3;
            watermarkDTO2 = fileDTO.watermark;
        } else {
            watermarkDTO2 = watermarkDTO;
            classificationDTO2 = classificationDTO3;
        }
        return fileDTO.copy(str21, str13, str14, str15, folderMiniDTO2, sharedLinkDTO2, str16, str17, str18, str19, str20, pathCollectionDTO2, userMiniDTO3, userMiniDTO4, permissionsDTO2, list6, list7, list8, list9, l4, bool3, list10, collaborationRole2, bool4, l5, l6, str22, fileVersionMiniDTO2, str23, itemStatus2, fileLockDTO2, representationsDTO2, classificationDTO2, watermarkDTO2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final PathCollectionDTO getPathCollection() {
        return this.pathCollection;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final UserMiniDTO getOwnedBy() {
        return this.ownedBy;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final PermissionsDTO getPermissions() {
        return this.permissions;
    }

    public final List<SharedLinkPermissionOptionType> component16() {
        return this.sharedLinkPermissions;
    }

    public final List<SharedLinkModel.Access> component17() {
        return this.allowedSharedLinkAccessLevels;
    }

    public final List<String> component18() {
        return this.tags;
    }

    public final List<CollectionDTO> component19() {
        return this.collections;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    public final List<CollaborationRole> component22() {
        return this.allowedInviteeRoles;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final CollaborationRole getDefaultInviteeRole() {
        return this.defaultInviteeRole;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Boolean getIsExternallyOwned() {
        return this.isExternallyOwned;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Long getCommentCount() {
        return this.commentCount;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Long getAnnotationCount() {
        return this.annotationCount;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final FileVersionMiniDTO getFileVersion() {
        return this.fileVersion;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getVersionNumber() {
        return this.versionNumber;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final ItemStatus getItemStatus() {
        return this.itemStatus;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final FileLockDTO getFileLock() {
        return this.fileLock;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final RepresentationsDTO getRepresentations() {
        return this.representations;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final ClassificationDTO getClassification() {
        return this.classification;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final WatermarkDTO getWatermark() {
        return this.watermark;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEtag() {
        return this.etag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FolderMiniDTO getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SharedLinkDTO getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    public final FileDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String name, @Json(name = BoxItem.FIELD_ETAG) String etag, @Json(name = "parent") FolderMiniDTO parent, @Json(name = "shared_link") SharedLinkDTO sharedLink, @Json(name = "created_at") String createdAt, @Json(name = "modified_at") String modifiedAt, @Json(name = "content_created_at") String contentCreatedAt, @Json(name = "content_modified_at") String contentModifiedAt, @Json(name = "description") String description, @Json(name = BoxItem.FIELD_PATH_COLLECTION) PathCollectionDTO pathCollection, @Json(name = "modified_by") UserMiniDTO modifiedBy, @Json(name = BoxItem.FIELD_OWNED_BY) UserMiniDTO ownedBy, @Json(name = "permissions") PermissionsDTO permissions, @Json(name = BoxFile.FIELD_SHARED_LINK_PERMISSION_OPTIONS) List<? extends SharedLinkPermissionOptionType> sharedLinkPermissions, @Json(name = BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS) List<? extends SharedLinkModel.Access> allowedSharedLinkAccessLevels, @Json(name = "tags") List<String> tags, @Json(name = BoxItem.FIELD_COLLECTIONS) List<CollectionDTO> collections, @Json(name = "size") Long size, @Json(name = BoxCollaborationItem.FIELD_HAS_COLLABORATIONS) Boolean hasCollaborations, @Json(name = BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES) List<? extends CollaborationRole> allowedInviteeRoles, @Json(name = BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE) CollaborationRole defaultInviteeRole, @Json(name = BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED) Boolean isExternallyOwned, @Json(name = "comment_count") Long commentCount, @Json(name = "annotation_count") Long annotationCount, @Json(name = "sha1") String sha1, @Json(name = "file_version") FileVersionMiniDTO fileVersion, @Json(name = BoxFile.FIELD_VERSION_NUMBER) String versionNumber, @Json(name = BoxItem.FIELD_ITEM_STATUS) ItemStatus itemStatus, @Json(name = BoxFile.FIELD_LOCK) FileLockDTO fileLock, @Json(name = BoxFile.FIELD_REPRESENTATIONS) RepresentationsDTO representations, @Json(name = BoxItem.FIELD_CLASSIFICATION) ClassificationDTO classification, @Json(name = BoxFile.FIELD_WATERMARK) WatermarkDTO watermark) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FileDTO(id, type, name, etag, parent, sharedLink, createdAt, modifiedAt, contentCreatedAt, contentModifiedAt, description, pathCollection, modifiedBy, ownedBy, permissions, sharedLinkPermissions, allowedSharedLinkAccessLevels, tags, collections, size, hasCollaborations, allowedInviteeRoles, defaultInviteeRole, isExternallyOwned, commentCount, annotationCount, sha1, fileVersion, versionNumber, itemStatus, fileLock, representations, classification, watermark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileDTO)) {
            return false;
        }
        FileDTO fileDTO = (FileDTO) other;
        return Intrinsics.areEqual(this.id, fileDTO.id) && Intrinsics.areEqual(this.type, fileDTO.type) && Intrinsics.areEqual(this.name, fileDTO.name) && Intrinsics.areEqual(this.etag, fileDTO.etag) && Intrinsics.areEqual(this.parent, fileDTO.parent) && Intrinsics.areEqual(this.sharedLink, fileDTO.sharedLink) && Intrinsics.areEqual(this.createdAt, fileDTO.createdAt) && Intrinsics.areEqual(this.modifiedAt, fileDTO.modifiedAt) && Intrinsics.areEqual(this.contentCreatedAt, fileDTO.contentCreatedAt) && Intrinsics.areEqual(this.contentModifiedAt, fileDTO.contentModifiedAt) && Intrinsics.areEqual(this.description, fileDTO.description) && Intrinsics.areEqual(this.pathCollection, fileDTO.pathCollection) && Intrinsics.areEqual(this.modifiedBy, fileDTO.modifiedBy) && Intrinsics.areEqual(this.ownedBy, fileDTO.ownedBy) && Intrinsics.areEqual(this.permissions, fileDTO.permissions) && Intrinsics.areEqual(this.sharedLinkPermissions, fileDTO.sharedLinkPermissions) && Intrinsics.areEqual(this.allowedSharedLinkAccessLevels, fileDTO.allowedSharedLinkAccessLevels) && Intrinsics.areEqual(this.tags, fileDTO.tags) && Intrinsics.areEqual(this.collections, fileDTO.collections) && Intrinsics.areEqual(this.size, fileDTO.size) && Intrinsics.areEqual(this.hasCollaborations, fileDTO.hasCollaborations) && Intrinsics.areEqual(this.allowedInviteeRoles, fileDTO.allowedInviteeRoles) && this.defaultInviteeRole == fileDTO.defaultInviteeRole && Intrinsics.areEqual(this.isExternallyOwned, fileDTO.isExternallyOwned) && Intrinsics.areEqual(this.commentCount, fileDTO.commentCount) && Intrinsics.areEqual(this.annotationCount, fileDTO.annotationCount) && Intrinsics.areEqual(this.sha1, fileDTO.sha1) && Intrinsics.areEqual(this.fileVersion, fileDTO.fileVersion) && Intrinsics.areEqual(this.versionNumber, fileDTO.versionNumber) && this.itemStatus == fileDTO.itemStatus && Intrinsics.areEqual(this.fileLock, fileDTO.fileLock) && Intrinsics.areEqual(this.representations, fileDTO.representations) && Intrinsics.areEqual(this.classification, fileDTO.classification) && Intrinsics.areEqual(this.watermark, fileDTO.watermark);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.etag;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FolderMiniDTO folderMiniDTO = this.parent;
        int iHashCode4 = (iHashCode3 + (folderMiniDTO == null ? 0 : folderMiniDTO.hashCode())) * 31;
        SharedLinkDTO sharedLinkDTO = this.sharedLink;
        int iHashCode5 = (iHashCode4 + (sharedLinkDTO == null ? 0 : sharedLinkDTO.hashCode())) * 31;
        String str3 = this.createdAt;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.modifiedAt;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.contentCreatedAt;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.contentModifiedAt;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.description;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        PathCollectionDTO pathCollectionDTO = this.pathCollection;
        int iHashCode11 = (iHashCode10 + (pathCollectionDTO == null ? 0 : pathCollectionDTO.hashCode())) * 31;
        UserMiniDTO userMiniDTO = this.modifiedBy;
        int iHashCode12 = (iHashCode11 + (userMiniDTO == null ? 0 : userMiniDTO.hashCode())) * 31;
        UserMiniDTO userMiniDTO2 = this.ownedBy;
        int iHashCode13 = (iHashCode12 + (userMiniDTO2 == null ? 0 : userMiniDTO2.hashCode())) * 31;
        PermissionsDTO permissionsDTO = this.permissions;
        int iHashCode14 = (iHashCode13 + (permissionsDTO == null ? 0 : permissionsDTO.hashCode())) * 31;
        List<SharedLinkPermissionOptionType> list = this.sharedLinkPermissions;
        int iHashCode15 = (iHashCode14 + (list == null ? 0 : list.hashCode())) * 31;
        List<SharedLinkModel.Access> list2 = this.allowedSharedLinkAccessLevels;
        int iHashCode16 = (iHashCode15 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.tags;
        int iHashCode17 = (iHashCode16 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<CollectionDTO> list4 = this.collections;
        int iHashCode18 = (iHashCode17 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Long l = this.size;
        int iHashCode19 = (iHashCode18 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.hasCollaborations;
        int iHashCode20 = (iHashCode19 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<CollaborationRole> list5 = this.allowedInviteeRoles;
        int iHashCode21 = (iHashCode20 + (list5 == null ? 0 : list5.hashCode())) * 31;
        CollaborationRole collaborationRole = this.defaultInviteeRole;
        int iHashCode22 = (iHashCode21 + (collaborationRole == null ? 0 : collaborationRole.hashCode())) * 31;
        Boolean bool2 = this.isExternallyOwned;
        int iHashCode23 = (iHashCode22 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l2 = this.commentCount;
        int iHashCode24 = (iHashCode23 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.annotationCount;
        int iHashCode25 = (iHashCode24 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str8 = this.sha1;
        int iHashCode26 = (iHashCode25 + (str8 == null ? 0 : str8.hashCode())) * 31;
        FileVersionMiniDTO fileVersionMiniDTO = this.fileVersion;
        int iHashCode27 = (iHashCode26 + (fileVersionMiniDTO == null ? 0 : fileVersionMiniDTO.hashCode())) * 31;
        String str9 = this.versionNumber;
        int iHashCode28 = (iHashCode27 + (str9 == null ? 0 : str9.hashCode())) * 31;
        ItemStatus itemStatus = this.itemStatus;
        int iHashCode29 = (iHashCode28 + (itemStatus == null ? 0 : itemStatus.hashCode())) * 31;
        FileLockDTO fileLockDTO = this.fileLock;
        int iHashCode30 = (iHashCode29 + (fileLockDTO == null ? 0 : fileLockDTO.hashCode())) * 31;
        RepresentationsDTO representationsDTO = this.representations;
        int iHashCode31 = (iHashCode30 + (representationsDTO == null ? 0 : representationsDTO.hashCode())) * 31;
        ClassificationDTO classificationDTO = this.classification;
        int iHashCode32 = (iHashCode31 + (classificationDTO == null ? 0 : classificationDTO.hashCode())) * 31;
        WatermarkDTO watermarkDTO = this.watermark;
        return iHashCode32 + (watermarkDTO != null ? watermarkDTO.hashCode() : 0);
    }

    public String toString() {
        return "FileDTO(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", etag=" + this.etag + ", parent=" + this.parent + ", sharedLink=" + this.sharedLink + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentModifiedAt=" + this.contentModifiedAt + ", description=" + this.description + ", pathCollection=" + this.pathCollection + ", modifiedBy=" + this.modifiedBy + ", ownedBy=" + this.ownedBy + ", permissions=" + this.permissions + ", sharedLinkPermissions=" + this.sharedLinkPermissions + ", allowedSharedLinkAccessLevels=" + this.allowedSharedLinkAccessLevels + ", tags=" + this.tags + ", collections=" + this.collections + ", size=" + this.size + ", hasCollaborations=" + this.hasCollaborations + ", allowedInviteeRoles=" + this.allowedInviteeRoles + ", defaultInviteeRole=" + this.defaultInviteeRole + ", isExternallyOwned=" + this.isExternallyOwned + ", commentCount=" + this.commentCount + ", annotationCount=" + this.annotationCount + ", sha1=" + this.sha1 + ", fileVersion=" + this.fileVersion + ", versionNumber=" + this.versionNumber + ", itemStatus=" + this.itemStatus + ", fileLock=" + this.fileLock + ", representations=" + this.representations + ", classification=" + this.classification + ", watermark=" + this.watermark + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String str, @Json(name = BoxItem.FIELD_ETAG) String str2, @Json(name = "parent") FolderMiniDTO folderMiniDTO, @Json(name = "shared_link") SharedLinkDTO sharedLinkDTO, @Json(name = "created_at") String str3, @Json(name = "modified_at") String str4, @Json(name = "content_created_at") String str5, @Json(name = "content_modified_at") String str6, @Json(name = "description") String str7, @Json(name = BoxItem.FIELD_PATH_COLLECTION) PathCollectionDTO pathCollectionDTO, @Json(name = "modified_by") UserMiniDTO userMiniDTO, @Json(name = BoxItem.FIELD_OWNED_BY) UserMiniDTO userMiniDTO2, @Json(name = "permissions") PermissionsDTO permissionsDTO, @Json(name = BoxFile.FIELD_SHARED_LINK_PERMISSION_OPTIONS) List<? extends SharedLinkPermissionOptionType> list, @Json(name = BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS) List<? extends SharedLinkModel.Access> list2, @Json(name = "tags") List<String> list3, @Json(name = BoxItem.FIELD_COLLECTIONS) List<CollectionDTO> list4, @Json(name = "size") Long l, @Json(name = BoxCollaborationItem.FIELD_HAS_COLLABORATIONS) Boolean bool, @Json(name = BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES) List<? extends CollaborationRole> list5, @Json(name = BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE) CollaborationRole collaborationRole, @Json(name = BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED) Boolean bool2, @Json(name = "comment_count") Long l2, @Json(name = "annotation_count") Long l3, @Json(name = "sha1") String str8, @Json(name = "file_version") FileVersionMiniDTO fileVersionMiniDTO, @Json(name = BoxFile.FIELD_VERSION_NUMBER) String str9, @Json(name = BoxItem.FIELD_ITEM_STATUS) ItemStatus itemStatus, @Json(name = BoxFile.FIELD_LOCK) FileLockDTO fileLockDTO, @Json(name = BoxFile.FIELD_REPRESENTATIONS) RepresentationsDTO representationsDTO, @Json(name = BoxItem.FIELD_CLASSIFICATION) ClassificationDTO classificationDTO, @Json(name = BoxFile.FIELD_WATERMARK) WatermarkDTO watermarkDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.name = str;
        this.etag = str2;
        this.parent = folderMiniDTO;
        this.sharedLink = sharedLinkDTO;
        this.createdAt = str3;
        this.modifiedAt = str4;
        this.contentCreatedAt = str5;
        this.contentModifiedAt = str6;
        this.description = str7;
        this.pathCollection = pathCollectionDTO;
        this.modifiedBy = userMiniDTO;
        this.ownedBy = userMiniDTO2;
        this.permissions = permissionsDTO;
        this.sharedLinkPermissions = list;
        this.allowedSharedLinkAccessLevels = list2;
        this.tags = list3;
        this.collections = list4;
        this.size = l;
        this.hasCollaborations = bool;
        this.allowedInviteeRoles = list5;
        this.defaultInviteeRole = collaborationRole;
        this.isExternallyOwned = bool2;
        this.commentCount = l2;
        this.annotationCount = l3;
        this.sha1 = str8;
        this.fileVersion = fileVersionMiniDTO;
        this.versionNumber = str9;
        this.itemStatus = itemStatus;
        this.fileLock = fileLockDTO;
        this.representations = representationsDTO;
        this.classification = classificationDTO;
        this.watermark = watermarkDTO;
    }

    public /* synthetic */ FileDTO(String str, String str2, String str3, String str4, FolderMiniDTO folderMiniDTO, SharedLinkDTO sharedLinkDTO, String str5, String str6, String str7, String str8, String str9, PathCollectionDTO pathCollectionDTO, UserMiniDTO userMiniDTO, UserMiniDTO userMiniDTO2, PermissionsDTO permissionsDTO, List list, List list2, List list3, List list4, Long l, Boolean bool, List list5, CollaborationRole collaborationRole, Boolean bool2, Long l2, Long l3, String str10, FileVersionMiniDTO fileVersionMiniDTO, String str11, ItemStatus itemStatus, FileLockDTO fileLockDTO, RepresentationsDTO representationsDTO, ClassificationDTO classificationDTO, WatermarkDTO watermarkDTO, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : folderMiniDTO, (i & 32) != 0 ? null : sharedLinkDTO, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : pathCollectionDTO, (i & 4096) != 0 ? null : userMiniDTO, (i & 8192) != 0 ? null : userMiniDTO2, (i & 16384) != 0 ? null : permissionsDTO, (32768 & i) != 0 ? null : list, (i & 65536) != 0 ? null : list2, (i & 131072) != 0 ? null : list3, (i & 262144) != 0 ? null : list4, (i & 524288) != 0 ? null : l, (i & 1048576) != 0 ? null : bool, (i & 2097152) != 0 ? null : list5, (i & 4194304) != 0 ? null : collaborationRole, (i & 8388608) != 0 ? null : bool2, (i & 16777216) != 0 ? null : l2, (i & 33554432) != 0 ? null : l3, (i & 67108864) != 0 ? null : str10, (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? null : fileVersionMiniDTO, (i & 268435456) != 0 ? null : str11, (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? null : itemStatus, (i & 1073741824) != 0 ? null : fileLockDTO, (i & Integer.MIN_VALUE) != 0 ? null : representationsDTO, (i2 & 1) != 0 ? null : classificationDTO, (i2 & 2) != 0 ? null : watermarkDTO);
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getType() {
        return this.type;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public FolderMiniDTO getParent() {
        return this.parent;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public SharedLinkDTO getSharedLink() {
        return this.sharedLink;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getModifiedAt() {
        return this.modifiedAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getDescription() {
        return this.description;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public PathCollectionDTO getPathCollection() {
        return this.pathCollection;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public UserMiniDTO getOwnedBy() {
        return this.ownedBy;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public PermissionsDTO getPermissions() {
        return this.permissions;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public List<SharedLinkPermissionOptionType> getSharedLinkPermissions() {
        return this.sharedLinkPermissions;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<SharedLinkModel.Access> getAllowedSharedLinkAccessLevels() {
        return this.allowedSharedLinkAccessLevels;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<String> getTags() {
        return this.tags;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<CollectionDTO> getCollections() {
        return this.collections;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public Long getSize() {
        return this.size;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<CollaborationRole> getAllowedInviteeRoles() {
        return this.allowedInviteeRoles;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public CollaborationRole getDefaultInviteeRole() {
        return this.defaultInviteeRole;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public Boolean isExternallyOwned() {
        return this.isExternallyOwned;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public Long getCommentCount() {
        return this.commentCount;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public Long getAnnotationCount() {
        return this.annotationCount;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public String getSha1() {
        return this.sha1;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public FileVersionMiniDTO getFileVersion() {
        return this.fileVersion;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public String getVersionNumber() {
        return this.versionNumber;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public ItemStatus getItemStatus() {
        return this.itemStatus;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public FileLockDTO getFileLock() {
        return this.fileLock;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public RepresentationsDTO getRepresentations() {
        return this.representations;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public ClassificationDTO getClassification() {
        return this.classification;
    }

    @Override // com.box.android.data.api.models.items.IFileDTO
    public WatermarkDTO getWatermark() {
        return this.watermark;
    }
}
