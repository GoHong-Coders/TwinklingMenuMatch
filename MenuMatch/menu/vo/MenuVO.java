package menu.vo;
import java.util.ArrayList;


public class MenuVO {
    ArrayList<MenuVO> svoList = new ArrayList<MenuVO>();

    //insert() : 메뉴 정보 객체 참조값을 ArrayList에 추가
    public void insert(MenuVO svo) {
        svoList.add(svo);
    }
    //select() : 메뉴 정보들이 저장된 ArrayList객체 참조값을 반환
    public ArrayList<MenuVO> select(){
        return svoList;
    }
}
