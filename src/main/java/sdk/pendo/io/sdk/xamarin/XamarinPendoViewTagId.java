package sdk.pendo.io.sdk.xamarin;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import sdk.pendo.io.R;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/sdk/xamarin/XamarinPendoViewTagId;", "", "()V", "pendoViewTagId", "", "getPendoViewTagId$annotations", "getPendoViewTagId", "()I", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XamarinPendoViewTagId {
    public static final XamarinPendoViewTagId INSTANCE = new XamarinPendoViewTagId();
    private static final int pendoViewTagId = R.id.pnd_maui_view_tag;

    private XamarinPendoViewTagId() {
    }

    public static final int getPendoViewTagId() {
        return pendoViewTagId;
    }

    @JvmStatic
    public static /* synthetic */ void getPendoViewTagId$annotations() {
    }
}
