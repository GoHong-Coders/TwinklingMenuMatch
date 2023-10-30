package menu.dto;

public class DeleteRecordDTO {
    private String UserId;
    private String MenuName;

    public DeleteRecordDTO() {}

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }
}
