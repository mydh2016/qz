package com.qazit.sysmanager.web.model;

public class HatCity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hat_city.id
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hat_city.cityID
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    private String cityid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hat_city.city
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hat_city.father
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    private String father;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hat_city.id
     *
     * @return the value of hat_city.id
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hat_city.id
     *
     * @param id the value for hat_city.id
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hat_city.cityID
     *
     * @return the value of hat_city.cityID
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hat_city.cityID
     *
     * @param cityid the value for hat_city.cityID
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hat_city.city
     *
     * @return the value of hat_city.city
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hat_city.city
     *
     * @param city the value for hat_city.city
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hat_city.father
     *
     * @return the value of hat_city.father
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public String getFather() {
        return father;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hat_city.father
     *
     * @param father the value for hat_city.father
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    public void setFather(String father) {
        this.father = father == null ? null : father.trim();
    }
}