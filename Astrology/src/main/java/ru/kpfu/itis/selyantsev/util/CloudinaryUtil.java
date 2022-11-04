package ru.kpfu.itis.selyantsev.util;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null) {
            Map configMap = new HashMap();
            configMap.put("cloud_name", "duy2v66de");
            configMap.put("api_key", "947547119335438");
            configMap.put("api_secret", "Rc_ccGwWdfkBdFDcwXJWG7LD_58");
            cloudinary = new Cloudinary(configMap);
        }
        return cloudinary;
    }
}
