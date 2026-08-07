package org.tinylog.format;

/* JADX INFO: loaded from: classes5.dex */
public class LegacyMessageFormatter extends AbstractMessageFormatter {
    @Override // org.tinylog.format.MessageFormatter
    public String format(String str, Object[] objArr) {
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 32);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '{' && (i = i2 + 1) < length && str.charAt(i) == '}' && i3 < objArr.length) {
                sb.append(resolve(objArr[i3]));
                i3++;
                i2 = i;
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }
}
