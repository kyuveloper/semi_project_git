//package com.semiproject.pettales.inquiry.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.UUID;
//
//@Controller
//public class FileuploadController {
//
//    @Autowired
//    private ResourceLoader resourceLoader;
//
//    @PostMapping("single-file")
//    public String singleFileUpload(@RequestParam MultipartFile singleFile, String singleFileDescription, Model model) throws IOException {
//        System.out.println("singleFile : " + singleFile);
//        System.out.println("singleFileDescription : " + singleFileDescription);
//
//        /* 인텔리제이에서 root 폴더를 지정하고 filePath에서 경로를 다르게 잡아서 절대경로로 변경 */
////        String root = "c:/upload-files";
////        String filePath = root + "/single";
//
//        /* 파일을 저장할 경로 설정 */
//        Resource resource = resourceLoader.getResource("classpath:static/img/single");
//        String filePath = null;
//
//        if (!resource.exists()) {
//            /* 만약 static 폴더에 파일이 없는 경우 만들어준다
//            *  초기 해당 디렉토리가 없는 경우 서버 리로드해야 한다.
//            *  spring에서 resources를 읽어와야 하는데 해당 경로가 없어 이미지를 초기에 보여줄 수 없는 상황이다.*/
//            String root = "src/main/resources/static/img/single";
//            File file = new File(root);
//            file.mkdirs();
//
//            filePath = file.getAbsolutePath();
//        } else {
//            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();
//        }
//
//        /* 파일명 변경 */
//        String originFileName = singleFile.getOriginalFilename();
//        System.out.println("originFileName : " + originFileName);
//        String ext = originFileName.substring(originFileName.lastIndexOf("."));
//        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
//        System.out.println("savedName : " + savedName);
//
//        /* 파일을 저장 */
//        try {
//            singleFile.transferTo(new File(filePath + "/" + savedName));
//            model.addAttribute("message", "파일 업로드 성공");
//            model.addAttribute("img", "static/img/single/"+savedName);
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("message", "파일 업로드 실패");
//        }
//
//        return "inquiry/imgResult";
//    }
//}
