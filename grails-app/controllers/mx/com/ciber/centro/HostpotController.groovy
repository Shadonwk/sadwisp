package mx.com.ciber.centro


import me.legrange.mikrotik.MikrotikApiException;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.ResultListener;
import me.legrange.mikrotik.*;
import java.io.*;

class HostpotController {

    def sshConfig

    def index() {
        List<Map<String, String>> rs
        try{



            ApiConnection con = ApiConnection.connect("192.168.0.118"); // connect to router
            con.login("admin","leon99"); // log in to router
            //con.execute("/system/reboot"); // execute a command
            rs = con.execute("/ip/hotspot/user/print");
            for (Map<String,String> r : rs) {
                System.out.println(r.get("name"));
            }
            con.disconnect(); // disconnect from router

        }catch(Exception  e){
                System.out.println(e);
            }
        [usuarios:rs]
    }
}
