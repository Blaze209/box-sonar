package com.box.android.auth;

import com.box.android.application.BoxBaseApplication;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.usecases.UserInteractor;
import com.box.android.usercontext.UserContextComponent;
import dagger.hilt.android.EntryPointAccessors;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserContextProxyComponent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/auth/UserContextProxyComponent;", "Lcom/box/android/usercontext/UserContextComponent;", "userInteractor", "Lcom/box/android/domain/usecases/UserInteractor;", "<init>", "(Lcom/box/android/domain/usecases/UserInteractor;)V", "onCreate", "", "contextId", "", "onSoftDestroy", "onHardDestroy", "clearDefaultNoteFolderCache", "DefaultNoteFolderEntryPoint", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserContextProxyComponent extends UserContextComponent {
    public static final int $stable = 8;
    private final UserInteractor userInteractor;

    /* JADX INFO: compiled from: UserContextProxyComponent.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/box/android/auth/UserContextProxyComponent$DefaultNoteFolderEntryPoint;", "", "defaultNoteFolderService", "Lcom/box/android/domain/services/IDefaultNoteFolderService;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface DefaultNoteFolderEntryPoint {
        IDefaultNoteFolderService defaultNoteFolderService();
    }

    @Inject
    public UserContextProxyComponent(UserInteractor userInteractor) {
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        this.userInteractor = userInteractor;
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onCreate(String contextId) throws IUserContextComponent.UserContextComponentCreationException {
        Intrinsics.checkNotNullParameter(contextId, "contextId");
        super.onCreate(contextId);
        this.userInteractor.createUser(contextId);
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() {
        clearDefaultNoteFolderCache();
        super.onSoftDestroy();
        this.userInteractor.shutdownUser();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        clearDefaultNoteFolderCache();
        super.onHardDestroy();
        this.userInteractor.logoutUser();
    }

    private final void clearDefaultNoteFolderCache() {
        BoxBaseApplication boxBaseApplication = BoxBaseApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(boxBaseApplication, "getInstance(...)");
        ((DefaultNoteFolderEntryPoint) EntryPointAccessors.fromApplication(boxBaseApplication, DefaultNoteFolderEntryPoint.class)).defaultNoteFolderService().clearCache();
    }
}
