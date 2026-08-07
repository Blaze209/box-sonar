package com.box.android.observability.appstart;

import android.app.Activity;
import com.box.android.coreservices.observability.appstart.AppStartDestinationPageType;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPage;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppStartDestinationPageHolder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/observability/appstart/AppStartDestinationPageHolder;", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPageHolder;", "authenticationAppStartDestinationPage", "Lcom/box/android/observability/appstart/AuthenticationAppStartDestinationPage;", "browseTabAppStartDestinationPage", "Lcom/box/android/observability/appstart/BrowseTabAppStartDestinationPage;", "<init>", "(Lcom/box/android/observability/appstart/AuthenticationAppStartDestinationPage;Lcom/box/android/observability/appstart/BrowseTabAppStartDestinationPage;)V", "appStartDestinationHandlers", "", "Lcom/box/android/coreservices/observability/appstart/AppStartDestinationPageType;", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPage;", "getAppStartDestinationPage", "activity", "Landroid/app/Activity;", "type", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppStartDestinationPageHolder implements IAppStartDestinationPageHolder {
    public static final int $stable = 8;
    private final Map<AppStartDestinationPageType, IAppStartDestinationPage> appStartDestinationHandlers;

    @Inject
    public AppStartDestinationPageHolder(AuthenticationAppStartDestinationPage authenticationAppStartDestinationPage, BrowseTabAppStartDestinationPage browseTabAppStartDestinationPage) {
        Intrinsics.checkNotNullParameter(authenticationAppStartDestinationPage, "authenticationAppStartDestinationPage");
        Intrinsics.checkNotNullParameter(browseTabAppStartDestinationPage, "browseTabAppStartDestinationPage");
        this.appStartDestinationHandlers = MapsKt.mapOf(TuplesKt.to(AppStartDestinationPageType.AuthenticationDestinationPage.INSTANCE, authenticationAppStartDestinationPage), TuplesKt.to(AppStartDestinationPageType.BrowseTabDestinationPage.INSTANCE, browseTabAppStartDestinationPage));
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder
    public IAppStartDestinationPage getAppStartDestinationPage(Activity activity) {
        Object next;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = this.appStartDestinationHandlers.values().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((IAppStartDestinationPage) next).isDestinationActivity(activity)) {
                return (IAppStartDestinationPage) next;
            }
        }
        next = null;
        return (IAppStartDestinationPage) next;
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder
    public IAppStartDestinationPage getAppStartDestinationPage(AppStartDestinationPageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.appStartDestinationHandlers.get(type);
    }
}
