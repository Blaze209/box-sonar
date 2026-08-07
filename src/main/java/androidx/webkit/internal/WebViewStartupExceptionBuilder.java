package androidx.webkit.internal;

import androidx.webkit.WebViewStartupException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public class WebViewStartupExceptionBuilder implements BiConsumer<Integer, Object> {
    Integer mErrorCode;
    String mErrorMessage;

    @Override // java.util.function.BiConsumer
    public void accept(Integer num, Object obj) {
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            this.mErrorCode = (Integer) obj;
        } else if (iIntValue == 1) {
            this.mErrorMessage = (String) obj;
        } else if (num.intValue() < 0) {
            throw new UnsupportedOperationException("The current AndroidX version doesn't support this callback value: " + num);
        }
    }

    public static WebViewStartupException buildException(Consumer<BiConsumer<Integer, Object>> consumer) {
        WebViewStartupExceptionBuilder webViewStartupExceptionBuilder = new WebViewStartupExceptionBuilder();
        consumer.accept(webViewStartupExceptionBuilder);
        Integer num = webViewStartupExceptionBuilder.mErrorCode;
        if (num == null) {
            return new WebViewStartupException(webViewStartupExceptionBuilder.mErrorMessage);
        }
        num.intValue();
        return new WebViewStartupException(webViewStartupExceptionBuilder.mErrorMessage);
    }
}
