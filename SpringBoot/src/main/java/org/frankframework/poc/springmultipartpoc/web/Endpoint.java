package org.frankframework.poc.springmultipartpoc.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;
import java.text.MessageFormat;

@RestController
public class Endpoint {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello Custom Enjoyer!");
    }

    @PostMapping(
            value = "/test",
            consumes = "multipart/form-data",
            produces = "text/plain"
    )
    public ResponseEntity<String> getFileName(MultipartBody multipartBody) {
        String userName = multipartBody.getName();
        String fileNameOrPath = multipartBody.getFile().getOriginalFilename();
        String fileName = null;
        if (fileNameOrPath != null) {
            fileName = Paths.get(fileNameOrPath).getFileName().toString();
        }
        return ResponseEntity.ok(MessageFormat.format("User {0} uploaded file \"{1}\"", userName, fileName));
    }

}
