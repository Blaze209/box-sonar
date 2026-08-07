package sdk.pendo.io.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public class StepModel {
    private static final String JSON_OBJECT_CLOSING_PARENTHESIS = "}";
    private static final String JSON_OBJECT_OPENING_PARENTHESIS = "{";
    private static final String JSON_OBJECT_VALUE_KEY = "value";
    private static final String SRC_OR_URL_PROPERTY_REGEX = "(\\\"name\\\":[\\s\\t]*\\\"src|backgroundImageUrl\\\")";

    @c("activations")
    private List<ActivationModel> mStepActivations;

    @c("content")
    private StepContentModel mStepContentModel;

    @c(FirebaseAnalytics.Param.LOCATION)
    private StepLocationModel mStepLocationModel;

    public Set<String> getImageSourcePropertySet(String str) {
        HashSet hashSet = new HashSet();
        Matcher matcher = Pattern.compile(SRC_OR_URL_PROPERTY_REGEX).matcher(str);
        while (matcher.find()) {
            int iStart = matcher.start();
            try {
                hashSet.add(new JSONObject(str.substring(str.lastIndexOf(JSON_OBJECT_OPENING_PARENTHESIS, iStart), str.indexOf(JSON_OBJECT_CLOSING_PARENTHESIS, iStart) + 1)).getString("value"));
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), "screenString: " + str);
            }
        }
        return hashSet;
    }

    public ArrayList<String> getImages() {
        f views = this.mStepContentModel.getStepModel().getViews();
        if (views == null) {
            return new ArrayList<>();
        }
        try {
            return getImages(views.d().toString());
        } catch (Exception unused) {
            return getImages(views.toString().replace("\\/", "/"));
        }
    }

    public List<ActivationModel> getStepActivations() {
        return this.mStepActivations;
    }

    public StepGuideModel getStepContent() {
        return this.mStepContentModel.getStepModel();
    }

    public StepContentModel getStepContentModel() {
        return this.mStepContentModel;
    }

    public StepLocationModel getStepLocationModel() {
        return this.mStepLocationModel;
    }

    public void setStepActivations(List<ActivationModel> list) {
        this.mStepActivations = list;
    }

    public void setStepContentModel(StepContentModel stepContentModel) {
        this.mStepContentModel = stepContentModel;
    }

    public void setStepLocationModel(StepLocationModel stepLocationModel) {
        this.mStepLocationModel = stepLocationModel;
    }

    public ArrayList<String> getImages(String str) {
        return new ArrayList<>(getImageSourcePropertySet(str));
    }
}
