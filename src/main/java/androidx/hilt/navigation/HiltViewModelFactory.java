package androidx.hilt.navigation;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiltNavBackStackEntry.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0005\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0005¨\u0006\b"}, d2 = {"HiltViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "context", "Landroid/content/Context;", "delegateFactory", PasskeyWebListener.CREATE_UNIQUE_KEY, "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "hilt-navigation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HiltViewModelFactory {
    public static final ViewModelProvider.Factory create(Context context, NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        return create(context, navBackStackEntry.getDefaultViewModelProviderFactory());
    }

    public static final ViewModelProvider.Factory create(Context context, ViewModelProvider.Factory delegateFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
        while (context instanceof ContextWrapper) {
            if (!(context instanceof ComponentActivity)) {
                context = ((ContextWrapper) context).getBaseContext();
                Intrinsics.checkNotNullExpressionValue(context, "ctx.baseContext");
            } else {
                ViewModelProvider.Factory factoryCreateInternal = dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.createInternal((ComponentActivity) context, delegateFactory);
                Intrinsics.checkNotNullExpressionValue(factoryCreateInternal, "createInternal(\n        … */ delegateFactory\n    )");
                return factoryCreateInternal;
            }
        }
        throw new IllegalStateException("Expected an activity context for creating a HiltViewModelFactory but instead found: " + context);
    }
}
