package acs.tools;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509KeyManager;

public class AliasForcingKeyManager implements X509KeyManager {

    X509KeyManager baseKM = null;
    String alias = null;

    public AliasForcingKeyManager(X509KeyManager keyManager, String alias) {
        baseKM = keyManager;
        this.alias = alias;
    }

    /*
     * Always render the specific alias provided in the constructor
     */
    @Override
    public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
        return alias;
    }

    @Override
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        return baseKM.chooseServerAlias(keyType, issuers, socket);
    }

    public X509Certificate[] getCertificateChain(String alias) {
        return baseKM.getCertificateChain(alias);
    }

    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return baseKM.getClientAliases(keyType, issuers);
    }

    public PrivateKey getPrivateKey(String alias) {
        return baseKM.getPrivateKey(alias);
    }

    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return baseKM.getServerAliases(keyType, issuers);
    }


}
