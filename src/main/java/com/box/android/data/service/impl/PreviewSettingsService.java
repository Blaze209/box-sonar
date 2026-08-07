package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.preview.PageFitMode;
import com.box.android.domain.models.preview.PageScrollDirection;
import com.box.android.domain.models.preview.PageScrollMode;
import com.box.android.domain.models.preview.ScrollSettings;
import com.box.android.domain.models.preview.ScrollableFileType;
import com.box.android.domain.services.IPreviewSettingsService;
import com.box.android.observability.DiagnosisParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PreviewSettingsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/service/impl/PreviewSettingsService;", "Lcom/box/android/domain/services/IPreviewSettingsService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "setPageFitMode", "", "pageFitMode", "Lcom/box/android/domain/models/preview/PageFitMode;", "getPageFitMode", "setHorizontalScrolling", "scrollableFileType", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "setVerticalPageByPageScrolling", "setVerticalContinuousScrolling", "getPageScrollSettings", "Lcom/box/android/domain/models/preview/ScrollSettings;", "getPageScrollingDirection", "Lcom/box/android/domain/models/preview/PageScrollDirection;", "getPageScrollingMode", "Lcom/box/android/domain/models/preview/PageScrollMode;", "setPageScrollingDirection", "direction", "setPageScrollingMode", DiagnosisParams.DIAGNOSIS_MODE, "getSharedPreferencesScrollingModeKey", "", "getSharedPreferencesScrollingDirectionKey", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewSettingsService implements IPreviewSettingsService {
    private static final PageFitMode DEFAULT_PAGE_FIT_MODE = PageFitMode.FIT_TO_WIDTH;
    private static final PageScrollDirection DEFAULT_SCROLLING_DIRECTION = PageScrollDirection.VERTICAL;
    private static final PageScrollMode DEFAULT_SCROLLING_MODE = PageScrollMode.PER_PAGE;
    public static final String SHARED_PREF_PAGE_FIT_MODE_KEY = "sharedPrefPageFitModeKey";
    public static final String SHARED_PREF_PREVIEW_PDF_PAGE_SCROLLING_DIRECTION = "sharedPrefPreviewPdfPageScrollingDirection";
    public static final String SHARED_PREF_PREVIEW_PDF_PAGE_SCROLLING_MODE = "sharedPrefPreviewPdfPageScrollingMode";
    public static final String SHARED_PREF_PREVIEW_POWERPOINT_PAGE_SCROLLING_DIRECTION = "sharedPrefPreviewPowerPointPageScrollingDirection";
    public static final String SHARED_PREF_PREVIEW_POWERPOINT_PAGE_SCROLLING_MODE = "sharedPrefPreviewPowerPointPageScrollingMode";
    public static final String SHARED_PREF_PREVIEW_WORD_PAGE_SCROLLING_DIRECTION = "sharedPrefPreviewWordPageScrollingDirection";
    public static final String SHARED_PREF_PREVIEW_WORD_PAGE_SCROLLING_MODE = "sharedPrefPreviewWordPageScrollingMode";
    private final IUserContextManager userContextManager;

    /* JADX INFO: compiled from: PreviewSettingsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScrollableFileType.values().length];
            try {
                iArr[ScrollableFileType.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScrollableFileType.POWERPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScrollableFileType.WORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public PreviewSettingsService(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    @Override // com.box.android.domain.services.IPreviewSettingsService
    public void setPageFitMode(PageFitMode pageFitMode) {
        Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs();
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
        editorEdit.putString(SHARED_PREF_PAGE_FIT_MODE_KEY, pageFitMode.name());
        editorEdit.commit();
    }

    @Override // com.box.android.domain.services.IPreviewSettingsService
    public PageFitMode getPageFitMode() {
        PageFitMode pageFitMode;
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs();
        PageFitMode pageFitMode2 = DEFAULT_PAGE_FIT_MODE;
        String string = userSharedPrefs.getString(SHARED_PREF_PAGE_FIT_MODE_KEY, pageFitMode2.name());
        PageFitMode pageFitMode3 = pageFitMode2;
        PageFitMode[] pageFitModeArrValues = PageFitMode.values();
        int length = pageFitModeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                pageFitMode = null;
                break;
            }
            pageFitMode = pageFitModeArrValues[i];
            if (StringsKt.equals(pageFitMode.name(), string, true)) {
                break;
            }
            i++;
        }
        PageFitMode pageFitMode4 = pageFitMode;
        if (pageFitMode4 != null) {
            pageFitMode3 = pageFitMode4;
        }
        return pageFitMode3;
    }

    @Override // com.box.android.domain.services.IPreviewSettingsService
    public void setHorizontalScrolling(ScrollableFileType scrollableFileType) {
        Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
        setPageScrollingDirection(scrollableFileType, PageScrollDirection.HORIZONTAL);
        setPageScrollingMode(scrollableFileType, PageScrollMode.PER_PAGE);
    }

    @Override // com.box.android.domain.services.IPreviewSettingsService
    public void setVerticalPageByPageScrolling(ScrollableFileType scrollableFileType) {
        Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
        setPageScrollingDirection(scrollableFileType, PageScrollDirection.VERTICAL);
        setPageScrollingMode(scrollableFileType, PageScrollMode.PER_PAGE);
    }

    @Override // com.box.android.domain.services.IPreviewSettingsService
    public void setVerticalContinuousScrolling(ScrollableFileType scrollableFileType) {
        Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
        setPageScrollingDirection(scrollableFileType, PageScrollDirection.VERTICAL);
        setPageScrollingMode(scrollableFileType, PageScrollMode.CONTINUOUS);
    }

    @Override // com.box.android.domain.services.IPreviewSettingsService
    public ScrollSettings getPageScrollSettings(ScrollableFileType scrollableFileType) {
        Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
        return new ScrollSettings(getPageScrollingMode(scrollableFileType), getPageScrollingDirection(scrollableFileType));
    }

    private final PageScrollDirection getPageScrollingDirection(ScrollableFileType scrollableFileType) {
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs();
        String sharedPreferencesScrollingDirectionKey = getSharedPreferencesScrollingDirectionKey(scrollableFileType);
        PageScrollDirection pageScrollDirection = DEFAULT_SCROLLING_DIRECTION;
        String string = userSharedPrefs.getString(sharedPreferencesScrollingDirectionKey, pageScrollDirection.name());
        if (string == null) {
            return pageScrollDirection;
        }
        try {
            return PageScrollDirection.valueOf(string);
        } catch (IllegalArgumentException unused) {
            return DEFAULT_SCROLLING_DIRECTION;
        }
    }

    private final PageScrollMode getPageScrollingMode(ScrollableFileType scrollableFileType) {
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs();
        String sharedPreferencesScrollingModeKey = getSharedPreferencesScrollingModeKey(scrollableFileType);
        PageScrollMode pageScrollMode = DEFAULT_SCROLLING_MODE;
        String string = userSharedPrefs.getString(sharedPreferencesScrollingModeKey, pageScrollMode.name());
        if (string == null) {
            return pageScrollMode;
        }
        try {
            return PageScrollMode.valueOf(string);
        } catch (IllegalArgumentException unused) {
            return DEFAULT_SCROLLING_MODE;
        }
    }

    private final void setPageScrollingDirection(ScrollableFileType scrollableFileType, PageScrollDirection direction) {
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs();
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
        editorEdit.putString(getSharedPreferencesScrollingDirectionKey(scrollableFileType), direction.name());
        editorEdit.commit();
    }

    private final void setPageScrollingMode(ScrollableFileType scrollableFileType, PageScrollMode mode) {
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs();
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
        editorEdit.putString(getSharedPreferencesScrollingModeKey(scrollableFileType), mode.name());
        editorEdit.commit();
    }

    private final String getSharedPreferencesScrollingModeKey(ScrollableFileType scrollableFileType) {
        int i = WhenMappings.$EnumSwitchMapping$0[scrollableFileType.ordinal()];
        if (i == 1) {
            return SHARED_PREF_PREVIEW_PDF_PAGE_SCROLLING_MODE;
        }
        if (i == 2) {
            return SHARED_PREF_PREVIEW_POWERPOINT_PAGE_SCROLLING_MODE;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return SHARED_PREF_PREVIEW_WORD_PAGE_SCROLLING_MODE;
    }

    private final String getSharedPreferencesScrollingDirectionKey(ScrollableFileType scrollableFileType) {
        int i = WhenMappings.$EnumSwitchMapping$0[scrollableFileType.ordinal()];
        if (i == 1) {
            return SHARED_PREF_PREVIEW_PDF_PAGE_SCROLLING_DIRECTION;
        }
        if (i == 2) {
            return SHARED_PREF_PREVIEW_POWERPOINT_PAGE_SCROLLING_DIRECTION;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return SHARED_PREF_PREVIEW_WORD_PAGE_SCROLLING_DIRECTION;
    }
}
