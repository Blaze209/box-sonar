package com.pspdfkit.document.providers;

import android.net.Uri;
import com.pspdfkit.document.DocumentSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"getDataProviderFromDocumentSource", "Lcom/pspdfkit/document/providers/DataProvider;", "Lcom/pspdfkit/document/DocumentSource;", "withAiAssistantPdfPassword", "password", "", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DataProvidersHelperKt {

    /* JADX INFO: renamed from: com.pspdfkit.document.providers.DataProvidersHelperKt$withAiAssistantPdfPassword$1, reason: invalid class name */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0010\u0010\t\u001a\t\u0018\u00010\u0004¢\u0006\u0002\b\nH\u0097\u0001J\u000e\u0010\u000b\u001a\u00070\u0004¢\u0006\u0002\b\nH\u0097\u0001J\u001e\u0010\f\u001a\u00070\r¢\u0006\u0002\b\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0097\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"com/pspdfkit/document/providers/DataProvidersHelperKt$withAiAssistantPdfPassword$1", "Lcom/pspdfkit/document/providers/DataProvider;", "Lcom/pspdfkit/document/providers/AiAssistantPdfPasswordProvider;", "pdfPassword", "", "getPdfPassword", "()Ljava/lang/String;", "getSize", "", "getTitle", "Lkotlin/jvm/internal/EnhancedNullability;", "getUid", "read", "", "size", "offset", "release", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 implements DataProvider, AiAssistantPdfPasswordProvider {
        private final /* synthetic */ DataProvider $$delegate_0;
        private final String pdfPassword;

        public AnonymousClass1(DataProvider dataProvider, String str) {
            this.$$delegate_0 = dataProvider;
            this.pdfPassword = str;
        }

        @Override // com.pspdfkit.document.providers.AiAssistantPdfPasswordProvider
        public String getPdfPassword() {
            return this.pdfPassword;
        }

        @Override // com.pspdfkit.document.providers.DataProvider
        public long getSize() {
            return this.$$delegate_0.getSize();
        }

        @Override // com.pspdfkit.document.providers.DataProvider
        public String getTitle() {
            return this.$$delegate_0.getTitle();
        }

        @Override // com.pspdfkit.document.providers.DataProvider
        public String getUid() {
            String uid = this.$$delegate_0.getUid();
            uid.getClass();
            return uid;
        }

        @Override // com.pspdfkit.document.providers.DataProvider
        public byte[] read(long size, long offset) {
            byte[] bArr = this.$$delegate_0.read(size, offset);
            bArr.getClass();
            return bArr;
        }

        @Override // com.pspdfkit.document.providers.DataProvider
        public void release() {
            this.$$delegate_0.release();
        }
    }

    public static final DataProvider getDataProviderFromDocumentSource(DocumentSource documentSource) {
        DataProvider dataProvider;
        String path;
        documentSource.getClass();
        if (documentSource.isFileSource()) {
            Uri fileUri = documentSource.getFileUri();
            if (fileUri == null || (path = fileUri.getPath()) == null) {
                throw new NullPointerException("File source is missing for AI Assistant");
            }
            final File file = new File(path);
            dataProvider = new InputStreamDataProvider() { // from class: com.pspdfkit.document.providers.DataProvidersHelperKt$getDataProviderFromDocumentSource$baseProvider$1
                @Override // com.pspdfkit.document.providers.DataProvider
                public long getSize() {
                    return file.length();
                }

                @Override // com.pspdfkit.document.providers.DataProvider
                public String getTitle() {
                    return file.getName();
                }

                @Override // com.pspdfkit.document.providers.DataProvider
                public String getUid() {
                    String absolutePath = file.getAbsolutePath();
                    absolutePath.getClass();
                    return absolutePath;
                }

                @Override // com.pspdfkit.document.providers.InputStreamDataProvider
                public InputStream openInputStream() throws Exception {
                    return new FileInputStream(file);
                }
            };
        } else {
            dataProvider = documentSource.getDataProvider();
            if (dataProvider == null) {
                throw new NullPointerException("Data provider is missing for AI Assistant");
            }
        }
        String password = documentSource.getPassword();
        return password == null ? dataProvider : withAiAssistantPdfPassword(dataProvider, password);
    }

    private static final DataProvider withAiAssistantPdfPassword(DataProvider dataProvider, String str) {
        return ((dataProvider instanceof AiAssistantPdfPasswordProvider) && Intrinsics.areEqual(((AiAssistantPdfPasswordProvider) dataProvider).getPdfPassword(), str)) ? dataProvider : new AnonymousClass1(dataProvider, str);
    }
}
