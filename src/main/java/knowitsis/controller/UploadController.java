package knowitsis.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import knowitsis.model.GradesModel;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@Autowired
	StartPageController startPage;
	
	@RequestMapping(value="/upload")
    public String singleUpload(){
    	return "upload";
    }
    @RequestMapping(value="/save", method=RequestMethod.POST )
    public @ResponseBody String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc ){
    	System.out.println("File Description:"+desc);
    	String fileName = null;
    	if (!file.isEmpty()) {
            try {
            	GradesModel model = startPage.getGradesModel();
            	model.setInputGrades(getDoc(multipartToFile(file)));
            	fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = 
                        new BufferedOutputStream(new FileOutputStream(new File("F:/cp/" + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }

	private Document getDoc(File inputFile) {
		SAXBuilder saxBuilder = new SAXBuilder();
		// converted file to document
		Document docResponse = null;
		try {
			docResponse = saxBuilder.build(inputFile);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return docResponse;
	}

	private File multipartToFile(MultipartFile multipart)
			throws IllegalStateException, IOException {
		File tmpFile = new File(System.getProperty("java.io.tmpdir")
							+ System.getProperty("file.separator")
							+ multipart.getOriginalFilename());
		multipart.transferTo(tmpFile);
		return tmpFile;
	}
}
