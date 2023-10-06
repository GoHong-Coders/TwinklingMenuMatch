package menu.dto;

public class DinnerDTO {
    private int MenuID;
    private String MenuName;
    private String Description;

    public DinnerDTO(int menuID, String menuName, String description) {
        MenuID = menuID;
        MenuName = menuName;
        Description = description;
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int menuID) {
        MenuID = menuID;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "DinnerDTO{" +
                "MenuID=" + MenuID +
                ", MenuName='" + MenuName + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
