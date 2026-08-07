package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSSplitHostManagerInterface;

/* JADX INFO: loaded from: classes13.dex */
public class RNSSplitHostManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSSplitHostManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSSplitHostManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "preferredSplitBehavior":
                ((RNSSplitHostManagerInterface) this.mViewManager).setPreferredSplitBehavior(t, (String) obj);
                break;
            case "orientation":
                ((RNSSplitHostManagerInterface) this.mViewManager).setOrientation(t, (String) obj);
                break;
            case "primaryEdge":
                ((RNSSplitHostManagerInterface) this.mViewManager).setPrimaryEdge(t, (String) obj);
                break;
            case "showInspector":
                ((RNSSplitHostManagerInterface) this.mViewManager).setShowInspector(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "showSecondaryToggleButton":
                ((RNSSplitHostManagerInterface) this.mViewManager).setShowSecondaryToggleButton(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "preferredDisplayMode":
                ((RNSSplitHostManagerInterface) this.mViewManager).setPreferredDisplayMode(t, (String) obj);
                break;
            case "primaryBackgroundStyle":
                ((RNSSplitHostManagerInterface) this.mViewManager).setPrimaryBackgroundStyle(t, (String) obj);
                break;
            case "topColumnForCollapsing":
                ((RNSSplitHostManagerInterface) this.mViewManager).setTopColumnForCollapsing(t, (String) obj);
                break;
            case "presentsWithGesture":
                ((RNSSplitHostManagerInterface) this.mViewManager).setPresentsWithGesture(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "displayModeButtonVisibility":
                ((RNSSplitHostManagerInterface) this.mViewManager).setDisplayModeButtonVisibility(t, (String) obj);
                break;
            case "columnMetrics":
                ((RNSSplitHostManagerInterface) this.mViewManager).setColumnMetrics(t, (ReadableMap) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("showColumn")) {
            ((RNSSplitHostManagerInterface) this.mViewManager).showColumn(t, readableArray.getString(0));
        }
    }
}
