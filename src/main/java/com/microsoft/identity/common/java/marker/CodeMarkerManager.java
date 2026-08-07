package com.microsoft.identity.common.java.marker;

import com.microsoft.identity.common.java.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class CodeMarkerManager {
    private static final int MAX_SIZE_CODE_MARKER = 1000;
    private static final String TAG = "CodeMarkerManager";
    private long baseMilliSeconds;
    private final List<CodeMarker> codeMarkers;
    private boolean enableCodeMarker;
    private String scenarioCode;

    private CodeMarkerManager() {
        this.enableCodeMarker = false;
        this.codeMarkers = Collections.synchronizedList(new ArrayList());
        this.baseMilliSeconds = 0L;
        this.scenarioCode = null;
    }

    private static class CodeMarkerHolder {
        static final CodeMarkerManager INSTANCE = new CodeMarkerManager();

        private CodeMarkerHolder() {
        }
    }

    public static CodeMarkerManager getInstance() {
        return CodeMarkerHolder.INSTANCE;
    }

    public void markCode(String str) {
        if (this.enableCodeMarker) {
            Logger.info(TAG + ":markCode", "Marking code with " + str);
            if (this.codeMarkers.size() >= 1000) {
                clearMarkers();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.codeMarkers.size() == 0) {
                this.baseMilliSeconds = jCurrentTimeMillis;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            StringBuilder sb = new StringBuilder();
            String str2 = this.scenarioCode;
            if (str2 == null) {
                str2 = "";
            }
            this.codeMarkers.add(new CodeMarker(sb.append(str2).append(str).toString(), jCurrentTimeMillis - this.baseMilliSeconds, simpleDateFormat.format(new Date()), Thread.currentThread().getId()));
        }
    }

    public void setPrefixScenarioCode(String str) {
        this.scenarioCode = str;
    }

    public boolean codeMarkerIsEnabled() {
        return this.enableCodeMarker;
    }

    public void setEnableCodeMarker(boolean z) {
        this.enableCodeMarker = z;
    }

    public void clearMarkers() {
        this.codeMarkers.clear();
    }

    public void clearAll() {
        clearMarkers();
        this.scenarioCode = null;
    }

    public String getFileContent() {
        return getCsvContent();
    }

    public String getCsvContent() {
        if (this.codeMarkers.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.codeMarkers.get(0).getCsvHeader());
        synchronized (this.codeMarkers) {
            for (CodeMarker codeMarker : this.codeMarkers) {
                sb.append('\n');
                sb.append(codeMarker.getCsvLine());
            }
        }
        return sb.toString();
    }
}
