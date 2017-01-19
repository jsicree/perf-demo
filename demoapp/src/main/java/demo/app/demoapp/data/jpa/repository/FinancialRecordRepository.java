package demo.app.demoapp.data.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.app.demoapp.data.domain.FinancialRecord;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

	@Query("select fr from INSTRUMENT_INFO fr where fr.financialInstrument.id = ?1 and fr.date = ?2") 
	public FinancialRecord findByInstrumentIdAndDate(Long instrumentId, Date date);

	@Query("select fr from INSTRUMENT_INFO fr where fr.financialInstrument.symbol IN ?1 and fr.date = ?2") 
	public List<FinancialRecord> findByInstrumentIdsAndDate(List<String> symbolList, Date date);
	
}
