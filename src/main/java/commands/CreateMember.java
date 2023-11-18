package commands;

import com.darkurfu.teambot.datamodels.UserData;

public class CreateMember {

    public static UserData update(String text, UserData userData) {
        switch(userData.getCount()) {
            case(0): {
                userData.setName(text);
                break;
            }

            case(1): {
                userData.setAge(text);
                break;
            }

            case(2): {
                userData.setCity(text);
                break;
            }

            case(3): {
                userData.setDescription(text);
                break;
            }
        }

        userData.countUpdate();
        return userData;
    }
}
