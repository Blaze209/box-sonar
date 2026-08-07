package com.box.android.utilities;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class InviteCollaboratorsErrorMessageBuilder {
    private InviteCollaboratorsErrorMessageBuilder() {
    }

    public static SpannableStringBuilder buildDialogMessage(Context context, Map<Integer, List<String>> map, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            List<String> list = map.get(Integer.valueOf(iIntValue));
            if (iIntValue == R.string.box_share_forbidden_due_to_shield) {
                appendShieldErrorMessage(context, spannableStringBuilder, list, z);
            } else {
                appendGenericErrorMessage(context, spannableStringBuilder, iIntValue, list);
            }
            spannableStringBuilder.append((CharSequence) "\n");
        }
        return spannableStringBuilder;
    }

    static void appendShieldErrorMessage(Context context, SpannableStringBuilder spannableStringBuilder, List<String> list, boolean z) {
        String string;
        int shieldErrorPrimaryStringRes = ShareSDKTransformer.getShieldErrorPrimaryStringRes(list.size(), z);
        if (list.size() == 1) {
            string = context.getString(shieldErrorPrimaryStringRes, list.get(0));
        } else {
            string = context.getString(shieldErrorPrimaryStringRes, Integer.valueOf(list.size()));
        }
        int colorFromAttribute = CommonBoxUtil.getColorFromAttribute(context, R.attr.contentPrimary);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(colorFromAttribute), 0, string.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, string.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString).append("\n");
        String string2 = context.getString(R.string.box_sharesdk_action_disabled_security_controls);
        SpannableString spannableString2 = new SpannableString(string2);
        spannableString2.setSpan(new ForegroundColorSpan(colorFromAttribute), 0, string2.length(), 33);
        spannableString2.setSpan(new AbsoluteSizeSpan(14, true), 0, string2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString2).append("\n");
    }

    static void appendGenericErrorMessage(Context context, SpannableStringBuilder spannableStringBuilder, int i, List<String> list) {
        int colorFromAttribute = CommonBoxUtil.getColorFromAttribute(context, R.attr.contentPrimary);
        int colorFromAttribute2 = CommonBoxUtil.getColorFromAttribute(context, R.attr.contentSecondary);
        String string = context.getString(i);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(colorFromAttribute), 0, string.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, string.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString).append("\n");
        for (String str : list) {
            SpannableString spannableString2 = new SpannableString(str);
            spannableString2.setSpan(new AbsoluteSizeSpan(12, true), 0, str.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(colorFromAttribute2), 0, str.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2).append("\n");
        }
    }
}
