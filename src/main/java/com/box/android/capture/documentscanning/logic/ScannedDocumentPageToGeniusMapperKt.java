package com.box.android.capture.documentscanning.logic;

import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.geniusscansdk.core.FilterConfiguration;
import com.geniusscansdk.core.Quadrangle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedDocumentPageToGeniusMapper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006\u001a\f\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u0005¨\u0006\b"}, d2 = {"toQuadrangle", "Lcom/geniusscansdk/core/Quadrangle;", "Lcom/box/android/domain/models/DocumentPosition;", "toDocumentPosition", "toFilterConfiguration", "Lcom/geniusscansdk/core/FilterConfiguration;", "Lcom/box/android/domain/models/DocumentPageFilterType;", "toDocumentPageFilterType", "capture_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ScannedDocumentPageToGeniusMapperKt {

    /* JADX INFO: compiled from: ScannedDocumentPageToGeniusMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentPageFilterType.values().length];
            try {
                iArr[DocumentPageFilterType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocumentPageFilterType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DocumentPageFilterType.COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DocumentPageFilterType.BLACK_AND_WHITE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DocumentPageFilterType.PHOTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DocumentPageFilterType.MONOCHROME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Quadrangle toQuadrangle(DocumentPosition documentPosition) {
        Intrinsics.checkNotNullParameter(documentPosition, "<this>");
        return new Quadrangle(documentPosition.getX1(), documentPosition.getY1(), documentPosition.getX2(), documentPosition.getY2(), documentPosition.getX3(), documentPosition.getY3(), documentPosition.getX4(), documentPosition.getY4());
    }

    public static final DocumentPosition toDocumentPosition(Quadrangle quadrangle) {
        Intrinsics.checkNotNullParameter(quadrangle, "<this>");
        float[] points = quadrangle.getPoints();
        return new DocumentPosition(points[0], points[1], points[2], points[3], points[4], points[5], points[6], points[7]);
    }

    public static final FilterConfiguration toFilterConfiguration(DocumentPageFilterType documentPageFilterType) {
        Intrinsics.checkNotNullParameter(documentPageFilterType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[documentPageFilterType.ordinal()]) {
            case 1:
                return null;
            case 2:
                return FilterConfiguration.INSTANCE.noOp();
            case 3:
                return FilterConfiguration.INSTANCE.strongColor();
            case 4:
                return FilterConfiguration.INSTANCE.strongGrayscale();
            case 5:
                return FilterConfiguration.INSTANCE.photo();
            case 6:
                return FilterConfiguration.INSTANCE.strongMonochrome();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final DocumentPageFilterType toDocumentPageFilterType(FilterConfiguration filterConfiguration) {
        if (Intrinsics.areEqual(filterConfiguration, FilterConfiguration.INSTANCE.noOp())) {
            return DocumentPageFilterType.NONE;
        }
        if (Intrinsics.areEqual(filterConfiguration, FilterConfiguration.INSTANCE.strongColor())) {
            return DocumentPageFilterType.COLOR;
        }
        if (Intrinsics.areEqual(filterConfiguration, FilterConfiguration.INSTANCE.strongGrayscale())) {
            return DocumentPageFilterType.BLACK_AND_WHITE;
        }
        if (Intrinsics.areEqual(filterConfiguration, FilterConfiguration.INSTANCE.photo())) {
            return DocumentPageFilterType.PHOTO;
        }
        return Intrinsics.areEqual(filterConfiguration, FilterConfiguration.INSTANCE.strongMonochrome()) ? DocumentPageFilterType.MONOCHROME : DocumentPageFilterType.AUTO;
    }
}
