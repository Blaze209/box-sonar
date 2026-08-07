package com.box.android.domain.services;

import com.box.android.domain.models.preview.PageFitMode;
import com.box.android.domain.models.preview.ScrollSettings;
import com.box.android.domain.models.preview.ScrollableFileType;
import kotlin.Metadata;

/* JADX INFO: compiled from: IPreviewSettingsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IPreviewSettingsService;", "", "setPageFitMode", "", "pageFitMode", "Lcom/box/android/domain/models/preview/PageFitMode;", "getPageFitMode", "setHorizontalScrolling", "scrollableFileType", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "setVerticalPageByPageScrolling", "setVerticalContinuousScrolling", "getPageScrollSettings", "Lcom/box/android/domain/models/preview/ScrollSettings;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPreviewSettingsService {
    PageFitMode getPageFitMode();

    ScrollSettings getPageScrollSettings(ScrollableFileType scrollableFileType);

    void setHorizontalScrolling(ScrollableFileType scrollableFileType);

    void setPageFitMode(PageFitMode pageFitMode);

    void setVerticalContinuousScrolling(ScrollableFileType scrollableFileType);

    void setVerticalPageByPageScrolling(ScrollableFileType scrollableFileType);
}
