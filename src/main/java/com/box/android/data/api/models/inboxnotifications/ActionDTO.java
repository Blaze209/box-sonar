package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.models.inboxnotifications.ActionStyleLevel;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;", "", "type", "", "focus", "", HubsObservability.HUB_ASSET_ICON, "Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "value", "styleLevel", "Lcom/box/android/domain/models/inboxnotifications/ActionStyleLevel;", "actionHandler", "Lcom/box/android/data/api/models/inboxnotifications/ActionHandlerDTO;", "<init>", "(Ljava/lang/String;ZLcom/box/android/data/api/models/inboxnotifications/IconDTO;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/ActionStyleLevel;Lcom/box/android/data/api/models/inboxnotifications/ActionHandlerDTO;)V", "getType", "()Ljava/lang/String;", "getFocus", "()Z", "getIcon", "()Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "getValue", "getStyleLevel", "()Lcom/box/android/domain/models/inboxnotifications/ActionStyleLevel;", "getActionHandler", "()Lcom/box/android/data/api/models/inboxnotifications/ActionHandlerDTO;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ActionDTO {
    private final ActionHandlerDTO actionHandler;
    private final boolean focus;
    private final IconDTO icon;
    private final ActionStyleLevel styleLevel;
    private final String type;
    private final String value;

    public static /* synthetic */ ActionDTO copy$default(ActionDTO actionDTO, String str, boolean z, IconDTO iconDTO, String str2, ActionStyleLevel actionStyleLevel, ActionHandlerDTO actionHandlerDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionDTO.type;
        }
        if ((i & 2) != 0) {
            z = actionDTO.focus;
        }
        if ((i & 4) != 0) {
            iconDTO = actionDTO.icon;
        }
        if ((i & 8) != 0) {
            str2 = actionDTO.value;
        }
        if ((i & 16) != 0) {
            actionStyleLevel = actionDTO.styleLevel;
        }
        if ((i & 32) != 0) {
            actionHandlerDTO = actionDTO.actionHandler;
        }
        ActionStyleLevel actionStyleLevel2 = actionStyleLevel;
        ActionHandlerDTO actionHandlerDTO2 = actionHandlerDTO;
        return actionDTO.copy(str, z, iconDTO, str2, actionStyleLevel2, actionHandlerDTO2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getFocus() {
        return this.focus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IconDTO getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ActionStyleLevel getStyleLevel() {
        return this.styleLevel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ActionHandlerDTO getActionHandler() {
        return this.actionHandler;
    }

    public final ActionDTO copy(@Json(name = "type") String type, @Json(name = "focus") boolean focus, @Json(name = HubsObservability.HUB_ASSET_ICON) IconDTO icon, @Json(name = "value") String value, @Json(name = "style_level") ActionStyleLevel styleLevel, @Json(name = "action_handler") ActionHandlerDTO actionHandler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(styleLevel, "styleLevel");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        return new ActionDTO(type, focus, icon, value, styleLevel, actionHandler);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionDTO)) {
            return false;
        }
        ActionDTO actionDTO = (ActionDTO) other;
        return Intrinsics.areEqual(this.type, actionDTO.type) && this.focus == actionDTO.focus && Intrinsics.areEqual(this.icon, actionDTO.icon) && Intrinsics.areEqual(this.value, actionDTO.value) && this.styleLevel == actionDTO.styleLevel && Intrinsics.areEqual(this.actionHandler, actionDTO.actionHandler);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + Boolean.hashCode(this.focus)) * 31;
        IconDTO iconDTO = this.icon;
        int iHashCode2 = (iHashCode + (iconDTO == null ? 0 : iconDTO.hashCode())) * 31;
        String str = this.value;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.styleLevel.hashCode()) * 31) + this.actionHandler.hashCode();
    }

    public String toString() {
        return "ActionDTO(type=" + this.type + ", focus=" + this.focus + ", icon=" + this.icon + ", value=" + this.value + ", styleLevel=" + this.styleLevel + ", actionHandler=" + this.actionHandler + ")";
    }

    public ActionDTO(@Json(name = "type") String type, @Json(name = "focus") boolean z, @Json(name = HubsObservability.HUB_ASSET_ICON) IconDTO iconDTO, @Json(name = "value") String str, @Json(name = "style_level") ActionStyleLevel styleLevel, @Json(name = "action_handler") ActionHandlerDTO actionHandler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(styleLevel, "styleLevel");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.type = type;
        this.focus = z;
        this.icon = iconDTO;
        this.value = str;
        this.styleLevel = styleLevel;
        this.actionHandler = actionHandler;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getFocus() {
        return this.focus;
    }

    public final IconDTO getIcon() {
        return this.icon;
    }

    public final String getValue() {
        return this.value;
    }

    public final ActionStyleLevel getStyleLevel() {
        return this.styleLevel;
    }

    public final ActionHandlerDTO getActionHandler() {
        return this.actionHandler;
    }
}
