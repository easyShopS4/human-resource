package com.hr.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class SalaryGrantBatch {
    private List<SalaryGrant> listsg=new ArrayList<SalaryGrant>();

    public SalaryGrantBatch(){

    }

    public List<SalaryGrant> getListsg() {
        return listsg;
    }

    public void setListsg(List<SalaryGrant> listsg) {
        this.listsg = listsg;
    }
}
