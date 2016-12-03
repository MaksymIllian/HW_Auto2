import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Created by User on 28.11.2016.
 */
public class Player {
    private String userName;
    private String email;
    private String lName;
    private String fName;
    private String address;
    private String city;
    private String phone;
    private String pasword;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getPasword() {
        return pasword;
    }

    public Player(){
        Random rand = new Random();
        this.address = "address" + rand.nextInt();
        this.email = "email" + rand.nextInt() + "@test.com";
        this.lName = RandomStringUtils.randomAlphabetic(7);
        this.userName = RandomStringUtils.randomAlphabetic(7);
        this.fName = RandomStringUtils.randomAlphabetic(7);
        this.city = "city" + rand.nextInt();
        this.phone = "" + rand.nextInt(9) + rand.nextInt(9) + rand.nextInt(9) + rand.nextInt(9)
                + rand.nextInt(9) + rand.nextInt(9) + rand.nextInt(9);
        this.pasword = RandomStringUtils.randomAlphabetic(7);
    }
    public Player(String userName, String email, String lName, String fName,
                  String address, String city, String phone, String pasword){
        this.address = address;
        this.email = email;
        this.lName = lName;
        this.userName = userName;
        this.fName = fName;
        this.city = city;
        this.phone = phone;
        this.pasword = pasword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (userName != null ? !userName.equals(player.userName) : player.userName != null) return false;
        if (email != null ? !email.equals(player.email) : player.email != null) return false;
        if (lName != null ? !lName.equals(player.lName) : player.lName != null) return false;
        if (fName != null ? !fName.equals(player.fName) : player.fName != null) return false;
        if (address != null ? !address.equals(player.address) : player.address != null) return false;
        if (city != null ? !city.equals(player.city) : player.city != null) return false;
        if (phone != null ? !phone.equals(player.phone) : player.phone != null) return false;
        return pasword != null ? pasword.equals(player.pasword) : player.pasword == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (pasword != null ? pasword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", pasword='" + pasword + '\'' +
                '}';
    }
}
