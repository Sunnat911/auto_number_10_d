package uz.pdp.avto_raqam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberDatabase;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberState;
import uz.pdp.avto_raqam.entity.region.RegionDatabase;
import uz.pdp.avto_raqam.model.response.AutoNumberResponseModel;
import uz.pdp.avto_raqam.repository.AutoNumberRepository;
import uz.pdp.avto_raqam.repository.RegionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoNumberService {

    private final AutoNumberRepository autoNumberRepository;
    private final RegionRepository regionRepository;

    @Autowired
    public AutoNumberService(AutoNumberRepository autoNumberRepository, RegionRepository regionRepository) {
        this.autoNumberRepository = autoNumberRepository;
        this.regionRepository = regionRepository;
    }

    public boolean addAutoNumber(
            AutoNumberDatabase autoNumberDatabase
    ){
        try {
            autoNumberDatabase.setStateId(AutoNumberState.FRESH.getStateId());
            autoNumberRepository.save(autoNumberDatabase);
            return true;

        }catch(Exception e) {
            return  false;
        }
    }

    public List<AutoNumberResponseModel> getAutoNumberList(){
        List<AutoNumberResponseModel> list = autoNumberRepository.findAll().stream()
                .map((autoNumberDatabase) -> {
                    AutoNumberResponseModel autoNumberResponseModel
                            = new AutoNumberResponseModel(
                                    autoNumberDatabase.getId(),
                                    autoNumberDatabase.getNumber(),
                                    autoNumberDatabase.getStateId()
                            ); // obekt olinishi bn 3 ta fieldini bervordik
                    autoNumberResponseModel.setRegionName(this.getRegionName(autoNumberDatabase.getRegionId()));
                    return autoNumberResponseModel;
                }).collect(Collectors.toList());

        return list;
    }

    private String getRegionName(int regionId){
        Optional<RegionDatabase> optionalRegionDatabase
                = regionRepository.findById(regionId);

        if (optionalRegionDatabase.isEmpty())
            return "";
        return optionalRegionDatabase.get().getName();
    }
}
