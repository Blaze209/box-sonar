package com.box.android.utilities;

import android.os.Environment;
import com.box.android.common.utilities.CommonBoxUtil;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes13.dex */
public class FileStorage implements IStorage {
    @Override // com.box.android.utilities.IStorage
    public void saveStringToFile(String str, String str2) throws IOException {
        CommonBoxUtil.writeToFile(new File(Environment.getExternalStorageDirectory(), str), str2, false, false);
    }

    @Override // com.box.android.utilities.IStorage
    public String readStringFromFile(String str) throws IOException {
        return FileUtils.readFileToString(new File(Environment.getExternalStorageDirectory(), str));
    }
}
