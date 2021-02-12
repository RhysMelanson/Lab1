package PackAWay;

import org.springframework.context.annotation.Bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
@Entity
public class AddressBook {



    public String id;
    public BuddyInfoRepository repository;

    @OneToMany(cascade = CascadeType.ALL)
    public ArrayList<BuddyInfo> AddressBook;

    public AddressBook() {


        AddressBook = new ArrayList<BuddyInfo>();
        BuddyInfoRepository repository;

    }
    public AddressBook(String name) {
        id = name;
        AddressBook = new ArrayList<BuddyInfo>();


    }
    @Id
    public String getId(){
        return id;
    }

    public void setId(String name){
        id = name;
    }


    public void addBuddy(String name, String address, String phone){
        repository.save(new BuddyInfo(name, address, phone));
        AddressBook.add(new BuddyInfo(name, address, phone));
    }


    public void addBuddy2(BuddyInfo bud){
        repository.save(bud);
        AddressBook.add(bud);
    }

    @OneToMany(cascade = CascadeType.ALL)
    public ArrayList<BuddyInfo> getBuddies(){
        return AddressBook;
    }

    public BuddyInfo removeBuddy(int num){

        return AddressBook.remove(num);
    }

    public ArrayList<BuddyInfo> getAddressBook() {
        return AddressBook;
    }

    public String toString(){

        ArrayList<BuddyInfo> temp = AddressBook;

        String toString = "";

        while(!(temp.isEmpty())){
            BuddyInfo bud = temp.remove(0);
            toString = toString + " Contact: " + bud.getName() + " " + bud.getAddress() + " " + bud.getPhone();
        }

        return toString;
    }
}
