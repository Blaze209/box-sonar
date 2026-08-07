package org.apache.http.conn.util;

import java.net.IDN;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class PublicSuffixMatcher {
    private final Map<String, DomainType> exceptions;
    private final Map<String, DomainType> rules;

    public PublicSuffixMatcher(Collection<String> collection, Collection<String> collection2) {
        this(DomainType.UNKNOWN, collection, collection2);
    }

    public PublicSuffixMatcher(DomainType domainType, Collection<String> collection, Collection<String> collection2) {
        Args.notNull(domainType, "Domain type");
        Args.notNull(collection, "Domain suffix rules");
        this.rules = new ConcurrentHashMap(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            this.rules.put(it.next(), domainType);
        }
        this.exceptions = new ConcurrentHashMap();
        if (collection2 != null) {
            Iterator<String> it2 = collection2.iterator();
            while (it2.hasNext()) {
                this.exceptions.put(it2.next(), domainType);
            }
        }
    }

    public PublicSuffixMatcher(Collection<PublicSuffixList> collection) {
        Args.notNull(collection, "Domain suffix lists");
        this.rules = new ConcurrentHashMap();
        this.exceptions = new ConcurrentHashMap();
        for (PublicSuffixList publicSuffixList : collection) {
            DomainType type = publicSuffixList.getType();
            Iterator<String> it = publicSuffixList.getRules().iterator();
            while (it.hasNext()) {
                this.rules.put(it.next(), type);
            }
            List<String> exceptions = publicSuffixList.getExceptions();
            if (exceptions != null) {
                Iterator<String> it2 = exceptions.iterator();
                while (it2.hasNext()) {
                    this.exceptions.put(it2.next(), type);
                }
            }
        }
    }

    private static DomainType findEntry(Map<String, DomainType> map, String str) {
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    private static boolean match(DomainType domainType, DomainType domainType2) {
        if (domainType != null) {
            return domainType2 == null || domainType.equals(domainType2);
        }
        return false;
    }

    public String getDomainRoot(String str) {
        return getDomainRoot(str, null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0078 A[RETURN] */
    public String getDomainRoot(String str, DomainType domainType) {
        if (str == null || str.startsWith(".")) {
            return null;
        }
        String strNormalize = DnsUtils.normalize(str);
        String str2 = null;
        while (strNormalize != null) {
            String unicode = IDN.toUnicode(strNormalize);
            if (!match(findEntry(this.exceptions, unicode), domainType)) {
                DomainType domainTypeFindEntry = findEntry(this.rules, unicode);
                if (match(domainTypeFindEntry, domainType)) {
                    if (domainTypeFindEntry != DomainType.PRIVATE) {
                        return str2;
                    }
                } else {
                    int iIndexOf = strNormalize.indexOf(46);
                    String strSubstring = iIndexOf != -1 ? strNormalize.substring(iIndexOf + 1) : null;
                    if (strSubstring != null) {
                        DomainType domainTypeFindEntry2 = findEntry(this.rules, "*." + IDN.toUnicode(strSubstring));
                        if (match(domainTypeFindEntry2, domainType)) {
                            if (domainTypeFindEntry2 != DomainType.PRIVATE) {
                                return str2;
                            }
                        }
                    }
                    str2 = strNormalize;
                    strNormalize = strSubstring;
                }
            }
            return strNormalize;
        }
        if (domainType == null || domainType == DomainType.UNKNOWN) {
            return str2;
        }
        return null;
    }

    public boolean matches(String str) {
        return matches(str, null);
    }

    public boolean matches(String str, DomainType domainType) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        return getDomainRoot(str, domainType) == null;
    }
}
