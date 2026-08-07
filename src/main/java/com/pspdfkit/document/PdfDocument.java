package com.pspdfkit.document;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.SparseIntArray;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.measurements.SecondaryMeasurementUnit;
import com.pspdfkit.bookmarks.BookmarkProvider;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer;
import com.pspdfkit.document.files.EmbeddedFilesProvider;
import com.pspdfkit.document.metadata.DocumentPdfMetadata;
import com.pspdfkit.document.metadata.DocumentXmpMetadata;
import com.pspdfkit.exceptions.LongTermValidationException;
import com.pspdfkit.forms.FormProvider;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.javascript.JavaScriptProvider;
import com.pspdfkit.projection.PdfProjection;
import com.pspdfkit.signatures.DocumentSignatureInfo;
import com.pspdfkit.signatures.HashAlgorithm;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.cert.X509Certificate;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfDocument {
    public static final int NO_ROTATION = 0;
    public static final int ROTATION_180 = 180;
    public static final int ROTATION_270 = 270;
    public static final int ROTATION_90 = 90;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PageRotation {
    }

    Completable addLongTermValidation(SignatureFormElement signatureFormElement, List<X509Certificate> list) throws LongTermValidationException;

    AnnotationProvider getAnnotationProvider();

    BookmarkProvider getBookmarkProvider();

    byte[] getChangeId();

    int getCharIndexAt(int i, float f, float f2);

    PdfDocumentCheckpointer getCheckpointer();

    DocumentSaveOptions getDefaultDocumentSaveOptions();

    byte[] getDocumentId();

    String getDocumentIdString();

    DocumentSignatureInfo getDocumentSignatureInfo();

    Single<DocumentSignatureInfo> getDocumentSignatureInfoAsync();

    DocumentSource getDocumentSource();

    List<DocumentSource> getDocumentSources();

    EmbeddedFilesProvider getEmbeddedFilesProvider();

    FormProvider getFormProvider();

    byte[] getHashForDocumentRange(int i, List<Long> list, HashAlgorithm hashAlgorithm);

    byte[] getHashForDocumentRange(List<Long> list, HashAlgorithm hashAlgorithm);

    JavaScriptProvider getJavaScriptProvider();

    List<OutlineElement> getOutline();

    Single<List<OutlineElement>> getOutlineAsync();

    PageBinding getPageBinding();

    RectF getPageBox(int i, PdfBox pdfBox);

    int getPageCount();

    Integer getPageIndexForPageLabel(String str, boolean z);

    String getPageLabel(int i, boolean z);

    int getPageRotation(int i);

    Size getPageSize(int i);

    String getPageText(int i);

    String getPageText(int i, int i2, int i3);

    String getPageText(int i, RectF rectF);

    int getPageTextLength(int i);

    List<RectF> getPageTextRects(int i, int i2, int i3);

    List<RectF> getPageTextRects(int i, int i2, int i3, boolean z);

    DocumentPdfMetadata getPdfMetadata();

    PdfProjection getPdfProjection();

    PdfVersion getPdfVersion();

    byte[] getPermanentId();

    EnumSet<DocumentPermissions> getPermissions();

    int getRotationOffset(int i);

    SecondaryMeasurementUnit getSecondaryMeasurementUnit();

    String getTextForBlocks(List<TextBlock> list);

    String getTitle();

    String getUid();

    DocumentXmpMetadata getXmpMetadata();

    boolean hasEmbeddedFile();

    boolean hasOutline();

    boolean hasPermission(DocumentPermissions documentPermissions);

    void initPageCache();

    Completable initPageCacheAsync();

    void invalidateCache();

    void invalidateCacheForPage(int i);

    boolean isAutomaticLinkGenerationEnabled();

    boolean isEncrypted();

    boolean isWatermarkFilteringEnabled();

    boolean isWritableAndCanSave();

    Bitmap renderPageToBitmap(Context context, int i, int i2, int i3);

    Bitmap renderPageToBitmap(Context context, int i, int i2, int i3, PageRenderConfiguration pageRenderConfiguration);

    Single<Bitmap> renderPageToBitmapAsync(Context context, int i, int i2, int i3);

    Single<Bitmap> renderPageToBitmapAsync(Context context, int i, int i2, int i3, PageRenderConfiguration pageRenderConfiguration);

    void save(String str) throws IOException;

    void save(String str, DocumentSaveOptions documentSaveOptions) throws IOException;

    Completable saveAsync(String str);

    Completable saveAsync(String str, DocumentSaveOptions documentSaveOptions);

    boolean saveIfModified() throws IOException;

    boolean saveIfModified(DocumentSaveOptions documentSaveOptions) throws IOException;

    boolean saveIfModified(String str) throws IOException;

    boolean saveIfModified(String str, DocumentSaveOptions documentSaveOptions) throws IOException;

    Single<Boolean> saveIfModifiedAsync();

    Single<Boolean> saveIfModifiedAsync(DocumentSaveOptions documentSaveOptions);

    Single<Boolean> saveIfModifiedAsync(String str);

    Single<Boolean> saveIfModifiedAsync(String str, DocumentSaveOptions documentSaveOptions);

    void setAutomaticLinkGenerationEnabled(boolean z);

    void setPageBinding(PageBinding pageBinding);

    void setRotationOffset(int i, int i2);

    void setRotationOffsets(SparseIntArray sparseIntArray);

    void setSecondaryMeasurementUnit(SecondaryMeasurementUnit secondaryMeasurementUnit);

    void setWatermarkTextFilteringEnabled(boolean z);

    boolean wasModified();
}
