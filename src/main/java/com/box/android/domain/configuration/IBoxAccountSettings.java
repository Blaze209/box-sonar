package com.box.android.domain.configuration;

import kotlin.Metadata;

/* JADX INFO: compiled from: IBoxAccountSettings.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/configuration/IBoxAccountSettings;", "", "isAnnotationsViewingEnabled", "", "isAnnotationsCreationEnabled", "isBoxAiEnabled", "isBoxAiStudioEnabled", "isBoxAiNotesEnabled", "isBoxAiMultidocEnabled", "isHubsGalleryEnabled", "isAxCenterEnabled", "isIntuneManaged", "isEMMMode", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBoxAccountSettings {
    boolean isAnnotationsCreationEnabled();

    boolean isAnnotationsViewingEnabled();

    boolean isAxCenterEnabled();

    boolean isBoxAiEnabled();

    boolean isBoxAiMultidocEnabled();

    boolean isBoxAiNotesEnabled();

    boolean isBoxAiStudioEnabled();

    boolean isEMMMode();

    boolean isHubsGalleryEnabled();

    boolean isIntuneManaged();
}
