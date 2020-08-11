package model;

public class SortConnectByName {
    public int compare(Information information1, Information information2){
        return information1.getName().compareTo(information2.getName());
    }
}
