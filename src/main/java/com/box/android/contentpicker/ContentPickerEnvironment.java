package com.box.android.contentpicker;

import com.box.android.base.presentation.multiselect.SelectionManager;
import com.box.android.domain.services.IClientSettingsService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentPickerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerEnvironment;", "", "selectionManager", "Lcom/box/android/base/presentation/multiselect/SelectionManager;", "clientSettingsService", "Lcom/box/android/domain/services/IClientSettingsService;", "contentPickerAnalytics", "Lcom/box/android/contentpicker/ContentPickerAnalytics;", "<init>", "(Lcom/box/android/base/presentation/multiselect/SelectionManager;Lcom/box/android/domain/services/IClientSettingsService;Lcom/box/android/contentpicker/ContentPickerAnalytics;)V", "getSelectionManager", "()Lcom/box/android/base/presentation/multiselect/SelectionManager;", "getClientSettingsService", "()Lcom/box/android/domain/services/IClientSettingsService;", "getContentPickerAnalytics", "()Lcom/box/android/contentpicker/ContentPickerAnalytics;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContentPickerEnvironment {
    public static final int $stable = 8;
    private final IClientSettingsService clientSettingsService;
    private final ContentPickerAnalytics contentPickerAnalytics;
    private final SelectionManager selectionManager;

    @Inject
    public ContentPickerEnvironment(SelectionManager selectionManager, IClientSettingsService clientSettingsService, ContentPickerAnalytics contentPickerAnalytics) {
        Intrinsics.checkNotNullParameter(selectionManager, "selectionManager");
        Intrinsics.checkNotNullParameter(clientSettingsService, "clientSettingsService");
        Intrinsics.checkNotNullParameter(contentPickerAnalytics, "contentPickerAnalytics");
        this.selectionManager = selectionManager;
        this.clientSettingsService = clientSettingsService;
        this.contentPickerAnalytics = contentPickerAnalytics;
    }

    public final SelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final IClientSettingsService getClientSettingsService() {
        return this.clientSettingsService;
    }

    public final ContentPickerAnalytics getContentPickerAnalytics() {
        return this.contentPickerAnalytics;
    }
}
