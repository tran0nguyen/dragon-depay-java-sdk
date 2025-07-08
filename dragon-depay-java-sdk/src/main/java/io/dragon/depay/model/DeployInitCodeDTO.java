package io.dragon.depay.model;

import java.math.BigInteger;
import java.util.List;

public class DeployInitCodeDTO {
    private String chain;
    private Integer env;
    private long nonce;
    private String contractAlias;
    private String apiAddress;
    private String merchantAddress;
    private List<String> payeeList;
    private List<BigInteger> shareList;

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public Integer getEnv() {
        return env;
    }

    public void setEnv(Integer env) {
        this.env = env;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public String getContractAlias() {
        return contractAlias;
    }

    public void setContractAlias(String contractAlias) {
        this.contractAlias = contractAlias;
    }

    public String getApiAddress() {
        return apiAddress;
    }

    public void setApiAddress(String apiAddress) {
        this.apiAddress = apiAddress;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public List<String> getPayeeList() {
        return payeeList;
    }

    public void setPayeeList(List<String> payeeList) {
        this.payeeList = payeeList;
    }

    public List<BigInteger> getShareList() {
        return shareList;
    }

    public void setShareList(List<BigInteger> shareList) {
        this.shareList = shareList;
    }
}
