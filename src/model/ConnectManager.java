package model;

import java.util.List;
import java.util.Scanner;

public class ConnectManager {
    public static Scanner sc = new Scanner(System.in);
    private List<Information> informationList;
    private ReadAndWrite readAndWrite;

    public ConnectManager() {
        readAndWrite = new ReadAndWrite();
        informationList = readAndWrite.read();
    }

    public void add() {
        String id = inputId();
        String name = inputName();
        String phoneNumber = inputPhoneNumber();
        String phoneGroup = inputPhoneGroup();
        String gender = inputGender();
        String address = inputAddress();
        String dateOfBirth = inputDateOfBirth();
        String email = inputEmail();
        Information information = new Information(id, phoneNumber,phoneGroup,name,gender,address,dateOfBirth,email);
        informationList.add(information);
        readAndWrite.write(informationList);
    }

    public void edit(String id) {
        boolean isExisted = false;
        int size = informationList.size();
        for (int i = 0; i<size;i++) {
            if(informationList.get(i).getId() == id) {
                isExisted = true;
                informationList.get(i).setName(inputName());
                informationList.get(i).setPhoneNumber(inputPhoneNumber());
                informationList.get(i).setPhoneGroup(inputPhoneGroup());
                informationList.get(i).setGender(inputGender());
                informationList.get(i).setAddress(inputAddress());
                informationList.get(i).setDateOfBirth(inputDateOfBirth());
                informationList.get(i).setEmail(inputEmail());
            }
        }
        if (!isExisted) {
            System.out.println("Không tồn tại id: " + id);
        } else {
            readAndWrite.write(informationList);
        }
    }

    public void delete(String id) {
        Information information = null;
        int size = informationList.size();
        for (int i = 0; i < size; i++) {
            if(informationList.get(i).getId().equals(id)){
                information = informationList.get(i);
                break;
            }
        }
        if (information != null) {
            informationList.remove(information);
            readAndWrite.write(informationList);
        } else {
            System.out.println("Không tồn tại id: " + id);
        }
    }

    public void find (String name) {
        Information information = null;
        boolean isExisted = false;
        int size = informationList.size();
        for (int i = 0; i < size; i++){
            isExisted = true;
            if(informationList.get(i).getName().equals(name)){
                show();
            }
        }
        if (!isExisted) {
            System.out.println("Không tồn tại tên: " + name);
        } else {
            readAndWrite.write(informationList);
        }
    }

    public void readFormFile (){
        readAndWrite.read();
    }

    public void writeInFile () {
        readAndWrite.write(informationList);
    }

    public String inputName() {
        System.out.println("Nhập tên: ");
        return sc.nextLine();
    }

    public String inputPhoneNumber() {
        System.out.println("Nhập số điện thoại: ");
        return sc.nextLine();
    }

    public String inputPhoneGroup() {
        System.out.println("Nhập nhóm: ");
        return sc.nextLine();
    }

    public String inputDateOfBirth() {
        System.out.println("Nhập ngày sinh: ");
        return sc.nextLine();
    }

    public String inputEmail() {
        System.out.println("Nhập emai: ");
        return sc.nextLine();
    }

    public String inputGender() {
        System.out.println("Nhập giới tính: ");
        return sc.nextLine();
    }

    public String inputAddress() {
        System.out.println("Nhập địa chỉ: ");
        return sc.nextLine();
    }

    public String inputId() {
        System.out.println("Nhập id: ");
        return sc.nextLine();
    }

//    public void sortConnectByName() {
//        Collections.sort(informationList,new SortConnectByName());
//    }

    public void show() {
        for (Information information: informationList){
            System.out.println("Tên: " + information.getName());
            System.out.println("Số điện thoại: " + information.getPhoneNumber());
            System.out.println("Nhóm: "+ information.getPhoneGroup());
            System.out.println("Giới tính: "+ information.getGender());
            System.out.println("Ngày sinh: "+ information.getDateOfBirth());
            System.out.println("Địa chỉ: "+ information.getAddress());
            System.out.println("Email: "+ information.getEmail());
        }
    }

    public List<Information> getInformationList() {
        return informationList;
    }

    public void setInformationList(List<Information> informationList){
        this.informationList = informationList;
    }
}
