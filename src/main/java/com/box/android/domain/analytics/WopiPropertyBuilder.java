package com.box.android.domain.analytics;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WopiPropertyBuilder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/analytics/WopiPropertyBuilder;", "", "eventPropertyBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$EventPropertyBuilder;", "<init>", "(Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$EventPropertyBuilder;)V", "getEventPropertyBuilder", "()Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$EventPropertyBuilder;", "logOpenWithWopiAttempted", "", "setFileExtension", "fileExtension", "", "setServiceId", "serviceID", "setIsFileEditable", "isEditable", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WopiPropertyBuilder {
    public static final String FILE_EXT_PROPERTY = "fileExt";
    public static final String IS_FILE_EDITABLE_PROPERTY = "canEdit";
    public static final String PREVIEW_BY_WOPI = "preview by wopi";
    public static final String SERVICE_ID_PROPERTY = "wopiServiceID";
    private final BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilder;

    @Inject
    public WopiPropertyBuilder(BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilder) {
        Intrinsics.checkNotNullParameter(eventPropertyBuilder, "eventPropertyBuilder");
        this.eventPropertyBuilder = eventPropertyBuilder;
    }

    public final BoxAmplitudeAnalytics.EventPropertyBuilder getEventPropertyBuilder() {
        return this.eventPropertyBuilder;
    }

    public final void logOpenWithWopiAttempted() {
        this.eventPropertyBuilder.logEvent(PREVIEW_BY_WOPI);
    }

    public final WopiPropertyBuilder setFileExtension(String fileExtension) {
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        this.eventPropertyBuilder.setProperty(FILE_EXT_PROPERTY, fileExtension);
        return this;
    }

    public final WopiPropertyBuilder setServiceId(String serviceID) {
        Intrinsics.checkNotNullParameter(serviceID, "serviceID");
        this.eventPropertyBuilder.setProperty(SERVICE_ID_PROPERTY, serviceID);
        return this;
    }

    public final WopiPropertyBuilder setIsFileEditable(boolean isEditable) {
        this.eventPropertyBuilder.setProperty(IS_FILE_EDITABLE_PROPERTY, Boolean.valueOf(isEditable));
        return this;
    }
}
