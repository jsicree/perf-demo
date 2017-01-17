package demo.app.demoapp.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.app.demoapp.data.domain.FinancialRecord;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

}
