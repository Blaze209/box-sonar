package com.box.android.preview.previewtype.document.print;

import android.content.Context;
import android.net.Uri;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.document.printing.DocumentPrintManager;
import com.pspdfkit.exceptions.InvalidPasswordException;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrintManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000f"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintManager;", "", "<init>", "()V", Analytics.Event.PRINT, "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/preview/previewtype/document/print/PrintManager$Error;", "context", "Landroid/content/Context;", "documentUri", "Ljava/net/URI;", "password", "", "Error", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrintManager {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: PrintManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintManager$Error;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_PASSWORD", "UNKNOWN_ERROR", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Error {
        INVALID_PASSWORD,
        UNKNOWN_ERROR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Error> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ Result print$default(PrintManager printManager, Context context, URI uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return printManager.print(context, uri, str);
    }

    public final Result<Unit, Error> print(Context context, URI documentUri, String password) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentUri, "documentUri");
        try {
            PdfDocument pdfDocumentOpenDocument = PdfDocumentLoader.openDocument(context, Uri.parse(documentUri.toString()), password);
            Intrinsics.checkNotNullExpressionValue(pdfDocumentOpenDocument, "openDocument(...)");
            DocumentPrintManager.get().print(context, pdfDocumentOpenDocument);
            return new Result.Success(Unit.INSTANCE);
        } catch (InvalidPasswordException unused) {
            return new Result.Error(Error.INVALID_PASSWORD);
        } catch (Exception e) {
            BoxLogUtils.e("Print failed " + e);
            return new Result.Error(Error.UNKNOWN_ERROR);
        }
    }
}
