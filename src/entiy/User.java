package entiy;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String brrow;
    private  String back;
    private String tel;

    public User(String name, String password,String tel) {

        this.name = name;
        this.password = password;
        this.tel = tel;
    }
    public User(String name, String password) {

        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", brrow='" + brrow + '\'' +
                ", back='" + back + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public User( String name) {
    this.name = name;
    };
    public User(){
        this.id=id;
        this.back=back;
        this.brrow=brrow;
        this.name=name;
        this.password=password;
    };

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBrrow(String brrow) {
        this.brrow = brrow;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getBrrow() {
        return brrow;
    }

    public String getBack() {
        return back;
    }

}
