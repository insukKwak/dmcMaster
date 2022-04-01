package com.our.project.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.our.project.core.model.ResponseCode;
import com.our.project.core.model.ResponseMessage;
import com.our.project.core.util.FileUploadUtil;
import com.our.project.service.AttachFileService;

@Controller("AttachFileController")
@RequestMapping("/file")
public class AttachFileController {

	@Autowired
	AttachFileService attachFileService;

	@Autowired
	ServletContext context;

	@Autowired
	FileUploadUtil fileUploadUtil;
	
	@RequestMapping("/example/list")
	public String fileList(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("exampleList", attachFileService.selectExampleList(params));
		return "file_example/upload";
	}
	
	
	@RequestMapping(value={"/example/upload"}, method = RequestMethod.POST , consumes ={"multipart/form-data"})
	public @ResponseBody ResponseMessage orgChartEdit(MultipartHttpServletRequest multiRequest, Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
				
		HashMap<String, Object> data = new HashMap<String, Object>();
		try {
			//upload File
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			List<HashMap<String, Object>> rsFileMap = fileUploadUtil.fileUpload(files, context.getRealPath("/") + "files", "exampleFile" + File.separator );
			
			if(rsFileMap != null && rsFileMap.size() > 0){
				List<HashMap<String, Object>>uploadedFileList = attachFileService.selectList(params);
				for(HashMap<String, Object> uploadedFile : uploadedFileList){
					uploadedFile.put("seq", uploadedFile.get("SEQ"));
					fileUploadUtil.fileDelete(uploadedFile.get("REAL_FILE_NAME").toString(), context.getRealPath("/") + "files", "exampleFile" + File.separator);
					attachFileService.delete(uploadedFile);	
				}
			}
	
			if (rsFileMap.size() > 0) {
				// 파일정보 등록
				for (HashMap<String, Object> fileMap : rsFileMap) {
					params.put("file_name", fileMap.get("file_name"));
					params.put("real_file_name", fileMap.get("real_file_name"));
					params.put("file_size", fileMap.get("file_size"));
					params.put("file_path", context.getRealPath("/") + "files" + File.separator + "exampleFile" + File.separator );

					attachFileService.insert(params);
				}
			}
	
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage("저장에 실패하였습니다.", null).setCode(ResponseCode.FAIL);
		}
		
		return new ResponseMessage("저장 되었습니다.", null).setData(data);
	} 
}
