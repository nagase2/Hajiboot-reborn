package com.example.domain;
// default package
// Generated 2015/08/20 19:15:06 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * MstRole generated by hbm2java
 */
public class MstRole implements java.io.Serializable {


  private int roleId;
  private String roleName;
  private Boolean deleteFlag;
  private Date updatedDate;
  private Date createdDate;
  private Integer createdUser;
  private Integer updatedUser;

  public MstRole() {}


  public MstRole(int roleId) {
    this.roleId = roleId;
  }

  public MstRole(int roleId, String roleName, Boolean deleteFlag, Date updatedDate,
      Date createdDate, Integer createdUser, Integer updatedUser) {
    this.roleId = roleId;
    this.roleName = roleName;
    this.deleteFlag = deleteFlag;
    this.updatedDate = updatedDate;
    this.createdDate = createdDate;
    this.createdUser = createdUser;
    this.updatedUser = updatedUser;
  }

  public int getRoleId() {
    return this.roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Boolean getDeleteFlag() {
    return this.deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public Date getUpdatedDate() {
    return this.updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Date getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Integer getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(Integer createdUser) {
    this.createdUser = createdUser;
  }

  public Integer getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(Integer updatedUser) {
    this.updatedUser = updatedUser;
  }



}