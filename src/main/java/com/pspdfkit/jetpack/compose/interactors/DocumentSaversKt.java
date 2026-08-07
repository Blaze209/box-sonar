package com.pspdfkit.jetpack.compose.interactors;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.fragment.app.Fragment;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.ul;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001a\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001a\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001a\u0010\t\u001a\f\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001a\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\r"}, d2 = {"getDocumentStateSaverWithUri", "Landroidx/compose/runtime/saveable/Saver;", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentStateWithUri;", "context", "Landroid/content/Context;", "getDocumentStateSaverWithDataProvider", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentStateWithDataProvider;", "getImageDocumentStateSaverWithUri", "Lcom/pspdfkit/jetpack/compose/interactors/ImageDocumentStateWithUri;", "getImageDocumentStateSaverWithDataProvider", "Lcom/pspdfkit/jetpack/compose/interactors/ImageDocumentStateWithDataProvider;", "getInstantDocumentStateSaver", "Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentState;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DocumentSaversKt {
    public static final Saver<DocumentStateWithDataProvider, ?> getDocumentStateSaverWithDataProvider(final Context context) {
        context.getClass();
        return ListSaverKt.listSaver(new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DocumentSaversKt.getDocumentStateSaverWithDataProvider$lambda$0$0((SaverScope) obj, (DocumentStateWithDataProvider) obj2);
            }
        }, new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentSaversKt.getDocumentStateSaverWithDataProvider$lambda$0$1(context, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getDocumentStateSaverWithDataProvider$lambda$0$0(SaverScope saverScope, DocumentStateWithDataProvider documentStateWithDataProvider) {
        saverScope.getClass();
        documentStateWithDataProvider.getClass();
        return CollectionsKt.listOf(documentStateWithDataProvider.getDataProvider(), documentStateWithDataProvider.getConfiguration(), documentStateWithDataProvider.getState$sdk_nutrient().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DocumentStateWithDataProvider getDocumentStateSaverWithDataProvider$lambda$0$1(Context context, List list) {
        list.getClass();
        Object obj = list.get(0);
        obj.getClass();
        Object obj2 = list.get(1);
        obj2.getClass();
        return new DocumentStateWithDataProvider(context, (DataProvider) obj, (PdfActivityConfiguration) obj2, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Fragment.SavedState) list.get(2), null, 2, null));
    }

    public static final Saver<DocumentStateWithUri, ?> getDocumentStateSaverWithUri(final Context context) {
        context.getClass();
        return ListSaverKt.listSaver(new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DocumentSaversKt.getDocumentStateSaverWithUri$lambda$0$0((SaverScope) obj, (DocumentStateWithUri) obj2);
            }
        }, new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentSaversKt.getDocumentStateSaverWithUri$lambda$0$1(context, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getDocumentStateSaverWithUri$lambda$0$0(SaverScope saverScope, DocumentStateWithUri documentStateWithUri) {
        saverScope.getClass();
        documentStateWithUri.getClass();
        return CollectionsKt.listOf(documentStateWithUri.getDocumentUri().toString(), documentStateWithUri.getConfiguration(), documentStateWithUri.getState$sdk_nutrient().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DocumentStateWithUri getDocumentStateSaverWithUri$lambda$0$1(Context context, List list) {
        list.getClass();
        Object obj = list.get(0);
        obj.getClass();
        Uri uri = Uri.parse((String) obj);
        Object obj2 = list.get(1);
        obj2.getClass();
        return new DocumentStateWithUri(context, uri, (PdfActivityConfiguration) obj2, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Fragment.SavedState) list.get(2), null, 2, null));
    }

    public static final Saver<ImageDocumentStateWithDataProvider, ?> getImageDocumentStateSaverWithDataProvider(final Context context) {
        context.getClass();
        return ListSaverKt.listSaver(new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DocumentSaversKt.getImageDocumentStateSaverWithDataProvider$lambda$0$0((SaverScope) obj, (ImageDocumentStateWithDataProvider) obj2);
            }
        }, new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentSaversKt.getImageDocumentStateSaverWithDataProvider$lambda$0$1(context, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getImageDocumentStateSaverWithDataProvider$lambda$0$0(SaverScope saverScope, ImageDocumentStateWithDataProvider imageDocumentStateWithDataProvider) {
        saverScope.getClass();
        imageDocumentStateWithDataProvider.getClass();
        return CollectionsKt.listOf(imageDocumentStateWithDataProvider.getDataProvider(), imageDocumentStateWithDataProvider.getConfiguration(), imageDocumentStateWithDataProvider.getState$sdk_nutrient().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageDocumentStateWithDataProvider getImageDocumentStateSaverWithDataProvider$lambda$0$1(Context context, List list) {
        list.getClass();
        Object obj = list.get(0);
        obj.getClass();
        Object obj2 = list.get(1);
        obj2.getClass();
        return new ImageDocumentStateWithDataProvider(context, (DataProvider) obj, (PdfActivityConfiguration) obj2, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Fragment.SavedState) list.get(2), null, 2, null));
    }

    public static final Saver<ImageDocumentStateWithUri, ?> getImageDocumentStateSaverWithUri(final Context context) {
        context.getClass();
        return ListSaverKt.listSaver(new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DocumentSaversKt.getImageDocumentStateSaverWithUri$lambda$0$0((SaverScope) obj, (ImageDocumentStateWithUri) obj2);
            }
        }, new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentSaversKt.getImageDocumentStateSaverWithUri$lambda$0$1(context, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getImageDocumentStateSaverWithUri$lambda$0$0(SaverScope saverScope, ImageDocumentStateWithUri imageDocumentStateWithUri) {
        saverScope.getClass();
        imageDocumentStateWithUri.getClass();
        return CollectionsKt.listOf(imageDocumentStateWithUri.getDocumentUri().toString(), imageDocumentStateWithUri.getConfiguration(), imageDocumentStateWithUri.getState$sdk_nutrient().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageDocumentStateWithUri getImageDocumentStateSaverWithUri$lambda$0$1(Context context, List list) {
        list.getClass();
        Object obj = list.get(0);
        obj.getClass();
        Uri uri = Uri.parse((String) obj);
        Object obj2 = list.get(1);
        obj2.getClass();
        return new ImageDocumentStateWithUri(context, uri, (PdfActivityConfiguration) obj2, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Fragment.SavedState) list.get(2), null, 2, null));
    }

    public static final Saver<InstantDocumentState, ?> getInstantDocumentStateSaver(final Context context) {
        context.getClass();
        return ListSaverKt.listSaver(new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DocumentSaversKt.getInstantDocumentStateSaver$lambda$0$0((SaverScope) obj, (InstantDocumentState) obj2);
            }
        }, new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentSaversKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentSaversKt.getInstantDocumentStateSaver$lambda$0$1(context, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getInstantDocumentStateSaver$lambda$0$0(SaverScope saverScope, InstantDocumentState instantDocumentState) {
        saverScope.getClass();
        instantDocumentState.getClass();
        return CollectionsKt.listOf((Object[]) new Parcelable[]{instantDocumentState.getInstantDocumentSource(), instantDocumentState.getConfiguration(), instantDocumentState.getState$sdk_nutrient().getValue()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstantDocumentState getInstantDocumentStateSaver$lambda$0$1(Context context, List list) {
        list.getClass();
        Object obj = list.get(0);
        obj.getClass();
        Object obj2 = list.get(1);
        obj2.getClass();
        return new InstantDocumentState(context, (ul) obj, (PdfActivityConfiguration) obj2, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Fragment.SavedState) list.get(2), null, 2, null));
    }
}
