package demo.app.demoapp.data.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.app.demoapp.data.domain.FinancialRecord;

/**
 * A <code>JpaRepository</code> for <code>FinancialRecord</code>.
 * 
 * @author joseph_sicree
 *
 */
@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

	/**
	 * Look up a <code>FinancialRecord</code> by instrument id and date
	 * 
	 * @param instrumentId
	 * @param date
	 * 
	 * @return A <code>FinancialRecord</code>
	 */
	@Query("select fr from INSTRUMENT_INFO fr where fr.financialInstrument.id = ?1 and fr.date = ?2") 
	public FinancialRecord findByInstrumentIdAndDate(Long instrumentId, Date date);

	/**
	 * Look up multiple <code>FinancialRecord</code> by instrument ids and date
	 * 
	 * @param symbolList
	 * @param date
	 * 
	 * @return A <code>List</code> of <code>FinancialRecord</code>
	 */
	@Query("select fr from INSTRUMENT_INFO fr where fr.financialInstrument.symbol IN ?1 and fr.date = ?2") 
	public List<FinancialRecord> findByInstrumentIdsAndDate(List<String> symbolList, Date date);
	
}
