package sdk.pendo.io.views.custom;

import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/views/custom/PendoCheckableCustomView;", "Lsdk/pendo/io/views/custom/PendoCustomView;", "setCheckedBackgroundColor", "", "color", "", "setCheckedTextColor", "setDefaultBackgroundColor", "setDefaultTextColor", "setDefaultTextSize", "size", "", "setIconSize", "setSelectedCornerRadius", "cornerRadius", "setSelectedIcon", HubsObservability.HUB_ASSET_ICON, "", "setSelectedIconColor", "setSelectedIconSize", "setSelectedStrokeColor", "strokeColor", "setSelectedStrokeWidth", "strokeWidth", "setSelectedTextSize", "setUnselectedIcon", "setUnselectedIconColor", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PendoCheckableCustomView extends PendoCustomView {
    void setCheckedBackgroundColor(int color);

    void setCheckedTextColor(int color);

    void setDefaultBackgroundColor(int color);

    void setDefaultTextColor(int color);

    void setDefaultTextSize(float size);

    void setIconSize(int size);

    void setSelectedCornerRadius(float cornerRadius);

    void setSelectedIcon(String icon);

    void setSelectedIconColor(int color);

    void setSelectedIconSize(int size);

    void setSelectedStrokeColor(int strokeColor);

    void setSelectedStrokeWidth(int strokeWidth);

    void setSelectedTextSize(float size);

    void setUnselectedIcon(String icon);

    void setUnselectedIconColor(int color);
}
