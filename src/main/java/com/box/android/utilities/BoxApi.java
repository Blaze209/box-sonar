package com.box.android.utilities;

import android.os.Build;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonObject;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApi {
    public static boolean isSsoLoginSuccess(String str) {
        return Pattern.matches(".*/auth/([0-9a-zA-Z]{10,70})\\?.*authorized=1", str);
    }

    public static boolean isSsoGetOpenTokenSuccess(String str) {
        return Pattern.matches(".*opentoken=?.*", str);
    }

    public static boolean isSsoLoginError1(String str) {
        return Pattern.matches(".*/auth/([0-9a-zA-Z]{10,70})/error/1", str);
    }

    public static boolean isSsoLoginError2(String str) {
        return Pattern.matches(".*/auth/([0-9a-zA-Z]{10,70})/error/2", str);
    }

    public static String getSsoOpenToken(String str) {
        try {
            for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "utf-8")) {
                if ("opentoken".equals(nameValuePair.getName())) {
                    return nameValuePair.getValue();
                }
            }
            return null;
        } catch (URISyntaxException e) {
            BoxLogUtils.logException(e);
            return null;
        }
    }

    public static String getDeviceTypeIdentifier() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Build.BRAND).append("_").append(Build.MANUFACTURER).append("_").append(Build.DEVICE).append("_").append(Build.MODEL).append("_").append(Build.PRODUCT);
        try {
            return URLEncoder.encode(stringBuffer.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            BoxLogUtils.logException(e);
            return null;
        }
    }

    public static BoxFolder createRootFolder() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("id", "0");
        jsonObject.set("name", CommonBoxUtil.LS(R.string.files));
        jsonObject.set("size", 0.0d);
        jsonObject.set("type", "folder");
        return new BoxFolder(jsonObject);
    }
}
