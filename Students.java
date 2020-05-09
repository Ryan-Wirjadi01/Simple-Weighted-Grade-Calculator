//----------------------------------------------------------------------------------------------------------------------
//CSE 205: 11333 T TH @ 4:30
//Assignment #6
//Ryan Wirjadi, 1216345962
//Description: This class will create the student object for the different courses
//----------------------------------------------------------------------------------------------------------------------

public class Students {
    //Declaring private variables
    private String name;

    //Constructor
    public Students(String name) {
        this.name = name;
    }

    //Getter
    public String getFullName() {
        return name;
    }

    //Setter
    public void setName(String Nname) {
        this.name = name;
    }
}
