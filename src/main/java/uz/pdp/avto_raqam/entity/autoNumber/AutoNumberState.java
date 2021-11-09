package uz.pdp.avto_raqam.entity.autoNumber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AutoNumberState {

    FRESH(1,"hali aksionga qo'yilmagan"),
    IN_PROCESS(2,"aksion davom etmoqda"),
    SUCCESS(0,"sotildi"),
    ERROR(-1,"sotilmadi");

    private int stateId;
    private String message;
}
