package com.box.android.preview.integration.nutrient;

import com.box.android.domain.models.preview.PageFitMode;
import com.box.android.domain.models.preview.PageScrollDirection;
import com.box.android.domain.models.preview.PageScrollMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NutrientPdfConfigMapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, d2 = {"toPSPDFKitPageFitMode", "Lcom/pspdfkit/configuration/page/PageFitMode;", "Lcom/box/android/domain/models/preview/PageFitMode;", "toPSPDFKitDirection", "Lcom/pspdfkit/configuration/page/PageScrollDirection;", "Lcom/box/android/domain/models/preview/PageScrollDirection;", "toPSPDFKitMode", "Lcom/pspdfkit/configuration/page/PageScrollMode;", "Lcom/box/android/domain/models/preview/PageScrollMode;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NutrientPdfConfigMapperKt {

    /* JADX INFO: compiled from: NutrientPdfConfigMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[PageFitMode.values().length];
            try {
                iArr[PageFitMode.FIT_TO_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageFitMode.FIT_TO_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PageScrollDirection.values().length];
            try {
                iArr2[PageScrollDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PageScrollDirection.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PageScrollMode.values().length];
            try {
                iArr3[PageScrollMode.PER_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[PageScrollMode.CONTINUOUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final com.pspdfkit.configuration.page.PageFitMode toPSPDFKitPageFitMode(PageFitMode pageFitMode) {
        Intrinsics.checkNotNullParameter(pageFitMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[pageFitMode.ordinal()];
        if (i == 1) {
            return com.pspdfkit.configuration.page.PageFitMode.FIT_TO_WIDTH;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return com.pspdfkit.configuration.page.PageFitMode.FIT_TO_SCREEN;
    }

    public static final com.pspdfkit.configuration.page.PageScrollDirection toPSPDFKitDirection(PageScrollDirection pageScrollDirection) {
        Intrinsics.checkNotNullParameter(pageScrollDirection, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[pageScrollDirection.ordinal()];
        if (i == 1) {
            return com.pspdfkit.configuration.page.PageScrollDirection.HORIZONTAL;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return com.pspdfkit.configuration.page.PageScrollDirection.VERTICAL;
    }

    public static final com.pspdfkit.configuration.page.PageScrollMode toPSPDFKitMode(PageScrollMode pageScrollMode) {
        Intrinsics.checkNotNullParameter(pageScrollMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$2[pageScrollMode.ordinal()];
        if (i == 1) {
            return com.pspdfkit.configuration.page.PageScrollMode.PER_PAGE;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return com.pspdfkit.configuration.page.PageScrollMode.CONTINUOUS;
    }
}
