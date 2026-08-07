package sdk.pendo.io.sdk.xamarin;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/sdk/xamarin/XamarinBridge;", "", "addFlyoutListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/sdk/xamarin/XamarinFlyoutPageListener;", "getScreenId", "", "isFlyoutPage", "", "onLayoutChanged", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface XamarinBridge {
    void addFlyoutListener(XamarinFlyoutPageListener listener);

    String getScreenId();

    boolean isFlyoutPage();

    void onLayoutChanged();
}
