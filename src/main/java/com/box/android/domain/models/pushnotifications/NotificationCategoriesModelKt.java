package com.box.android.domain.models.pushnotifications;

import com.box.androidsdk.content.requests.BoxRequestEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationCategoriesModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007¨\u0006\b"}, d2 = {"isCategoryEnabled", "", "Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "category", "Lcom/box/android/domain/models/pushnotifications/NotificationCategory;", "copyWithChanges", BoxRequestEvent.STREAM_TYPE_CHANGES, "", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotificationCategoriesModelKt {

    /* JADX INFO: compiled from: NotificationCategoriesModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationCategory.values().length];
            try {
                iArr[NotificationCategory.SHARING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationCategory.MENTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotificationCategory.TASKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NotificationCategory.RELEVANT_UPDATES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NotificationCategory.COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NotificationCategory.COLLABORATION_INVITE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[NotificationCategory.EDIT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[NotificationCategory.UPLOAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isCategoryEnabled(NotificationCategoriesModel notificationCategoriesModel, NotificationCategory category) {
        Intrinsics.checkNotNullParameter(notificationCategoriesModel, "<this>");
        Intrinsics.checkNotNullParameter(category, "category");
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                return notificationCategoriesModel.getSharing();
            case 2:
                return notificationCategoriesModel.getMentions();
            case 3:
                return notificationCategoriesModel.getTasks();
            case 4:
                return notificationCategoriesModel.getRelevantUpdates();
            case 5:
                return notificationCategoriesModel.getComment();
            case 6:
                return notificationCategoriesModel.getCollaborationInvite();
            case 7:
                return notificationCategoriesModel.getEdit();
            case 8:
                return notificationCategoriesModel.getUpload();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final NotificationCategoriesModel copyWithChanges(NotificationCategoriesModel notificationCategoriesModel, Map<NotificationCategory, Boolean> changes) {
        Intrinsics.checkNotNullParameter(notificationCategoriesModel, "<this>");
        Intrinsics.checkNotNullParameter(changes, "changes");
        Boolean bool = changes.get(NotificationCategory.SHARING);
        boolean zBooleanValue = bool != null ? bool.booleanValue() : notificationCategoriesModel.getSharing();
        Boolean bool2 = changes.get(NotificationCategory.MENTIONS);
        boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : notificationCategoriesModel.getMentions();
        Boolean bool3 = changes.get(NotificationCategory.TASKS);
        boolean zBooleanValue3 = bool3 != null ? bool3.booleanValue() : notificationCategoriesModel.getTasks();
        Boolean bool4 = changes.get(NotificationCategory.RELEVANT_UPDATES);
        boolean zBooleanValue4 = bool4 != null ? bool4.booleanValue() : notificationCategoriesModel.getRelevantUpdates();
        Boolean bool5 = changes.get(NotificationCategory.COMMENT);
        boolean zBooleanValue5 = bool5 != null ? bool5.booleanValue() : notificationCategoriesModel.getComment();
        Boolean bool6 = changes.get(NotificationCategory.COLLABORATION_INVITE);
        boolean zBooleanValue6 = bool6 != null ? bool6.booleanValue() : notificationCategoriesModel.getCollaborationInvite();
        Boolean bool7 = changes.get(NotificationCategory.EDIT);
        boolean zBooleanValue7 = bool7 != null ? bool7.booleanValue() : notificationCategoriesModel.getEdit();
        Boolean bool8 = changes.get(NotificationCategory.UPLOAD);
        return new NotificationCategoriesModel(zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, zBooleanValue6, zBooleanValue7, bool8 != null ? bool8.booleanValue() : notificationCategoriesModel.getUpload());
    }
}
