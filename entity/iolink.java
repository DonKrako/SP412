package com.henningSB412.entity;

import org.hibernate.validator.constraints.Length;

public class iolink {
    private boolean valid;
    @Length(max = 10)
    private int[] value;

    public iolink(boolean valid, int[] value) {
        this.valid = valid;
        this.value = value;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }
}
