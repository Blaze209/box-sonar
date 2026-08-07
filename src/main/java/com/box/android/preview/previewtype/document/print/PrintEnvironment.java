package com.box.android.preview.previewtype.document.print;

import com.box.android.coreservices.utilities.FileActionsManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrintReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/previewtype/document/print/PrintEnvironment;", "", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "<init>", "(Lcom/box/android/coreservices/utilities/FileActionsManager;)V", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrintEnvironment {
    public static final int $stable = 8;
    private final FileActionsManager fileActionsManager;

    @Inject
    public PrintEnvironment(FileActionsManager fileActionsManager) {
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        this.fileActionsManager = fileActionsManager;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }
}
