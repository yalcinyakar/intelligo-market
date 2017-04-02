package com.dglproject.brand;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

/**
 * Created by Tortuvshin Byambaa on 3/3/2017.
 */

public class DglConstants {

    public static String AdminPageURL = "http://www.dglproject.com/applications/";
    public static String ProductService = "http://www.dglproject.com/applications/ProductService.php";
    public static String UserService= "https://www.dglproject.com/applications/UserService.php";
    public static String BrandService= "https://www.dglproject.com/applications/BrandService.php";

    public static String AccessKey = "12345";

    public static String DBPath = "/data/data/com.dglproject/databases/";

    private static long generateAccessKey(){
        int y = Calendar.YEAR, m = Calendar.MONTH, d = Calendar.DAY_OF_MONTH, a = 4, b = 7, c = 12;
        return (y+m+d)*a*b*c*(y*c+m*b+d*a);
    }

    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager connectivity = (ConnectivityManager) activity
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
                int count=is.read(bytes, 0, buffer_size);
                if(count==-1)
                    break;
                os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }

}
