package tw.blackcat.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FileUploadAjaxController {
	@PostMapping("/upload.controller")
	public String processUploadAction(@RequestParam("myfile") MultipartFile mf) throws IllegalStateException, IOException {
		String filename = mf.getOriginalFilename();
		System.out.println("fileName"+filename);
		
		String saveDirPath = "c:/temp/upload/";
		File saveFileDir = new File(saveDirPath,filename);
		mf.transferTo(saveFileDir);
		return "saveFileDir"+saveFileDir;
	}
	

}
