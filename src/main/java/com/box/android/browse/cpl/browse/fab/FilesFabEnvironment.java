package com.box.android.browse.cpl.browse.fab;

import com.box.android.browse.cpl.browse.fab.newfile.NewFileMenuUtils;
import com.box.android.domain.identity.IUserContextManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesFabReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabEnvironment;", "", "fabManager", "Lcom/box/android/browse/cpl/browse/fab/FabManager;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "uploadHelper", "Lcom/box/android/browse/cpl/browse/fab/UploadHelper;", "newFileMenuUtils", "Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileMenuUtils;", "analytics", "Lcom/box/android/browse/cpl/browse/fab/FilesFabAnalytics;", "<init>", "(Lcom/box/android/browse/cpl/browse/fab/FabManager;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/browse/cpl/browse/fab/UploadHelper;Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileMenuUtils;Lcom/box/android/browse/cpl/browse/fab/FilesFabAnalytics;)V", "getFabManager", "()Lcom/box/android/browse/cpl/browse/fab/FabManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getUploadHelper", "()Lcom/box/android/browse/cpl/browse/fab/UploadHelper;", "getNewFileMenuUtils", "()Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileMenuUtils;", "getAnalytics", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabAnalytics;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesFabEnvironment {
    public static final int $stable = 8;
    private final FilesFabAnalytics analytics;
    private final FabManager fabManager;
    private final NewFileMenuUtils newFileMenuUtils;
    private final UploadHelper uploadHelper;
    private final IUserContextManager userContextManager;

    @Inject
    public FilesFabEnvironment(FabManager fabManager, IUserContextManager userContextManager, UploadHelper uploadHelper, NewFileMenuUtils newFileMenuUtils, FilesFabAnalytics analytics) {
        Intrinsics.checkNotNullParameter(fabManager, "fabManager");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(uploadHelper, "uploadHelper");
        Intrinsics.checkNotNullParameter(newFileMenuUtils, "newFileMenuUtils");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.fabManager = fabManager;
        this.userContextManager = userContextManager;
        this.uploadHelper = uploadHelper;
        this.newFileMenuUtils = newFileMenuUtils;
        this.analytics = analytics;
    }

    public final FabManager getFabManager() {
        return this.fabManager;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final UploadHelper getUploadHelper() {
        return this.uploadHelper;
    }

    public final NewFileMenuUtils getNewFileMenuUtils() {
        return this.newFileMenuUtils;
    }

    public final FilesFabAnalytics getAnalytics() {
        return this.analytics;
    }
}
