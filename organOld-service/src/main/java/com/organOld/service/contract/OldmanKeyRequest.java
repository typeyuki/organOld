package com.organOld.service.contract;

public class OldmanKeyRequest {
    private Integer oldmanId;
    private Integer goalStart;//重点老人 分数  起
    private Integer goalEnd;//重点老人 分数  止
    private String future;//是否查询的是未来的


    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getGoalStart() {
        return goalStart;
    }

    public void setGoalStart(Integer goalStart) {
        this.goalStart = goalStart;
    }

    public Integer getGoalEnd() {
        return goalEnd;
    }

    public void setGoalEnd(Integer goalEnd) {
        this.goalEnd = goalEnd;
    }
}
