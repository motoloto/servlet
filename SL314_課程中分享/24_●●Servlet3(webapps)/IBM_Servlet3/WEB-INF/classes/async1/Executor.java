package async1;

import java.io.*;
import java.util.*;
import javax.servlet.*;

public class Executor implements Runnable {
    
    private AsyncContext ctx = null;
    
    public Executor(AsyncContext ctx){
        this.ctx = ctx;
    }

    public void run(){
        try {
            //等待5秒鐘，以模擬業務之執行
            Thread.sleep(5*1000);
            PrintWriter out = ctx.getResponse().getWriter();
            out.println("<font color=red>");
            out.println("<br>業務處理完畢的時間:" + new Date() + ".");
            out.println("</font>");
            out.flush();
            ctx.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
