package com.box.android.domain.mappers;

import com.box.android.domain.models.item.PermissionsModel;
import com.box.androidsdk.content.models.BoxItem;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionsModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0007J\n\u0010\b\u001a\u00020\t*\u00020\u0007J\u0010\u0010\n\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/mappers/PermissionsModelMapper;", "", "<init>", "()V", "toLegacyPermissions", "Ljava/util/EnumSet;", "Lcom/box/androidsdk/content/models/BoxItem$Permission;", "Lcom/box/android/domain/models/item/PermissionsModel;", "toJsonString", "", "toPermissionsModel", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PermissionsModelMapper {
    public static final PermissionsModelMapper INSTANCE = new PermissionsModelMapper();

    /* JADX INFO: compiled from: PermissionsModelMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxItem.Permission.values().length];
            try {
                iArr[BoxItem.Permission.CAN_SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxItem.Permission.CAN_UPLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxItem.Permission.CAN_RENAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BoxItem.Permission.CAN_DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BoxItem.Permission.CAN_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BoxItem.Permission.CAN_PREVIEW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BoxItem.Permission.CAN_DOWNLOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BoxItem.Permission.CAN_SET_SHARE_ACCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BoxItem.Permission.CAN_INVITE_COLLABORATOR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BoxItem.Permission.CAN_VIEW_ANNOTATIONS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BoxItem.Permission.CAN_CREATE_ANNOTATIONS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PermissionsModelMapper() {
    }

    public final EnumSet<BoxItem.Permission> toLegacyPermissions(PermissionsModel permissionsModel) {
        Intrinsics.checkNotNullParameter(permissionsModel, "<this>");
        EnumSet<BoxItem.Permission> enumSetNoneOf = EnumSet.noneOf(BoxItem.Permission.class);
        if (permissionsModel.getCanShare()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_SHARE);
        }
        if (permissionsModel.getCanUpload()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_UPLOAD);
        }
        if (permissionsModel.getCanRename()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_RENAME);
        }
        if (permissionsModel.getCanDelete()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_DELETE);
        }
        if (permissionsModel.getCanComment()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_COMMENT);
        }
        if (permissionsModel.getCanPreview()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_PREVIEW);
        }
        if (permissionsModel.getCanDownload()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_DOWNLOAD);
        }
        if (permissionsModel.getCanSetShareAccess()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_SET_SHARE_ACCESS);
        }
        if (permissionsModel.getCanInviteCollaborators()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_INVITE_COLLABORATOR);
        }
        if (permissionsModel.getCanCreateAnnotations()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_CREATE_ANNOTATIONS);
        }
        if (permissionsModel.getCanViewAnnotations()) {
            enumSetNoneOf.add(BoxItem.Permission.CAN_VIEW_ANNOTATIONS);
        }
        Intrinsics.checkNotNull(enumSetNoneOf);
        return enumSetNoneOf;
    }

    public final String toJsonString(PermissionsModel permissionsModel) {
        Intrinsics.checkNotNullParameter(permissionsModel, "<this>");
        EnumSet<BoxItem.Permission> legacyPermissions = toLegacyPermissions(permissionsModel);
        StringBuilder sb = new StringBuilder();
        for (BoxItem.Permission permission : BoxItem.Permission.values()) {
            sb.append("\"" + permission + "\":" + legacyPermissions.contains(permission) + ",");
        }
        return "{" + sb.substring(0, sb.length() - 1) + "}";
    }

    public final PermissionsModel toPermissionsModel(EnumSet<BoxItem.Permission> enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "<this>");
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        for (BoxItem.Permission permission : enumSet) {
            switch (permission == null ? -1 : WhenMappings.$EnumSwitchMapping$0[permission.ordinal()]) {
                case -1:
                    break;
                case 0:
                default:
                    throw new NoWhenBranchMatchedException();
                case 1:
                    z7 = true;
                    break;
                case 2:
                    z5 = true;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    z = true;
                    break;
                case 5:
                    z6 = true;
                    break;
                case 6:
                    z4 = true;
                    break;
                case 7:
                    z3 = true;
                    break;
                case 8:
                    z9 = true;
                    break;
                case 9:
                    z8 = true;
                    break;
                case 10:
                    z10 = true;
                    break;
                case 11:
                    z11 = true;
                    break;
            }
        }
        return new PermissionsModel(z, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, false, 2048, null);
    }
}
