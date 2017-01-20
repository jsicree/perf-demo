package demo.app.demoapp.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.app.demoapp.data.domain.FinancialInstrument;

@Repository
public interface FinancialInstrumentRepository extends JpaRepository<FinancialInstrument, Long> {
	
	public List<FinancialInstrument> findBySymbolIn(List<String> symbols);
	
}
