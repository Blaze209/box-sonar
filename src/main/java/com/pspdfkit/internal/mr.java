package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import com.pspdfkit.annotations.note.AuthorState;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfBox;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.document.processor.ocr.OcrLanguage;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.document.search.CompareOptions;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.instant.client.InstantJsonVersion;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAPStreamGenerationOptions;
import com.pspdfkit.internal.jni.NativeAnnotationAppearanceStream;
import com.pspdfkit.internal.jni.NativeAnnotationReviewSummary;
import com.pspdfkit.internal.jni.NativeAnnotationType;
import com.pspdfkit.internal.jni.NativeAuthorState;
import com.pspdfkit.internal.jni.NativeBlendMode;
import com.pspdfkit.internal.jni.NativeDataDescriptor;
import com.pspdfkit.internal.jni.NativeDocumentPermissions;
import com.pspdfkit.internal.jni.NativeDocumentSaveFlags;
import com.pspdfkit.internal.jni.NativeDocumentSaveOptions;
import com.pspdfkit.internal.jni.NativeDocumentSecurityOptions;
import com.pspdfkit.internal.jni.NativeEditingChange;
import com.pspdfkit.internal.jni.NativeEditingOperation;
import com.pspdfkit.internal.jni.NativeFormType;
import com.pspdfkit.internal.jni.NativeHashAlgorithm;
import com.pspdfkit.internal.jni.NativeImage;
import com.pspdfkit.internal.jni.NativeImageEncoding;
import com.pspdfkit.internal.jni.NativeImageFactory;
import com.pspdfkit.internal.jni.NativeInstantJSONVersion;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeMeasurementPrecision;
import com.pspdfkit.internal.jni.NativeMeasurementPrecisionType;
import com.pspdfkit.internal.jni.NativeMeasurementScale;
import com.pspdfkit.internal.jni.NativeOcrLanguage;
import com.pspdfkit.internal.jni.NativePDFVersion;
import com.pspdfkit.internal.jni.NativeProcessOperation;
import com.pspdfkit.internal.jni.NativeUnitFrom;
import com.pspdfkit.internal.jni.NativeUnitTo;
import com.pspdfkit.signatures.BiometricSignatureData;
import com.pspdfkit.signatures.HashAlgorithm;
import com.pspdfkit.signatures.SignatureGraphic;
import com.pspdfkit.undo.EditingChange;
import com.pspdfkit.undo.EditingOperation;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class mr {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ EnumEntries<NativeAuthorState> a = EnumEntriesKt.enumEntries(NativeAuthorState.values());
        public static final /* synthetic */ EnumEntries<NativeBlendMode> b;

        static {
            EnumEntriesKt.enumEntries(BlendMode.values());
            b = EnumEntriesKt.enumEntries(NativeBlendMode.values());
        }
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public static final /* synthetic */ int[] e;
        public static final /* synthetic */ int[] f;
        public static final /* synthetic */ int[] g;
        public static final /* synthetic */ int[] h;
        public static final /* synthetic */ int[] i;
        public static final /* synthetic */ int[] j;
        public static final /* synthetic */ int[] k;
        public static final /* synthetic */ int[] l;

        static {
            int[] iArr = new int[NativeMeasurementPrecisionType.values().length];
            try {
                iArr[NativeMeasurementPrecisionType.DECIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NativeMeasurementPrecisionType.FRACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[MeasurementPrecision.values().length];
            try {
                iArr2[MeasurementPrecision.WHOLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MeasurementPrecision.ONE_DP.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MeasurementPrecision.TWO_DP.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MeasurementPrecision.THREE_DP.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MeasurementPrecision.FOUR_DP.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MeasurementPrecision.WHOLE_INCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[MeasurementPrecision.HALVES_INCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[MeasurementPrecision.QUARTERS_INCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[MeasurementPrecision.EIGHTHS_INCH.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[MeasurementPrecision.SIXTEENTHS_INCH.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            b = iArr2;
            int[] iArr3 = new int[PdfProcessorTask.AnnotationProcessingMode.values().length];
            try {
                iArr3[PdfProcessorTask.AnnotationProcessingMode.KEEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[PdfProcessorTask.AnnotationProcessingMode.FLATTEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[PdfProcessorTask.AnnotationProcessingMode.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[PdfProcessorTask.AnnotationProcessingMode.PRINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            c = iArr3;
            int[] iArr4 = new int[PdfBox.values().length];
            try {
                iArr4[PdfBox.CROP_BOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr4[PdfBox.MEDIA_BOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[PdfBox.BLEED_BOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[PdfBox.TRIM_BOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            d = iArr4;
            int[] iArr5 = new int[OcrLanguage.values().length];
            try {
                iArr5[OcrLanguage.CROATIAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr5[OcrLanguage.CZECH.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[OcrLanguage.DANISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[OcrLanguage.DUTCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr5[OcrLanguage.ENGLISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr5[OcrLanguage.FINNISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr5[OcrLanguage.FRENCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr5[OcrLanguage.GERMAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr5[OcrLanguage.INDONESIAN.ordinal()] = 9;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr5[OcrLanguage.ITALIAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr5[OcrLanguage.MALAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr5[OcrLanguage.NORWEGIAN.ordinal()] = 12;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr5[OcrLanguage.POLISH.ordinal()] = 13;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr5[OcrLanguage.PORTUGUESE.ordinal()] = 14;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr5[OcrLanguage.SERBIAN.ordinal()] = 15;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr5[OcrLanguage.SLOVAK.ordinal()] = 16;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr5[OcrLanguage.SLOVENIAN.ordinal()] = 17;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr5[OcrLanguage.SPANISH.ordinal()] = 18;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr5[OcrLanguage.SWEDISH.ordinal()] = 19;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr5[OcrLanguage.TURKISH.ordinal()] = 20;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr5[OcrLanguage.WELSH.ordinal()] = 21;
            } catch (NoSuchFieldError unused41) {
            }
            e = iArr5;
            int[] iArr6 = new int[BiometricSignatureData.InputMethod.values().length];
            try {
                iArr6[BiometricSignatureData.InputMethod.FINGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr6[BiometricSignatureData.InputMethod.STYLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr6[BiometricSignatureData.InputMethod.MOUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr6[BiometricSignatureData.InputMethod.APPLE_PENCIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused45) {
            }
            f = iArr6;
            int[] iArr7 = new int[HashAlgorithm.values().length];
            try {
                iArr7[HashAlgorithm.MD5.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr7[HashAlgorithm.SHA160.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr7[HashAlgorithm.SHA224.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr7[HashAlgorithm.SHA256.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr7[HashAlgorithm.SHA384.ordinal()] = 5;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr7[HashAlgorithm.SHA512.ordinal()] = 6;
            } catch (NoSuchFieldError unused51) {
            }
            g = iArr7;
            int[] iArr8 = new int[NativeHashAlgorithm.values().length];
            try {
                iArr8[NativeHashAlgorithm.MD5.ordinal()] = 1;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr8[NativeHashAlgorithm.SHA160.ordinal()] = 2;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr8[NativeHashAlgorithm.SHA224.ordinal()] = 3;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr8[NativeHashAlgorithm.SHA256.ordinal()] = 4;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr8[NativeHashAlgorithm.SHA384.ordinal()] = 5;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr8[NativeHashAlgorithm.SHA512.ordinal()] = 6;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr8[NativeHashAlgorithm.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused58) {
            }
            h = iArr8;
            int[] iArr9 = new int[NativeLicenseFeatures.values().length];
            try {
                iArr9[NativeLicenseFeatures.PDF_CREATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr9[NativeLicenseFeatures.DIGITAL_SIGNATURES.ordinal()] = 2;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr9[NativeLicenseFeatures.ANNOTATION_EDITING.ordinal()] = 3;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr9[NativeLicenseFeatures.INDEXED_FTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr9[NativeLicenseFeatures.ANNOTATION_REPLIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr9[NativeLicenseFeatures.IMAGE_DOCUMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr9[NativeLicenseFeatures.DOCUMENT_EDITING.ordinal()] = 7;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr9[NativeLicenseFeatures.ACRO_FORMS.ordinal()] = 8;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr9[NativeLicenseFeatures.COMPARISON.ordinal()] = 9;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr9[NativeLicenseFeatures.REDACTION.ordinal()] = 10;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr9[NativeLicenseFeatures.WEBKIT_HTML_CONVERSION.ordinal()] = 11;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr9[NativeLicenseFeatures.READER_VIEW.ordinal()] = 12;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr9[NativeLicenseFeatures.ELECTRONIC_SIGNATURES.ordinal()] = 13;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr9[NativeLicenseFeatures.MEASUREMENT_TOOLS.ordinal()] = 14;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr9[NativeLicenseFeatures.CONTENT_EDITING.ordinal()] = 15;
            } catch (NoSuchFieldError unused73) {
            }
            i = iArr9;
            int[] iArr10 = new int[EditingOperation.values().length];
            try {
                iArr10[EditingOperation.REMOVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr10[EditingOperation.MOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr10[EditingOperation.INSERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr10[EditingOperation.ROTATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused77) {
            }
            int[] iArr11 = new int[NativeEditingOperation.values().length];
            try {
                iArr11[NativeEditingOperation.REMOVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr11[NativeEditingOperation.MOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr11[NativeEditingOperation.INSERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr11[NativeEditingOperation.ROTATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr11[NativeEditingOperation.INSERTREFERENCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused82) {
            }
            j = iArr11;
            int[] iArr12 = new int[CompareOptions.values().length];
            try {
                iArr12[CompareOptions.CASE_INSENSITIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr12[CompareOptions.DIACRITIC_INSENSITIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr12[CompareOptions.SMART_SEARCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                iArr12[CompareOptions.REGULAR_EXPRESSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused86) {
            }
            k = iArr12;
            int[] iArr13 = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr13[Bitmap.CompressFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                iArr13[Bitmap.CompressFormat.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                iArr13[Bitmap.CompressFormat.WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused89) {
            }
            l = iArr13;
        }
    }

    public static final NativeDocumentSaveOptions a(DocumentSaveOptions documentSaveOptions, lm lmVar, boolean z) {
        documentSaveOptions.getClass();
        lmVar.getClass();
        EnumSet enumSetNoneOf = EnumSet.noneOf(NativeDocumentSaveFlags.class);
        if (documentSaveOptions.isIncremental()) {
            enumSetNoneOf.add(NativeDocumentSaveFlags.INCREMENTAL);
        }
        if (documentSaveOptions.shouldApplyRedactions()) {
            enumSetNoneOf.add(NativeDocumentSaveFlags.APPLYREDACTANNOTATIONS);
        }
        if (documentSaveOptions.shouldRewriteAndOptimizeFileSize()) {
            enumSetNoneOf.add(NativeDocumentSaveFlags.OPTIMIZEFILESIZE);
        }
        if (z) {
            enumSetNoneOf.add(NativeDocumentSaveFlags.KEEPDIRTY);
        }
        String password = documentSaveOptions.getPassword();
        if (Intrinsics.areEqual(lmVar.A.get(0).getPassword(), password) && documentSaveOptions.getPdfVersion().getMajorVersion() == lmVar.D.getMajorVersion() && documentSaveOptions.getPdfVersion().getMinorVersion() == lmVar.D.getMinorVersion()) {
            EnumSet<DocumentPermissions> permissions = documentSaveOptions.getPermissions();
            AbstractCollection abstractCollectionClone = lmVar.G.clone();
            abstractCollectionClone.getClass();
            if (Intrinsics.areEqual(permissions, abstractCollectionClone)) {
                return new NativeDocumentSaveOptions(null, enumSetNoneOf);
            }
        }
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("You need document editing feature enabled in your license to change document password, version or permissions.");
        }
        enumSetNoneOf.remove(NativeDocumentSaveFlags.INCREMENTAL);
        NativePDFVersion nativePDFVersion = new NativePDFVersion((byte) documentSaveOptions.getPdfVersion().getMajorVersion(), (byte) documentSaveOptions.getPdfVersion().getMinorVersion());
        EnumSet<DocumentPermissions> permissions2 = documentSaveOptions.getPermissions();
        permissions2.getClass();
        return new NativeDocumentSaveOptions(new NativeDocumentSecurityOptions(password, password, documentSaveOptions.getPdfVersion().getMaxEncryptionKeyLength(), b(permissions2), nativePDFVersion, null), enumSetNoneOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final EnumSet<NativeDocumentPermissions> b(EnumSet<DocumentPermissions> enumSet) {
        Enum r3;
        enumSet.getClass();
        EnumSet<NativeDocumentPermissions> enumSetNoneOf = EnumSet.noneOf(NativeDocumentPermissions.class);
        Iterator<DocumentPermissions> it = enumSet.iterator();
        it.getClass();
        while (it.hasNext()) {
            DocumentPermissions next = it.next();
            next.getClass();
            Enum[] enumArr = (Enum[]) DocumentPermissions.class.getEnumConstants();
            if (enumArr == null) {
                throw new IllegalArgumentException("Source enum class must have enum constants.");
            }
            Enum[] enumArr2 = (Enum[]) NativeDocumentPermissions.class.getEnumConstants();
            if (enumArr2 == null) {
                throw new IllegalArgumentException("Target enum class must have enum constants.");
            }
            if (enumArr.length != enumArr2.length) {
                throw new IllegalArgumentException("Enum classes must have the same number of constants.");
            }
            Enum[] enumArr3 = (Enum[]) NativeDocumentPermissions.class.getEnumConstants();
            if (enumArr3 == null || (r3 = enumArr3[next.ordinal()]) == null) {
                throw new IllegalArgumentException("Could not map enum value " + next + " to " + NativeDocumentPermissions.class + ".");
            }
            enumSetNoneOf.add(r3);
        }
        enumSetNoneOf.getClass();
        return enumSetNoneOf;
    }

    public static final MeasurementPrecision a(NativeMeasurementPrecision nativeMeasurementPrecision) {
        nativeMeasurementPrecision.getClass();
        int i = b.a[nativeMeasurementPrecision.getPrecisionType().ordinal()];
        if (i == 1) {
            int precision = nativeMeasurementPrecision.getPrecision();
            if (precision == 0) {
                return MeasurementPrecision.WHOLE;
            }
            if (precision == 1) {
                return MeasurementPrecision.ONE_DP;
            }
            if (precision == 2) {
                return MeasurementPrecision.TWO_DP;
            }
            if (precision == 3) {
                return MeasurementPrecision.THREE_DP;
            }
            if (precision != 4) {
                return MeasurementPrecision.TWO_DP;
            }
            return MeasurementPrecision.FOUR_DP;
        }
        if (i == 2) {
            int precision2 = nativeMeasurementPrecision.getPrecision();
            if (precision2 == 1) {
                return MeasurementPrecision.WHOLE_INCH;
            }
            if (precision2 == 2) {
                return MeasurementPrecision.HALVES_INCH;
            }
            if (precision2 == 4) {
                return MeasurementPrecision.QUARTERS_INCH;
            }
            if (precision2 == 8) {
                return MeasurementPrecision.EIGHTHS_INCH;
            }
            if (precision2 != 16) {
                return MeasurementPrecision.SIXTEENTHS_INCH;
            }
            return MeasurementPrecision.SIXTEENTHS_INCH;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final NativeMeasurementPrecision a(MeasurementPrecision measurementPrecision) {
        measurementPrecision.getClass();
        switch (b.b[measurementPrecision.ordinal()]) {
            case 1:
                return new NativeMeasurementPrecision(0, NativeMeasurementPrecisionType.DECIMAL);
            case 2:
                return new NativeMeasurementPrecision(1, NativeMeasurementPrecisionType.DECIMAL);
            case 3:
                return new NativeMeasurementPrecision(2, NativeMeasurementPrecisionType.DECIMAL);
            case 4:
                return new NativeMeasurementPrecision(3, NativeMeasurementPrecisionType.DECIMAL);
            case 5:
                return new NativeMeasurementPrecision(4, NativeMeasurementPrecisionType.DECIMAL);
            case 6:
                return new NativeMeasurementPrecision(1, NativeMeasurementPrecisionType.FRACTION);
            case 7:
                return new NativeMeasurementPrecision(2, NativeMeasurementPrecisionType.FRACTION);
            case 8:
                return new NativeMeasurementPrecision(4, NativeMeasurementPrecisionType.FRACTION);
            case 9:
                return new NativeMeasurementPrecision(8, NativeMeasurementPrecisionType.FRACTION);
            case 10:
                return new NativeMeasurementPrecision(16, NativeMeasurementPrecisionType.FRACTION);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Scale.UnitFrom a(NativeUnitFrom nativeUnitFrom) {
        nativeUnitFrom.getClass();
        try {
            return Scale.UnitFrom.valueOf(nativeUnitFrom.name());
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Received unknown native unit from: " + nativeUnitFrom.name());
        }
    }

    public static final NativeUnitFrom a(Scale.UnitFrom unitFrom) {
        unitFrom.getClass();
        try {
            return NativeUnitFrom.valueOf(unitFrom.name());
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Received unknown scale unit from: " + unitFrom.name());
        }
    }

    public static final Scale.UnitTo a(NativeUnitTo nativeUnitTo) {
        nativeUnitTo.getClass();
        try {
            return Scale.UnitTo.valueOf(nativeUnitTo.name());
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Received unknown native unit to: " + nativeUnitTo.name());
        }
    }

    public static final NativeUnitTo a(Scale.UnitTo unitTo) {
        unitTo.getClass();
        try {
            return NativeUnitTo.valueOf(unitTo.name());
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Received unknown scale unit to: " + unitTo.name());
        }
    }

    public static final NativeMeasurementScale a(Scale scale) {
        scale.getClass();
        return new NativeMeasurementScale(a(scale.unitFrom), a(scale.unitTo), scale.getValueFrom(), scale.getValueTo(), scale.fromDescription, scale.toDescription);
    }

    public static final NativeInstantJSONVersion a(InstantJsonVersion instantJsonVersion) {
        instantJsonVersion.getClass();
        try {
            return NativeInstantJSONVersion.valueOf(instantJsonVersion.name());
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Received unknown InstantJsonVersion: " + instantJsonVersion.name());
        }
    }

    public static final NativeProcessOperation a(PdfProcessorTask.AnnotationProcessingMode annotationProcessingMode) {
        annotationProcessingMode.getClass();
        int i = b.c[annotationProcessingMode.ordinal()];
        if (i == 1) {
            return NativeProcessOperation.EMBED;
        }
        if (i == 2) {
            return NativeProcessOperation.FLATTEN;
        }
        if (i == 3) {
            return NativeProcessOperation.REMOVE;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return NativeProcessOperation.PRINT;
    }

    public static final NativeOcrLanguage a(OcrLanguage ocrLanguage) {
        switch (b.e[ocrLanguage.ordinal()]) {
            case 1:
                return NativeOcrLanguage.CROATIAN;
            case 2:
                return NativeOcrLanguage.CZECH;
            case 3:
                return NativeOcrLanguage.DANISH;
            case 4:
                return NativeOcrLanguage.DUTCH;
            case 5:
                return NativeOcrLanguage.ENGLISH;
            case 6:
                return NativeOcrLanguage.FINNISH;
            case 7:
                return NativeOcrLanguage.FRENCH;
            case 8:
                return NativeOcrLanguage.GERMAN;
            case 9:
                return NativeOcrLanguage.INDONESIAN;
            case 10:
                return NativeOcrLanguage.ITALIAN;
            case 11:
                return NativeOcrLanguage.MALAY;
            case 12:
                return NativeOcrLanguage.NORWEGIAN;
            case 13:
                return NativeOcrLanguage.POLISH;
            case 14:
                return NativeOcrLanguage.PORTUGUESE;
            case 15:
                return NativeOcrLanguage.SERBIAN;
            case 16:
                return NativeOcrLanguage.SLOVAK;
            case 17:
                return NativeOcrLanguage.SLOVENIAN;
            case 18:
                return NativeOcrLanguage.SPANISH;
            case 19:
                return NativeOcrLanguage.SWEDISH;
            case 20:
                return NativeOcrLanguage.TURKISH;
            case 21:
                return NativeOcrLanguage.WELSH;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final AnnotationType a(NativeAnnotationType nativeAnnotationType) {
        Enum r1;
        nativeAnnotationType.getClass();
        Enum[] enumArr = (Enum[]) NativeAnnotationType.class.getEnumConstants();
        if (enumArr != null) {
            Enum[] enumArr2 = (Enum[]) AnnotationType.class.getEnumConstants();
            if (enumArr2 != null) {
                if (enumArr.length == enumArr2.length) {
                    Enum[] enumArr3 = (Enum[]) AnnotationType.class.getEnumConstants();
                    if (enumArr3 == null || (r1 = enumArr3[nativeAnnotationType.ordinal()]) == null) {
                        throw new IllegalArgumentException("Could not map enum value " + nativeAnnotationType + " to " + AnnotationType.class + ".");
                    }
                    return (AnnotationType) r1;
                }
                throw new IllegalArgumentException("Enum classes must have the same number of constants.");
            }
            throw new IllegalArgumentException("Target enum class must have enum constants.");
        }
        throw new IllegalArgumentException("Source enum class must have enum constants.");
    }

    public static final FormType a(NativeFormType nativeFormType) {
        Enum r1;
        nativeFormType.getClass();
        Enum[] enumArr = (Enum[]) NativeFormType.class.getEnumConstants();
        if (enumArr != null) {
            Enum[] enumArr2 = (Enum[]) FormType.class.getEnumConstants();
            if (enumArr2 != null) {
                if (enumArr.length == enumArr2.length) {
                    Enum[] enumArr3 = (Enum[]) FormType.class.getEnumConstants();
                    if (enumArr3 == null || (r1 = enumArr3[nativeFormType.ordinal()]) == null) {
                        throw new IllegalArgumentException("Could not map enum value " + nativeFormType + " to " + FormType.class + ".");
                    }
                    return (FormType) r1;
                }
                throw new IllegalArgumentException("Enum classes must have the same number of constants.");
            }
            throw new IllegalArgumentException("Target enum class must have enum constants.");
        }
        throw new IllegalArgumentException("Source enum class must have enum constants.");
    }

    public static final NativeFormType a(FormType formType) {
        Enum r1;
        formType.getClass();
        Enum[] enumArr = (Enum[]) FormType.class.getEnumConstants();
        if (enumArr != null) {
            Enum[] enumArr2 = (Enum[]) NativeFormType.class.getEnumConstants();
            if (enumArr2 != null) {
                if (enumArr.length == enumArr2.length) {
                    Enum[] enumArr3 = (Enum[]) NativeFormType.class.getEnumConstants();
                    if (enumArr3 == null || (r1 = enumArr3[formType.ordinal()]) == null) {
                        throw new IllegalArgumentException("Could not map enum value " + formType + " to " + NativeFormType.class + ".");
                    }
                    return (NativeFormType) r1;
                }
                throw new IllegalArgumentException("Enum classes must have the same number of constants.");
            }
            throw new IllegalArgumentException("Target enum class must have enum constants.");
        }
        throw new IllegalArgumentException("Source enum class must have enum constants.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final EnumSet<AppearanceStreamGenerator.AppearanceStreamGenerationOptions> a(EnumSet<NativeAPStreamGenerationOptions> enumSet) {
        Enum r3;
        enumSet.getClass();
        EnumSet<AppearanceStreamGenerator.AppearanceStreamGenerationOptions> enumSetNoneOf = EnumSet.noneOf(AppearanceStreamGenerator.AppearanceStreamGenerationOptions.class);
        Iterator<NativeAPStreamGenerationOptions> it = enumSet.iterator();
        it.getClass();
        while (it.hasNext()) {
            NativeAPStreamGenerationOptions next = it.next();
            next.getClass();
            Enum[] enumArr = (Enum[]) NativeAPStreamGenerationOptions.class.getEnumConstants();
            if (enumArr != null) {
                Enum[] enumArr2 = (Enum[]) AppearanceStreamGenerator.AppearanceStreamGenerationOptions.class.getEnumConstants();
                if (enumArr2 != null) {
                    if (enumArr.length == enumArr2.length) {
                        Enum[] enumArr3 = (Enum[]) AppearanceStreamGenerator.AppearanceStreamGenerationOptions.class.getEnumConstants();
                        if (enumArr3 != null && (r3 = enumArr3[next.ordinal()]) != null) {
                            enumSetNoneOf.add(r3);
                        } else {
                            throw new IllegalArgumentException("Could not map enum value " + next + " to " + AppearanceStreamGenerator.AppearanceStreamGenerationOptions.class + ".");
                        }
                    } else {
                        throw new IllegalArgumentException("Enum classes must have the same number of constants.");
                    }
                } else {
                    throw new IllegalArgumentException("Target enum class must have enum constants.");
                }
            } else {
                throw new IllegalArgumentException("Source enum class must have enum constants.");
            }
        }
        enumSetNoneOf.getClass();
        return enumSetNoneOf;
    }

    public static final int a(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            throw new IllegalArgumentException(String.format(Locale.getDefault(), "Invalid rotation passed: %d. Expected one of: 0, 90, 180, 270.", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1)).toString());
        }
        return i / 90;
    }

    public static final NativeHashAlgorithm a(HashAlgorithm hashAlgorithm) {
        hashAlgorithm.getClass();
        switch (b.g[hashAlgorithm.ordinal()]) {
            case 1:
                return NativeHashAlgorithm.MD5;
            case 2:
                return NativeHashAlgorithm.SHA160;
            case 3:
                return NativeHashAlgorithm.SHA224;
            case 4:
                return NativeHashAlgorithm.SHA256;
            case 5:
                return NativeHashAlgorithm.SHA384;
            case 6:
                return NativeHashAlgorithm.SHA512;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final HashAlgorithm a(NativeHashAlgorithm nativeHashAlgorithm) {
        nativeHashAlgorithm.getClass();
        switch (b.h[nativeHashAlgorithm.ordinal()]) {
            case 1:
                return HashAlgorithm.MD5;
            case 2:
                return HashAlgorithm.SHA160;
            case 3:
                return HashAlgorithm.SHA224;
            case 4:
                return HashAlgorithm.SHA256;
            case 5:
                return HashAlgorithm.SHA384;
            case 6:
                return HashAlgorithm.SHA512;
            case 7:
                throw new IllegalStateException("Unknown hash algorithm.");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final AnnotationReviewSummary a(NativeAnnotationReviewSummary nativeAnnotationReviewSummary) {
        nativeAnnotationReviewSummary.getClass();
        HashMap map = new HashMap();
        HashMap<NativeAuthorState, ArrayList<String>> reviewNames = nativeAnnotationReviewSummary.getReviewNames();
        reviewNames.getClass();
        for (Map.Entry<NativeAuthorState, ArrayList<String>> entry : reviewNames.entrySet()) {
            NativeAuthorState key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            key.getClass();
            map.put(AuthorState.getEntries().get(key.ordinal()), value);
        }
        NativeAuthorState currentUserState = nativeAnnotationReviewSummary.getCurrentUserState();
        currentUserState.getClass();
        return new AnnotationReviewSummary(map, AuthorState.getEntries().get(currentUserState.ordinal()));
    }

    public static final ArrayList a(ArrayList arrayList) {
        EditingOperation editingOperation;
        arrayList.getClass();
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NativeEditingChange nativeEditingChange = (NativeEditingChange) obj;
            nativeEditingChange.getClass();
            NativeEditingOperation operation = nativeEditingChange.getOperation();
            operation.getClass();
            int i2 = b.j[operation.ordinal()];
            if (i2 == 1) {
                editingOperation = EditingOperation.REMOVE;
            } else if (i2 == 2) {
                editingOperation = EditingOperation.MOVE;
            } else if (i2 == 3) {
                editingOperation = EditingOperation.INSERT;
            } else if (i2 == 4) {
                editingOperation = EditingOperation.ROTATE;
            } else {
                if (i2 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                editingOperation = EditingOperation.INSERTREFERENCE;
            }
            arrayList2.add(new EditingChange(editingOperation, nativeEditingChange.getAffectedPageIndex(), nativeEditingChange.getPageIndexDestination(), nativeEditingChange.getPageReferenceSourceIndex()));
        }
        return arrayList2;
    }

    public static final NativeImageEncoding a(Bitmap.CompressFormat compressFormat) {
        compressFormat.getClass();
        int i = b.l[compressFormat.ordinal()];
        if (i == 1) {
            return NativeImageEncoding.JPEG;
        }
        if (i == 2) {
            return NativeImageEncoding.PNG;
        }
        if (i == 3) {
            return NativeImageEncoding.WEBP;
        }
        throw new IllegalArgumentException("Unknown compression format:" + compressFormat);
    }

    public static final NativeAnnotationAppearanceStream a(Context context, SignatureGraphic signatureGraphic) throws IOException {
        NativeDataDescriptor nativeDataDescriptorCreateNativeDataDescriptor;
        context.getClass();
        if (signatureGraphic.getIsBitmap()) {
            if (signatureGraphic.getDataProvider() != null) {
                return new NativeAnnotationAppearanceStream((NativeImage) NativeImageFactory.INSTANCE.fromDataProvider(signatureGraphic.getDataProvider()).first, null);
            }
            Uri uri = signatureGraphic.getUri();
            NativeImageFactory.Companion companion = NativeImageFactory.INSTANCE;
            uri.getClass();
            return new NativeAnnotationAppearanceStream((NativeImage) companion.fromUri(context, uri).first, null);
        }
        if (signatureGraphic.getDataProvider() != null) {
            nativeDataDescriptorCreateNativeDataDescriptor = DataProviderShim.createNativeDataDescriptor(signatureGraphic.getDataProvider(), null);
            nativeDataDescriptorCreateNativeDataDescriptor.getClass();
        } else {
            Uri uri2 = signatureGraphic.getUri();
            uri2.getClass();
            String strA = wg.a(context, uri2);
            if (strA != null) {
                nativeDataDescriptorCreateNativeDataDescriptor = new NativeDataDescriptor(strA, null, null, null, null);
            } else {
                nativeDataDescriptorCreateNativeDataDescriptor = DataProviderShim.createNativeDataDescriptor(new ContentResolverDataProvider(signatureGraphic.getUri()), null);
                nativeDataDescriptorCreateNativeDataDescriptor.getClass();
            }
        }
        return new NativeAnnotationAppearanceStream(null, nativeDataDescriptorCreateNativeDataDescriptor);
    }
}
