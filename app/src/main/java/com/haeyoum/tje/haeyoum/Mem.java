package com.haeyoum.tje.haeyoum;

public class Mem {

    private String m_password;
    private String m_name;
    private String m_email;

    public String toServer() {
        String data = null;
        if (m_password != null || m_name != null || m_email != null) {
            data = String.format(
                    "m_password=%s" +
                            "&m_name=%s" +
                            "&m_email=%s",
                            m_password, m_name, m_email);
        }
        return data;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }
}
