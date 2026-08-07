package org.apache.hc.core5.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class InetAddressUtils {
    private static final char COLON_CHAR = ':';
    public static final byte IPV4 = 1;
    private static final String IPV4_BASIC_PATTERN_STRING = "(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    public static final byte IPV6 = 4;
    private static final int MAX_COLON_COUNT = 7;
    private static final char SCOPE_ID_DELIMITER = '%';
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    private static final Pattern IPV4_MAPPED_IPV6_PATTERN = Pattern.compile("^::[fF]{4}:(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");
    private static final Pattern SCOPE_ID_PATTERN = Pattern.compile("^[a-zA-Z0-9\\-]+$");

    private InetAddressUtils() {
    }

    @Deprecated
    public static boolean isIPv4Address(String str) {
        return isIPv4(str);
    }

    public static boolean isIPv4(CharSequence charSequence) {
        return IPV4_PATTERN.matcher(charSequence).matches();
    }

    @Deprecated
    public static boolean isIPv4MappedIPv64Address(String str) {
        return isIPv4MappedIPv6(str);
    }

    public static boolean isIPv4MappedIPv6(CharSequence charSequence) {
        return IPV4_MAPPED_IPV6_PATTERN.matcher(charSequence).matches();
    }

    static boolean hasValidIPv6ColonCount(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (charSequence.charAt(i2) == ':') {
                i++;
            }
        }
        return i >= 2 && i <= 7;
    }

    @Deprecated
    public static boolean isIPv6StdAddress(String str) {
        return isIPv6Std(str);
    }

    public static boolean isIPv6Std(CharSequence charSequence) {
        return hasValidIPv6ColonCount(charSequence) && IPV6_STD_PATTERN.matcher(charSequence).matches();
    }

    @Deprecated
    public static boolean isIPv6HexCompressedAddress(String str) {
        return isIPv6HexCompressed(str);
    }

    public static boolean isIPv6HexCompressed(CharSequence charSequence) {
        return hasValidIPv6ColonCount(charSequence) && IPV6_HEX_COMPRESSED_PATTERN.matcher(charSequence).matches();
    }

    @Deprecated
    public static boolean isIPv6Address(String str) {
        return isIPv6(str);
    }

    public static boolean isIPv6(CharSequence charSequence) {
        int i = 0;
        while (true) {
            if (i >= charSequence.length()) {
                i = -1;
                break;
            }
            if (charSequence.charAt(i) == '%') {
                break;
            }
            i++;
        }
        if (i == -1) {
            return isIPv6Std(charSequence) || isIPv6HexCompressed(charSequence);
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(0, i);
        if (!isIPv6Std(charSequenceSubSequence) && !isIPv6HexCompressed(charSequenceSubSequence)) {
            return false;
        }
        CharSequence charSequenceSubSequence2 = charSequence.subSequence(i + 1, charSequence.length());
        return charSequenceSubSequence2.length() != 0 && SCOPE_ID_PATTERN.matcher(charSequenceSubSequence2).matches();
    }

    @Deprecated
    public static boolean isIPv6URLBracketedAddress(String str) {
        return isIPv6URLBracketed(str);
    }

    public static boolean isIPv6URLBracketed(CharSequence charSequence) {
        return charSequence.length() != 0 && charSequence.charAt(0) == '[' && charSequence.charAt(charSequence.length() - 1) == ']' && isIPv6(charSequence.subSequence(1, charSequence.length() - 1));
    }

    public static void formatAddress(StringBuilder sb, SocketAddress socketAddress) {
        Args.notNull(sb, "buffer");
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                sb.append(address.getHostAddress()).append(':').append(inetSocketAddress.getPort());
                return;
            } else {
                sb.append(socketAddress);
                return;
            }
        }
        sb.append(socketAddress);
    }

    public static String getCanonicalLocalHostName() {
        try {
            return InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException unused) {
            return "localhost";
        }
    }
}
