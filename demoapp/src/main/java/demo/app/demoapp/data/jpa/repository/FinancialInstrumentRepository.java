package demo.app.demoapp.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.app.demoapp.data.domain.FinancialInstrument;

@Repository
public interface FinancialInstrumentRepository extends JpaRepository<FinancialInstrument, Long> {

}
