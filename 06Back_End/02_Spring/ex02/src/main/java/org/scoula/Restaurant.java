package org.scoula;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor //필수 argument에 대해 Constructor 만들어 줌 (final)
public class Restaurant {
//    @Autowired
    final private Chef chef; // @RequiredArgsConstructor -> Restaurant(Chef chef) 만들어짐
}




