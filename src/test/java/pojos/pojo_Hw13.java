package pojos;

public class pojo_Hw13 {
    private String firstName;
    private String lastName;
    private String password;
    private Integer userStatus;
    private String phone;
    private Integer id;
    private String email;
    private String username;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setUserStatus(Integer userStatus){
        this.userStatus = userStatus;
    }

    public Integer getUserStatus(){
        return userStatus;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    @Override
    public String toString(){
        return
                "HomeWork13POJO{" +
                        "firstName = '" + firstName + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        ",password = '" + password + '\'' +
                        ",userStatus = '" + userStatus + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",id = '" + id + '\'' +
                        ",email = '" + email + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }
}
