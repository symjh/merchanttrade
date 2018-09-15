package com.mybank.bkmerchant.constant;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum MccEnum {
  Cate("2015050700000000", "美食"),
  Supermarket("2015091000052157", "超市便利店"),
  Entertainment("2015062600004525", "休闲娱乐"),
  Shopping("2015062600002758", "购物"),
  LovingCar("2016062900190124", "爱车"),
  LifeService("2015063000020189", "生活服务"),
  Education("2016042200000148", "教育培训"),
  HealthCare("2016062900190296", "医疗健康"),
  AirTravel("2015080600000001", "航旅"),
  WholeSale("2016062900190337", "专业销售/批发"),
  Government("2016062900190371", "政府/社会组织")
  ;

  private String mccId;
  private String mccCate;

  MccEnum(String mccId, String mccCate) {
    this.mccId = mccId;
    this.mccCate = mccCate;
  }

  public String getMccId() {
    return mccId;
  }

  public void setMccId(String mccId) {
    this.mccId = mccId;
  }

  public String getMccCate() {
    return mccCate;
  }

  public void setMccCate(String mccCate) {
    this.mccCate = mccCate;
  }
}
