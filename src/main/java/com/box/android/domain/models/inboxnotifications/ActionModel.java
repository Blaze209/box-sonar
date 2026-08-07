package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "Lcom/box/android/domain/models/DomainModel;", "type", "", "focus", "", HubsObservability.HUB_ASSET_ICON, "Lcom/box/android/domain/models/inboxnotifications/IconModel;", "value", "styleLevel", "Lcom/box/android/domain/models/inboxnotifications/ActionStyleLevel;", "actionHandler", "Lcom/box/android/domain/models/inboxnotifications/ActionHandlerModel;", "<init>", "(Ljava/lang/String;ZLcom/box/android/domain/models/inboxnotifications/IconModel;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/ActionStyleLevel;Lcom/box/android/domain/models/inboxnotifications/ActionHandlerModel;)V", "getType", "()Ljava/lang/String;", "getFocus", "()Z", "getIcon", "()Lcom/box/android/domain/models/inboxnotifications/IconModel;", "getValue", "getStyleLevel", "()Lcom/box/android/domain/models/inboxnotifications/ActionStyleLevel;", "getActionHandler", "()Lcom/box/android/domain/models/inboxnotifications/ActionHandlerModel;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ActionModel implements DomainModel {
    private final ActionHandlerModel actionHandler;
    private final boolean focus;
    private final IconModel icon;
    private final ActionStyleLevel styleLevel;
    private final String type;
    private final String value;

    public static /* synthetic */ ActionModel copy$default(ActionModel actionModel, String str, boolean z, IconModel iconModel, String str2, ActionStyleLevel actionStyleLevel, ActionHandlerModel actionHandlerModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionModel.type;
        }
        if ((i & 2) != 0) {
            z = actionModel.focus;
        }
        if ((i & 4) != 0) {
            iconModel = actionModel.icon;
        }
        if ((i & 8) != 0) {
            str2 = actionModel.value;
        }
        if ((i & 16) != 0) {
            actionStyleLevel = actionModel.styleLevel;
        }
        if ((i & 32) != 0) {
            actionHandlerModel = actionModel.actionHandler;
        }
        ActionStyleLevel actionStyleLevel2 = actionStyleLevel;
        ActionHandlerModel actionHandlerModel2 = actionHandlerModel;
        return actionModel.copy(str, z, iconModel, str2, actionStyleLevel2, actionHandlerModel2);
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
    public final IconModel getIcon() {
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
    public final ActionHandlerModel getActionHandler() {
        return this.actionHandler;
    }

    public final ActionModel copy(String type, boolean focus, IconModel icon, String value, ActionStyleLevel styleLevel, ActionHandlerModel actionHandler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(styleLevel, "styleLevel");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        return new ActionModel(type, focus, icon, value, styleLevel, actionHandler);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionModel)) {
            return false;
        }
        ActionModel actionModel = (ActionModel) other;
        return Intrinsics.areEqual(this.type, actionModel.type) && this.focus == actionModel.focus && Intrinsics.areEqual(this.icon, actionModel.icon) && Intrinsics.areEqual(this.value, actionModel.value) && this.styleLevel == actionModel.styleLevel && Intrinsics.areEqual(this.actionHandler, actionModel.actionHandler);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + Boolean.hashCode(this.focus)) * 31;
        IconModel iconModel = this.icon;
        int iHashCode2 = (iHashCode + (iconModel == null ? 0 : iconModel.hashCode())) * 31;
        String str = this.value;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.styleLevel.hashCode()) * 31) + this.actionHandler.hashCode();
    }

    public String toString() {
        return "ActionModel(type=" + this.type + ", focus=" + this.focus + ", icon=" + this.icon + ", value=" + this.value + ", styleLevel=" + this.styleLevel + ", actionHandler=" + this.actionHandler + ")";
    }

    public ActionModel(String type, boolean z, IconModel iconModel, String str, ActionStyleLevel styleLevel, ActionHandlerModel actionHandler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(styleLevel, "styleLevel");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.type = type;
        this.focus = z;
        this.icon = iconModel;
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

    public final IconModel getIcon() {
        return this.icon;
    }

    public final String getValue() {
        return this.value;
    }

    public final ActionStyleLevel getStyleLevel() {
        return this.styleLevel;
    }

    public final ActionHandlerModel getActionHandler() {
        return this.actionHandler;
    }
}
