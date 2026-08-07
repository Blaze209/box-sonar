package com.box.android.browse.utilities;

import android.content.Context;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.browse.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.DomainError;
import java.util.Arrays;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: CreateFolderHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/utilities/CreateFolderHelper;", "Lcom/box/android/browse/utilities/ICreateFolderHelper;", "applicationContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getApplicationContext", "()Landroid/content/Context;", "getCreateFolderError", "", "error", "Lcom/box/android/domain/models/DomainError;", "getIncorrectCharacterError", "incorrectChar", "", "displayFolderCreatedSuccessfullyToast", "", "sendCreateFolderSucceededAmplitudeEvent", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderHelper implements ICreateFolderHelper {
    public static final int $stable = 8;
    private final Context applicationContext;

    @Inject
    public CreateFolderHelper(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    @Override // com.box.android.browse.utilities.ICreateFolderHelper
    public String getCreateFolderError(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return CommonBoxUtil.LS(error instanceof DomainError.NameConflict ? R.string.folder_create_error_duplicate_name : R.string.folder_create_error_generic);
    }

    @Override // com.box.android.browse.utilities.ICreateFolderHelper
    public String getIncorrectCharacterError(char incorrectChar) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s '%s'", Arrays.copyOf(new Object[]{CommonBoxUtil.LS(com.box.android.common.R.string.LS_Unsupported_character), Character.valueOf(incorrectChar)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @Override // com.box.android.browse.utilities.ICreateFolderHelper
    public void displayFolderCreatedSuccessfullyToast() {
        BoxPresentationUtils.displayToast(R.string.folder_created_successfully, this.applicationContext, new String[0]);
    }

    @Override // com.box.android.browse.utilities.ICreateFolderHelper
    public void sendCreateFolderSucceededAmplitudeEvent() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_NEW_FOLDER_SUCCEEDED);
    }
}
