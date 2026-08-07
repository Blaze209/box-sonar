package com.box.androidsdk.content.models;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxLock.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000e¨\u0006\u0011"}, d2 = {"Lcom/box/androidsdk/content/models/BoxLock;", "Lcom/box/androidsdk/content/models/BoxJsonObject;", "<init>", "()V", "getType", "", "getAppType", "getId", "getCreator", "Lcom/box/androidsdk/content/models/BoxUser;", "getCreatedAt", "Ljava/util/Date;", "getExpiresAt", "isDownloadPrevented", "", "isInWOPICoauthoringSession", "Companion", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxLock extends BoxJsonObject {
    private static final String APP_TYPE = "app_type";
    private static final String APP_TYPE_WOPI = "office_wopi";
    private static final String CREATED_AT = "created_at";
    private static final String CREATED_BY = "created_by";
    private static final String EXPIRES_AT = "expires_at";
    private static final String ID = "id";
    private static final String IS_DOWNLOAD_PREVENTED = "is_download_prevented";
    private static final String TYPE = "lock";

    public final String getType() {
        String propertyAsString = getPropertyAsString("lock");
        Intrinsics.checkNotNullExpressionValue(propertyAsString, "getPropertyAsString(...)");
        return propertyAsString;
    }

    public final String getAppType() {
        return getPropertyAsString(APP_TYPE);
    }

    public final String getId() {
        String propertyAsString = getPropertyAsString("id");
        Intrinsics.checkNotNullExpressionValue(propertyAsString, "getPropertyAsString(...)");
        return propertyAsString;
    }

    public final BoxUser getCreator() {
        BoxJsonObject propertyAsJsonObject = getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxUser.class), "created_by");
        Intrinsics.checkNotNullExpressionValue(propertyAsJsonObject, "getPropertyAsJsonObject(...)");
        return (BoxUser) propertyAsJsonObject;
    }

    public final Date getCreatedAt() {
        Date propertyAsDate = getPropertyAsDate("created_at");
        Intrinsics.checkNotNullExpressionValue(propertyAsDate, "getPropertyAsDate(...)");
        return propertyAsDate;
    }

    public final Date getExpiresAt() {
        return getPropertyAsDate("expires_at");
    }

    public final boolean isDownloadPrevented() {
        Boolean propertyAsBoolean = getPropertyAsBoolean(IS_DOWNLOAD_PREVENTED);
        Intrinsics.checkNotNullExpressionValue(propertyAsBoolean, "getPropertyAsBoolean(...)");
        return propertyAsBoolean.booleanValue();
    }

    public final boolean isInWOPICoauthoringSession() {
        String propertyAsString = getPropertyAsString(APP_TYPE);
        if (propertyAsString != null) {
            return propertyAsString.equals(APP_TYPE_WOPI);
        }
        return false;
    }
}
