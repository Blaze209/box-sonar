package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\u000e\b\u0001\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fHÆ\u0003J\u0099\u0001\u00106\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\r\u001a\u00020\u00032\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u000e\b\u0003\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fHÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$¨\u0006>"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "type", "", "mainIcon", "Lcom/box/android/data/api/models/inboxnotifications/AvatarDTO;", "subIcon", "Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "title", "Lcom/box/android/data/api/models/inboxnotifications/TextDTO;", "message", "status", "Lcom/box/android/data/api/models/inboxnotifications/StatusDTO;", "timestamp", "statusIcons", "", "cardAction", "Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;", "primaryAction", "secondaryAction", "menuActions", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/AvatarDTO;Lcom/box/android/data/api/models/inboxnotifications/IconDTO;Lcom/box/android/data/api/models/inboxnotifications/TextDTO;Lcom/box/android/data/api/models/inboxnotifications/TextDTO;Lcom/box/android/data/api/models/inboxnotifications/StatusDTO;Ljava/lang/String;Ljava/util/List;Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getMainIcon", "()Lcom/box/android/data/api/models/inboxnotifications/AvatarDTO;", "getSubIcon", "()Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "getTitle", "()Lcom/box/android/data/api/models/inboxnotifications/TextDTO;", "getMessage", "getStatus", "()Lcom/box/android/data/api/models/inboxnotifications/StatusDTO;", "getTimestamp", "getStatusIcons", "()Ljava/util/List;", "getCardAction", "()Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;", "getPrimaryAction", "getSecondaryAction", "getMenuActions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommonPayloadDTOInbox extends InboxNotificationPayloadDTO {
    private final ActionDTO cardAction;
    private final AvatarDTO mainIcon;
    private final List<ActionDTO> menuActions;
    private final TextDTO message;
    private final ActionDTO primaryAction;
    private final ActionDTO secondaryAction;
    private final StatusDTO status;
    private final List<IconDTO> statusIcons;
    private final IconDTO subIcon;
    private final String timestamp;
    private final TextDTO title;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonPayloadDTOInbox copy$default(CommonPayloadDTOInbox commonPayloadDTOInbox, String str, AvatarDTO avatarDTO, IconDTO iconDTO, TextDTO textDTO, TextDTO textDTO2, StatusDTO statusDTO, String str2, List list, ActionDTO actionDTO, ActionDTO actionDTO2, ActionDTO actionDTO3, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commonPayloadDTOInbox.type;
        }
        if ((i & 2) != 0) {
            avatarDTO = commonPayloadDTOInbox.mainIcon;
        }
        if ((i & 4) != 0) {
            iconDTO = commonPayloadDTOInbox.subIcon;
        }
        if ((i & 8) != 0) {
            textDTO = commonPayloadDTOInbox.title;
        }
        if ((i & 16) != 0) {
            textDTO2 = commonPayloadDTOInbox.message;
        }
        if ((i & 32) != 0) {
            statusDTO = commonPayloadDTOInbox.status;
        }
        if ((i & 64) != 0) {
            str2 = commonPayloadDTOInbox.timestamp;
        }
        if ((i & 128) != 0) {
            list = commonPayloadDTOInbox.statusIcons;
        }
        if ((i & 256) != 0) {
            actionDTO = commonPayloadDTOInbox.cardAction;
        }
        if ((i & 512) != 0) {
            actionDTO2 = commonPayloadDTOInbox.primaryAction;
        }
        if ((i & 1024) != 0) {
            actionDTO3 = commonPayloadDTOInbox.secondaryAction;
        }
        if ((i & 2048) != 0) {
            list2 = commonPayloadDTOInbox.menuActions;
        }
        ActionDTO actionDTO4 = actionDTO3;
        List list3 = list2;
        ActionDTO actionDTO5 = actionDTO;
        ActionDTO actionDTO6 = actionDTO2;
        String str3 = str2;
        List list4 = list;
        TextDTO textDTO3 = textDTO2;
        StatusDTO statusDTO2 = statusDTO;
        return commonPayloadDTOInbox.copy(str, avatarDTO, iconDTO, textDTO, textDTO3, statusDTO2, str3, list4, actionDTO5, actionDTO6, actionDTO4, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ActionDTO getPrimaryAction() {
        return this.primaryAction;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ActionDTO getSecondaryAction() {
        return this.secondaryAction;
    }

    public final List<ActionDTO> component12() {
        return this.menuActions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AvatarDTO getMainIcon() {
        return this.mainIcon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IconDTO getSubIcon() {
        return this.subIcon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final TextDTO getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextDTO getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StatusDTO getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    public final List<IconDTO> component8() {
        return this.statusIcons;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ActionDTO getCardAction() {
        return this.cardAction;
    }

    public final CommonPayloadDTOInbox copy(@Json(name = "type") String type, @Json(name = "main_icon") AvatarDTO mainIcon, @Json(name = "sub_icon") IconDTO subIcon, @Json(name = "title") TextDTO title, @Json(name = "message") TextDTO message, @Json(name = "status") StatusDTO status, @Json(name = "timestamp") String timestamp, @Json(name = "status_icons") List<IconDTO> statusIcons, @Json(name = "card_action") ActionDTO cardAction, @Json(name = "primary_action") ActionDTO primaryAction, @Json(name = "secondary_action") ActionDTO secondaryAction, @Json(name = "menu_actions") List<ActionDTO> menuActions) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mainIcon, "mainIcon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(statusIcons, "statusIcons");
        Intrinsics.checkNotNullParameter(menuActions, "menuActions");
        return new CommonPayloadDTOInbox(type, mainIcon, subIcon, title, message, status, timestamp, statusIcons, cardAction, primaryAction, secondaryAction, menuActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonPayloadDTOInbox)) {
            return false;
        }
        CommonPayloadDTOInbox commonPayloadDTOInbox = (CommonPayloadDTOInbox) other;
        return Intrinsics.areEqual(this.type, commonPayloadDTOInbox.type) && Intrinsics.areEqual(this.mainIcon, commonPayloadDTOInbox.mainIcon) && Intrinsics.areEqual(this.subIcon, commonPayloadDTOInbox.subIcon) && Intrinsics.areEqual(this.title, commonPayloadDTOInbox.title) && Intrinsics.areEqual(this.message, commonPayloadDTOInbox.message) && Intrinsics.areEqual(this.status, commonPayloadDTOInbox.status) && Intrinsics.areEqual(this.timestamp, commonPayloadDTOInbox.timestamp) && Intrinsics.areEqual(this.statusIcons, commonPayloadDTOInbox.statusIcons) && Intrinsics.areEqual(this.cardAction, commonPayloadDTOInbox.cardAction) && Intrinsics.areEqual(this.primaryAction, commonPayloadDTOInbox.primaryAction) && Intrinsics.areEqual(this.secondaryAction, commonPayloadDTOInbox.secondaryAction) && Intrinsics.areEqual(this.menuActions, commonPayloadDTOInbox.menuActions);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.mainIcon.hashCode()) * 31;
        IconDTO iconDTO = this.subIcon;
        int iHashCode2 = (((iHashCode + (iconDTO == null ? 0 : iconDTO.hashCode())) * 31) + this.title.hashCode()) * 31;
        TextDTO textDTO = this.message;
        int iHashCode3 = (iHashCode2 + (textDTO == null ? 0 : textDTO.hashCode())) * 31;
        StatusDTO statusDTO = this.status;
        int iHashCode4 = (((((iHashCode3 + (statusDTO == null ? 0 : statusDTO.hashCode())) * 31) + this.timestamp.hashCode()) * 31) + this.statusIcons.hashCode()) * 31;
        ActionDTO actionDTO = this.cardAction;
        int iHashCode5 = (iHashCode4 + (actionDTO == null ? 0 : actionDTO.hashCode())) * 31;
        ActionDTO actionDTO2 = this.primaryAction;
        int iHashCode6 = (iHashCode5 + (actionDTO2 == null ? 0 : actionDTO2.hashCode())) * 31;
        ActionDTO actionDTO3 = this.secondaryAction;
        return ((iHashCode6 + (actionDTO3 != null ? actionDTO3.hashCode() : 0)) * 31) + this.menuActions.hashCode();
    }

    public String toString() {
        return "CommonPayloadDTOInbox(type=" + this.type + ", mainIcon=" + this.mainIcon + ", subIcon=" + this.subIcon + ", title=" + this.title + ", message=" + this.message + ", status=" + this.status + ", timestamp=" + this.timestamp + ", statusIcons=" + this.statusIcons + ", cardAction=" + this.cardAction + ", primaryAction=" + this.primaryAction + ", secondaryAction=" + this.secondaryAction + ", menuActions=" + this.menuActions + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonPayloadDTOInbox(@Json(name = "type") String type, @Json(name = "main_icon") AvatarDTO mainIcon, @Json(name = "sub_icon") IconDTO iconDTO, @Json(name = "title") TextDTO title, @Json(name = "message") TextDTO textDTO, @Json(name = "status") StatusDTO statusDTO, @Json(name = "timestamp") String timestamp, @Json(name = "status_icons") List<IconDTO> statusIcons, @Json(name = "card_action") ActionDTO actionDTO, @Json(name = "primary_action") ActionDTO actionDTO2, @Json(name = "secondary_action") ActionDTO actionDTO3, @Json(name = "menu_actions") List<ActionDTO> menuActions) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mainIcon, "mainIcon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(statusIcons, "statusIcons");
        Intrinsics.checkNotNullParameter(menuActions, "menuActions");
        this.type = type;
        this.mainIcon = mainIcon;
        this.subIcon = iconDTO;
        this.title = title;
        this.message = textDTO;
        this.status = statusDTO;
        this.timestamp = timestamp;
        this.statusIcons = statusIcons;
        this.cardAction = actionDTO;
        this.primaryAction = actionDTO2;
        this.secondaryAction = actionDTO3;
        this.menuActions = menuActions;
    }

    @Override // com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadDTO
    public String getType() {
        return this.type;
    }

    public final AvatarDTO getMainIcon() {
        return this.mainIcon;
    }

    public final IconDTO getSubIcon() {
        return this.subIcon;
    }

    public final TextDTO getTitle() {
        return this.title;
    }

    public final TextDTO getMessage() {
        return this.message;
    }

    public final StatusDTO getStatus() {
        return this.status;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final List<IconDTO> getStatusIcons() {
        return this.statusIcons;
    }

    public final ActionDTO getCardAction() {
        return this.cardAction;
    }

    public final ActionDTO getPrimaryAction() {
        return this.primaryAction;
    }

    public final ActionDTO getSecondaryAction() {
        return this.secondaryAction;
    }

    public final List<ActionDTO> getMenuActions() {
        return this.menuActions;
    }
}
