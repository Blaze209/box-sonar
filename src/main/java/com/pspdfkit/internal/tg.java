package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.annotations.AnnotationReplyFeatures;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.jni.NativeLicense;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.utils.PdfLog;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class tg {
    public final LinkedHashMap a = new LinkedHashMap();

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationTool.values().length];
            try {
                iArr[AnnotationTool.REDACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationTool.MAGIC_INK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationTool.SOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_DISTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_PERIMETER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_AREA_POLYGON.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_AREA_ELLIPSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_AREA_RECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_SCALE_CALIBRATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            a = iArr;
        }
    }

    public final synchronized boolean a(NativeLicenseFeatures nativeLicenseFeatures) {
        Object objValueOf;
        nativeLicenseFeatures.getClass();
        LinkedHashMap linkedHashMap = this.a;
        objValueOf = linkedHashMap.get(nativeLicenseFeatures);
        if (objValueOf == null) {
            objValueOf = Boolean.valueOf(NativeLicense.license().supportsFeatures(EnumSet.of(nativeLicenseFeatures)));
            linkedHashMap.put(nativeLicenseFeatures, objValueOf);
        }
        return ((Boolean) objValueOf).booleanValue();
    }

    public final synchronized boolean b(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return a(NativeLicenseFeatures.ANNOTATION_REPLIES) && pdfConfiguration.getAnnotationReplyFeatures() != AnnotationReplyFeatures.DISABLED;
    }

    public final synchronized void c() {
        this.a.clear();
    }

    public final boolean d(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return a(NativeLicenseFeatures.CONTENT_EDITING) && pdfConfiguration.isContentEditingEnabled();
    }

    public final synchronized boolean e(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return a(NativeLicenseFeatures.ACRO_FORMS) && pdfConfiguration.isFormEditingEnabled();
    }

    public final synchronized boolean f(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return a(NativeLicenseFeatures.MEASUREMENT_TOOLS) && pdfConfiguration.isMeasurementsEnabled();
    }

    public final synchronized boolean c(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return a(NativeLicenseFeatures.ANNOTATION_EDITING) && pdfConfiguration.isAnnotationEditingEnabled();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:10:0x0012, B:13:0x001a, B:15:0x0029, B:17:0x0036), top: B:27:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x003c A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x003c, please report this as an issue */
    public final synchronized boolean b(PdfConfiguration pdfConfiguration, PdfDocument pdfDocument) {
        pdfConfiguration.getClass();
        lm lmVar = pdfDocument instanceof lm ? (lm) pdfDocument : null;
        if (pdfDocument != null) {
            if (!(lmVar != null ? lmVar.a() : true)) {
                lm lmVar2 = (lm) pdfDocument;
                DocumentPermissions documentPermissions = DocumentPermissions.ANNOTATIONS_AND_FORMS;
                documentPermissions.getClass();
                if (!lmVar2.G.contains(documentPermissions)) {
                    DocumentPermissions documentPermissions2 = DocumentPermissions.FILL_FORMS;
                    documentPermissions2.getClass();
                    if (lmVar2.G.contains(documentPermissions2)) {
                        if (e(pdfConfiguration)) {
                            return true;
                        }
                    }
                } else if (e(pdfConfiguration)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final synchronized boolean a() {
        return a(NativeLicenseFeatures.ANNOTATION_EDITING) || a(NativeLicenseFeatures.ELECTRONIC_SIGNATURES);
    }

    public final synchronized boolean a(Annotation annotation) {
        annotation.getClass();
        boolean zA = a(NativeLicenseFeatures.ANNOTATION_EDITING);
        if (zA) {
            if (annotation.isMeasurement() && !a(NativeLicenseFeatures.MEASUREMENT_TOOLS)) {
                return false;
            }
            if (annotation.getType() == AnnotationType.REDACT && !a(NativeLicenseFeatures.REDACTION)) {
                return false;
            }
        } else if (annotation.isSignature()) {
            return a(NativeLicenseFeatures.ELECTRONIC_SIGNATURES);
        }
        return zA;
    }

    public final synchronized boolean a(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return a() && pdfConfiguration.isAnnotationEditingEnabled();
    }

    public final synchronized boolean a(PdfConfiguration pdfConfiguration, PdfDocument pdfDocument) {
        pdfConfiguration.getClass();
        lm lmVar = pdfDocument instanceof lm ? (lm) pdfDocument : null;
        if (pdfDocument != null && pdfDocument.hasPermission(DocumentPermissions.ANNOTATIONS_AND_FORMS)) {
            if (!(lmVar != null ? lmVar.a() : true) && a(pdfConfiguration)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean a(PdfConfiguration pdfConfiguration, AnnotationType annotationType) {
        pdfConfiguration.getClass();
        annotationType.getClass();
        if (!a(pdfConfiguration)) {
            return false;
        }
        if (annotationType == AnnotationType.REDACT && !a(NativeLicenseFeatures.REDACTION)) {
            return false;
        }
        List<AnnotationType> editableAnnotationTypes = pdfConfiguration.getEditableAnnotationTypes();
        return editableAnnotationTypes.isEmpty() || editableAnnotationTypes.contains(annotationType);
    }

    public final synchronized boolean a(PdfConfiguration pdfConfiguration, Annotation annotation) {
        pdfConfiguration.getClass();
        annotation.getClass();
        if (!a(annotation)) {
            return false;
        }
        return a(pdfConfiguration, annotation.getType());
    }

    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0127  */
    public final boolean a(PdfConfiguration pdfConfiguration, AnnotationTool annotationTool) {
        boolean zBooleanValue;
        pdfConfiguration.getClass();
        annotationTool.getClass();
        if (!a(pdfConfiguration)) {
            return false;
        }
        if (annotationTool == AnnotationTool.NONE) {
            return true;
        }
        List<AnnotationType> editableAnnotationTypes = pdfConfiguration.getEditableAnnotationTypes();
        List<AnnotationTool> enabledAnnotationTools = pdfConfiguration.getEnabledAnnotationTools();
        AnnotationType annotationType = annotationTool.toAnnotationType();
        annotationType.getClass();
        boolean z = enabledAnnotationTools.isEmpty() || enabledAnnotationTools.contains(annotationTool);
        if (annotationTool != AnnotationTool.ERASER && annotationTool != AnnotationTool.ANNOTATION_MULTI_SELECTION) {
            if (annotationTool == AnnotationTool.SIGNATURE) {
                return b() && z;
            }
            if (!editableAnnotationTypes.isEmpty() && !editableAnnotationTypes.contains(annotationType)) {
                return false;
            }
            switch (a.a[annotationTool.ordinal()]) {
                case 1:
                    return z && a(NativeLicenseFeatures.REDACTION);
                case 2:
                    if (!z) {
                        return false;
                    }
                    synchronized (k10.class) {
                        if (k10.b == null) {
                            Context context = n5.a;
                            if (context != null) {
                                try {
                                    try {
                                        String[] list = context.getAssets().list("nutrient");
                                        boolean z2 = list != null && Arrays.asList(list).contains("PSPDFShapeTemplates.data");
                                        k10.b = Boolean.valueOf(z2);
                                        if (!z2) {
                                            PdfLog.w("Nutri.ShapeDetector", "The shape templates data (%s/%s) could not be found in assets. Magic ink will be disabled.", "nutrient", "PSPDFShapeTemplates.data");
                                        }
                                    } catch (Throwable th) {
                                        if (k10.b == null) {
                                            k10.b = Boolean.FALSE;
                                        }
                                        if (!k10.b.booleanValue()) {
                                            PdfLog.w("Nutri.ShapeDetector", "The shape templates data (%s/%s) could not be found in assets. Magic ink will be disabled.", "nutrient", "PSPDFShapeTemplates.data");
                                        }
                                        throw th;
                                    }
                                } catch (Throwable unused) {
                                    PdfLog.i("Nutri.ShapeDetector", "Failed to check whether or not SHAPE_TEMPLATES_DATA_ASSET_NAME is in the assets list and the exception was ignored.", new Object[0]);
                                    if (k10.b == null) {
                                        k10.b = Boolean.FALSE;
                                    }
                                    if (!k10.b.booleanValue()) {
                                        PdfLog.w("Nutri.ShapeDetector", "The shape templates data (%s/%s) could not be found in assets. Magic ink will be disabled.", "nutrient", "PSPDFShapeTemplates.data");
                                    }
                                    zBooleanValue = k10.b.booleanValue();
                                    if (zBooleanValue) {
                                        return true;
                                    }
                                    return false;
                                }
                            } else {
                                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
                            }
                        }
                        zBooleanValue = k10.b.booleanValue();
                    }
                    if (zBooleanValue) {
                        return true;
                    }
                    return false;
                case 3:
                    if (z) {
                        Context context2 = n5.a;
                        if (context2 != null) {
                            if (l6.a(context2)) {
                                return true;
                            }
                        } else {
                            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
                        }
                    }
                    return false;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return z && f(pdfConfiguration);
                case 9:
                    return f(pdfConfiguration);
            }
        }
        return z;
    }

    public static boolean b() {
        return NativeLicense.license().signatureFeatureAvailability() != NativeSignatureFeatureAvailability.NONE;
    }
}
