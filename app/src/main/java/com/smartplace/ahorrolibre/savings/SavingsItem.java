package com.smartplace.ahorrolibre.savings;

/**
 * Created by Roberto on 13/08/2014.
 */
public class SavingsItem {

    private String id;
    private String name;
    private String adminUser;
    private String startDate;
    private String endDate;
    private String deliveryDate;
    private String missingDays;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getMissingDays() {
        return missingDays;
    }

    public void setMissingDays(String missingDays) {
        this.missingDays = missingDays;
    }


}
