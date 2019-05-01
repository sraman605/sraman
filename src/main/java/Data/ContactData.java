package Data;

public class ContactData {
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneno=" + phoneno +
                ", mobno=" + mobno +
                ", userid=" + userid +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(Long phoneno) {
        this.phoneno = phoneno;
    }

    public Long getMobno() {
        return mobno;
    }

    public void setMobno(Long mobno) {
        this.mobno = mobno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private int id;
    private String name;
    private String email;
    private String address;
    private Long phoneno;
    private Long mobno;
  private int userid;

}
