package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/ActionHandlerModel;", "Lcom/box/android/domain/models/DomainModel;", "type", "", "uri", "actionId", "title", "Lcom/box/android/domain/models/inboxnotifications/TextModel;", "message", "actions", "", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/TextModel;Lcom/box/android/domain/models/inboxnotifications/TextModel;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getUri", "getActionId", "getTitle", "()Lcom/box/android/domain/models/inboxnotifications/TextModel;", "getMessage", "getActions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ActionHandlerModel implements DomainModel {
    private final String actionId;
    private final List<ActionModel> actions;
    private final TextModel message;
    private final TextModel title;
    private final String type;
    private final String uri;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionHandlerModel copy$default(ActionHandlerModel actionHandlerModel, String str, String str2, String str3, TextModel textModel, TextModel textModel2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionHandlerModel.type;
        }
        if ((i & 2) != 0) {
            str2 = actionHandlerModel.uri;
        }
        if ((i & 4) != 0) {
            str3 = actionHandlerModel.actionId;
        }
        if ((i & 8) != 0) {
            textModel = actionHandlerModel.title;
        }
        if ((i & 16) != 0) {
            textModel2 = actionHandlerModel.message;
        }
        if ((i & 32) != 0) {
            list = actionHandlerModel.actions;
        }
        TextModel textModel3 = textModel2;
        List list2 = list;
        return actionHandlerModel.copy(str, str2, str3, textModel, textModel3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final TextModel getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextModel getMessage() {
        return this.message;
    }

    public final List<ActionModel> component6() {
        return this.actions;
    }

    public final ActionHandlerModel copy(String type, String uri, String actionId, TextModel title, TextModel message, List<ActionModel> actions) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ActionHandlerModel(type, uri, actionId, title, message, actions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionHandlerModel)) {
            return false;
        }
        ActionHandlerModel actionHandlerModel = (ActionHandlerModel) other;
        return Intrinsics.areEqual(this.type, actionHandlerModel.type) && Intrinsics.areEqual(this.uri, actionHandlerModel.uri) && Intrinsics.areEqual(this.actionId, actionHandlerModel.actionId) && Intrinsics.areEqual(this.title, actionHandlerModel.title) && Intrinsics.areEqual(this.message, actionHandlerModel.message) && Intrinsics.areEqual(this.actions, actionHandlerModel.actions);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.uri;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.actionId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        TextModel textModel = this.title;
        int iHashCode4 = (iHashCode3 + (textModel == null ? 0 : textModel.hashCode())) * 31;
        TextModel textModel2 = this.message;
        int iHashCode5 = (iHashCode4 + (textModel2 == null ? 0 : textModel2.hashCode())) * 31;
        List<ActionModel> list = this.actions;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ActionHandlerModel(type=" + this.type + ", uri=" + this.uri + ", actionId=" + this.actionId + ", title=" + this.title + ", message=" + this.message + ", actions=" + this.actions + ")";
    }

    public ActionHandlerModel(String type, String str, String str2, TextModel textModel, TextModel textModel2, List<ActionModel> list) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.uri = str;
        this.actionId = str2;
        this.title = textModel;
        this.message = textModel2;
        this.actions = list;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final TextModel getTitle() {
        return this.title;
    }

    public final TextModel getMessage() {
        return this.message;
    }

    public final List<ActionModel> getActions() {
        return this.actions;
    }
}
