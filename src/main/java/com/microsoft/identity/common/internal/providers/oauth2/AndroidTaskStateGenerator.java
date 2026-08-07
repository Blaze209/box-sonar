package com.microsoft.identity.common.internal.providers.oauth2;

import com.microsoft.identity.common.java.providers.oauth2.DefaultStateGenerator;
import com.microsoft.identity.common.logging.Logger;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidTaskStateGenerator extends DefaultStateGenerator {
    private static final String SPLITTER = ":";
    private static final String TAG = "AndroidTaskStateGenerator";
    private int taskId;

    public int getTaskId() {
        return this.taskId;
    }

    public AndroidTaskStateGenerator(int i) {
        this.taskId = i;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.DefaultStateGenerator, com.microsoft.identity.common.java.providers.oauth2.IStateGenerator
    public String generate() {
        return String.format(Locale.US, "%d%s%s", Integer.valueOf(this.taskId), SPLITTER, super.generate());
    }

    public static int getTaskFromState(String str) {
        String[] strArrSplit = str.split(SPLITTER);
        if (strArrSplit.length >= 2) {
            try {
                return Integer.parseInt(strArrSplit[0]);
            } catch (NumberFormatException e) {
                Logger.error("AndroidTaskStateGenerator:getTaskFromState", "Unable to parse state", e);
            }
        }
        return 0;
    }
}
