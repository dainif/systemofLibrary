package entiy;

public class Admin {
    private Integer id;
    private String name;
    private String password;
    private  Integer tel;

    public Admin(Integer id, String name, String password, Integer tel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tel = tel;
    }
    public Admin( String name, String password, Integer tel) {
        this.name = name;
        this.password = password;
        this.tel = tel;
    }

    public Admin(Integer id) {
        this.id = id;
    }
    public Admin( String name, String password) {
        this.name = name;
        this.password = password;

    }
    public Admin( String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tel=" + tel +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
