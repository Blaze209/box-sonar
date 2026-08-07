package com.pspdfkit.document.processor;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.pspdfkit.Nutrient;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.document.PdfBox;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.ocr.OcrLanguage;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationType;
import com.pspdfkit.internal.jni.NativeDataDescriptor;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeFormType;
import com.pspdfkit.internal.jni.NativeItemZPosition;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativePDFBoxType;
import com.pspdfkit.internal.jni.NativePageColorOptions;
import com.pspdfkit.internal.jni.NativePageSizeFormat;
import com.pspdfkit.internal.jni.NativeProcessorConfiguration;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.n5;
import com.pspdfkit.internal.r10;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import com.pspdfkit.utils.Size;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfProcessorTask {
    private final List<NativeProcessorConfigurationMapper> configurationMappers;
    private final NativeProcessorConfigurationFactory initialConfigurationFactory;
    final lm sourceDocument;

    public enum AnnotationProcessingMode {
        KEEP,
        FLATTEN,
        DELETE,
        PRINT
    }

    public interface NativeProcessorConfigurationFactory {
        NativeProcessorConfiguration create();
    }

    public interface NativeProcessorConfigurationMapper {
        NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration);
    }

    private PdfProcessorTask(PdfDocument pdfDocument) {
        this.configurationMappers = new ArrayList();
        if (!Nutrient.isInitialized()) {
            throw new NutrientNotInitializedException("PSPDFKit must be initialized with the initialize() call before use of processor.");
        }
        uw.a(pdfDocument, "sourceDocument", null);
        lm lmVar = (lm) pdfDocument;
        this.sourceDocument = lmVar;
        final NativeDocument nativeDocument = lmVar.y;
        this.initialConfigurationFactory = new NativeProcessorConfigurationFactory() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationFactory
            public final NativeProcessorConfiguration create() {
                return NativeProcessorConfiguration.create(nativeDocument);
            }
        };
    }

    private void checkCurrentPageIndexOrThrow(NativeProcessorConfiguration nativeProcessorConfiguration, int i) {
        if (i < 0 || i >= nativeProcessorConfiguration.getPageCount()) {
            throw new IllegalArgumentException("Page index " + i + " isn't within existing page ranges!");
        }
    }

    private void checkCurrentPageIndexesOrThrow(NativeProcessorConfiguration nativeProcessorConfiguration, Set<Integer> set) {
        for (Integer num : set) {
            if (num == null || num.intValue() < 0 || num.intValue() >= nativeProcessorConfiguration.getPageCount()) {
                throw new IllegalArgumentException("Page index " + num + " isn't within existing page ranges!");
            }
        }
    }

    private void checkDestinationIndexOrThrow(NativeProcessorConfiguration nativeProcessorConfiguration, int i) {
        if (i < 0 || i > nativeProcessorConfiguration.getPageCount()) {
            throw new IllegalArgumentException("Destination index " + i + " isn't within range!");
        }
    }

    public static PdfProcessorTask empty() {
        return new PdfProcessorTask();
    }

    public static PdfProcessorTask fromDocument(PdfDocument pdfDocument) {
        uw.a(pdfDocument, "sourceDocument", null);
        return new PdfProcessorTask(pdfDocument);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$addCanvasDrawingToPage$16(int i, PageCanvas pageCanvas, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        nativeProcessorConfiguration.mergeContentFromItem(i, pageCanvas.getItemConfiguration());
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$addImageToPage$15(int i, PageImage pageImage, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        try {
            nativeProcessorConfiguration.mergeContentFromItem(i, pageImage.getItemConfiguration());
            return nativeProcessorConfiguration;
        } catch (IOException e) {
            throw new PdfProcessorException(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$addNewPage$10(int i, NewPage newPage, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        nativeProcessorConfiguration.addNewPage(i, newPage.getNativeNewPageConfiguration());
        return nativeProcessorConfiguration;
    }

    static /* synthetic */ NativeProcessorConfiguration lambda$applyRedactions$24(NativeProcessorConfiguration nativeProcessorConfiguration) {
        for (int i = 0; i < nativeProcessorConfiguration.getPageCount(); i++) {
            nativeProcessorConfiguration.applyRedactAnnotations(i);
        }
        return nativeProcessorConfiguration;
    }

    static /* synthetic */ NativeProcessorConfiguration lambda$changeAllAnnotations$9(AnnotationProcessingMode annotationProcessingMode, NativeProcessorConfiguration nativeProcessorConfiguration) {
        nativeProcessorConfiguration.processAnnotationsWithOperation(new ArrayList<>(Arrays.asList(NativeAnnotationType.values())), mr.a(annotationProcessingMode));
        return nativeProcessorConfiguration;
    }

    static /* synthetic */ NativeProcessorConfiguration lambda$changeAnnotations$8(List list, AnnotationProcessingMode annotationProcessingMode, NativeProcessorConfiguration nativeProcessorConfiguration) {
        NativeAnnotation nativeAnnotation;
        ArrayList<NativeAnnotation> arrayList = new ArrayList<>(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            if (annotation.isAttached() && (nativeAnnotation = annotation.getInternal().getNativeAnnotation()) != null) {
                arrayList.add(nativeAnnotation);
            }
        }
        nativeProcessorConfiguration.processAnnotations(arrayList, mr.a(annotationProcessingMode));
        return nativeProcessorConfiguration;
    }

    static NativeProcessorConfiguration lambda$changeAnnotationsOfType$6(AnnotationType annotationType, AnnotationProcessingMode annotationProcessingMode, NativeProcessorConfiguration nativeProcessorConfiguration) {
        ArrayList arrayList;
        if (annotationType == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(annotationType);
            arrayList = arrayList2;
        }
        arrayList.getClass();
        ArrayList<NativeAnnotationType> arrayList3 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList3.add(r10.a((AnnotationType) obj));
        }
        nativeProcessorConfiguration.processAnnotationsWithOperation(arrayList3, mr.a(annotationProcessingMode));
        return nativeProcessorConfiguration;
    }

    static /* synthetic */ NativeProcessorConfiguration lambda$changeFormsOfType$7(FormType formType, AnnotationProcessingMode annotationProcessingMode, NativeProcessorConfiguration nativeProcessorConfiguration) {
        ArrayList<NativeFormType> arrayList = new ArrayList<>();
        arrayList.add(mr.a(formType));
        nativeProcessorConfiguration.processFormsWithOperation(arrayList, mr.a(annotationProcessingMode));
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$changeStrokeColorOnPage$19(int i, int i2, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        nativeProcessorConfiguration.adjustPageColors(i, Integer.valueOf(i2), EnumSet.of(NativePageColorOptions.STROKING));
        return nativeProcessorConfiguration;
    }

    static /* synthetic */ NativeProcessorConfiguration lambda$clearPageLabels$20(NativeProcessorConfiguration nativeProcessorConfiguration) {
        nativeProcessorConfiguration.clearPageLabels();
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeProcessorConfiguration lambda$keepPages$2(Set set, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkCurrentPageIndexesOrThrow(nativeProcessorConfiguration, set);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nativeProcessorConfiguration.getPageCount(); i++) {
            if (!set.contains(Integer.valueOf(i))) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        nativeProcessorConfiguration.removePages(hashSet);
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$mergePage$17(int i, PagePdf pagePdf, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        nativeProcessorConfiguration.mergeAutoRotatedContentFromDataDescriptor(i, pagePdf.getNativeDataDescriptor(), pagePdf.getPageIndex(), pagePdf.getNativeZPosition(), pagePdf.getMatrix(), null);
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeProcessorConfiguration lambda$mergePage$18(int i, PagePdf pagePdf, BlendMode blendMode, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        NativeDataDescriptor nativeDataDescriptor = pagePdf.getNativeDataDescriptor();
        int pageIndex = pagePdf.getPageIndex();
        NativeItemZPosition nativeZPosition = pagePdf.getNativeZPosition();
        Matrix matrix = pagePdf.getMatrix();
        blendMode.getClass();
        nativeProcessorConfiguration.mergeAutoRotatedContentFromDataDescriptor(i, nativeDataDescriptor, pageIndex, nativeZPosition, matrix, mr.a.b.get(blendMode.ordinal()));
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeProcessorConfiguration lambda$movePages$4(Set set, int i, NativeProcessorConfiguration nativeProcessorConfiguration) {
        HashSet<Integer> hashSet;
        checkCurrentPageIndexesOrThrow(nativeProcessorConfiguration, set);
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        if (set == null) {
            hashSet = null;
        } else {
            hashSet = set instanceof HashSet ? (HashSet) set : new HashSet<>(set);
        }
        nativeProcessorConfiguration.movePages(hashSet, i);
        return nativeProcessorConfiguration;
    }

    static NativeProcessorConfiguration lambda$performOcrOnPages$25(OcrLanguage ocrLanguage, Set set, NativeProcessorConfiguration nativeProcessorConfiguration) {
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(ocrLanguage.getTrainedDataFilename() + ".traineddata");
            String strB = wg.b("ocr/trained-data");
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            wg.a(context, strB, hashSet, strB);
            nativeProcessorConfiguration.performOcr(new HashSet<>(set), mr.a(ocrLanguage));
            return nativeProcessorConfiguration;
        } catch (Exception e) {
            throw new NutrientException("Error while trying to perform OCR on the page.Did you forget to import core OCR library or OCR language pack in your dependencies?", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeProcessorConfiguration lambda$removePages$3(Set set, NativeProcessorConfiguration nativeProcessorConfiguration) {
        HashSet<Integer> hashSet;
        checkCurrentPageIndexesOrThrow(nativeProcessorConfiguration, set);
        if (set == null) {
            hashSet = null;
        } else {
            hashSet = set instanceof HashSet ? (HashSet) set : new HashSet<>(set);
        }
        nativeProcessorConfiguration.removePages(hashSet);
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$resizePage$13(int i, Size size, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkCurrentPageIndexOrThrow(nativeProcessorConfiguration, i);
        nativeProcessorConfiguration.scalePage(i, (int) size.width, (int) size.height, NativePageSizeFormat.POINTS);
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$rotatePage$12(int i, int i2, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkCurrentPageIndexOrThrow(nativeProcessorConfiguration, i);
        nativeProcessorConfiguration.rotatePage(i, i2);
        return nativeProcessorConfiguration;
    }

    static NativeProcessorConfiguration lambda$setFormFieldNameMappings$22(Map map, NativeProcessorConfiguration nativeProcessorConfiguration) {
        HashMap<String, String> map2;
        if (map == null) {
            map2 = null;
        } else {
            map2 = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
        }
        nativeProcessorConfiguration.changeFormFieldNames(map2);
        return nativeProcessorConfiguration;
    }

    static NativeProcessorConfiguration lambda$setFormMappingNameMappings$23(Map map, NativeProcessorConfiguration nativeProcessorConfiguration) {
        HashMap<String, String> map2;
        if (map == null) {
            map2 = null;
        } else {
            map2 = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
        }
        nativeProcessorConfiguration.changeFormMappingNames(map2);
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeProcessorConfiguration lambda$setPageBox$11(int i, PdfBox pdfBox, RectF rectF, NativeProcessorConfiguration nativeProcessorConfiguration) {
        NativePDFBoxType nativePDFBoxType;
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        pdfBox.getClass();
        int i2 = mr.b.d[pdfBox.ordinal()];
        if (i2 == 1) {
            nativePDFBoxType = NativePDFBoxType.CROPBOX;
        } else if (i2 == 2) {
            nativePDFBoxType = NativePDFBoxType.MEDIABOX;
        } else if (i2 == 3) {
            nativePDFBoxType = NativePDFBoxType.BLEEDBOX;
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            nativePDFBoxType = NativePDFBoxType.TRIMBOX;
        }
        nativeProcessorConfiguration.changeBox(i, nativePDFBoxType, rectF);
        return nativeProcessorConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeProcessorConfiguration lambda$setPageLabel$21(int i, String str, NativeProcessorConfiguration nativeProcessorConfiguration) {
        checkDestinationIndexOrThrow(nativeProcessorConfiguration, i);
        nativeProcessorConfiguration.setPageLabel(i, str);
        return nativeProcessorConfiguration;
    }

    static /* synthetic */ NativeProcessorConfiguration lambda$stripEmptyPages$5(boolean z, NativeProcessorConfiguration nativeProcessorConfiguration) {
        nativeProcessorConfiguration.setShouldStripGeneratedBlankPages(z);
        return nativeProcessorConfiguration;
    }

    static /* synthetic */ NativeProcessorConfiguration lambda$withMetadata$14(HashMap map, NativeProcessorConfiguration nativeProcessorConfiguration) {
        nativeProcessorConfiguration.clearMetadata();
        nativeProcessorConfiguration.updateMetadata(map);
        return nativeProcessorConfiguration;
    }

    public static PdfProcessorTask newPage(NewPage newPage) {
        uw.a(newPage, "newPage", null);
        return new PdfProcessorTask(newPage);
    }

    public PdfProcessorTask addCanvasDrawingToPage(final PageCanvas pageCanvas, final int i) {
        uw.a(pageCanvas, "pageCanvas", null);
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda15
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$addCanvasDrawingToPage$16(i, pageCanvas, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask addImageToPage(final PageImage pageImage, final int i) {
        if (pageImage == null) {
            throw new IllegalArgumentException("Image must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda24
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$addImageToPage$15(i, pageImage, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask addNewPage(final NewPage newPage, final int i) {
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Adding new pages requires document editor feature in your license!");
        }
        if (newPage == null) {
            throw new IllegalArgumentException("New page configuration must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$addNewPage$10(i, newPage, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask applyRedactions() {
        if (!ar.b().a(NativeLicenseFeatures.REDACTION)) {
            throw new InvalidNutrientLicenseException("Redacting requires Redaction License.");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda10
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$applyRedactions$24(nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask changeAllAnnotations(final AnnotationProcessingMode annotationProcessingMode) {
        if (annotationProcessingMode == null) {
            throw new IllegalArgumentException("Processing mode must not be null.");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$changeAllAnnotations$9(annotationProcessingMode, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask changeAnnotations(final List<Annotation> list, final AnnotationProcessingMode annotationProcessingMode) {
        if (this.sourceDocument == null) {
            return this;
        }
        if (list == null) {
            throw new IllegalArgumentException("List of annotations must not be null.");
        }
        if (annotationProcessingMode == null) {
            throw new IllegalArgumentException("Processing mode must not be null.");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$changeAnnotations$8(list, annotationProcessingMode, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask changeAnnotationsOfType(final AnnotationType annotationType, final AnnotationProcessingMode annotationProcessingMode) {
        if (annotationType == null) {
            throw new IllegalArgumentException("Annotation type must not be null!");
        }
        if (annotationProcessingMode == null) {
            throw new IllegalArgumentException("Processing mode must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda6
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$changeAnnotationsOfType$6(annotationType, annotationProcessingMode, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask changeFormsOfType(final FormType formType, final AnnotationProcessingMode annotationProcessingMode) {
        if (formType == null) {
            throw new IllegalArgumentException("Form type must not be null!");
        }
        if (annotationProcessingMode == null) {
            throw new IllegalArgumentException("Processing mode must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda19
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$changeFormsOfType$7(formType, annotationProcessingMode, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask changeStrokeColorOnPage(final int i, final int i2) {
        if (!ar.b().a(NativeLicenseFeatures.COMPARISON)) {
            throw new InvalidNutrientLicenseException("Changing page stroke color requires document comparison feature in your license.");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda12
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$changeStrokeColorOnPage$19(i, i2, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask clearPageLabels() {
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda25
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$clearPageLabels$20(nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public NativeProcessorConfiguration getProcessorConfiguration() {
        NativeProcessorConfiguration nativeProcessorConfigurationCreate = this.initialConfigurationFactory.create();
        if (nativeProcessorConfigurationCreate == null) {
            throw new NullPointerException("Mapped configuration may not be null!");
        }
        Iterator<NativeProcessorConfigurationMapper> it = this.configurationMappers.iterator();
        while (it.hasNext()) {
            nativeProcessorConfigurationCreate = it.next().apply(nativeProcessorConfigurationCreate);
            if (nativeProcessorConfigurationCreate == null) {
                throw new NullPointerException("Mapped configuration may not be null!");
            }
        }
        return nativeProcessorConfigurationCreate;
    }

    public PdfProcessorTask keepPages(final Set<Integer> set) {
        if (set == null) {
            throw new IllegalArgumentException("Set of pages to keep must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$keepPages$2(set, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask mergePage(final PagePdf pagePdf, final int i) {
        uw.a(pagePdf, "pagePdf", null);
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda17
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$mergePage$17(i, pagePdf, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask movePages(final Set<Integer> set, final int i) {
        if (set == null) {
            throw new IllegalArgumentException("Set of pages to move must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$movePages$4(set, i, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask performOcrOnPages(final Set<Integer> set, final OcrLanguage ocrLanguage) {
        uw.a(set, "Provided page indexes for OCR processing cannot be empty.");
        set.getClass();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("Provided page indexes for OCR processing cannot contain null elements.");
            }
        }
        uw.a(ocrLanguage, "ocrLanguage", null);
        if (!ar.b().a(NativeLicenseFeatures.OCR)) {
            throw new InvalidNutrientLicenseException("Performing OCR requires OCR License.");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda22
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$performOcrOnPages$25(ocrLanguage, set, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask removePages(final Set<Integer> set) {
        if (set == null) {
            throw new IllegalArgumentException("Set of pages to remove must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda23
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$removePages$3(set, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask resizePage(final int i, final Size size) {
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Scaling pages requires document editor feature in your license!");
        }
        if (size.width <= 0.0f || size.height <= 0.0f) {
            throw new IllegalArgumentException("Page size must be positive!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda7
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$resizePage$13(i, size, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask rotatePage(final int i, final int i2) {
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Rotating pages requires document editor feature in your license!");
        }
        int iAbs = Math.abs(i2);
        if (iAbs != 0 && iAbs != 90 && iAbs != 180 && iAbs != 270) {
            throw new IllegalArgumentException("Rotation value may only be 0, 90, 180 or 270.");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda21
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$rotatePage$12(i, i2, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask setFormFieldNameMappings(final Map<String, String> map) {
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Renaming fields / mappings in forms requires Document Editor license.");
        }
        if (map == null) {
            throw new IllegalArgumentException("formFieldNameMapping must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda18
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$setFormFieldNameMappings$22(map, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask setFormMappingNameMappings(final Map<String, String> map) {
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Renaming fields / mappings in forms requires Document Editor license.");
        }
        if (map == null) {
            throw new IllegalArgumentException("formFieldNameMapping must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda8
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$setFormMappingNameMappings$23(map, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask setPageBox(final int i, final PdfBox pdfBox, final RectF rectF) {
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Modifying page box requires document editor feature in your license!");
        }
        if (pdfBox == null) {
            throw new IllegalArgumentException("Box parameter must not be null.");
        }
        if (rectF == null) {
            throw new IllegalArgumentException("Box rect must not be null.");
        }
        if (rectF.width() == 0.0f && rectF.height() == 0.0f) {
            throw new IllegalArgumentException("Rect sizes must not be zero!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda14
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$setPageBox$11(i, pdfBox, rectF, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask setPageLabel(final int i, final String str) {
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda13
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return this.f$0.lambda$setPageLabel$21(i, str, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask stripEmptyPages(final boolean z) {
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda16
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$stripEmptyPages$5(z, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask withMetadata(final HashMap<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("Metadata must not be null!");
        }
        this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda9
            @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
            public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                return PdfProcessorTask.lambda$withMetadata$14(map, nativeProcessorConfiguration);
            }
        });
        return this;
    }

    public PdfProcessorTask mergePage(final PagePdf pagePdf, final int i, final BlendMode blendMode) {
        uw.a(pagePdf, "pagePdf", null);
        uw.a(blendMode, "blendMode", null);
        if (ar.b().a(NativeLicenseFeatures.COMPARISON)) {
            if (pagePdf.getPosition() == null) {
                this.configurationMappers.add(new NativeProcessorConfigurationMapper() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda20
                    @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationMapper
                    public final NativeProcessorConfiguration apply(NativeProcessorConfiguration nativeProcessorConfiguration) {
                        return this.f$0.lambda$mergePage$18(i, pagePdf, blendMode, nativeProcessorConfiguration);
                    }
                });
                return this;
            }
            throw new IllegalArgumentException("Page position parameter of PagePdf is not supported when using blendMode.");
        }
        throw new InvalidNutrientLicenseException("Adding page for comparison requires document comparison feature in your license.");
    }

    private PdfProcessorTask(NewPage newPage) {
        this();
        uw.a(newPage, "newPage", null);
        addNewPage(newPage, 0);
    }

    private PdfProcessorTask() {
        this.configurationMappers = new ArrayList();
        if (Nutrient.isInitialized()) {
            this.sourceDocument = null;
            this.initialConfigurationFactory = new NativeProcessorConfigurationFactory() { // from class: com.pspdfkit.document.processor.PdfProcessorTask$$ExternalSyntheticLambda11
                @Override // com.pspdfkit.document.processor.PdfProcessorTask.NativeProcessorConfigurationFactory
                public final NativeProcessorConfiguration create() {
                    return NativeProcessorConfiguration.create(null);
                }
            };
            return;
        }
        throw new NutrientNotInitializedException("PSPDFKit must be initialized with the initialize() call before use of processor.");
    }
}
