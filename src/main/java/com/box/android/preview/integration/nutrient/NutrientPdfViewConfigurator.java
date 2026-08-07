package com.box.android.preview.integration.nutrient;

import android.content.Context;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.preview.previewtype.document.PdfPreviewConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.activity.TabBarHidingMode;
import com.pspdfkit.configuration.activity.UserInterfaceViewMode;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.configuration.page.PageLayoutMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NutrientPdfViewConfigurator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/integration/nutrient/NutrientPdfViewConfigurator;", "", "<init>", "()V", "createPdfActivityConfiguration", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "context", "Landroid/content/Context;", "pdfPreviewConfiguration", "Lcom/box/android/preview/previewtype/document/PdfPreviewConfiguration;", "pageFitMode", "Lcom/pspdfkit/configuration/page/PageFitMode;", "isEnvironmentSetUp", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NutrientPdfViewConfigurator {
    public static final int $stable = 0;
    public static final NutrientPdfViewConfigurator INSTANCE = new NutrientPdfViewConfigurator();

    private NutrientPdfViewConfigurator() {
    }

    public final PdfActivityConfiguration createPdfActivityConfiguration(Context context, PdfPreviewConfiguration pdfPreviewConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pdfPreviewConfiguration, "pdfPreviewConfiguration");
        return new PdfActivityConfiguration.Builder(createPdfActivityConfiguration(context, pdfPreviewConfiguration.getPageFitMode())).scrollDirection(pdfPreviewConfiguration.getPageScrollDirection()).scrollMode(pdfPreviewConfiguration.getPageScrollMode()).textSelectionEnabled(pdfPreviewConfiguration.isMobileCopyPasteEnabled()).build();
    }

    public static /* synthetic */ PdfActivityConfiguration createPdfActivityConfiguration$default(NutrientPdfViewConfigurator nutrientPdfViewConfigurator, Context context, PageFitMode pageFitMode, int i, Object obj) {
        if ((i & 2) != 0) {
            pageFitMode = PageFitMode.FIT_TO_WIDTH;
        }
        return nutrientPdfViewConfigurator.createPdfActivityConfiguration(context, pageFitMode);
    }

    public final PdfActivityConfiguration createPdfActivityConfiguration(Context context, PageFitMode pageFitMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
        return new PdfActivityConfiguration.Builder(context).setUserInterfaceViewMode(UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_HIDDEN).annotationListEnabled(false).layoutMode(PageLayoutMode.SINGLE).restoreLastViewedPage(false).scrollbarsEnabled(false).defaultToolbarEnabled(false).copyPastEnabled(false).pageNumberOverlayEnabled(false).textSelectionPopupToolbarEnabled(false).loadingProgressDrawable(null).autosaveEnabled(false).printingEnabled(true).setTabBarHidingMode(TabBarHidingMode.HIDE).fitMode(pageFitMode).immersiveModeEnabled(false).build();
    }

    public final boolean isEnvironmentSetUp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context instanceof BoxFragmentActivity;
    }
}
