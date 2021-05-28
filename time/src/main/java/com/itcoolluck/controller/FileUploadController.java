package com.itcoolluck.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itcoolluck.storage.StorageFileNotFoundException;
import com.itcoolluck.storage.StorageService;

@Controller
public class FileUploadController {

	private final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}
	/*
	 * @GetMapping("/") public String listUploadedFiles(Model model) throws
	 * IOException {
	 * 
	 * model.addAttribute("files", storageService.loadAll().map( path ->
	 * MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
	 * "serveFile", path.getFileName().toString()).build().toUri().toString())
	 * .collect(Collectors.toList()));
	 * 
	 * return "uploadForm"; }
	 */
	
	@GetMapping("/i/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	
	
	@GetMapping("/1C")
	@ResponseBody
	public ResponseEntity<Resource> serveFile2() {

		Resource file = storageService.loadAsResource("1C");
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	  @RequestMapping(value="/upload", method=RequestMethod.POST)
	    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
	            @RequestParam("file") MultipartFile file){
	        if (!file.isEmpty()) {
	            try {
	            	
	            	storageService.store(file);
					/*
					 * byte[] bytes = file.getBytes(); BufferedOutputStream stream = new
					 * BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
					 * stream.write(bytes); stream.close();
					 */
	                return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
	            } catch (Exception e)	 {
	                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
	            }
	        } else {
	            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
	        }
	    }

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}