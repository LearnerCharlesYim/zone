package com.charles.zone.controller;


import com.charles.zone.controller.ex.FileEmptyException;
import com.charles.zone.utils.IDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ueditor")
public class UeditorController extends BaseController{

    @RequestMapping("/config")
    public String uploadConfig(String action) {
        if(action.equals("config")){
            return "forward:/ueditor/getConfig";

        }else{
            return "forward:/ueditor/upload";
        }
    }

    @RequestMapping("/getConfig")
    @ResponseBody
    public String getConfig() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/config.json"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line=br.readLine())!=null){
            sb.append(line);
        }
        return sb.toString();
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,String> uploadFile(MultipartFile upfile) throws IOException {
        if(upfile == null){
            throw new FileEmptyException("文件空指针异常");
        }
        String oldName = upfile.getOriginalFilename();
        String newName = IDUtil.getImageName();
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        newName += oldName.substring(oldName.lastIndexOf("."));

        File dest = new File(new File("src\\main\\resources\\static\\upload\\").getAbsolutePath() + "\\" + datePath);
        if(!dest.exists()){
            dest.mkdirs();
        }
        File file = new File(dest, newName);
        upfile.transferTo(file);

        Map<String,String> result = new HashMap<>();
        result.put("state","SUCCESS");
        result.put("url","/upload/"+datePath+"/"+newName);
        result.put("title",newName);
        result.put("original",newName);
        return result;
    }

}
