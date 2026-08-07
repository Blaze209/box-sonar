package com.box.android.browse.utilities;

import com.box.android.domain.models.DomainError;
import kotlin.Metadata;

/* JADX INFO: compiled from: CreateFolderHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/browse/utilities/ICreateFolderHelper;", "", "getCreateFolderError", "", "error", "Lcom/box/android/domain/models/DomainError;", "getIncorrectCharacterError", "incorrectChar", "", "displayFolderCreatedSuccessfullyToast", "", "sendCreateFolderSucceededAmplitudeEvent", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICreateFolderHelper {
    void displayFolderCreatedSuccessfullyToast();

    String getCreateFolderError(DomainError error);

    String getIncorrectCharacterError(char incorrectChar);

    void sendCreateFolderSucceededAmplitudeEvent();
}
