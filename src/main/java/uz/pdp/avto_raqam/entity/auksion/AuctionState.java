package uz.pdp.avto_raqam.entity.auksion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuctionState {

    IN_PROCESS(2),
    SUCCESS(0),
    ERROR(-1);

    private int stateId;
}
