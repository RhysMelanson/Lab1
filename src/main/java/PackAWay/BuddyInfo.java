package PackAWay;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BuddyInfo {

    @Id
    public String fullname;
    public String address;
    public String phone;



    public BuddyInfo(){

    }

    public BuddyInfo(String fullname, String address, String phone) {

        this.fullname = fullname;
        this.address = address;
        this.phone = phone;

    }
    @Id
    public String getName(){
        return fullname;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public void setName(String t){
        fullname = t;
    }

    public void setAddress(String t){
        address = t;
    }

    public void setPhone(String t){
        phone = t;
    }

    public String toString(){

        return "Name: " + fullname + ", Address: " + address + ", Phone#: " + phone;
    }
}
