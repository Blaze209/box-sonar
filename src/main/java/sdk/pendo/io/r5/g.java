package sdk.pendo.io.r5;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private GuideModel a;
    private long b = -1;
    private String c;
    private b d;

    public enum a {
        TIME_OUT("Timeout"),
        STATE_CHANGED("StateChanged"),
        CLOSE_BUTTON("CloseButton"),
        SYSTEM("System"),
        APP_TERMINATION("AppTermination"),
        USER_ACTION("UserAction"),
        APP_IN_BACKGROUND("AppInBackground");

        private final String mValue;

        a(String str) {
            this.mValue = str;
        }

        public String b() {
            return this.mValue;
        }
    }

    public enum b {
        ERROR_REASON_CAPPING("Capping"),
        ERROR_CONTROL_GROUP("ControlGroup"),
        ERROR_REASON_CONNECTIVITY("Connectivity"),
        ERROR_REASON_IMAGE("ImageError"),
        ERROR_REASON_VIDEO("VideoError"),
        ERROR_REASON_CONFIGURATION("ConfigurationError"),
        ELEMENT_NOT_VISIBLE("ElementNotVisible"),
        ERROR_REASON_UNKNOWN("Unknown"),
        ERROR_REASON_RUN_PREVIEW_GUIDE("RunPreviewInsertError"),
        ERROR_REASON_ENTER_TEST_MODE("EnterTestModeError"),
        ERROR_REASON_BACKEND("BackendError"),
        ERROR_GUIDE_ALREADY_DISPLAYED("GuideAlreadyDisplayed");

        private final String mValue;

        b(String str) {
            this.mValue = str;
        }

        public String b() {
            return this.mValue;
        }
    }

    public enum c {
        INVALID_SIGNATURE("InvalidSignature");

        private final String mValue;

        c(String str) {
            this.mValue = str;
        }

        public String b() {
            return this.mValue;
        }
    }

    public g(GuideModel guideModel) {
        this.a = guideModel;
    }

    public void a(JSONObject jSONObject, d dVar) {
        try {
            jSONObject.put("group", new JSONObject());
            d.GUIDE_RECEIVED.equals(dVar);
            if (d.GUIDE_DISMISSED.equals(dVar)) {
                String strA = a();
                if (strA == null) {
                    PendoLogger.w("No dismiss reason given!", new Object[0]);
                    return;
                } else {
                    jSONObject.put("displayDurationInMillis", b());
                    jSONObject.put(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_BY, strA);
                    return;
                }
            }
            if (d.GUIDE_NOT_DISPLAYED.equals(dVar)) {
                b bVarE = e();
                if (bVarE != null) {
                    jSONObject.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, bVarE.b());
                } else {
                    PendoLogger.w("No not display reason given!", new Object[0]);
                }
            }
        } catch (JSONException e) {
            PendoLogger.e(e.getMessage(), new Object[0]);
        }
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.a.getGuideId();
    }

    protected GuideModel d() {
        return this.a;
    }

    public b e() {
        return this.d;
    }

    private String a() {
        return this.c;
    }

    public g a(String str) {
        this.c = str;
        return this;
    }

    public g a(long j) {
        this.b = j;
        return this;
    }

    public g a(b bVar) {
        this.d = bVar;
        return this;
    }
}
