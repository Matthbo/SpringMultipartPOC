package org.frankframework.poc.springmultipartpoc.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class MultipartBody {
    private String name;
    private MultipartFile file;
}
