package menu.dto;

public class FoodRecordDTO {
    private static String UserID;
    private String MenuName;

    public FoodRecordDTO(String userID, String menuName) {
        UserID = userID;
        MenuName = menuName;
    }

    public FoodRecordDTO() { }


    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    @Override
    public String toString() {
        return "FoodRecordDTO{" +
                ", UserID='" + UserID + '\'' +
                ", MenuName='" + MenuName + '\'' +
                '}';
    }
}
