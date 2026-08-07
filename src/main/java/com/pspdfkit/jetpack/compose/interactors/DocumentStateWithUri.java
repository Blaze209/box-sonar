package com.pspdfkit.jetpack.compose.interactors;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.compose.runtime.MutableState;
import androidx.core.net.UriKt;
import androidx.fragment.app.Fragment;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.ui.DocumentDescriptor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/DocumentStateWithUri;", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "context", "Landroid/content/Context;", "documentUri", "Landroid/net/Uri;", "configuration", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "state", "Landroidx/compose/runtime/MutableState;", "Landroidx/fragment/app/Fragment$SavedState;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;Landroidx/compose/runtime/MutableState;)V", "getDocumentUri", "()Landroid/net/Uri;", "getState$sdk_nutrient", "()Landroidx/compose/runtime/MutableState;", "setState$sdk_nutrient", "(Landroidx/compose/runtime/MutableState;)V", "arguments", "Landroid/os/Bundle;", "getArguments$sdk_nutrient", "()Landroid/os/Bundle;", "getTitle", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DocumentStateWithUri extends DocumentState {
    public static final int $stable = 8;
    private final Uri documentUri;
    private MutableState<Fragment.SavedState> state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentStateWithUri(Context context, Uri uri, PdfActivityConfiguration pdfActivityConfiguration, MutableState<Fragment.SavedState> mutableState) {
        super(context, pdfActivityConfiguration);
        context.getClass();
        uri.getClass();
        pdfActivityConfiguration.getClass();
        mutableState.getClass();
        this.documentUri = uri;
        this.state = mutableState;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public Bundle getArguments$sdk_nutrient() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(DocumentDescriptor.fromUris(CollectionsKt.listOf(this.documentUri), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        Unit unit = Unit.INSTANCE;
        bundle.putParcelableArrayList("Nutri.DocumentDescriptors", arrayList);
        bundle.putParcelable("Nutri.Configuration", getConfiguration());
        return bundle;
    }

    public final Uri getDocumentUri() {
        return this.documentUri;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public MutableState<Fragment.SavedState> getState$sdk_nutrient() {
        return this.state;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public String getTitle() {
        try {
            return FilesKt.getNameWithoutExtension(UriKt.toFile(this.documentUri));
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentState
    public void setState$sdk_nutrient(MutableState<Fragment.SavedState> mutableState) {
        mutableState.getClass();
        this.state = mutableState;
    }
}
