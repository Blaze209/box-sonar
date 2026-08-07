package sdk.pendo.io.views.custom;

import android.view.View;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.c2.b;

/* JADX INFO: loaded from: classes5.dex */
public interface ActionableBlock extends View.OnClickListener {

    public enum OnSubmitAction {
        CLOSE(HeaderElements.CLOSE),
        CHANGE_SCREEN("changeScreen");

        private static final String CHANGE_SCREEN_PTRN = "^changeScreen\\('(.*)'\\)$";
        private static final Pattern CHANGE_SCREEN_PTRN_MCHR = Pattern.compile(CHANGE_SCREEN_PTRN);
        private final String mOnSubmitAction;

        OnSubmitAction(String str) {
            this.mOnSubmitAction = str;
        }

        static String getChangeScreenId(String str) {
            if (str == null) {
                throw new IllegalStateException("Given null submit action.");
            }
            Matcher matcher = CHANGE_SCREEN_PTRN_MCHR.matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            throw new IllegalStateException("Given submit action '" + str + "' Doesn't match the regex.");
        }

        String getOnSubmitActionName() {
            return this.mOnSubmitAction;
        }
    }

    CharSequence getElementId();

    b<OnSubmitAction, String> getOnSubmit();

    void setActions(List<PendoCommand> list);

    void setOnSubmit(String str);
}
