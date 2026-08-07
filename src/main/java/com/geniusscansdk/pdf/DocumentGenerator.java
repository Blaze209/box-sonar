package com.geniusscansdk.pdf;

import android.content.Context;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.core.GeniusScanSDK;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentGenerator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/geniusscansdk/pdf/DocumentGenerator;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "generatePDFDocument", "", "document", "Lcom/geniusscansdk/pdf/PDFDocument;", "configuration", "Lcom/geniusscansdk/pdf/DocumentGenerator$Configuration;", "imageProcessor", "Lcom/geniusscansdk/pdf/PDFImageProcessor;", "generateTIFFDocument", "outputFile", "Ljava/io/File;", "Exception", "PDFAConfiguration", "Configuration", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentGenerator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    public final void generatePDFDocument(PDFDocument document, Configuration configuration) throws IOException, Exception {
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        generatePDFDocument$default(this, document, configuration, null, 4, null);
    }

    public DocumentGenerator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: compiled from: DocumentGenerator.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/pdf/DocumentGenerator$Exception;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "<init>", "(Ljava/lang/String;)V", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Exception extends java.lang.Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Exception(String errorCode) {
            super("Document generation failed with status " + errorCode);
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        }
    }

    /* JADX INFO: compiled from: DocumentGenerator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/geniusscansdk/pdf/DocumentGenerator$PDFAConfiguration;", "", "enabled", "", "customICCProfile", "Ljava/io/File;", "<init>", "(ZLjava/io/File;)V", "getEnabled", "()Z", "getCustomICCProfile", "()Ljava/io/File;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PDFAConfiguration {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final File customICCProfile;
        private final boolean enabled;

        public /* synthetic */ PDFAConfiguration(boolean z, File file, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, file);
        }

        private PDFAConfiguration(boolean z, File file) {
            this.enabled = z;
            this.customICCProfile = file;
        }

        /* synthetic */ PDFAConfiguration(boolean z, File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : file);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final File getCustomICCProfile() {
            return this.customICCProfile;
        }

        /* JADX INFO: compiled from: DocumentGenerator.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/pdf/DocumentGenerator$PDFAConfiguration$Companion;", "", "<init>", "()V", "disabled", "Lcom/geniusscansdk/pdf/DocumentGenerator$PDFAConfiguration;", "enabled", "customICCProfile", "Ljava/io/File;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final PDFAConfiguration disabled() {
                return new PDFAConfiguration(false, null, 2, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final PDFAConfiguration enabled() {
                return new PDFAConfiguration(true, null, 2, 0 == true ? 1 : 0);
            }

            public final PDFAConfiguration enabled(File customICCProfile) {
                Intrinsics.checkNotNullParameter(customICCProfile, "customICCProfile");
                return new PDFAConfiguration(true, customICCProfile, null);
            }
        }
    }

    /* JADX INFO: compiled from: DocumentGenerator.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/geniusscansdk/pdf/DocumentGenerator$Configuration;", "", "outputFile", "Ljava/io/File;", "pdfFontFile", "pdfaConfiguration", "Lcom/geniusscansdk/pdf/DocumentGenerator$PDFAConfiguration;", "<init>", "(Ljava/io/File;Ljava/io/File;Lcom/geniusscansdk/pdf/DocumentGenerator$PDFAConfiguration;)V", "getOutputFile", "()Ljava/io/File;", "getPdfFontFile", "getPdfaConfiguration", "()Lcom/geniusscansdk/pdf/DocumentGenerator$PDFAConfiguration;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Configuration {
        private final File outputFile;
        private final File pdfFontFile;
        private final PDFAConfiguration pdfaConfiguration;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Configuration(File outputFile) {
            this(outputFile, null, null, 6, null);
            Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Configuration(File outputFile, File file) {
            this(outputFile, file, null, 4, null);
            Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        }

        public static /* synthetic */ Configuration copy$default(Configuration configuration, File file, File file2, PDFAConfiguration pDFAConfiguration, int i, Object obj) {
            if ((i & 1) != 0) {
                file = configuration.outputFile;
            }
            if ((i & 2) != 0) {
                file2 = configuration.pdfFontFile;
            }
            if ((i & 4) != 0) {
                pDFAConfiguration = configuration.pdfaConfiguration;
            }
            return configuration.copy(file, file2, pDFAConfiguration);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getOutputFile() {
            return this.outputFile;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final File getPdfFontFile() {
            return this.pdfFontFile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PDFAConfiguration getPdfaConfiguration() {
            return this.pdfaConfiguration;
        }

        public final Configuration copy(File outputFile, File pdfFontFile, PDFAConfiguration pdfaConfiguration) {
            Intrinsics.checkNotNullParameter(outputFile, "outputFile");
            Intrinsics.checkNotNullParameter(pdfaConfiguration, "pdfaConfiguration");
            return new Configuration(outputFile, pdfFontFile, pdfaConfiguration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return Intrinsics.areEqual(this.outputFile, configuration.outputFile) && Intrinsics.areEqual(this.pdfFontFile, configuration.pdfFontFile) && Intrinsics.areEqual(this.pdfaConfiguration, configuration.pdfaConfiguration);
        }

        public int hashCode() {
            int iHashCode = this.outputFile.hashCode() * 31;
            File file = this.pdfFontFile;
            return ((iHashCode + (file == null ? 0 : file.hashCode())) * 31) + this.pdfaConfiguration.hashCode();
        }

        public String toString() {
            return "Configuration(outputFile=" + this.outputFile + ", pdfFontFile=" + this.pdfFontFile + ", pdfaConfiguration=" + this.pdfaConfiguration + ")";
        }

        public Configuration(File outputFile, File file, PDFAConfiguration pdfaConfiguration) {
            Intrinsics.checkNotNullParameter(outputFile, "outputFile");
            Intrinsics.checkNotNullParameter(pdfaConfiguration, "pdfaConfiguration");
            this.outputFile = outputFile;
            this.pdfFontFile = file;
            this.pdfaConfiguration = pdfaConfiguration;
        }

        public final File getOutputFile() {
            return this.outputFile;
        }

        public final File getPdfFontFile() {
            return this.pdfFontFile;
        }

        public /* synthetic */ Configuration(File file, File file2, PDFAConfiguration pDFAConfiguration, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? PDFAConfiguration.INSTANCE.enabled() : pDFAConfiguration);
        }

        public final PDFAConfiguration getPdfaConfiguration() {
            return this.pdfaConfiguration;
        }
    }

    public static /* synthetic */ void generatePDFDocument$default(DocumentGenerator documentGenerator, PDFDocument pDFDocument, Configuration configuration, PDFImageProcessor pDFImageProcessor, int i, Object obj) throws IOException, Exception {
        if ((i & 4) != 0) {
            pDFImageProcessor = new NoopImageProcessor();
        }
        documentGenerator.generatePDFDocument(pDFDocument, configuration, pDFImageProcessor);
    }

    public final void generatePDFDocument(PDFDocument document, Configuration configuration, PDFImageProcessor imageProcessor) throws IOException, Exception {
        File customICCProfile;
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(imageProcessor, "imageProcessor");
        if (configuration.getPdfaConfiguration().getEnabled()) {
            customICCProfile = configuration.getPdfaConfiguration().getCustomICCProfile();
            if (customICCProfile == null) {
                customICCProfile = new File(this.context.getFilesDir(), "AdobeRGB1998.icc");
                INSTANCE.copyAssetToFile(this.context, "AdobeRGB1998.icc", customICCProfile);
            }
        } else {
            customICCProfile = null;
        }
        File pdfFontFile = configuration.getPdfFontFile();
        JNIPDFGeneratorError jNIPDFGeneratorErrorGeneratePDF = JNIPDFGenerator.createWithDocument(document.toJNI$gssdk_release(), new JNIPDFGeneratorConfiguration(pdfFontFile != null ? pdfFontFile.getAbsolutePath() : null, customICCProfile != null ? customICCProfile.getPath() : null, false), PDFImageProcessorKt.toJNI(imageProcessor), GeniusScanSDK.getLogger()).generatePDF(configuration.getOutputFile().getAbsolutePath());
        if (jNIPDFGeneratorErrorGeneratePDF != JNIPDFGeneratorError.SUCCESS) {
            throw new Exception(jNIPDFGeneratorErrorGeneratePDF.name());
        }
    }

    public final void generateTIFFDocument(PDFDocument document, File outputFile) throws Exception {
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        JNIPDFGeneratorError jNIPDFGeneratorErrorGenerateTIFF = JNITIFFGenerator.createWithDocument(document.toJNI$gssdk_release(), GeniusScanSDK.getLogger()).generateTIFF(outputFile.getAbsolutePath());
        if (jNIPDFGeneratorErrorGenerateTIFF != JNIPDFGeneratorError.SUCCESS) {
            throw new Exception(jNIPDFGeneratorErrorGenerateTIFF.name());
        }
    }

    /* JADX INFO: compiled from: DocumentGenerator.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/pdf/DocumentGenerator$Companion;", "", "<init>", "()V", "copyAssetToFile", "", "context", "Landroid/content/Context;", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "", "destinationFile", "Ljava/io/File;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void copyAssetToFile(Context context, String assetName, File destinationFile) throws IOException {
            if (destinationFile.exists()) {
                return;
            }
            InputStream inputStreamOpen = context.getAssets().open(assetName);
            try {
                InputStream inputStream = inputStreamOpen;
                FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
                try {
                    Intrinsics.checkNotNull(inputStream);
                    ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpen, th3);
                    throw th4;
                }
            }
        }
    }
}
