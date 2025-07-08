package io.dragon.depay.model;

import java.math.BigInteger;
import java.util.List;

public class DeployInitCodeResultDTO {
    private List<BigInteger> shares;
    private List<String> payees;
    private String bin;
    private String nonce;
    private String contractAlias;

    public List<BigInteger> getShares() {
        return shares;
    }

    public void setShares(List<BigInteger> shares) {
        this.shares = shares;
    }

    public List<String> getPayees() {
        return payees;
    }

    public void setPayees(List<String> payees) {
        this.payees = payees;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getContractAlias() {
        return contractAlias;
    }

    public void setContractAlias(String contractAlias) {
        this.contractAlias = contractAlias;
    }
}
