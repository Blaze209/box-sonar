package com.swmansion.rnscreens.gamma.tabs.screen;

import android.graphics.Color;
import android.util.Log;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;

/* JADX INFO: compiled from: TabsScreenViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\t\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"getOptionalBoolean", "", "Lcom/facebook/react/bridge/ReadableMap;", "key", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Boolean;", "getOptionalString", "getOptionalFloat", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Float;", "getOptionalColor", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Integer;", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TabsScreenViewManagerKt {

    /* JADX INFO: compiled from: TabsScreenViewManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean getOptionalBoolean(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str) && !readableMap.isNull(str) && readableMap.getType(str) == ReadableType.Boolean) {
            return Boolean.valueOf(readableMap.getBoolean(str));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getOptionalString(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str) && !readableMap.isNull(str) && readableMap.getType(str) == ReadableType.String) {
            return readableMap.getString(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float getOptionalFloat(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str) && !readableMap.isNull(str) && readableMap.getType(str) == ReadableType.Number) {
            return Float.valueOf((float) readableMap.getDouble(str));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer getOptionalColor(ReadableMap readableMap, String str) {
        String string;
        if (readableMap.hasKey(str) && !readableMap.isNull(str)) {
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[readableMap.getType(str).ordinal()];
                if (i == 1) {
                    return Integer.valueOf(readableMap.getInt(str));
                }
                if (i == 2 && (string = readableMap.getString(str)) != null) {
                    return Integer.valueOf(Color.parseColor(string));
                }
                return null;
            } catch (Exception e) {
                Log.w(TabsScreenViewManager.TAG, "[RNScreens] Could not parse color for key '" + str + "': " + e.getMessage());
            }
        }
        return null;
    }
}
