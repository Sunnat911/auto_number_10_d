package uz.pdp.avto_raqam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.avto_raqam.entity.region.RegionDatabase;

@Repository
public interface RegionRepository extends JpaRepository<RegionDatabase,Integer> {

}
