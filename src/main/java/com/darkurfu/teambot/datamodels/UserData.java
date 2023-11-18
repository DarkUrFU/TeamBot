package com.darkurfu.teambot.datamodels;

import lombok.Getter;

public class UserData extends CommandData {
    private String name;
    private String age;
    private String city;
    private String description;
    private Long userID;
    private Integer count;

    public String chat() {
        switch(count) {
            case(0): {
                return "Как Вас зовут?";
            }
            case(1): {
                return "Сколько Вам лет?";
            }
            case(2): {
                return "Укажите Ваш город.";
            }
            case(3): {
                return "Укажите Вашу профессию, навыки или иную информацию для других людей";
            }
        }
        return null;
    }

    @Override
    public Integer getCommandType() {
        return 1;
    }

    public UserData(long userID) {
        this.userID = userID;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getCount() {
        return count;
    }

    public void countUpdate() {
        this.count++;
    }
}

