package com.pspdfkit.document;

import android.net.Uri;
import com.pspdfkit.Nutrient;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.providers.UrlDataProvider;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeDataDescriptor;
import com.pspdfkit.internal.jni.NativeDocument;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DocumentSource {
    private final boolean checkpointAlreadyCreated;
    private final File checkpointFile;
    private final String contentSignature;
    private final DataProvider dataProvider;
    private final Uri fileUri;
    private final String password;
    private String uid;

    public DocumentSource(Uri uri) {
        this(uri, null, null, null);
    }

    private static URL getAsHttpOrHttpsUrl(Uri uri) {
        if (!Objects.equals(uri.getScheme(), "http") && !Objects.equals(uri.getScheme(), "https")) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    public DocumentSource cloneWithPassword(String str) {
        return new DocumentSource(this.fileUri, this.dataProvider, str, this.contentSignature);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentSource)) {
            return false;
        }
        DocumentSource documentSource = (DocumentSource) obj;
        Uri uri = this.fileUri;
        Uri uri2 = documentSource.fileUri;
        if (uri == null ? uri2 != null : !uri.equals(uri2)) {
            return false;
        }
        DataProvider dataProvider = this.dataProvider;
        DataProvider dataProvider2 = documentSource.dataProvider;
        if (dataProvider == null ? dataProvider2 != null : !dataProvider.equals(dataProvider2)) {
            return false;
        }
        String str = this.contentSignature;
        String str2 = documentSource.contentSignature;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.password;
        String str4 = documentSource.password;
        if (str3 != null) {
            return str3.equals(str4);
        }
        return str4 == null;
    }

    public File getCheckpointFile() {
        return this.checkpointFile;
    }

    public String getContentSignature() {
        return this.contentSignature;
    }

    public DataProvider getDataProvider() {
        return this.dataProvider;
    }

    public Uri getFileUri() {
        return this.fileUri;
    }

    public String getPassword() {
        return this.password;
    }

    public synchronized String getUid() {
        ArrayList arrayList;
        if (this.uid == null) {
            if (!Nutrient.isInitialized()) {
                throw new NutrientNotInitializedException("PSPDFKit must be initialized before invocation of any functions.");
            }
            NativeDataDescriptor dataDescriptor = toDataDescriptor();
            if (dataDescriptor == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(dataDescriptor);
            }
            this.uid = NativeDocument.generateUid(arrayList, null);
        }
        return this.uid;
    }

    public int hashCode() {
        Uri uri = this.fileUri;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        DataProvider dataProvider = this.dataProvider;
        int iHashCode2 = (iHashCode + (dataProvider != null ? dataProvider.hashCode() : 0)) * 31;
        String str = this.contentSignature;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.password;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean isCheckpointAlreadyCreated() {
        return this.checkpointAlreadyCreated;
    }

    public boolean isFileSource() {
        return this.dataProvider == null;
    }

    public boolean isRemoteSource() {
        return this.dataProvider instanceof UrlDataProvider;
    }

    public NativeDataDescriptor toDataDescriptor() {
        Uri uri = this.fileUri;
        String path = uri != null ? uri.getPath() : null;
        DataProviderShim dataProviderShim = this.dataProvider != null ? new DataProviderShim(this.dataProvider) : null;
        String str = this.password;
        String path2 = null;
        DataProviderShim dataProviderShim2 = dataProviderShim;
        String str2 = this.contentSignature;
        File file = this.checkpointFile;
        if (file != null && this.checkpointAlreadyCreated) {
            path2 = file.getPath();
        }
        return new NativeDataDescriptor(path, dataProviderShim2, str, str2, path2);
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder("DocumentSource{");
        if (isFileSource()) {
            sb = new StringBuilder("File,uri=");
            obj = this.fileUri;
        } else {
            sb = new StringBuilder("DataProvider,provider=");
            obj = this.dataProvider;
        }
        return sb2.append(sb.append(obj).toString()).append(this.password != null ? ",password=" + this.password : "").append(this.contentSignature != null ? ",contentSignature=" + this.contentSignature : "").append(this.checkpointFile != null ? ",checkpointFile=" + this.checkpointFile : "").append(",checkpointAlreadyCreated=").append(this.checkpointAlreadyCreated).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public DocumentSource(Uri uri, String str) {
        this(uri, null, str, null);
    }

    public DocumentSource(Uri uri, String str, String str2) {
        this(uri, null, str, str2);
    }

    public DocumentSource(DataProvider dataProvider) {
        this(null, dataProvider, null, null);
    }

    public DocumentSource(DataProvider dataProvider, String str) {
        this(null, dataProvider, str, null);
    }

    public DocumentSource(DataProvider dataProvider, String str, String str2) {
        this(null, dataProvider, str, str2);
    }

    public DocumentSource(Uri uri, DataProvider dataProvider, String str, String str2) {
        this(uri, dataProvider, str, str2, null, false);
    }

    public DocumentSource(Uri uri, DataProvider dataProvider, String str, String str2, File file, boolean z) {
        URL asHttpOrHttpsUrl;
        if (uri == null && dataProvider == null) {
            throw new IllegalArgumentException("Either data provider or file URI must be passed to create a DocumentSource!");
        }
        if (uri != null && dataProvider == null && (asHttpOrHttpsUrl = getAsHttpOrHttpsUrl(uri)) != null) {
            this.fileUri = null;
            this.dataProvider = new UrlDataProvider(asHttpOrHttpsUrl, null);
        } else {
            this.fileUri = uri;
            this.dataProvider = dataProvider;
        }
        this.password = str;
        this.contentSignature = str2;
        this.checkpointFile = file;
        this.checkpointAlreadyCreated = z;
        if (isFileSource()) {
            return;
        }
        this.uid = this.dataProvider.getUid();
    }

    public DocumentSource(DocumentSource documentSource, File file, boolean z) {
        this(documentSource.getFileUri(), documentSource.getDataProvider(), documentSource.getPassword(), documentSource.getContentSignature(), file, z);
    }
}
