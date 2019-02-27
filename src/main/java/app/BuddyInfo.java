package app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Integer Id = null;
    @NotNull
    @Size(min = 1, max = 40)
    private String name;
    @NotNull
    @Size(min = 1, max = 10)
    private String prefix;
    @NotNull
    @Size(min = 1, max = 50)
    private String address;
    @NotNull
    @Size(min = 1, max = 14)
    private String phoneNumber;
    @NotNull
    @Size(min = 1, max = 20)
    private String greeting;
    @NotNull
    @Min(1)
    @Max(150)
    private int age;

    public BuddyInfo(String name, String prefix, String address, String phoneNumber, String greeting, int age) {
        super();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.prefix = prefix;
        this.greeting = greeting;
        this.age = age;
    }

    public BuddyInfo(String name, String address, String phoneNumber, int age) { this(name, "", address, phoneNumber, "", age); }

    public BuddyInfo() {
        this("Miles Davis", "Mr.", "444-444-444", "123 Green Dolphin Street", "*jazz*", 65);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age > 0 ? age : this.age;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public boolean isOver18() {
        return age > 18;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!BuddyInfo.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final BuddyInfo other = (BuddyInfo) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }

        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)) {
            return false;
        }

        if ((this.phoneNumber == null) ? (other.phoneNumber != null) : !this.phoneNumber.equals(other.phoneNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return prefix + ", " + name + ", " + address + ", " + phoneNumber;
    }
}
