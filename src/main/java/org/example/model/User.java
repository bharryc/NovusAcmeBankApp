package org.example.model;

import java.util.List;

public class User {

    private static long id = 10000;

    private long userId;
    private String name;
    private String photoID;
    private String photoIDType;
    private String addressBasedId;
    private String addressBasedIdType;
    private String userAddress;
    private int userIsaAccount;

    public User() {

    }

    public User(String name, String photoID, String photoIDType, String addressBasedId, String addressBasedIdType, String userAddress) {
        this.userId = id++;
        this.name = name;
        this.photoID = photoID;
        this.photoIDType = photoIDType;
        this.addressBasedId = addressBasedId;
        this.addressBasedIdType = addressBasedIdType;
        this.userAddress = userAddress;
        this.userIsaAccount = 0;
    }

    public int getUserIsaAccount() {
        return userIsaAccount;
    }

    public void incrementUserIsaAccount(int userIsaAccount) {
        this.userIsaAccount = userIsaAccount;
    }

    public static long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoID() {
        return photoID;
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public String getPhotoIDType() {
        return photoIDType;
    }

    public void setPhotoIDType(String photoIDType) {
        this.photoIDType = photoIDType;
    }

    public String getAddressBasedId() {
        return addressBasedId;
    }

    public void setAddressBasedId(String addressBasedId) {
        this.addressBasedId = addressBasedId;
    }

    public String getAddressBasedIdType() {
        return addressBasedIdType;
    }

    public void setAddressBasedIdType(String addressBasedIdType) {
        this.addressBasedIdType = addressBasedIdType;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", photoID='" + photoID + '\'' +
                ", photoIDType='" + photoIDType + '\'' +
                ", addressBasedId='" + addressBasedId + '\'' +
                ", addressBasedIdType='" + addressBasedIdType + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

}
