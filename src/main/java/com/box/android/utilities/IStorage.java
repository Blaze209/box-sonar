package com.box.android.utilities;

import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public interface IStorage {
    String readStringFromFile(String str) throws IOException;

    void saveStringToFile(String str, String str2) throws IOException;
}
