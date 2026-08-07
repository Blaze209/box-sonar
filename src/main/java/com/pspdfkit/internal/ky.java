package com.pspdfkit.internal;

import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeReflowConfiguration;
import com.pspdfkit.internal.jni.NativeReflowProcessor;
import com.pspdfkit.internal.jni.NativeReflowProcessorCreationResult;
import com.pspdfkit.internal.jni.NativeReflowResult;
import com.pspdfkit.ui.PdfReaderView;
import com.pspdfkit.utils.PdfLog;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ky {
    public final NativeReflowProcessor a;

    public ky(PdfDocument pdfDocument, PdfReaderView pdfReaderView) {
        pdfDocument.getClass();
        if (!ar.b().a(NativeLicenseFeatures.READER_VIEW)) {
            throw new InvalidNutrientLicenseException("Your current license doesn't allow using the reflow processor.");
        }
        NativeReflowConfiguration nativeReflowConfigurationCreate = NativeReflowConfiguration.create(((lm) pdfDocument).y);
        nativeReflowConfigurationCreate.getClass();
        NativeReflowProcessorCreationResult nativeReflowProcessorCreationResultCreate = NativeReflowProcessor.create(nativeReflowConfigurationCreate, new ly(pdfReaderView));
        nativeReflowProcessorCreationResultCreate.getClass();
        if (nativeReflowProcessorCreationResultCreate.getSuccess()) {
            this.a = nativeReflowProcessorCreationResultCreate.getReflowProcessor();
        } else {
            PdfLog.e("Nutri.ReflowProcessor", nativeReflowProcessorCreationResultCreate.getErrorMessage(), new Object[0]);
        }
    }

    public final String a() {
        NativeReflowProcessor nativeReflowProcessor = this.a;
        if (nativeReflowProcessor == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            return String.format("<!doctype html><html><head><meta charset=\"utf-8\"></meta></head><body>%s</body></html>", Arrays.copyOf(new Object[]{"The reflow processor could not be initialized."}, 1));
        }
        NativeReflowResult nativeReflowResultReflowAllPages = nativeReflowProcessor.reflowAllPages();
        nativeReflowResultReflowAllPages.getClass();
        if (nativeReflowResultReflowAllPages.getHasError()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            return String.format("<!doctype html><html><head><meta charset=\"utf-8\"></meta></head><body>%s</body></html>", Arrays.copyOf(new Object[]{nativeReflowResultReflowAllPages.getErrorMessage()}, 1));
        }
        String reflowedDocument = nativeReflowProcessor.getReflowedDocument();
        reflowedDocument.getClass();
        return reflowedDocument;
    }
}
