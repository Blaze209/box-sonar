package com.microsoft.identity.common.java.marker;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes14.dex */
public class CodeMarker {
    private static final String csvNoValue = "NA";
    private static final char csvSeparator = ',';
    private final String marker;
    private final long threadId;
    private final long timeInMilliseconds;
    private final String timeStamp;
    private String cpuUsed = null;
    private String cpuTotal = null;
    private String residentSize = null;
    private String virtualSize = null;
    private String wifiSent = null;
    private String wifiRecv = null;
    private String wwanSent = null;
    private String wwanRecv = null;
    private String appSent = null;
    private String appRecv = null;
    private String battery = null;
    private String systemDiskRead = null;
    private String systemDiskWrite = null;

    public CodeMarker(String str, long j, String str2, long j2) {
        this.marker = str;
        this.timeInMilliseconds = j;
        this.timeStamp = str2;
        this.threadId = j2;
    }

    private LinkedHashMap<String, String> getKeyValuePairsOfCodeMarker() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        String str = this.timeStamp;
        String str2 = csvNoValue;
        if (str == null) {
            str = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.TIMESTAMP, str);
        String str3 = this.marker;
        if (str3 == null) {
            str3 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.MARKER, str3);
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.TIME, Long.toString(this.timeInMilliseconds));
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.THREAD, Long.toString(this.threadId));
        String str4 = this.cpuUsed;
        if (str4 == null) {
            str4 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.CPU_USED, str4);
        String str5 = this.cpuTotal;
        if (str5 == null) {
            str5 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.CPU_TOTAL, str5);
        String str6 = this.residentSize;
        if (str6 == null) {
            str6 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.RESIDENT_SIZE, str6);
        String str7 = this.virtualSize;
        if (str7 == null) {
            str7 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.VIRTUAL_SIZE, str7);
        String str8 = this.wifiSent;
        if (str8 == null) {
            str8 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.WIFI_SENT, str8);
        String str9 = this.wifiRecv;
        if (str9 == null) {
            str9 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.WIFI_RECEIVED, str9);
        String str10 = this.wwanSent;
        if (str10 == null) {
            str10 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.WAN_SENT, str10);
        String str11 = this.wwanRecv;
        if (str11 == null) {
            str11 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.WAN_RECEIVED, str11);
        String str12 = this.appSent;
        if (str12 == null) {
            str12 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.APP_SENT, str12);
        String str13 = this.appRecv;
        if (str13 == null) {
            str13 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.APP_RECEIVED, str13);
        String str14 = this.battery;
        if (str14 == null) {
            str14 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.BATTERY, str14);
        String str15 = this.systemDiskRead;
        if (str15 == null) {
            str15 = csvNoValue;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.SYSTEM_DISK_READ, str15);
        String str16 = this.systemDiskWrite;
        if (str16 != null) {
            str2 = str16;
        }
        linkedHashMap.put(PerfConstants.CodeMarkerParameters.SYSTEM_DISK_WRITE, str2);
        return linkedHashMap;
    }

    public String getCsvHeader() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : getKeyValuePairsOfCodeMarker().keySet()) {
            if (i != 0) {
                sb.append(',');
            }
            sb.append(str);
            i++;
        }
        return sb.toString();
    }

    public String getCsvLine() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : getKeyValuePairsOfCodeMarker().values()) {
            if (i != 0) {
                sb.append(',');
            }
            sb.append(str);
            i++;
        }
        return sb.toString();
    }
}
