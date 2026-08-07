package com.pspdfkit.instant.ui;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.ul;
import com.pspdfkit.ui.DocumentCoordinator;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUiFragment;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\u001aJ\u0017\u0010\"\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\"\u0010\u001aJ\u001d\u0010%\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J!\u0010*\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b*\u0010+J1\u0010/\u001a\u00020\u00122\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0,2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010,H\u0016¢\u0006\u0004\b/\u00100J!\u00103\u001a\u00020\u00122\u0006\u00102\u001a\u0002012\b\u0010)\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b3\u00104J1\u00106\u001a\u00020\u00122\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010,2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010,H\u0016¢\u0006\u0004\b6\u00100J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006="}, d2 = {"Lcom/pspdfkit/instant/ui/InstantPdfUiFragment;", "Lcom/pspdfkit/ui/PdfUiFragment;", "Lcom/pspdfkit/instant/listeners/InstantDocumentListener;", "<init>", "()V", "Lcom/pspdfkit/internal/cw;", "createImplementation", "()Lcom/pspdfkit/internal/cw;", "Lcom/pspdfkit/instant/ui/InstantPdfFragment;", "getPdfFragment", "()Lcom/pspdfkit/instant/ui/InstantPdfFragment;", "Lcom/pspdfkit/instant/document/InstantPdfDocument;", "getDocument", "()Lcom/pspdfkit/instant/document/InstantPdfDocument;", "requirePdfFragment", "instantDocument", "Lcom/pspdfkit/instant/exceptions/InstantException;", "error", "", "onAuthenticationFailed", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;Lcom/pspdfkit/instant/exceptions/InstantException;)V", "", "validJwt", "onAuthenticationFinished", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;Ljava/lang/String;)V", "onSyncStarted", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;)V", "onSyncError", "onSyncFinished", "Lcom/pspdfkit/instant/document/InstantDocumentState;", "state", "onDocumentStateChanged", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;Lcom/pspdfkit/instant/document/InstantDocumentState;)V", "onDocumentCorrupted", "onDocumentInvalidated", "serverUrl", "jwt", "setDocument", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", "documentUri", "password", "setDocumentFromUri", "(Landroid/net/Uri;Ljava/lang/String;)V", "", "documentUris", "passwords", "setDocumentFromUris", "(Ljava/util/List;Ljava/util/List;)V", "Lcom/pspdfkit/document/providers/DataProvider;", "dataProvider", "setDocumentFromDataProvider", "(Lcom/pspdfkit/document/providers/DataProvider;Ljava/lang/String;)V", "dataProviders", "setDocumentFromDataProviders", "Lcom/pspdfkit/ui/DocumentCoordinator;", "getDocumentCoordinator", "()Lcom/pspdfkit/ui/DocumentCoordinator;", "Lcom/pspdfkit/instant/ui/InstantPdfUiImpl;", "instantImplementation", "Lcom/pspdfkit/instant/ui/InstantPdfUiImpl;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class InstantPdfUiFragment extends PdfUiFragment implements InstantDocumentListener {
    public static final int $stable = 8;
    private InstantPdfUiImpl instantImplementation;

    @Override // com.pspdfkit.ui.PdfUiFragment
    public cw createImplementation() {
        InstantPdfUiImpl instantPdfUiImpl = this.instantImplementation;
        if (instantPdfUiImpl != null) {
            return instantPdfUiImpl;
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        InstantPdfUiImpl instantPdfUiImpl2 = new InstantPdfUiImpl((AppCompatActivity) fragmentActivityRequireActivity, this, this, this.internalPdfUi);
        this.instantImplementation = instantPdfUiImpl2;
        return instantPdfUiImpl2;
    }

    @Override // com.pspdfkit.ui.PdfUi
    public DocumentCoordinator getDocumentCoordinator() {
        throw new NutrientException("DocumentCoordinator is not supported when using InstantPdfUiFragment, use PdfUiFragment instead!");
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFailed(InstantPdfDocument instantDocument, InstantException error) {
        instantDocument.getClass();
        error.getClass();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFinished(InstantPdfDocument instantDocument, String validJwt) {
        instantDocument.getClass();
        validJwt.getClass();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentCorrupted(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentInvalidated(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentStateChanged(InstantPdfDocument instantDocument, InstantDocumentState state) {
        instantDocument.getClass();
        state.getClass();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncError(InstantPdfDocument instantDocument, InstantException error) {
        instantDocument.getClass();
        error.getClass();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncFinished(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncStarted(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
    }

    public final void setDocument(String serverUrl, String jwt) {
        serverUrl.getClass();
        jwt.getClass();
        InstantPdfUiImpl instantPdfUiImpl = this.instantImplementation;
        if (instantPdfUiImpl != null) {
            instantPdfUiImpl.setDocument(new ul(serverUrl, jwt));
        }
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromDataProvider(DataProvider dataProvider, String password) {
        dataProvider.getClass();
        throw new NutrientException("setDocumentFromDataProvider() may not be called when using InstantPdfUiFragment, use PdfUiFragment instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromDataProviders(List<? extends DataProvider> dataProviders, List<String> passwords) {
        dataProviders.getClass();
        throw new NutrientException("setDocumentFromDataProviders() may not be called when using InstantPdfUiFragment, use PdfUiFragment instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromUri(Uri documentUri, String password) throws IllegalStateException {
        documentUri.getClass();
        throw new NutrientException("setDocumentFromUri() may not be called when using InstantPdfUiFragment, use PdfUiFragment instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromUris(List<? extends Uri> documentUris, List<String> passwords) {
        documentUris.getClass();
        throw new NutrientException("setDocumentFromUris() may not be called when using InstantPdfUiFragment, use PdfUiFragment instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public InstantPdfDocument getDocument() {
        InstantPdfFragment pdfFragment = getPdfFragment();
        if (pdfFragment != null) {
            return pdfFragment.getDocument();
        }
        return null;
    }

    @Override // com.pspdfkit.ui.PdfUi
    public InstantPdfFragment getPdfFragment() {
        PdfFragment pdfFragment = super.getPdfFragment();
        if (pdfFragment instanceof InstantPdfFragment) {
            return (InstantPdfFragment) pdfFragment;
        }
        return null;
    }

    @Override // com.pspdfkit.ui.PdfUi
    public InstantPdfFragment requirePdfFragment() {
        InstantPdfFragment pdfFragment = getPdfFragment();
        if (pdfFragment != null) {
            return pdfFragment;
        }
        throw new IllegalStateException("Instant fragment has wrong fragment type. InstantPdfFragment was expected!");
    }
}
