package org.itstack.demo.model;

/**
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * 博  客：http://bugstack.cn
 * Create by 小傅哥 on @2020
 */
public class Policy {

    private String sex;            // 性别；男、女
    private Integer age;           // 年龄
    private Boolean userSingle;    // 单身；是/否
    private Boolean userMarry;     // 结婚；是/否
    private Boolean userParenting; // 育儿；是/否

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getUserSingle() {
        return userSingle;
    }

    public void setUserSingle(Boolean userSingle) {
        this.userSingle = userSingle;
    }

    public Boolean getUserMarry() {
        return userMarry;
    }

    public void setUserMarry(Boolean userMarry) {
        this.userMarry = userMarry;
    }

    public Boolean getUserParenting() {
        return userParenting;
    }

    public void setUserParenting(Boolean userParenting) {
        this.userParenting = userParenting;
    }
}
