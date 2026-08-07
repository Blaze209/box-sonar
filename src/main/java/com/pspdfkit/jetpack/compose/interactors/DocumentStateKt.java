package com.pspdfkit.jetpack.compose.interactors;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.ul;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\t\u001a'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"rememberDocumentState", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "documentUri", "Landroid/net/Uri;", "configuration", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "(Landroid/net/Uri;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "dataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "(Lcom/pspdfkit/document/providers/DataProvider;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "rememberImageDocumentState", "rememberInstantDocumentState", "serverUrl", "", "jwt", "(Ljava/lang/String;Ljava/lang/String;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DocumentStateKt {
    public static final DocumentState rememberDocumentState(final Uri uri, final PdfActivityConfiguration pdfActivityConfiguration, Composer composer, int i, int i2) {
        uri.getClass();
        if ((i2 & 2) != 0) {
            pdfActivityConfiguration = new PdfActivityConfiguration.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).build();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(986069740, i, -1, "com.pspdfkit.jetpack.compose.interactors.rememberDocumentState (DocumentState.kt:49)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] objArr = {uri, pdfActivityConfiguration};
        Saver<DocumentStateWithUri, ?> documentStateSaverWithUri = DocumentSaversKt.getDocumentStateSaverWithUri(context);
        boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(uri) | composer.changedInstance(pdfActivityConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentStateKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DocumentStateKt.rememberDocumentState$lambda$0$0(context, uri, pdfActivityConfiguration);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        DocumentStateWithUri documentStateWithUri = (DocumentStateWithUri) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) documentStateSaverWithUri, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return documentStateWithUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DocumentStateWithUri rememberDocumentState$lambda$0$0(Context context, Uri uri, PdfActivityConfiguration pdfActivityConfiguration) {
        return new DocumentStateWithUri(context, uri, pdfActivityConfiguration, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DocumentStateWithDataProvider rememberDocumentState$lambda$1$0(Context context, DataProvider dataProvider, PdfActivityConfiguration pdfActivityConfiguration) {
        return new DocumentStateWithDataProvider(context, dataProvider, pdfActivityConfiguration, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null));
    }

    public static final DocumentState rememberImageDocumentState(final Uri uri, final PdfActivityConfiguration pdfActivityConfiguration, Composer composer, int i, int i2) {
        uri.getClass();
        if ((i2 & 2) != 0) {
            pdfActivityConfiguration = new PdfActivityConfiguration.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).build();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1078676505, i, -1, "com.pspdfkit.jetpack.compose.interactors.rememberImageDocumentState (DocumentState.kt:99)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] objArr = {uri, pdfActivityConfiguration};
        Saver<ImageDocumentStateWithUri, ?> imageDocumentStateSaverWithUri = DocumentSaversKt.getImageDocumentStateSaverWithUri(context);
        boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(uri) | composer.changedInstance(pdfActivityConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentStateKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DocumentStateKt.rememberImageDocumentState$lambda$0$0(context, uri, pdfActivityConfiguration);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ImageDocumentStateWithUri imageDocumentStateWithUri = (ImageDocumentStateWithUri) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) imageDocumentStateSaverWithUri, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imageDocumentStateWithUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageDocumentStateWithUri rememberImageDocumentState$lambda$0$0(Context context, Uri uri, PdfActivityConfiguration pdfActivityConfiguration) {
        return new ImageDocumentStateWithUri(context, uri, pdfActivityConfiguration, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageDocumentStateWithDataProvider rememberImageDocumentState$lambda$1$0(Context context, DataProvider dataProvider, PdfActivityConfiguration pdfActivityConfiguration) {
        return new ImageDocumentStateWithDataProvider(context, dataProvider, pdfActivityConfiguration, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null));
    }

    public static final DocumentState rememberInstantDocumentState(final String str, final String str2, final PdfActivityConfiguration pdfActivityConfiguration, Composer composer, int i, int i2) {
        str.getClass();
        str2.getClass();
        if ((i2 & 4) != 0) {
            pdfActivityConfiguration = new PdfActivityConfiguration.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).build();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1548885921, i, -1, "com.pspdfkit.jetpack.compose.interactors.rememberInstantDocumentState (DocumentState.kt:150)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] objArr = {str, str2, pdfActivityConfiguration};
        Saver<InstantDocumentState, ?> instantDocumentStateSaver = DocumentSaversKt.getInstantDocumentStateSaver(context);
        boolean z = true;
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(str)) || (i & 6) == 4) | composer.changedInstance(context);
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(str2)) && (i & 48) != 32) {
            z = false;
        }
        boolean zChangedInstance2 = zChangedInstance | z | composer.changedInstance(pdfActivityConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentStateKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DocumentStateKt.rememberInstantDocumentState$lambda$0$0(context, str, str2, pdfActivityConfiguration);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        InstantDocumentState instantDocumentState = (InstantDocumentState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) instantDocumentStateSaver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return instantDocumentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstantDocumentState rememberInstantDocumentState$lambda$0$0(Context context, String str, String str2, PdfActivityConfiguration pdfActivityConfiguration) {
        return new InstantDocumentState(context, new ul(str, str2), pdfActivityConfiguration, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null));
    }

    public static final DocumentState rememberImageDocumentState(final DataProvider dataProvider, final PdfActivityConfiguration pdfActivityConfiguration, Composer composer, int i, int i2) {
        dataProvider.getClass();
        if ((i2 & 2) != 0) {
            pdfActivityConfiguration = new PdfActivityConfiguration.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).build();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2143105894, i, -1, "com.pspdfkit.jetpack.compose.interactors.rememberImageDocumentState (DocumentState.kt:123)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] objArr = {dataProvider, pdfActivityConfiguration};
        Saver<ImageDocumentStateWithDataProvider, ?> imageDocumentStateSaverWithDataProvider = DocumentSaversKt.getImageDocumentStateSaverWithDataProvider(context);
        boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(dataProvider) | composer.changedInstance(pdfActivityConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentStateKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DocumentStateKt.rememberImageDocumentState$lambda$1$0(context, dataProvider, pdfActivityConfiguration);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ImageDocumentStateWithDataProvider imageDocumentStateWithDataProvider = (ImageDocumentStateWithDataProvider) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) imageDocumentStateSaverWithDataProvider, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imageDocumentStateWithDataProvider;
    }

    public static final DocumentState rememberDocumentState(final DataProvider dataProvider, final PdfActivityConfiguration pdfActivityConfiguration, Composer composer, int i, int i2) {
        dataProvider.getClass();
        if ((i2 & 2) != 0) {
            pdfActivityConfiguration = new PdfActivityConfiguration.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).build();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1751669557, i, -1, "com.pspdfkit.jetpack.compose.interactors.rememberDocumentState (DocumentState.kt:74)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] objArr = {dataProvider, pdfActivityConfiguration};
        Saver<DocumentStateWithDataProvider, ?> documentStateSaverWithDataProvider = DocumentSaversKt.getDocumentStateSaverWithDataProvider(context);
        boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(dataProvider) | composer.changedInstance(pdfActivityConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentStateKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DocumentStateKt.rememberDocumentState$lambda$1$0(context, dataProvider, pdfActivityConfiguration);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        DocumentStateWithDataProvider documentStateWithDataProvider = (DocumentStateWithDataProvider) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) documentStateSaverWithDataProvider, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return documentStateWithDataProvider;
    }
}
