package demo.app.demoapp.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.app.demoapp.data.domain.FinancialInstrument;

/**
 * A <code>JpaRepository</code> for <code>FinancialInstrument</code>.
 * 
 * @author joseph_sicree
 *
 */
@Repository
public interface FinancialInstrumentRepository extends JpaRepository<FinancialInstrument, Long> {
	
	/**
	 * Fetch a list of <code>FinancialInstrument</code> objects by symbol.
	 * 
	 * @param symbols
	 * 
	 * @return A <code>List<code> of <code>FinancialInstrument</code> objects
	 */
	public List<FinancialInstrument> findBySymbolIn(List<String> symbols);
	
}
