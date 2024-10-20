package com.example.prac02_1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import java.util.ArrayList;

public class StaffViewModel extends ViewModel {
    private final MutableLiveData<List<Staff>> staffList;
    private final MutableLiveData<String> message = new MutableLiveData<>();
    private List<Staff> currentList;
    private StaffAdapter staffAdapter;
    private boolean isFirstAdd = true; // Biến theo dõi lần thêm đầu tiên



    public StaffViewModel() {

        staffList = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        currentList = new ArrayList<>();
        currentList.add(new Staff("No Result!","","",""));
        staffList.setValue(currentList);
    }

    public MutableLiveData<List<Staff>> getStaffList() {
        return staffList;
    }

    public MutableLiveData<String> message(){
        return message;
    }

    public void  addStaff(Staff staff){
        currentList = staffList.getValue();
        if(currentList != null) {
            if (isFirstAdd) {
                // Xóa item khởi tạo nếu đây là lần thêm đầu tiên
                currentList.remove(0); // Xóa phần tử đầu tiên
                isFirstAdd = false; // Đánh dấu là đã thêm lần đầu tiên
            }
            currentList.add(staff);
            staffList.setValue(currentList);
            // Kiểm tra số lượng nhân viên
            if (currentList.size() >= 4) {
                message.setValue("Đã thêm được vài nhân viên");
            } else {
                message.setValue("Sau khi bấm nút thêm");
            }
        }
    }

    public void checkInput(String id, String name, String bd, String salary){
        if(id.isEmpty() && name.isEmpty() && bd.isEmpty() && salary.isEmpty())
            message.setValue("Chua nhap du lieu");
        else if(id.isEmpty() || name.isEmpty() || bd.isEmpty() || salary.isEmpty()){
            message.setValue("Chua nhap het du lieu");
        }
        else message.setValue(("Nhap du lieu nhung chua an nut them"));
    }


}
