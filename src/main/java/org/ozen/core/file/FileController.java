package org.ozen.core.file;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ozen.core.util.Constants.uploadType;
import org.ozen.core.util.FileUtil;
import org.ozen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController extends BaseController {

	@RequestMapping(value = "/receiveFile")
	public void receiveFile(@RequestParam(required = false) MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		uploadType poster = uploadType.img;
		if (type.equals("voice")) {
			poster = uploadType.voice;
		} else if (type.equals("video")) {
			poster = uploadType.video;
		} else if (type.equals("album")) {
			poster = uploadType.album;
		}
		String statusCode = SC_FAIL;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			multipartRequest = (MultipartHttpServletRequest) request;
		} catch (Exception e) {
			multipartRequest = null;
		}
		if (multipartRequest != null) {
			Map<String, MultipartFile> filemap = multipartRequest.getFileMap();
			MultipartFile file = filemap.get("uploadimg");
			if (file != null && !file.isEmpty()) {
				String filePath = FileUtil.uploadFile(file, poster);
				statusCode = SC_OK;
				resultMap.put("filePath", filePath);
			}
		}
		setJsonResult(statusCode, resultMap, response);
	}
}
