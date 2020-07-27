package io.agileintelligence.ppmtool.services;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MapValidationErrorService {
    public ResponseEntity<?> mapErrorValidationService(BindingResult result){
        if(result.hasErrors()){
            Map<String,String> errorMap = result.getFieldErrors().stream().collect
                    (Collectors.toMap(error -> error.getField(), error -> error.getDefaultMessage()));
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
