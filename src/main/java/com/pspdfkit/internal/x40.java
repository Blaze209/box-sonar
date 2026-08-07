package com.pspdfkit.internal;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class x40 {
    @JvmStatic
    public static final boolean a() {
        String name;
        Context context = n5.a;
        if (context == null) {
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }
        Object systemService = context.getSystemService("input");
        systemService.getClass();
        InputManager inputManager = (InputManager) systemService;
        int[] inputDeviceIds = inputManager.getInputDeviceIds();
        inputDeviceIds.getClass();
        for (int i : inputDeviceIds) {
            InputDevice inputDevice = inputManager.getInputDevice(i);
            if (inputDevice != null && (name = inputDevice.getName()) != null) {
                Locale locale = Locale.ROOT;
                locale.getClass();
                String lowerCase = name.toLowerCase(locale);
                lowerCase.getClass();
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) PointerEventHelper.POINTER_TYPE_PEN, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }
}
