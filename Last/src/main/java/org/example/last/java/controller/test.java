
package org.example.last.java.controller;
import org.example.last.java.entity.*;
import org.example.last.java.service.impl.AdminServiceimpl;
import org.example.last.java.service.impl.EmployeeServiceImpl;
import org.example.last.java.service.impl.SportServiceimpl;
import org.example.last.java.service.impl.UserBookMessageimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("api")

public class test {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    SportServiceimpl sportServiceimpl;
    @Autowired
    UserBookMessageimpl userBookMessageimpl;
    @Autowired
    AdminServiceimpl adminServiceimpl;
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/userInfo")
    public int login(@RequestBody Employee employeeDTO) {
        String password = employeeDTO.getPassword();
        String username = employeeDTO.getUsername();
        System.out.println(employeeDTO);
        Employee employee = employeeService.login(employeeDTO);
        if (employee == null) {
            return 0;
        }
        if(employee.getPassword().equals(password)){
            return 1;
        }
        return 0;
    }
    @PostMapping("/userInfo/ppq")
    public List<SportDto> getsport(){
        System.out.println("success");
        List<SportDto> ljs=new ArrayList<>();
        ljs=sportServiceimpl.SelectAllppq();
        return ljs;
    }
    @PostMapping("/userInfo/ymq")
    public List<SportDto> getsport1(){
        System.out.println("success");
        List<SportDto> ljs=new ArrayList<>();
        ljs=sportServiceimpl.SelectAllymq();
        return ljs;
    }
    @PostMapping("/userInfo/wq")
    public List<SportDto> getsport2(){
        System.out.println("success");
        List<SportDto> ljs=new ArrayList<>();
        ljs=sportServiceimpl.SelectAllwq();
        return ljs;
    }

    @PostMapping("/userInfo/book")
    public int UpdateSport(@RequestBody UpdateMessage updateMessage){
        System.out.println(updateMessage);
        int flag=0;
        int time= updateMessage.getTime();
        int id=updateMessage.getId();
        if(updateMessage.getIsBook()){
            if(updateMessage.getType().equals("羽毛球")) {
                flag = sportServiceimpl.UpdateSportymq(id, time);
                Message message = new Message(updateMessage);
                userBookMessageimpl.UpdateMessage(message);
                return flag;
            }
            if(updateMessage.getType().equals("乒乓球")) {
                flag = sportServiceimpl.UpdateSportppq(id, time);
                Message message = new Message(updateMessage);
                userBookMessageimpl.UpdateMessage(message);
                return flag;
            }
            if(updateMessage.getType().equals("网球")) {
                flag = sportServiceimpl.UpdateSportwq(id, time);
                Message message = new Message(updateMessage);
                userBookMessageimpl.UpdateMessage(message);
                return flag;
            }

        }else{
            if(updateMessage.getType().equals("羽毛球")) {
                flag = sportServiceimpl.CancleUpdateSportymq(id, time);
                Message message = new Message(updateMessage);
                userBookMessageimpl.CancleUpdateMessage(message);
                return flag;
            }
            if(updateMessage.getType().equals("乒乓球")) {
                flag = sportServiceimpl.CancleUpdateSportppq(id, time);
                Message message = new Message(updateMessage);
                userBookMessageimpl.CancleUpdateMessage(message);
                return flag;
            }
            if(updateMessage.getType().equals("网球")) {
                flag = sportServiceimpl.CancleUpdateSportwq(id, time);
                Message message = new Message(updateMessage);
                userBookMessageimpl.CancleUpdateMessage(message);
                return flag;
            }
        }
        return 0;
    }
    @PostMapping("/adminInfo")
    public int Adminlogin(@RequestBody Admin admin){
        System.out.println(admin.adminName+"登陆成功");
        String id=admin.getAdminName();
        String password = admin.getAdminPassword();
        Admin admin1=adminServiceimpl.login(id);
        if(password.equals(admin1.getAdminPassword())){
            return 1;
        }else{
            return 0;
        }
    }
    @PostMapping("/admin/sport")
    public List<MessageDto> MessageSelect(@RequestBody UserMessageId userMessageId){
        List<MessageDto> ljs=userBookMessageimpl.AdminSelectUser(userMessageId);
        return ljs;
    }
    @PostMapping("/admin/delete")
    public int deleteDateMessage(){
        userBookMessageimpl.deleteDataMessage();
        return 1;
    }
}
