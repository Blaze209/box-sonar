package com.box.boxandroidlibv2private.requests.requestobjects;

import com.box.androidsdk.content.BoxException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public interface IBoxRequestUploadFileHelper {
    void addCustomProperties(HashMap<String, String> map);

    void checkBasicError() throws BoxException;
}
