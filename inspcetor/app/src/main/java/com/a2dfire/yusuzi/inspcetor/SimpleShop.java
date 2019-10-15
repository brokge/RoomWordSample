package com.a2dfire.yusuzi.inspcetor;


import android.support.annotation.NonNull;

import java.util.Objects;

/**
 * Created by devin on 21/3/2018.
 * 不可选的店铺定义
 */

public class SimpleShop implements Comparable<SimpleShop> {

    /**
     * 加盟模式-直营
     */
    public static final int JOINMODE_CHAIN = 1;
    /**
     * 加盟模式-加盟（数据库设置错误，按理为2）
     */
    public static final int JOINMODE_JOIN = 0;
    /**
     * 加盟模式-合作
     */
    public static final int JOINMODE_COOPERATE = 2;
    /**
     * 加盟模式-合营
     */
    public static final int JOINMODE_VENTURE = 3;

    private String shopName;
    private String shopEntityId;
    /**
     * 不可选原因
     */
    private String reason;
    /**
     * 不可选原因类型
     */
    private int status;

    /**
     * 品牌Id
     */
    private String plateId;

    /**
     * 品牌名
     */
    private String plateName;

    /**
     * 上级公司名称
     */
    private String branchName;


    /**
     * 分公司门店关联表ID
     */
    private String branchShopId;

    private String branchId;

    /**
     * 上级分公司实体ID
     */
    private String branchEntityId;

    /**
     * 1直营2加盟.
     */
    private int joinMode;

    public void setShopEntityId(String shopEntityId) {
        this.shopEntityId = shopEntityId;
    }

    public String getShopEntityId() {
        return shopEntityId;
    }

    public String getReason() {
        return reason;
    }

    public int getStatus() {
        return status;
    }

    /**
     * 依据status排序
     */
    @Override
    public int compareTo(@NonNull SimpleShop o) {
        return status - o.status;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPlateId() {
        return plateId;
    }

    public String getPlateName() {
        return plateName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchShopId() {
        return branchShopId;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getBranchEntityId() {
        return branchEntityId;
    }

    public int getJoinMode() {
        return joinMode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 这里equals仅对比id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleShop that = (SimpleShop) o;
        return Objects.equals(shopEntityId, that.shopEntityId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shopEntityId, status);
    }
}
