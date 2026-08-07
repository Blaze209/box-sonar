package com.box.android.preview.fileactions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.preview.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateItemInfoMessages.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"toMessage", "", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "(Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError;", "(Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UpdateItemInfoMessagesKt {
    public static final String toMessage(UpdateItemInfoReducer.NameError nameError, Composer composer, int i) {
        String strStringResource;
        int i2;
        Intrinsics.checkNotNullParameter(nameError, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, -1775773148, "C(toMessage):UpdateItemInfoMessages.kt#bq3m7o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1775773148, i, -1, "com.box.android.preview.fileactions.toMessage (UpdateItemInfoMessages.kt:7)");
        }
        if (nameError instanceof UpdateItemInfoReducer.NameError.EmptyName) {
            composer.startReplaceGroup(-1415974565);
            ComposerKt.sourceInformation(composer, "8@304L183");
            if (((UpdateItemInfoReducer.NameError.EmptyName) nameError).isFile()) {
                i2 = R.string.empty_rename_error_message_file;
            } else {
                i2 = R.string.empty_rename_error_message_folder;
            }
            strStringResource = StringResources_androidKt.stringResource(i2, composer, 0);
            composer.endReplaceGroup();
        } else if (nameError instanceof UpdateItemInfoReducer.NameError.TooLong) {
            composer.startReplaceGroup(-1415967105);
            ComposerKt.sourceInformation(composer, "16@539L123");
            UpdateItemInfoReducer.NameError.TooLong tooLong = (UpdateItemInfoReducer.NameError.TooLong) nameError;
            strStringResource = StringResources_androidKt.stringResource(com.box.android.base.R.string.name_too_long_error, new Object[]{Integer.valueOf(tooLong.getExceedsBy()), Integer.valueOf(tooLong.getLimit())}, composer, 0);
            composer.endReplaceGroup();
        } else {
            if (!(nameError instanceof UpdateItemInfoReducer.NameError.InvalidCharacter)) {
                composer.startReplaceGroup(-1415976295);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-1415961262);
            ComposerKt.sourceInformation(composer, "22@723L63");
            strStringResource = StringResources_androidKt.stringResource(R.string.LS_Unsupported_character, composer, 0) + " " + ((UpdateItemInfoReducer.NameError.InvalidCharacter) nameError).getC();
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }

    public static final String toMessage(UpdateItemInfoReducer.DescriptionError descriptionError, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(descriptionError, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, 37755321, "C(toMessage):UpdateItemInfoMessages.kt#bq3m7o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(37755321, i, -1, "com.box.android.preview.fileactions.toMessage (UpdateItemInfoMessages.kt:28)");
        }
        if (!(descriptionError instanceof UpdateItemInfoReducer.DescriptionError.TooLong)) {
            composer.startReplaceGroup(1923127396);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.startReplaceGroup(1923129595);
        ComposerKt.sourceInformation(composer, "29@953L130");
        UpdateItemInfoReducer.DescriptionError.TooLong tooLong = (UpdateItemInfoReducer.DescriptionError.TooLong) descriptionError;
        String strStringResource = StringResources_androidKt.stringResource(com.box.android.base.R.string.description_too_long_error, new Object[]{Integer.valueOf(tooLong.getExceedsBy()), Integer.valueOf(tooLong.getLimit())}, composer, 0);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }
}
