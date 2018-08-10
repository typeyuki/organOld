package com.organOld.service.model;

import java.util.ArrayList;
import java.util.List;

public class ExcelReturnModel {
    private int numSuccess;//成功导入的数量
    private int successUpdate;//导入数量中  更新的个数
    private int successAdd;//导入数量中  更新的个数
    private int successDel;//删除的个数
    private int total;//一共
    private int numFail;//失败的数量
    private List<Integer> fail=new ArrayList<>();//失败的行号

    private int noexistOldman;//针对 机构、居家 导入的人员 不在已有的老人库的数量


    public int getNoexistOldman() {
        return noexistOldman;
    }

    public void setNoexistOldman(int noexistOldman) {
        this.noexistOldman = noexistOldman;
    }

    public int getSuccessUpdate() {
        return successUpdate;
    }

    public void setSuccessUpdate(int successUpdate) {
        this.successUpdate = successUpdate;
    }

    public int getSuccessAdd() {
        return successAdd;
    }

    public void setSuccessAdd(int successAdd) {
        this.successAdd = successAdd;
    }

    public int getSuccessDel() {
        return successDel;
    }

    public void setSuccessDel(int successDel) {
        this.successDel = successDel;
    }

    public List<Integer> getFail() {
        return fail;
    }

    public void setFail(List<Integer> fail) {
        this.fail = fail;
    }

    public int getNumSuccess() {
        return numSuccess;
    }

    public void setNumSuccess(int numSuccess) {
        this.numSuccess = numSuccess;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumFail() {
        return numFail;
    }

    public void setNumFail(int numFail) {
        this.numFail = numFail;
    }
}
