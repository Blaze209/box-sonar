package com.pspdfkit.document;

import android.content.Context;
import android.net.Uri;
import com.pspdfkit.Nutrient;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.activity.ThumbnailBarMode;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.vd;
import com.pspdfkit.internal.zj;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Function;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u0011J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001cJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001a\u0010\u001fJ#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010 R\u001a\u0010#\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b\u0017\u0010!¨\u0006$"}, d2 = {"Lcom/pspdfkit/document/ImageDocumentLoader;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/pspdfkit/document/DocumentSource;", "documentSource", "Lcom/pspdfkit/internal/zj;", "openImageDocument", "(Landroid/content/Context;Lcom/pspdfkit/document/DocumentSource;)Lcom/pspdfkit/internal/zj;", "Landroid/net/Uri;", "documentUri", "Lcom/pspdfkit/document/ImageDocument;", "openDocument", "(Landroid/content/Context;Landroid/net/Uri;)Lcom/pspdfkit/document/ImageDocument;", "source", "(Landroid/content/Context;Lcom/pspdfkit/document/DocumentSource;)Lcom/pspdfkit/document/ImageDocument;", "Lio/reactivex/rxjava3/core/Single;", "openDocumentAsync", "(Landroid/content/Context;Lcom/pspdfkit/document/DocumentSource;)Lio/reactivex/rxjava3/core/Single;", "Lcom/pspdfkit/configuration/PdfConfiguration;", "configuration", "getDefaultImageDocumentConfiguration", "(Lcom/pspdfkit/configuration/PdfConfiguration;)Lcom/pspdfkit/configuration/PdfConfiguration;", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "getDefaultImageDocumentActivityConfiguration", "(Landroid/content/Context;)Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration$Builder;", "builder", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration$Builder;)Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "(Landroid/content/Context;Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "()Lcom/pspdfkit/configuration/PdfConfiguration;", "getDefaultImageDocumentConfiguration$annotations", "defaultImageDocumentConfiguration", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ImageDocumentLoader {
    public static final int $stable = 0;
    public static final ImageDocumentLoader INSTANCE = new ImageDocumentLoader();

    private ImageDocumentLoader() {
    }

    @JvmStatic
    public static final PdfActivityConfiguration getDefaultImageDocumentActivityConfiguration(Context context) {
        context.getClass();
        uw.a(context, "context", null);
        return INSTANCE.getDefaultImageDocumentActivityConfiguration(new PdfActivityConfiguration.Builder(context));
    }

    public static final PdfConfiguration getDefaultImageDocumentConfiguration() {
        return INSTANCE.getDefaultImageDocumentConfiguration(new PdfConfiguration.Builder().build());
    }

    @JvmStatic
    public static /* synthetic */ void getDefaultImageDocumentConfiguration$annotations() {
    }

    @JvmStatic
    public static final ImageDocument openDocument(Context context, Uri documentUri) throws NutrientNotInitializedException, IOException {
        context.getClass();
        documentUri.getClass();
        Nutrient.ensureInitialized();
        return openDocument(context, new DocumentSource(documentUri));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openDocumentAsync$lambda$0(Context context, DocumentSource documentSource, SingleEmitter singleEmitter) {
        singleEmitter.getClass();
        try {
            ImageDocumentLoader imageDocumentLoader = INSTANCE;
            context.getClass();
            singleEmitter.onSuccess(imageDocumentLoader.openImageDocument(context, documentSource));
        } catch (Throwable th) {
            singleEmitter.tryOnError(th);
        }
    }

    private final zj openImageDocument(Context context, DocumentSource documentSource) throws IOException {
        return new zj(vd.a(context, documentSource));
    }

    public final Single<ImageDocument> openDocumentAsync(Context context, Uri documentUri) throws NutrientNotInitializedException {
        context.getClass();
        documentUri.getClass();
        Nutrient.ensureInitialized();
        return openDocumentAsync(context, new DocumentSource(documentUri));
    }

    private final PdfConfiguration getDefaultImageDocumentConfiguration(PdfConfiguration configuration) {
        return PdfConfiguration.copy$default(configuration, null, null, PageFitMode.FIT_TO_SCREEN, PageLayoutMode.SINGLE, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -131085, -1, 15, null);
    }

    @JvmStatic
    public static final PdfActivityConfiguration getDefaultImageDocumentActivityConfiguration(PdfActivityConfiguration configuration) {
        configuration.getClass();
        uw.a(configuration, "configuration", null);
        return INSTANCE.getDefaultImageDocumentActivityConfiguration(new PdfActivityConfiguration.Builder(configuration));
    }

    @JvmStatic
    public static final ImageDocument openDocument(Context context, DocumentSource source) throws IOException {
        context.getClass();
        source.getClass();
        Nutrient.ensureInitialized();
        try {
            return INSTANCE.openImageDocument(context, source);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                Throwable cause = e.getCause();
                cause.getClass();
                throw ((IOException) cause);
            }
            throw e;
        }
    }

    @JvmStatic
    public static final Single<ImageDocument> openDocumentAsync(Context context, final DocumentSource source) {
        context.getClass();
        source.getClass();
        Nutrient.ensureInitialized();
        final Context applicationContext = context.getApplicationContext();
        Single<ImageDocument> map = Single.create(new SingleOnSubscribe() { // from class: com.pspdfkit.document.ImageDocumentLoader$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                ImageDocumentLoader.openDocumentAsync$lambda$0(applicationContext, source, singleEmitter);
            }
        }).map(new Function() { // from class: com.pspdfkit.document.ImageDocumentLoader.openDocumentAsync.2
            @Override // io.reactivex.rxjava3.functions.Function
            public final ImageDocument apply(zj zjVar) {
                zjVar.getClass();
                return zjVar;
            }
        });
        map.getClass();
        return map;
    }

    private final PdfActivityConfiguration getDefaultImageDocumentActivityConfiguration(PdfActivityConfiguration.Builder builder) {
        return builder.bookmarkListEnabled(false).setThumbnailBarMode(ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE).pageNumberOverlayEnabled(false).configuration(getDefaultImageDocumentConfiguration(builder.build().getConfiguration())).enabledAnnotationTools(new ArrayList(EnumSet.complementOf(EnumSet.of(AnnotationTool.NONE, AnnotationTool.HIGHLIGHT, AnnotationTool.STRIKEOUT, AnnotationTool.UNDERLINE, AnnotationTool.SQUIGGLY)))).build();
    }
}
