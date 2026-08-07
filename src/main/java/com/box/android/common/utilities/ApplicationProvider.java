package com.box.android.common.utilities;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/common/utilities/ApplicationProvider;", "", "<init>", "()V", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "getApplication$annotations", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApplicationProvider {
    public static final ApplicationProvider INSTANCE = new ApplicationProvider();
    public static Application application;

    @JvmStatic
    public static /* synthetic */ void getApplication$annotations() {
    }

    private ApplicationProvider() {
    }

    public static final Application getApplication() {
        Application application2 = application;
        if (application2 != null) {
            return application2;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
        return null;
    }

    public static final void setApplication(Application application2) {
        Intrinsics.checkNotNullParameter(application2, "<set-?>");
        application = application2;
    }
}
