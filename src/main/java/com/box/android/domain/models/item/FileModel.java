package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ClassificationModel;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B§\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b/\u00100J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0007HÆ\u0003J\t\u0010`\u001a\u00020\u0007HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010h\u001a\u00020\u0007HÆ\u0003J\t\u0010i\u001a\u00020\u0015HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\u0011\u0010l\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u0011\u0010n\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019HÆ\u0003J\u0011\u0010o\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019HÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010'HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010t\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010u\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010-HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÜ\u0002\u0010x\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00192\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00192\b\b\u0002\u0010#\u001a\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010yJ\u0006\u0010z\u001a\u00020{J\u0013\u0010|\u001a\u00020\u00072\b\u0010}\u001a\u0004\u0018\u00010~HÖ\u0003J\t\u0010\u007f\u001a\u00020{HÖ\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0005HÖ\u0001J\u001b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020{R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u00106R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\r\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u0014\u0010\u0013\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00106R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010FR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010FR\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bK\u0010FR\u0011\u0010#\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u00104R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0015\u0010(\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010R\u001a\u0004\bQ\u0010BR\u0015\u0010)\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010R\u001a\u0004\bS\u0010BR\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0016\u0010.\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u00104R\u0011\u0010Y\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bZ\u00104R\u0011\u0010[\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\\\u00104¨\u0006\u0087\u0001"}, d2 = {"Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/item/ItemModel;", "itemId", "Lcom/box/android/domain/models/ItemId;", "name", "", "hasCollaborations", "", "isExternallyOwned", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "owner", "Lcom/box/android/domain/models/item/UserModel;", "updatedBy", "createdDate", "Ljava/util/Date;", "contentCreatedDate", "modifiedDate", "contentModifiedDate", "isRooted", "size", "", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "pathCollection", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/domain/models/CollectionModel;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/domain/models/item/SharedLinkModel;", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/domain/models/RepresentationModel;", "sharedLinkPermissions", "Lcom/box/android/domain/models/SharedLinkPermissionOptionType;", "sha1", "fileVersion", "Lcom/box/android/domain/models/item/FileVersionMiniModel;", "fileLock", "Lcom/box/android/domain/models/item/FileLockModel;", "commentCount", "annotationCount", BoxItem.FIELD_CLASSIFICATION, "Lcom/box/android/domain/models/ClassificationModel;", "watermark", "Lcom/box/android/domain/models/item/WatermarkModel;", "description", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;ZZLcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/item/UserModel;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZJLcom/box/android/domain/models/item/PermissionsModel;Ljava/util/List;Ljava/util/List;Lcom/box/android/domain/models/item/SharedLinkModel;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/box/android/domain/models/item/FileVersionMiniModel;Lcom/box/android/domain/models/item/FileLockModel;Ljava/lang/Long;Ljava/lang/Long;Lcom/box/android/domain/models/ClassificationModel;Lcom/box/android/domain/models/item/WatermarkModel;Ljava/lang/String;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getName", "()Ljava/lang/String;", "getHasCollaborations", "()Z", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getOwner", "()Lcom/box/android/domain/models/item/UserModel;", "getUpdatedBy", "getCreatedDate", "()Ljava/util/Date;", "getContentCreatedDate", "getModifiedDate", "getContentModifiedDate", "getSize", "()Ljava/lang/Long;", "getPermissions", "()Lcom/box/android/domain/models/item/PermissionsModel;", "getPathCollection", "()Ljava/util/List;", "getCollections", "getSharedLink", "()Lcom/box/android/domain/models/item/SharedLinkModel;", "getRepresentations", "getSharedLinkPermissions", "getSha1", "getFileVersion", "()Lcom/box/android/domain/models/item/FileVersionMiniModel;", "getFileLock", "()Lcom/box/android/domain/models/item/FileLockModel;", "getCommentCount", "Ljava/lang/Long;", "getAnnotationCount", "getClassification", "()Lcom/box/android/domain/models/ClassificationModel;", "getWatermark", "()Lcom/box/android/domain/models/item/WatermarkModel;", "getDescription", "nameWithoutExtension", "getNameWithoutExtension", BoxFile.FIELD_EXTENSION, "getExtension", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;ZZLcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/item/UserModel;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZJLcom/box/android/domain/models/item/PermissionsModel;Ljava/util/List;Ljava/util/List;Lcom/box/android/domain/models/item/SharedLinkModel;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/box/android/domain/models/item/FileVersionMiniModel;Lcom/box/android/domain/models/item/FileLockModel;Ljava/lang/Long;Ljava/lang/Long;Lcom/box/android/domain/models/ClassificationModel;Lcom/box/android/domain/models/item/WatermarkModel;Ljava/lang/String;)Lcom/box/android/domain/models/item/FileModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileModel extends ItemModel {
    private final Long annotationCount;
    private final ClassificationModel classification;
    private final List<CollectionModel> collections;
    private final Long commentCount;
    private final Date contentCreatedDate;
    private final Date contentModifiedDate;
    private final Date createdDate;
    private final String description;
    private final FileLockModel fileLock;
    private final FileVersionMiniModel fileVersion;
    private final boolean hasCollaborations;
    private final boolean isExternallyOwned;
    private final boolean isRooted;
    private final ItemId itemId;
    private final Date modifiedDate;
    private final String name;
    private final UserModel owner;
    private final FolderModel parentFolder;
    private final List<PathCollectionEntry> pathCollection;
    private final PermissionsModel permissions;
    private final List<RepresentationModel> representations;
    private final String sha1;
    private final SharedLinkModel sharedLink;
    private final List<SharedLinkPermissionOptionType> sharedLinkPermissions;
    private final long size;
    private final UserModel updatedBy;
    private final WatermarkModel watermark;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FileModel> CREATOR = new Creator();

    /* JADX INFO: compiled from: FileModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FileModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ItemId itemId = (ItemId) parcel.readParcelable(FileModel.class.getClassLoader());
            String string = parcel.readString();
            boolean z = false;
            if (parcel.readInt() != 0) {
                z = true;
            }
            boolean z2 = parcel.readInt() != 0 ? true : z;
            FolderModel folderModelCreateFromParcel = parcel.readInt() == 0 ? null : FolderModel.CREATOR.createFromParcel(parcel);
            UserModel userModelCreateFromParcel = parcel.readInt() == 0 ? null : UserModel.CREATOR.createFromParcel(parcel);
            UserModel userModelCreateFromParcel2 = parcel.readInt() == 0 ? null : UserModel.CREATOR.createFromParcel(parcel);
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Date date3 = (Date) parcel.readSerializable();
            Date date4 = (Date) parcel.readSerializable();
            boolean z3 = parcel.readInt() != 0;
            long j = parcel.readLong();
            PermissionsModel permissionsModelCreateFromParcel = parcel.readInt() == 0 ? null : PermissionsModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                int i2 = 0;
                while (i2 != i) {
                    arrayList.add(PathCollectionEntry.CREATOR.createFromParcel(parcel));
                    i2++;
                    i = i;
                }
            }
            ArrayList arrayList5 = arrayList;
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i3 = parcel.readInt();
                arrayList2 = new ArrayList(i3);
                int i4 = 0;
                while (i4 != i3) {
                    arrayList2.add(CollectionModel.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
            }
            ArrayList arrayList6 = arrayList2;
            SharedLinkModel sharedLinkModelCreateFromParcel = parcel.readInt() == 0 ? null : SharedLinkModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int i5 = parcel.readInt();
                arrayList3 = new ArrayList(i5);
                for (int i6 = 0; i6 != i5; i6++) {
                    arrayList3.add(RepresentationModel.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList7 = arrayList3;
            if (parcel.readInt() == 0) {
                arrayList4 = null;
            } else {
                int i7 = parcel.readInt();
                arrayList4 = new ArrayList(i7);
                for (int i8 = 0; i8 != i7; i8++) {
                    arrayList4.add(SharedLinkPermissionOptionType.CREATOR.createFromParcel(parcel));
                }
            }
            return new FileModel(itemId, string, z, z2, folderModelCreateFromParcel, userModelCreateFromParcel, userModelCreateFromParcel2, date, date2, date3, date4, z3, j, permissionsModelCreateFromParcel, arrayList5, arrayList6, sharedLinkModelCreateFromParcel, arrayList7, arrayList4, parcel.readString(), parcel.readInt() == 0 ? null : FileVersionMiniModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FileLockModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : ClassificationModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : WatermarkModel.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileModel[] newArray(int i) {
            return new FileModel[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileModel copy$default(FileModel fileModel, ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, long j, PermissionsModel permissionsModel, List list, List list2, SharedLinkModel sharedLinkModel, List list3, List list4, String str2, FileVersionMiniModel fileVersionMiniModel, FileLockModel fileLockModel, Long l, Long l2, ClassificationModel classificationModel, WatermarkModel watermarkModel, String str3, int i, Object obj) {
        String str4;
        WatermarkModel watermarkModel2;
        ItemId itemId2 = (i & 1) != 0 ? fileModel.itemId : itemId;
        String str5 = (i & 2) != 0 ? fileModel.name : str;
        boolean z4 = (i & 4) != 0 ? fileModel.hasCollaborations : z;
        boolean z5 = (i & 8) != 0 ? fileModel.isExternallyOwned : z2;
        FolderModel folderModel2 = (i & 16) != 0 ? fileModel.parentFolder : folderModel;
        UserModel userModel3 = (i & 32) != 0 ? fileModel.owner : userModel;
        UserModel userModel4 = (i & 64) != 0 ? fileModel.updatedBy : userModel2;
        Date date5 = (i & 128) != 0 ? fileModel.createdDate : date;
        Date date6 = (i & 256) != 0 ? fileModel.contentCreatedDate : date2;
        Date date7 = (i & 512) != 0 ? fileModel.modifiedDate : date3;
        Date date8 = (i & 1024) != 0 ? fileModel.contentModifiedDate : date4;
        boolean z6 = (i & 2048) != 0 ? fileModel.isRooted : z3;
        long j2 = (i & 4096) != 0 ? fileModel.size : j;
        ItemId itemId3 = itemId2;
        PermissionsModel permissionsModel2 = (i & 8192) != 0 ? fileModel.permissions : permissionsModel;
        List list5 = (i & 16384) != 0 ? fileModel.pathCollection : list;
        List list6 = (i & 32768) != 0 ? fileModel.collections : list2;
        SharedLinkModel sharedLinkModel2 = (i & 65536) != 0 ? fileModel.sharedLink : sharedLinkModel;
        List list7 = (i & 131072) != 0 ? fileModel.representations : list3;
        List list8 = (i & 262144) != 0 ? fileModel.sharedLinkPermissions : list4;
        String str6 = (i & 524288) != 0 ? fileModel.sha1 : str2;
        FileVersionMiniModel fileVersionMiniModel2 = (i & 1048576) != 0 ? fileModel.fileVersion : fileVersionMiniModel;
        FileLockModel fileLockModel2 = (i & 2097152) != 0 ? fileModel.fileLock : fileLockModel;
        Long l3 = (i & 4194304) != 0 ? fileModel.commentCount : l;
        Long l4 = (i & 8388608) != 0 ? fileModel.annotationCount : l2;
        ClassificationModel classificationModel2 = (i & 16777216) != 0 ? fileModel.classification : classificationModel;
        WatermarkModel watermarkModel3 = (i & 33554432) != 0 ? fileModel.watermark : watermarkModel;
        if ((i & 67108864) != 0) {
            watermarkModel2 = watermarkModel3;
            str4 = fileModel.description;
        } else {
            str4 = str3;
            watermarkModel2 = watermarkModel3;
        }
        return fileModel.copy(itemId3, str5, z4, z5, folderModel2, userModel3, userModel4, date5, date6, date7, date8, z6, j2, permissionsModel2, list5, list6, sharedLinkModel2, list7, list8, str6, fileVersionMiniModel2, fileLockModel2, l3, l4, classificationModel2, watermarkModel2, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemId getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Date getModifiedDate() {
        return this.modifiedDate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Date getContentModifiedDate() {
        return this.contentModifiedDate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsRooted() {
        return this.isRooted;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final PermissionsModel getPermissions() {
        return this.permissions;
    }

    public final List<PathCollectionEntry> component15() {
        return this.pathCollection;
    }

    public final List<CollectionModel> component16() {
        return this.collections;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final SharedLinkModel getSharedLink() {
        return this.sharedLink;
    }

    public final List<RepresentationModel> component18() {
        return this.representations;
    }

    public final List<SharedLinkPermissionOptionType> component19() {
        return this.sharedLinkPermissions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final FileVersionMiniModel getFileVersion() {
        return this.fileVersion;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final FileLockModel getFileLock() {
        return this.fileLock;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Long getCommentCount() {
        return this.commentCount;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Long getAnnotationCount() {
        return this.annotationCount;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final ClassificationModel getClassification() {
        return this.classification;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final WatermarkModel getWatermark() {
        return this.watermark;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsExternallyOwned() {
        return this.isExternallyOwned;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FolderModel getParentFolder() {
        return this.parentFolder;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserModel getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UserModel getUpdatedBy() {
        return this.updatedBy;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Date getCreatedDate() {
        return this.createdDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Date getContentCreatedDate() {
        return this.contentCreatedDate;
    }

    public final FileModel copy(ItemId itemId, String name, boolean hasCollaborations, boolean isExternallyOwned, FolderModel parentFolder, UserModel owner, UserModel updatedBy, Date createdDate, Date contentCreatedDate, Date modifiedDate, Date contentModifiedDate, boolean isRooted, long size, PermissionsModel permissions, List<PathCollectionEntry> pathCollection, List<CollectionModel> collections, SharedLinkModel sharedLink, List<RepresentationModel> representations, List<? extends SharedLinkPermissionOptionType> sharedLinkPermissions, String sha1, FileVersionMiniModel fileVersion, FileLockModel fileLock, Long commentCount, Long annotationCount, ClassificationModel classification, WatermarkModel watermark, String description) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        return new FileModel(itemId, name, hasCollaborations, isExternallyOwned, parentFolder, owner, updatedBy, createdDate, contentCreatedDate, modifiedDate, contentModifiedDate, isRooted, size, permissions, pathCollection, collections, sharedLink, representations, sharedLinkPermissions, sha1, fileVersion, fileLock, commentCount, annotationCount, classification, watermark, description);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileModel)) {
            return false;
        }
        FileModel fileModel = (FileModel) other;
        return Intrinsics.areEqual(this.itemId, fileModel.itemId) && Intrinsics.areEqual(this.name, fileModel.name) && this.hasCollaborations == fileModel.hasCollaborations && this.isExternallyOwned == fileModel.isExternallyOwned && Intrinsics.areEqual(this.parentFolder, fileModel.parentFolder) && Intrinsics.areEqual(this.owner, fileModel.owner) && Intrinsics.areEqual(this.updatedBy, fileModel.updatedBy) && Intrinsics.areEqual(this.createdDate, fileModel.createdDate) && Intrinsics.areEqual(this.contentCreatedDate, fileModel.contentCreatedDate) && Intrinsics.areEqual(this.modifiedDate, fileModel.modifiedDate) && Intrinsics.areEqual(this.contentModifiedDate, fileModel.contentModifiedDate) && this.isRooted == fileModel.isRooted && this.size == fileModel.size && Intrinsics.areEqual(this.permissions, fileModel.permissions) && Intrinsics.areEqual(this.pathCollection, fileModel.pathCollection) && Intrinsics.areEqual(this.collections, fileModel.collections) && Intrinsics.areEqual(this.sharedLink, fileModel.sharedLink) && Intrinsics.areEqual(this.representations, fileModel.representations) && Intrinsics.areEqual(this.sharedLinkPermissions, fileModel.sharedLinkPermissions) && Intrinsics.areEqual(this.sha1, fileModel.sha1) && Intrinsics.areEqual(this.fileVersion, fileModel.fileVersion) && Intrinsics.areEqual(this.fileLock, fileModel.fileLock) && Intrinsics.areEqual(this.commentCount, fileModel.commentCount) && Intrinsics.areEqual(this.annotationCount, fileModel.annotationCount) && Intrinsics.areEqual(this.classification, fileModel.classification) && Intrinsics.areEqual(this.watermark, fileModel.watermark) && Intrinsics.areEqual(this.description, fileModel.description);
    }

    public int hashCode() {
        int iHashCode = ((((((this.itemId.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.hasCollaborations)) * 31) + Boolean.hashCode(this.isExternallyOwned)) * 31;
        FolderModel folderModel = this.parentFolder;
        int iHashCode2 = (iHashCode + (folderModel == null ? 0 : folderModel.hashCode())) * 31;
        UserModel userModel = this.owner;
        int iHashCode3 = (iHashCode2 + (userModel == null ? 0 : userModel.hashCode())) * 31;
        UserModel userModel2 = this.updatedBy;
        int iHashCode4 = (iHashCode3 + (userModel2 == null ? 0 : userModel2.hashCode())) * 31;
        Date date = this.createdDate;
        int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.contentCreatedDate;
        int iHashCode6 = (iHashCode5 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.modifiedDate;
        int iHashCode7 = (iHashCode6 + (date3 == null ? 0 : date3.hashCode())) * 31;
        Date date4 = this.contentModifiedDate;
        int iHashCode8 = (((((iHashCode7 + (date4 == null ? 0 : date4.hashCode())) * 31) + Boolean.hashCode(this.isRooted)) * 31) + Long.hashCode(this.size)) * 31;
        PermissionsModel permissionsModel = this.permissions;
        int iHashCode9 = (iHashCode8 + (permissionsModel == null ? 0 : permissionsModel.hashCode())) * 31;
        List<PathCollectionEntry> list = this.pathCollection;
        int iHashCode10 = (iHashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        List<CollectionModel> list2 = this.collections;
        int iHashCode11 = (iHashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        SharedLinkModel sharedLinkModel = this.sharedLink;
        int iHashCode12 = (iHashCode11 + (sharedLinkModel == null ? 0 : sharedLinkModel.hashCode())) * 31;
        List<RepresentationModel> list3 = this.representations;
        int iHashCode13 = (iHashCode12 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<SharedLinkPermissionOptionType> list4 = this.sharedLinkPermissions;
        int iHashCode14 = (((iHashCode13 + (list4 == null ? 0 : list4.hashCode())) * 31) + this.sha1.hashCode()) * 31;
        FileVersionMiniModel fileVersionMiniModel = this.fileVersion;
        int iHashCode15 = (iHashCode14 + (fileVersionMiniModel == null ? 0 : fileVersionMiniModel.hashCode())) * 31;
        FileLockModel fileLockModel = this.fileLock;
        int iHashCode16 = (iHashCode15 + (fileLockModel == null ? 0 : fileLockModel.hashCode())) * 31;
        Long l = this.commentCount;
        int iHashCode17 = (iHashCode16 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.annotationCount;
        int iHashCode18 = (iHashCode17 + (l2 == null ? 0 : l2.hashCode())) * 31;
        ClassificationModel classificationModel = this.classification;
        int iHashCode19 = (iHashCode18 + (classificationModel == null ? 0 : classificationModel.hashCode())) * 31;
        WatermarkModel watermarkModel = this.watermark;
        int iHashCode20 = (iHashCode19 + (watermarkModel == null ? 0 : watermarkModel.hashCode())) * 31;
        String str = this.description;
        return iHashCode20 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FileModel(itemId=" + this.itemId + ", name=" + this.name + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", parentFolder=" + this.parentFolder + ", owner=" + this.owner + ", updatedBy=" + this.updatedBy + ", createdDate=" + this.createdDate + ", contentCreatedDate=" + this.contentCreatedDate + ", modifiedDate=" + this.modifiedDate + ", contentModifiedDate=" + this.contentModifiedDate + ", isRooted=" + this.isRooted + ", size=" + this.size + ", permissions=" + this.permissions + ", pathCollection=" + this.pathCollection + ", collections=" + this.collections + ", sharedLink=" + this.sharedLink + ", representations=" + this.representations + ", sharedLinkPermissions=" + this.sharedLinkPermissions + ", sha1=" + this.sha1 + ", fileVersion=" + this.fileVersion + ", fileLock=" + this.fileLock + ", commentCount=" + this.commentCount + ", annotationCount=" + this.annotationCount + ", classification=" + this.classification + ", watermark=" + this.watermark + ", description=" + this.description + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.itemId, flags);
        dest.writeString(this.name);
        dest.writeInt(this.hasCollaborations ? 1 : 0);
        dest.writeInt(this.isExternallyOwned ? 1 : 0);
        FolderModel folderModel = this.parentFolder;
        if (folderModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            folderModel.writeToParcel(dest, flags);
        }
        UserModel userModel = this.owner;
        if (userModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userModel.writeToParcel(dest, flags);
        }
        UserModel userModel2 = this.updatedBy;
        if (userModel2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userModel2.writeToParcel(dest, flags);
        }
        dest.writeSerializable(this.createdDate);
        dest.writeSerializable(this.contentCreatedDate);
        dest.writeSerializable(this.modifiedDate);
        dest.writeSerializable(this.contentModifiedDate);
        dest.writeInt(this.isRooted ? 1 : 0);
        dest.writeLong(this.size);
        PermissionsModel permissionsModel = this.permissions;
        if (permissionsModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            permissionsModel.writeToParcel(dest, flags);
        }
        List<PathCollectionEntry> list = this.pathCollection;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<PathCollectionEntry> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        List<CollectionModel> list2 = this.collections;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<CollectionModel> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        SharedLinkModel sharedLinkModel = this.sharedLink;
        if (sharedLinkModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            sharedLinkModel.writeToParcel(dest, flags);
        }
        List<RepresentationModel> list3 = this.representations;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list3.size());
            Iterator<RepresentationModel> it3 = list3.iterator();
            while (it3.hasNext()) {
                it3.next().writeToParcel(dest, flags);
            }
        }
        List<SharedLinkPermissionOptionType> list4 = this.sharedLinkPermissions;
        if (list4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list4.size());
            Iterator<SharedLinkPermissionOptionType> it4 = list4.iterator();
            while (it4.hasNext()) {
                it4.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.sha1);
        FileVersionMiniModel fileVersionMiniModel = this.fileVersion;
        if (fileVersionMiniModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            fileVersionMiniModel.writeToParcel(dest, flags);
        }
        FileLockModel fileLockModel = this.fileLock;
        if (fileLockModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            fileLockModel.writeToParcel(dest, flags);
        }
        Long l = this.commentCount;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Long l2 = this.annotationCount;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        ClassificationModel classificationModel = this.classification;
        if (classificationModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            classificationModel.writeToParcel(dest, flags);
        }
        WatermarkModel watermarkModel = this.watermark;
        if (watermarkModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            watermarkModel.writeToParcel(dest, flags);
        }
        dest.writeString(this.description);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileModel(ItemId itemId, String name, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, long j, PermissionsModel permissionsModel, List<PathCollectionEntry> list, List<CollectionModel> list2, SharedLinkModel sharedLinkModel, List<RepresentationModel> list3, List<? extends SharedLinkPermissionOptionType> list4, String sha1, FileVersionMiniModel fileVersionMiniModel, FileLockModel fileLockModel, Long l, Long l2, ClassificationModel classificationModel, WatermarkModel watermarkModel, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        this.itemId = itemId;
        this.name = name;
        this.hasCollaborations = z;
        this.isExternallyOwned = z2;
        this.parentFolder = folderModel;
        this.owner = userModel;
        this.updatedBy = userModel2;
        this.createdDate = date;
        this.contentCreatedDate = date2;
        this.modifiedDate = date3;
        this.contentModifiedDate = date4;
        this.isRooted = z3;
        this.size = j;
        this.permissions = permissionsModel;
        this.pathCollection = list;
        this.collections = list2;
        this.sharedLink = sharedLinkModel;
        this.representations = list3;
        this.sharedLinkPermissions = list4;
        this.sha1 = sha1;
        this.fileVersion = fileVersionMiniModel;
        this.fileLock = fileLockModel;
        this.commentCount = l;
        this.annotationCount = l2;
        this.classification = classificationModel;
        this.watermark = watermarkModel;
        this.description = str;
    }

    public /* synthetic */ FileModel(ItemId itemId, String str, boolean z, boolean z2, FolderModel folderModel, UserModel userModel, UserModel userModel2, Date date, Date date2, Date date3, Date date4, boolean z3, long j, PermissionsModel permissionsModel, List list, List list2, SharedLinkModel sharedLinkModel, List list3, List list4, String str2, FileVersionMiniModel fileVersionMiniModel, FileLockModel fileLockModel, Long l, Long l2, ClassificationModel classificationModel, WatermarkModel watermarkModel, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemId, str, z, z2, (i & 16) != 0 ? null : folderModel, userModel, userModel2, date, date2, date3, date4, z3, j, permissionsModel, list, list2, sharedLinkModel, list3, list4, str2, fileVersionMiniModel, fileLockModel, l, l2, (i & 16777216) != 0 ? null : classificationModel, (i & 33554432) != 0 ? null : watermarkModel, (i & 67108864) != 0 ? null : str3);
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public ItemId getItemId() {
        return this.itemId;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public String getName() {
        return this.name;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public boolean isExternallyOwned() {
        return this.isExternallyOwned;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public FolderModel getParentFolder() {
        return this.parentFolder;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public UserModel getOwner() {
        return this.owner;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public UserModel getUpdatedBy() {
        return this.updatedBy;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getCreatedDate() {
        return this.createdDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getContentCreatedDate() {
        return this.contentCreatedDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Date getContentModifiedDate() {
        return this.contentModifiedDate;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public boolean isRooted() {
        return this.isRooted;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public Long getSize() {
        return Long.valueOf(this.size);
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public PermissionsModel getPermissions() {
        return this.permissions;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public List<PathCollectionEntry> getPathCollection() {
        return this.pathCollection;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public List<CollectionModel> getCollections() {
        return this.collections;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public SharedLinkModel getSharedLink() {
        return this.sharedLink;
    }

    public final List<RepresentationModel> getRepresentations() {
        return this.representations;
    }

    public final List<SharedLinkPermissionOptionType> getSharedLinkPermissions() {
        return this.sharedLinkPermissions;
    }

    public final String getSha1() {
        return this.sha1;
    }

    public final FileVersionMiniModel getFileVersion() {
        return this.fileVersion;
    }

    public final FileLockModel getFileLock() {
        return this.fileLock;
    }

    public final Long getCommentCount() {
        return this.commentCount;
    }

    public final Long getAnnotationCount() {
        return this.annotationCount;
    }

    public final ClassificationModel getClassification() {
        return this.classification;
    }

    public final WatermarkModel getWatermark() {
        return this.watermark;
    }

    @Override // com.box.android.domain.models.item.ItemModel
    public String getDescription() {
        return this.description;
    }

    public final String getNameWithoutExtension() {
        return StringsKt.substringBeforeLast$default(getName(), ".", (String) null, 2, (Object) null);
    }

    public final String getExtension() {
        return CommonBoxUtil.getFileExtension(getName(), "");
    }

    /* JADX INFO: compiled from: FileModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\n\u0010\b\u001a\u00020\t*\u00020\nJ\n\u0010\u000b\u001a\u00020\t*\u00020\n¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/item/FileModel$Companion;", "", "<init>", "()V", "createItemId", "Lcom/box/android/domain/models/ItemId;", "id", "", "isWatermarked", "", "Lcom/box/android/domain/models/item/FileModel;", "canPreview", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ItemId createItemId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            try {
                return ItemId.INSTANCE.create(id);
            } catch (Exception unused) {
                return new ItemId.Remote(id, ItemType.FILE);
            }
        }

        public final boolean isWatermarked(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "<this>");
            WatermarkModel watermark = fileModel.getWatermark();
            if (watermark != null) {
                return watermark.isWatermarked();
            }
            return false;
        }

        public final boolean canPreview(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "<this>");
            PermissionsModel permissions = fileModel.getPermissions();
            if (permissions != null) {
                return permissions.getCanPreview();
            }
            return false;
        }
    }
}
