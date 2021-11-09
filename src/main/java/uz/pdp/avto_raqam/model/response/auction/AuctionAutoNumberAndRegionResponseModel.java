package uz.pdp.avto_raqam.model.response.auction;

import lombok.Data;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberDatabase;
import uz.pdp.avto_raqam.entity.region.RegionDatabase;

import java.util.List;

@Data
public class AuctionAutoNumberAndRegionResponseModel {
    private List<RegionDatabase> regionDatabaseList;
    private List<AutoNumberDatabase> autoNumberDatabaseList;
}
