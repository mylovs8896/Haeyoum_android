package com.haeyoum.tje.haeyoum;

public class Mem {

    private String member_id;
    private String member_password;
    private String member_password_check;
    private String member_name;
    private String member_nick_name;
    private String member_email;
    private String member_birthday;

    public String toServer(){
        String data = null;
        if(member_id != null || member_password != null || member_name != null || member_nick_name != null || member_email != null || member_birthday != null) {
            data = String.format(
                    "member_id=%s" +
                            "&member_password=%s" +
                            "&member_name=%s" +
                            "&member_nick_name=%s" +
                            "&member_email=%s" +
                            "&member_birthday=%s",
                    member_id, member_password, member_name, member_nick_name, member_email, member_birthday);
        }
        return data;
    }

    public String getMember_id() {
        return member_id;
    }
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    public String getMember_password() {
        return member_password;
    }
    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }
    public String getMember_password_check() {
        return member_password_check;
    }
    public void setMember_password_check(String member_password_check) {
        this.member_password_check = member_password_check;
    }
    public String getMember_name() {
        return member_name;
    }
    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
    public String getMember_nick_name() {
        return member_nick_name;
    }
    public void setMember_nick_name(String member_nickname) {
        this.member_nick_name = member_nickname;
    }
    public String getMember_email() {
        return member_email;
    }
    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }
    public String getMember_birthday() {
        return member_birthday;
    }
    public void setMember_birthday(String member_birthday) {
        this.member_birthday = member_birthday;
    }

}
