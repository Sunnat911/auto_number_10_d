package uz.pdp.avto_raqam.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberState;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutoNumberResponseModel {

    private int id;
    private String regionName;
    private String number;
    private int stateId;

    public AutoNumberResponseModel(int id, String number, int stateId) {
        this.id = id;
        this.number = number;
        this.stateId = stateId;
    }

    public String getState(){

        if (stateId == AutoNumberState.SUCCESS.getStateId())
            return AutoNumberState.SUCCESS.getMessage();

        if (stateId == AutoNumberState.IN_PROCESS.getStateId())
            return AutoNumberState.IN_PROCESS.getMessage();

        if (stateId == AutoNumberState.ERROR.getStateId())
            return AutoNumberState.ERROR.getMessage();

        if (stateId == AutoNumberState.FRESH.getStateId())
            return AutoNumberState.FRESH.getMessage();

        return "";

    }

}
