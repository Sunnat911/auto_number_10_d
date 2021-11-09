package uz.pdp.avto_raqam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avto_raqam.entity.auksion.AuctionDatabase;

import java.util.List;

public interface AuctionRepository extends JpaRepository<AuctionDatabase,Integer> {

    List<AuctionDatabase> findAllByStateId(int stateId);
}
