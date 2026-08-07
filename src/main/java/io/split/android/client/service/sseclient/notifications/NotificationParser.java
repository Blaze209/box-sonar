package io.split.android.client.service.sseclient.notifications;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationParser {
    private static final String EVENT_TYPE_ERROR = "error";
    private static final String EVENT_TYPE_FIELD = "event";

    public IncomingNotification parseIncoming(String jsonData) throws JsonSyntaxException {
        try {
            RawNotification rawNotification = (RawNotification) Json.fromJson(jsonData, RawNotification.class);
            try {
                NotificationType type = ((IncomingNotificationType) Json.fromJson(rawNotification.getData(), IncomingNotificationType.class)).getType();
                if (type == null) {
                    type = NotificationType.OCCUPANCY;
                }
                return new IncomingNotification(type, rawNotification.getChannel(), rawNotification.getData(), rawNotification.getTimestamp());
            } catch (JsonSyntaxException e) {
                Logger.e("Error parsing notification: " + e.getLocalizedMessage());
                return null;
            } catch (Exception e2) {
                Logger.e("Unexpected error while parsing incoming notification: " + e2.getLocalizedMessage());
                return null;
            }
        } catch (JsonSyntaxException e3) {
            Logger.e("Unexpected error while parsing raw notification: " + e3.getLocalizedMessage());
            return null;
        }
    }

    public SplitsChangeNotification parseSplitUpdate(String jsonData) throws JsonSyntaxException {
        return (SplitsChangeNotification) Json.fromJson(jsonData, SplitsChangeNotification.class);
    }

    public RuleBasedSegmentChangeNotification parseRuleBasedSegmentUpdate(String notificationJson) {
        return (RuleBasedSegmentChangeNotification) Json.fromJson(notificationJson, RuleBasedSegmentChangeNotification.class);
    }

    public SplitKillNotification parseSplitKill(String jsonData) throws JsonSyntaxException {
        return (SplitKillNotification) Json.fromJson(jsonData, SplitKillNotification.class);
    }

    public OccupancyNotification parseOccupancy(String jsonData) throws JsonSyntaxException {
        return (OccupancyNotification) Json.fromJson(jsonData, OccupancyNotification.class);
    }

    public ControlNotification parseControl(String jsonData) throws JsonSyntaxException {
        return (ControlNotification) Json.fromJson(jsonData, ControlNotification.class);
    }

    public StreamingError parseError(String jsonData) throws JsonSyntaxException {
        return (StreamingError) Json.fromJson(jsonData, StreamingError.class);
    }

    public KeyList parseKeyList(String jsonData) throws JsonSyntaxException {
        return (KeyList) Json.fromJson(jsonData, KeyList.class);
    }

    public boolean isError(Map<String, String> values) {
        return values != null && "error".equals(values.get("event"));
    }

    public String extractUserKeyHashFromChannel(String channel) {
        if (channel == null) {
            return null;
        }
        String[] strArrSplit = channel.split("_");
        if (strArrSplit.length > 2) {
            return strArrSplit[2];
        }
        return null;
    }

    public MembershipNotification parseMembershipNotification(String jsonData) {
        try {
            return (MembershipNotification) Json.fromJson(jsonData, MembershipNotification.class);
        } catch (Exception unused) {
            Logger.w("Failed to parse membership notification");
            return null;
        }
    }
}
