package expo.modules.ui;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextInputView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "", "(Ljava/lang/String;)I", "autoCapitalize", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextInputViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final int keyboardType(String str) {
        switch (str.hashCode()) {
            case -2010681661:
                if (str.equals("email-address")) {
                    return KeyboardType.INSTANCE.m9332getEmailPjHm6EE();
                }
                break;
            case -2000413939:
                if (str.equals(Constants.COLLATION_OPTION_NUMERIC)) {
                    return KeyboardType.INSTANCE.m9333getNumberPjHm6EE();
                }
                break;
            case -1380505577:
                if (str.equals("decimal-pad")) {
                    return KeyboardType.INSTANCE.m9331getDecimalPjHm6EE();
                }
                break;
            case -1030161484:
                if (str.equals("phone-pad")) {
                    return KeyboardType.INSTANCE.m9336getPhonePjHm6EE();
                }
                break;
            case -829387344:
                if (str.equals("ascii-capable")) {
                    return KeyboardType.INSTANCE.m9330getAsciiPjHm6EE();
                }
                break;
            case 116079:
                if (str.equals("url")) {
                    return KeyboardType.INSTANCE.m9339getUriPjHm6EE();
                }
                break;
            case 904922271:
                if (str.equals("number-password")) {
                    return KeyboardType.INSTANCE.m9334getNumberPasswordPjHm6EE();
                }
                break;
            case 1216985755:
                if (str.equals("password")) {
                    return KeyboardType.INSTANCE.m9335getPasswordPjHm6EE();
                }
                break;
            case 1544803905:
                if (str.equals("default")) {
                    return KeyboardType.INSTANCE.m9337getTextPjHm6EE();
                }
                break;
        }
        return KeyboardType.INSTANCE.m9337getTextPjHm6EE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final int autoCapitalize(String str) {
        switch (str.hashCode()) {
            case -1626174665:
                if (str.equals("unspecified")) {
                    return KeyboardCapitalization.INSTANCE.m9311getUnspecifiedIUNYP9k();
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    return KeyboardCapitalization.INSTANCE.m9309getNoneIUNYP9k();
                }
                break;
            case 113318569:
                if (str.equals("words")) {
                    return KeyboardCapitalization.INSTANCE.m9312getWordsIUNYP9k();
                }
                break;
            case 490141296:
                if (str.equals("sentences")) {
                    return KeyboardCapitalization.INSTANCE.m9310getSentencesIUNYP9k();
                }
                break;
            case 1245424234:
                if (str.equals("characters")) {
                    return KeyboardCapitalization.INSTANCE.m9308getCharactersIUNYP9k();
                }
                break;
        }
        return KeyboardCapitalization.INSTANCE.m9309getNoneIUNYP9k();
    }
}
