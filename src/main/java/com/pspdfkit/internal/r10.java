package com.pspdfkit.internal;

import android.graphics.Color;
import android.graphics.RectF;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.PageBinding;
import com.pspdfkit.document.PdfBox;
import com.pspdfkit.document.PdfVersion;
import com.pspdfkit.internal.jni.NativeAnnotationType;
import com.pspdfkit.internal.jni.NativeDocumentPermissions;
import com.pspdfkit.internal.jni.NativeFormRenderingConfig;
import com.pspdfkit.internal.jni.NativePDFBoxType;
import com.pspdfkit.internal.jni.NativePDFVersion;
import com.pspdfkit.internal.jni.NativePageBinding;
import com.pspdfkit.internal.jni.NativePageRenderingConfig;
import com.pspdfkit.internal.jni.NativePageRenderingFlags;
import com.pspdfkit.internal.jni.NativeRectDescriptor;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r10 {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[NativePageBinding.values().length];
            try {
                iArr[NativePageBinding.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NativePageBinding.LEFTEDGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NativePageBinding.RIGHTEDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[PageBinding.values().length];
            try {
                iArr2[PageBinding.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PageBinding.LEFT_EDGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PageBinding.RIGHT_EDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    public static final NativePageRenderingConfig a(jm jmVar) {
        byte rotationOffset;
        jmVar.getClass();
        List<AnnotationType> list = jmVar.q;
        list.getClass();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((AnnotationType) it.next()));
        }
        Iterator<AnnotationType> it2 = iu.b.iterator();
        it2.getClass();
        while (it2.hasNext()) {
            AnnotationType next = it2.next();
            next.getClass();
            NativeAnnotationType nativeAnnotationTypeA = a(next);
            if (!arrayList.contains(nativeAnnotationTypeA)) {
                arrayList.add(nativeAnnotationTypeA);
            }
        }
        if (jmVar.f == null) {
            ou ouVar = jmVar.a;
            int i = jmVar.b;
            ouVar.a(i);
            rotationOffset = ouVar.f.getRotationOffset(i);
        } else {
            rotationOffset = 0;
        }
        byte b = rotationOffset;
        EnumSet enumSetOf = EnumSet.of(NativePageRenderingFlags.RENDER_ANNOTATIONS, NativePageRenderingFlags.RENDER_TEXT_NATIVE, NativePageRenderingFlags.USE_CLEAR_TYPE_AA, NativePageRenderingFlags.REVERSE_BYTE_ORDER);
        if (jmVar.o) {
            enumSetOf.add(NativePageRenderingFlags.RENDER_GRAYSCALE);
        }
        if (jmVar.n) {
            enumSetOf.add(NativePageRenderingFlags.RENDER_INVERTED_COLORS);
        }
        if (Color.alpha(jmVar.i) < 255) {
            enumSetOf.add(NativePageRenderingFlags.PREMULTIPLY_ALPHA);
        }
        if (jmVar.s) {
            enumSetOf.add(NativePageRenderingFlags.DRAW_REDACT_AS_REDACTED);
        }
        if (!jmVar.u) {
            enumSetOf.add(NativePageRenderingFlags.DONT_RENDER_TEXT_OBJECTS);
        }
        if (!jmVar.a.c) {
            enumSetOf.add(NativePageRenderingFlags.RENDER_ON_ORIGINAL_DOCUMENT);
        }
        Integer numValueOf = Integer.valueOf(jmVar.i);
        NativeFormRenderingConfig nativeFormRenderingConfig = new NativeFormRenderingConfig(jmVar.j, jmVar.l, jmVar.m, jmVar.k, jmVar.t);
        List<Integer> list2 = jmVar.p;
        if (list2.isEmpty()) {
            list2 = null;
        }
        return new NativePageRenderingConfig(numValueOf, nativeFormRenderingConfig, list2 != null ? new ArrayList(list2) : null, arrayList, b, enumSetOf);
    }

    public static final NativeAnnotationType a(AnnotationType annotationType) {
        Enum r1;
        annotationType.getClass();
        Enum[] enumArr = (Enum[]) AnnotationType.class.getEnumConstants();
        if (enumArr != null) {
            Enum[] enumArr2 = (Enum[]) NativeAnnotationType.class.getEnumConstants();
            if (enumArr2 != null) {
                if (enumArr.length == enumArr2.length) {
                    Enum[] enumArr3 = (Enum[]) NativeAnnotationType.class.getEnumConstants();
                    if (enumArr3 == null || (r1 = enumArr3[annotationType.ordinal()]) == null) {
                        throw new IllegalArgumentException("Could not map enum value " + annotationType + " to " + NativeAnnotationType.class + ".");
                    }
                    return (NativeAnnotationType) r1;
                }
                throw new IllegalArgumentException("Enum classes must have the same number of constants.");
            }
            throw new IllegalArgumentException("Target enum class must have enum constants.");
        }
        throw new IllegalArgumentException("Source enum class must have enum constants.");
    }

    public static final NativePDFBoxType a(PdfBox pdfBox) {
        Enum r1;
        pdfBox.getClass();
        Enum[] enumArr = (Enum[]) PdfBox.class.getEnumConstants();
        if (enumArr != null) {
            Enum[] enumArr2 = (Enum[]) NativePDFBoxType.class.getEnumConstants();
            if (enumArr2 != null) {
                if (enumArr.length == enumArr2.length) {
                    Enum[] enumArr3 = (Enum[]) NativePDFBoxType.class.getEnumConstants();
                    if (enumArr3 == null || (r1 = enumArr3[pdfBox.ordinal()]) == null) {
                        throw new IllegalArgumentException("Could not map enum value " + pdfBox + " to " + NativePDFBoxType.class + ".");
                    }
                    return (NativePDFBoxType) r1;
                }
                throw new IllegalArgumentException("Enum classes must have the same number of constants.");
            }
            throw new IllegalArgumentException("Target enum class must have enum constants.");
        }
        throw new IllegalArgumentException("Source enum class must have enum constants.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final EnumSet<DocumentPermissions> a(EnumSet<NativeDocumentPermissions> enumSet) {
        Enum r3;
        enumSet.getClass();
        EnumSet<DocumentPermissions> enumSetNoneOf = EnumSet.noneOf(DocumentPermissions.class);
        Iterator<NativeDocumentPermissions> it = enumSet.iterator();
        it.getClass();
        while (it.hasNext()) {
            NativeDocumentPermissions next = it.next();
            next.getClass();
            Enum[] enumArr = (Enum[]) NativeDocumentPermissions.class.getEnumConstants();
            if (enumArr != null) {
                Enum[] enumArr2 = (Enum[]) DocumentPermissions.class.getEnumConstants();
                if (enumArr2 != null) {
                    if (enumArr.length == enumArr2.length) {
                        Enum[] enumArr3 = (Enum[]) DocumentPermissions.class.getEnumConstants();
                        if (enumArr3 != null && (r3 = enumArr3[next.ordinal()]) != null) {
                            enumSetNoneOf.add(r3);
                        } else {
                            throw new IllegalArgumentException("Could not map enum value " + next + " to " + DocumentPermissions.class + ".");
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

    public static final PdfVersion a(NativePDFVersion nativePDFVersion) {
        nativePDFVersion.getClass();
        nativePDFVersion.getMajorVersion();
        byte minorVersion = nativePDFVersion.getMinorVersion();
        if (minorVersion == 0) {
            return PdfVersion.PDF_1_0;
        }
        if (minorVersion == 1) {
            return PdfVersion.PDF_1_1;
        }
        if (minorVersion == 2) {
            return PdfVersion.PDF_1_2;
        }
        if (minorVersion == 3) {
            return PdfVersion.PDF_1_3;
        }
        if (minorVersion == 4) {
            return PdfVersion.PDF_1_4;
        }
        if (minorVersion == 5) {
            return PdfVersion.PDF_1_5;
        }
        if (minorVersion == 6) {
            return PdfVersion.PDF_1_6;
        }
        if (minorVersion == 7) {
            return PdfVersion.PDF_1_7;
        }
        throw new IllegalArgumentException("Unrecognised version.");
    }

    public static final ArrayList<RectF> a(ArrayList<NativeRectDescriptor> arrayList) {
        arrayList.getClass();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            NativeRectDescriptor nativeRectDescriptor = arrayList.get(i);
            i++;
            arrayList2.add(nativeRectDescriptor.getRect());
        }
        return new ArrayList<>(arrayList2);
    }
}
