package fr.insa.smarties;

import java.math.BigInteger;

public class Heir {

    private String _address;
    private int _percentage;

    public Heir (String address, int percentage) {
        this._address = address;
        this._percentage = percentage;
    }

    public int getPercentage () {
        return this._percentage;
    }

    public void setPercentage (int percentage) {
        this._percentage = percentage;
    }

    public String getAddress() {
        return this._address;
    }

    public void setAddress(String address) {
        this._address = address;
    }
}
