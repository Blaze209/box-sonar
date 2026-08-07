package sdk.pendo.io.views.custom;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.o3.b;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q4.a;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.s7.d;
import sdk.pendo.io.s7.w;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes5.dex */
public final class PendoForm extends PendoLinearLayout implements ViewBaseScriptBridge.FormScriptBridge {
    public static final String ADDITIONAL_INFO_BUTTON_GROUP_ID = "buttonGroupId";
    public static final String ADDITIONAL_INFO_KEY_VALUES_INPUT = "keyValuesInput";
    public static final String ADDITIONAL_INFO_RADIO_BUTTON_INPUT = "radioButtonInput";
    public static final String ADDITIONAL_INFO_SELECTED_BUTTON_ID = "selectedButtonId";
    public static final String ADDITIONAL_INFO_TEXT_FIELD_ID = "textFieldId";
    public static final String ADDITIONAL_INFO_TEXT_FIELD_INPUT = "textFieldInput";
    public static final String ADDITIONAL_INFO_TEXT_FIELD_VALUE = "value";
    private List<PendoCommand> mCommands;
    private e<PendoCommand> mFormUpdatedObserver;
    private b mFormUpdatedSubscription;
    private Set<String> mMandatory;
    private e<PendoCommand> mSubmitObserver;
    private b mSubmitterSubscription;
    private HashMap<String, Pair<Class, String>> mUserInput;

    public PendoForm(Context context) {
        this(context, null);
    }

    private JSONObject getFormAdditionalInfo() {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        for (Map.Entry<String, Pair<Class, String>> entry : this.mUserInput.entrySet()) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String key = entry.getKey();
                Pair<Class, String> value = entry.getValue();
                Class cls = (Class) value.first;
                String str = (String) value.second;
                if (RadioGroup.class.equals(cls)) {
                    jSONObject2.put(ADDITIONAL_INFO_BUTTON_GROUP_ID, key);
                    jSONObject2.put(ADDITIONAL_INFO_SELECTED_BUTTON_ID, str);
                    jSONArray = jSONArray2;
                } else if (EditText.class.equals(cls)) {
                    jSONObject2.put(ADDITIONAL_INFO_TEXT_FIELD_ID, key);
                    jSONObject2.put("value", str);
                    jSONArray = jSONArray3;
                } else if (Map.class.equals(cls)) {
                    jSONObject2.put(key, str);
                    jSONArray = jSONArray4;
                }
                jSONArray.put(jSONObject2);
            } catch (Exception e) {
                PendoLogger.w(e, e.getMessage(), new Object[0]);
            }
        }
        try {
            if (jSONArray2.length() > 0) {
                jSONObject.put(ADDITIONAL_INFO_RADIO_BUTTON_INPUT, jSONArray2);
            }
            if (jSONArray3.length() > 0) {
                jSONObject.put(ADDITIONAL_INFO_TEXT_FIELD_INPUT, jSONArray3);
            }
            if (jSONArray4.length() > 0) {
                jSONObject.put(ADDITIONAL_INFO_KEY_VALUES_INPUT, jSONArray4);
            }
            CharSequence contentDescription = getContentDescription();
            if (TextUtils.isEmpty(contentDescription)) {
                d.a(g.b.ERROR_REASON_CONFIGURATION, "No content description for element id.", new Object[0]);
            } else {
                jSONObject.put("elementId", contentDescription);
            }
        } catch (JSONException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    private void processFormQuestions(l lVar) {
        String strC = w.c(lVar, "widget");
        f fVarB = w.b(lVar, "properties");
        if (strC == null || fVarB == null) {
            return;
        }
        JSONArray jSONArray = null;
        for (int i = 0; i < fVarB.size(); i++) {
            l lVarA = w.a(fVarB, i);
            if (lVarA != null && "mandatory_fields".equals(w.c(lVarA, "name"))) {
                try {
                    jSONArray = new JSONArray(w.c(lVarA, "value"));
                } catch (JSONException e) {
                    PendoLogger.d(e.getMessage(), new Object[0]);
                }
            }
            if (jSONArray != null) {
                break;
            }
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    this.mMandatory.add(jSONArray.getString(i2));
                } catch (JSONException e2) {
                    PendoLogger.w(e2, e2.getMessage(), new Object[0]);
                }
            }
        }
    }

    private void subscribeFormUpdated(String str) {
        unsubscribeFormUpdated();
        LinkedList linkedList = new LinkedList();
        linkedList.add(PendoCommandAction.PendoCommandFormAction.UPDATE);
        linkedList.add(PendoCommandAction.PendoCommandFormAction.SET_VALUE_FOR_KEY);
        this.mFormUpdatedSubscription = PendoCommandsEventBus.getInstance().subscribe(sdk.pendo.io.t4.g.a(this), PendoCommand.createFilter("any", str, linkedList, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY), this.mFormUpdatedObserver);
    }

    private void subscribeOnSubmit(String str) {
        unsubscribeSubmitter();
        this.mSubmitterSubscription = PendoCommandsEventBus.getInstance().subscribe(sdk.pendo.io.t4.g.a(this), PendoCommand.createFilter("any", str, PendoCommandAction.PendoCommandFormAction.SUBMIT, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY), this.mSubmitObserver);
    }

    private void unsubscribeFormUpdated() {
        b bVar = this.mFormUpdatedSubscription;
        if (bVar == null || bVar.isDisposed()) {
            return;
        }
        this.mFormUpdatedSubscription.dispose();
    }

    private void unsubscribeSubmitter() {
        b bVar = this.mSubmitterSubscription;
        if (bVar == null || bVar.isDisposed()) {
            return;
        }
        this.mSubmitterSubscription.dispose();
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge.FormScriptBridge
    public JSONObject getAnswers() {
        return getFormAdditionalInfo();
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public String getType() {
        return ViewBaseScriptBridge.ViewBaseScriptBridgeUtils.getType(this);
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public ViewBaseScriptBridge getViewScriptBridge() {
        return this;
    }

    public boolean isValid() {
        if (this.mCommands == null) {
            return false;
        }
        if (this.mMandatory.isEmpty() || this.mUserInput.keySet().containsAll(this.mMandatory)) {
            PendoCommandDispatcher.getInstance().dispatchCommands(this.mCommands, PendoCommandEventType.FormEventType.ON_VALID, true);
            return true;
        }
        PendoCommandDispatcher.getInstance().dispatchCommands(this.mCommands, PendoCommandEventType.FormEventType.ON_INVALID, true);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        CharSequence contentDescription = getContentDescription();
        if (contentDescription != null) {
            subscribeOnSubmit(contentDescription.toString());
            subscribeFormUpdated(contentDescription.toString());
            a.b(this).a(sdk.pendo.io.t4.g.a(this)).a(sdk.pendo.io.t6.d.a(new e<Object>() { // from class: sdk.pendo.io.views.custom.PendoForm.3
                @Override // sdk.pendo.io.q3.e
                public void accept(Object obj) {
                    PendoForm.this.isValid();
                }
            }, "PendoForm viewbind observer"));
        }
        super.onAttachedToWindow();
    }

    public void processForm(l lVar, List<PendoCommand> list, String str) {
        this.mCommands = list;
        processFormQuestions(lVar);
    }

    public void setSubmitButton(VisualActionButton visualActionButton) {
    }

    public PendoForm(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PendoForm(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMandatory = new HashSet();
        this.mUserInput = new HashMap<>();
        this.mSubmitObserver = new e<PendoCommand>() { // from class: sdk.pendo.io.views.custom.PendoForm.1
            @Override // sdk.pendo.io.q3.e
            public void accept(PendoCommand pendoCommand) {
                PendoLogger.d(pendoCommand.toString(), new Object[0]);
                if (PendoForm.this.isValid()) {
                    JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(PendoForm.this.mCommands);
                    PendoCommandDispatcher.getInstance().dispatchCommands(PendoForm.this.mCommands, PendoCommandEventType.FormEventType.ON_SUBMIT, true);
                }
            }
        };
        this.mFormUpdatedObserver = new e<PendoCommand>() { // from class: sdk.pendo.io.views.custom.PendoForm.2
            /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
            @Override // sdk.pendo.io.q3.e
            public void accept(PendoCommand pendoCommand) {
                Object obj;
                String string;
                Object obj2;
                try {
                    PendoLogger.d(pendoCommand.toString(), new Object[0]);
                    if (PendoForm.this.mCommands == null) {
                        PendoLogger.e("No commands for the form!", new Object[0]);
                        return;
                    }
                    List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
                    if (PendoCommandAction.PendoCommandFormAction.SET_VALUE_FOR_KEY.equals(pendoCommand.getAction())) {
                        if (parameters == null) {
                            PendoLogger.e("Parameters are null for SET_VALUE_FOR_KEY.", new Object[0]);
                            return;
                        }
                        try {
                            PendoForm.this.mUserInput.put((String) PendoCommandsEventBus.Parameter.getParameterValue(parameters, "key", String.class), Pair.create(Map.class, (String) PendoCommandsEventBus.Parameter.getParameterValue(parameters, "value", String.class)));
                            PendoForm.this.isValid();
                            return;
                        } catch (NoSuchFieldException e) {
                            PendoLogger.e(e, e.getMessage(), new Object[0]);
                            return;
                        }
                    }
                    final String sourceId = pendoCommand.getSourceId();
                    if (sourceId == null) {
                        PendoLogger.w("Source id is null!", new Object[0]);
                        return;
                    }
                    ArrayList<View> arrayList = new ArrayList<>();
                    PendoForm.this.findViewsWithText(arrayList, sourceId, 2);
                    y0.a(arrayList, new y0.a<View>() { // from class: sdk.pendo.io.views.custom.PendoForm.2.1
                        @Override // sdk.pendo.io.s7.y0.a
                        public boolean test(View view) {
                            return !sourceId.equals(view.getContentDescription().toString());
                        }
                    });
                    if (arrayList.isEmpty()) {
                        PendoLogger.d("Didn't find source view for id: " + sourceId, new Object[0]);
                        return;
                    }
                    if (arrayList.size() > 1) {
                        PendoLogger.w("Found '" + arrayList.size() + "' source view for id: " + sourceId, new Object[0]);
                        return;
                    }
                    View view = arrayList.get(0);
                    String str = null;
                    if (view instanceof RadioGroup) {
                        try {
                            RadioGroup radioGroup = (RadioGroup) view;
                            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                            if (checkedRadioButtonId == -1) {
                                PendoLogger.w("No selected radio button.", new Object[0]);
                                return;
                            }
                            View viewFindViewById = radioGroup.findViewById(checkedRadioButtonId);
                            if (viewFindViewById == null) {
                                PendoLogger.w("Could not find the selected radio button in the group!", new Object[0]);
                                return;
                            }
                            string = viewFindViewById.getContentDescription().toString();
                            obj2 = RadioGroup.class;
                            Object obj3 = obj2;
                            str = string;
                            obj = obj3;
                        } catch (Exception e2) {
                            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
                            obj = null;
                            str = null;
                        }
                    } else {
                        if (view instanceof EditText) {
                            Editable text = ((EditText) view).getText();
                            if (TextUtils.isEmpty(text)) {
                                PendoForm.this.mUserInput.remove(sourceId);
                            } else {
                                string = text.toString();
                                obj2 = EditText.class;
                                Object obj4 = obj2;
                                str = string;
                                obj = obj4;
                            }
                        }
                        obj = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        PendoLogger.d("Not saving answer. Answer is null: '" + TextUtils.isEmpty(str) + "' Class is: '" + obj + "' View is: '" + (view == null ? AbstractJsonLexerKt.NULL : view.getClass().getCanonicalName()) + "'.", new Object[0]);
                    } else {
                        PendoForm.this.mUserInput.put(sourceId, Pair.create(obj, str));
                    }
                    PendoForm.this.isValid();
                } catch (Exception e3) {
                    PendoLogger.e(e3, e3.getMessage(), new Object[0]);
                }
            }
        };
    }
}
