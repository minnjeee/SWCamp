package co.kr.smhrd.mvc_maven_20230621.dto;

public class BoardLikesDto {
//    enum StateType{   //SPRING에서 사용
//        LIKE, ABD, BEST, SAD
//    }
    private int blNum; //pk(board_likes_bl_num_seq)
    private String state; //('LIKE','BAD','BEST','SAD')
//    private StateType state;
    private String uId; //fk (Users.u_id)
    private int bNum; //fk (Boards.b_num)

    public int getBlNum() {
        return blNum;
    }

    public void setBlNum(int blNum) {
        this.blNum = blNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getbNum() {
        return bNum;
    }

    public void setbNum(int bNum) {
        this.bNum = bNum;
    }
//uk (u_id, b_num) -> 한 사람이 한 게시물에 한 번만 좋아요 가능
}
