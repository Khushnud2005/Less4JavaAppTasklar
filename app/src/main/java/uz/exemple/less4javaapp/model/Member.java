package uz.exemple.less4javaapp.model;

import java.io.Serializable;

public class Member implements Serializable {
    private int member_id;
    private String member_name;

    public Member(int member_id,String member_name){
        this.member_id = member_id;
        this.member_name = member_name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", member_name='" + member_name + '\'' +
                '}';
    }
}
