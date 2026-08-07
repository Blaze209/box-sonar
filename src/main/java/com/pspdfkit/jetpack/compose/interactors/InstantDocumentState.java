package com.pspdfkit.jetpack.compose.interactors;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.MutableState;
import androidx.core.net.UriKt;
import androidx.fragment.app.Fragment;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.internal.ul;
import kotlin.Metadata;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R*\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentState;", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "Landroid/content/Context;", "context", "Lcom/pspdfkit/internal/ul;", "instantDocumentSource", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "configuration", "Landroidx/compose/runtime/MutableState;", "Landroidx/fragment/app/Fragment$SavedState;", "state", "<init>", "(Landroid/content/Context;Lcom/pspdfkit/internal/ul;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;Landroidx/compose/runtime/MutableState;)V", "", "getTitle", "()Ljava/lang/String;", "Lcom/pspdfkit/internal/ul;", "getInstantDocumentSource", "()Lcom/pspdfkit/internal/ul;", "Landroidx/compose/runtime/MutableState;", "getState$sdk_nutrient", "()Landroidx/compose/runtime/MutableState;", "setState$sdk_nutrient", "(Landroidx/compose/runtime/MutableState;)V", "Landroid/os/Bundle;", "getArguments$sdk_nutrient", "()Landroid/os/Bundle;", "arguments", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InstantDocumentState extends DocumentState {
    public static final int $stable = 8;
    private final ul instantDocumentSource;
    private MutableState<Fragment.SavedState> state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstantDocumentState(Context context, ul ulVar, PdfActivityConfiguration pdfActivityConfiguration, MutableState<Fragment.SavedState> mutableState) {
        super(context, pdfActivityConfiguration);
        context.getClass();
        ulVar.getClass();
        pdfActivityConfiguration.getClass();
        mutableState.getClass();
        this.instantDocumentSource = ulVar;
        this.state = mutableState;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public Bundle getArguments$sdk_nutrient() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("Instant.InstantDocumentSource", this.instantDocumentSource);
        bundle.putParcelable("Nutri.Configuration", getConfiguration());
        return bundle;
    }

    public final ul getInstantDocumentSource() {
        return this.instantDocumentSource;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public MutableState<Fragment.SavedState> getState$sdk_nutrient() {
        return this.state;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public String getTitle() {
        String str = this.instantDocumentSource.a;
        str.getClass();
        return FilesKt.getNameWithoutExtension(UriKt.toFile(Uri.parse(str)));
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public void setState$sdk_nutrient(MutableState<Fragment.SavedState> mutableState) {
        mutableState.getClass();
        this.state = mutableState;
    }
}
